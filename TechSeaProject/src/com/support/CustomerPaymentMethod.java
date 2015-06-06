package com.support;

public class CustomerPaymentMethod 
{
	private String customerPaymentId;
	private int customerId;
	private String paymentMethodCode;
	private String paymentMethodDetails1;
	private String paymentMethodDetails2;
	
	
	public String getCustomerPaymentId() {
		return customerPaymentId;
	}
	public void setCustomerPaymentId(String customerPaymentId) {
		this.customerPaymentId = customerPaymentId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}
	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}
	public String getPaymentMethodDetails1() {
		return paymentMethodDetails1;
	}
	public void setPaymentMethodDetails1(String paymentMethodDetails1) {
		this.paymentMethodDetails1 = paymentMethodDetails1;
	}
	public String getPaymentMethodDetails2() {
		return paymentMethodDetails2;
	}
	public void setPaymentMethodDetails2(String paymentMethodDetails2) {
		this.paymentMethodDetails2 = paymentMethodDetails2;
	}
	
	
	
}
