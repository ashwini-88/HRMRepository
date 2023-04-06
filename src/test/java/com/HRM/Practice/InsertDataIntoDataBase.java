package com.HRM.Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;  //WE SHOULD IMPORT THIS ?

//import com.mysql.jdbc.Driver;WE SHOULD NOT IMPORT THIS wHY?

public class InsertDataIntoDataBase {
public static void main(String[] args) throws SQLException {
	int result=0;
	Connection con=null; 
	try {
	//step1: Create Object for Driver
	Driver driver=new Driver();    //import com.mysql.cj.jdbc.Driver;
	
	//Step2:Register the Database
      DriverManager.registerDriver(driver);
	
     //step3:GEt connection for the database;// DriverManager.getConnection("Jdbc:mysql://localhost:3306/Database_name", "username", "password");
      con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/ashwini", "root", "root");
    
    //step4:create Statement
       Statement state = con.createStatement();
	  // String query = "select * from employee"; 
      // ALTER TABLE table_name
      // ADD column_name datatype;
       String query = "insert into employee value(3,'Arun',50000,'Manager');";
      
       //step5: Excecute Query
      result = state.executeUpdate(query);
	}
	 catch(Exception e)
	{
		 }
	
	finally
	{
		if(result==1)
			System.out.println("data updated");
		else 
            System.out.println("data not updated");  
	}
	
	
     	  
	   con.close();

}
}

