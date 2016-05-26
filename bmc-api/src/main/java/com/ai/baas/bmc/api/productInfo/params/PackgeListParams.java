package com.ai.baas.bmc.api.productInfo.params;

import java.io.Serializable;
import java.util.List;

import com.ai.baas.bmc.api.productInfo.params.FactorCodeListParams;

/**
 * 客户基本信息.<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author biancx
 */
public class PackgeListParams implements Serializable{
	   private static final long serialVersionUID = 1L;
	/**
	 * 包内额度
	 */
	private Long amount;
	/**
	 * 单位编码对应额度的单位的编码：
	 *  MB：MB
	 *	KB：KB
	 *	S：秒
	 *	60S：60秒
	 *	TIME：次
	 *	ITEM：条
	 */
	private String unitCode;
	/**
	 * 单位类型
	 * 对应额度的单位的类型：
	 *	STREAM-流量
	 *	DURATION-时长
	 *	TIMES-次数
	 *	ITEMS-条数
	*/
	private String unitType;
	/**
	 * 参考因素   适用的业务记录的过滤条件，只要满足参考因素的记录才用该套餐包计费；0个或者多个参考因素
	 */
	private List<FactorCodeListParams> factorCode;

	/**
	 * 超出后计费类型  D：单价；T：透支
	 */
	private String exceedType;
	/**
	 * 单价资费编码  超出之后为单价时需要填写，通过单价产品信息接口传入
	 */
	private String unitpriceCode ;
	/**
	 * 清零标识 标识该产品的资源是否定期清零。取值：Y:清零；N-不清零。
	 * 如果【用户订购信息接口】填写该字段，则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
	 */
	private String resClearFlag;
	/**
	 * 清零周期       与清零标识联用
	 */
	private String resClearCycle;
	/**
	 * 赠送标识       标识该产品是否为一个赠送的产品。取值：Y:是赠送；N-不是赠送。如果【用户订购信息接口】填写该字段，
	 * 则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
	 */
	private String resBonusFlag;
	/**
	 * 资源有效期结束类型
	 */
	private String resEndType;
	/**
	 * 资费自定义标识       标识，该产品的资源额度是否由客户自行定义。Y-自定义；N-不自定义。选择Y，则调用资源订购实例接口，把自定义的资源量传入 
	 */
	private String defineFlag;
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getUnitCode() {
		return unitCode==null?null:unitCode.trim();
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitType() {
		return unitType==null?null:unitType.trim();
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public List<FactorCodeListParams> getFactorCode() {
		return factorCode;
	}
	public void setFactorCode(List<FactorCodeListParams> factorCode) {
		this.factorCode = factorCode;
	}

	public String getExceedType() {
		return exceedType;
	}
	public void setExceedType(String exceedType) {
		this.exceedType = exceedType;
	}
	public String getUnitpriceCode() {
		return unitpriceCode;
	}
	public void setUnitpriceCode(String unitpriceCode) {
		this.unitpriceCode = unitpriceCode;
	}
	public String getResClearFlag() {
		return resClearFlag;
	}
	public void setResClearFlag(String resClearFlag) {
		this.resClearFlag = resClearFlag;
	}
	public String getResClearCycle() {
		return resClearCycle;
	}
	public void setResClearCycle(String resClearCycle) {
		this.resClearCycle = resClearCycle;
	}
	public String getResBonusFlag() {
		return resBonusFlag;
	}
	public void setResBonusFlag(String resBonusFlag) {
		this.resBonusFlag = resBonusFlag;
	}
	public String getResEndType() {
		return resEndType;
	}
	public void setResEndType(String resEndType) {
		this.resEndType = resEndType;
	}
	public String getDefineFlag() {
		return defineFlag;
	}
	public void setDefineFlag(String defineFlag) {
		this.defineFlag = defineFlag;
	}
	
}