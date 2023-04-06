package branchModule;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.pomRepository.BranchPage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

@Listeners(com.GenericUtilities.ListenerImplementationClass.class)

public class BranchCreatedByHrHead_BaseClass extends Baseclass {

	@Test(groups = "integration")
	public void BranchCreatedByHrHead() throws Throwable {

		// verifying Login page
		LoginPage lp = new LoginPage(driver);

		

	assertTrue(lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle")), "Login Page is not displayed and it is verified ");
	Reporter.log("Login Page is displayed and it is verified ",true);
		
	
	// login as hr head
		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"),
				FLib.readDataFromPropertyFile("headpassword"));

		
		
		// Verify the DashBoard page
		// create an Object for the DashBoardPage
		DashBoardPage dp = new DashBoardPage(driver);
		
		
		assertTrue(dp.validateDashBoardPage(ELib.readExpData("Exp_Data", "expectedAdmin_DashboardTitle")),"DashBoard Page is not displayed and it is verified");
		Reporter.log("DashBoard Page is displayed and it is verified",true);
		Assert.fail();
		
		
		// create branches
		// create an Object for the DashBoardPage
		dp.gotoBranchPage();
		
		// create an Object for the BranchPage
		BranchPage bp = new BranchPage(driver);
		bp.clickOnAddBranchBtn();
		bp.enterBranchName(ELib.readDataFromExcel("Branch_Name", 0, 1));
		
		// bp.enterBranchName("branch_name");
		WLib.acceptAlert(driver);

		// Logout from the application as hr head
		dp.logoutOfAccount();

		//verify the login page after logout 
		assertTrue(lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle")), "Login Page is not displayed and it is verified ");
		Reporter.log("Login Page is displayed and Logout successfully",true);
	}
}
