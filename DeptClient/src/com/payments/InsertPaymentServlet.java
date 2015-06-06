package com.payments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.dialect.H2Dialect;

import com.coupon.GetDate;
import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Payment;
import com.table.operations.TableOperationsStub.PaymentArray;
import com.table.operations.TableOperationsStub.PaymentaOperaction;

public class InsertPaymentServlet extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		TableOperationsStub tableStub=new TableOperationsStub();
		PaymentaOperaction paymentoperation=new PaymentaOperaction();
		Payment p=new Payment();
		PaymentArray pArray=new PaymentArray();
		pArray.setOperationName(Operations.INSERT);
	
		p.setPAYMENT_STATUS(request.getParameter("paymentstatus"));
		p.setPAYMENT_AMOUNT(request.getParameter("paymentamount"));
        p.setPAYMENT_DATE(GetDate.getDate(request.getParameter("paymentdate")));
		p.setPAYMENT_DETAILS(request.getParameter("paymentdetails"));
		p.setINVOICE_ID(request.getParameter("invoiceid"));
		
		paymentoperation.setP(p);

		paymentoperation.setPArray(pArray);
		
		pArray=(PaymentArray) tableStub.paymentaOperaction(paymentoperation).get_return();
	 String flag=pArray.getResult();
		request.setAttribute("sucessFlag",flag);
		System.out.println("inside insert servlet "+flag);
		pw.print("Record Inserted");
		RequestDispatcher reqDis =  request.getRequestDispatcher("/paymentsjsps/InsertReturnpayments.jsp");
		reqDis.forward(request, response);	
	}	

}
