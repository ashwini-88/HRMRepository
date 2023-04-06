package loginModule_package;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM_ST_TC_08 {
	
	//As it is in Global I am making this static 
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
        String Assistant_UserName = pObj.getProperty("assistantusename");
        String Assistant_Password = pObj.getProperty("assistantpassword");
		
		//Launching the browser
		if(BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		//Pre-Condition
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(URL);
	
	//To access data from Test data file 
	 FileInputStream fi = new FileInputStream("./src/test/resources/HRM_TestData.xlsx");
     Workbook wb = WorkbookFactory.create(fi);
     Sheet sh = wb.getSheet("Sheet1");
     
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
    
    driver.findElement(By.name("hr_email")).sendKeys(Head_UserName);
    driver.findElement(By.name("hr_password")).sendKeys(Head_Password);
    WebElement selectType = driver.findElement(By.id("hr_type"));
    Select select = new Select(selectType);
    select.selectByValue("HR Head");
    driver.findElement(By.name("login_hr")).click();
    driver.switchTo().alert().accept();
    
    String actualAdmin_DashboardTitle=driver.getTitle();
    String expectedAdmin_DashboardTitle="Admin | Dashboard";
    if(actualAdmin_DashboardTitle.equals(expectedAdmin_DashboardTitle))
    {
    	System.out.println("Admin DashBoard Page has displayed");
    }
    else
    {
    	System.out.println("Admin DashBoard Page has not displayed");
    }
    
    driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
    driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//p[text()='Add Corporate']")).click();
    //driver.findElement(By.xpath("//button[normalize-space()='Add Corporate']")).click();
    driver.findElement(By.xpath("//button[contains(text(),'Add Corporate')]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Corporate Name']")).sendKeys("ICICI");
    driver.findElement(By.xpath("//button[.='Save']")).click();
    driver.switchTo().alert().accept();
    
    String corporateCreated="ICICI";
    String actualCorporateName = driver.findElement(By.xpath("//tbody/tr/td[text()='"+corporateCreated+"']")).getText();
    String expectedCorporateName="ICICI";
    if(actualCorporateName.equals(expectedCorporateName))
    {
    	System.out.println("Corporate has created");
    }
    else
    {
    	System.out.println("Corporate has not created");
    }
    
    driver.findElement(By.xpath("//li[@class='nav-item has-treeview']//p[normalize-space()='BRANCHES']")).click();
    driver.findElement(By.xpath("//a[@class='nav-link']//p[text()='Add Braches']")).click();
    driver.findElement(By.xpath("//button[contains(text(),'Add Branches')]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Branches Name']")).sendKeys("JP Nagar");
    driver.findElement(By.xpath("//button[.='Save']")).click();
    driver.switchTo().alert().accept();
    
    String branchesCreated="JP Nagar";
    String actualbranchesName = driver.findElement(By.xpath("//tbody/tr/td[text()='"+branchesCreated+"']")).getText();
    String expectedBranchesName="JP Nagar";
    if(actualbranchesName.equals(expectedBranchesName))
    {
    	System.out.println("Branches has created");
    }
    else
    {
    	System.out.println("Branches has not created");
    }
    
    driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[normalize-space()='Welcome!,']")).click();
    driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();
    driver.switchTo().alert().accept();
    
    if(actualLoginTitle.equals(expectedLoginTitle))
    {
    	System.out.println("Login Page has displayed");
    }
    else
    {
    	System.out.println("Login Page has not displayed");
    }
    
    driver.findElement(By.name("hr_email")).sendKeys(Assistant_UserName);
    driver.findElement(By.name("hr_password")).sendKeys(Assistant_Password);
    WebElement selectTypeOfHrAssistant = driver.findElement(By.id("hr_type"));
    Select selectAssistant = new Select(selectTypeOfHrAssistant);
    selectAssistant.selectByValue("HR Assistant");
    driver.findElement(By.name("login_hr")).click();
    driver.switchTo().alert().accept();
    
    String AssistantPageDashboard="hrassistant@gmail.com";
    String actualAssistantPageDashboard=driver.findElement(By.xpath("//a[text()='"+AssistantPageDashboard+"']")).getText();
    String expectedAssistantPageDashboard="hrassistant@gmail.com";
    if(actualAssistantPageDashboard.equals(expectedAssistantPageDashboard))
    {
    	System.out.println("Assistant DashBoard has displayed");
    }
    else
    {
    	System.out.println("Assistant DashBoard has not displayed");
    }
    
    driver.findElement(By.xpath("//li[@class='nav-item has-treeview']//p[contains(.,'EMPLOYEE')]")).click();
    driver.findElement(By.xpath("//a[@href='Add_employee.php']//p[.='Add Employee']")).click();
    driver.findElement(By.xpath("//button[normalize-space()='Add Employee']")).click();
    String empFirstName = "Ashwini";
    for(Entry<String, String> emp:map.entrySet())
    {
    	if(emp.getKey().equals("employee_department")) {
    	    WebElement selectDepatment = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
    	    Select selectDep = new Select(selectDepatment);
    	    selectDep.selectByValue(emp.getValue());
    	}else if (emp.getKey().equals("employee_branches")) {
    	    WebElement selectBranches = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
    	    Select selectBran = new Select(selectBranches);
    	    selectBran.selectByValue(emp.getValue());
		}else {
			driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='"+emp.getKey()+"']")).sendKeys(emp.getValue());
		}
    }
    
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_companyid']")).sendKeys("12345");
//    //WebElement empFirstName = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_firstname']"));
//    
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_lastname']")).sendKeys("Ironman");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_middlename']")).sendKeys("Avenger");
//    //driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_lastname']")).sendKeys("Ironman");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='branches_datefrom']")).sendKeys("22-03-2023");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='branches_recentdate']")).sendKeys("25-03-2023");
//    
//    WebElement selectDepatment = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='employee_department']"));
//    Select selectDep = new Select(selectDepatment);
//    selectDep.selectByValue("ICICI");
//    
//    WebElement selectBranches = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='employee_branches']"));
//    Select selectBran = new Select(selectBranches);
//    selectBran.selectByValue("JP Nagar");
//    
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_position']")).sendKeys("Captain");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_contact']")).sendKeys("78912354660");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_sss']")).sendKeys("1236");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_tin']")).sendKeys("32145");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_hdmf_pagibig']")).sendKeys("2135");
//    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_gsis']")).sendKeys("25896");
    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_file201']")).sendKeys("C:\\Users\\91917\\Desktop\\XpathPractice.txt");
    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_image']")).sendKeys("C:\\Users\\91917\\Pictures\\Camera Roll\\WIN_20220509_11_45_18_Pro.jpg");
    driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//button[.='Save']")).click();
	
    //Insert sucecssfully popup should be should be displayed
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    //Employee page should be displayed and Employee should be created
    
    String employeeFirstName="Ashwini";
    String actualEmployeeFirstName = driver.findElement(By.xpath("//tbody/tr/td[text()='"+employeeFirstName+"']")).getText();
    String expectedEmployeeFirstName="JP Nagar";
    if(actualEmployeeFirstName.equals(expectedEmployeeFirstName))
    {
    	System.out.println("Employee has created");
    }
    else
    {
    	System.out.println("Employee has not created");
    }
    
    
    //Logout option should be displayed
    //Successfully Logout popup should be displayed
    //Login page should be displayed
    
    driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[normalize-space()='Welcome!,']")).click();
    driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();
    driver.switchTo().alert().accept();
    
    if(actualLoginTitle.equals(expectedLoginTitle))
    {
    	System.out.println("Login Page has displayed");
    }
    else
    {
    	System.out.println("Login Page has not displayed");
    }
    
   /* Enter the valid HR email id
    Enter the valid HR password
    Select the Type
    Click on remember password check box
    Click on signIn button
    */
    
    driver.findElement(By.name("hr_email")).sendKeys(Head_UserName);
    driver.findElement(By.name("hr_password")).sendKeys(Head_Password);
    WebElement selectTypeHrHead = driver.findElement(By.id("hr_type"));
    Select selectHrHead = new Select(selectTypeHrHead);
    selectHrHead.selectByValue("HR Head");
    driver.findElement(By.name("login_hr")).click();
    driver.switchTo().alert().accept();
   // Dashboard page should be displayed

    String actualAdmin_DashboardTitle1=driver.getTitle();
    String expectedAdmin_DashboardTitle1="Admin | Dashboard";
    if(actualAdmin_DashboardTitle1.equals(expectedAdmin_DashboardTitle1))
    {
    	System.out.println("Admin DashBoard Page has displayed");
    }
    else
    {
    	System.out.println("Admin DashBoard Page has not displayed");
    }
    
   //Delete the Employee
    driver.findElement(By.xpath("//td[text()='"+empFirstName+"']/../td[9]/i[2]")).click();
    driver.findElement(By.xpath("//input[@value='"+empFirstName+"']/../..//button[text()='Delete']"));
    driver.findElement(By.xpath("//input[@value='Hari Krish']/../..//button[text()='Delete']")).click();
    //To Click OK Button 
    driver.switchTo().alert().accept();
    
    //String actualAdmin_DashboardTitle=driver.getTitle();
    //String expectedAdmin_DashboardTitle="Admin | Dashboard";
    if(actualAdmin_DashboardTitle.equals(expectedAdmin_DashboardTitle))
    {
    	System.out.println("Admin DashBoard Page has displayed");
    }
    else
    {
    	System.out.println("Admin DashBoard Page has not displayed");
    }
    driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[normalize-space()='Welcome!,']")).click();
    driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();
    driver.switchTo().alert().accept();
    
    if(actualLoginTitle.equals(expectedLoginTitle))
    {
    	System.out.println("Login Page has displayed");
    }
    else
    {
    	System.out.println("Login Page has not displayed");
    }
    
    driver.quit();
	}
}
	



