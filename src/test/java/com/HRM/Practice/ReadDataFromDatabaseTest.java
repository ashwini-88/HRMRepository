package com.HRM.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {
public static void main(String[] args) throws SQLException {
	
	//step1: Create Object for Driver
	Driver driver=new Driver();    //import com.mysql.cj.jdbc.Driver;
	
	//Step2:Register the Database
      DriverManager.registerDriver(driver);
	
     //step3:GEt connection for the database;// DriverManager.getConnection("Jdbc:mysql://localhost:3306/Database_name", "username", "password");
       Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/ashwini", "root", "root");
    
    //step4:create Statement
       Statement state = con.createStatement();
	   String query = "select * from employee"; 
	   
	 //step5: Execute Query
	   ResultSet result = state.executeQuery(query);
	   
	   while(result.next())
	   {
		   System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	   }
	   
	   //step6: close database connection
	   con.close();
}


}

