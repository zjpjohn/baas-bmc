package com.ai.baas.bmc.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.constants.CacheRSMapper;
import com.ai.baas.bmc.dao.interfaces.BmcBasedataCodeMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCode;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCodeCriteria;
import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author wangluyang
 *
 */
public class BaseInfoCache implements InitializingBean{

	private static final Logger LOG = LogManager.getLogger(BaseInfoCache.class);
	
	@Autowired
	private BmcBasedataCodeMapper bmcBasedataCodeMapper;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		this.writeBaseInfoToRedis();
	}

	public void writeBaseInfoToRedis(){
		List<BmcBasedataCode> list = bmcBasedataCodeMapper.selectByExample(new BmcBasedataCodeCriteria());
		if(CollectionUtil.isEmpty(list)){
			return;
		}
		ICacheClient cacheClient = MCSClientFactory.getCacheClient(CacheRSMapper.CACHE_BASEINFO);
		
		//清空上次缓存的数据
		cacheClient.del(CacheRSMapper.CACHE_BASEINFO);
		
		for(BmcBasedataCode vo:list){
			LOG.debug("缓存BaseInfo信息:租户{}paramType{}paramCode{}", vo.getTenantId(), vo.getParamType(), vo.getParamCode());
			List<BmcBasedataCode> rsList = new ArrayList<>();
			String data = cacheClient.hget(CacheRSMapper.CACHE_BASEINFO,
					generateBaseInfoKey(vo.getTenantId(), vo.getParamType()));
			if(data!=null){
				rsList = (List<BmcBasedataCode>) JSONObject.parseArray(data, BmcBasedataCode.class);
			}
			rsList.add(vo);
			cacheClient.hset(CacheRSMapper.CACHE_BASEINFO, generateBaseInfoKey(vo.getTenantId(), vo.getParamType()), JSON.toJSONString(rsList));
		}
	}
	
	public static String generateBaseInfoKey(String tenantId, String paramType){
		return tenantId.toUpperCase() + "." + paramType.toUpperCase();
	}
	
}
