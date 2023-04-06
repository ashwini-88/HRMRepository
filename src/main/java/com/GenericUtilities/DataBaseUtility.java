package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;
 
public class DataBaseUtility {
    Connection con=null;
	
    //connect to the DB 
	public void connectToDb() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUSERNAME, IPathConstant.DBPASSWORD);
	}
	
	//Register DB
	public String ecxecuteQueryAndGetData(String query,int columnIndex,String expData) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
	
		while(result.next())
		{
			String data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
			   flag=true;
			   break;
			}
		}
		if(flag)
		{
			System.out.println("Data is verified");
	        return 	expData;
		}
		else 
		{
		    System.out.println("Data is not updated");
		    return "";
		}
		
	}
	public void closeDB() throws Throwable
	{
		con.close();
		System.out.println("DataBase connection Closed");
	}
}
