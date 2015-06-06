package com.areasearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clientsupport.SelectAllData;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;

public class RelatedProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId=request.getParameter("productid");
		
		int productPrice = 0;
		int highPrice=0;
		int lowPrice=0;
		
		//Getting all records from products table
		ProductArray productArray=SelectAllData.productSellectAll();
		if(productArray!=null){
			//Storing data from productArray to product
			ProductBean[] product=productArray.getProduct();			

			//Getting price of the product
			for(int i=0;i<product.length;i++)
			{			
				if(product[i].getProductId().equalsIgnoreCase(productId)){
					productPrice = 	Integer.parseInt(product[i].getPrice());
				}
			}
			
			//calculating near price
			highPrice=productPrice+2000;
			lowPrice=productPrice-2000;
			
			//Getting related products and store into productArray
			productArray=new ProductArray();
			int price=0;
			for(int i=0;i<product.length;i++)
			{	
				price=Integer.parseInt(product[i].getPrice());
				if((price<=highPrice)&&(price>=lowPrice)){
					productArray.addProduct(product[i]);
				}
				
			}
			
		}
		try{
			//forwarding data to the jsp file 
			request.setAttribute("productArray",productArray);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/areajsps/relatedproducts.jsp");
			reqDis.forward(request, response);																						
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
