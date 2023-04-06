package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int random()
    {
	Random ran = new Random();
	int random = ran.nextInt(1000);
	return random;
	}
  
public String getSystemDate()
    {
	Date dt = new Date();
	String date = dt.toString();
	return date;
	}

public String formateSystemDate()
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yy hh:mm:ss");
	Date dt = new Date();
	//String getDateAndTime = dateFormat.format(dt);
	String getDateAndTime = dateFormat.format(dt);
	getDateAndTime.replace(":","-");
	return getDateAndTime;
	}

public String getSystemDateWithFormate()
    {
		Date date = new Date();
		String dateAndTime = date.toString();
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		
		@SuppressWarnings("deprecation")
		int MM = date.getMonth()+1;
		
		String finalFormate = YYYY +"-"+MM+"-"+DD;
		return finalFormate;
	}
}





