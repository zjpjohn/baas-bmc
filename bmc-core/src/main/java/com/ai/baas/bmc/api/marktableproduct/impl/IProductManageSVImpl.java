package com.ai.baas.bmc.api.marktableproduct.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.baas.bmc.api.marktableproduct.params.ProcductResponse;
import com.ai.baas.bmc.api.marktableproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.baas.bmc.business.interfaces.IProductManageBusiness;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.service.business.interfaces.IProductManageBusi;
import com.ai.baas.bmc.util.InCheckUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 可销售产品管理
 * 
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangzhi
 */
@Service(validation = "true")
@Component
public class IProductManageSVImpl implements IProductManageSV {
	private static final Logger log = LogManager
			.getLogger(IProductManageSVImpl.class);

	@Autowired
	private IProductManageBusiness iProductManageBusiness;
	
	@Autowired
	private IProductManageBusi iProductManageBusi;
	//新建产品
	@Override
	public ProcductResponse addProduct(ProductVO vo) throws BusinessException,
			SystemException {
		if (vo == null) {
			log.debug("addProduct() vo = [null]");
			return null;
		} else {
			log.debug("addProduct() vo = " + vo.toString() + "]");
		}
		ProcductResponse response = new ProcductResponse();
		//判重
		try {
			String returnFlag = iProductManageBusiness.hasSeq(vo);
			if (returnFlag.equals("exit")) {
				System.out.println("-----init-----");
				ResponseHeader responseHeader = new ResponseHeader(false,
						ErrorCode.EXIST, "tradeSeq已使用");
				response.setResponseHeader(responseHeader);
				return response;
			}
		} catch (IOException e) {
			LoggerUtil.log.error(e.getStackTrace());
			throw new SystemException(e.getMessage());
		}
       //数据校验
		ProcductResponse resultCode = InCheckUtil.check(vo.getActiveDate(),
				"activeDate", false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getTradeSeq(), "tradeSeq", false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getBillingType(), "productId", false,
				0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getBillingType(), "billingType",
				false, 32,"","");
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getProductName(), "productName",
				false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getActiveDateTag(), "activeDateTag",
				false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getInvalidDate(), "invalidDate",
				false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getTenantId(), "tenantId", false, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}

		resultCode = InCheckUtil.check(vo.getIsPriceEqual(), "isPriceEqual",
				true, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}

		resultCode = InCheckUtil.check(vo.getStandardPriceType(),
				"standardPriceType", true, 1, "1", "2");
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		resultCode = InCheckUtil.check(vo.getTenantPwd(), "", true, 0);
		if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
			return resultCode;
		}
		if (vo.getMajorProductAmount() == null) {
			ResponseHeader responseHeader = new ResponseHeader(false,
					ErrorCode.NULL, "MajorProductAmount不能为空");
			response.setResponseHeader(responseHeader);
			return response;
		}
		for (ServiceVO s : vo.getMajorProductAmount()) {
			resultCode = InCheckUtil
					.check(s.getCycleId(), "cycleId", false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getAmountEnd(), "amountEnd",
					false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getAmountStart(), "amountStart",
					false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getCycleAmount(), "cycleAmount",
					false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getCycleType(), "cycleType",
					false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getPrice(), "price", false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getServiceType(), "serviceType",
					false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getServiceTypeDetail(),
					"serviceTypeDetail", false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}
			resultCode = InCheckUtil.check(s.getUnit(), "unit", false, 0);
			if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
				return resultCode;
			}

		}
		/*if (!(vo.getRelatedProductAmount().isEmpty() || vo
				.getRelatedProductAmount() == null)) {
			for (ServiceVO s : vo.getMajorProductAmount()) {
				resultCode = InCheckUtil.check(s.getCycleId(), "cycleId",
						false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getAmountEnd(), "amountEnd",
						false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getAmountStart(),
						"amountStart", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getCycleAmount(),
						"cycleAmount", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getCycleType(), "cycleType",
						false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getPrice(), "", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getServiceType(),
						"serviceType", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getServiceTypeDetail(),
						"serviceTypeDetail", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}
				resultCode = InCheckUtil.check(s.getUnit(), "unit", false, 0);
				if (!ErrorCode.SUCCESS.equals(resultCode.getResponseHeader())) {
					return resultCode;
				}

			}

		}*/
		//数据库操作
		try {
			iProductManageBusiness.addproduct(vo);
			log.info("-------------->添加成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseHeader responseHeader = new ResponseHeader(true,
					ErrorCode.FALSE, "失败");
			response.setResponseHeader(responseHeader);
			return response;

		}

		ResponseHeader responseHeader = new ResponseHeader(true,
				ErrorCode.SUCCESS, "成功");
		response.setResponseHeader(responseHeader);
		return response;

	}

	@Override
	public void updateProductStatus(ProductActiveVO vo)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delProduct(ProductParamKeyVo vo) throws BusinessException,
			SystemException {
		this.iProductManageBusi.deleteProduct(vo);
		
	}

	@Override
	public void updateProduct(ProductParamVo vo) throws BusinessException,
			SystemException {
		this.iProductManageBusi.updateProduct(vo);
	}

	@Override
	public ProductParamVo editProduct(ProductParamKeyVo vo) throws BusinessException, SystemException {
		return this.iProductManageBusi.editProduct(vo);
		
	}

	@Override
	public ProcductResponse insertProduct(ProductParamVo vo) throws BusinessException, SystemException {
		return this.iProductManageBusi.insertProduct(vo);
	}

}
