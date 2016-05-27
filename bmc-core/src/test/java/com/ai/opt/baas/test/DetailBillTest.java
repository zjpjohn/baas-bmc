package com.ai.opt.baas.test;

import java.io.IOException;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.detailbill.interfaces.IDetailBillQuerySV;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;
import com.ai.opt.baas.failbill.HBaseProxy;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/context/core-context.xml"})
public class DetailBillTest {
	  @Autowired
	    protected ApplicationContext ctx;

	    public <T> T getBean(Class<T> type) {
	        return ctx.getBean(type);
	    }

	    public Object getBean(String beanName) {
	        return ctx.getBean(beanName);
	    }
	    @Autowired
	    public IDetailBillQuerySV  IDetailBillQuerySV;
	    public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
		public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
	  //详单数据添加
		@Test
		public void addTRData(){
			
			StringBuilder sb = new StringBuilder();
			sb.append("38").append(FIELD_SPLIT);
			sb.append("100").append(FIELD_SPLIT);
			sb.append("999999BHC436").append(FIELD_SPLIT);
			sb.append("sn111q").append(FIELD_SPLIT);
			sb.append("1459440000001");
			String rowkey1=sb.toString();
			
			
			
			
			Connection conn = HBaseProxy.getConnection();
			byte[] rowKey = rowkey1.getBytes();
			Table table = null;
			try {
				table = conn.getTable(TableName
						.valueOf("VIV-BYD_VOICE_DR_201605"));

				Put put = new Put(rowKey);
				//添加各个列族里面的数据
				put.addColumn("detail_bill".getBytes(), "account_period".getBytes(), "2016".getBytes());
				put.addColumn("detail_bill".getBytes(), "bsn".getBytes(), "1456281622845".getBytes());
				put.addColumn("detail_bill".getBytes(), "duration".getBytes(), "14562816".getBytes());
				put.addColumn("detail_bill".getBytes(), "fee1".getBytes(), "123123111111".getBytes());
				put.addColumn("detail_bill".getBytes(), "fee2".getBytes(), "12312321".getBytes());
				put.addColumn("detail_bill".getBytes(), "fee3".getBytes(), "321123213".getBytes());
				put.addColumn("detail_bill".getBytes(), "product_id".getBytes(), "xxxx".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_id".getBytes(), "999999BHC282".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_type".getBytes(), "VOICE".getBytes());
				put.addColumn("detail_bill".getBytes(), "start_time".getBytes(), "123213213213".getBytes());
				put.addColumn("detail_bill".getBytes(), "cal_type".getBytes(), "VOICE".getBytes());
				put.addColumn("detail_bill".getBytes(), "sn".getBytes(), "1456281622845".getBytes());
				put.addColumn("detail_bill".getBytes(), "source".getBytes(), "VOICE".getBytes());
				put.addColumn("detail_bill".getBytes(), "subject1".getBytes(), "通话1".getBytes());
				put.addColumn("detail_bill".getBytes(), "subject2".getBytes(), "通话1".getBytes());
				put.addColumn("detail_bill".getBytes(), "subject3".getBytes(), "于心1".getBytes());
				put.addColumn("detail_bill".getBytes(), "tenant_id".getBytes(), "VIV-BYD".getBytes());
				put.addColumn("detail_bill".getBytes(), "call_type".getBytes(), "MO".getBytes());
				put.addColumn("detail_bill".getBytes(), "opp_number".getBytes(), "13523411234".getBytes());
				put.addColumn("detail_bill".getBytes(), "visit_area".getBytes(), "北京1".getBytes());
				put.addColumn("detail_bill".getBytes(), "long_type".getBytes(), "LOCAL".getBytes());
			
				
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
		public void addTRGprsData(){
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("38").append(FIELD_SPLIT);
			sb.append("100").append(FIELD_SPLIT);
			sb.append("999999BHC436").append(FIELD_SPLIT);
			sb.append("snsnsns1").append(FIELD_SPLIT);
			sb.append("1459440000001");
			String rowkey1=sb.toString();
			
			
			
			
			Connection conn = HBaseProxy.getConnection();
			byte[] rowKey = rowkey1.getBytes();
			Table table = null;
			try {
				table = conn.getTable(TableName
						.valueOf("VIV-BYD_GPRS_DR_201605"));

				Put put = new Put(rowKey);
				//添加各个列族里面的数据
				put.addColumn("detail_bill".getBytes(), "cust_id".getBytes(), "38".getBytes());
				put.addColumn("detail_bill".getBytes(), "cal_type".getBytes(), "GPRS1".getBytes());
				put.addColumn("detail_bill".getBytes(), "gprs_down".getBytes(), "14562816000".getBytes());
				put.addColumn("detail_bill".getBytes(), "fee1".getBytes(), "123123111111".getBytes());
				
				put.addColumn("detail_bill".getBytes(), "gprs_up".getBytes(), "1024000000".getBytes());
				put.addColumn("detail_bill".getBytes(), "service_id".getBytes(), "999999BHC282".getBytes());
				put.addColumn("detail_bill".getBytes(), "subs_id".getBytes(), "100".getBytes());
				put.addColumn("detail_bill".getBytes(), "start_time".getBytes(), "123213213213".getBytes());
				
				put.addColumn("detail_bill".getBytes(), "sn".getBytes(), "1456281622845".getBytes());
				
				
				put.addColumn("detail_bill".getBytes(), "tenant_id".getBytes(), "VIV-BYD".getBytes());
				
				put.addColumn("detail_bill".getBytes(), "is_special".getBytes(), "YES".getBytes());
				put.addColumn("detail_bill".getBytes(), "visit_area".getBytes(), "北京".getBytes());
				
			
				
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
		//详单查询测试
		@Test
		public void queryTR(){
			Table table;
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("38").append(FIELD_SPLIT);
				sb.append("101").append(FIELD_SPLIT);
				sb.append("999999BHC282").append(FIELD_SPLIT);
				
				String rowkey1=sb.toString();
				table = HBaseProxy.getConnection().getTable(TableName.valueOf("VIV-BYD_VOICE_DR_201605"));
				 Filter filter1 = new RowFilter(CompareFilter.CompareOp.EQUAL,
	                     new SubstringComparator(rowkey1));
				Scan scan = new Scan();
				scan.setCaching(200);
				/*scan.setFilter(new SingleColumnValueFilter("bsn".getBytes(),
						"value".getBytes(), CompareFilter.CompareOp.EQUAL,
						new BinaryComparator("JSBIUGZT20160412124".getBytes())));*/
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

@Test
public void testGet(){
	QueryBillRequest request=new QueryBillRequest();
	request.setCustId("38");
	request.setSearchTime("2016-05");
	request.setServiceId("999999BHC436");
	request.setSubsId("100");
	request.setTenantId("VIV-BYD");
	System.out.println(JSON.toJSONString(IDetailBillQuerySV.getDetailBill(request)));
}
}
