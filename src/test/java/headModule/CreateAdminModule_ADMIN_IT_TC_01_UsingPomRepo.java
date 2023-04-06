package headModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAdminModule_ADMIN_IT_TC_01_UsingPomRepo {

	public static void main(String[] args) throws Throwable {
		

		WebDriver driver=null;
		
		//Create the objects for the Utility expect IPath constant
	    WebDriverUtility WLib = new WebDriverUtility();	
		JavaUtility JLib = new JavaUtility();
		DataBaseUtility DBLib = new DataBaseUtility();
		ExcelUtility ELib = new ExcelUtility();
	    FileUtility FLib = new FileUtility();
	    
	    
	  //Launching the browser
		if("chrome".equals(FLib.readDataFromPropertyFile("browser"))) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if("firefox".equals(FLib.readDataFromPropertyFile("browser")))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		//Pre-Condition
		  WLib.maximizeWindow(driver);
		  WLib.waitForPageLoad(driver);
		  driver.get(FLib.readDataFromPropertyFile("url"));
		  
//verifying Login page
		
		  
		  
		//login as hr head
		  LoginPage lp = new LoginPage(driver);
		  lp.signInToAppASHrHead(null, null);

//Verify the DashBoard page 
		
		  
		  //Create the Admin As Hr Head
		  
		  
		  
		  
		  
	}
}
