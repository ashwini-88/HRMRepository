package loginModule_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;
import com.pomRepository.BranchPage;
import com.pomRepository.CorporatePage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CraeteEmpAsHead_HRM_ST_TC_01_UsingPomRepo {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;

		// Create the objects for the Utility expect IPath constant
		WebDriverUtility WLib = new WebDriverUtility();
		// JavaUtility JLib = new JavaUtility();
		// DataBaseUtility DBLib = new DataBaseUtility();
		ExcelUtility ELib = new ExcelUtility();
		FileUtility FLib = new FileUtility();

		// Launching the browser
		if ("chrome".equals(FLib.readDataFromPropertyFile("browser"))) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equals(FLib.readDataFromPropertyFile("browser"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// Create an objects for all the Gen Utility except IPath
		String BROWSER = FLib.readDataFromPropertyFile("browser");
		String URL = FLib.readDataFromPropertyFile("url");
		// String Head_UserName = FLib.readDataFromPropertyFile("headusername");
		// String Head_Password = FLib.readDataFromPropertyFile("headpassword");

		// Pre-Condition
		WLib.maximizeWindow(driver);
		WLib.waitForPageLoad(driver);
		driver.get(URL);

//verifying Login page

		LoginPage lp = new LoginPage(driver);
		if (lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and it is verified ");
		} else
			System.out.println("Login Page is not displayed and it is verified ");


		// login as hr head
		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"),
				FLib.readDataFromPropertyFile("headpassword"));

//Verify the DashBoard page 
		// create an Object for the DashBoardPage

		DashBoardPage dp = new DashBoardPage(driver);
		if (dp.validateDashBoardPage(ELib.readExpData("Exp_Data","expectedAdmin_DashboardTitle"))){
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

		// Create an Employee by head

//Verify on Emp craeted

		// Logout from the application as hr head
		dp.logoutOfAccount();

//Verificaton of LoginPage page after logout

		if (lp.validateLoginPage(ELib.readExpData("Exp_Data","expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and it is verified ");
		} else
			System.out.println("Login Page is not displayed and it is verified ");

		driver.quit();
	}
}
