package com.ai.baas.bmc.api.initbasedata.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.initbasedata.interfaces.IInitBaseSV;
import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;
import com.ai.baas.bmc.business.interfaces.IinitBaseDataBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
@Service
@Component
public class IInitBaseSVImpl implements IInitBaseSV{
	@Autowired
	IinitBaseDataBusi initBase;
	@Override
	public BaseResponse InitBaseData(InitBaseParam param) throws BusinessException, SystemException {
		int result=initBase.InitBaseBusi(param);
		BaseResponse resultParams = new BaseResponse();
		if(result==1){
			ResponseHeader responHeader=new ResponseHeader(true, "000000", "Success");
			resultParams.setResponseHeader(responHeader);
			return resultParams;
		}else{
			ResponseHeader responHeader=new ResponseHeader(false, "000001", "False");
			resultParams.setResponseHeader(responHeader);
			return resultParams;
		}
	}

}
