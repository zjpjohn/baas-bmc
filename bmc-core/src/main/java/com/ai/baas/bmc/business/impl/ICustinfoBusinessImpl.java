package com.ai.baas.bmc.business.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.client.Table;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.custInfo.params.CustInfoParams;
import com.ai.baas.bmc.api.custInfo.params.ExtInfo;
import com.ai.baas.bmc.business.interfaces.ICustinfoBusiness;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoExtCriteria;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.runner.base.exception.CallerException;

import net.sf.json.JSONObject;


@Service
@Transactional
public class ICustinfoBusinessImpl implements ICustinfoBusiness{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private BlCustinfoExtMapper blCustinfoExtMapper;
	@Autowired
	private BlCustinfoMapper aBlCustinfoMapper;
	@Autowired
	private ISysSequenceSvc aISysSequenceSvc;

	@Override
	public boolean hasSeq(CustInfoParams custInfo) throws IOException {
		 String rowkey = custInfo.getTenantId() + Context.SPLIT + Context.ORDER_INFO_CODE
	                + Context.SPLIT + custInfo.getTradeSeq();
	        Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);

	        if (MyHbaseUtil.hasExists(table, rowkey)) {
	            return true;
	        }
	        MyHbaseUtil.addData(table, rowkey,
	                CellTemp.inst(ConTradeSeqLog.TENANT_ID, custInfo.getTenantId()),
	                CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.CUST_INFO_CODE),
	                CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, custInfo.getTradeSeq()),
	                CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
	                        DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
	                CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(custInfo)));
	        return false;
	    
		
	}


	@Override
	public void writeData(CustInfoParams custInfo) {
		JSONObject custobject = new JSONObject();
		BlCustinfo blCustinfo = new BlCustinfo();
		System.err.println("*******************************");
		if (!StringUtil.isBlank(custInfo.getState())) {
			if (custInfo.getState().length() <= 4) {
				blCustinfo.setState(custInfo.getState());
				custobject.put("STATE", custInfo.getState());
			} else {
				throw new CallerException("BMC-00002", "State超长");
			}
		} else {
			   blCustinfo.setState("0");
			   custobject.put("STATE", "0");
		}
		if (!StringUtil.isBlank(custInfo.getStateChgTime())) {
			if (custInfo.getState().length() <= 14) {
				blCustinfo.setStateChgTime(DateUtil.getTimestamp(custInfo.getStateChgTime(), DateUtil.YYYYMMDDHHMMSS));
				custobject.put("STATE_CHG_TIME", DateUtil.getTimestamp(custInfo.getStateChgTime(), DateUtil.YYYYMMDDHHMMSS).toString().substring(0, 19));
				
			} else {
				throw new CallerException("BMC-00002", "StateChgTime超长");
			}
		} else {
			  blCustinfo.setStateChgTime(DateUtil.getSysDate());
		        custobject.put("STATE_CHG_TIME",DateUtil.getDateString(DateUtil.getSysDate(),
				DateUtil.YYYYMMDDHHMMSS));
		}    
	        
		blCustinfo.setTenantId(custInfo.getTenantId());
		custobject.put("TENANTA_ID", custInfo.getTenantId());
		
		blCustinfo.setExtCustId(custInfo.getExtCustId());
		custobject.put("EXT_CUST_ID", custInfo.getExtCustId());
		
		blCustinfo.setCustName(custInfo.getCustName());
		custobject.put("CUST_NAME", custInfo.getCustName());
		
		blCustinfo.setProvinceCode(custInfo.getProvinceCode());
		custobject.put("PROVINCE_CODE", custInfo.getProvinceCode());
		
		blCustinfo.setCityCode(custInfo.getCityCode());
		custobject.put("CITY_CODE", custInfo.getCityCode());
			
		blCustinfo.setCustGrade(custInfo.getCustGrade());
		custobject.put("CUST_GRADE", custInfo.getCustGrade());
		
		blCustinfo.setCustType(custInfo.getCustType());
		custobject.put("CUST-TYPE", custInfo.getCustType());
		
		blCustinfo.setRemark(custInfo.getRemark());
		custobject.put("REMARK", custInfo.getRemark());
		
		blCustinfo.setContactNo(custInfo.getRemark());
		custobject.put("CONTACT_NO", custInfo.getRemark());
		
		blCustinfo.setEmail(custInfo.getEmail());
		custobject.put("EMAIL", custInfo.getEmail());
		
		blCustinfo.setCustAddress(custInfo.getCustAddress());
		custobject.put("CUST_ADDRESS", custInfo.getCustAddress());
		
		String custId = null;
		Map<String, String> params = new TreeMap<String, String>();
        params.put("EXT_CUST_ID", custInfo.getExtCustId());
        List<Map<String, String>> result = DshmUtil.getDshmread().list("bl_custinfo").where(params)
                .executeQuery();
        if(!(result==null||result.isEmpty())){
        	 String temp[] = result.get(0).get("CUST_ID").split("#");
        	 custId = temp[temp.length - 1];
        	 blCustinfo.setCustId(custId);
     		 custobject.put("CUST_ID", custId);
        }else{
        	custId = aISysSequenceSvc.terrigerSysSequence("CUST_ID", 1).get(0);
    		blCustinfo.setCustId(custId);
    		custobject.put("CUST_ID", custId);
        }
//        custId ="3";
//        blCustinfo.setCustId(custId);
		if (custInfo.getExtInfoList() != null) {
			for (ExtInfo e : custInfo.getExtInfoList()) {
				writeBlCustinfoExt(custId,e);

			}
		}
		
		BlCustinfoCriteria blCustinfoCriteria = new BlCustinfoCriteria();
		blCustinfoCriteria.createCriteria()
		    .andTenantIdEqualTo(custInfo.getTenantId())
		    .andCustIdEqualTo(custId);
		
		aBlCustinfoMapper.deleteByExample(blCustinfoCriteria);
		aBlCustinfoMapper.insert(blCustinfo);
		
//		DshmUtil.getIdshmSV().initdel("bl_custinfo", custobject.toString());
        DshmUtil.getIdshmSV().initLoader("bl_custinfo", custobject.toString(),0);
		
	}
	private void writeBlCustinfoExt(String custId, ExtInfo extInfo) {
		BlCustinfoExt blCustinfoExt = new BlCustinfoExt();
//		JSONObject extobject = new JSONObject();
		
		if (extInfo.getUpdateFlag().equals("N")){
			blCustinfoExt.setExtName(extInfo.getExtName());
//			extobject.put("EXT_NAME", extInfo.getExtName());

			blCustinfoExt.setExtValue(extInfo.getExtValue());
//			extobject.put("EXTA_VALUE", extInfo.getExtValue());

			blCustinfoExt.setCustId(custId);
//			extobject.put("CUST_ID", custId);
			
			blCustinfoExtMapper.insert(blCustinfoExt);
			 BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
	            example.createCriteria().andExtNameEqualTo(extInfo.getExtName())
	            .andCustIdEqualTo(custId);
	            
	            BlCustinfoExt temp = blCustinfoExtMapper.selectByExample(example).get(0);
	            DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", MyJsonUtil.toJson(temp),1);

		}else if(extInfo.getUpdateFlag().equals("U")){
			 blCustinfoExt.setExtValue(extInfo.getExtValue());
			 BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
	            example.createCriteria().andCustIdEqualTo(custId)
	                    .andExtNameEqualTo(extInfo.getExtName());
	            try {
	            	BlCustinfoExt temp = blCustinfoExtMapper.selectByExample(example).get(0);
	            	blCustinfoExtMapper.updateByExampleSelective(blCustinfoExt, example);
	             
//	                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext", MyJsonUtil.toJson(temp));
	                DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", MyJsonUtil.toJson(temp),0);
	             
	            } catch (NullPointerException e) {
	                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法更新");
	            }
			
			
//			DshmUtil.getIdshmSV().initDel("bl_custinfo_ext", extobject.toString());
			
		}else if(extInfo.getUpdateFlag().equals("D")){
//			 blCustinfoExt.setExtValue(extInfo.getExtValue());
			 BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
	            example.createCriteria().andCustIdEqualTo(custId).andExtValueEqualTo(extInfo.getExtValue())
	                    .andExtNameEqualTo(extInfo.getExtName());
	            try {
	            	BlCustinfoExt temp = blCustinfoExtMapper.selectByExample(example).get(0);
	            	blCustinfoExtMapper.deleteByExample(example);
	            	DshmUtil.getIdshmSV().initdel("bl_userinfo_ext", MyJsonUtil.toJson(temp));
	            } catch (NullPointerException e) {
	                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法删除");
	            }
		}
		
		
		
		
		
	}

}
