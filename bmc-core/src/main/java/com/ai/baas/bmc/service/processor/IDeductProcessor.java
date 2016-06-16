package com.ai.baas.bmc.service.processor;

import java.util.Map;

public interface IDeductProcessor {
	void sendToMds(Map<String, String> data) throws Exception;
}
