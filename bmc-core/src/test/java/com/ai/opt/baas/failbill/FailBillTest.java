package com.ai.opt.baas.failbill;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
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
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class FailBillTest {
	 @Autowired
	    IFailedBillMaintainSV failedBillMaintainSV;
	 
	 @Test
	    public void queryTest2(){
	    	FailedBillCriteria queryInfo = new FailedBillCriteria();
	    	//queryInfo.setTenantId("TR");
	    	queryInfo.setServiceType("VOICE");
//	    	queryInfo.setErrorCode();
	    	FailedBillPagerResponse list = failedBillMaintainSV.queryFailedBills(queryInfo);
	    	System.out.println("标准资费查询出参:"+JSON.toJSONString(list));
	    }
	 
	 
	 
	 
	    public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
		public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
		//create 'RTM_OUTPUT_DETAIL_SMC_201604','bsn','detail'
		
		@Test
		public void insertData(){
			Connection conn = HBaseProxy.getConnection();
			String rowKey = getRowKey();
			Table table = null;
			try {
				table = conn.getTable(TableName
						.valueOf("bmc_failure_bill"));

				Put put = new Put(rowKey.getBytes());
				
				
				
				Map<String,String> failPacket=new HashMap<String,String>();
				failPacket.put("account_period", "20160411");
				failPacket.put("arrival_time", "20160410");
				failPacket.put("bsn", "1456281622845");
				failPacket.put("duration", "1");
				failPacket.put("service_id", "VOICE");
				failPacket.put("service_num", "17012345678");
				failPacket.put("sn", "1064802120010120060709230666");
				failPacket.put("source", "TEST");
				failPacket.put("start_time", "20160413");
				failPacket.put("tenant_id", "TR");
				
				put.addColumn("failure_bill".getBytes(), "account_period".getBytes(), "20160411".getBytes());
				put.addColumn("failure_bill".getBytes(), "arrival_time".getBytes(), "20160410".getBytes());
				put.addColumn("failure_bill".getBytes(), "bsn".getBytes(), "1456281622845".getBytes());
				put.addColumn("failure_bill".getBytes(), "fail_code".getBytes(), "BMC-S0001".getBytes());
				put.addColumn("failure_bill".getBytes(), "fail_date".getBytes(), "20160511170000".getBytes());
				put.addColumn("failure_bill".getBytes(), "fail_reason".getBytes(), "重复数据3333".getBytes());
				put.addColumn("failure_bill".getBytes(), "fail_step".getBytes(), "BMC".getBytes());
				put.addColumn("failure_bill".getBytes(), "service_id".getBytes(), "VOICE".getBytes());
				put.addColumn("failure_bill".getBytes(), "sn".getBytes(), "1064802120010120060709230666".getBytes());
				put.addColumn("failure_bill".getBytes(), "source".getBytes(), "TEST".getBytes());
				put.addColumn("failure_bill".getBytes(), "tenant_id".getBytes(), "TR".getBytes());
				
				
				put.addColumn("failure_bill".getBytes(), "fail_packet".getBytes(), JSON.toJSONString(failPacket).getBytes());
				table.put(put);
				
				/*{
                "accountPeriod": "20160411",
                "arrivalTime": "20160410",
                "bsn": "1456281622845",
                "failCode": "BMC-S0001",
                "failDate": 20160511154257,
                "failPacket": {
                    "account_period": "20160411",
                    "arrival_time": "20160410",
                    "bsn": "1456281622845",
                    "duration": "1",
                    "service_id": "VOICE",
                    "service_num": "17012345678",
                    "sn": "1064802120010120060709230666",
                    "source": "TEST",
                    "start_time": "20160413",
                    "tenant_id": "TR"
                },
                "failReason": "重复数据",
                "failStep": "BMC",
                "rowKey": "TR@@VOICE@@TEST@@1456281622845@@1064802120010120060709230666@@20160410@@20160411",
                "rowKeyRaw": "TRVOICETEST14562816228451064802120010120060709230666BMCBMC-S000120160511154257",
                "serviceId": "VOICE",
                "sn": "1064802120010120060709230666",
                "source": "TEST",
                "tenantId": "TR"
            },*/

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
		public void query(){
			Table table;
			try {
				table = HBaseProxy.getConnection().getTable(TableName.valueOf("bmc_failure_bill"));
				Scan scan = new Scan();
				/*scan.setFilter(new SingleColumnValueFilter("failure_bill".getBytes(),
						"value".getBytes(), CompareFilter.CompareOp.EQUAL,
						new BinaryComparator("JSBIUGZT20160412124".getBytes())));*/
				
				RowFilter rowFilter = new RowFilter(CompareOp.EQUAL, new BinaryComparator(getRowKey().getBytes()));
				scan.setFilter(rowFilter);
				ResultScanner rs = table.getScanner(scan);
				System.out.println("rowkey="+getRowKey());
				for (Result r : rs) {// 按行去遍历
					String line = "";
					for (KeyValue kv : r.raw()) {// 遍历每一行的各列
						//if (Bytes.toString(kv.getQualifier()).equals("record")) {
							line = Bytes.toString(kv.getValue());
							System.out.println(Bytes.toString(kv.getQualifier())+"---"+line);
						//}
					}
				}
				rs.close();
				table.close();			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public String getRowKey(){
			StringBuilder sb = new StringBuilder();
			//tenant_id
			sb.append("TR").append(FIELD_SPLIT);//
			//serviceId
			sb.append("VOICE").append(FIELD_SPLIT);
			//source
			sb.append("TEST").append(FIELD_SPLIT);
			//bsn
			sb.append("1456281622845").append(FIELD_SPLIT);
			//sn
			sb.append("1064802120010120060709230666").append(FIELD_SPLIT);
			//failStep
			sb.append("BMC").append(FIELD_SPLIT);
			//failedCode
			sb.append("BMC-S0001").append(FIELD_SPLIT);
			//failDate
//			sb.append("20160511170000");
			sb.append("20160511154257");
			return sb.toString();
		}
		
		
}
