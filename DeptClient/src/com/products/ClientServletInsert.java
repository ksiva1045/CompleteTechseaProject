package com.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.ProductSpecification;
import com.table.operations.TableOperationsStub.ProductSpecificationArray;
import com.table.operations.TableOperationsStub.ProductSpecificationOperations;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = "false";
		String staticFlag = "false";
		response.setContentType("text/html");
		
		TableOperationsStub table = new TableOperationsStub();
		HttpSession session = request.getSession(false);
		
	try
	{
		//products
		ProductBean product=(ProductBean)session.getAttribute("product");
		ProductArray productarray=new ProductArray();
		ProductOperations productoperations = new ProductOperations();		
	    productarray.setOperationName(Operations.INSERT);
        productoperations.setProductBean(product);
		productoperations.setProductArray(productarray);
		
	    //productSpecification
		ProductSpecificationOperations productSpecificationOperations = new ProductSpecificationOperations();
		ProductSpecification productSpecification = new ProductSpecification();
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		
		productSpecification.setProduct_typecode(request.getParameter("product_typecode"));
		productSpecification.setProduct_colour(request.getParameter("product_colour"));
		productSpecification.setProduct_size(request.getParameter("product_size"));
		productSpecification.setProduct_features(request.getParameter("product_features"));
		productSpecification.setProduct_quality4(request.getParameter("productquality4"));
 
		productSpecification.setProduct_quality5(request.getParameter("productquality5"));
		productSpecification.setProduct_quality6(request.getParameter("productquality6"));
		productSpecification.setProduct_quality7(request.getParameter("productquality7"));
		productSpecification.setProduct_quality8(request.getParameter("productquality8"));
		productSpecification.setProduct_quality9(request.getParameter("productquality9"));
		productSpecification.setProduct_quality10(request.getParameter("productquality10"));
		
		productSpecificationArray.setOperationName(Operations.INSERT);
	    productSpecificationOperations.setProductSpecificObj(productSpecification);	    
	    productSpecificationOperations.setProductSpecificationArray(productSpecificationArray);

	    productarray = (ProductArray)table.productOperations(productoperations).get_return();
		flag=productarray.getResult();

        productSpecificationArray = (ProductSpecificationArray) table.productSpecificationOperations(productSpecificationOperations).get_return();
		staticFlag=productSpecificationArray.getResult();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	if(!flag.equals(staticFlag))
		flag="false";
	
	request.setAttribute("sucessFlag",flag);
	
	RequestDispatcher reqDis =  request.getRequestDispatcher("/productjsps/insertReturn.jsp");
	reqDis.forward(request, response);

	}
	
}
