package com.payments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.table.operations.TableOperationsStub;

import com.table.operations.TableOperationsStub.Payment;
import com.table.operations.TableOperationsStub.PaymentArray;
import com.table.operations.TableOperationsStub.PaymentaOperaction;

public class SelectPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		
		TableOperationsStub tableStub=new TableOperationsStub();
		PaymentaOperaction paymentOperations=new PaymentaOperaction();
		PaymentArray paymentArray=new PaymentArray();
		Payment payment =new Payment();
		paymentArray.setOperationName(Operations.SELECTBYID);
	    //paymentArray.setOperationName(Operations.SELECTBYID);
		payment.setPAYMENT_ID(Integer.parseInt(request.getParameter("id")));
		String id=request.getParameter("id");
		System.out.println(id);
		paymentOperations.setP(payment);
		paymentOperations.setPArray(paymentArray);

		Object obj= tableStub.paymentaOperaction(paymentOperations).get_return();
		
		
	if(obj instanceof String){
		System.out.println(obj);
	}
		else if(obj instanceof Payment){
			payment= (Payment)obj;			
		}
		request.setAttribute("paymentObj",payment);
		RequestDispatcher reqDis = request.getRequestDispatcher("/paymentsjsps/UpdatePayment.jsp");
		reqDis.forward(request, response);
	
	}
		
}
