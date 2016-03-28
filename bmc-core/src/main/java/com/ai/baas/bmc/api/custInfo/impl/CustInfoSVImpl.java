package com.ai.baas.bmc.api.custInfo.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.custInfo.interfaces.ICustInfoSV;
import com.ai.baas.bmc.api.custInfo.params.CustInfoParams;
import com.ai.baas.bmc.api.custInfo.params.ExtInfo;
import com.ai.baas.bmc.business.interfaces.ICustinfoBusiness;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.util.CheckUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.runner.base.exception.CallerException;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 保存从外部系统同步过来的客户信息
 * 
 * Date: 2016年3月23日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangzhi
 */
@Service
@Component
public class CustInfoSVImpl implements ICustInfoSV {
	private static final Logger log = LogManager.getLogger(CustInfoSVImpl.class
			.getName());

	 @Autowired
	    private ICustinfoBusiness iCustinfoBusiness;
	 
	/**
	 * 使用对象做为输入参数的接口函数
	 * 
	 */
	@Override
	public String custNotify(CustInfoParams custInfo) throws CallerException {
		if (custInfo == null) {
			log.debug("extInfoNotify() custInfo = [null]");
			return null;
		} else {
			log.debug("custNotify() custInfo = " + custInfo.toString() + "]");
		}
		
		String resultCode = CheckUtil.check(custInfo.getTradeSeq(), "tradeSeq", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        
        resultCode = CheckUtil.check(custInfo.getTenantId(), "", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
		
        resultCode = CheckUtil.check(custInfo.getExtCustId(), "", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getCustName(), "", false, 128);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getProvinceCode(), "", false, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getCityCode(), "", false, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
     
        resultCode = CheckUtil.check(custInfo.getCustGrade(), "", true, 1,"A","B","C","D");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getCustType(), "", true, 1,"P","G");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getRemark(), "", true, 1024);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getContactNo(), "", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getEmail(), "", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        resultCode = CheckUtil.check(custInfo.getCustAddress(), "", true, 128);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }
        
        
        if (custInfo.getExtInfoList()!=null) {
            for (ExtInfo e: custInfo.getExtInfoList()) {
               resultCode = CheckUtil.check(e.getExtName(), "", false, 32);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                  return resultCode;
            }
             resultCode = CheckUtil.check(e.getExtValue(), "", false, 64);
              if (!ErrorCode.SUCCESS.equals(resultCode)) {
                 return resultCode;
             }
             resultCode = CheckUtil.check(e.getUpdateFlag(), "", false, 1,"D","U","N");
             if (!ErrorCode.SUCCESS.equals(resultCode)) {
                 return resultCode;
               }
        
            }
            
        }
            
		
        try {
        	iCustinfoBusiness.writeData(custInfo);
        	
        } catch (BusinessException e){
            return e.getErrorCode() + e.getErrorMessage();
        } catch (Exception e1) {
            return "writeData发生错误："+e1.getMessage();
        }
	
		return ErrorCode.SUCCESS;
	}
}
