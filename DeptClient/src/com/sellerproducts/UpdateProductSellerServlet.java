package com.sellerproducts;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.SellerProduct;
import com.table.operations.TableOperationsStub.SellerProductArray;
import com.table.operations.TableOperationsStub.SellerProductOperations;

public class UpdateProductSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		
		
		SellerProductOperations sellerProductOperations=new SellerProductOperations();
		SellerProduct sellerProduct = new SellerProduct();
		SellerProductArray sellerProductArray=new SellerProductArray();
		
		sellerProductArray.setOperationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		SellerProduct sellerProducts = (SellerProduct) session.getAttribute("SellerProductObj");
		
		
		
		sellerProduct.setPsid(sellerProducts.getPsid());
		//sellerProduct.setPid(sellerProducts.getPid());

		sellerProduct.setPid(request.getParameter("Product_Name"));
		
		
		sellerProduct.setSid(request.getParameter("Seller_Name"));
		sellerProduct.setPsprice(request.getParameter("PRODUCT_SELLER_PRICE"));
		sellerProductOperations.setSellerProductObj(sellerProduct);
		sellerProductOperations.setSellerProductArray(sellerProductArray);
	    
		System.out.println("inside update servlet");
		sellerProductArray=(SellerProductArray) tableStub.sellerProductOperations(sellerProductOperations).get_return();
		String flag=sellerProductArray.getResult();
		
		System.out.println(flag);
		if(flag.equals("success")){
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/SellerProductJsps/UpdateReturnSellerProduct.jsp");
			reqDis.forward(request,response);
		}
	}

}
