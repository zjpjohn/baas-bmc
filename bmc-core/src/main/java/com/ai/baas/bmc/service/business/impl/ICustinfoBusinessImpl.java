package com.ai.baas.bmc.service.business.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Table;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.custInfo.params.CustInfoParams;
import com.ai.baas.bmc.api.custInfo.params.ExtInfo;
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
import com.ai.baas.bmc.service.business.interfaces.ICustinfoBusiness;
import com.ai.baas.bmc.service.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.runner.base.exception.CallerException;
import com.alibaba.fastjson.JSON;

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
	private static final Log log = LogFactory.getLog(ICustinfoBusinessImpl.class);
	@Override
	public boolean hasSeq(CustInfoParams custInfo) throws IOException {
		 String rowkey = custInfo.getTenantId() + Context.SPLIT + Context.CUST_INFO_CODE
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
		log.info("*******************************");
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
		custobject.put("TENANT_ID", custInfo.getTenantId());
		
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
		custobject.put("CUST_TYPE", custInfo.getCustType());
		
		blCustinfo.setRemark(custInfo.getRemark());
		custobject.put("REMARK", custInfo.getRemark());
		
		blCustinfo.setContactNo(custInfo.getContactNo());
		custobject.put("CONTACT_NO", custInfo.getContactNo());
		
		blCustinfo.setEmail(custInfo.getEmail());
		custobject.put("EMAIL", custInfo.getEmail());
		
		blCustinfo.setCustAddress(custInfo.getCustAddress());
		custobject.put("CUST_ADDRESS", custInfo.getCustAddress());
		
		String custId = null;
		Map<String, String> params = new TreeMap<String, String>();
        params.put("EXT_CUST_ID", custInfo.getExtCustId());
        params.put("TENANT_ID", custInfo.getTenantId());
        
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_custinfo").where(params)
                .executeQuery(DshmUtil.getCacheClient());
        log.info("dshm custInfo---->>>:"+JSON.toJSONString(result));
        //获得缓存中第一条有效数据
        boolean bool = true;
        if(!(result==null||result.isEmpty())){
            for(Map<String, String> r : result){
                if(!r.isEmpty()){
                    custId = r.get("cust_id");
                    blCustinfo.setCustId(custId);
                    custobject.put("CUST_ID", custId);
                    bool = false;
                    break;
                }
            }
        }
        // bool=fasle时说明获得了一条数据，不需要执行下面部分
        if(bool){
        	custId = aISysSequenceSvc.terrigerSysSequence("CUST_ID", 1).get(0);
    		blCustinfo.setCustId(custId);
    		custobject.put("CUST_ID", custId);
        }
//        custId ="3";
//        blCustinfo.setCustId(custId);
		if (custInfo.getExtInfoList() != null) {
			for (ExtInfo e : custInfo.getExtInfoList()) {
				log.info("extinfo.extValue--->>>:"+e.getExtValue());
				writeBlCustinfoExt(custId,e);

			}
		}
		
		BlCustinfoCriteria blCustinfoCriteria = new BlCustinfoCriteria();
		blCustinfoCriteria.createCriteria()
		    .andTenantIdEqualTo(custInfo.getTenantId())
		    .andCustIdEqualTo(custId);
		
		List<BlCustinfo> blCustInfoList = aBlCustinfoMapper.selectByExample(blCustinfoCriteria);
		//如果信息不存在 就添加信息
		if(CollectionUtil.isEmpty(blCustInfoList)){
			log.info("---------------custInfo not exist------------------");
			aBlCustinfoMapper.insert(blCustinfo);
			DshmUtil.getIdshmSV().initLoader("bl_custinfo", JSON.toJSONString(custobject),1);
		}else{
			try{
				log.info("---------------custInfo exist------------------");
				//如果信息存在就修改信息
				BlCustinfo blCustInfoUpdate = new BlCustinfo();
				blCustInfoUpdate.setCityCode(custInfo.getCityCode());
				blCustInfoUpdate.setContactNo(custInfo.getContactNo());
				blCustInfoUpdate.setCustAddress(custInfo.getCustAddress());
				blCustInfoUpdate.setCustGrade(custInfo.getCustGrade());
				blCustInfoUpdate.setCustName(custInfo.getCustName());
				blCustInfoUpdate.setCustType(custInfo.getCustType());
				blCustInfoUpdate.setEmail(custInfo.getEmail());
				blCustInfoUpdate.setExtCustId(custInfo.getExtCustId());
				blCustInfoUpdate.setProvinceCode(custInfo.getProvinceCode());
				blCustInfoUpdate.setRemark(custInfo.getRemark());
				blCustInfoUpdate.setState(custInfo.getState());
				//
//				SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			    Date date = df1.parse(custInfo.getStateChgTime());
//			    String time = df1.format(date);
//			    Timestamp ts = Timestamp.valueOf(time);
//				log.info("-----timestamp:"+ts);
				
				blCustInfoUpdate.setStateChgTime(DateUtil.getSysDate());//(DateUtil.getSysDate());
				
				blCustInfoUpdate.setTenantId(custInfo.getTenantId());
				//
				BlCustinfoCriteria blCustinfoCriteriaUpdate = new BlCustinfoCriteria();
				blCustinfoCriteriaUpdate.createCriteria()
				    .andTenantIdEqualTo(custInfo.getTenantId())
				    .andCustIdEqualTo(custId);
				
				aBlCustinfoMapper.updateByExampleSelective(blCustInfoUpdate, blCustinfoCriteriaUpdate);
				//
				DshmUtil.getIdshmSV().initLoader("bl_custinfo", JSON.toJSONString(custobject),0);
				log.info("------------update custInfo:修改客户信息完毕！");
			}catch(Exception e){
				log.info("------------update custInfo exception-------------------");
				e.printStackTrace();
			}
		}
		
	}
	private void writeBlCustinfoExt(String custId, ExtInfo extInfo) {
		BlCustinfoExt blCustinfoExt = new BlCustinfoExt();
		JSONObject extobject = new JSONObject();
		
		if (extInfo.getUpdateFlag().equals("N")){
			blCustinfoExt.setExtName(extInfo.getExtName());
//			extobject.put("EXT_NAME", extInfo.getExtName());

			blCustinfoExt.setExtValue(extInfo.getExtValue());
//			extobject.put("EXTA_VALUE", extInfo.getExtValue());

			blCustinfoExt.setCustId(custId);
//			extobject.put("CUST_ID", custId);
			
			
			BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
            example.createCriteria().andExtNameEqualTo(extInfo.getExtName())
            .andCustIdEqualTo(custId);
            
            List<BlCustinfoExt> blCustinfoExtList = blCustinfoExtMapper.selectByExample(example);
            if(CollectionUtil.isEmpty(blCustinfoExtList)){
            	try{
            	blCustinfoExtMapper.insert(blCustinfoExt);
            	//
            	BlCustinfoExt blCustInfoExtNew = blCustinfoExtMapper.selectByExample(example).get(0);
            	extobject.put("EXT_ID", blCustInfoExtNew.getExtId());
            	extobject.put("EXT_NAME", blCustInfoExtNew.getExtName());
            	extobject.put("EXT_VALUE", blCustInfoExtNew.getExtValue());
            	extobject.put("CUST_ID", blCustInfoExtNew.getCustId());
            	log.info("------ insert ext info---->>>:"+MyJsonUtil.toJson(blCustInfoExtNew));
            	DshmUtil.getIdshmSV().initLoader("bl_custinfo_ext", JSON.toJSONString(extobject),1);
            	}catch(Exception e){
            		e.printStackTrace();
            	}
            }
	            

		}else if(extInfo.getUpdateFlag().equals("U")){
			 blCustinfoExt.setExtValue(extInfo.getExtValue());
			 
			 BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
	            example.createCriteria()
	            .andCustIdEqualTo(custId)
	            .andExtNameEqualTo(extInfo.getExtName());
	            try {
	            	
	            	blCustinfoExtMapper.updateByExampleSelective(blCustinfoExt, example);
	            	List<BlCustinfoExt> blCustinfoExtList = blCustinfoExtMapper.selectByExample(example);
	            	if(!CollectionUtil.isEmpty(blCustinfoExtList)){
	            		BlCustinfoExt blCustInfoExtNew = blCustinfoExtList.get(0);
	            		extobject.put("EXT_ID", blCustInfoExtNew.getExtId());
	                	extobject.put("EXT_NAME", blCustInfoExtNew.getExtName());
	                	extobject.put("EXT_VALUE", blCustInfoExtNew.getExtValue());
	                	extobject.put("CUST_ID", blCustInfoExtNew.getCustId());
	                	
	            		DshmUtil.getIdshmSV().initLoader("bl_custinfo_ext", JSON.toJSONString(extobject),0);
	            	}
	             
	            } catch (NullPointerException e) {
	                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法更新");
	            }
			
		}else if(extInfo.getUpdateFlag().equals("D")){
			 BlCustinfoExtCriteria example = new BlCustinfoExtCriteria();
	            example.createCriteria()
	            .andCustIdEqualTo(custId)
	            .andExtNameEqualTo(extInfo.getExtName());
	            //.andExtValueEqualTo(extInfo.getExtValue())
	            
	            try {
	            	List<BlCustinfoExt> blCustInfoExtList = blCustinfoExtMapper.selectByExample(example);
	            	
	            	if(!CollectionUtil.isEmpty(blCustInfoExtList)){
	            		BlCustinfoExt blCustInfoExtNew = blCustInfoExtList.get(0);
	            		extobject.put("EXT_ID", blCustInfoExtNew.getExtId());
	                	extobject.put("EXT_NAME", blCustInfoExtNew.getExtName());
	                	extobject.put("EXT_VALUE", blCustInfoExtNew.getExtValue());
	                	extobject.put("CUST_ID", blCustInfoExtNew.getCustId());
	                	//
	            		blCustinfoExtMapper.deleteByExample(example);
	            		DshmUtil.getIdshmSV().initdel("bl_custinfo_ext", JSON.toJSONString(extobject));
	            	}
	            	
	            	
	            } catch (NullPointerException e) {
	                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法删除");
	            }
		}
		
		
		
		
		
	}

}
