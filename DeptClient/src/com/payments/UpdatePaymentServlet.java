package com.payments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coupon.GetDate;
import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Payment;
import com.table.operations.TableOperationsStub.PaymentArray;
import com.table.operations.TableOperationsStub.PaymentaOperaction;

public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		PaymentaOperaction paymentoperation=new PaymentaOperaction();
		Payment p=new Payment();
	
		Payment p1=(Payment)session.getAttribute("payment");
		PaymentArray pArray=new PaymentArray();
		pArray.setOperationName(Operations.UPDATE);
	
		//Payament payment1 = (Payament) session.getAttribute("deal");
		
		p.setPAYMENT_ID(p1.getPAYMENT_ID());
		//p.setPAYMENT_ID(Integer.parseInt(request.getParameter("paymentid")));
		p.setPAYMENT_STATUS(request.getParameter("paymentstatus"));
		p.setPAYMENT_AMOUNT(request.getParameter("paymentamount"));
		p.setPAYMENT_DATE(GetDate.getDate(request.getParameter("paymentdate")));
		p.setPAYMENT_DETAILS(request.getParameter("paymentdetails"));
		p.setINVOICE_ID(request.getParameter("invoiceid"));
		paymentoperation.setP(p);
		paymentoperation.setPArray(pArray);
		
		pArray=(PaymentArray) tableStub.paymentaOperaction(paymentoperation).get_return();
		 String flag=pArray.getResult();
		 System.out.println("success"+flag);
			if(flag.equals("success")){
				request.setAttribute("sucessFlag",flag);
				
				RequestDispatcher reqDis = 	request.getRequestDispatcher("/paymentsjsps/UpdateReturnPayment.jsp");
				reqDis.forward(request,response);
			}
	}
}
