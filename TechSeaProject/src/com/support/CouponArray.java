package com.support;

public class CouponArray {
	public Coupon[] coupon;
	
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

	public void setCoupon(Coupon[] coupon) {
		this.coupon = coupon;
	}

	public String operationName;
	public String result;
	
	public Coupon[] getCoupon() {
		return coupon;
	}

}