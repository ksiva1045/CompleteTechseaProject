package com.products;

import java.io.IOException;
import java.io.PrintWriter;

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



public class ClientServletSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("username",session.getAttribute("username"));
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		String flag1="";

		
		try{	
		TableOperationsStub tablestub=new TableOperationsStub();
		// products
		ProductOperations productoperations=new ProductOperations();
		ProductBean product=new ProductBean();
		ProductArray productarray=new ProductArray();
		productarray.setOperationName(Operations.SELECTALL);
		
		productoperations.setProductBean(product);
		productoperations.setProductArray(productarray);
		
		// product specifications
		ProductSpecificationOperations productspecOperations=new ProductSpecificationOperations();
		ProductSpecificationArray productspecArray=new ProductSpecificationArray();
		ProductSpecification productspec=new ProductSpecification();
		
		productspecArray.setOperationName(Operations.SELECTALL);
		productspecOperations.setProductSpecificObj(productspec);
		productspecOperations.setProductSpecificationArray(productspecArray);
		
		
	String id = request.getParameter("id");
	ProductBean[] productbean=new ProductBean[1];
	ProductSpecification[] productspec1=new ProductSpecification[1];
	
	// products
	if(id==null)
	{
		// products
		productarray=(ProductArray)tablestub.productOperations(productoperations).get_return();
				
     	 flag=productarray.getResult();
	    flag="success";
	 System.out.println(productbean.length);
	 productbean=productarray.getProduct();
	 
	 
	 // productspecifications
	 
	 if(id==null)
	 {
		 productspecArray=(ProductSpecificationArray)tablestub.productSpecificationOperations(productspecOperations).get_return();
					
	     	 flag=productspecArray.getResult();
		    flag="success";
		 System.out.println(productspec1.length);
		 productspec1=productspecArray.getProductSpecification();

	}//if
	
	else
	{
		// products
	
		product=new ProductBean();
		product.setProductId(id);
		product.setProductName(id);
		productarray.setOperationName(Operations.SELECTALL);
		productoperations.setProductArray(productarray);
		productoperations.setProductBean(product);
		Object obj=tablestub.productOperations(productoperations).get_return();
		
		
		// product specifications
		
		
		productspec=new ProductSpecification();
		productspec.setProduct_id(id);
		productspec.setProduct_typecode(id);
		productspecArray.setOperationName(Operations.SELECTALL);
		productspecOperations.setProductSpecificObj(productspec);
		productspecOperations.setProductSpecificationArray(productspecArray);
		Object obj1=tablestub.productSpecificationOperations(productspecOperations);
		
		
		if((obj instanceof String)&&(obj1 instanceof String)){
			flag = (String) obj;
			flag1 = (String) obj1;

	}//if
		else if((obj instanceof ProductBean)&&(obj1 instanceof ProductSpecification))
		{
			productbean[0] = (ProductBean)obj;
			productspec1[0] = (ProductSpecification)obj1;

			
		}//else if
	}//else
	
	if(!flag.equals("failure"))
	{
	request.setAttribute("productAll", productbean);
	request.setAttribute("productspecAll", productspec1);

	RequestDispatcher reqDisp = request.getRequestDispatcher("productjsps/SelectAll.jsp");
	reqDisp.include(request, response);
	}//if
	
	else
	{
	 	out.print("<center style='color:red'>");
    	out.print("<h2>");
    	out.print("No Records were selected to delete");
    	out.print("</h2>");
    	out.print("</center>");
	}
	//else
	}
	
	}//try
		catch(Exception e)
		{
			out.print("<center style='color:red'>");
	    	out.print("<h2>");
	    	out.print("No Record is found to Display");
	    	out.print("</h2>");
	    	out.print("</center>");
			e.printStackTrace();
		}//catch

	}//service
	
}//class
