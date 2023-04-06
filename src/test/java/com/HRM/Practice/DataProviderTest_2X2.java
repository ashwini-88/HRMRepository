package com.HRM.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest_2X2 {
     
	@Test(dataProvider = "data")
	
	public void getData(String src,String des)
	{
		System.out.println("From-->"+src+"To-->"+des);
	}
	
	
	
	@DataProvider
	public Object[][] data() 
	{
	Object[][] obj = new Object[2][2];	
	
	obj[0][0]="QSpider";
	obj[0][1]="TestYantra";
	
	obj[1][0]="TestYantra";
	obj[1][1]="Sony";
	
	return obj;
	}
}
