package com.ai.baas.bmc.api.drmanager.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.drmanager.parameters.BillQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.BillQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryOutputObject;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryInputObject;
import com.ai.baas.bmc.api.drmanager.parameters.UseQueryOutputObject;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

/**
 * 详单查询服务接口：Runner-BMC<br>
 * Date: 2015年10月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *  
 * @author zhanghy6
 */
@Path("/drQuery")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IDrQuery
{
    /**
     * 详单查询<br>
     * 
     * @param param 内容为json串 具体内容如下:<br>
     * 请求报文体：<br>		
     *	节点名称			父节点编码	节点编码	是否必选	类型	说明	<br>				
	 *	租户ID			DrQuery	tenantId			Y				VARCHAR(32)<br>	                                                   
	 *	系统ID			DrQuery	systemId			Y				VARCHAR(32)	 <br>                                                  
	 *	消息流水			DrQuery	msgSeq				Y				VARCHAR(32)<br>	                                                   
	 *	客户ID			DrQuery	custId				Y				VARCHAR(32)<br>	                                                     
	 *	用户订购标识		DrQuery	subsId				N				VARCHAR(32)	                                               
	 *	服务号码			DrQuery	serviceNum			N				VARCHAR(32)	电信行业使用                                   
	 *	业务类型			DrQuery	serviceType			Y				VARCHAR(32)	业务类型：voice 语音;sm 短信;data 流量;va  增值
	 *	页码				DrQuery	pageNum				N				VARCHAR(32)	页码                                                   
     *  每页条数			DrQuery	pagecountNum		N				VARCHAR(32)	每页条数                                     
     *  开始时间			DrQuery	beginDate			N				VARCHAR(14)	                                                 
     *  结束时间			DrQuery	endDate				N				VARCHAR(14)
     * 
     *  举例如下:
	 *	{  
	 *		"DrQuery": {
	 *			"tenantId": "bmct1",
	 *			"systemId": "bmcs1",
	 *			"msgSeq": "001",
	 *			"custId": "aaa",
	 *			"subsId": "aaa",
	 *			"serviceNum": "aaa",
     *  		"serviceType": "1",
     *  		"pageNum": "1",
     *  		"pagecountNum": "20",
	 *			"beginDate": "20151010000000",
	 *			"endDate": "20151010235959"
	 *	  }
	 *	}    
	 *                                            
     * @return 查询返回json串 
     * 返回报文体：	
     *	节点名称			父节点名称				节点名称			是否必选	类型				说明
	 *  返回码			responseMessage		returnCode			Y					VARCHAR(14)	BMC-000000成功；其他失败
	 *  租户ID			responseMessage		tenantId			Y					VARCHAR(32)	
	 *  系统ID			responseMessage		systemId			Y					VARCHAR(32)	
	 *  消息流水			responseMessage		msgSeq				Y					VARCHAR(32)	
	 *  客户ID			responseMessage		custId				Y					VARCHAR(32)	
	 *  用户订购标识		responseMessage		subsId				Y					VARCHAR(32)	
	 *  服务号码			responseMessage		serviceNum			N					VARCHAR(32)	电信行业使用
	 *  业务类型			responseMessage		serviceType			Y					VARCHAR(32)	业务类型：voice 语音;sm 短信;data 流量;va  增值
	 *  详单				responseMessage		drList									list	
	 *  产品ID			drList				productId			N					VARCHAR(10)	等于【套餐包产品信息接口】中的产品编码
	 *  漫游类型			drList				roamType			N					VARCHAR(10)	漫游类型
	 *  长途类型			drList				longType			N					VARCHAR(10)	长途类型
	 *  费用				drList				FEE					N					VARCHAR(32)	单位：厘
	 *  通讯地点			drList				visitArea			N					VARCHAR(18)	中文
	 *  上行流量			drList				upStream			N					VARCHAR(32)	单位：字节
	 *  下行流量			drList				downStream			N					VARCHAR(32)	单位：字节
	 *  开始时间			drList				beganTime			Y					VARCHAR(14)	
	 *  时长 			drList				duration			N					VARCHAR(32)	单位：秒
	 *  当前页码			responseMessage		pageNum				N					VARCHAR(32)	当前页码
	 *  总页码			responseMessage		totalcount			N					VARCHAR(32)	总条数
	 *
	 * 举例如下:
	 *	{  
	 *		"responseMessage": {
	 *			"returnCode": "BMC-000000",
	 *			"tenantId": "bmct1",
	 *			"systemId": "bmcs1",
	 *			"msgSeq": "001",
	 *			"custId": "aaa",
	 *			"subsId": "aaa",
	 *			"serviceNum": "aaa",
     *  		"serviceType": "1",
     *			"drList": [
     *					{"productId": "XXproductId1","roamType":"XXroamType1","longType":"XXlongType1","FEE":"100","visitArea":"XXvisitArea1",
     *							"upStream":"XXupStream1","downStream":"XXdownStream1","beganTime":"XXbeganTime1","duration":"2000"},
     *					{"productId": "XXproductId2","roamType":"XXroamType2","longType":"XXlongType2","FEE":"140","visitArea":"XXvisitArea2",
     *							"upStream":"XXupStream2","downStream":"XXdownStream2","beganTime":"XXbeganTime1","duration":"500"},
     *					{"productId": "XXproductId3","roamType":"XXroamType3","longType":"XXlongType3","FEE":"160","visitArea":"XXvisitArea3",
     *							"upStream":"XXupStream3","downStream":"XXdownStream2","beganTime":"XXbeganTime2","duration":"30"}		 *
     *			],
     *  		"pageNum": "1",
     *  		"totalcount": "100"
	 *	  	}
	 *	}    
	 *
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0001
     * @RestRelativeURL drQuery/drQuery
     */
	 @POST
	 @Path("/drQuery")
	public String drQuery(String param) throws BusinessException,SystemException;
	
    /**
     * 详单查询 对象方法
     * 
     * @param drObject 
     * 定义见DrQueryInputObject 或者参见 BMC-0001接口[String drQuery(String param)] 
     * @return DrQueryOutputObject
     *	定义见 DrQueryOutputObject类 或者参见 BMC-0001接口[String billQuery(String param)]
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode BMC-0002
     * @RestRelativeURL drQuery/drQueryObj
     */
	 @POST
	 @Path("/drQueryObj")
	public DrQueryOutputObject drQueryObj(DrQueryInputObject drObject) throws BusinessException,SystemException;
	
    /**
     * 账单查询
     * 
     * @param param 输入json串
     * 请求报文体：
     *	节点名称		父节点编码	节点编码			是否必选			类型			说明
     *	租户ID		BillQuery	tenantId		Y				VARCHAR(32)	
     *	系统ID		BillQuery	systemId		Y				VARCHAR(32)	
     *	消息流水		BillQuery	msgSeq			Y				VARCHAR(32)	
     *	客户ID		BillQuery	custId			Y				VARCHAR(32)	
     *	用户订购标识	BillQuery	subsId			Y				VARCHAR(32)	
	 *	服务号码		BillQuery	serviceNum		N				VARCHAR(32)	电信行业使用
	 *	页码			BillQuery	pageNum			N				VARCHAR(32)	页码
	 *	每页条数		BillQuery	pagecountNum	N				VARCHAR(32)	每页条数
	 *	查询月份		BillQuery	queryMon		N				VARCHAR(14)	查询月份
	 *     
     * @return 查询返回json串 内容如下
	 * 返回报文体：
     *	节点名称			父节点编码			节点编码			是否必选			类型				说明
     *  返回码			responseMessage	returnCode			Y				VARCHAR(14)	BMC-000000成功；其他失败
     *  租户ID			responseMessage	tenantId			Y				VARCHAR(32)	                          
     *  系统ID			responseMessage	systemId			Y				VARCHAR(32)	                          
     *  消息流水			responseMessage	msgSeq				Y				VARCHAR(32)	                          
     *  客户ID			responseMessage	custId				Y				VARCHAR(32)	                            
     *  用户列表			responseMessage	sublist								List	                                
     *  用户订购标识		sublist			subsId				Y				VARCHAR(32)	                              
     *  优惠费用			sublist			disFee				N				NUMBER(32)	单位：厘                          
     *  调整费用			sublist			adjustFee			N				NUMBER(32)	单位：厘                        
     *  总费用			sublist			totalfee			Y				NUMBER(32)	单位：厘                          
     *  账单明细			sublist			subjcetDetails		*				List	                                
     *  科目				subjcetDetails	subjectId			Y				NUMBER(32)	按服务方约定填写            
     *  科目优惠费用		subjcetDetails	subjectAisFee		N				NUMBER(32)	单位：厘        
     *  科目调整费用		subjcetDetails	subjcetAdjustFee	N				NUMBER(32)	单位：厘    
     *  科目费用			subjcetDetails	subjectfee			Y				NUMBER(32)	单位：厘              
     *  当前页码			subjcetDetails	pageNum				N				VARCHAR(32)	当前页码                  
     *  总页码			responseMessage	totalcount			N				VARCHAR(32)	总条数                  
     *  查询月份			responseMessage	queryMon			N				VARCHAR(14)	查询月份
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0003
     * @RestRelativeURL drQuery/drQueryObj
     */
	 @POST
	 @Path("/billQuery")
	public String billQuery(String param) throws BusinessException,SystemException;

	/**
     * 账单查询 对象方法
     * @param billObject 
     * 定义见BillQueryInputObject 或者参见 BMC-0003接口[String billQuery(String param)]
     * @return BillQueryOutputObject
     *	定义见 BillQueryOutputObject类 或者参见 BMC-0003接口[String billQuery(String param)]
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0004
     * @RestRelativeURL drQuery/drQueryObj
     */
	 @POST
	 @Path("/billQueryObj")
	public BillQueryOutputObject billQueryObj(BillQueryInputObject billObject) throws BusinessException,SystemException;
	
    /**
     * 使用量查询
     * 请求报文体：
     * @param param 输入json串
     * 请求报文体：
     * 节点名称			父节点编码			节点编码			是否必选			类型	说明
     * 租户ID			CurrMonthUsgQuery	tenantId			Y	VARCHAR(32)	
     * 系统ID			CurrMonthUsgQuery	systemId			Y	VARCHAR(32)	
     * 消息流水			CurrMonthUsgQuery	msgSeq				Y	VARCHAR(32)	
     * 客户ID			CurrMonthUsgQuery	custId				Y	VARCHAR(32)	
     * 用户订购标识		CurrMonthUsgQuery	subsId				Y	VARCHAR(32)	
     * 服务号码			CurrMonthUsgQuery	serviceNum			N	VARCHAR(32)	电信行业使用
     * 开始账期			CurrMonthUsgQuery	beginMonth			N	VARCHAR(32)	开始账期
     * 
     * @return 查询返回json串 
     * 返回报文体：
     * 节点名称			父节点名称				节点名称		是否必选	类型			说明                                      
     * 返回码			responseMessage		returnCode			Y	VARCHAR(14)	BMC-000000成功；其他失败                
     * 租户ID			responseMessage		tenantId			Y	VARCHAR(32)	                                          
     * 系统ID			responseMessage		systemId			Y	VARCHAR(32)	                                          
     * 消息流水			responseMessage		msgSeq				Y	VARCHAR(32)	                                          
     * 月份列表			responseMessage		MonthList				List	                                              
     * 开始账期			MonthList			beginMonth			N	VARCHAR(32)	开始账期                                    
     * 客户ID			MonthList			custId				Y	VARCHAR(32)	                                                  
     * 用户列表			MonthList			subList					VARCHAR(32)	                                                
     * 用户订购标识		subList				subsId				Y	VARCHAR(32)	                                              
     * 业务类型			subList				serviceType			Y	VARCHAR(32)	业务类型：voice 语音;sm 短信;data 流量;va  增值
     * 服务号码			subList				serviceNum			N	VARCHAR(32)	电信行业使用                                  
     * 产品ID			subList				productId			N	VARCHAR(32)	等于【套餐包产品信息接口】中的产品编码            
     * 漫游地			subList				visitArea				VARCHAR(32)	漫游地：本地、国内、国外                          
     * 资源类型			subList				resType				N	VARCHAR(32)	取值：DATA：流量；                                
     * 使用量			subList				amount				N	VARCHAR(18)	单位：字节                                          
     * 产品额度			subList				productAmount		N	VARCHAR(18)	流量单位：字节 ，语音：分钟                     
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0005
     * @RestRelativeURL drQuery/useQuantityQuery
     */
	 @POST
	 @Path("/useQuantityQuery")
	public String useQuantityQuery(String param) throws BusinessException,SystemException;

	/**
     * 使用量查询 
     * @param useObject 
     * 定义见UseQueryInputObject 或者参见 BMC-0005接口[String useQuantityQuery(String param)] 
     * @return UseQueryOutputObject
     *	定义见 UseQueryOutputObject类 或者参见 BMC-0005接口[String useQuantityQuery(String param)] 
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0006
     * @RestRelativeURL drQuery/useQuantityQueryObj
     */
	 @POST
	 @Path("/useQuantityQueryObj")
	public UseQueryOutputObject useQuantityQueryObj(UseQueryInputObject useObject) throws BusinessException,SystemException;
	
    /**
     * 运营商流量使用查询
     * 
     * @param param 输入json串
     *请求报文体：
     * 节点名称		父节点编码			节点编码		是否必选	类型			说明
     * 租户ID		dealerDataUsgQuery	tenantId	Y		VARCHAR(32)	
     * 系统ID		dealerDataUsgQuery	systemId	Y		VARCHAR(32)	
     * 消息流水		dealerDataUsgQuery	msgSeq		Y		VARCHAR(32)	
     * 运营商编码	dealerDataUsgQuery	dealerCode	N		VARCHAR(1)	取值：0：联通；1-电信；2：移动
     * 
     * @return 查询返回json串
     * 返回报文体：
     * 节点名称		父节点名称		节点名称		是否必选		类型			说明                                      
     * 返回码		responseMessage	returnCode	Y		VARCHAR(14)		BMC-000000成功；其他失败
     * 租户ID		responseMessage	tenantId	Y		VARCHAR(32)	
     * 系统ID		responseMessage	systemId	Y		VARCHAR(32)	
     * 消息流水		responseMessage	msgSeq		Y		VARCHAR(32)	
     * 运营商编码	responseMessage	dealerCode	N		VARCHAR(1)		取值：0：联通；1-电信；2：移动
     * 流量			responseMessage	amount		N		NUMBER(32)		单位：字节
	 *
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0007
     * @RestRelativeURL drQuery/operatorFlowQuery
     */
	 @POST
	 @Path("/operatorFlowQuery")
	public String operatorFlowQuery(String param) throws BusinessException,SystemException;	
	

	/**
     * 运营商流量使用查询 对象方法
     * @param operatorFlowObject 
     * 定义见OperatorFlowQueryInputObject 或者参见 BMC-0007接口[String operatorFlowQuery(String param)] &lt;br&gt;
     * @return OperatorFlowQueryOutputObject
     *	定义见 OperatorFlowQueryOutputObject类 或者参见 BMC-0007接口[String operatorFlowQuery(String param)] 
     * @author zhanghy6
     * @ApiDocMethod
     * @ApiCode BMC-0008
     * @RestRelativeURL drQuery/operatorFlowQueryObj
     */
	 @POST
	 @Path("/operatorFlowQueryObj")
	public OperatorFlowQueryOutputObject operatorFlowQueryObj(OperatorFlowQueryInputObject operatorFlowObject) throws BusinessException,SystemException;
	
}
