package com.payments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Deal;
import com.table.operations.TableOperationsStub.Payment;
import com.table.operations.TableOperationsStub.PaymentArray;
import com.table.operations.TableOperationsStub.PaymentaOperaction;

public class SelectAllPaymentServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	
			TableOperationsStub tableStub=new TableOperationsStub();
			PaymentaOperaction paymentoperation=new PaymentaOperaction();
			Payment p=new Payment();
			PaymentArray pArray=new PaymentArray();
			//System.out.println(request.getParameter("id"));
			String id1=request.getParameter("id");
			Payment[] pays=new Payment[1];
			int id = 0;
			if(id1== null){

				pArray.setOperationName(Operations.SELECTALL);
				paymentoperation.setP(p);
				paymentoperation.setPArray(pArray);
	pArray=(PaymentArray) tableStub.paymentaOperaction(paymentoperation).get_return();
	          pays=pArray.getPayments();   
	        //  for(int i=0;i<pays.length;i++)
	        	 // System.out.println(pays[i].getPAYMENT_DATE());
			}
			
			else{ 
				id = Integer.parseInt(id1);
				Payment payObj=new Payment();
				payObj.setPAYMENT_ID(id);	
				pArray.setOperationName(Operations.SELECTBYID);
				paymentoperation.setP(p);
				paymentoperation.setPArray(pArray);
				Object obj=tableStub.paymentaOperaction(paymentoperation).get_return();	

				if(obj instanceof String){
					flag = (String) obj;
				}
				else if(obj instanceof Payment){
					pays[0] = (Payment)obj;			
				}
			}
			if(!flag.equals("failure")){
				request.setAttribute("SelectAll", pays);
				RequestDispatcher reqDisp = request.getRequestDispatcher("/paymentsjsps/SelectAllPayment.jsp");
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
			e.printStackTrace();
			out.print("<center style='color:red'>");
	    	out.print("<h2>");
	    	out.print("No Record is found to Display");
	    	out.print("</h2>");
	    	out.print("</center>");
			
		}
			
			
		}
			
}