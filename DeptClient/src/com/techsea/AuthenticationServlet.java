package com.techsea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	
    	//System.setProperty("java.security.auth.login.config", "jaas1.config");
    	response.setContentType("text/html");
    	String user = request.getParameter("username");
    	String pass = request.getParameter("password");
    	if(user!=null || pass!=null){
    		JAASCallbackHandler callbackHandler = new JAASCallbackHandler(user, pass);
    		boolean authenticationFlag = true;
    		try {
				LoginContext loginContext = new LoginContext("jaas2",callbackHandler);
				loginContext.login();
				
    		} catch (LoginException e) {
    			authenticationFlag =false;
				//e.printStackTrace();
			}
    		if(authenticationFlag){ 
    			HttpSession session = request.getSession(true);
    			
    			session.setAttribute("userName", user);
    			RequestDispatcher reqDisp = request.getRequestDispatcher("/deptjsps/index.jsp");	
    		    reqDisp.forward(request, response);
    		}
    		else{
    			request.setAttribute("error","error");
    			
    			RequestDispatcher reqDisp = request.getRequestDispatcher("/deptjsps/login.jsp");	
    		    reqDisp.forward(request, response);
    		}
    	}else
    	{
    		out.println("Invalid Details");
    	}
	}

	
}
