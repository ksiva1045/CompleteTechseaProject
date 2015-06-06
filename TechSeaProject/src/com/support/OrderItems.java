package com.support;

public class OrderItems {
	private String orderItemId;
	private String productId;
	private String orderItemStatusCode ;
	private String orderItemQuantity;
	private String orderItemPrice;
	private String merchantAuthNbr;
	private String merchantIssuedBy;
	private String otherOrderItemsDetails;
	private String sellerId;
	private String merchantAuthDate;
	private int orderId;
	
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderItemStatusCode() {
		return orderItemStatusCode;
	}
	public void setOrderItemStatusCode(String orderItemStatusCode) {
		this.orderItemStatusCode = orderItemStatusCode;
	}
	public String getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(String orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	public String getOrderItemPrice() {
		return orderItemPrice;
	}
	public void setOrderItemPrice(String orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}
	public String getMerchantAuthNbr() {
		return merchantAuthNbr;
	}
	public void setMerchantAuthNbr(String merchantAuthNbr) {
		this.merchantAuthNbr = merchantAuthNbr;
	}
	public String getMerchantIssuedBy() {
		return merchantIssuedBy;
	}
	public void setMerchantIssuedBy(String merchantIssuedBy) {
		this.merchantIssuedBy = merchantIssuedBy;
	}
	public String getOtherOrderItemsDetails() {
		return otherOrderItemsDetails;
	}
	public void setOtherOrderItemsDetails(String otherOrderItemsDetails) {
		this.otherOrderItemsDetails = otherOrderItemsDetails;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getMerchantAuthDate() {
		return merchantAuthDate;
	}
	public void setMerchantAuthDate(String merchantAuthDate) {
		this.merchantAuthDate = merchantAuthDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
