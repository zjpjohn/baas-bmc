package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.baseInfo.params.BaseCode;
import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.ChildeCodeResponse;
import com.ai.baas.bmc.api.baseInfo.params.QueryChildCodeRequest;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.baas.bmc.cache.BaseInfoCache;
import com.ai.baas.bmc.constants.CacheRSMapper;
import com.ai.baas.bmc.constants.BmcConstants.TenantId;
import com.ai.baas.bmc.dao.interfaces.BmcBasedataCodeMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCode;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCodeCriteria;
import com.ai.baas.bmc.service.business.interfaces.IBaseInfoBussiness;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class BaseInfoBussinessImpl implements IBaseInfoBussiness {
	@Autowired
	private BmcBasedataCodeMapper bmcBasedataCodeMapper;

	@Override
	public BaseCodeInfo getBaseInfo(QueryInfoParams param) {

		List<BaseCode> baseCodeList = new ArrayList<BaseCode>();

		ICacheClient cacheClient = MCSClientFactory.getCacheClient(CacheRSMapper.CACHE_BASEINFO);
		String dataPub = cacheClient.hget(CacheRSMapper.CACHE_BASEINFO,
				BaseInfoCache.generateBaseInfoKey(TenantId.PUB, param.getParamType()));
		if(dataPub!=null){
			System.out.println("缓存取得的数据－－"+dataPub);
			List<BmcBasedataCode> pubList = (List<BmcBasedataCode>) JSONObject.parseObject(dataPub);
			if(pubList!=null && pubList.size()>0){
				for (BmcBasedataCode bmcBaseCode : pubList) { 
					BaseCode baseCode = new BaseCode();
					BeanUtils.copyProperties(baseCode, bmcBaseCode);
					baseCodeList.add(baseCode);
				}
			}
		}
		String data = cacheClient.hget(CacheRSMapper.CACHE_BASEINFO,
				BaseInfoCache.generateBaseInfoKey(param.getTenantId(), param.getParamType()));
		if(data!=null){
			List<BmcBasedataCode> list = (List<BmcBasedataCode>) JSONObject.parseObject(data);
			if(list!=null && list.size()>0){
				for (BmcBasedataCode bmcBaseCode : list) {
					BaseCode baseCode = new BaseCode();
					BeanUtils.copyProperties(baseCode, bmcBaseCode);
					baseCodeList.add(baseCode);
				}
			}
		}
		//如果缓存未查询到数据，查询数据库并保存如缓存
		if(baseCodeList.size()==0){
			BmcBasedataCodeCriteria pubsql = new BmcBasedataCodeCriteria();
			BmcBasedataCodeCriteria.Criteria pubCriteria = pubsql.or();
			pubCriteria.andTenantIdEqualTo(TenantId.PUB).andParamTypeEqualTo(param.getParamType());
			List<BmcBasedataCode> pubList = bmcBasedataCodeMapper.selectByExample(pubsql);
			if (!CollectionUtil.isEmpty(pubList)) {
				for (BmcBasedataCode bmcBaseCode : pubList) {
					BaseCode baseCode = new BaseCode();
					BeanUtils.copyProperties(baseCode, bmcBaseCode);
					baseCodeList.add(baseCode);
				}
				cacheClient.hset(CacheRSMapper.CACHE_BASEINFO, BaseInfoCache.generateBaseInfoKey(TenantId.PUB, param.getParamType()), JSON.toJSONString(pubList));
			}
			if(!(TenantId.PUB).equals(param.getTenantId())){
				BmcBasedataCodeCriteria sql = new BmcBasedataCodeCriteria();
				BmcBasedataCodeCriteria.Criteria Criteria = sql.or();
				Criteria.andTenantIdEqualTo(param.getTenantId()).andParamTypeEqualTo(param.getParamType());
				List<BmcBasedataCode> list = bmcBasedataCodeMapper.selectByExample(sql);
				// 非pub查询
				if (!CollectionUtil.isEmpty(list)) {
					for (BmcBasedataCode bmcBaseCode : list) {
						BaseCode baseCode = new BaseCode();
						BeanUtils.copyProperties(baseCode, bmcBaseCode);
						baseCodeList.add(baseCode);
					}
					cacheClient.hset(CacheRSMapper.CACHE_BASEINFO, BaseInfoCache.generateBaseInfoKey(param.getTenantId(), param.getParamType()), JSON.toJSONString(pubList));
				}
			}
		}

		BaseCodeInfo baseCodeInfo = new BaseCodeInfo();
		baseCodeInfo.setTradeSeq(param.getTradeSeq());
		baseCodeInfo.setTenantId(param.getTenantId());
		baseCodeInfo.setParamType(param.getParamType());
		baseCodeInfo.setParamList(baseCodeList);
		return baseCodeInfo;
	}

	@Override
	public ChildeCodeResponse getChildCode(QueryChildCodeRequest request) {
		List<BaseCode> baseCodeList = new ArrayList<BaseCode>();
		ChildeCodeResponse baseCodeInfo = new ChildeCodeResponse();
		BmcBasedataCodeCriteria pubsql = new BmcBasedataCodeCriteria();
		BmcBasedataCodeCriteria.Criteria pubCriteria = pubsql.or();
		pubCriteria.andTenantIdEqualTo(TenantId.PUB).andParentCodeEqualTo(request.getParentCode());
		List<BmcBasedataCode> pubList = bmcBasedataCodeMapper.selectByExample(pubsql);
		if (!CollectionUtil.isEmpty(pubList)) {
			for (BmcBasedataCode bmcBaseCode : pubList) {
				BaseCode baseCode = new BaseCode();
				BeanUtils.copyProperties(baseCode, bmcBaseCode);
				baseCodeList.add(baseCode);
			}

		}
		if(!(TenantId.PUB).equals(request.getTenantId())){
			BmcBasedataCodeCriteria sql = new BmcBasedataCodeCriteria();
			BmcBasedataCodeCriteria.Criteria Criteria = sql.or();
			Criteria.andTenantIdEqualTo(request.getTenantId()).andParentCodeEqualTo(request.getParentCode());
			List<BmcBasedataCode> list = bmcBasedataCodeMapper.selectByExample(sql);
			// 非pub查询
			if (!CollectionUtil.isEmpty(list)) {
				baseCodeInfo.setParamType(list.get(0).getParamType());
				for (BmcBasedataCode bmcBaseCode : list) {
					BaseCode baseCode = new BaseCode();
					BeanUtils.copyProperties(baseCode, bmcBaseCode);
					baseCodeList.add(baseCode);
				}

			}else{
				baseCodeInfo.setParamType("");
			}
		}


		
		baseCodeInfo.setTradeSeq(request.getTradeSeq());
		baseCodeInfo.setTenantId(request.getTenantId());
		
		baseCodeInfo.setParamList(baseCodeList);
		return baseCodeInfo;
	}

	
}
