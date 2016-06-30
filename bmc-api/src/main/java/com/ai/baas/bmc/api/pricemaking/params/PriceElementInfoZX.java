package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class PriceElementInfoZX extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String service_id;

    private String accepts_incomplete;

    private String parameters;

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getAccepts_incomplete() {
        return accepts_incomplete;
    }

    public void setAccepts_incomplete(String accepts_incomplete) {
        this.accepts_incomplete = accepts_incomplete;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
