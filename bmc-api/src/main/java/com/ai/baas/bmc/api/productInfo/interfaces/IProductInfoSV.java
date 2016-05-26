package com.ai.baas.bmc.api.productInfo.interfaces;

import com.ai.baas.bmc.api.productInfo.params.ProductInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 *产品信息dubbo服务<br>
 * Date: 2015年10月28日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author biancx
 */
public interface IProductInfoSV {

	 /**
     * 将产品资料表的基本信息同步插入到计费域对应的表中
     * 
     * @param user 客户信息表对应的json串
     *节点名称  			        节点编码     			是否必选			类型       				说明 
     *产品编码              		  productId         Y             VARCHAR(32) 			产品编码
     *周期费类型              	  cycleFeeTpye      N             VARCHAR(32) 			MONTH,YEAR,DAY
     *周期费                  		  cycleFee          N             NUMBER(32)  			单位厘，周期费用（月租费，年租费，天） 
     *产品包列表             	  packgeList                      list        
     *包内额度                		  amount            Y             NUMBER(32)  			包内额度
     *单位编码                                     unitCode          Y             VARCHAR(32) 			对应额度的单位的编码：MB：MB,KB：KB,S：秒,60S：60秒,TIME：次,ITEM：条
     *单位类型                                     unitType          Y             VARCHAR(32) 			对应额度的单位的类型：STREAM-流量,DURATION-时长,TIMES-次数,ITEMS-条数
     *参考因素                                     factorCode        *             VARCHAR(10) 			适用的业务记录的过滤条件，只要满足参考因素的记录才用该套餐包计费；0个或者多个参考因素
     *名称                                              Factor_name       Y             VARCHAR(10) 			缺省长市漫，取值参考：参考因素定义表
     *值                                                  Factor_value      Y             VARCHAR(10) 			缺省长市漫，取值参考：参考因素定义表
     *超出后计费类型                       exceedType        N             VARCHAR(10) 			D：单价；T：透支
     *单价资费编码                           unitpriceCode     N             VARCHAR(10) 			超出之后为单价时需要填写，通过单价产品信息接口传入
     *清零标识                                    resClearFlag      N             VARCHAR(1)  			标识该产品的资源是否定期清零。取值：Y:清零；N-不清零。如果【用户订购信息接口】填写该字段，则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
     *清零周期                                    resClearCycle     N             VARCHAR(1)  			与清零标识联用
     *赠送标识                                    resBonusFlag      N             VARCHAR(1)  			标识该产品是否为一个赠送的产品。取值：Y:是赠送；N-不是赠送。如果【用户订购信息接口】填写该字段，则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
     *资源有效期结束类型             resEndType        N             VARCHAR(32) 
     *资费自定义标识                      defineFlag        N             varchar(1)  			标识，该产品的资源额度是否由客户自行定义。Y-自定义；N-不自定义。选择Y，则调用资源订购实例接口，把自定义的资源量传入
     *初始计费方式                           billingType       N             VARCHAR(32) 			取值：HALF：半月套餐方式,FULL：全月套餐方式,OUTP：套外资费方式,PDAY：首月按天收取
     *优惠类型                                   disItem           N             VARCHAR(6)  			取值：1：总费用优惠；如果【用户订购信息接口】填写该字段，则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
     *优惠方式                                   disType           N             VARCHAR(6)  			与优惠类型联用，取值：RET：返还,DIS：折扣
     *优惠值类型                               disValueType      N             varchar(6)  			与优惠类型联用。取值：USGP：使用量的百分比,FIX：固定值
     *优惠值                                        disValue          N             number(14,3)			与优惠类型联用
     *生效日期                                   activeTime        Y             VARCHAR(14) 			YYYYMMDDHH24MISS
     *失效日期                                   inactiveTime      Y             VARCHAR(14) 			YYYYMMDDHH24MISS
     *套餐原始费用                          orginFee          N             VARCHAR(10) 
     *套餐优惠后费用                      discountFee       N             VARCHAR(10) 
     *租户ID           tenancyId         Y             VARCHAR(32) 
     *系统ID           systemId          Y             VARCHAR(32) 
     *消息流水                                     msgSeq                          VARCHAR(32) 


     * @return BMC-000000成功；BMC-000001:单价没有定义
     * @throws CallerException
     * @author biancx 
     * @ApiCode CTP-0004
     */
	public String productNotify(String product) throws BusinessException,SystemException;
	
    /**
     * 套餐包产品信息接口
     * @param paramInfo
     * @return CTP-000000成功；其他失败
     * @throws CallerException
     * @author wangkai16
     * @ApiDocMethod
     *  @ApiCode CTP-S001
     */
	public String productNotify(ProductInfoParams product) throws BusinessException,SystemException;
	
	
}
