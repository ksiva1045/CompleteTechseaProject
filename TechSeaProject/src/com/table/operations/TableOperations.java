package com.table.operations;


import com.operations.CallerOperationsClass;
import com.operations.CouponOperataonsClass;
import com.operations.CustomerOperationClass;
import com.operations.CustomerPaymentMethodOperationsClass;
import com.operations.DealOperataonsClass;
import com.operations.DeptOperataonsClass;
import com.operations.EmpOperationClass;
import com.operations.GetAreaNames;
import com.operations.OrderItemsOperataonsClass;
import com.operations.OrderOperationsClass;
import com.operations.PaymentOperationsClass;
import com.operations.ProductCatOperataonsClass;
import com.operations.ProductCatStaticOperataonsClass;
import com.operations.ProductOperationClass;
import com.operations.ProductSpecificationOperationClass;
import com.operations.SellerOperataonsClass;
import com.operations.SellerProductOperationClass;
import com.operations.InvoicesOperations;
import com.operations.ShipmentOperationClass;
import com.support.Area;
import com.support.AreaArray;
import com.support.Caller;
import com.support.CallerArray;
import com.support.Coupon;
import com.support.CouponArray;
import com.support.Customer;
import com.support.CustomerArray;
import com.support.CustomerPaymentMethod;
import com.support.CustomerPaymentMethodArray;
import com.support.Deal;
import com.support.DealArray;
import com.support.Dept;
import com.support.DeptArray;
import com.support.Emp;
import com.support.EmpArray;
import com.support.Invoices;
import com.support.InvoicesArray;
import com.support.Order;
import com.support.OrderArray;
import com.support.OrderItems;
import com.support.OrderItemsArray;
import com.support.Payment;
import com.support.PaymentArray;
import com.support.ProductArray;
import com.support.ProductBean;
import com.support.ProductCat;
import com.support.ProductCatArray;
import com.support.ProductCatStatic;
import com.support.ProductCatStaticArray;
import com.support.ProductSpecification;
import com.support.ProductSpecificationArray;
import com.support.Seller;
import com.support.SellerArray;
import com.support.SellerProduct;
import com.support.SellerProductArray;
import com.support.ShipmentArray;
import com.support.Shipments;



