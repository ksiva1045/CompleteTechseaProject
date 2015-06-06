package com.coupon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Coupon;
import com.table.operations.TableOperationsStub.CouponArray;
import com.table.operations.TableOperationsStub.CouponOperations;

/**
 * Servlet implementation class DeleteCouponServlet
 */
public class DeleteCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
		
				TableOperationsStub tableStub=new TableOperationsStub();
				CouponOperations couponOperations=new CouponOperations();
				CouponArray couponArray=new CouponArray();
				Coupon coupon=new Coupon();

				couponArray.setOperationName(Operations.DELETE);
				coupon.setCouponId(value);
couponOperations.setCouponObj(coupon);
couponOperations.setCouponArray(couponArray);

tableStub.couponOperations(couponOperations).get_return();
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
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Couponjsps/DeleteStatusCoupon.jsp");
			reqDispatcher.forward(request, response);
			
		}
		

	}

}
