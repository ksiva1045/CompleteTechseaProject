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


public class UpdateSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String flag="failure";
		TableOperationsStub stub = new TableOperationsStub();
		SellerOperations sellerOperations = new SellerOperations();
		Seller seller = new  Seller();
        SellerArray sellerArray = new SellerArray();
		sellerArray.setOperationName(Operations.UPDATE);
        HttpSession session = request.getSession(false);
        Seller seller1 = (Seller) session.getAttribute("seller");
		
	    seller.setSid(seller1.getSid());
	    seller.setSName(request.getParameter("SellerName"));
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
	    seller.setLastModifiedUserId((String)session.getAttribute("username"));
	    sellerOperations.setSellerObj(seller);
	    sellerOperations.setSellerArray(sellerArray);
		sellerArray =  (SellerArray) stub.sellerOperations(sellerOperations).get_return();
		
		System.out.println((String)session.getAttribute("username"));
		
		flag = sellerArray.getResult();
		if(flag.equals("success")){
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/sellerjsps/sellerupdateReturn.jsp");
			reqDis.forward(request,response);
		}	
	
	}

}
