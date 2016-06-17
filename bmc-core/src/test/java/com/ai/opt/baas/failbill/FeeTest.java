package com.ai.opt.baas.failbill;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.failedbillmaintain.interfaces.IFailedBillMaintainSV;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillPagerResponse;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.baas.bmc.api.feeReBatch.interfaces.IFeeReBatchSV;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParamPagerResponse;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchParam;
import com.ai.opt.base.vo.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.sf.json.JSONArray;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class FeeTest {
	 @Autowired
	 IFeeReBatchSV feeReBatchSV;
	 
    public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
	public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
	 
	 @Test
	    public void queryTest2(){
		    FeeReBatchCriteria queryInfo = new FeeReBatchCriteria();
//	    	queryInfo.setTenantId("VIV-BYD");
//	    	queryInfo.setServiceType("VOICE");
//	    	queryInfo.setAccountPeriod("2016051212");
	    	
	    	String str = "{\"serviceType\":\"VOICE\",\"tenantPwd\":\"\",\"pager\":null,\"tenantId\":\"VIV-BYD\",\"accountPeriod\":\"201605\",\"serviceId\":\"\",\"reBatchType\":\"\"}";
	    	queryInfo = JSONObject.parseObject(str, queryInfo.getClass());
//	    	queryInfo.setErrorCode();
	    	JSONArray.fromObject(queryInfo);
	    	FeeParamPagerResponse list = feeReBatchSV.queryFeeReBatch(queryInfo);
	    	System.out.println("标准资费查询出参:"+JSON.toJSONString(list));  
	    }
	 
	 @Test
	    public void testReBatch(){
		  	FeeReBatchParam param = new FeeReBatchParam();
		    FeeReBatchCriteria queryInfo = new FeeReBatchCriteria();
	    	queryInfo.setTenantId("VIV-BYD");
	    	queryInfo.setServiceType("GPRS");
	    	queryInfo.setAccountPeriod("2016051212");
	    	queryInfo.setReBatchType("test");
	    	queryInfo.setServiceId("iccid1219");
	    	param.setCriteria(queryInfo);
	    	JSONArray.fromObject(param);
	    	BaseResponse response = feeReBatchSV.batchResendFee(param);
	    	System.out.println("标准资费查询出参:"+JSON.toJSONString(response));
	    }
	 
	//详单数据添加
	 @Test
		public void addTRData(){
			
			StringBuilder sb = new StringBuilder();
			sb.append("VIV-BYD").append(FIELD_SPLIT);
			sb.append("iccid1150").append(FIELD_SPLIT);
			sb.append("GPRS").append(FIELD_SPLIT);
			sb.append("1456281622845").append(FIELD_SPLIT);
			sb.append("1459440000000");
			String rowkey1=sb.toString();
			
			
			
			
			Connection conn = HBaseProxy.getConnection();
			byte[] rowKey = rowkey1.getBytes();
			Table table = null;
			try {
				table = conn.getTable(TableName
						.valueOf("VIV-BYD_VOICE_DR_201605"));

				Put put = new Put(rowKey);
				
			
				//添加各个列族里面的数据
				put.addColumn("detail_bill".getBytes(), "account_period".getBytes(), "2016061212".getBytes());
				put.addColumn("detail_bill".getBytes(), "tenant_id".getBytes(), "VIV-BYD".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_id".getBytes(), "iccid1150".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_type".getBytes(), "VOICE".getBytes());
				put.addColumn("detail_bill".getBytes(), "bsn".getBytes(), "1459440000000".getBytes());
				put.addColumn("detail_bill".getBytes(), "duration".getBytes(), "14562816".getBytes());
				put.addColumn("detail_bill".getBytes(), "custNo".getBytes(), "123123".getBytes());
				put.addColumn("detail_bill".getBytes(), "userNo".getBytes(), "123".getBytes());
				put.addColumn("detail_bill".getBytes(), "call_number".getBytes(), "321".getBytes());
				put.addColumn("detail_bill".getBytes(), "called_number".getBytes(), "122".getBytes());
				put.addColumn("detail_bill".getBytes(), "start_time".getBytes(), "2016051212".getBytes());
				put.addColumn("detail_bill".getBytes(), "fee".getBytes(), "12333".getBytes());
				put.addColumn("detail_bill".getBytes(), "product_id".getBytes(), "xxxx".getBytes());
				put.addColumn("detail_bill".getBytes(), "sn".getBytes(), "1456281622845".getBytes());
				put.addColumn("detail_bill".getBytes(), "source".getBytes(), "STREAM".getBytes());
				put.addColumn("detail_bill".getBytes(), "call_type".getBytes(), "被叫".getBytes());
				put.addColumn("detail_bill".getBytes(), "opp_number".getBytes(), "13523411234".getBytes());
				put.addColumn("detail_bill".getBytes(), "visit_area".getBytes(), "北京12".getBytes());
				put.addColumn("detail_bill".getBytes(), "long_type".getBytes(), "local".getBytes());
				put.addColumn("detail_bill".getBytes(), "call_duration".getBytes(), "test2".getBytes());
				put.addColumn("detail_bill".getBytes(), "total_flow".getBytes(), "00001".getBytes());
//				String data = getData();
//				put.addColumn("detail".getBytes(), "record".getBytes(), data.getBytes());
				table.put(put);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (table != null) {
					try {
						table.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	 
	 @Test
		public void addDRData(){
			
			StringBuilder sb = new StringBuilder();
			sb.append("iccid1219").append(FIELD_SPLIT);
			sb.append("s1219").append(FIELD_SPLIT);
			sb.append("1219").append(FIELD_SPLIT);
			sb.append("GPRS").append(FIELD_SPLIT);
			sb.append("20160601230901").append(FIELD_SPLIT);
			String rowkey1=sb.toString();
			
			
			
			
			Connection conn = HBaseProxy.getConnection();
			byte[] rowKey = rowkey1.getBytes();
			Table table = null;
			try {
				table = conn.getTable(TableName
						.valueOf("VIV-BYD_GPRS_DR_201605"));

				Put put = new Put(rowKey);
				
			
				//添加各个列族里面的数据
				put.addColumn("detail_bill".getBytes(), "account_period".getBytes(), "2016051212".getBytes());
				put.addColumn("detail_bill".getBytes(), "tenant_id".getBytes(), "VIV-BYD".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_id".getBytes(), "iccid1219".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_type".getBytes(), "GPRS".getBytes());
				put.addColumn("detail_bill".getBytes(), "bsn".getBytes(), "1459440000000".getBytes());
				put.addColumn("detail_bill".getBytes(), "duration".getBytes(), "14562816".getBytes());
				put.addColumn("detail_bill".getBytes(), "cust_id".getBytes(), "1219".getBytes());
				put.addColumn("detail_bill".getBytes(), "apn_code".getBytes(), "APN1".getBytes());
				put.addColumn("detail_bill".getBytes(), "gprs_down".getBytes(), "321".getBytes());
				put.addColumn("detail_bill".getBytes(), "gprs_up".getBytes(), "122".getBytes());
				put.addColumn("detail_bill".getBytes(), "start_time".getBytes(), "2016051212".getBytes());
				put.addColumn("detail_bill".getBytes(), "subs_id".getBytes(), "s1219".getBytes());
				put.addColumn("detail_bill".getBytes(), "acct_id".getBytes(), "1219".getBytes());
				put.addColumn("detail_bill".getBytes(), "sn".getBytes(), "1456281622845".getBytes());
				put.addColumn("detail_bill".getBytes(), "source".getBytes(), "GPRS".getBytes());
				
//				String data = getData();
//				put.addColumn("detail".getBytes(), "record".getBytes(), data.getBytes());
				table.put(put);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (table != null) {
					try {
						table.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	 
	 @Test
	    public void QueryAll(){  
	        try {  
	        	Table table = HBaseProxy.getConnection().getTable(TableName.valueOf("VIV-BYD_GPRS_DR_201605"));
	            ResultScanner rs = table.getScanner(new Scan());  
	            for (Result r : rs) {  
	                System.out.println("获得到rowkey:" + new String(r.getRow()));  
	                for (KeyValue keyValue : r.raw()) {  
	                    System.out.println("列：" + new String(keyValue.getFamily()) + "_" +Bytes.toString(keyValue.getQualifier())
	                            + "====值:" + new String(keyValue.getValue()));  
	                }  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	 
}
