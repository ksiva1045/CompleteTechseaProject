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

public class InsertProductSellerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
		    HttpSession session=request.getSession(false);
			TableOperationsStub tableStub=new TableOperationsStub();
			SellerProductOperations sellerProductOperations=new SellerProductOperations();
			SellerProduct sellerProduct = new SellerProduct();
			SellerProductArray sellerProductArray=new SellerProductArray();
			String fromPage=(String) session.getAttribute("fromPage");
			
			sellerProductArray.setOperationName(Operations.INSERT);
			
			//String str=(String) request.getAttribute("productName");
			
			if(fromPage.equalsIgnoreCase("productid")){
				sellerProduct.setPid((String)session.getAttribute("productName"));
				sellerProduct.setSid(request.getParameter("sellerid"));
			}
			else if(fromPage.equalsIgnoreCase("sellerid")){
				sellerProduct.setPid(request.getParameter("productid"));
				sellerProduct.setSid((String)session.getAttribute("sellerName"));
			}
			
			
			sellerProduct.setPsprice(request.getParameter("PRODUCT_SELLER_PRICE"));
			
			sellerProductOperations.setSellerProductObj(sellerProduct);
			sellerProductOperations.setSellerProductArray(sellerProductArray);
			
			sellerProductArray= (SellerProductArray) tableStub.sellerProductOperations(sellerProductOperations).get_return();
			String flag=sellerProductArray.getResult();
			request.setAttribute("sucessFlag",flag);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/SellerProductJsps/InsertReturnProductSeller.jsp");
			reqDis.forward(request, response);		
		}

	}
