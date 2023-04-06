package com.HRM.Practice;

import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;

public class TestCase_01 extends Baseclass{

	@Test(groups = "smoke")
	
    public void TS_01()
    {
    	System.out.println("--Test Script_1 will exc--");
    }
    
	@Test(groups = {"smoke","regression"})
    public void TS_02()
    {
    	System.out.println("--Test Script_2 will exc--");
    }
}