public class TableOperations {
	
	
public Object DeptOperations(Dept d,DeptArray dArray){
	
	DeptOperataonsClass dept = new DeptOperataonsClass(d,dArray);
	Object obj=null;
	
	
	if(dArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  dept.insertDept(d);
	}
	
	if(dArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = dept.selectAll();
	}
	
	if(dArray.getOperationName().equalsIgnoreCase("update")){
		 obj = dept.updateDept(d);
		}
		
	if(dArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = dept.deleteDept(d);
		}
		
	if(dArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = dept.selectDept(d);
		}
		
	if(dArray.getOperationName().equalsIgnoreCase("selectbyname")){
		 obj = dept.selectDeptDataByName(d);
		}
	return obj;
	

}

public Object ProductOperations(ProductBean productBean,ProductArray productArray){
	ProductOperationClass product = new ProductOperationClass(productBean,productArray);
	Object obj=null;
	if(productArray.getOperationName().equalsIgnoreCase("insert")){
		 obj = product.insertProduct(productBean);
		}
	
	if(productArray.getOperationName().equalsIgnoreCase("update")){
		 obj = product.updateProduct(productBean);
		}
	
	if(productArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = product.deleteProduct(productBean);
		}
	
	if(productArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = product.selectProduct(productBean);
		}
	
	if(productArray.getOperationName().equalsIgnoreCase("selectAll")){
		 obj = product.selectAll();
		}
	if(productArray.getOperationName().equalsIgnoreCase("updateproducttoprating")){
		 obj = product.updateProductTopRating(productBean);
		}
	if(productArray.getOperationName().equalsIgnoreCase("getProductByWord")){
		 obj = product.getProductByWord(productBean);
		}
	return obj;
}

public Object EmpOperations(Emp emp,EmpArray empArray){
	EmpOperationClass empObj = new EmpOperationClass(emp,empArray);
	Object obj=null;
	if(empArray.getOperationName().equalsIgnoreCase("insert")){
		 obj = empObj.insertEmp(emp);
		}
	
	if(empArray.getOperationName().equalsIgnoreCase("update")){
		 obj = empObj.updateEmp(emp);
		}
	
	if(empArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = empObj.deleteEmp(emp);
		}
	
	if(empArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = empObj.selectEmp(emp);
		}
	
	if(empArray.getOperationName().equalsIgnoreCase("selectAll")){
		 obj = empObj.selectAllEmp();
		}
	return obj;
}


public Object DealOperations(Deal dealObj,DealArray dealArray){
	
	DealOperataonsClass deal = new DealOperataonsClass(dealObj,dealArray);
	Object obj=null;
	
	
	if(dealArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  deal.insertDeal(dealObj);
	}
	
	if(dealArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = deal.selectAll();
	}
	
	if(dealArray.getOperationName().equalsIgnoreCase("update")){
		 obj = deal.updateDeal(dealObj);
		}
		
	if(dealArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = deal.deleteDeal(dealObj);
		}
		
	if(dealArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = deal.selectDeal(dealObj);
		}
		
	
	return obj;
	

}


public Object sellerOperations(Seller sellerObj,SellerArray sellerArray){
	
	SellerOperataonsClass seller = new SellerOperataonsClass(sellerObj,sellerArray);
	Object obj=null;
	
	
	if(sellerArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  seller.insertSeller(sellerObj);
	}
	
	if(sellerArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = seller.selectAll();
	}
	
	if(sellerArray.getOperationName().equalsIgnoreCase("update")){
		 obj = seller.updateSeller(sellerObj);
	}
	if(sellerArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = seller.deleteSeller(sellerObj);
		}
		
	if(sellerArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = seller.selectSeller(sellerObj);
		}
		
	
	return obj;
	



}


public Object productCategoryOperations(ProductCat proCatObj,ProductCatArray proCatArray){
	
	ProductCatOperataonsClass proCat = new ProductCatOperataonsClass(proCatObj,proCatArray);
	Object obj=null;
	
	
	if(proCatArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  proCat.insertProdCat(proCatObj);
	}
	
	if(proCatArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = proCat.selectAll();
	}
	
	if(proCatArray.getOperationName().equalsIgnoreCase("update")){
		 obj = proCat.updateProdCat(proCatObj);
	}
	if(proCatArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = proCat.deleteProdCat(proCatObj);
		}
		
	if(proCatArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = proCat.selectProdCat(proCatObj);
		}	
	if(proCatArray.getOperationName().equalsIgnoreCase("selectByParentId")){
		 obj = proCat.selectProdCatParent(proCatObj);
		}	
	
	return obj;

}



public Object CouponOperations(Coupon couponObj,CouponArray couponArray){
    CouponOperataonsClass coupon = new CouponOperataonsClass(couponObj,couponArray);
		Object obj=null;
		
		
		if(couponArray.getOperationName().equalsIgnoreCase("insert")){
			obj = coupon.insertCoupon(couponObj);
		}
		
		if(couponArray.getOperationName().equalsIgnoreCase("selectAll")){
		 obj = coupon.selectAll();
		}
		
		if(couponArray.getOperationName().equalsIgnoreCase("update")){
			 obj = coupon.updateCoupon(couponObj);
			}
			
		if(couponArray.getOperationName().equalsIgnoreCase("delete")){
			 obj = coupon.deleteCoupon(couponObj);
			}
			
		if(couponArray.getOperationName().equalsIgnoreCase("selectById")){
			 obj = coupon.selectCoupon(couponObj);
			}
			
		
		return obj;
		
	}



public Object CustomerOperations(Customer customerObj,CustomerArray customerArray){
	
CustomerOperationClass customer = new CustomerOperationClass(customerObj,customerArray);
	Object obj=null;
	
	
	if(customerArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  customer.insertCustomer(customerObj);
	}
	
	if(customerArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = customer.selectAll();
	}
	
	if(customerArray.getOperationName().equalsIgnoreCase("update")){
		System.out.println(" customer operation class");
		 obj = customer.updateCustomer(customerObj);
		 System.out.println(" customer operation ");
		}
		
	if(customerArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = customer.deleteCustomer(customerObj);
		}
		
	if(customerArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = customer.selectCustomer(customerObj);
		}
		
	if(customerArray.getOperationName().equalsIgnoreCase("selectbyname")){
		 obj = customer.selectCustomerDataByName(customerObj);
		}
	return obj;
	

}

public Object productCategoryStaticOperations(ProductCatStatic proCatStaticObj,ProductCatStaticArray proCatStaticArray){
	
	ProductCatStaticOperataonsClass proCatStatic = new ProductCatStaticOperataonsClass(proCatStaticObj,proCatStaticArray);
	Object obj=null;
	
	
	if(proCatStaticArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  proCatStatic.insertProdCatStatic(proCatStaticObj);
	}
	
	if(proCatStaticArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = proCatStatic.selectAll();
	}
	
	if(proCatStaticArray.getOperationName().equalsIgnoreCase("update")){
		 obj = proCatStatic.updateProdCatStatic(proCatStaticObj);
	}
	if(proCatStaticArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = proCatStatic.deleteProdCatStatic(proCatStaticObj);
		}
		
	if(proCatStaticArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = proCatStatic.selectProdCatStatic(proCatStaticObj);
		}
		
	
	return obj;

}

public  Object productSpecificationOperations(ProductSpecification productSpecificObj,ProductSpecificationArray productSpecificationArray){
	
	ProductSpecificationOperationClass productSpecific = new ProductSpecificationOperationClass(productSpecificObj,productSpecificationArray);
	
	Object obj=null;
	
	
	if(productSpecificationArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  productSpecific.insertProductSpecification(productSpecificObj);
	}
	
	if(productSpecificationArray.getOperationName().equalsIgnoreCase("selectAll")){
	 obj = productSpecific.productSpecificationselectAll();
	}
	
	if(productSpecificationArray.getOperationName().equalsIgnoreCase("update")){
		 obj = productSpecific.updateProductSpection(productSpecificObj);
	}
	if(productSpecificationArray.getOperationName().equalsIgnoreCase("delete")){
		 obj = productSpecific.deleteProductSpecification(productSpecificObj);
		}
		
	if(productSpecificationArray.getOperationName().equalsIgnoreCase("selectById")){
		 obj = productSpecific.selectProductSpecification(productSpecificObj);
		}
		
	
	return obj;

}
	public Object getAreas(Area area,AreaArray areaArray){
		
		GetAreaNames gan = new GetAreaNames(area,areaArray);
		Object obj=null;
		if(areaArray.getOperationName().equalsIgnoreCase("getLocation")){
			obj = gan.getArea(area);
		}
		if(areaArray.getOperationName().equalsIgnoreCase("getLatLonByWord")){
			obj=gan.getAreaByWord(area);
		}		
		return obj;
	}
	
