package com.invoices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.Operations;
import com.deal.GetDate;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.DealArray;
import com.table.operations.TableOperationsStub.DealOperations;
import com.table.operations.TableOperationsStub.Invoices;
import com.table.operations.TableOperationsStub.InvoicesArray;
import com.table.operations.TableOperationsStub.InvoicesOperations;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String invoiceid=request.getParameter("INVOICE_ID");
		int orderid=Integer.parseInt(request.getParameter("ORDER_ID"));
		String statuscode=request.getParameter("INVOICE_STATUS_CODE");
		String invoicedate=request.getParameter("INVOICE_DATE");
		String invoicedetails=request.getParameter("INVOICE_DETAILS");
		System.out.println(invoiceid);
		System.out.println(orderid);
		System.out.println(statuscode);
		
		TableOperationsStub stub= new TableOperationsStub();
		Invoices invoices=new Invoices();
		invoices.setINVOICE_ID(invoiceid);
		invoices.setORDER_ID(orderid);
		invoices.setINVOICE_STATUS_CODE(statuscode);
		invoices.setINVOICE_DATE((String)GetDate.getDate(invoicedate));
		invoices.setINVOICE_DETAILS(invoicedetails);
		
		
		System.out.println("From Servlet:::"+invoices.getINVOICE_DATE());
		InvoicesArray invoicesarray= new InvoicesArray();
		invoicesarray.setOpreationName(Operations.INSERT);
		InvoicesOperations invoicesoperations=new InvoicesOperations();
		invoicesoperations.setIn(invoices);
		invoicesoperations.setArray(invoicesarray);
		stub.invoicesOperations(invoicesoperations);*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		TableOperationsStub tableStub=new TableOperationsStub();
		InvoicesOperations invoicesoperations=new InvoicesOperations();
		InvoicesArray invoicesarray= new InvoicesArray();
		Invoices invoices=new Invoices();
		invoicesarray.setOpreationName(Operations.INSERT);
		
		
		System.out.println(request.getParameter("INVOICE_DATE"));
		invoices.setINVOICE_ID(request.getParameter("INVOICE_ID"));
		invoices.setORDER_ID(Integer.parseInt(request.getParameter("ORDER_ID")));
		invoices.setINVOICE_STATUS_CODE(request.getParameter("INVOICE_STATUS_CODE"));
		invoices.setINVOICE_DATE(GetDate.getDate(request.getParameter("INVOICE_DATE")));
		invoices.setINVOICE_DETAILS(request.getParameter("INVOICE_DETAILS"));
		
		invoicesarray.setOpreationName(Operations.INSERT);
		invoicesoperations.setIn(invoices);
		invoicesoperations.setArray(invoicesarray);
		invoicesarray=(InvoicesArray)tableStub.invoicesOperations(invoicesoperations).get_return();
		
		
		String flag=invoicesarray.getResult();
		request.setAttribute("sucessFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/Invoicesjsps/insertReturn.jsp");
		reqDis.forward(request, response);		
	}

	}


