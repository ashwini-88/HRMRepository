package com.HRM.Practice;

import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;

public class TestCase_03 extends Baseclass{
	
	@Test(groups = "smoke")
	public void TS_05()
	    {
	    	System.out.println("--Test Script_5 will exc--");
	    }
	    
	@Test(groups = "regression")
	    public void TS_06()
	    {
	    	System.out.println("--Test Script_6 will exc--");
	    }
}
