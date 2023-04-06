package com.HRM.Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commanData.properties");
		Properties pObj = new Properties(); 
		pObj.load(fis);
		String Browser = pObj.getProperty("browser");
		String Url = pObj.getProperty("url");
		String Username = pObj.getProperty("username");
		String Password = pObj.getProperty("password");
		
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(Username);
		System.out.println(Password);
		

	}

}
