package com.ai.baas.bmc.api.priceinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

@Path("/priceinfo")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IPriceInfoSV {
    
    
     /**
      * 标准资费查询接口
      * @param QueryInfoParams
      * @return BMC-000000成功；其他失败
      * @throws BusinessException
      * @throws SystemException
      * @author wangkai16
      * @ApiCode BaaS-00002
      * @RestRelativeURL priceinfo/getPriceInfo
      */
    @POST
    @Path("/getPriceInfo")
     public ResponseMessage getPriceInfo(QueryInfoParams record)throws BusinessException,SystemException;
     @interface GetPriceInfo{}
     
     /**
      * 标准资费更新接口
      * @param StandardPriceInfoParams
      * @return BMC-000000成功；其他失败
      * @throws BusinessException
      * @throws SystemException
      * @author caoyf
      * @ApiCode BaaS-00003
      * @RestRelativeURL priceinfo/updatePriceInfo
      */
     @POST
     @Path("/updatePriceInfo")
     public BaseResponse updatePriceInfo(StandardPriceInfoParams record)throws BusinessException,SystemException;
     @interface UpdatePriceInfo{}
     /**
      * 标准资费删除接口
      * @param StandardPriceInfoParams
      * @return BMC-000000成功；其他失败
      * @throws BusinessException
      * @throws SystemException
      * @author caoyf
      * @ApiCode BaaS-00003
      * @RestRelativeURL priceinfo/deletePriceInfo
      */
     @POST
     @Path("/deletePriceInfo")
     public BaseResponse deletePriceInfo(StandardPriceInfoParams record)throws BusinessException,SystemException;
     @interface DeletePriceInfo{}
}
