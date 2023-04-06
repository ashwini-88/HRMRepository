package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.pomRepository.DashBoardPage;
import com.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriverUtility WLib = new WebDriverUtility();
	public JavaUtility JLib = new JavaUtility();
	public DataBaseUtility DBLib = new DataBaseUtility();
	public ExcelUtility ELib = new ExcelUtility();
	public FileUtility FLib = new FileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		// DBLib.connectToDb();
		System.out.println("--Connect to DB--");
	}

//    @Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
//    public void configBC(String BROWSER) throws Throwable{
	public void configBC() throws Throwable {
		String BROWSER = FLib.readDataFromPropertyFile("browser");
		String URL = FLib.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			//driver = WebDriverManager.chromedriver().create();
	        WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} 
		else {
			System.out.println("Invalid browser");
		}

		
		sdriver=driver;
		
		WLib.maximizeWindow(driver);

		driver.get(URL);

		WLib.waitForPageLoad(driver);
	}

//    @BeforeMethod
	public void configBM() throws Throwable {
		String USERNAME = FLib.readDataFromPropertyFile("username");
		String PASSWORD = FLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.signInToAppASHrHead(USERNAME, PASSWORD);
	}

//    @AfterMethod
	public void configAM() throws Throwable {
		
		DashBoardPage dp = new DashBoardPage(driver);
		dp.logoutOfAccount();
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		// DBLib.closeDB();
	}
}
