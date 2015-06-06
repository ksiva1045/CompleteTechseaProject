package com.support;
import java.util.Date;

public class Payment {
	private int PAYMENT_ID;
		private String PAYMENT_DETAILS;
		private String INVOICE_ID;
		private String PAYMENT_STATUS;
		private String PAYMENT_DATE;
		private String PAYMENT_AMOUNT;
		public int getPAYMENT_ID() {
			return PAYMENT_ID;
		}
		public void setPAYMENT_ID(int pAYMENT_ID) {
			PAYMENT_ID = pAYMENT_ID;
		}
		public String getPAYMENT_DETAILS() {
			return PAYMENT_DETAILS;
		}
		public void setPAYMENT_DETAILS(String pAYMENT_DETAILS) {
			PAYMENT_DETAILS = pAYMENT_DETAILS;
		}
		public String getINVOICE_ID() {
			return INVOICE_ID;
		}
		public void setINVOICE_ID(String iNVOICE_ID) {
			INVOICE_ID = iNVOICE_ID;
		}
		public String getPAYMENT_STATUS() {
			return PAYMENT_STATUS;
		}
		public void setPAYMENT_STATUS(String pAYMENT_STATUS) {
			PAYMENT_STATUS = pAYMENT_STATUS;
		}
		
		public String getPAYMENT_DATE() {
			return PAYMENT_DATE;
		}
		public void setPAYMENT_DATE(String pAYMENT_DATE) {
			PAYMENT_DATE = pAYMENT_DATE;
		}
		public String getPAYMENT_AMOUNT() {
			return PAYMENT_AMOUNT;
		}
		public void setPAYMENT_AMOUNT(String pAYMENT_AMOUNT) {
			PAYMENT_AMOUNT = pAYMENT_AMOUNT;
		}
		
	}


