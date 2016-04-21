package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.baas.bmc.api.marktableproduct.interfaces.IQueryProductSV;
/**
 * 可销售产品管理>>>关联详单科目 入参
 *
 * Date: 2016年4月21日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public class ProductRelatedRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品编号
	 */
	@NotBlank(message="产品Id不能为空",groups={IProductManageSV.updateProductRelated.class,IQueryProductSV.GetProductRelated.class})
	private String productId;
	/**
	 * 租户id
	 */
	@NotBlank(message="租户id不能为空",groups={IProductManageSV.updateProductRelated.class,IQueryProductSV.GetProductRelated.class})
	private String tenantId;
	/**
	 * 计费类型
	 */
	@NotBlank(message="计费类型不能为空",groups={IProductManageSV.updateProductRelated.class,IQueryProductSV.GetProductRelated.class})
	private String billingType;
	
	@NotBlank(message="科目编码不能为空",groups={IProductManageSV.updateProductRelated.class})
	private String subjectCode;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

}
