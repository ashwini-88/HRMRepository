package com.HRM.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {

	@BeforeSuite
	public void connect_DB() {
        System.out.println("--Connect to DB--");
	}
	
	@AfterSuite
	public void disconnect_DB() {
        System.out.println("--Disconnect DB--");
	}
	
	@BeforeClass
	public void launch_Browser() {
		System.out.println("--Browser is Launched--");
	}
	
	@AfterClass
	public void close_Browser() {
	    System.out.println("--Close Browser--");
	}
	
	@BeforeMethod
	public void login_App(){
		System.out.println("--Loging To The App--");
	}
	
	@AfterMethod
	public void logout_App() {
        System.out.println("--Logout from App--");	
	}
	
	@Test
	public void testScript_1() {
		System.out.println("Test Script_1 will get excecuted");
	}
	
	@Test
	public void testScript_2(){
		System.out.println("Test Script_2 will get excecuted");
	}
	}

