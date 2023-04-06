package loginModule_package;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


	//User should be able to create Officer
	public class HRM_ST_TC_01 {

	static WebDriver driver =null;
		
		static WebDriverWait wait;
		public static void main(String[] args) throws Throwable {
			//To access data from common_data file
			FileInputStream fis = new FileInputStream("./src/test/resources/HRM_commanData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
		    String BROWSER = pObj.getProperty("browser");
	        String URL = pObj.getProperty("url");
	        String Head_UserName = pObj.getProperty("headusername");
	        String Head_Password = pObj.getProperty("headpassword");
	       // String Assistant_UserName = pObj.getProperty("assistantusename");
	        //String Assistant_Password = pObj.getProperty("assistantpassword");
			
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		
		//To access data from Test data file 
		 FileInputStream fi = new FileInputStream("./src/test/resources/HRM_TestData.xlsx");
	     Workbook wb = WorkbookFactory.create(fi);
	     Sheet sh = wb.getSheet("Sheet2");
	     
	     //create Empty HashMap
	     HashMap<String, String> map = new HashMap<String, String>();
	     //loading data to test data in the created HashMap as key and value pair 
	     for(int i=0;i<=sh.getLastRowNum();i++)
	     {
	     	String key = sh.getRow(i).getCell(0).getStringCellValue();
	         String row = sh.getRow(i).getCell(1).getStringCellValue();
	         map.put(key, row);
	     }
		
	    driver.get(URL);
	    String actualLoginTitle=driver.getTitle();
	    String expectedLoginTitle="Admin Log in";
	    
	    if(actualLoginTitle.equals(expectedLoginTitle))
	    {
	    	System.out.println("Login Page has displayed");
	    }
	    else
	    {
	    	System.out.println("Login Page has not displayed");
	    }
			//Validating the login page
			String expectedTitle = "Admin Log in";
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				System.out.println("Login Page is Displayed and varified");
			}else {
				System.err.println("Login page is not displayed and varified");
			}
			
			//login to the application
			driver.findElement(By.name("hr_email")).sendKeys(Head_UserName);
		    driver.findElement(By.name("hr_password")).sendKeys(Head_Password);
		    WebElement selectType = driver.findElement(By.id("hr_type"));
		    Select select = new Select(selectType);
		    select.selectByValue("HR Head");
		    driver.findElement(By.name("login_hr")).click();
			
			//validating the pop-up
			String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
			String actualPopuptext = driver.switchTo().alert().getText();
			if (actualPopuptext.equals(expectedPopuptext)) {
				System.out.println("Popup is displayed and varified upon popup text");
			}else {
				System.err.println("Popup is not displayed and varified upon popup text");
			}
			
			driver.switchTo().alert().accept();
			
			//validating the Homepage/Dashboard
			String expectedTabName = "Dashboard";
			String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();
			
			if (actualTabName.equals(expectedTabName)) {
				System.out.println("Dashboard is displayed and varified on board name");
			}else {
				System.err.println("Dashboard is not displayed and varified on board name");
			}
			
			//creating the admin credentials
			driver.findElement(By.xpath("//p[normalize-space()='ADMIN']")).click();
			driver.findElement(By.xpath("//p[normalize-space()='Add Admin']")).click();
			WebElement addAdminButton = driver.findElement(By.xpath("//button[normalize-space()='Add Admin']"));
			addAdminButton.click();
			
			String expectedAdminTabName = "Dashboard";
			String actualAdminTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();
			
			if (actualAdminTabName.equals(expectedAdminTabName)) {
				System.out.println("Admin page is displayed and varified on board name");
			}else {
				System.err.println("Admin page is not displayed and varified on board name");
			}
			
			
			String expectedAddAdminPopupTitle="Add Admin";
			String actualAddAdminPopupTitle =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Admin']"))).getText();
			
			if(actualAddAdminPopupTitle.equals(expectedAddAdminPopupTitle)) {
				System.out.println("Add Admin popup is displayed and varified upon title");
			}else {
				System.err.println("Add Admin popup is not displayed and varified upon title");
			}
			
			//fill the form for admin
			/*
			 * Company Id: 123
			 * First Name: QSP
			 * Last Name: Basavangudi
			 * Middle Name: Head Branch
			 * Contact No.: 12345678901
			 * Position: HR Head
			 * Email Address: qsphead@gmail.com
			 * password: qsphead@123
			 */
			String acName = "QSP";
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_companyid']")))).sendKeys("123");
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_firstname']")).sendKeys(acName);
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_lastname']")).sendKeys("Basavangudi");
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_middlename']")).sendKeys("Head Branch");
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_contactno']")).sendKeys("78912354661");
			WebElement selectType_dropdown = driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//select[@name='hr_type']"));
			Select selectType_DD = new Select(selectType_dropdown);
			selectType_DD.selectByVisibleText("→ HR Officer"); 
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_email']")).sendKeys("qspofficer@gmail.com");
			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_password']")).sendKeys("qspofficer@123");
			
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			
			//popup for sucessfully
			String expectedAdminInsertPopuptext = "Insert Successfully!!!";//Insert Successfully!!!
			String actualAdminInsertPopuptext = driver.switchTo().alert().getText();
			if (actualAdminInsertPopuptext.equals(expectedAdminInsertPopuptext)) {
				System.out.println("Popup is displayed and varified upon popup text");
			}else {
				System.err.println("Popup is not displayed and varified upon popup text");
			}
			
			driver.switchTo().alert().accept();
			boolean flag = false;
			List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
			for (WebElement empName : EmployeeNames) {
				if(empName.getText().equals("QSP")) {
					flag=true;
					System.out.println("The Admin is sucessfully created");
					break;
				}
			}
			if(!flag) {
				System.out.println("The Admin is not created");
			}
			
			//Logout of application
			driver.findElement(By.xpath("//b[text()='Welcome!,']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
			String expectedLogoutPopuptext = "Successfully Logout!";//Successfully Logout!
			String actualLogoutPopuptext = driver.switchTo().alert().getText();
			if (actualLogoutPopuptext.equals(expectedLogoutPopuptext)) {
				System.out.println("Popup is displayed and varified upon popup text");
			}else {
				System.err.println("Popup is not displayed and varified upon popup text");
			}
			driver.switchTo().alert().accept();
			
			String actualAftreLogoutTitle = driver.getTitle();
			if (actualAftreLogoutTitle.equals(expectedTitle)) {
				System.out.println("Login Page is Displayed and varified");
			}else {
				System.err.println("Login page is not displayed and varified");
			}

			//terminate the browser
			driver.quit();
			
		}
	}

