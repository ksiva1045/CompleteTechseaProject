package com.invoices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.DealArray;
import com.table.operations.TableOperationsStub.DealOperations;
import com.table.operations.TableOperationsStub.Invoices;
import com.table.operations.TableOperationsStub.InvoicesArray;
import com.table.operations.TableOperationsStub.InvoicesOperations;

/**
 * Servlet implementation class InvoiceSelectByIdServlet
 */
public class InvoiceSelectByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceSelectByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		TableOperationsStub tableStub=new TableOperationsStub();
		InvoicesOperations invoicesoperations=new InvoicesOperations();
		InvoicesArray invoicearray=new InvoicesArray();
		Invoices invoices=new Invoices();
		invoicearray.setOpreationName(Operations.SELECTBYID);
		invoices.setINVOICE_ID(request.getParameter("id"));
		
		invoicesoperations.setIn(invoices);
		invoicesoperations.setArray(invoicearray);
		Object obj= tableStub.invoicesOperations(invoicesoperations).get_return();
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Invoices){
			invoices = (Invoices)obj;			
		}
		request.setAttribute("invoiceID",invoices );
		RequestDispatcher reqDis = request.getRequestDispatcher("/Invoicesjsps/GettingOneRecord.jsp");
		reqDis.forward(request, response);
	
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
