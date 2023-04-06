package corporateModule;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CorporateCreatedByHrHead {
	

		public static void main(String[] args) throws Throwable {
			WebDriverManager.chromedriver().create();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//To accecc data from common_data file
					FileInputStream fis = new FileInputStream("./src/test/resources/HRM_commanData.properties");
					Properties pObj = new Properties();
					pObj.load(fis);
				    String BROWSER = pObj.getProperty("browser");
			        String URL = pObj.getProperty("url");
			        String Head_UserName = pObj.getProperty("headusername");
			        String Head_Password = pObj.getProperty("headpassword");
			        //String Assistant_UserName = pObj.getProperty("assistantusename");
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
		    
				String actualLoginTitle=driver.getTitle();
				String expectedLoginTitle="Admin Log in";
		    if(actualLoginTitle.equals(expectedLoginTitle))
		    {
		    	System.out.println("Login Page has displayed and verified");
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
		    driver.switchTo().alert().accept();
        
	    
	    String actualAdmin_DashboardTitle=driver.getTitle();
	    String expectedAdmin_DashboardTitle="Admin | Dashboard";
	    if(actualAdmin_DashboardTitle.equals(expectedAdmin_DashboardTitle))
	    {
	    	System.out.println("Admin DashBoard Page has displayed and verified");
	    }
	    else
	    {
	    	System.out.println("Admin DashBoard Page has not displayed");
	    }
	    
	    //create corporate 
	    driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
	    driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//p[text()='Add Corporate']")).click();
	    //driver.findElement(By.xpath("//button[normalize-space()='Add Corporate']")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'Add Corporate')]")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Corporate Name']")).sendKeys("ICICI");
	    driver.findElement(By.xpath("//button[.='Save']")).click();
	    driver.switchTo().alert().accept();
	    
	    String corporateCreated="ICICI";
	    String actualCorporateName = driver.findElement(By.xpath("//tbody/tr/td[text()='"+corporateCreated+"']")).getText();
	    String expectedcorporateName="ICICI";
	    if(actualCorporateName.equals(expectedcorporateName))
	    {
	    	System.out.println("Corporate has created and verified");
	    }
	    else
	    {
	    	System.out.println("Corporate has not created");
	    }
	    
	    //lodout from the application as hr head
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
	    driver.close();
	    
	  
}
}
