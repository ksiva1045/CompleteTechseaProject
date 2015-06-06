package com.sellerproducts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.SellerProduct;
import com.table.operations.TableOperationsStub.SellerProductArray;
import com.table.operations.TableOperationsStub.SellerProductOperations;

public class SelectAllProductSellerServlet  extends HttpServlet {
		private static final long serialVersionUID = 1L;

		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String flag="";
			try{	
				TableOperationsStub tableStub=new TableOperationsStub();
				SellerProductOperations sellerProductOperations=new SellerProductOperations();
				SellerProduct sellerProduct = new SellerProduct();
				SellerProductArray sellerProductArray=new SellerProductArray();
				String id = request.getParameter("id");
				SellerProduct[] sellerProducts=new SellerProduct[1];
				if(id==null){
					sellerProductArray.setOperationName(Operations.SELECTALL);
					sellerProductOperations.setSellerProductObj(sellerProduct);
					sellerProductOperations.setSellerProductArray(sellerProductArray);
				
					sellerProductArray=(SellerProductArray) tableStub.sellerProductOperations(sellerProductOperations).get_return();
					sellerProducts=sellerProductArray.getSellerProduct();
				}
				
							
				else{
					
					SellerProduct SellerProductObj  = new SellerProduct();
					SellerProductObj.setPsid(id);
					sellerProductArray.setOperationName(Operations.SELECTBYID);
					sellerProductOperations.setSellerProductObj(SellerProductObj);
					sellerProductOperations.setSellerProductArray(sellerProductArray);
			Object obj=tableStub.sellerProductOperations(sellerProductOperations).get_return();

			
					if(obj instanceof String){
						flag = (String) obj;
					}
					else if(obj instanceof SellerProduct){
						sellerProducts[0] = (SellerProduct)obj;			
					}
				}
				if(!flag.equals("failure")){
					request.setAttribute("sellerProductAll", sellerProducts);
					RequestDispatcher reqDisp = request.getRequestDispatcher("/SellerProductJsps/SellerProductsSelectAll.jsp");
					reqDisp.include(request, response);
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
				out.print("<center style='color:red'>");
		    	out.print("<h2>");
		    	out.print("No Record is found to Display");
		    	out.print("</h2>");
		    	out.print("</center>");
				
			}
		}

	}
