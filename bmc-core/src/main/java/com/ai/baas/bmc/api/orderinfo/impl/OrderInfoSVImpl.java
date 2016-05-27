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
import com.ai.baas.bmc.util.CheckUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service(validation = "true")
@Component
public class OrderInfoSVImpl implements IOrderInfoSV {
    @Autowired
    private IOrderinfoBusiness business;

    @Override
    public BaseResponse orderInfo(OrderInfoParams record)throws BusinessException, SystemException {

        BaseResponse resultParams = new BaseResponse();
        String resultCode = null;
        // 入参检验
        
        if(StringUtil.isBlank( record.getTenantId())) {
            resultParams.setResponseHeader(new ResponseHeader(false,"000001","TenantId不能为空"));
            return resultParams;
        } 
    
       resultCode = CheckUtil.check(record.getUsetype(), "usetype", false, 32, "Test", "Normal");
       if (!ErrorCode.SUCCESS.equals(resultCode)) {
           resultParams.setResponseHeader(new ResponseHeader(false,"000001","useType字段有误，取值范围：Test,Normal"));
           return resultParams;
       }

       resultCode = CheckUtil.check(record.getState(), "state", true, 32, "Normal", "Stop",
              "Cancel");
       if (!ErrorCode.SUCCESS.equals(resultCode)) {
           resultParams.setResponseHeader(new ResponseHeader(false,"000001","state字段有误，取值范围：Normal，Stop"));
           return resultParams;
       }


//
//      resultCode = CheckUtil.check(record.getCityCode(), "cityCode", true, 6);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getChlId(), "chlId", true, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getDevId(), "devId", true, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getActiveTime(), "activeTime", false, 14);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      } else if (!CheckUtil.check(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//          return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
//      }
//
//      resultCode = CheckUtil.check(record.getInactiveTime(), "inactiveTime", false, 14);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      } else if (!CheckUtil.check(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//          return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
//      }

//      if (record.getOrderExtInfo() != null) {
//          for (OrderExt o : record.getOrderExtInfo()) {
//              resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U",
//                      "N");
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//          }
//      }
//      resultCode = CheckUtil.check(record.getRemark(), "remark", true, 1024);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      if (record.getProductList() != null) {
//          for (Product p : record.getProductList()) {
//              resultCode = CheckUtil.check(p.getProductId(), "productId", false, 32);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getProductNumber(), "productNumber", false, 9);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getResBonusFlag(), "resBonusFlag", true, 1, "Y",
//                      "N");
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getActiveTime(), "activeTime", false, 14);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              } else if (!CheckUtil.check(p.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//                  return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
//              }
//
//              resultCode = CheckUtil.check(p.getInactiveTime(), "inactiveTime", false, 14);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              } else if (!CheckUtil.check(p.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//                  return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
//              }
//
//              if (p.getProductExtInfoList() != null) {
//                  for (ProductExt o : p.getProductExtInfoList()) {
//                      resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//
//                      resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//
//                      resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D",
//                              "U", "N");
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//                  }
//              }
//          }
//      }
        
        
        if(record.getOrderExtInfo()!=null){
            if(record.getOrderExtInfo().size()!=0){
                List<OrderExt> orderExtList = record.getOrderExtInfo();
                for(OrderExt oe : orderExtList ){
                    if(StringUtil.isBlank(oe.getExtName())||StringUtil.isBlank(oe.getExtValue())||StringUtil.isBlank(oe.getUpdateFlag())){
                        resultParams.setResponseHeader(new ResponseHeader(false,"000001","订购扩展信息中的参数不能为空"));
                        return resultParams;
                    }   
                }
            }
        }
        if(record.getProductList()!=null){
            if(record.getProductList().size()!=0){
                List<Product>productList = record.getProductList();
                for(Product pt:productList){
                    if(StringUtil.isBlank(pt.getActiveTime())||StringUtil.isBlank(pt.getInactiveTime())||StringUtil.isBlank(pt.getProductId())||StringUtil.isBlank(pt.getProductType())||pt.getProductNumber()==null){
                        resultParams.setResponseHeader(new ResponseHeader(false,"000001","产品列表中的参数不能为空"));
                        return resultParams;
                    }
                    
                    if((pt.getProductType().equals("bill"))&&pt.getProductNumber()!=1){
                        resultParams.setResponseHeader(new ResponseHeader(false,"000001","订购账单产品ProductNumber必须为1,订购失败"));
                        return resultParams;
                    }
                    
                    if(pt.getSubsProductId()!=null&&pt.getProductNumber()!=1){
                        resultParams.setResponseHeader(new ResponseHeader(false,"000001","传入subsProductId时，订购账单产品的ProductNumber必须为1,订购失败"));
                        return resultParams;
                    }
                    
                    if(!pt.getProductType().equals("bill")&&!pt.getProductType().equals("dr")){
                        resultParams.setResponseHeader(new ResponseHeader(false,"000001","订购账单产品productType必须为dr或bill,订购失败"));
                        return resultParams;
                    }
                    
                }
            }
        }
        // 通过共享内存获得内部的custId
        Map<String, String> params = new TreeMap<String, String>();
        params.put("ext_cust_id", record.getExtCustId());
        params.put("tenant_id", record.getTenantId());
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_custinfo").where(params)
                .executeQuery(DshmUtil.getCacheClient());
        // 获得对应的内部的custId
        
        String custId = null;
        System.err.println("map"+JSON.toJSONString(result));
        // 循环获得第一条非空的数据
        for (Map<String, String> r : result) {
            if (!r.isEmpty()) {
                custId = r.get("cust_id");
                break;
            }
        }
        
        if(StringUtil.isBlank(custId)){
            LoggerUtil.log.debug("内存查custId未找到，EXT_CUST_ID为" + record.getExtCustId());
            resultParams.setResponseHeader(new ResponseHeader(false, "000001", "客户ID不存在23333, EXT_CUST_ID为" + record.getExtCustId()));
            return resultParams;
        }
        System.err.println("获得cust_id : "+custId);
        LoggerUtil.log.debug("获得cust_id:" + custId);
        LoggerUtil.log.debug("校验成功！");
        
        // 幂等性判断（判重）
        try {
            if (business.hasSeq(record)) {
                resultParams.setResponseHeader(new ResponseHeader(false, "000001", "tradeSeq已存在"));
                return resultParams;
            }
        } catch (IOException e) {
            LoggerUtil.log.error(e);
            resultParams.setResponseHeader(new ResponseHeader(false, "000001", "幂等性判断失败"));
            return resultParams;
        }
        //判断产品是否存在
        if(business.checkProduct(record)){
        }
        
        // 写入MySQL表中
        try {
            business.writeData(record, custId);
        } catch (BusinessException e) {
            resultParams.setResponseHeader(new ResponseHeader(false, "000001", e.getErrorCode() + e.getErrorMessage()));
            return resultParams;
        }
        resultParams.setResponseHeader(new ResponseHeader(true, "000000", "成功"));
        return resultParams;
    }

    public static void main(String[] args) {
        
//      LoggerUtil.log.debug("入参：" + MyJsonUtil.toJson(record));  
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getTenantId(), "tenantId", false, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getExtCustId(), "extCustId", false, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getUsetype(), "usetype", false, 32, "Test", "Normal");
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getState(), "state", true, 32, "Normal", "Stop",
//              "Cancel");
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getServiceId(), "serviceId", false, 64);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getOrderTime(), "orderTime", true, 14);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      } else if (!CheckUtil.check(record.getOrderTime(), DateUtil.YYYYMMDDHHMMSS)) {
//          return ErrorCode.UNFORMATE + ":orderTime格式YYYYMMDDHH24MISS";
//      }
//
//      resultCode = CheckUtil.check(record.getProvinceCode(), "provinceCode", true, 6);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getCityCode(), "cityCode", true, 6);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getChlId(), "chlId", true, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getDevId(), "devId", true, 32);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      resultCode = CheckUtil.check(record.getActiveTime(), "activeTime", false, 14);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      } else if (!CheckUtil.check(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//          return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
//      }
//
//      resultCode = CheckUtil.check(record.getInactiveTime(), "inactiveTime", false, 14);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      } else if (!CheckUtil.check(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//          return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
//      }

//      if (record.getOrderExtInfo() != null) {
//          for (OrderExt o : record.getOrderExtInfo()) {
//              resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D", "U",
//                      "N");
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//          }
//      }
//      resultCode = CheckUtil.check(record.getRemark(), "remark", true, 1024);
//      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//          return resultCode;
//      }
//
//      if (record.getProductList() != null) {
//          for (Product p : record.getProductList()) {
//              resultCode = CheckUtil.check(p.getProductId(), "productId", false, 32);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getProductNumber(), "productNumber", false, 9);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getResBonusFlag(), "resBonusFlag", true, 1, "Y",
//                      "N");
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              }
//
//              resultCode = CheckUtil.check(p.getActiveTime(), "activeTime", false, 14);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              } else if (!CheckUtil.check(p.getActiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//                  return ErrorCode.UNFORMATE + ":activeTime格式YYYYMMDDHH24MISS";
//              }
//
//              resultCode = CheckUtil.check(p.getInactiveTime(), "inactiveTime", false, 14);
//              if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                  return resultCode;
//              } else if (!CheckUtil.check(p.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS)) {
//                  return ErrorCode.UNFORMATE + ":inactiveTime格式YYYYMMDDHH24MISS";
//              }
//
//              if (p.getProductExtInfoList() != null) {
//                  for (ProductExt o : p.getProductExtInfoList()) {
//                      resultCode = CheckUtil.check(o.getExtName(), "extName", false, 32);
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//
//                      resultCode = CheckUtil.check(o.getExtValue(), "extValue", false, 64);
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//
//                      resultCode = CheckUtil.check(o.getUpdateFlag(), "updateFlag", false, 1, "D",
//                              "U", "N");
//                      if (!ErrorCode.SUCCESS.equals(resultCode)) {
//                          return resultCode;
//                      }
//                  }
//              }
//          }
//      }
    }
}