	public Object SellerProductOperations(SellerProduct sellerProductObj,SellerProductArray sellerProductArray){
		SellerProductOperationClass sellerProduct = new SellerProductOperationClass(sellerProductObj,sellerProductArray);
		Object obj=null;
		
		
		if(sellerProductArray.getOperationName().equalsIgnoreCase("insertsellerproduct")){
			obj = sellerProduct.insertSellerProduct(sellerProductObj);
		}
		
		if(sellerProductArray.getOperationName().equalsIgnoreCase("selectAll")){
		 obj = sellerProduct.selectAll();
		}
		
		if(sellerProductArray.getOperationName().equalsIgnoreCase("update")){
			 obj = sellerProduct.updateSellerProduct(sellerProductObj);
			}
			
		if(sellerProductArray.getOperationName().equalsIgnoreCase("deletesellerproduct")){
			 obj = sellerProduct.deleteSellerProduct(sellerProductObj);
			}
			
		if(sellerProductArray.getOperationName().equalsIgnoreCase("selectById")){
			 obj = sellerProduct.selectSellerProduct(sellerProductObj);
			}
			
		
		return obj;
		
	}
	
	public Object CallerOperations(Caller callerObj,CallerArray callerArray){
		
		CallerOperationsClass caller = new CallerOperationsClass(callerObj, callerArray);
			Object obj=null;
	
			if(callerArray.getOperationName().equalsIgnoreCase("insert")){
				obj =  caller.insertCaller(callerObj);
			}
			
			if(callerArray.getOperationName().equalsIgnoreCase("selectAll")){
			 obj = caller.selectAll();
			}
			return obj;
		}
	
