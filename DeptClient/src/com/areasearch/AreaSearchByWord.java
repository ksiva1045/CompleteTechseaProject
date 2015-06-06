package com.areasearch;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Area;
import com.table.operations.TableOperationsStub.AreaArray;
import com.table.operations.TableOperationsStub.GetAreas;

/**
 * Servlet implementation class AreaSearchByWord
 */
public class AreaSearchByWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String term = request.getParameter("term");
		
		System.out.println(term);
		
	
		if(term!=null){
			term=term+"%";
			
			//areaa_lat_long
			TableOperationsStub stub = new TableOperationsStub();
			GetAreas getAreas=new GetAreas();
			Area area=new Area();
			AreaArray areaArray=new AreaArray();
			areaArray.setOperationName("getLatLonByWord");
			area.setAREA(term);
			getAreas.setArea(area);
			getAreas.setAreaArray(areaArray);
			areaArray=(AreaArray) stub.getAreas(getAreas).get_return();
			
			ArrayList<String> list=new ArrayList<String>();
			Area[] areas=areaArray.getArea();
			for(int i=0;i<areas.length;i++){
				list.add(areas[i].getAREA());
				System.out.println("Inside AreaSearchByWord Area names "+areas[i].getAREA());
			}
			try{
				String searchList = new Gson().toJson(list);
				System.out.println("hi");
	            response.getWriter().write(searchList);
			}
			
			catch (Exception e) {
                System.err.println(e.getMessage());
			}
			
		}
	}
}
