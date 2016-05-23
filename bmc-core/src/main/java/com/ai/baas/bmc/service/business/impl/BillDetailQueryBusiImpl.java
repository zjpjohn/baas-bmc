package com.ai.baas.bmc.service.business.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
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
import com.ai.baas.bmc.api.detailbill.params.GPRSParam;
import com.ai.baas.bmc.api.detailbill.params.GPRSResponse;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;
import com.ai.baas.bmc.api.detailbill.params.VoiceParam;
import com.ai.baas.bmc.api.detailbill.params.VoiceResponse;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IBillDetailQueryBusiSV;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.alibaba.fastjson.JSON;
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
		List<VoiceParam> voices=new ArrayList<VoiceParam>();
		List<GPRSParam> gps=new ArrayList<GPRSParam>();
		VoiceResponse vr=new VoiceResponse();
		GPRSResponse gr=new GPRSResponse();
		if(!CollectionUtil.isEmpty(list)){
			for(BmcOutputInfo info:list){
				String serviceType=info.getServiceId();
				//获取该租户对应的标明前缀（即不包含时间部分）
				String tableName=request.getTenantId()+"_"+serviceType+"_"+"DR"+"_"+request.getSearchTime();
				tableNames.add(tableName);
			
				Table table;
				try {
					StringBuilder sb = new StringBuilder();
					sb.append(request.getCustId()).append(FIELD_SPLIT);
					sb.append(request.getSubsId()).append(FIELD_SPLIT);
					sb.append(request.getServiceId()).append(FIELD_SPLIT);
					
					String rowkey1=sb.toString();
					table = MyHbaseUtil.getConnection().getTable(TableName.valueOf(tableName));
					 Filter filter1 = new RowFilter(CompareFilter.CompareOp.EQUAL,
		                     new SubstringComparator(rowkey1));
					Scan scan = new Scan();
					
					scan.setFilter(filter1);
					ResultScanner rs = table.getScanner(scan);
					Iterator<Result> resultIterator=rs.iterator();
					
					while(resultIterator.hasNext()){
						 Result result = resultIterator.next();
						//如果是语音，需要给语音相关的实体类赋值，如果是流量则需要给流量的数据赋值
						
						 if("VOICE".equals(serviceType)){
							 VoiceParam voiceParam=setVoiceParamValue(result);
							 voices.add(voiceParam);
						 }
						 
						 if("GPRS".equals(serviceType)){
							 GPRSParam gParam=setGPRSParamValut(result); 
							 gps.add(gParam);
						 }
					}
					
					
					
					/*
					for (Result r : rs) {// 按行去遍历
					    if("VOICE".equals(serviceType)){
					    	for(KeyValue keyValue : r.raw()){
					    		
					    			if (Bytes.toString(keyValue.getQualifier()).equals("duration")) {
										String line = Bytes.toString(keyValue.getValue());
										System.out.println("---"+line);
									}
					    		
					    	}
					    }
						
						
						  for (KeyValue keyValue : r.raw()) {  
			                    System.out.println("列：" + new String(keyValue.getFamily()) + "_" +Bytes.toString(keyValue.getQualifier())
			                            + "====值:" + new String(keyValue.getValue()));  
			                }  
					}*/
					rs.close();
					table.close();			
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				
				
			}
		}
		vr.setVoice(voices);
		gr.setGprs(gps);
		DetailBillResponse response=new DetailBillResponse();
		response.setGprs(gr);
		response.setVoice(vr);
		ResponseHeader rh=new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		response.setResponseHeader(rh);
		return response;
	}

	//给数据赋值
	private VoiceParam setVoiceParamValue( Result result){
		VoiceParam param =new VoiceParam();
		Cell cell;
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "account_period".getBytes());
		if(cell != null){
			String account_period=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setAccount_period(account_period);
		}
		
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "bsn".getBytes());
		if(cell != null){
			String bsn=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setBsn(bsn);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "duration".getBytes());
		if(cell != null){
			String duration=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setDuration(duration);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "fee1".getBytes());
		if(cell != null){
			String fee1=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setFee1(fee1);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "fee2".getBytes());
		if(cell != null){
			String fee2=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setFee2(fee2);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "fee3".getBytes());
		if(cell != null){
			String fee3=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setFee3(fee3);
		}
		
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "product_id".getBytes());
		if(cell != null){
			String product_id=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setProduct_id(product_id);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "service_id".getBytes());
		if(cell != null){
			String service_id=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setService_id(service_id);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "sn".getBytes());
		if(cell != null){
			String sn=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSn(sn);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "source".getBytes());
		if(cell != null){
			String source=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSource(source);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "subject1".getBytes());
		if(cell != null){
			String subject1=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSubject1(subject1);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "subject2".getBytes());
		if(cell != null){
			String subject2=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSubject2(subject2);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "subject3".getBytes());
		if(cell != null){
			String subject3=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSubject3(subject3);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "tenant_id".getBytes());
		if(cell != null){
			String tenant_id=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setTenant_id(tenant_id);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "call_type".getBytes());
		if(cell != null){
			String call_type=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setCall_type(call_type);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "opp_number".getBytes());
		if(cell != null){
			String opp_number=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setOpp_number(opp_number);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "visit_area".getBytes());
		if(cell != null){
			String visit_area=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setVisit_area(visit_area);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "long_type".getBytes());
		if(cell != null){
			String long_type=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setLong_type(long_type);
		}
		
		
		return param;
	}
	
	
	
	private GPRSParam setGPRSParamValut(Result result){
		GPRSParam param=new GPRSParam();
		Cell cell;
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "cust_id".getBytes());
		if(cell != null){
			String custId=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setCustId(custId);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "fee1".getBytes());
		if(cell != null){
			String fee1=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setFee1(fee1);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "gprs_cu".getBytes());
		if(cell != null){
			String gprsCu=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setGprsCu(gprsCu);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "gprs_down".getBytes());
		if(cell != null){
			String gprsDown=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setGprsDown(gprsDown);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "gprs_up".getBytes());
		if(cell != null){
			String gprsUp=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setGprsUp(gprsUp);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "sbs_id".getBytes());
		if(cell != null){
			String sbsId=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setSbsId(sbsId);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "service_id".getBytes());
		if(cell != null){
			String serviceId=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setServiceId(serviceId);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "start_time".getBytes());
		if(cell != null){
			String startTime=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setStartTime(startTime);
		}
		cell=result.getColumnLatestCell("detail_bill".getBytes(), "visit_area".getBytes());
		if(cell != null){
			String visitArea=Bytes.toString(cell.getValueArray(),cell.getValueOffset(), cell.getValueLength());
			param.setVisitArea(visitArea);
		}
		return param; 
		
	}
}
