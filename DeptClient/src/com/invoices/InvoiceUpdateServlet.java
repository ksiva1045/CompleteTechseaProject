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
 * Servlet implementation class InvoiceUpdateServlet
 */
public class InvoiceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		InvoicesOperations invoicesoperations=new InvoicesOperations();
		InvoicesArray invoicesarray=new InvoicesArray();
		Invoices invoices = new Invoices();
		
		invoicesarray.setOpreationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		Invoices invoicess = (Invoices) session.getAttribute("invoices1");
		
		invoices.setORDER_ID(Integer.parseInt(request.getParameter("ORDER_ID")));
		invoices.setINVOICE_STATUS_CODE(request.getParameter("INVOICE_STATUS_CODE"));
	    invoices.setINVOICE_DATE(GetDate.getDate(request.getParameter("INVOICE_DATE")));
	    invoices.setINVOICE_DETAILS(request.getParameter("INVOICE_DETAILS"));
	    invoices.setINVOICE_ID(invoicess.getINVOICE_ID());
	    System.out.println(request.getParameter("INVOICE_DETAILS"));
	    invoicesoperations.setIn(invoices);
	    invoicesoperations.setArray(invoicesarray);
	    invoicesarray = (InvoicesArray)tableStub.invoicesOperations(invoicesoperations).get_return();
	    String flag=invoicesarray.getResult();
	    System.out.println(flag);
		if(flag.equals("success")){
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/Invoicesjsps/UpdateReturnInvoice.jsp");
			reqDis.forward(request,response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
