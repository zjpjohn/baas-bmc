package com.ai.baas.bmc.api.orderinfo.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;
import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConBlCustinfo;
import com.ai.baas.bmc.util.CheckUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation="true")
@Component
public class OrderInfoSVImpl implements IOrderInfoSV {
    @Autowired
    private IOrderinfoBusiness business;

    @Override
    public String orderInfo(OrderInfoParams record) {
        //入参检验
        if (record == null) {
            return ErrorCode.NULL + ":入参不能为空";
        }
        LoggerUtil.log.debug("入参："+MyJsonUtil.toJson(record));

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
            return ErrorCode.UNFORMATE + ":orderTime格式YYYYMMDDHH24MISS";
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
            return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
        }

        resultCode = CheckUtil.check(record.getInactiveTime(), "inactiveTime", false, 14);
        if (!ErrorCode.SUCCESS.equals(resultCode)) {
            return resultCode;
        }else if(!CheckUtil.check(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)){
            return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
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
                    return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
                }
                
                resultCode = CheckUtil.check(p.getInactiveTime(), "inactiveTime", false, 14);
                if (!ErrorCode.SUCCESS.equals(resultCode)) {
                    return resultCode;
                }else if(!CheckUtil.check(p.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)){
                    return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
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
        // 通过共享内存获得内部的custId
        Map<String, String> params = new TreeMap<String, String>();
        params.put(ConBlCustinfo.EXT_CUST_ID, record.getExtCustId());
        List<Map<String, String>> result =  DshmUtil.getDshmread().list(TableCon.BL_CUSTINFO).where(params)
                .executeQuery();
        // 获得对应的内部的custId
        if (result == null || result.isEmpty()) {
            LoggerUtil.log.debug("内存查custId未找到，EXT_CUST_ID为" + record.getExtCustId());
            return ErrorCode.NULL + ":客户不存在";
        }
        String custIds[] = result.get(0).get(ConBlCustinfo.CUST_ID).split("#");
        String custId = custIds[custIds.length - 1];
//        String custId = record.getExtCustId();
        LoggerUtil.log.debug("校验成功！");
        //幂等性判断（判重）
        try {
            if(business.hasSeq(record)){
                return "tradeSeq已存在";
            }
        } catch (IOException e) {
            LoggerUtil.log.error(e.getStackTrace());
            return "幂等性判断判断失败请联系管理员";
        }
        //写入mysql表中
        try {
            business.writeData(record,custId);
        } catch (BusinessException e){
            return e.getErrorCode() + e.getErrorMessage();
        } 
//        catch (Exception e1) {
//            return "请联系管理员";
//        }
        
        return ErrorCode.SUCCESS;
    }

    public static void main(String[] args) {
    }
}
