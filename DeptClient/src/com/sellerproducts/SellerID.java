package com.sellerproducts;

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
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;
import com.table.operations.TableOperationsStub.SellerProduct;

/**
 * Servlet implementation class SellerID
 */
public class SellerID extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();
		String toPages=(String) session.getAttribute("toPage");
		String fromPage=(String)session.getAttribute("fromPage");
		if(fromPage.equalsIgnoreCase("ProductUpdate")){
			toPages="insert";
		}
		else if(fromPage.equalsIgnoreCase("SellerUpdate")){
			toPages="insertseller";
		}
		System.out.println("inside sellerid servlet topages"+toPages);
		String sellerName="";
		
		session.setAttribute("product", session.getAttribute("product"));
		//sellers
				SellerOperations sellerOperations = new SellerOperations();
				Seller sellerObj = new Seller();
				
				SellerArray sellerArray = new SellerArray();
				sellerArray.setOperationName(Operations.SELECTALL);
				sellerOperations.setSellerObj(sellerObj);
				sellerOperations.setSellerArray(sellerArray);
				sellerArray=(SellerArray) stub.sellerOperations(sellerOperations).get_return();
				
				sellerName=request.getParameter("Seller_Name");
				System.out.println("inside sellerid servlet : "+sellerName);
				System.out.println("inside sellerid servlet : "+sellerArray);
				SellerProduct sellerProduct1=(SellerProduct) session.getAttribute("SellerProduct");
				
				Seller[] seller=null;
				if(sellerArray!=null){
					seller = sellerArray.getSeller();

					for(int i=0;i<seller.length;i++){

						if(seller[i].getSName().equalsIgnoreCase(sellerName)){
							//System.out.println("inside productid servlet if condition");

							sellerName=seller[i].getSid();
							//System.out.println("inside productid servlet : "+productName);
						}
					}
				}

				
				
				
				try{
					RequestDispatcher reqDis=null;
				
				
				request.setAttribute("sellerArray",sellerArray);
				System.out.println(toPages+" success");
				
				if(toPages.equalsIgnoreCase("insert")){
					reqDis =  request.getRequestDispatcher("/SellerProductJsps/InsertSellerProduct.jsp");
				}
				else if(toPages.equalsIgnoreCase("insertseller")){
					session.setAttribute("sellerName",sellerName);
					session.setAttribute("fromPage", "sellerid");
					reqDis =  request.getRequestDispatcher("/InsertProductSellerServlet");
				}
				
				else if(toPages.equalsIgnoreCase("update")){														
	
					request.setAttribute("SellerProductObj", request.getAttribute("SellerProductObj"));
					reqDis =  request.getRequestDispatcher("/SellerProductJsps/UpdateSellerProduct.jsp");
				}
				
				reqDis.forward(request, response);
				}
				
				
				
			catch(Exception e){
				e.printStackTrace();
			}
				
				
	
}
}