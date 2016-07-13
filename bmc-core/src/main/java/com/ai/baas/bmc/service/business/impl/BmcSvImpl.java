package com.ai.baas.bmc.service.business.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryInputObject;
import com.ai.baas.bmc.dao.interfaces.BmcAccuDealerMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealer;
import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealerCriteria;
import com.ai.baas.bmc.service.business.interfaces.BmcSv;
//import com.ai.baas.bmc.vo.SaveScoPolicyVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO:整体代码有重复，并请完善注释
@Service
@Transactional
public class BmcSvImpl implements BmcSv {

	 private Logger logger = Logger.getLogger(BmcSvImpl.class);
 
	@Autowired

	private SqlSessionTemplate sqlSessionTemplate;	
	
	@Override
	public List<BmcAccuDealer> operatorAccuQuery(OperatorFlowQueryInputObject aOperatorFlowQueryInputObject) {

		//获取mapper
		BmcAccuDealerMapper bmcAccuDealerMapper = sqlSessionTemplate.getMapper(BmcAccuDealerMapper.class);
		
		//调用查询方法  List<BmcAccuDealer> selectByExample(BmcAccuDealerCriteria example);
		List<BmcAccuDealer> accuList = null;
		
		//查询总条数
		BmcAccuDealerCriteria bmcAccuCriteria = new BmcAccuDealerCriteria();
		
		if(null !=aOperatorFlowQueryInputObject.getTenantId())
		{
			bmcAccuCriteria.createCriteria().andTenantidEqualTo(aOperatorFlowQueryInputObject.getTenantId());
		}		
		else if(null !=aOperatorFlowQueryInputObject.getDealerCode())
		{
			bmcAccuCriteria.createCriteria().andDealercodeEqualTo(aOperatorFlowQueryInputObject.getDealerCode());
		}
		else if(null !=aOperatorFlowQueryInputObject.getDealerAreaCode())
		{
			bmcAccuCriteria.createCriteria().andDealerareacodeEqualTo(aOperatorFlowQueryInputObject.getDealerAreaCode());
		}
		//TODO: 没有使用的代码，建议删掉
		int totalcount = bmcAccuDealerMapper.countByExample(bmcAccuCriteria);

		//设置条件
		int pageNum = Integer.parseInt(aOperatorFlowQueryInputObject.getPageNum());
		int pageSize = Integer.parseInt(aOperatorFlowQueryInputObject.getPagecountNum());
		int start = (pageNum - 1) * pageSize + 1;
		
		// TODO:建议对BmcAccuDealerCriteria的对象(bmcAccuCriteria)重复使用，去掉下面的ifelse
		BmcAccuDealerCriteria bmcAccuDealerCriteria = new BmcAccuDealerCriteria();
		bmcAccuDealerCriteria.setLimitStart(start);
		bmcAccuDealerCriteria.setLimitEnd(start + pageSize - 1);


		if(null !=aOperatorFlowQueryInputObject.getTenantId())
		{
			bmcAccuDealerCriteria.createCriteria().andTenantidEqualTo(aOperatorFlowQueryInputObject.getTenantId());
		}		
		else if(null !=aOperatorFlowQueryInputObject.getDealerCode())
		{
			bmcAccuDealerCriteria.createCriteria().andDealercodeEqualTo(aOperatorFlowQueryInputObject.getDealerCode());
		}
		else if(null !=aOperatorFlowQueryInputObject.getDealerAreaCode())
		{
			bmcAccuDealerCriteria.createCriteria().andDealerareacodeEqualTo(aOperatorFlowQueryInputObject.getDealerAreaCode());
		}
		
		//查询
		accuList = bmcAccuDealerMapper.selectByExample(bmcAccuDealerCriteria);
		
		
		return accuList;
	}
	
	@Override
	public int operatorAccuQueryCount(OperatorFlowQueryInputObject aOperatorFlowQueryInputObject) {

		//获取mapper
		BmcAccuDealerMapper bmcAccuDealerMapper = sqlSessionTemplate.getMapper(BmcAccuDealerMapper.class);
		
		//查询总条数
		BmcAccuDealerCriteria bmcAccuCriteria = new BmcAccuDealerCriteria();
		
		if(null !=aOperatorFlowQueryInputObject.getTenantId())
		{
			bmcAccuCriteria.createCriteria().andTenantidEqualTo(aOperatorFlowQueryInputObject.getTenantId());
		}		
		else if(null !=aOperatorFlowQueryInputObject.getDealerCode())
		{
			bmcAccuCriteria.createCriteria().andDealercodeEqualTo(aOperatorFlowQueryInputObject.getDealerCode());
		}
		else if(null !=aOperatorFlowQueryInputObject.getDealerAreaCode())
		{
			bmcAccuCriteria.createCriteria().andDealerareacodeEqualTo(aOperatorFlowQueryInputObject.getDealerAreaCode());
		}
		
		int totalcount = bmcAccuDealerMapper.countByExample(bmcAccuCriteria);
				
		return totalcount;
	}
 
}
