package com.ai.baas.bmc.dao.mapper.bo;

public class PubServiceRoute {
    private Integer id;

    private String routeType;

    private String routeParams;

    private String routeClass;

    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType == null ? null : routeType.trim();
    }

    public String getRouteParams() {
        return routeParams;
    }

    public void setRouteParams(String routeParams) {
        this.routeParams = routeParams == null ? null : routeParams.trim();
    }

    public String getRouteClass() {
        return routeClass;
    }

    public void setRouteClass(String routeClass) {
        this.routeClass = routeClass == null ? null : routeClass.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}