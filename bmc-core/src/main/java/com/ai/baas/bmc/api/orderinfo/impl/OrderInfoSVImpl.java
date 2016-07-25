package com.ai.baas.bmc.api.orderinfo.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;
import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.service.business.interfaces.IOrderinfoBusiSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class OrderInfoSVImpl implements IOrderInfoSV {
    @Autowired
    private IOrderinfoBusiSV business;

    @Override
    public BaseResponse orderInfo(OrderInfoParams request) throws BusinessException,
            SystemException {

        BaseResponse resultCode = new BaseResponse();
        // 入参检验
        BusinessUtil.checkBaseInfo(request);
        if (StringUtil.isBlank(request.getTradeSeq())) {
            throw new BusinessException("交易流水为空");
        }
        if (StringUtil.isBlank(request.getExtCustId())) {
            throw new BusinessException("外部客户ID为空");
        }
        if (StringUtil.isBlank(request.getUsetype())) {
            throw new BusinessException("订购类型为空");
        }
        if (StringUtil.isBlank(request.getServiceId())) {
            throw new BusinessException("服务标识为空");
        }
        if (!CollectionUtil.isEmpty(request.getOrderExtInfo())) {
            for (OrderExt orderExt : request.getOrderExtInfo()) {
                if (StringUtil.isBlank(orderExt.getExtName())) {
                    throw new BusinessException("订购扩展信息名称为空");
                }
                if (StringUtil.isBlank(orderExt.getExtValue())) {
                    throw new BusinessException("订购扩展信息值为空");
                }
                if (StringUtil.isBlank(orderExt.getUpdateFlag())) {
                    throw new BusinessException("订购扩展信息更新标识为空");
                }
            }
        }
        if (!CollectionUtil.isEmpty(request.getProductList())) {
            for (Product product : request.getProductList()) {
                if (StringUtil.isBlank(product.getProductId())) {
                    throw new BusinessException("产品ID为空");
                }
                if (StringUtil.isBlank(product.getProductType())) {
                    throw new BusinessException("产品类型为空");
                }
                if ((product.getProductNumber() == null) || product.getProductNumber() == 0) {
                    throw new BusinessException("产品数量为空");
                }
                if (StringUtil.isBlank(product.getActiveTime())) {
                    throw new BusinessException("产品生效时间为空");
                }
                if (StringUtil.isBlank(product.getInactiveTime())) {
                    throw new BusinessException("产品失效时间为空");
                }
            }
        }

        // 幂等性判断（判重）
//        try {
//            if (business.hasSeq(request)) {
//                resultCode.setResponseHeader(new ResponseHeader(false, "000001", "tradeSeq已存在"));
//                return resultCode;
//            }
//        } catch (IOException e) {
//            LoggerUtil.log.error(e);
//            resultCode.setResponseHeader(new ResponseHeader(false, "000001", "幂等性判断失败"));
//            return resultCode;
//        }

        // 写入MySQL表中
        business.writeData(request);

        resultCode.setResponseHeader(new ResponseHeader(true, "000000", "成功"));
        return resultCode;
    }

    public static void main(String[] args) {

        // LoggerUtil.log.debug("入参：" + MyJsonUtil.toJson(record));
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getTenantId(), "tenantId", false, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getExtCustId(), "extCustId", false, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getUsetype(), "usetype", false, 32, "Test",
        // "Normal");
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getState(), "state", true, 32, "Normal", "Stop",
        // "Cancel");
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getServiceId(), "serviceId", false, 64);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getOrderTime(), "orderTime", true, 14);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // } else if (!CheckUtil.check(record.getOrderTime(), DateUtil.YYYYMMDDHHMMSS)) {
        // return ErrorCode.UNFORMATE + ":orderTime格式YYYYMMDDHH24MISS";
        // }
        //
        // resultCode = CheckUtil.check(record.getProvinceCode(), "provinceCode", true, 6);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getCityCode(), "cityCode", true, 6);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getChlId(), "chlId", true, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getDevId(), "devId", true, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(record.getActiveTime(), "activeTime", false, 14);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // } else if (!CheckUtil.check(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
        // return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
        // }
        //
        // resultCode = CheckUtil.check(record.getInactiveTime(), "inactiveTime", false, 14);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // } else if (!CheckUtil.check(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
        // return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
        // }

        // if (record.getOrderExtInfo() != null) {
        // for (OrderExt o : record.getOrderExtInfo()) {
        // resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U",
        // "N");
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        // }
        // }
        // resultCode = CheckUtil.check(record.getRemark(), "remark", true, 1024);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // if (record.getProductList() != null) {
        // for (Product p : record.getProductList()) {
        // resultCode = CheckUtil.check(p.getProductId(), "productId", false, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(p.getProductNumber(), "productNumber", false, 9);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(p.getResBonusFlag(), "resBonusFlag", true, 1, "Y",
        // "N");
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(p.getActiveTime(), "activeTime", false, 14);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // } else if (!CheckUtil.check(p.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
        // return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
        // }
        //
        // resultCode = CheckUtil.check(p.getInactiveTime(), "inactiveTime", false, 14);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // } else if (!CheckUtil.check(p.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
        // return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
        // }
        //
        // if (p.getProductExtInfoList() != null) {
        // for (ProductExt o : p.getProductExtInfoList()) {
        // resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        //
        // resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D",
        // "U", "N");
        // if (!ErrorCode.SUCCESS.equals(resultCode)) {
        // return resultCode;
        // }
        // }
        // }
        // }
        // }
    }
}
