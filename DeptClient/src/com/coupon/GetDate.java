package com.coupon;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getDate(String dateInString){
		try{
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MMM/yyyy");
		Date date = formatter1.parse(dateInString);
		return formatter2.format(date);		
	}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getReqFormat(String dateInString){
		String ar[]=dateInString.split(" ");
		return ar[0];
	}

}
