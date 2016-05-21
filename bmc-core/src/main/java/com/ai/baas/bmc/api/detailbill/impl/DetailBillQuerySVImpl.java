package com.ai.baas.bmc.api.detailbill.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.detailbill.interfaces.IDetailBillQuerySV;
import com.ai.baas.bmc.api.detailbill.params.DetailBillResponse;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;
import com.ai.baas.bmc.service.business.interfaces.IBillDetailQueryBusiSV;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service(validation="true")
@Component
public class DetailBillQuerySVImpl implements IDetailBillQuerySV {

	@Autowired
	private IBillDetailQueryBusiSV iBillDetailQueryBusiSV;
	@Override
	public DetailBillResponse getDetailBill(QueryBillRequest vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iBillDetailQueryBusiSV.getDetailBill(vo);
	}

}
