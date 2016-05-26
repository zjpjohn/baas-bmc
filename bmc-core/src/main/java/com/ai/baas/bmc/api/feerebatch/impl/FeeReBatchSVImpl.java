package com.ai.baas.bmc.api.feerebatch.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.feeReBatch.interfaces.IFeeReBatchSV;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeParamPagerResponse;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchParam;
import com.ai.baas.bmc.business.interfaces.IFeeReBatchBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.HBasePager;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 费用重批
 * @author wangluyang
 *
 */
@Service
@Component
public class FeeReBatchSVImpl implements IFeeReBatchSV{

	@Autowired
	private IFeeReBatchBusi feeReBatchBusi;
	
	@Override
	public FeeParamPagerResponse queryFeeReBatch(FeeReBatchCriteria criteria) {
		// TODO Auto-generated method stub
		FeeParamPagerResponse response = new FeeParamPagerResponse();
        HBasePager<FeeParam> hBasePager = criteria.getPager();
        ResponseHeader header = new ResponseHeader(true, "000000", "Success");
        if(StringUtil.isBlank(criteria.getTenantId())){
	           throw new BusinessException("400", "租户ID不能为空");
	       }
		if(StringUtil.isBlank(criteria.getServiceType())){
	           throw new BusinessException("400", "业务类型不能为空");
	       }
		if(StringUtil.isBlank(criteria.getAccountPeriod())){
	           throw new BusinessException("400", "账期不能为空");
	       }
        try {
            if (hBasePager == null) {
                hBasePager = new HBasePager<FeeParam>();
            }
            List<FeeParam> result = feeReBatchBusi.queryFeeReBatch(criteria);
            hBasePager.setResult(result);
            response.setFeeParamPager(hBasePager);
        } catch (BusinessException e) {
            header.setResultCode("000001");
            header.setIsSuccess(false);
            header.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("查询出错", e);
        }
        response.setResponseHeader(header);
        return response;
	}

	@Override
	public BaseResponse batchResendFee(FeeReBatchParam param) {
		// TODO Auto-generated method stub
		ResponseHeader responseHeader = new ResponseHeader(true, "000000", "Success");
		if(StringUtil.isBlank(param.getCriteria().getTenantId())){
	           throw new BusinessException("400", "租户ID不能为空");
	       }
		if(StringUtil.isBlank(param.getCriteria().getServiceType())){
	           throw new BusinessException("400", "业务类型不能为空");
	       }
		if(StringUtil.isBlank(param.getCriteria().getReBatchType())){
	           throw new BusinessException("400", "回退类型不能为空");
	       }
		if(StringUtil.isBlank(param.getCriteria().getAccountPeriod())){
	           throw new BusinessException("400", "账期不能为空");
	       }
        try {
        	feeReBatchBusi.batchResendFee(param);
        } catch (BusinessException e) {
            responseHeader.setResultCode("000001");
            responseHeader.setIsSuccess(false);
            responseHeader.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("费用重批出错", e);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
	}

}
