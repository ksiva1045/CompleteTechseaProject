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
 * Servlet implementation class InvoicesDeleteServlet
 */
public class InvoicesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoicesDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
		
				TableOperationsStub tableStub=new TableOperationsStub();
				InvoicesOperations invoicesoperations=new InvoicesOperations();
				InvoicesArray invoicearray=new InvoicesArray();
				Invoices invoices=new Invoices();

				invoicearray.setOpreationName(Operations.DELETE);
				invoices.setINVOICE_ID(value);

				invoicesoperations.setIn(invoices);
				invoicesoperations.setArray(invoicearray);
		
				
		tableStub.invoicesOperations(invoicesoperations);
				count++;
			}
		}
		else{    	
        	out.print("<center style='color:red'>");
        	out.print("<h2>");
        	out.print("No Records were selected to delete");
        	out.print("</h2>");
        	out.print("</center>");}
		if(count>0){
			System.out.println(count);

			request.setAttribute("count", count);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Invoicesjsps/InvoicesDeleteStatus.jsp");
			reqDispatcher.forward(request, response);
			
		}
	}

}
