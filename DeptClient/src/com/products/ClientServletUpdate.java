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
 * Servlet implementation class ClientServletUpdate
 */
public class ClientServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag="failure";
		String flag1="failure";
		TableOperationsStub tablestub=new TableOperationsStub();
		ProductOperations productoperaions=new ProductOperations();
		//ProductBean product=new ProductBean();
		ProductArray productarray=new ProductArray();
		productarray.setOperationName(Operations.UPDATE);
		ProductSpecificationOperations productSpecificationOperations = new ProductSpecificationOperations();
		ProductSpecification productSpecification = new ProductSpecification();
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		productSpecificationArray.setOperationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		
      //product
		ProductBean product = (ProductBean)session.getAttribute("product");
		
		if(request.getParameter("ptcode")!=null){
			product.setProductId(product.getProductId());
			product.setProductCode(request.getParameter("ptcode"));
			product.setProductName(request.getParameter("pname"));
			product.setPrice(request.getParameter("pprice"));
			product.setServiceCode(request.getParameter("pscode"));
			product.setProuduct_cat_id(request.getParameter("prod_cat_id"));
			product.setLastModifiedUserID((String)session.getAttribute("username"));
		}

		productoperaions.setProductArray(productarray);
		productoperaions.setProductBean(product);
		productarray=(ProductArray) tablestub.productOperations(productoperaions).get_return();
		flag=productarray.getResult();
		
		
		//product Specification
		if(request.getParameter("ptcode")==null){
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
			productSpecification.setProduct_id(product.getProductId());
	        productSpecificationOperations.setProductSpecificObj(productSpecification);
	        productSpecificationOperations.setProductSpecificationArray(productSpecificationArray);
	        productSpecificationArray = (ProductSpecificationArray) tablestub.productSpecificationOperations(productSpecificationOperations).get_return();
	        flag1=productSpecificationArray.getResult();
	        
	        if(flag.equals("success")&&flag1.equals("success")){
				request.setAttribute("sucessFlag",flag);
				RequestDispatcher reqDis = 	request.getRequestDispatcher("productjsps/UpdateReturn.jsp");
				reqDis.forward(request,response);
			}
		}
		else{
			if(flag.equals("success")){
				request.setAttribute("sucessFlag",flag);
				RequestDispatcher reqDis = 	request.getRequestDispatcher("productjsps/UpdateReturn.jsp");
				reqDis.forward(request,response);
			}
		}						
	}
}
