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


public class SelectAllCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	
			TableOperationsStub tableStub=new TableOperationsStub();
			CouponOperations couponOperations = new CouponOperations();
			CouponArray couponArray = new CouponArray();
			Coupon coupon = new Coupon();
		
			String id = request.getParameter("id");
			
       Coupon[] coupons=new Coupon[1];
			if(id==null){
				couponArray.setOperationName(Operations.SELECTALL);
				couponOperations.setCouponObj(coupon);
				couponOperations.setCouponArray(couponArray);
			
				couponArray=(CouponArray) tableStub.couponOperations(couponOperations).get_return();
				coupons=couponArray.getCoupon();
				flag="success";
			}
			
						
			else{
				
				Coupon couponObj = new Coupon();
				couponObj.setCouponId(id);
				couponArray.setOperationName(Operations.SELECTBYID);
                couponOperations.setCouponObj(couponObj);
                couponOperations.setCouponArray(couponArray);
		Object obj=tableStub.couponOperations(couponOperations).get_return();

		
				if(obj instanceof String){
					flag = (String) obj;
				}
				else if(obj instanceof Coupon){
					coupons[0] = (Coupon)obj;			
				}
			}
			if(!flag.equals("failure")){
				System.out.println("error in jsp");
				request.setAttribute("couponAll", coupons);
				RequestDispatcher reqDisp = request.getRequestDispatcher("/Couponjsps/SelectAllCoupon.jsp");
				System.out.println("error because of coding by jhansi");
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
