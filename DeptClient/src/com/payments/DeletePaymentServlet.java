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
import com.table.operations.TableOperationsStub.Payment;
import com.table.operations.TableOperationsStub.PaymentArray;
import com.table.operations.TableOperationsStub.PaymentaOperaction;


	public class DeletePaymentServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			String ar[] = request.getParameterValues("checkval");
			//String ar[]=(String) request.getParameter("checkval");
			int count=0;
			if(ar.length>0)
			{
				for(int i=0;i<ar.length;i++)
				{
					System.out.println(ar[i]);
					String value= ar[i];
					int s=Integer.parseInt(value);
				TableOperationsStub tableStub=new TableOperationsStub();
				PaymentaOperaction paymentoperation=new PaymentaOperaction();
				Payment p=new Payment();
				PaymentArray pArray=new PaymentArray();
				pArray.setOperationName(Operations.DELETE);	
				p.setPAYMENT_ID(s);
				paymentoperation.setP(p);
				paymentoperation.setPArray(pArray);
				 tableStub.paymentaOperaction(paymentoperation).get_return();
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
				System.out.println(count);

				request.setAttribute("count", count);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/paymentsjsps/DeleteStatusPayments.jsp");
				reqDispatcher.forward(request, response);
				
			}
			

		}

				
  
	}
