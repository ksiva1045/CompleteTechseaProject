package com.support;

public class ProductSpecificationArray {
	public ProductSpecification[] productSpecification;
	public ProductSpecification[] getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(ProductSpecification[] productSpecification) {
		this.productSpecification = productSpecification;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String operationName;
	public String result;

}
