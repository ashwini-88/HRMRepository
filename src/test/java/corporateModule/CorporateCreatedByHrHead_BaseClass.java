package corporateModule;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.pomRepository.CorporatePage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

public class CorporateCreatedByHrHead_BaseClass extends Baseclass{

	@Test(groups = "integration",retryAnalyzer = com.GenericUtilities.RetryImpClass.class)
	public void CorporateCreatedByHrHead() throws Throwable{
	//verifying Login page
	  LoginPage lp = new LoginPage(driver);
	  
	  
	  assertEquals(lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle")), "Login Page is not displayed and it is verified ");
	  Reporter.log("Login Page is displayed and it is verified ");
	  
	  Assert.fail();
	  
	  
	//login as hr head

	  lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"), FLib.readDataFromPropertyFile("headpassword"));
	  
//Verification of DashBoard

	//Verify the DashBoard page 
		//create an Object for the DashBoardPage 	 
		  DashBoardPage dp = new DashBoardPage(driver);
		
		  
      assertEquals(dp.validateDashBoardPage(ELib.readExpData("Exp_Data", "expectedAdmin_DashboardTitle")), "DashBoard Page is not displayed and it is verified");
	  Reporter.log("DashBoard Page is displayed and it is verified");
	  //create corporate 
	
	  //create an Object for the DashBoardPage 
	  dp.gotoCorporatePage();
	  
	  //Create an Object for the corporatePage
	  CorporatePage cp = new CorporatePage(driver);
	  cp.clickOnCorporateBtn();
	  cp.enterCorporateName(ELib.readDataFromExcel("Corporate_Name",0,1));
    WLib.acceptAlert(driver);
       
   
    
//verify on Corporate creation
    
  //Logout from the application as hr head 
	  dp.logoutOfAccount();
	
//Verify on logout whether loginPaage is created 

		
		assertEquals(lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle")), "Login Page is not displayed and it is verified ");
		Reporter.log("Login Page is displayed and Logout successfully");
		
		driver.quit();
	  
	  
}
}