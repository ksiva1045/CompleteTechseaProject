package com.operations;

import org.apache.ws.java2wsdl.Java2WSDL;

public class Snippet {
	public static void main(String[] args) throws Exception {
	    Java2WSDL.main("-cn com.table.operations.TableOperations".split("\\s+"));
	}
}

