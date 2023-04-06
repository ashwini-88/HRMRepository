package com.HRM.Practice;

import  static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void Test_01()
	{
		System.out.println("--Test Script_01--");
		System.out.println("--Test Script_02--");
	    assertEquals("TestYentra", "Qspider", "Data is mismatching");
	    System.out.println("--Test Script_03--");
	}
	
	@Test
	public void Test_02()
	{
		int a=10;
		System.out.println("--Test Script_04--");
		System.out.println("--Test Script_05--");
	    assertNull(a);
	    System.out.println("--Test Script_06--");
	}
}
