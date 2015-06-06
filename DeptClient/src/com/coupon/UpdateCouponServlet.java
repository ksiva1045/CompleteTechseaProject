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
 * Servlet implementation class UpdateCouponServlet
 */
public class UpdateCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		CouponOperations couponOperations=new CouponOperations();
		CouponArray couponArray = new CouponArray();
	    Coupon coupon = new Coupon();
	
		
		couponArray.setOperationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		Coupon coupons = (Coupon) session.getAttribute("coupon");
		
		coupon.setCouponId(coupons.getCouponId());
		coupon.setCouponName(request.getParameter("couponName"));
		coupon.setCouponCode(request.getParameter("couponCode"));
		coupon.setCouponDetails(request.getParameter("couponDetails"));
		coupon.setSellerId(request.getParameter("sellerId"));
		coupon.setIssueDate(GetDate.getDate(request.getParameter("issueDate")));
		coupon.setExpireDate(GetDate.getDate(request.getParameter("expireDate")));
		coupon.setLastModifiedUserId((String)session.getAttribute("username"));
		couponOperations.setCouponObj(coupon);
		couponOperations.setCouponArray(couponArray);
		
		couponArray=(CouponArray) tableStub.couponOperations(couponOperations).get_return();
	    String flag="success";
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = request.getRequestDispatcher("/Couponjsps/UpdateReturnCoupon.jsp");
			reqDis.forward(request,response);
		}
	}

	


