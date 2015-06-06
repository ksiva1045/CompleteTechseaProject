package com.products;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;

/**
 * Servlet implementation class ProductSearchByWord
 */
public class ProductSearchByWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String term = request.getParameter("term");
		String productCatId=request.getParameter("productCatId");
		
		System.out.println(term);
		System.out.println(productCatId);
	
		if(term!=null){
			term=term+"%";
			
			//Getting all products from product table
			TableOperationsStub stub = new TableOperationsStub();
			ProductOperations productOperations=new ProductOperations();
			ProductBean productBean=new ProductBean();
			ProductArray productArray=new ProductArray();
			productArray.setOperationName("getProductByWord");
			productBean.setProductName(term);
			productOperations.setProductBean(productBean);
			productOperations.setProductArray(productArray);
			productArray=(ProductArray) stub.productOperations(productOperations).get_return();
			
			ArrayList<String> list=new ArrayList<String>();
			ProductBean[] product=productArray.getProduct();
			for(int i=0;i<product.length;i++){
				if(product[i].getProuduct_cat_id().equalsIgnoreCase(productCatId)){
					list.add(product[i].getProductName());
				}
				
				System.out.println("Inside ProductSearchByWord Product names "+product[i].getProductName());
			}
			try{
				String searchList = new Gson().toJson(list);
				System.out.println("hi");
	            response.getWriter().write(searchList);
			}
			
			catch (Exception e) {
                System.err.println(e.getMessage());
			}
			
		}
	}

}
