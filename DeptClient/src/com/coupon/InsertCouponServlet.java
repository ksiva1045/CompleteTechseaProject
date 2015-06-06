package com.coupon;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class InsertCouponServlet
 */
public class InsertCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		TableOperationsStub tableStub=new TableOperationsStub();
		CouponOperations couponOperations=new CouponOperations();
		Coupon coupon=new Coupon();
		CouponArray couponArray=new CouponArray();
		couponArray.setOperationName(Operations.INSERT);
	
	
		//System.out.println(session.getAttribute("username"));
		coupon.setCouponName(request.getParameter("couponName"));
		coupon.setCouponCode(request.getParameter("couponCode"));
		coupon.setCouponDetails(request.getParameter("couponDetails"));
		coupon.setSellerId(request.getParameter("sellerId"));
		coupon.setIssueDate(GetDate.getDate(request.getParameter("issueDate")));
		coupon.setExpireDate(GetDate.getDate(request.getParameter("expireDate")));
		
		coupon.setCreatedUserId((String)session.getAttribute("username"));
		
		couponOperations.setCouponObj(coupon);
		couponOperations.setCouponArray(couponArray);
		
		couponArray=(CouponArray) tableStub.couponOperations(couponOperations).get_return();

		String flag=couponArray.getResult();
		request.setAttribute("successFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/Couponjsps/InsertReturnCoupon.jsp");
		reqDis.forward(request, response);		
	}

}
