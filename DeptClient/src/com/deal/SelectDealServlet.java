package com.deal;

import java.io.IOException;




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
 * Servlet implementation class SelectDealServlet
 */
public class SelectDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		
		TableOperationsStub tableStub=new TableOperationsStub();
		DealOperations dealOperations=new DealOperations();
		DealArray dealArray=new DealArray();
		Deal deal=new Deal();
		dealArray.setOperationName(Operations.SELECTBYID);
		deal.setDealId(request.getParameter("id"));
		dealOperations.setDealObj(deal);
		dealOperations.setDealArray(dealArray);

		Object obj= tableStub.dealOperations(dealOperations).get_return();
		
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Deal){
			deal = (Deal)obj;			
		}
		
		request.setAttribute("dealObj", deal);
		RequestDispatcher reqDis = request.getRequestDispatcher("/ProductIDAndSellerID");
		reqDis.forward(request, response);
	
	}

}
