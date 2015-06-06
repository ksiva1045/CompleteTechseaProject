package com.coupon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Coupon;
import com.table.operations.TableOperationsStub.CouponArray;
import com.table.operations.TableOperationsStub.CouponOperations;

/**
 * Servlet implementation class SelectCouponlServlet
 */
public class SelectCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		TableOperationsStub tableStub=new TableOperationsStub();
	CouponOperations couponOperations=new CouponOperations();
	CouponArray couponArray = new CouponArray();
 Coupon coupon = new Coupon();
	
	couponArray.setOperationName(Operations.SELECTBYID);
		coupon.setCouponId(request.getParameter("id"));;
		couponOperations.setCouponObj(coupon);
		couponOperations.setCouponArray(couponArray);

		Object obj= tableStub.couponOperations(couponOperations).get_return();
		
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Coupon){
			coupon = (Coupon)obj;			
		}
		
		request.setAttribute("couponAll", coupon);
		RequestDispatcher reqDis = request.getRequestDispatcher("/Couponjsps/UpdateCoupon.jsp");
		reqDis.forward(request, response);
	
	}

}
