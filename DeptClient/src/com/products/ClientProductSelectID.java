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
 * Servlet implementation class ClientProductSelectID
 */
public class ClientProductSelectID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("toPage", session.getAttribute("toPage"));
		session.setAttribute("username",session.getAttribute("username")); 
		
		TableOperationsStub tablestub=new TableOperationsStub();
		
		
		//products
		ProductBean productBean=null;
		productBean=(ProductBean)session.getAttribute("product");
		
		ProductOperations productoperation=new ProductOperations();
		ProductBean product=new ProductBean();
		ProductArray productarray=new ProductArray();
		
		System.out.println("inside servlet : "+request.getParameter("id"));
		if(request.getParameter("id")==null){
			System.out.println("inside ClientProductSelectID product values: if block");
			System.out.println("inside ClientProductSelectID product values: "+productBean.getProductId());
			session.setAttribute("toPage","update");
			product.setProductId(productBean.getProductId());
		}
		else{
			System.out.println("inside ClientProductSelectID product values: else block");
			System.out.println("inside ClientProductSelectID product values:"+request.getParameter("id"));
			session.setAttribute("toPage",session.getAttribute("toPage"));
			product.setProductId(request.getParameter("id"));
		}
		
		productarray.setOperationName(Operations.SELECTBYID);
		
		productoperation.setProductArray(productarray);
		productoperation.setProductBean(product);
		Object obj = tablestub.productOperations(productoperation).get_return();
		
		//product Specifications
		ProductSpecificationOperations productSpecificationOperations=new ProductSpecificationOperations();
		ProductSpecification productSpecification=new ProductSpecification();		
		ProductSpecificationArray productSpecificationArray=new ProductSpecificationArray();
		if(request.getParameter("id")==null){
			productSpecification.setProduct_id(productBean.getProductId());
		}
		else{
			productSpecification.setProduct_id(request.getParameter("id"));
		}
		
		productSpecificationArray.setOperationName(Operations.SELECTBYID);
		
		productSpecificationOperations.setProductSpecificObj(productSpecification);
		productSpecificationOperations.setProductSpecificationArray(productSpecificationArray);
		Object obj1=tablestub.productSpecificationOperations(productSpecificationOperations).get_return();
		
		
		if((obj instanceof ProductBean)&&(obj1 instanceof ProductSpecification)){
			product = (ProductBean)obj;
			productSpecification = (ProductSpecification)obj1;
		}
		
		session.setAttribute("product", product);
		request.setAttribute("productSpecification",productSpecification);
		RequestDispatcher reqDis = request.getRequestDispatcher("/ProductCatIDServlet");
		reqDis.forward(request, response);
	}

}
