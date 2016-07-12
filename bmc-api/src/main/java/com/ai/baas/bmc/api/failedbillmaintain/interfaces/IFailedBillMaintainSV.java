package com.ai.baas.bmc.api.failedbillmaintain.interfaces;

import com.ai.baas.bmc.api.failedbillmaintain.params.*;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by xin on 16-4-11.
 */
@Path("/failedbillmaintain")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IFailedBillMaintainSV {

    /**
     * 查询错单
     *
     * @param criteria
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00001
     * @RestRelativeURL failedbillmaintain/queryFailedBills
     */
    @POST
    @Path("/queryFailedBills")
    FailedBillPagerResponse queryFailedBills(FailedBillCriteria criteria);

    /**
     * 查询单个错单
     *
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00002
     * @RestRelativeURL failedbillmaintain/queryFailedBillsById
     */
    @POST
    @Path("/queryFailedBillsById")
    FailedBillResponse queryFailedBillsById(FailedBillParam param);


    /**
     * 重发单个错单
     *
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00003
     * @RestRelativeURL failedbillmaintain/resendFailedBill
     */
    @POST
    @Path("/resendFailedBill")
    BaseResponse resendFailedBill(FailedBillParam param);


    /**
     * 批量重发错单
     *
     * @param params
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00003
     * @RestRelativeURL failedbillmaintain/batchResendFailedBill
     */
    @POST
    @Path("/batchResendFailedBill")
    BaseResponse batchResendFailedBill(List<FailedBillParam> params);

}
