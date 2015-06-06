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

public class InsertProductCatServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	  
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String flag = "false";
			String staticFlag = "false";
			response.setContentType("text/html");
			TableOperationsStub table = new TableOperationsStub();
			HttpSession session = request.getSession(false);
			
			try{
				//ProductCat
				ProductCategoryOperations productCatOperations=new ProductCategoryOperations();			
				ProductCat productCat=new ProductCat();
				ProductCatArray productCatArray=new ProductCatArray();
				
				productCat.setPname(request.getParameter("PROD_CATAGORY_NAME"));
				productCat.setPdetails(request.getParameter("PROD_CATAGORY_DETAILS"));
				productCat.setProd_parent_id(request.getParameter("PRODUCT_PARENT_ID"));
				productCat.setCuid((String)session.getAttribute("username"));
			
				productCatArray.setOperationName(Operations.INSERT);
				productCatOperations.setProCatObj(productCat);
				productCatOperations.setProCatArray(productCatArray);
			
			
				//ProductCatStatic
				ProductCategoryStaticOperations productCatStaticOperations=new ProductCategoryStaticOperations();				
				ProductCatStatic productCatStatic = new ProductCatStatic();
				ProductCatStaticArray proCatStaticArray = new ProductCatStaticArray();
		    
				//
				productCatStatic.setProductquality1(request.getParameter("productquality1"));
				productCatStatic.setProductquality2(request.getParameter("productquality2"));
				productCatStatic.setProductquality3(request.getParameter("productquality3"));
				productCatStatic.setProductquality4(request.getParameter("productquality4"));
				productCatStatic.setProductquality5(request.getParameter("productquality5"));
				productCatStatic.setProductquality6(request.getParameter("productquality6"));
				productCatStatic.setProductquality7(request.getParameter("productquality7"));
				productCatStatic.setProductquality8(request.getParameter("productquality8"));
				productCatStatic.setProductquality9(request.getParameter("productquality9"));
				productCatStatic.setProductquality10(request.getParameter("productquality10"));
			//	productCatStatic.setProductcatid("34");

				proCatStaticArray.setOperationName(Operations.INSERT);
				productCatStaticOperations.setProCatStaticObj(productCatStatic);
				productCatStaticOperations.setProCatStaticArray(proCatStaticArray);
		
				productCatArray=(ProductCatArray) table.productCategoryOperations(productCatOperations).get_return();
				flag= productCatArray.getResult();
				proCatStaticArray=(ProductCatStaticArray) table.productCategoryStaticOperations(productCatStaticOperations).get_return();
				staticFlag= proCatStaticArray.getResult();		
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			if(!flag.equals(staticFlag))
				flag="false";
			
			request.setAttribute("sucessFlag",flag);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/productCatjspPages/InsertProductCatReturn.jsp");
			reqDis.forward(request, response);
			
		}

	}

