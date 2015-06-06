package com.deal;

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


public class SelectAllDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	
			TableOperationsStub tableStub=new TableOperationsStub();
			DealOperations dealOperations=new DealOperations();
			DealArray dealArray=new DealArray();
			Deal deal=new Deal();
			String id = request.getParameter("id");
			Deal[] deals=new Deal[1];
			if(id==null){
				dealArray.setOperationName(Operations.SELECTALL);
				dealOperations.setDealObj(deal);
				dealOperations.setDealArray(dealArray);
			
				dealArray=(DealArray) tableStub.dealOperations(dealOperations).get_return();
				deals=dealArray.getDeal();
			}
			
						
			else{
				
				Deal dealObj = new Deal();
				dealObj.setDealId(id);
				dealArray.setOperationName(Operations.SELECTBYID);
		dealOperations.setDealObj(dealObj);
		dealOperations.setDealArray(dealArray);
		Object obj=tableStub.dealOperations(dealOperations).get_return();

		
				if(obj instanceof String){
					flag = (String) obj;
				}
				else if(obj instanceof Deal){
					deals[0] = (Deal)obj;			
				}
			}
			if(!flag.equals("failure")){
				request.setAttribute("dealAll", deals);
				RequestDispatcher reqDisp = request.getRequestDispatcher("/dealjsps/SelectAllDeal.jsp");
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
