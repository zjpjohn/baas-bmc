package com.ai.baas.bmc.util;

import com.ai.baas.bmc.service.processor.IDeductProcessor;

public class ReflectionUtils {
	@SuppressWarnings("unchecked")
	public static IDeductProcessor getRuleProcessorObj(String strClazz) throws Exception{
		Class<IDeductProcessor> clazz = (Class<IDeductProcessor>)Class.forName(strClazz);
		return clazz.newInstance();
	}
}
