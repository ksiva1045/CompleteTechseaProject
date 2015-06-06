package com.customercall;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clientsupport.SelectAllData;
import com.deal.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Caller;
import com.table.operations.TableOperationsStub.CallerArray;
import com.table.operations.TableOperationsStub.CallerOperations;
import com.table.operations.TableOperationsStub.Customer;
import com.table.operations.TableOperationsStub.CustomerArray;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;

public class InsertCustomerCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		String user=(String)session.getAttribute("username");
		String callerMobileNo=(String)session.getAttribute("callerMobileNo");
		String productId=(String)session.getAttribute("productId");
		
		String searchInfo="";
		String sentInfo="";
		String customerId="";
		int hh;
		String duration="";
		
		TableOperationsStub stub = new TableOperationsStub();

		//updating top rating of the product
		ProductOperations productOperations=new ProductOperations();
		ProductBean productBean=new ProductBean();
		ProductArray productArray=new ProductArray();
		
		productArray.setOperationName("updateproducttoprating");
		productBean.setProductId(productId);

		productOperations.setProductBean(productBean);
		productOperations.setProductArray(productArray);
		
		productArray= (ProductArray) stub.productOperations(productOperations).get_return();
		
		long startTime=(long) session.getAttribute("startTime");
		long endTime=(long) session.getAttribute("endTime");
		long time=endTime-startTime;
		
		System.out.println("time in milli seconds : "+time);
		if(time>=(1000*60*60)){
			hh=(int) (time/(1000*60*60));
			time=(int) (time%(1000*60*60));
			duration=duration+" "+hh+"h :";			
		}
		if(time>=(1000*60)){			
			hh=(int) (time/(1000*60));
			time=(int) (time%(1000*60));
			duration=duration+hh+" "+"m :";
		}
		if(time>=1000){			
			hh=(int) (time/1000);
			time=(int) (time%1000);
			duration=duration+" "+hh+"s";
		}

			
		//Getting all records from customer table
		CustomerArray customerArray=SelectAllData.customerSellectAll();
			
		//Getting customerid whose mobile no is callerMobileNo in the customerArray
		Customer[] customer1=customerArray.getCustomer();
		for(int i=0;i<customer1.length;i++){
			if(customer1[i].getPhonenumber().equalsIgnoreCase(callerMobileNo)){
				customerId=customer1[i].getCustomerid();
			}
			
		}
		

		//Getting all records from products table
		productArray=SelectAllData.productSellectAll();
		
		ProductBean[] product=productArray.getProduct();
		for(int i=0;i<product.length;i++){
			if(product[i].getProductId().equalsIgnoreCase(productId))
			{
				searchInfo=searchInfo+"Searching for "+product[i].getProductName()+" details";
				sentInfo=sentInfo+"Sending information about : "+product[i].getProductName();
			}
		}
		
		//caller insertion
		CallerOperations callerOperations=new CallerOperations();
		Caller caller=new Caller();
		CallerArray callerArray=new CallerArray();
		
		callerArray.setOperationName(Operations.INSERT);
	
		caller.setCostomerID(customerId);
		caller.setCallerSearchInfo(searchInfo);
		caller.setCallerSentInfo(sentInfo);
		caller.setSentInfoUserId(user);
		caller.setCallDuration(duration);
		caller.setEmpId(user);

		callerOperations.setCallerObj(caller);
		callerOperations.setCallerArray(callerArray);
		
		callerArray= (CallerArray) stub.callerOperations(callerOperations).get_return();
		
		//Getting all records from customer table
		callerArray=SelectAllData.callerSellectAll();
		
		Caller[] caller1=callerArray.getCaller();
		callerArray=new CallerArray();
		for(int i=0;i<caller1.length;i++){
			if(caller1[i].getCostomerID().equalsIgnoreCase(customerId)){
				callerArray.addCaller(caller1[i]);
			}
		}
		
		if(callerArray!=null){
			try{
				//forwarding data to the jsp file 
				request.setAttribute("callerArray",callerArray);
				RequestDispatcher reqDis =  request.getRequestDispatcher("/areajsps/CallerSelect.jsp");
				reqDis.forward(request, response);																						
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
