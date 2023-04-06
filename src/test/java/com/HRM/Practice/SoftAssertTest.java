package com.HRM.Practice;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	SoftAssert sa = new SoftAssert();
	@Test
	public void Test_01()
	{
		System.out.println("--Test Script_01--");
		System.out.println("--Test Script_02--");
		sa.assertEquals("TestYentra", "Qspider", "Data is mismatching");
	    System.out.println("--Test Script_03--");
	    sa.assertAll();
	}
	
	@Test
	public void Test_02()
	{
		int a=10;
		System.out.println("--Test Script_04--");
		System.out.println("--Test Script_05--");
		sa.assertNull(a);
	    System.out.println("--Test Script_06--");
	    sa.assertAll();
	}
}
