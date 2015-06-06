package com.areasearch;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.coupon.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Area;
import com.table.operations.TableOperationsStub.AreaArray;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;
import com.table.operations.TableOperationsStub.SellerProduct;
import com.table.operations.TableOperationsStub.SellerProductArray;
import com.table.operations.TableOperationsStub.SellerProductOperations;

public class AreaSearchServletSupporting {
	
	public static SellerArray getSellerArrayData(AreaArray areaArray,String productId,int productPrice,int discountFrom) throws RemoteException{
		TableOperationsStub tableStub=new TableOperationsStub();
		SellerArray sellerArray1=new SellerArray();
		if(areaArray!=null&&productId!=null){
			
			Area[] area1=null;
			area1=areaArray.getArea();
			for(int i=0;i<area1.length;i++){
				System.out.println("inside for loop "+area1[i].getAREA());
			}
			
			//seller products
			SellerProductOperations sellerProductOperations = new SellerProductOperations();
			SellerProduct sellerProduct = new SellerProduct();
			SellerProductArray sellerProductArray = new SellerProductArray();
			sellerProductArray.setOperationName(Operations.SELECTALL);
			sellerProductOperations.setSellerProductObj(sellerProduct);
			sellerProductOperations.setSellerProductArray(sellerProductArray);
			sellerProductArray = (SellerProductArray) tableStub.sellerProductOperations(sellerProductOperations).get_return();
			
			if(sellerProductArray!=null){
				SellerProduct[] sellerProduct1=null;
				sellerProduct1=sellerProductArray.getSellerProduct();

				for(int i=0;i<sellerProduct1.length;i++){

					if(sellerProduct1[i].getPid().equalsIgnoreCase(productId)){
						//seller
						double price = Double.parseDouble(sellerProduct1[i].getPsprice());
						double discount=100-((price/productPrice)*100);
						System.out.println("discount"+discount);
						System.out.println("price"+price);
						if((discountFrom<=discount))
						{	
							System.out.println("from discount "+discountFrom+"  "+discount+" "+price);
														SellerOperations sellerOperations = new SellerOperations();
							Seller sellerObj = new Seller();
							
							SellerArray sellerArray = new SellerArray();
							sellerArray.setOperationName(Operations.SELECTALL);
							sellerOperations.setSellerObj(sellerObj);
							sellerOperations.setSellerArray(sellerArray);
							sellerArray=(SellerArray) tableStub.sellerOperations(sellerOperations).get_return();
							
							if(sellerArray!=null){
								Seller[] seller=null;
								seller=sellerArray.getSeller();
								
								for(int j=0;j<seller.length;j++){
									//System.out.println("inside sellerarray loop seller address "+seller[j].getSellerAddress());

									if(seller[j].getSid().equalsIgnoreCase(sellerProduct1[i].getSid())){
										System.out.println("SellerId and SellerProductId "+seller[j].getSid()+" : "+sellerProduct1[i].getSid());
										for(int k=0;k<area1.length;k++){
											
											if(seller[j].getSellerAddress().equalsIgnoreCase(area1[k].getAREA())){
												Seller seller1=new Seller();
												seller1.setSid(seller[j].getSid());
												seller1.setSName(seller[j].getSName());
												seller1.setSellerAddress(seller[j].getSellerAddress());
												sellerArray1.addSeller(seller1);
												/*if(sellerArray1!=null){
													dummySeller=sellerArray1.getSeller();
													if(dummySeller==null){
														System.out.println("inside dummySeller : "+seller1.getSid());
														sellerArray1.addSeller(seller1);
													}
													else{
														for(int l=0;l<dummySeller.length;l++){	
															System.out.println("dummySeller[l].getSid().equalsIgnoreCase(seller1.getSid()) "+dummySeller[l].getSid()+" : "+seller1.getSid());

															if(dummySeller[l].getSid().equalsIgnoreCase(seller1.getSid())){
																System.out.println("dummySeller[l].getSid().equalsIgnoreCase(seller1.getSid()) "+dummySeller[l].getSid()+" : "+seller1.getSid());
															}
															else{
																sellerArray1.addSeller(seller1);
															}
														}
													}
												}*/
											}								
										}							
									}
								}
							}
						}		
					}
				}
			}				
		}

		return sellerArray1;
	}

}