	public Object operationCustomerPaymentMethod(CustomerPaymentMethod customerPayments,CustomerPaymentMethodArray paymentMethodArray) 
	{
		System.out.println("operation");
		
		CustomerPaymentMethodOperationsClass paymentOperations=new CustomerPaymentMethodOperationsClass(customerPayments, paymentMethodArray);
		System.out.println("operation1");
		Object obj=null;
		if(paymentMethodArray.getOperationName().equalsIgnoreCase("insert"))
		{
			obj=paymentOperations.insertCustomerPaymentMethod(customerPayments);
			
		}
		if(paymentMethodArray.getOperationName().equalsIgnoreCase("update"))
		{
			obj=paymentOperations.updateCustomerPaymentMethod(customerPayments);
			
		}
		if(paymentMethodArray.getOperationName().equalsIgnoreCase("delete"))
		{
			
			obj=paymentOperations.deleteCustomerPaymentMethod(customerPayments);
			
		}
		if(paymentMethodArray.getOperationName().equalsIgnoreCase("selectAll"))
		{
			obj=paymentOperations.selectAllCustomerDetails();
			
		}
		if(paymentMethodArray.getOperationName().equalsIgnoreCase("selectById"))
		{
			obj=paymentOperations.selectCustomerPaymentMethod(customerPayments);
			
		}
		
		
		return obj;
	}
public Object orderItemsOperations(OrderItems orderItems,OrderItemsArray orderItemsArray){
		
		OrderItemsOperataonsClass orderItemOper = new OrderItemsOperataonsClass(orderItems,orderItemsArray);
		
		Object obj=null;
		
		if(orderItemsArray.getOperationName().equalsIgnoreCase("insert")){
			obj=orderItemOper.insertOrderItems(orderItems);
		}
		
		if(orderItemsArray.getOperationName().equalsIgnoreCase("selectAll")){
			obj= orderItemOper.selectAll();
		}
		
		if(orderItemsArray.getOperationName().equalsIgnoreCase("update")){
			obj= orderItemOper.updateOrderItems(orderItems);
			}
			
		if(orderItemsArray.getOperationName().equalsIgnoreCase("delete")){
			obj= orderItemOper.deleteOrderItems(orderItems);
			}
			
		if(orderItemsArray.getOperationName().equalsIgnoreCase("selectById")){
			obj= orderItemOper.selectOrderItems(orderItems);
			}
			
		return obj;
		

	}

public Object InvoicesOperations(Invoices in,InvoicesArray array){
	  InvoicesOperations operations= new InvoicesOperations(in, array);
	  Object obj=null;
	  if(array.getOpreationName().equalsIgnoreCase("insert")){
		 obj= operations.insertInvoice(in);}
	  if(array.getOpreationName().equalsIgnoreCase("update")){
		  obj=operations.updateInvoice(in);}
	  if(array.getOpreationName().equalsIgnoreCase("delete")){
		  obj=operations.deleteInvoice(in);}
	  if(array.getOpreationName().equalsIgnoreCase("selectById")){
		  obj=operations.selectInvoice(in);}
	  if(array.getOpreationName().equalsIgnoreCase("selectAll")){
		  obj=operations.selectAll();
	  }
	  return obj;
	}

public Object ShipmentsOperations(Shipments shipments,ShipmentArray shipmentsArray){
	
	ShipmentOperationClass soc = new ShipmentOperationClass(shipments,shipmentsArray);
	Object obj=null;
	
	if(shipmentsArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  soc.insertShipments(shipments);
	}
	if(shipmentsArray.getOperationName().equalsIgnoreCase("update")){
		obj =  soc.updateShipments(shipments);
	}
	if(shipmentsArray.getOperationName().equalsIgnoreCase("delete")){
		obj =  soc.deleteShipments(shipments);
	}
	if(shipmentsArray.getOperationName().equalsIgnoreCase("selectbyid")){
		obj =  soc.selectbyIdShipments(shipments);
	}
	if(shipmentsArray.getOperationName().equalsIgnoreCase("selectAll")){
		obj =  soc.selectAllShipments();
	}
	return obj;
	
}


public Object orderOperations(Order order,OrderArray orderArray)
{
	OrderOperationsClass orderOperation=new OrderOperationsClass(order,orderArray);
	Object obj=null;
	if(orderArray.getOperationName().equalsIgnoreCase("insert"))
	{	
		obj=orderOperation.insertOrder(order);	
		if(obj instanceof OrderArray){
			System.out.println("instence of order array");
		}
	}
	if(orderArray.getOperationName().equalsIgnoreCase("update"))
	{
		obj=orderOperation.updateOrder(order);
	}
	if(orderArray.getOperationName().equalsIgnoreCase("delete"))
	{
		obj=orderOperation.deleteOrder(order);
	}
	if(orderArray.getOperationName().equalsIgnoreCase("selectAll"))
	{
		obj=orderOperation.selectAllOrder(order);
	}
	if(orderArray.getOperationName().equalsIgnoreCase("selectById"))
	{
		obj=orderOperation.selectByIdOrder(order);
	}
	
	return obj;
	
}
public Object PaymentaOperaction(Payment p,PaymentArray pArray)
{
	PaymentOperationsClass p1=new PaymentOperationsClass(p,pArray);

	Object obj=null;
	
	
	if(pArray.getOperationName().equalsIgnoreCase("insert")){
		obj =  p1.insert(p);
	}
	if(pArray.getOperationName().equalsIgnoreCase("update")){
		obj =  p1.update(p);
	}
	if(pArray.getOperationName().equalsIgnoreCase("delete")){
		obj =  p1.delete(p);
     }
	if(pArray.getOperationName().equalsIgnoreCase("select")){
		System.out.println("insert  in table operation");
		obj =  p1.select(p);
	}
	if(pArray.getOperationName().equalsIgnoreCase("selectAll")){
		
		obj =  p1.selectAll(p);
	}
	return obj;
	
}
}

