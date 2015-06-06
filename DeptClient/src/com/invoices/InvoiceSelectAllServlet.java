package com.invoices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.DealArray;
import com.table.operations.TableOperationsStub.DealOperations;
import com.table.operations.TableOperationsStub.Invoices;
import com.table.operations.TableOperationsStub.InvoicesArray;
import com.table.operations.TableOperationsStub.InvoicesOperations;

/**
 * Servlet implementation class InvoiceSelectAllServlet
 */
public class InvoiceSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceSelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		System.out.println("Invoice Select All servlet");
		try{	
			TableOperationsStub tableStub=new TableOperationsStub();
			InvoicesOperations invoicesoperations=new InvoicesOperations();
			InvoicesArray invoicesarray=new InvoicesArray();
			Invoices invoices=new Invoices();
			String id = request.getParameter("id");
			Invoices[] invoices1=new Invoices[1];
			if(id==null){
				invoicesarray.setOpreationName(Operations.SELECTALL);
				invoicesoperations.setIn(invoices);
				invoicesoperations.setArray(invoicesarray);
				invoicesarray=(InvoicesArray)tableStub.invoicesOperations(invoicesoperations).get_return();
				invoices1=invoicesarray.getInvoice();
			}
			else{
				
				Invoices invoicesobj = new Invoices();
				invoicesobj.setINVOICE_ID(id);
				invoicesarray.setOpreationName(Operations.SELECTBYID);
				invoicesoperations.setIn(invoicesobj);
				invoicesoperations.setArray(invoicesarray);
				Object obj=tableStub.invoicesOperations(invoicesoperations).get_return();
				if(obj instanceof String){
					flag=(String) obj;
				}
				else if(obj instanceof Invoices){
					invoices1[0]=(Invoices)obj;
				}
				}
				if(!flag.equals("failure")){
				request.setAttribute("invoicesall", invoices1);
			
				RequestDispatcher reqDisp=	request.getRequestDispatcher("/Invoicesjsps/InvoicesSelectAll1.jsp");
				reqDisp.include(request, response);
				}
				else
				{		
					out.print("<center style='color:red'>");
					out.print("<h2>");
					out.print("No Records were selected to delete");
					out.print("</h2>");
					out.print("</center>");
				}}
				catch(Exception e){
					e.printStackTrace();
					out.print("<center style='color:red'>");
			    	out.print("<h2>");
			    	out.print("No Record is found to Display");
			    	out.print("</h2>");
			    	out.print("</center>");
					
				}
		}
	}
	
