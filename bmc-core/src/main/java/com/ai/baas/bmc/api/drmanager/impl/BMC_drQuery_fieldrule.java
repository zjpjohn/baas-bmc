package com.ai.baas.bmc.api.drmanager.impl;

public class BMC_drQuery_fieldrule {
	//字段配置
    private String tablename;
    private String tableid;
    private String field_desc;
    private String field_name;
    private Integer field_type;
    private Integer field_length;
    private String parent_node;
    private String src_content;
    private Integer default_output;

    public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename == null ? null : tablename.trim();
	}

	public String getTableid() {
		return tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}

	public String getField_desc() {
		return field_desc;
	}

	public void setField_desc(String field_desc) {
		this.field_desc = field_desc;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name == null ? null : field_name.trim();
	}

	public Integer getField_type() {
		return field_type;
	}

	public void setField_type(Integer field_type) {
		this.field_type = field_type;
	}

	public Integer getField_length() {
		return field_length;
	}

	public void setField_length(Integer field_length) {
		this.field_length = field_length;
	}

	public String getParent_node() {
		return parent_node;
	}

	public void setParent_node(String parent_node) {
		this.parent_node = parent_node == null ? null : parent_node.trim();
	}

	public String getSrc_content() {
		return src_content;
	}

	public void setSrc_content(String src_content) {
		this.src_content = src_content;
	}

	public Integer getDefault_output() {
		return default_output;
	}

	public void setDefault_output(Integer default_output) {
		this.default_output = default_output;
	}

	@Override
	public String toString() {
		return "BMC_drQuery_fieldrule [tablename=" + tablename + ", tableid=" + tableid + ", field_desc=" + field_desc
				+ ", field_name=" + field_name + ", field_type=" + field_type + ", field_length=" + field_length
				+ ", parent_node=" + parent_node + ", src_content=" + src_content + ", default_output=" + default_output
				+ "]";
	}
	
}
