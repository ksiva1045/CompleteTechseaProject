package com.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductCatStatic;
import com.table.operations.TableOperationsStub.ProductCatStaticArray;
import com.table.operations.TableOperationsStub.ProductCategoryStaticOperations;


/**
 * Servlet implementation class ProductCatStaticServlet
 */
public class ProductCatStaticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();	
		String toPages=(String) session.getAttribute("toPage");
			
		ProductBean product=new ProductBean();
		
		product.setProductCode(request.getParameter("ptcode"));
		product.setProductName(request.getParameter("pname"));
		product.setPrice(request.getParameter("pprice"));
	    product.setServiceCode(request.getParameter("pscode"));
	    product.setProuduct_cat_id(request.getParameter("prod_cat_id"));
	    
	    
		if(toPages.equalsIgnoreCase("update")){
			ProductBean product1=(ProductBean) session.getAttribute("product");
			product.setProductId(product1.getProductId());
	        product.setLastModifiedUserID((String)session.getAttribute("username"));
		}

	    if(toPages.equalsIgnoreCase("insert")){
	        product.setCreatedUserID((String)session.getAttribute("username"));

	    }
	        
        ProductCategoryStaticOperations productCategoryStaticOperations=new ProductCategoryStaticOperations();
        ProductCatStaticArray productCatStaticArray=new ProductCatStaticArray();
        ProductCatStatic productCatStatic=new ProductCatStatic();
	     
	    if(request.getParameter("prod_cat_id")!=null){
	    	System.out.println("if block : "+request.getParameter("prod_cat_id"));
			productCatStatic.setProductcatid(request.getParameter("prod_cat_id"));	
	    }
	    else{
	    	System.out.println("else block");
	    	productCatStatic.setProductcatid("22244");	
	    }
				
		productCatStaticArray.setOperationName(Operations.SELECTBYID);
		productCategoryStaticOperations.setProCatStaticObj(productCatStatic);
		productCategoryStaticOperations.setProCatStaticArray(productCatStaticArray);
		Object obj=productCatStatic=(ProductCatStatic) stub.productCategoryStaticOperations(productCategoryStaticOperations).get_return();
			
		
		if(obj instanceof ProductCatStatic){
			productCatStatic = (ProductCatStatic)obj;
		}
		     
		try{
			RequestDispatcher reqDis=null;

			if(toPages.equalsIgnoreCase("insert")){
				   System.out.println("inside servlet product type code(INSERT) : "+request.getParameter("ptcode"));
					
				request.setAttribute("productCatStatic", productCatStatic);
				session.setAttribute("product", product);
				reqDis =  request.getRequestDispatcher("/productjsps/productSpecifications.jsp");
			}
			else if(toPages.equalsIgnoreCase("update")){
				   System.out.println("inside servlet product type code(UPDATE) : "+request.getParameter("ptcode"));
					
				session.setAttribute("product", product);
				request.setAttribute("productCatStatic", productCatStatic);
				session.setAttribute("productSpecification", session.getAttribute("productSpecification"));
				reqDis =  request.getRequestDispatcher("/productjsps/productSpecificationUpdate.jsp");
			}
			
		
			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
