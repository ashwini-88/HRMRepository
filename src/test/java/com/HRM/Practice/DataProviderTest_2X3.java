package com.HRM.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest_2X3 {
    @Test(dataProvider = "data")
    public void getData(String src, String des,String loc)
    {
    	System.out.println("From-->"+src+"To-->"+des+"LOc-->"+loc);
    }
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0]="TestYentra";
		obj[0][1]="Sony";
		obj[0][2]="Bengaluru";
		
		obj[1][0]="QSpider";
		obj[1][1]="Erricson";
		obj[1][2]="Pune";
		
		return obj;
	}
}
