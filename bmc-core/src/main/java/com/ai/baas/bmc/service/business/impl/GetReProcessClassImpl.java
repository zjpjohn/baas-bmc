package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.dao.mapper.bo.PubServiceRoute;
import com.ai.baas.bmc.service.atom.interfaces.IPubServiceRouteAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IGetReProcessClassSV;
import com.ai.baas.bmc.service.processor.IDeductProcessor;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.ReflectionUtils;

@Service
@Transactional
public class GetReProcessClassImpl implements IGetReProcessClassSV{
	@Autowired	
	private IPubServiceRouteAtomSV PubServiceRoute;
	private Map<String, String> routeMap=new HashMap<String, String>();
	private StringBuilder classKey=new StringBuilder();
	 List<PubServiceRoute> serviceRoutes=new ArrayList<PubServiceRoute>();
	@Override
	public IDeductProcessor getProcessor(String tenantId, String serviceType) {
		// TODO Auto-generated method stub
		serviceRoutes=PubServiceRoute.getProcessClass(tenantId, serviceType);
		try{
			for(PubServiceRoute serviceRoute:serviceRoutes){
				StringBuilder routeKey= new StringBuilder();
				routeKey.append(serviceRoute.getRouteType()).append(BmcConstants.SEQ.BMC_BAK_HTABLE_SPLIT).append(serviceRoute.getRouteParams());
				routeMap.put(routeKey.toString(),serviceRoute.getRouteClass());
			}
			classKey.append(BmcConstants.SEQ.BMC_BAK_ROUTE_TYPE).append(BmcConstants.SEQ.BMC_BAK_HTABLE_SPLIT).append(tenantId.toUpperCase()).append(",").append(serviceType.toUpperCase());
			String clazz=routeMap.get(classKey.toString());
			
			return ReflectionUtils.getRuleProcessorObj(clazz);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
