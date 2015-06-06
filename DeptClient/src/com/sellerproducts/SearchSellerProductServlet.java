package com.sellerproducts;


	import java.io.IOException;





	import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.SellerProduct;
import com.table.operations.TableOperationsStub.SellerProductArray;
import com.table.operations.TableOperationsStub.SellerProductOperations;

	/**
	 * Servlet implementation class SelectDealServlet
	 */
	public class  SearchSellerProductServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.setAttribute("username",session.getAttribute("username")); 
			session.setAttribute("toPage",session.getAttribute("toPage"));
			
			TableOperationsStub tableStub=new TableOperationsStub();
			SellerProductOperations sellerProductOperations=new SellerProductOperations();
			SellerProduct sellerProduct = new SellerProduct();
			SellerProductArray sellerProductArray=new SellerProductArray();
			
			sellerProductArray.setOperationName(Operations.SELECTBYID);
			sellerProduct.setPsid(request.getParameter("id"));;
			sellerProductOperations.setSellerProductObj(sellerProduct);
			sellerProductOperations.setSellerProductArray(sellerProductArray);

			Object obj= tableStub.sellerProductOperations(sellerProductOperations).get_return();
			
			
			if(obj instanceof String){
				System.out.println(obj);
			}
			else if(obj instanceof SellerProduct){
				sellerProduct = (SellerProduct)obj;			
			}
			
			/*request.setAttribute("SellerProductObj", sellerProduct);
			RequestDispatcher reqDis = request.getRequestDispatcher("/ProductID");
			reqDis.forward(request, response);*/
			
			

			request.setAttribute("SellerProductObj", sellerProduct);
			RequestDispatcher reqDisp = request.getRequestDispatcher("/SellerID");
			reqDisp.forward(request, response);
		

		
		}

	}

