package com.ai.baas.bmc.business.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchParam;
import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.business.interfaces.IFeeReBatchBusi;
import com.ai.baas.bmc.business.interfaces.IReBillingBussiness;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.dao.interfaces.BmcRecordFmtMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmtCriteria;
import com.ai.baas.bmc.util.MDSUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.HBasePager;
import com.ai.opt.base.vo.ResponseHeader;

@Service
public class FeeReBatchBusiImpl implements IFeeReBatchBusi {
	
	@Autowired
	private IReBillingBussiness iReBillingBussiness;

	@Override
	public List<FeeParam> queryFeeReBatch(FeeReBatchCriteria criteria) throws IOException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Table table = MyHbaseUtil.getTable(this.buildTableName(criteria));
		FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
		if (criteria.getTenantId() != null && criteria.getTenantId().length() > 0) {
            Filter filter = new SingleColumnValueFilter("detail_bill".getBytes(), "tenant_id".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getTenantId().getBytes()));
            filterList.addFilter(filter);
        }
        if (criteria.getServiceId() != null && criteria.getServiceId().length() > 0) {
            Filter filter = new SingleColumnValueFilter("detail_bill".getBytes(), "service_id".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getServiceId().getBytes()));
            filterList.addFilter(filter);
        }
        if (criteria.getServiceType() != null && criteria.getServiceType().length() > 0) {
            Filter filter = new SingleColumnValueFilter("detail_bill".getBytes(), "service_type".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getServiceType().getBytes()));
            filterList.addFilter(filter);
        }
        if (criteria.getAccountPeriod() != null && criteria.getAccountPeriod().length() > 0) {
            Filter filter = new SingleColumnValueFilter("detail_bill".getBytes(), "account_period".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new RegexStringComparator(criteria.getAccountPeriod().substring(0, 6)+"*"));
            filterList.addFilter(filter);
        }
       
        Scan scan = new Scan();
        Filter countFilter=new PageFilter(1000);
        filterList.addFilter(countFilter);
        scan.setFilter(filterList);
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> resultIterator = resultScanner.iterator();
        List<FeeParam> resultFeeParams = new ArrayList<FeeParam>();
        while (resultIterator.hasNext()) {
            Result result = resultIterator.next();
            FeeParam feeParam = getFeeParam(result);
            resultFeeParams.add(feeParam);
        }
        return resultFeeParams;
	}

	@Override
	public void batchResendFee(FeeReBatchParam param) throws IOException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		FeeReBatchCriteria criteria = param.getCriteria();
		
		ReBillingParam billParam = new ReBillingParam();
		billParam.setBusiType(criteria.getServiceType());
		billParam.setReBillingType(criteria.getReBatchType());
		billParam.setServiceId(criteria.getServiceId());
		billParam.setTenantId(criteria.getTenantId());
		Long success = iReBillingBussiness.reBilling(billParam);
	}
	
	private void cleanDuplicateData(String tabName, String rowKey) throws IOException {
        Table duplicateionBill = MyHbaseUtil.getTable(tabName);
        Delete duplicateDelete = new Delete(rowKey.getBytes());
        duplicateionBill.delete(duplicateDelete);
    }

    private String buildDuplicateBillTableName(FeeReBatchCriteria criteria) {
        return criteria.getTenantId() + "_" + criteria.getServiceType() + "_dup_" 
        		+ criteria.getAccountPeriod().substring(0, 6);
    }
	
	private String buildTableName(FeeReBatchCriteria criteria){
		return criteria.getTenantId()+"_"+criteria.getServiceType()+
				"_DR_"+criteria.getAccountPeriod().substring(0, 6);
	}

	private FeeParam getFeeParam(Result result) throws IllegalArgumentException, IllegalAccessException{
		FeeParam param = new FeeParam();
		Class paramClass = param.getClass();
		Field[] fs = paramClass.getDeclaredFields();
		Map<String, String> attMaps = param.getCommonAttrMap();
		Set<String> keySet = attMaps.keySet();
		Collection<String> valueSet = attMaps.values();
		param.setRowKey(new String(result.getRow()));
		//设置公共属性
		for(Field f:fs){
			if(keySet.contains(f.getName()) && f.getType().toString().endsWith("String")){
				f.setAccessible(true);
				f.set(param, this.getAttrValue(result, attMaps.get(f.getName())));
			}
		}
		//设置map属性
		Map<String, String> feePacket = new HashMap<String, String>();
		for(KeyValue keyValue:result.raw()){
			if(!valueSet.contains(Bytes.toString(keyValue.getQualifier()))){
				feePacket.put(Bytes.toString(keyValue.getQualifier()), new String(keyValue.getValue()));
			}
		}
		param.setFeePacket(feePacket);
		return param;
	}
	
	private String getAttrValue(Result result, String attrName) {
        Cell cell;
        cell = result.getColumnLatestCell("detail_bill".getBytes(), attrName.getBytes());
        if (cell != null) {
            return Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
        }
        return null;
    }
	
	private void cleanFeeData(FeeParam param, String tableName) throws IOException {
        Table duplicateionBill = MyHbaseUtil.getTable(tableName);
        Delete duplicateDelete = new Delete(param.getRowKey().getBytes());
        duplicateionBill.delete(duplicateDelete);
    }
	
	private String generateMessage(FeeParam feeParam) {
	        StringBuilder stringBuilder = new StringBuilder();

	        stringBuilder.append(feeParam.getTenantId() + "\1");
	        stringBuilder.append(feeParam.getServiceId() + "\1");
	        stringBuilder.append(feeParam.getServiceType() + "\1");
	        stringBuilder.append(feeParam.getSource() + "\1");
	        stringBuilder.append(feeParam.getBsn() + "\1");
	        stringBuilder.append(feeParam.getSn() + "\1");
	        stringBuilder.append(feeParam.getAccountPeriod() + "\1");
	        
	        Map<String, String> map = feeParam.getFeePacket();
	        if(map!=null){
	        	 for (Map.Entry<String, String> entry : map.entrySet()) {
	        		 stringBuilder.append(entry.getValue() + "\1");
	        	  }
	        }

	        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
	    }
}
