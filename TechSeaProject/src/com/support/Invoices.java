package com.support;

import java.util.Date;

public class Invoices {
    private String INVOICE_ID;
    private Integer ORDER_ID;
    private String INVOICE_STATUS_CODE;
    private String INVOICE_DATE;
    private String INVOICE_DETAILS;
    
	public String getINVOICE_DATE() {
		return INVOICE_DATE;
	}
	public void setINVOICE_DATE(String iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}
	public String getINVOICE_ID() {
		return INVOICE_ID;
	}
	public void setINVOICE_ID(String iNVOICE_ID) {
		INVOICE_ID = iNVOICE_ID;
	}
	public Integer getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(Integer oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public String getINVOICE_STATUS_CODE() {
		return INVOICE_STATUS_CODE;
	}
	public void setINVOICE_STATUS_CODE(String iNVOICE_STATUS_CODE) {
		INVOICE_STATUS_CODE = iNVOICE_STATUS_CODE;
	}
	
	public String getINVOICE_DETAILS() {
		return INVOICE_DETAILS;
	}
	public void setINVOICE_DETAILS(String iNVOICE_DETAILS) {
		INVOICE_DETAILS = iNVOICE_DETAILS;
	}
    
    
}
