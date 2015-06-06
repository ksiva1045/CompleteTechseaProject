package com.deal;

import java.io.IOException;
import java.io.PrintWriter;

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

public class UpdateDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		DealOperations dealOperations=new DealOperations();
		DealArray dealArray=new DealArray();
		Deal deal = new Deal();
		
		dealArray.setOperationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		Deal deals = (Deal) session.getAttribute("deal");
		
	    deal.setDealId(deals.getDealId());
	    deal.setDealName(request.getParameter("dealName"));
	    deal.setDealDetails(request.getParameter("dealDetails"));
	    deal.setProductId(request.getParameter("productId"));
	    deal.setSellerId(request.getParameter("sellerid"));
		deal.setStartDate(GetDate.getDate(request.getParameter("startdate")));
		deal.setEndDate(GetDate.getDate(request.getParameter("enddate")));
	    deal.setLastModifiedUserId((String)session.getAttribute("username"));
	    dealOperations.setDealObj(deal);
	    dealOperations.setDealArray(dealArray);
	    

		dealArray=(DealArray) tableStub.dealOperations(dealOperations).get_return();
		String flag=dealArray.getResult();
		
		System.out.println(flag);
		if(flag.equals("success")){
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/dealjsps/UpdateReturnDeal.jsp");
			reqDis.forward(request,response);
		}
	}

}
