package com.sellers;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class InsertSeller
 */
public class InsertSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag = "false";

		response.setContentType("text/html");
try{
		TableOperationsStub table = new TableOperationsStub();
		SellerOperations selleroperations = new SellerOperations();
		HttpSession session = request.getSession(false);
		Seller seller=new Seller();
		System.out.println((String)session.getAttribute("username"));
		seller.setSName(request.getParameter("SellerName"));
		seller.setSellerAddress(request.getParameter("SellerAddress"));
		seller.setSellerType(request.getParameter("SellerType"));
		seller.setSPincode(request.getParameter("SellerPincode"));
		seller.setSellerEmpContactNo(request.getParameter("SellerEmpContactNo"));
		seller.setSMarketingNo(request.getParameter("SellerMarketingNo"));
		seller.setSManagerNo(request.getParameter("SellerManagerNo"));
		seller.setSMarketingMailId(request.getParameter("SellerMarketingMailid"));
		seller.setSBusinessMailId(request.getParameter("SellerBusinessMailid"));
		seller.setBestTimeToContact(request.getParameter("BestTimeToContact"));
		seller.setContactFrequency(request.getParameter("ContactFrequency"));
		seller.setSellerCatId(request.getParameter("SellerCatId"));
		seller.setCreatedUserId((String)session.getAttribute("username"));
		SellerArray sellerArray =new SellerArray();
		sellerArray.setOperationName(Operations.INSERT);
		selleroperations.setSellerObj(seller);
		selleroperations.setSellerArray(sellerArray);
		sellerArray=(SellerArray)table.sellerOperations(selleroperations).get_return();
		flag=sellerArray.getResult();
	
	System.out.println(flag);
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
		
		request.setAttribute("sucessFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/sellerjsps/InsertsellerReturn.jsp");
		reqDis.forward(request, response);
		
	}



	}


