package com.ai.baas.bmc.api.orderinfo.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;
import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.util.CheckUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderInfoSVImpl implements IOrderInfoSV {
    @Autowired
    private IOrderinfoBusiness business;

    @Override
    public String orderInfo(OrderInfoParams record) {
        //入参检验
        LoggerUtil.log.debug("入参："+MyJsonUtil.toJson(record));
        if (record == null) {
            return ErrorCode.NULL + "入参不能为空";
        }

        String resultCode = CheckUtil.check(record.getTradeSeq(), "tradeSeq", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getTenantId(), "tenantId", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getExtCustId(), "extCustId", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getUsetype(), "usetype", false, 32, "Test", "Normal");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getState(), "state", true, 32, "Normal", "Stop", "Cancel");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getServiceId(), "serviceId", false, 64);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getOrderTime(), "orderTime", true, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        } else if(!CheckUtil.check(record.getOrderTime(), DateUtil.YYYYMMDDHHMMSS)){
            return ErrorCode.UNFORMATE + "格式YYYYMMDDHH24MISS";
        }

        resultCode = CheckUtil.check(record.getProvinceCode(), "provinceCode", true, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getCityCode(), "cityCode", true, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getChlId(), "chlId", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getDevId(), "devId", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = CheckUtil.check(record.getActiveTime(), "activeTime", false, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        } else if(!CheckUtil.check(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)){
            return ErrorCode.UNFORMATE + "格式YYYYMMDDHH24MISS";
        }

        resultCode = CheckUtil.check(record.getInactiveTime(), "inactiveTime", false, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }else if(!CheckUtil.check(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)){
            return ErrorCode.UNFORMATE + "格式YYYYMMDDHH24MISS";
        }

        if (record.getOrderExtInfo() != null) {
            for (OrderExt o : record.getOrderExtInfo()) {
                resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }

                resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }

                resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U", "N");
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
            }
        }
        
        resultCode = CheckUtil.check(record.getRemark(), "remark", true, 1024);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        if (record.getProductList() != null) {
            for (Product p : record.getProductList()) {
                resultCode = CheckUtil.check(p.getProductId(), "productId", false, 32);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = CheckUtil.check(p.getProductNumber(), "productNumber", false, 9);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = CheckUtil.check(p.getResBonusFlag(), "resBonusFlag", true, 1,"Y","N");
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = CheckUtil.check(p.getActiveTime(), "activeTime", false, 14);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }else if(!CheckUtil.check(p.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)){
                    return ErrorCode.UNFORMATE + "格式YYYYMMDDHH24MISS";
                }
                
                resultCode = CheckUtil.check(p.getInactiveTime(), "inactiveTime", false, 14);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }else if(!CheckUtil.check(p.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)){
                    return ErrorCode.UNFORMATE + "格式YYYYMMDDHH24MISS";
                }
                
                if (p.getProductExtInfoList() != null) {
                    for (ProductExt o : p.getProductExtInfoList()) {
                        resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }

                        resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }

                        resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U", "N");
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }
                    }
                }
            }
        }
        LoggerUtil.log.debug("校验成功！");
        //幂等性判断（判重）
        try {
            if(business.hasSeq(record)){
                return "tradeSeq已使用";
            }
        } catch (IOException e) {
            LoggerUtil.log.error(e.getStackTrace());
            return e.getMessage();
        }
        //写入mysql表中
        business.writeData(record);
        
        return ErrorCode.SUCCESS;
    }

    //入参校验，canBeNull为true是可以为空，lenth是最大长度，enums是取值范围，不填是没有取值范围
    
    public static void main(String[] args) {
    }
}
