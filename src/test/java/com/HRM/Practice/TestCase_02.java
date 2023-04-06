package com.HRM.Practice;

import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;

public class TestCase_02 extends Baseclass{


	@Test(groups = "regression")
	 public void TS_03()
	    {
	    	System.out.println("--Test Script_3 will exc--");
	    }
	    
	@Test(groups = {"regression","smoke"})
	    public void TS_04()
	    {
	    	System.out.println("--Test Script_4 will exc--");
	    }
}
