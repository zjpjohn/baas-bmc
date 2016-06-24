package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;

/**
 * 对于没有初始化基础资料一类业务的初始化
 *  Date: 2016年6月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author biancx
 *
 */
public interface IinitBaseDataBusi {

	public int InitBaseBusi(InitBaseParam param);
}
