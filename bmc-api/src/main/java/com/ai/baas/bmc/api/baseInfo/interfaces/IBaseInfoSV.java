package com.ai.baas.bmc.api.baseInfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.ChildeCodeResponse;
import com.ai.baas.bmc.api.baseInfo.params.QueryChildCodeRequest;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
/**
 * 基础数据编码
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
@Path("/baseinfo")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IBaseInfoSV {

	/**
	 * 基础数据编码查询服务
	 * @param param
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00001
	 * @RestRelativeURL baseinfo/getBaseInfo
	 */
    @POST
    @Path("/getBaseInfo")
	BaseCodeInfo getBaseInfo(QueryInfoParams param) throws BusinessException,SystemException;
	@interface GetBaseInfo{}
	/**
	 * 根据parentCode查询编码
	 * @param request
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL baseinfo/getChildCode
	 */
	@POST
    @Path("/getChildCode")
	ChildeCodeResponse getChildCode(QueryChildCodeRequest request) throws BusinessException,SystemException;
	@interface GetChildCode{}
	
}
