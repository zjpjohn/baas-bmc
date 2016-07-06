package com.ai.baas.bmc.api.baseInfo.params;



import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.baseInfo.interfaces.IBaseInfoSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 基本信息查询入参
 *
 * Date: 2016年3月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class QueryInfoParams extends BaseInfo{

	private static final long serialVersionUID = 1L;
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotBlank(message="消息流水号不能为空",groups = { IBaseInfoSV.GetBaseInfo.class })
	private String tradeSeq;
	/**
	 *参数类型<br>
	 *取值范围：UNIT：单位参数，WEIGHT_UNIT：重量单位，DISTANCE_UNIT：距离单位，TIME_UNIT：时间单位，AREA_UNIT：面积单位，VOLUME_UNIT：体积单位，DATA_UNIT：数据存储单位，SEAT_UNIT：坐席单位<br>
	 */
	@NotBlank(message="参数类型不能为空",groups = { IBaseInfoSV.GetBaseInfo.class })
	private String paramType;
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	

}
