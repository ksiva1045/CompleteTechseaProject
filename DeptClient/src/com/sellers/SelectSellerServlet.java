package com.sellers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

/**
 * Servlet implementation class SelectSellerServlet
 */
public class SelectSellerServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username"));
		Seller seller1=(Seller)session.getAttribute("seller");
		TableOperationsStub stub = new TableOperationsStub();		
		SellerOperations selleroperation=new SellerOperations();
		Seller seller=new Seller();
		SellerArray sellerArray =new SellerArray();
		if(request.getParameter("id")==null){
			seller.setSid(seller1.getSid());
		}
		else{
			seller.setSid(request.getParameter("id"));
		}
	
		System.out.println(session.getAttribute("username"));
		sellerArray.setOperationName(Operations.SELECTBYID);
		selleroperation.setSellerObj(seller);;
		selleroperation.setSellerArray(sellerArray);
		Object obj=stub.sellerOperations(selleroperation).get_return();
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Seller){
			seller = (Seller)obj;
			
		}

		request.setAttribute("sellerObj", seller);
		RequestDispatcher reqDis = request.getRequestDispatcher("/sellerjsps/sellerupdate.jsp");
		reqDis.forward(request, response);
	}


	

}
