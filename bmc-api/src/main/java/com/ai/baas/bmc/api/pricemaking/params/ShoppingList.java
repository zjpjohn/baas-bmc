package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.Map;

public class ShoppingList implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 购买清单的唯一标识
     */
    private String list_id;

    /**
     * 在服务目录中的服务唯一标识
     */
    private String service_id;

    /**
     * 中信云平台会根据服务目录中获取的config_options提供创建一个服务实例所需的配置项值的列表，计费平台要负责验证
     */
    private Map<String, String> parameters;

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

}
