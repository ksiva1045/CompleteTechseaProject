package com.prod_cat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.DealArray;
import com.table.operations.TableOperationsStub.DealOperations;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCatStatic;
import com.table.operations.TableOperationsStub.ProductCatStaticArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductCategoryStaticOperations;

public class DeleteProductCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
				TableOperationsStub tableStub=new TableOperationsStub();
				
				// product category static				
				ProductCategoryStaticOperations productcatstaticOperations=new ProductCategoryStaticOperations();
				ProductCatStatic productcatstatic=new ProductCatStatic();
				ProductCatStaticArray productcatstaticArray=new ProductCatStaticArray();
	
				productcatstaticArray.setOperationName(Operations.DELETE);
				productcatstatic.setProductcatid(value);
			
				productcatstaticOperations.setProCatStaticObj(productcatstatic);
				productcatstaticOperations.setProCatStaticArray(productcatstaticArray);				
				tableStub.productCategoryStaticOperations(productcatstaticOperations).get_return();

				// product category
				ProductCategoryOperations productCatOperations=new ProductCategoryOperations();
				ProductCatArray productCatArray=new ProductCatArray();
				ProductCat productCat=new ProductCat();

				productCatArray.setOperationName(Operations.DELETE);
				productCat.setId(value);

				productCatOperations.setProCatObj(productCat);
				productCatOperations.setProCatArray(productCatArray);						
				tableStub.productCategoryOperations(productCatOperations).get_return();
		
				count++;
				
			}
		}		
		else{    	
            	out.print("<center style='color:red'>");
            	out.print("<h2>");
            	out.print("No Records were selected to delete");
            	out.print("</h2>");
            	out.print("</center>");
            	
            	
		}
		if(count>0){
			request.setAttribute("count", count);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("productCatjspPages/DeleteStatus.jsp");
			reqDispatcher.forward(request, response);

		}
	}

}
