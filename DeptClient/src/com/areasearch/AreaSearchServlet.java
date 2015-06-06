package com.areasearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clientsupport.SelectAllData;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Area;
import com.table.operations.TableOperationsStub.AreaArray;
import com.table.operations.TableOperationsStub.GetAreas;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.SellerArray;

/**
 * Servlet implementation class AreaSearchServlet
 */
public class AreaSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lat1="",lat2="",lon1="",lon2="";
		double distance=0.0;
		//Seller[] dummySeller=null;
		
		String dist=request.getParameter("distance");
		String lattitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		String productName=request.getParameter("productid");
		String productId="";
		
		int discountFrom=Integer.parseInt(request.getParameter("discount"));
	
		if(!lattitude.equalsIgnoreCase("")&&!longitude.equalsIgnoreCase("")){
			if(dist.equalsIgnoreCase("")){
				distance=650/111.12;
			}
			else{
				distance=Double.parseDouble(dist)/111.12;			

			}
			lat1=Double.toString((Double.parseDouble(lattitude))-distance);
			lat2=Double.toString((Double.parseDouble(lattitude))+distance);
			lon1=Double.toString((Double.parseDouble(longitude))-distance);
			lon2=Double.toString((Double.parseDouble(longitude))+distance);
			System.out.println("lat1 : "+lat1+"   lat1 : "+lat2+"    lon1 : "+lon1+"   lon2 : "+lon2);
		}
		else{
			
			lat1="17";
			lat2="18";
			lon1="78";
			lon2="79";
		}
		

		response.setContentType("text/html");
		TableOperationsStub tableStub=new TableOperationsStub();
		
		GetAreas getAreas=new GetAreas();
		Area area=new Area();
		AreaArray areaArray=new AreaArray();

		area.setLATTITUDE(lat1);
		area.setLATTITUDE1(lat2);
		area.setLONGITUDE(lon1);
		area.setLONGITUDE2(lon2);
		
		areaArray.setOperationName("getLocation");
		getAreas.setArea(area);
		getAreas.setAreaArray(areaArray);
		
		areaArray=(AreaArray) tableStub.getAreas(getAreas).get_return();


		SellerArray sellerArray1=new SellerArray();
		HttpSession session=request.getSession(false);
		session.setAttribute("username",session.getAttribute("username"));
		session.setAttribute("callerMobileNo", session.getAttribute("callerMobileNo"));
		session.setAttribute("startTime",session.getAttribute("startTime"));
		session.setAttribute("productId", productId);
		
		
		//Getting all records from products table
		ProductArray productArray=SelectAllData.productSellectAll();

		//price search functionality by ramki
		
		int minPrice=Integer.parseInt(request.getParameter("price"));
		int maxPrice=minPrice+5000;

		//ProductArray productArray = (ProductArray)session.getAttribute("productArray");
		ProductBean[] productBean = productArray.getProduct();		
		for(int i=0;i<productBean.length;i++)
		{			
			if(productBean[i].getProductName().equalsIgnoreCase(productName)){
				productId=productBean[i].getProductId();
			}
		}
		int productPrice = 0;
		for(int i=0;i<productBean.length;i++)
		{
			if(productBean[i].getProductId().equalsIgnoreCase(productId)){
				productPrice = 	Integer.parseInt(productBean[i].getPrice());

			}
		}
		//price range
		if(minPrice <=productPrice && productPrice <= maxPrice )
		{
			sellerArray1=AreaSearchServletSupporting.getSellerArrayData(areaArray, productId, productPrice, discountFrom);
		System.out.println("productPrice "+productPrice);
		}
		//not 
		else if(minPrice== 1 )
				{
			sellerArray1=AreaSearchServletSupporting.getSellerArrayData(areaArray, productId, productPrice, discountFrom);
			System.out.println("productPrice "+productPrice);
		}

		/*if(areaArray!=null&&productId!=null){
	
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
		}*/
		
		try{
			request.setAttribute("sellerArray1",sellerArray1);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/areajsps/sellerarea.jsp");
			reqDis.forward(request, response);																						
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
