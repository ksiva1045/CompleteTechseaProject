package com.techsea;

import java.io.IOException;
import java.util.Map;


import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JAASLoginModule implements LoginModule {

	private CallbackHandler callbackHandler = null;
	public static String username=null;
	public static String password=null;
	public boolean authenticationFalg=false;
	
	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		// TODO Auto-generated method stub
		this.callbackHandler=callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		Emp emp=CheckDatabaseData.checkData();
		username = emp.getUsername();
		password = emp.getPassword();
		
		
		
		Callback[]  callbackArray = new Callback[2];
		callbackArray[0]= new NameCallback("User Name");
		callbackArray[1]= new PasswordCallback("Password",false);
		try {
			callbackHandler.handle(callbackArray);
		} catch (IOException | UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name= ((NameCallback) callbackArray[0]).getName();
		String  pass= new String(((PasswordCallback) callbackArray[1]).getPassword());
		if(name.equals(username)&&(pass.equals(password))){
			System.out.println("authentication sucess");
			authenticationFalg=true;
		}
		else {
			authenticationFalg=false;
			throw new FailedLoginException("authentication failure");
			
		}
		
	
		return authenticationFalg;
	}

	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return authenticationFalg;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
