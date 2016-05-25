package com.ai.baas.bmc.api.feerebatch.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillPagerResponse;
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
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 费用重批
 * @author wangluyang
 *
 */
@Service
@Component
public class FeeReBatchSVImpl implements IFeeReBatchSV{

	private IFeeReBatchBusi feeReBatchBusi;
	
	@Override
	public FeeParamPagerResponse queryFeeReBatch(FeeReBatchCriteria criteria) {
		// TODO Auto-generated method stub
		FeeParamPagerResponse response = new FeeParamPagerResponse();
        HBasePager<FeeParam> hBasePager = criteria.getPager();
        ResponseHeader header = new ResponseHeader(true, "000000", "Success");
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
            throw new SystemException("查询错单出错", e);
        }
        response.setResponseHeader(header);
        return response;
	}

	@Override
	public BaseResponse batchResendFailedBill(FeeReBatchParam param) {
		// TODO Auto-generated method stub
		ResponseHeader responseHeader = new ResponseHeader(true, "000000", "Success");
        try {
        	feeReBatchBusi.batchResendFee(param);
        } catch (BusinessException e) {
            responseHeader.setResultCode("000001");
            responseHeader.setIsSuccess(false);
            responseHeader.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("重发单条错单出错", e);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
	}

}
