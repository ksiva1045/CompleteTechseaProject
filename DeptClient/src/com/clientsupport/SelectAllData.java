package com.clientsupport;

import java.rmi.RemoteException;

import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Caller;
import com.table.operations.TableOperationsStub.CallerArray;
import com.table.operations.TableOperationsStub.CallerOperations;
import com.table.operations.TableOperationsStub.CouponArray;
import com.table.operations.TableOperationsStub.CouponOperations;
import com.table.operations.TableOperationsStub.Customer;
import com.table.operations.TableOperationsStub.CustomerArray;
import com.table.operations.TableOperationsStub.CustomerOperations;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;
import com.table.operations.TableOperationsStub.Invoices;
import com.table.operations.TableOperationsStub.InvoicesArray;
import com.table.operations.TableOperationsStub.InvoicesOperations;
import com.table.operations.TableOperationsStub.Order;
import com.table.operations.TableOperationsStub.OrderArray;
import com.table.operations.TableOperationsStub.OrderOperations;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

public class SelectAllData {
	
	public static ProductArray productSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		ProductOperations productOperations = new ProductOperations();
		ProductBean productObj = new ProductBean();
		ProductArray productArray = new ProductArray();
		productArray.setOperationName(Operations.SELECTALL);
		productOperations.setProductBean(productObj);
		productOperations.setProductArray(productArray);
		productArray = (ProductArray) stub.productOperations(productOperations).get_return();
		return productArray;
	}
	
	public static CustomerArray customerSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		CustomerOperations customerOperations = new CustomerOperations();
		Customer customer = new Customer();
		CustomerArray customerArray = new CustomerArray();
		customerArray.setOperationName(Operations.SELECTALL);
		customerOperations.setCustomerObj(customer);
		customerOperations.setCustomerArray(customerArray);
		customerArray = (CustomerArray) stub.customerOperations(customerOperations).get_return();
		return customerArray;
	}
	
	public static CallerArray callerSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		CallerOperations callerOperations = new CallerOperations();
		Caller caller = new Caller();
		CallerArray callerArray = new CallerArray();
		callerArray.setOperationName(Operations.SELECTALL);
		callerOperations.setCallerObj(caller);
		callerOperations.setCallerArray(callerArray);
		callerArray = (CallerArray) stub.callerOperations(callerOperations).get_return();
		return callerArray;
	}
	
	/*public static CouponArray couponsSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		CouponOperations couponOperations = new CouponOperations();
		Caller caller = new Caller();
		CouponArray couponArray = new CouponArray();
		callerArray.setOperationName(Operations.SELECTALL);
		couponOperations.setCallerObj(caller);
		couponOperations.setCallerArray(callerArray);
		callerArray = (CouponArray) stub.callerOperations(callerOperations).get_return();
		return callerArray;
	}*/
	
	public static InvoicesArray invoiceSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		InvoicesOperations invoceOperations = new InvoicesOperations();
		Invoices invoices = new Invoices();
		InvoicesArray invoicesArray = new InvoicesArray();
		invoicesArray.setOpreationName(Operations.SELECTALL);
		invoceOperations.setIn(invoices);
		invoceOperations.setArray(invoicesArray);
		invoicesArray = (InvoicesArray) stub.invoicesOperations(invoceOperations).get_return();
		return invoicesArray;
	}
	
	public static SellerArray sellerSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		SellerOperations sellerOperations = new SellerOperations();
		SellerArray sArray = new SellerArray();
		sArray.setOperationName(Operations.SELECTALL);
		Seller s = new Seller();
		sellerOperations.setSellerArray(sArray);
		sellerOperations.setSellerObj(s);
		sArray = (SellerArray) stub.sellerOperations(sellerOperations).get_return();
		return sArray;
	}
	
	public static OrderArray orderSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		OrderOperations orderOperations = new OrderOperations();
		Order order = new Order();
		OrderArray orderArray = new OrderArray();
		orderArray.setOperationName(Operations.SELECTALL);
		orderOperations.setOrder(order);
		orderOperations.setOrderArray(orderArray);
		orderArray = (OrderArray) stub.orderOperations(orderOperations).get_return();
		return orderArray;
	}
	
	public static DeptArray deptSellectAll() throws RemoteException{
		TableOperationsStub stub = new TableOperationsStub();
		DeptOperations deptOperations = new DeptOperations();
		Dept dept = new Dept();
		DeptArray deptArray = new DeptArray();
		deptArray.setOperationName(Operations.SELECTALL);
		deptOperations.setD(dept);
		deptOperations.setDArray(deptArray);
		deptArray = (DeptArray) stub.deptOperations(deptOperations).get_return();
		return deptArray;
		
	}
	
}
