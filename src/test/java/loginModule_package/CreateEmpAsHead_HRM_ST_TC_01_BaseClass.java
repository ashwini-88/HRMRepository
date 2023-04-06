package loginModule_package;

import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.pomRepository.BranchPage;
import com.pomRepository.CorporatePage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

public class CreateEmpAsHead_HRM_ST_TC_01_BaseClass extends Baseclass{
  
	@Test(groups = "regression")
	public void CreateEmpAsHead() throws Throwable
	
	{

	//verifying Login page
		//login as hr head

		  LoginPage lp = new LoginPage(driver);

		  if(lp.validateLoginPage("expectedLoginTitle"))
		  {
			  System.out.println("Login Page is displayed and it is verified ");
		  }
		  else 
			  System.out.println("Login Page is not displayed and it is verified ");
		  
		    
		//login as hr head  
		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"), FLib.readDataFromPropertyFile("headpassword"));

	//Verify the DashBoard page 
		 //create an Object for the DashBoardPage 
		 
		DashBoardPage dp = new DashBoardPage(driver);
		 if(dp.validateDashBoardPage("expectedAdmin_DashboardTitle")) 
		 {
			System.out.println("DashBoard Page is displayed and it is verified"); 
		 }
		 else System.out.println("DashBoard Page is not displayed and it is verified"); 
		  
		
		dp.gotoCorporatePage();
		  
		  //Create an Object for the corporatePage
		  CorporatePage cp = new CorporatePage(driver);
		  cp.clickOnCorporateBtn();
		  cp.enterCorporateName(ELib.readDataFromExcel("Corporate_Name",0,1));
	      WLib.acceptAlert(driver);
	      
	//verify the Corporate created
		  
		//create an Object for the BranchPage
	      dp.gotoBranchPage();
		  BranchPage bp=new BranchPage(driver);
		  bp.clickOnAddBranchBtn();
		  bp.enterBranchName(ELib.readDataFromExcel("Branch_Name",0,1));
		  //bp.enterBranchName("branch_name");
		  WLib.acceptAlert(driver);

	//verify the Branch created 	  
		  
		  
		  
		  
		  //Create an Employee by head 
	       
		  
		  
		  
	//Verify on Emp craeted
		  
		  
		  
		  
		  //Logout from the application as hr head 
		  dp.logoutOfAccount();
		  
		  
		  
	//Verificaton of LoginPage page after logout
		  
		  if(lp.validateLoginPage("expectedLoginTitle"))
		  {
			  System.out.println("Login Page is displayed and it is verified ");
		  }
		  else 
			  System.out.println("Login Page is not displayed and it is verified ");
		  
		    
		 driver.quit(); 
	}
	}


