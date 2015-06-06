package com.support;



public class CustomerPaymentMethodArray 
{
	private String result;
	private String operationName;
	private CustomerPaymentMethod[] customerPaymentMethod;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public CustomerPaymentMethod[] getCustomerPaymentMethod() {
		return customerPaymentMethod;
	}
	public void setCustomerPaymentMethod(
			CustomerPaymentMethod[] customerPaymentMethod) {
		this.customerPaymentMethod = customerPaymentMethod;
	}
	
}
