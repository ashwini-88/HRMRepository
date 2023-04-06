package branchModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BranchCreatedByHr_Using_Utility {

	public static void main(String[] args) throws Throwable {
	    
		WebDriver driver=null;
		
		//Create the objects for the Utility expect IPath constant
	    WebDriverUtility WLib = new WebDriverUtility();	
		JavaUtility JLib = new JavaUtility();
		DataBaseUtility DBLib = new DataBaseUtility();
		ExcelUtility ELib = new ExcelUtility();
	    FileUtility FLib = new FileUtility();
	    
     	//To access data from common_data file
//				FileInputStream fis = new FileInputStream("./src/test/resources/HRM_commanData.properties");
//				Properties pObj = new Properties();
//				pObj.load(fis);
//			    String BROWSER = pObj.getProperty("browser");
//		        String URL = pObj.getProperty("url");
//		        
//		        //String Assistant_UserName = pObj.getProperty("assistantusename");
//		        //String Assistant_Password = pObj.getProperty("assistantpassword");
				
		String BROWSER=FLib.readDataFromPropertyFile("browser");
		String URL=FLib.readDataFromPropertyFile("url");
		String Head_UserName = FLib.readDataFromPropertyFile("headusername");
        String Head_Password = FLib.readDataFromPropertyFile("headpassword");
		
        //Launching the browser
				if(BROWSER.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER.equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new ChromeDriver();
				}
				
				//Pre-Condition
			//driver.manage().window().maximize();
				WLib.maximizeWindow(driver);
		    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				WLib.waitForPageLoad(driver);
				driver.get(URL);
	    
		String actualLoginTitle=driver.getTitle();    
		//String expectedLoginTitle="Admin Log in";
	    if(actualLoginTitle.equals(ELib.readExpData("Exp_Data", "expectedLoginTitle")))
	    {
	    	System.out.println("Login Page has displayed");
	    }
	    else
	    {
	    	System.out.println("Login Page has not displayed");
	    }
	    //login as hr head
	   
	    driver.findElement(By.name("hr_email")).sendKeys(Head_UserName);
	    driver.findElement(By.name("hr_password")).sendKeys(Head_Password);
	    WebElement selectType = driver.findElement(By.id("hr_type"));
	    Select select = new Select(selectType);
	    select.selectByValue("HR Head");
	    driver.findElement(By.name("login_hr")).click();
	    
	    //driver.switchTo().alert().accept();
	    WLib.acceptAlert(driver);
	    
	    String actualAdmin_DashboardTitle=driver.getTitle();
	    String expectedAdmin_DashboardTitle="Admin | Dashboard";
	    if(actualAdmin_DashboardTitle.equals(ELib.readExpData("Exp_Data", "expectedAdmin_DashboardTitle")))
	    {
	    	System.out.println("Admin DashBoard Page has displayed and verified");
	    }
	    else
	    {
	    	System.out.println("Admin DashBoard Page has not displayed");
	    }
	    
	    //create branches 
	    driver.findElement(By.xpath("//li[@class='nav-item has-treeview']//p[normalize-space()='BRANCHES']")).click();
	    driver.findElement(By.xpath("//a[@class='nav-link']//p[text()='Add Braches']")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'Add Branches')]")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Branches Name']")).sendKeys("JP Nagar");
	    driver.findElement(By.xpath("//button[.='Save']")).click();
	    
	    //driver.switchTo().alert().accept();
	    WLib.acceptAlert(driver);
	    
	    String branchesCreated="JP Nagar";
	    String actualbranchesName = driver.findElement(By.xpath("//tbody/tr/td[text()='"+branchesCreated+"']")).getText();
	   // String expectedBranchesName="JP Nagar";
	    if(actualbranchesName.equals(ELib.readExpData("exp_Data", "expectedBranchesName")))
	    {
	    	System.out.println("Branches has created and verified on the basis of branchName created");
	    }
	    else
	    {
	    	System.out.println("Branches has not created");
	    }
	    
	    //Logout from the application as hr head 
	    driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[normalize-space()='Welcome!,']")).click();
	    driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();
	    driver.switchTo().alert().accept();
	    
	    if(actualLoginTitle.equals(ELib.readExpData("Exp_Data", "expectedLoginTitle")))
	    {
	    	System.out.println("Login Page has displayed and logout successfully");
	    }
	    else
	    {
	    	System.out.println("Login Page has not displayed");
	    }
	    driver.quit();
		}
	}
