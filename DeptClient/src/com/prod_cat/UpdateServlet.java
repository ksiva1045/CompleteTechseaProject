package com.prod_cat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sellers.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCatStatic;
import com.table.operations.TableOperationsStub.ProductCatStaticArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductCategoryStaticOperations;



public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag="failure";
		String flag1="failure";

		TableOperationsStub stub = new TableOperationsStub();
		ProductCategoryOperations productCategoryOperations=new ProductCategoryOperations();
		
		ProductCat productCat=new ProductCat();
		ProductCatArray productCatArray =new ProductCatArray();
		productCatArray.setOperationName(Operations.UPDATE);
		
		ProductCategoryStaticOperations productcatstaticOperations=new ProductCategoryStaticOperations();
		ProductCatStatic productcatstatic=new ProductCatStatic();
		ProductCatStaticArray productcatstaticArray=new ProductCatStaticArray();
		
		productcatstaticArray.setOperationName(Operations.UPDATE);
		
        HttpSession session = request.getSession(false);
        
        // product category
        
        ProductCat productCat1=(ProductCat) session.getAttribute("productCat");
        productCat.setId(productCat1.getId());
		productCat.setPname(request.getParameter("PROD_CATAGORY_NAME"));
		productCat.setPdetails(request.getParameter("PROD_CATAGORY_DETAILS"));
		productCat.setProd_parent_id(request.getParameter("PRODUCT_PARENT_ID"));
		//System.out.println();
		System.out.println(productCat.getProd_parent_id());

		
		productCat.setLmuid((String)session.getAttribute("username"));
	   
		productCategoryOperations.setProCatObj(productCat);
		productCategoryOperations.setProCatArray(productCatArray);
	   	productCatArray=(ProductCatArray) stub.productCategoryOperations(productCategoryOperations).get_return();

		flag=productCatArray.getResult();

			// product category static

		   productcatstatic.setProductquality1(request.getParameter("PRODUCT_QUALITY_1"));
		   productcatstatic.setProductquality2(request.getParameter("PRODUCT_QUALITY_2"));
		   productcatstatic.setProductquality3(request.getParameter("PRODUCT_QUALITY_3"));
		   productcatstatic.setProductquality4(request.getParameter("PRODUCT_QUALITY_4"));
		   productcatstatic.setProductquality5(request.getParameter("PRODUCT_QUALITY_5"));
		   productcatstatic.setProductquality6(request.getParameter("PRODUCT_QUALITY_6"));
		   productcatstatic.setProductquality7(request.getParameter("PRODUCT_QUALITY_7"));
		   productcatstatic.setProductquality8(request.getParameter("PRODUCT_QUALITY_8"));
		   productcatstatic.setProductquality9(request.getParameter("PRODUCT_QUALITY_9"));
		   productcatstatic.setProductquality10(request.getParameter("PRODUCT_QUALITY_10"));
		   productcatstatic.setProductcatid(productCat1.getId());


			productcatstaticOperations.setProCatStaticObj(productcatstatic);
			productcatstaticOperations.setProCatStaticArray(productcatstaticArray);
			productcatstaticArray=(ProductCatStaticArray) stub.productCategoryStaticOperations(productcatstaticOperations).get_return();

			
			//System.out.println((String)session.getAttribute("username"));
			flag1=productcatstaticArray.getResult();
			
			System.out.println(flag+" : "+flag1);
			if(flag.equals("success")&&flag1.equals("success")){
				request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/productCatjspPages/UpdateProductCatReturn.jsp");
			reqDis.forward(request,response);
		}	
	
	}

}
