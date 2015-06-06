package com.areasearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clientsupport.SelectAllData;
import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductOperations;


/**
 * Servlet implementation class ProductCatIDProductIDSevlet
 */
public class ProductCatIDProductIDSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();		
		ProductCatArray productCatArray1=null;
		 //System.out.println("Inside ProductCatIDProductIDSevlet");
		session.setAttribute("username",session.getAttribute("username"));
		session.setAttribute("callerMobileNo", request.getParameter("callerMobileNo"));
		session.setAttribute("startTime",session.getAttribute("startTime"));
		
		//ProductCategoryOperations
		ProductCategoryOperations productCategoryOperations = new ProductCategoryOperations();
		ProductCat productCat = new ProductCat();		
		ProductCatArray productCatArray = new ProductCatArray();
		productCatArray.setOperationName("selectByParentId");
		productCat.setId("22201");
		productCategoryOperations.setProCatObj(productCat);
		productCategoryOperations.setProCatArray(productCatArray);
		productCatArray=(ProductCatArray) stub.productCategoryOperations(productCategoryOperations).get_return();
		ProductCat[] procat=productCatArray.getProductCat();

		
		//ProductCategoryOperations

		ProductCat productCat1 = new ProductCat();		
		productCatArray1 = new ProductCatArray();
		productCatArray1.setOperationName("selectByParentId");
		
		if(request.getParameter("productcatid")!=null){
			productCat1.setId(request.getParameter("productcatid"));
		}
		else{
			productCat1.setId(procat[0].getId());
		}
		productCategoryOperations.setProCatObj(productCat1);
		productCategoryOperations.setProCatArray(productCatArray1);
		productCatArray1=(ProductCatArray) stub.productCategoryOperations(productCategoryOperations).get_return();

		//product table data		
		ProductArray productArray=SelectAllData.productSellectAll();
		
		/*ProductOperations productOperations = new ProductOperations();
		ProductBean productObj = new ProductBean();
		ProductArray productArray = new ProductArray();
		productArray.setOperationName(Operations.SELECTALL);
		productOperations.setProductBean(productObj);
		productOperations.setProductArray(productArray);
		productArray = (ProductArray) stub.productOperations(productOperations).get_return();*/

		
		
		ProductCat[] productCatTemp=null; 
		if(productCatArray1!=null){	
			productCatTemp=productCatArray1.getProductCat();
		}
		
		ProductBean[] productBean1=null;
		if(productArray!=null){	
			productBean1=productArray.getProduct();
			productArray=new ProductArray();
		}
		
		if(request.getParameter("productcatid1")!=null){
			for(int i=0;i<productBean1.length;i++){
				if(productBean1[i].getProuduct_cat_id().equalsIgnoreCase(request.getParameter("productcatid1"))){
					System.out.println("aftr changing data "+request.getParameter("productcatid1"));
					productArray.addProduct(productBean1[i]);
				}
			}
		}
		else{
			for(int i=0;i<productBean1.length;i++){
				if(productBean1[i].getProuduct_cat_id().equalsIgnoreCase(productCatTemp[0].getId())){
					System.out.println("aftr changing data "+productCatTemp[0].getId());
					productArray.addProduct(productBean1[i]);
				}
			}
		}
		
		/*
		if(request.getParameter("productcatid1")!=null){
			ProductBean[] productBean1=null;			
			if(productArray!=null){	
				productBean1=productArray.getProduct();
				productArray=new ProductArray();
				for(int i=0;i<productBean1.length;i++){
					if(productBean1[i].getProuduct_cat_id().equalsIgnoreCase(request.getParameter("productcatid1"))){
						System.out.println("aftr changing data "+request.getParameter("productcatid1"));
						productArray.addProduct(productBean1[i]);
					}
					/*else{
						productArray.addProduct(productBean1[1]);
					}
				}

			}
		}*/
		
		try{

			//product
			
			//request.setAttribute("productArray",productArray);

			//ProductCatageries
			session.setAttribute("productcatid", request.getParameter("productcatid"));
			session.setAttribute("productcatid1", request.getParameter("productcatid1"));
			request.setAttribute("productCatArray",productCatArray);
			request.setAttribute("productCatArray1",productCatArray1);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/areajsps/area.jsp");

			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
