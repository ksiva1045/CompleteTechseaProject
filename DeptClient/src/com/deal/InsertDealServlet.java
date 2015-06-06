package com.deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.OperationsException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.DealArray;
import com.table.operations.TableOperationsStub.DealOperations;



/**
 * Servlet implementation class InsertDealServlet
 */
public class InsertDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		TableOperationsStub tableStub=new TableOperationsStub();
		DealOperations dealOperations=new DealOperations();
		Deal deal = new Deal();
		DealArray dealArray=new DealArray();
		
		dealArray.setOperationName(Operations.INSERT);
	
		deal.setDealName(request.getParameter("dealname"));
		deal.setDealDetails(request.getParameter("dealdetails"));
		deal.setProductId(request.getParameter("productid"));
		deal.setSellerId(request.getParameter("sellerid"));
		deal.setStartDate(GetDate.getDate(request.getParameter("startdate")));
		deal.setEndDate(GetDate.getDate(request.getParameter("enddate")));
		deal.setCreatedUserId((String)session.getAttribute("username"));
		
		dealOperations.setDealObj(deal);
		dealOperations.setDealArray(dealArray);
		
		dealArray= (DealArray) tableStub.dealOperations(dealOperations).get_return();
		String flag=dealArray.getResult();
		request.setAttribute("sucessFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/dealjsps/InsertReturnDeal.jsp");
		reqDis.forward(request, response);		
	}

}
