package com.ai.baas.bmc.api.priceinfo.interfaces;

import com.ai.baas.bmc.api.priceinfo.params.PriceCode;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;


public interface IPriceInfoSV {
    
    @interface GetPriceInfo{}
     /**
      * 标准资费查询接口
      * @param QueryInfoParams
      * @return PriceCode
      * @throws BusinessException
      * @throws SystemException
      * @author wangkai
      * @ApiCode BaaS-00002
      */
     public PriceCode getPriceInfo(QueryInfoParams record)throws BusinessException,SystemException;
     
     @interface UpdatePriceInfo{}
     /**
      * 标准资费更新接口
      * @param StandardPriceInfoParams
      * @return BMC-000000成功；其他失败
      * @throws BusinessException
      * @throws SystemException
      * @author caoyf
      * @ApiCode BaaS-00003
      */
     public String updatePriceInfo(StandardPriceInfoParams record)throws BusinessException,SystemException;
}
