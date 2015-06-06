package com.sellerproducts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

/**
 * Servlet implementation class SelectAllSellerServlet
 */
public class ShowSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	
HttpSession session=request.getSession();
session.setAttribute("username",session.getAttribute("username"));
session.setAttribute("product", session.getAttribute("product"));
TableOperationsStub stub = new TableOperationsStub();
SellerOperations sellerOperation = new SellerOperations();
Seller sellerObj=new Seller();
com.table.operations.TableOperationsStub.SellerArray sellerArray=new com.table.operations.TableOperationsStub.SellerArray();
sellerArray.setOperationName(Operations.SELECTALL);
sellerOperation.setSellerObj(sellerObj);
sellerOperation.setSellerArray(sellerArray);

	String id = request.getParameter("id");
	Seller[] seller=new Seller[1];
	
	if(id==null){
		sellerArray=(SellerArray)stub.sellerOperations(sellerOperation).get_return();
		seller=sellerArray.getSeller();
		 
	flag="success";
	 System.out.println(seller.length);
	/*for(int i=0;i<seller.length;i++){
		Seller seller1 = seller[i];
		

		System.out.print(seller1.getSid()+"\t");
		System.out.print(seller1.getSName()+"\t");
		System.out.print(seller1.getSDetails()+"\t");
		System.out.print(seller1.getPid()+"\t");
	
		
		
	}*/
	}
	else{
		sellerObj=new Seller();
		 sellerObj.setSid(id);
		sellerArray.setOperationName(Operations.SELECTBYID);
		sellerOperation.setSellerObj(sellerObj);
		sellerOperation.setSellerArray(sellerArray);
		
		Object obj = stub.sellerOperations(sellerOperation).get_return();
		if(obj instanceof String){
			flag = (String) obj;
		}
		else if(obj instanceof Seller){
			seller[0] = (Seller)obj;
			
		}
		
	
	}
	if(!flag.equals("failure")){
	
	request.setAttribute("sellerAll", seller);
	RequestDispatcher reqDisp = request.getRequestDispatcher("/SellerProductJsps/ShowSellers.jsp");
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
