package com.ai.baas.bmc.service.business.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.detailbill.params.DetailBillResponse;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IBillDetailQueryBusiSV;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.opt.baas.failbill.HBaseProxy;
import com.ai.opt.sdk.util.CollectionUtil;
@Service
public class BillDetailQueryBusiImpl implements IBillDetailQueryBusiSV {

	@Autowired
	private IBmcOutputInfoAtomSV iBmcOutputInfoAtomSV;
	
	public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
	 
	public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
	
	@Override
	public DetailBillResponse getDetailBill(QueryBillRequest request) {
		List<BmcOutputInfo> list=iBmcOutputInfoAtomSV.getOutputInfo(request.getTenantId(), "DR");
		List<String> tableNames=new ArrayList<String>();
		
		if(!CollectionUtil.isEmpty(list)){
			for(BmcOutputInfo info:list){
				String serviceType=info.getServiceId();
				//获取该租户对应的标明前缀（即不包含时间部分）
				String tableName=request.getTenantId()+"_"+serviceType+"_"+"DR"+request.getSearchTime();
				tableNames.add(tableName);
				
				
				
				Table table;
				try {
					StringBuilder sb = new StringBuilder();
					sb.append("38").append(FIELD_SPLIT);
					sb.append("101").append(FIELD_SPLIT);
					sb.append("999999BHC282").append(FIELD_SPLIT);
					
					String rowkey1=sb.toString();
					table = MyHbaseUtil.getConnection().getTable(TableName.valueOf(tableName));
					 Filter filter1 = new RowFilter(CompareFilter.CompareOp.EQUAL,
		                     new SubstringComparator(rowkey1));
					Scan scan = new Scan();
					
					scan.setFilter(filter1);
					ResultScanner rs = table.getScanner(scan);
					for (Result r : rs) {// 按行去遍历
					
						
						/*for (KeyValue kv : r.raw()) {// 遍历每一行的各列
							if (Bytes.toString(kv.getQualifier()).equals("record")) {
								line = Bytes.toString(kv.getValue());
								System.out.println("---"+line);
							}
						}*/
						  for (KeyValue keyValue : r.raw()) {  
			                    System.out.println("列：" + new String(keyValue.getFamily()) + "_" +Bytes.toString(keyValue.getQualifier())
			                            + "====值:" + new String(keyValue.getValue()));  
			                }  
					}
					rs.close();
					table.close();			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		}
		
		
		
		
		
		
		
		
		return null;
	}

}
