package branchModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;
import com.pomRepository.BranchPage;
import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BranchCreatedByHrHead_UsingPomRepo {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;

		// Create the objects for the Utility expect IPath constant
		WebDriverUtility WLib = new WebDriverUtility();
//	JavaUtility JLib = new JavaUtility();
//	DataBaseUtility DBLib = new DataBaseUtility();
		ExcelUtility ELib = new ExcelUtility();
		FileUtility FLib = new FileUtility();

		String BROWSER = FLib.readDataFromPropertyFile("browser");
		String URL = FLib.readDataFromPropertyFile("url");
		// String Head_UserName = FLib.readDataFromPropertyFile("headusername");
		// String Head_Password = FLib.readDataFromPropertyFile("headpassword");

		// Launching the browser
		if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}

		// Pre-Condition
		WLib.maximizeWindow(driver);
		WLib.waitForPageLoad(driver);
		driver.get(URL);

//	   

		// verifying Login page
		LoginPage lp = new LoginPage(driver);

		if (lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and it is verified ");
		} else
			System.out.println("Login Page is not displayed and it is verified ");

		// login as hr head
		lp.signInToAppASHrHead(FLib.readDataFromPropertyFile("headusername"),
				FLib.readDataFromPropertyFile("headpassword"));

		// Verify the DashBoard page
		// create an Object for the DashBoardPage
		DashBoardPage dp = new DashBoardPage(driver);
		if (dp.validateDashBoardPage(ELib.readExpData("Exp_Data", "expectedAdmin_DashboardTitle"))) {
			System.out.println("DashBoard Page is displayed and it is verified");
		} else
			System.out.println("DashBoard Page is not displayed and it is verified");
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

		if (lp.validateLoginPage(ELib.readExpData("Exp_Data", "expectedLoginTitle"))) {
			System.out.println("Login Page is displayed and Logout successfully");
		} else
			System.out.println("Login Page is not displayed and it is verified ");
		driver.quit();
	}
}
