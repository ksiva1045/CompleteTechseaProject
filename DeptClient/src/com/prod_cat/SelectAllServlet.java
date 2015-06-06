package com.prod_cat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCatStatic;
import com.table.operations.TableOperationsStub.ProductCatStaticArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductCategoryStaticOperations;

public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();

		HttpSession session = request.getSession(false);
		String flag="";
		try{	
			//product categories
			ProductCategoryOperations productCatOperations=new ProductCategoryOperations();
			ProductCat productCatObj=new ProductCat();

			ProductCatArray productCatArray=new ProductCatArray();
			productCatArray.setOperationName(Operations.SELECTALL);
			productCatOperations.setProCatObj(productCatObj);
			productCatOperations.setProCatArray(productCatArray);


			String id = request.getParameter("id");
			ProductCat[] productCat=new ProductCat[1];
	
	
	//product category static
	
			ProductCategoryStaticOperations productcatstaticOperations=new ProductCategoryStaticOperations();
			ProductCatStatic productcatstaticObj=new ProductCatStatic();
			ProductCatStaticArray productcatstaticArray=new ProductCatStaticArray();
			productcatstaticArray.setOperationName(Operations.SELECTALL);
			productcatstaticOperations.setProCatStaticObj(productcatstaticObj);
			productcatstaticOperations.setProCatStaticArray(productcatstaticArray);


			id= request.getParameter("productcatstatic");
			ProductCatStatic[] productcatstatic1=new ProductCatStatic[1];
		
	
	
	
	
	
	
	
	
			if(id==null){
				
				// product category	
				productCatArray=(com.table.operations.TableOperationsStub.ProductCatArray) stub.productCategoryOperations(productCatOperations).get_return();
				productCat= productCatArray.getProductCat();
				
				// product category	static
				productcatstaticArray=(ProductCatStaticArray) stub.productCategoryStaticOperations(productcatstaticOperations).get_return();
				productcatstatic1= productcatstaticArray.getProductcatstatic();
				flag="success";
	
			}
			else{
				// product category
				
				productCatObj=new ProductCat();
				productCatObj.setPname(id);
				productCatArray.setOperationName(Operations.SELECTBYID);
		
				productCatOperations.setProCatObj(productCatObj);
				productCatOperations.setProCatArray(productCatArray);
				Object obj=stub.productCategoryOperations(productCatOperations);
				
				// product category static 
				
				
				productcatstaticObj=new ProductCatStatic();
				productcatstaticObj.setProductcategorystatic(id);
				productcatstaticArray.setOperationName(Operations.SELECTBYID);
		
				productcatstaticOperations.setProCatStaticObj(productcatstaticObj);
				productcatstaticOperations.setProCatStaticArray(productcatstaticArray);
				Object obj1=stub.productCategoryStaticOperations(productcatstaticOperations).get_return();
				
				
				// product category

				if(obj instanceof String) {
					flag = (String) obj;
				}
				else if(obj instanceof ProductCat){
					productCat[0] = (ProductCat)obj;
			
				}
		
	
				// product category static
				
				if(obj1 instanceof String) {
					flag = (String) obj1;
				}
				else if(obj1 instanceof ProductCatStatic){
					productcatstatic1[0] = (ProductCatStatic)obj1;
			
				}
					
			}
			if(!flag.equals("failure")){
	
				request.setAttribute("productCatAll", productCat);
				request.setAttribute("productCatStaticAll", productcatstatic1);

				
				RequestDispatcher reqDisp = request.getRequestDispatcher("productCatjspPages/SelectAllProductCat.jsp");
				reqDisp.forward(request, response);
			}
			else
			{
		
				out.print("<center style='color:red'>");
				out.print("<h2>");
				out.print("No Records were selected to delete");
				out.print("</h2>");
				out.print("</center>");
			}
		}
		catch(Exception e){
			e.printStackTrace();

		}

	}
}
