package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;




import com.support.Area;
import com.support.AreaArray;
import com.support.SessionClass;

public class GetAreaNames {
	Area area=null;
	AreaArray areaArray=null;
	public GetAreaNames(Area area,AreaArray areaArray)
	{
		this.area=area;
		this.areaArray=areaArray;
	}
	
	public AreaArray getArea(Area area){
		AreaArray areaArray = new AreaArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ArrayList list = (ArrayList) session.getNamedQuery("getLatLon").setString("lattitude",area.getLATTITUDE()).
		setString("longitude", area.getLONGITUDE()).setString("lattitude1",area.getLATTITUDE1()).
		setString("longitude1", area.getLONGITUDE2()).list();
		Iterator it = list.iterator();
		System.out.println(list);
	
		Area[] areas = new Area[list.size()];
		int i=0;
		while(it.hasNext()){			
			areas[i]=(Area) it.next();
			//System.out.println(deal[i].getCreatedUserId());			
			i++;
		}
		areaArray.setArea(areas);
		return areaArray;
	
	}

	
	public AreaArray getAreaByWord(Area area){
		AreaArray areaArray = new AreaArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ArrayList list = (ArrayList) session.getNamedQuery("getLatLonByWord").setString("term", area.getAREA()).list();
		Iterator it = list.iterator();
		System.out.println(list);
	
		Area[] areas = new Area[list.size()];
		int i=0;
		while(it.hasNext()){			
			areas[i]=(Area) it.next();
			//System.out.println(deal[i].getCreatedUserId());			
			i++;
		}
		areaArray.setArea(areas);
		return areaArray;
	
	}

	
	
}
