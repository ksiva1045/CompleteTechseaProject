package com.support;

public class CallerArray {
	public Caller[] caller;
	public String operationName;
	public String result;
	public String error;
	public Caller[] getCaller() {
		return caller;
	}
	public void setCaller(Caller[] caller) {
		this.caller = caller;
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
