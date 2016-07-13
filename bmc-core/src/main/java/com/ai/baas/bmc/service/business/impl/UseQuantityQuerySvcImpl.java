package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.drmanager.parameters.UseQueryInputObject;
import com.ai.baas.bmc.dao.interfaces.BmcUseQueryMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQuery;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQueryCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQueryCriteria.Criteria;
import com.ai.baas.bmc.service.business.interfaces.IUseQuantityQuerySvc;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;

@Service
@Transactional
public class UseQuantityQuerySvcImpl implements IUseQuantityQuerySvc{

	private Logger logger = Logger.getLogger(UseQuantityQuerySvcImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BmcUseQuery> selectUseQuery(UseQueryInputObject userQuery) {
		System.out.println("进入selectUseQuery方法,打印入参json:" + userQuery);
		logger.info("进入selectUseQuery方法,打印入参json:" + userQuery);
		List<BmcUseQuery> useQueryList = new ArrayList<BmcUseQuery>();
		try {
			BmcUseQueryMapper mapper = sqlSessionTemplate
					.getMapper(BmcUseQueryMapper.class);
			BmcUseQueryCriteria criteria = new BmcUseQueryCriteria();
			Criteria criteriaA = criteria.createCriteria().andTenantIdEqualTo(userQuery.getTenantId())
//					.andSystemIdEqualTo(userQuery.getSystemId())
					.andCustIdEqualTo(userQuery.getCustId())
					.andSubsIdEqualTo(userQuery.getSubsId());
			if(!StringUtil.isBlank(userQuery.getServiceNum())){
				criteriaA.andServiceNumEqualTo(userQuery.getServiceNum());
			}
			if(!StringUtil.isBlank(userQuery.getBeginMonth())){
			    String nowDate = DateUtil.getDateString(DateUtil.YYYYMM);
//				criteriaA.andBeginMonthEqualTo(userQuery.getBeginMonth());
				criteriaA.andBeginMonthBetween(userQuery.getBeginMonth(), nowDate);
			}
		
			useQueryList = mapper.selectByExample(criteria);
		} catch (Exception e) {
		    logger.info("异常" + e.getMessage());
			return null;
		}
		return useQueryList;
	}
//	public static void main(String[] args) {
//	   ApplicationContext context =new ClassPathXmlApplicationContext("classpath*:context/core-context.xml");
//	   IUseQuantityQuerySvc svc = context.getBean(IUseQuantityQuerySvc.class);
//	   UseQueryInputObject userQuery = new UseQueryInputObject();
//	   userQuery.setTenancyId("2");
//	   userQuery.setSystemId("2");
//	   userQuery.setMsgSeq("001");
//	   userQuery.setCustId("3");
//	   userQuery.setSubsId("4");
//	   svc.selectUseQuery(userQuery);
//	}
}
