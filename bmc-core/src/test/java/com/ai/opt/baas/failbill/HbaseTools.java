package com.ai.opt.baas.failbill;


import java.io.IOException;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;


public class HbaseTools {

	public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
	public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
	//create 'RTM_OUTPUT_DETAIL_SMC_201604','bsn','detail'
	
	public void insertData(){
		Connection conn = HBaseProxy.getConnection();
		byte[] rowKey = String.valueOf(System.currentTimeMillis()).getBytes();
		Table table = null;
		try {
			table = conn.getTable(TableName
					.valueOf("RTM_OUTPUT_DETAIL_201604"));

			Put put = new Put(rowKey);
			put.addColumn("bsn".getBytes(), "value".getBytes(), "1456281622845".getBytes());
			String data = getData();
			put.addColumn("detail".getBytes(), "record".getBytes(), data.getBytes());
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
	
	public void query(){
		Table table;
		try {
			table = HBaseProxy.getConnection().getTable(TableName.valueOf("RTM_OUTPUT_DETAIL_201604"));
			
			
			 Filter filter1 = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,
                     new BinaryComparator("row010".getBytes()));
			Scan scan = new Scan();
			scan.setFilter(new SingleColumnValueFilter("bsn".getBytes(),
					"value".getBytes(), CompareFilter.CompareOp.EQUAL,
					new BinaryComparator("JSBIUGZT20160412124".getBytes())));
			ResultScanner rs = table.getScanner(scan);
			for (Result r : rs) {// 按行去遍历
				String line = "";
				for (KeyValue kv : r.raw()) {// 遍历每一行的各列
					if (Bytes.toString(kv.getQualifier()).equals("record")) {
						line = Bytes.toString(kv.getValue());
						System.out.println("---"+line);
					}
				}
			}
			rs.close();
			table.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getData(){
		StringBuilder sb = new StringBuilder();
		sb.append("MVNE").append(FIELD_SPLIT);
		sb.append("msg").append(FIELD_SPLIT);
		sb.append("msg").append(FIELD_SPLIT);
		sb.append("20150401001").append(FIELD_SPLIT);
		sb.append("1064802120010120060709230900113").append(FIELD_SPLIT);
		sb.append("201604").append(FIELD_SPLIT);
		sb.append("20160410").append(FIELD_SPLIT);
		sb.append("20150401001").append(FIELD_SPLIT);
		sb.append("1").append(FIELD_SPLIT);
		sb.append("1064802120010120060709230900116").append(FIELD_SPLIT);
		sb.append("hx").append(FIELD_SPLIT);
		sb.append("bw").append(FIELD_SPLIT);
		sb.append("13012345678").append(FIELD_SPLIT);
		sb.append("20160405").append(FIELD_SPLIT);
		sb.append("abcfdafsdaf").append(FIELD_SPLIT);
		sb.append("1");
		return sb.toString();
	}
	//详单数据添加
	public void addTRData(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("38").append(FIELD_SPLIT);
		sb.append("101").append(FIELD_SPLIT);
		sb.append("999999BHC123").append(FIELD_SPLIT);
		sb.append("snsnsnsn").append(FIELD_SPLIT);
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
			put.addColumn("detail_bill".getBytes(), "account_period".getBytes(), "2016".getBytes());
			put.addColumn("detail_bill".getBytes(), "bsn".getBytes(), "1456281622845".getBytes());
			put.addColumn("detail_bill".getBytes(), "duration".getBytes(), "14562816".getBytes());
			put.addColumn("detail_bill".getBytes(), "fee1".getBytes(), "123123".getBytes());
			put.addColumn("detail_bill".getBytes(), "fee2".getBytes(), "123".getBytes());
			put.addColumn("detail_bill".getBytes(), "fee3".getBytes(), "321".getBytes());
			put.addColumn("detail_bill".getBytes(), "product_id".getBytes(), "xxxx".getBytes());
			put.addColumn("detail_bill".getBytes(), "service_id".getBytes(), "999999BHC123".getBytes());
			put.addColumn("detail_bill".getBytes(), "sn".getBytes(), "1456281622845".getBytes());
			put.addColumn("detail_bill".getBytes(), "source".getBytes(), "VOICE".getBytes());
			put.addColumn("detail_bill".getBytes(), "subject1".getBytes(), "通话12".getBytes());
			put.addColumn("detail_bill".getBytes(), "subject2".getBytes(), "通话12".getBytes());
			put.addColumn("detail_bill".getBytes(), "subject3".getBytes(), "于心12".getBytes());
			put.addColumn("detail_bill".getBytes(), "tenant_id".getBytes(), "VIV-BYD".getBytes());
			put.addColumn("detail_bill".getBytes(), "call_type".getBytes(), "被叫".getBytes());
			put.addColumn("detail_bill".getBytes(), "opp_number".getBytes(), "13523411234".getBytes());
			put.addColumn("detail_bill".getBytes(), "visit_area".getBytes(), "北京12".getBytes());
			put.addColumn("detail_bill".getBytes(), "long_type".getBytes(), "local".getBytes());
			put.addColumn("detail_bill".getBytes(), "call_duration".getBytes(), "test2".getBytes());
			put.addColumn("detail_bill".getBytes(), "total_flow".getBytes(), "00001".getBytes());
//			String data = getData();
//			put.addColumn("detail".getBytes(), "record".getBytes(), data.getBytes());
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
	public void queryTR(){
		Table table;
		try {
			table = HBaseProxy.getConnection().getTable(TableName.valueOf("VIV-BYD_VOICE_DR_201605"));
			 Filter filter1 = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,
                     new SubstringComparator("test"));
			Scan scan = new Scan();
			/*scan.setFilter(new SingleColumnValueFilter("bsn".getBytes(),
					"value".getBytes(), CompareFilter.CompareOp.EQUAL,
					new BinaryComparator("JSBIUGZT20160412124".getBytes())));*/
			scan.setFilter(filter1);
			ResultScanner rs = table.getScanner(scan);
			for (Result r : rs) {// 按行去遍历
				String line = "";
				
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
	public static void main(String[] args) {
		HbaseTools demo = new HbaseTools();
		//demo.insertData();
		demo.addTRData();
	}

}
