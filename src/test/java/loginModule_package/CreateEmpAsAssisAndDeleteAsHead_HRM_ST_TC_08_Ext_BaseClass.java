package loginModule_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.pomRepository.AssistantPage;
import com.pomRepository.BranchPage;
import com.pomRepository.CorporatePage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

public class CreateEmpAsAssisAndDeleteAsHead_HRM_ST_TC_08_Ext_BaseClass extends Baseclass {

	@Test(groups = "regression")
	public void createEmpAsAssisAndDeleteAsHead() throws Throwable {

//verifying Login page
		LoginPage lp = new LoginPage(driver);

		if (lp.validateLoginPage(ELib.readExpData("Exp_Data","expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and it is verified ");
		} else
			System.out.println("Login Page is not displayed and it is verified ");

		// login as hr head

		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"),
				FLib.readDataFromPropertyFile("headpassword"));

//Verify the DashBoard page 
		// create an Object for the DashBoardPage
		DashBoardPage dp = new DashBoardPage(driver);
		if (dp.validateDashBoardPage(ELib.readExpData("Exp_Data","expectedAdmin_DashboardTitle"))) {
			System.out.println("DashBoard Page is displayed and it is verified");
		} else
			System.out.println("DashBoard Page is not displayed and it is verified");

		dp.gotoCorporatePage();

		// Create an Object for the corporatePage
		CorporatePage cp = new CorporatePage(driver);
		cp.clickOnCorporateBtn();
		cp.enterCorporateName(ELib.readDataFromExcel("Corporate_Name", 0, 1));
		WLib.acceptAlert(driver);

//verify the Corporate created

		// create an Object for the BranchPage
		dp.gotoBranchPage();
		BranchPage bp = new BranchPage(driver);
		bp.clickOnAddBranchBtn();
		bp.enterBranchName(ELib.readDataFromExcel("Branch_Name", 0, 1));
		// bp.enterBranchName("branch_name");
		WLib.acceptAlert(driver);

//verify the Branch created 	  

		// Logout from the application as hr head
		dp.logoutOfAccount();

//Verificaton of LoginPage page after logout

		if (lp.validateLoginPage(ELib.readExpData("Exp_Data","expectedLoginTitle"))) {
			System.out.println("Logout successfully and Login Page is verified ");
		} else
			System.out.println("Logout is not successful and Login Page is not verified ");

		// login as Assistant and the object is already created
		String assistantUsername = FLib.readDataFromPropertyFile("assistantusename");
		String assistantPassword = FLib.readDataFromPropertyFile("assistantpassword");
		lp.signInToAppASHrAssistant(assistantUsername, assistantPassword);

//Verify the Assistant DashBoard

		AssistantPage as = new AssistantPage(driver);
		as.getAddEmpForm();
		as.fillEmpFormAs(ELib.readMultipleData("xyz"));
		as.uploadFileAndImg();

//	  driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_file201']")).sendKeys("C:\\\\Users\\\\91917\\\\Desktop\\\\XpathPractice.txt");
//	  driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_image']")).sendKeys("C:\\\\Users\\\\91917\\\\Pictures\\\\Camera Roll\\\\WIN_20220509_11_45_18_Pro.jpg");

		// as.uploadFileAndImg();

		if (as.validateInsertPopUp("Insert Successfully!!!")) {
			System.out.println("Insert Successfully!!! pop is displayed and it is verified");
		} else
			System.out.println("Insert Successfully!!! pop is not displayed and it is verified");

//to verify that emp has ceated 

		List<WebElement> allEmpNames = driver.findElements(By.xpath("//table//td[3]"));
		boolean flag = false;
		for (WebElement name : allEmpNames) {
			if (name.getText().equals("Ashwini")) {
				System.out.println("Emp is created and verified");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Emp is not created");
		}

		dp.logoutOfAccount();

//Verify the login Page After logout
		
		if (lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and Logout successfully");
		} else
			System.out.println("Login Page is not displayed and it is verified ");

		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"),
				FLib.readDataFromPropertyFile("headpassword"));

	}

}