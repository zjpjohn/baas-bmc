package com.ai.baas.bmc.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;

/**
 * 标准资费更新服务<br>
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public interface IUpdatePriceInfoBussiness {
    /**
     * hbase判重
     */
    public boolean dupCheck(StandardPriceInfoParams param) throws IOException;
    
    /**
     * mysql写入，更新
     */
    public void writeData(StandardPriceInfoParams param);
    
    /**
     * mysql删除，更改生效状态
     * 
     */
    public void deleteData(StandardPriceInfoParams param);
}