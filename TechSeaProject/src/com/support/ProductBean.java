package com.support;

public class ProductBean {
	private String productId;
	private String productCode;
	private String productName;
	private String price;
	private String prouduct_cat_id;
	private String serviceCode;

	
	
	private String createdUserID ;
	private String createdDate ;
	private String lastModifiedUserID;
	private String lastModifiedDate;

	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}


	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getCreatedUserID() {
		return createdUserID;
	}
	public void setCreatedUserID(String createdUserID) {
		this.createdUserID = createdUserID;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedUserID() {
		return lastModifiedUserID;
	}
	public void setLastModifiedUserID(String lastModifiedUserID) {
		this.lastModifiedUserID = lastModifiedUserID;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getProuduct_cat_id() {
		return prouduct_cat_id;
	}
	public void setProuduct_cat_id(String prouduct_cat_id) {
		this.prouduct_cat_id = prouduct_cat_id;
	}
	
}
