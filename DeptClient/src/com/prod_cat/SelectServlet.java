package com.prod_cat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCatStatic;
import com.table.operations.TableOperationsStub.ProductCatStaticArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductCategoryStaticOperations;




public class SelectServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username"));
		session.setAttribute("toPage",session.getAttribute("toPage"));
		TableOperationsStub tableStub=new TableOperationsStub();
		
		//product categories
		ProductCategoryOperations productCategoryOperations=new ProductCategoryOperations(); 
		ProductCat productCat=new ProductCat();
		ProductCatArray productCatArray=new ProductCatArray();
		productCatArray.setOperationName(Operations.SELECTBYID);
		//System.out.println(request.getParameter("id"));
		productCat.setId(request.getParameter("id"));
		productCategoryOperations.setProCatObj(productCat);
		productCategoryOperations.setProCatArray(productCatArray);
		ProductCat  obj=(ProductCat) tableStub.productCategoryOperations(productCategoryOperations).get_return();		
		
		//product categories static
		ProductCategoryStaticOperations productCategoryStaticOperations=new ProductCategoryStaticOperations(); 
		ProductCatStatic productCatStatic=new ProductCatStatic();
		ProductCatStaticArray productCatStaticArray=new ProductCatStaticArray();
		productCatStaticArray.setOperationName(Operations.SELECTBYID);
		//System.out.println(request.getParameter("id"));
		productCatStatic.setProductcatid(request.getParameter("id"));
		productCategoryStaticOperations.setProCatStaticObj(productCatStatic);
		productCategoryStaticOperations.setProCatStaticArray(productCatStaticArray);
		ProductCatStatic  obj1=(ProductCatStatic) tableStub.productCategoryStaticOperations(productCategoryStaticOperations).get_return();
		
		 if((obj instanceof ProductCat)&&(obj1 instanceof ProductCatStatic)){
			productCat = (ProductCat)obj;	
			productCatStatic = (ProductCatStatic)obj1;
		}
		 
		request.setAttribute("productCatObj", productCat);
		request.setAttribute("productcatstaticObj", productCatStatic);

		RequestDispatcher reqDis = request.getRequestDispatcher("/NoOfProductParenIDServlet");
		reqDis.forward(request, response);
	
	}

}
