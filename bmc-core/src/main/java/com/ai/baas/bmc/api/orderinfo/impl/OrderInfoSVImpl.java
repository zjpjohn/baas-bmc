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
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderInfoSVImpl implements IOrderInfoSV {
    @Autowired
    private IOrderinfoBusiness business;

    @Override
    public String orderInfo(OrderInfoParams record) {
        //入参检验
        if (record == null) {
            return ErrorCode.NULL + "入参不能为空";
        }

        String resultCode = check(record.getTradeSeq(), "tradeSeq", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getTenantId(), "tenantId", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getExtCustId(), "extCustId", false, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getUsetype(), "usetype", false, 32, "Test", "Normal");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getState(), "state", true, 32, "Normal", "Stop", "Cancel");
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getServiceId(), "serviceId", false, 64);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getOrderTime(), "orderTime", true, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getProvinceCode(), "provinceCode", true, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getCityCode(), "cityCode", true, 6);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getChlId(), "chlId", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getDevId(), "devId", true, 32);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getActiveTime(), "activeTime", false, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        resultCode = check(record.getInactiveTime(), "inactiveTime", false, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        if (record.getOrderExtInfo() != null) {
            for (OrderExt o : record.getOrderExtInfo()) {
                resultCode = check(o.getExtName(), "extName", false, 32);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }

                resultCode = check(o.getExtValue(), "extValue", false, 64);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }

                resultCode = check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U", "N");
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
            }
        }
        
        resultCode = check(record.getRemark(), "remark", true, 1024);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }

        if (record.getProductList() != null) {
            for (Product p : record.getProductList()) {
                resultCode = check(p.getProductId(), "productId", false, 32);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = check(p.getProductNumber(), "productNumber", false, 9);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = check(p.getResBonusFlag(), "resBonusFlag", true, 1,"Y","N");
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = check(p.getActiveTime(), "activeTime", false, 14);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                resultCode = check(p.getInactiveTime(), "inactiveTime", false, 14);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }
                
                if (p.getProductExtInfoList() != null) {
                    for (ProductExt o : p.getProductExtInfoList()) {
                        resultCode = check(o.getExtName(), "extName", false, 32);
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }

                        resultCode = check(o.getExtValue(), "extValue", false, 64);
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }

                        resultCode = check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U", "N");
                        if (!ErrorCode.SUCCESS.equals(resultCode)) {
                            return resultCode;
                        }
                    }
                }
            }
        }
        
        //幂等性判断（判重）
        try {
            if(business.hasSeq(record.getTradeSeq())){
                return "tradeSeq已使用";
            }
            
        } catch (IOException e) {
            return e.getMessage();
        }
        
        return ErrorCode.SUCCESS;
    }

    //入参校验，canBeNull为true是可以为空，lenth是最大长度，enums是取值范围，不填是没有取值范围
    private static String check(Object o, String name, boolean canBeNull, int lenth,
            String... enums) {
        if (o == null || "".equals(o.toString())) {
            if (canBeNull) {
                return ErrorCode.SUCCESS;
            }
            return ErrorCode.NULL + name + "不能为空";
        }

        if (o.toString().length() > lenth) {
            return ErrorCode.OVER_LENTH + name + "不能超过" + lenth + "位";
        }

        if (enums == null || enums.length == 0) {
            return ErrorCode.SUCCESS;
        }

        String result = ErrorCode.UNKNOWN + name + "取值范围";
        for (String e : enums) {
            if (e.equals(o.toString())) {
                return ErrorCode.SUCCESS;
            }
            result += e + ",";
        }
        return result;
    }
    
    public static void main(String[] args) {
    }
}
