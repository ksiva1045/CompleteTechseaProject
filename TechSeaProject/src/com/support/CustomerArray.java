package com.support;


	



public class CustomerArray {		
	
	public Customer[] customer;
		public String operationName;
		public String result;
		public String error;
		
		public Customer[] getCustomer() {
			return customer;
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
		
		public void setCustomer(Customer[] customer) {
			this.customer = customer;
		}
		
		
		
}

		