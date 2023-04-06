package com.HRM.Practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgApplication {
public static void main(String[] args) throws Throwable {
	
	Connection con=null;
	 ResultSet result =null;
     String expProj="Rmg_Ashu"; 
     WebDriver driver=null;
   
     WebDriverManager.chromedriver().setup();
     FileInputStream fis = new FileInputStream("./src/test/resources/commanDataRmgApplication.properties");
		Properties pObj = new Properties(); 
		pObj.load(fis); 
		
		//launch the browser
        if(pObj.getProperty("browser").equals("chrome"))
      {
    	  driver=new ChromeDriver();
      }
        else if(pObj.getProperty("browser").equals("firefox"))
        {
        	driver=new FirefoxDriver();
        }
        String URL = pObj.getProperty("url");
        String UserName = pObj.getProperty("username");
        String Password = pObj.getProperty("password");
		
        //Pre-conditions
        driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	     
	    //Trigger the Url
        driver.get(URL);
        
        //Login to the Application and welcome page will be displayed
        driver.findElement(By.id("usernmae")).sendKeys(UserName);
        driver.findElement(By.id("inputPassword")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        
        //Create the Project
        Thread.sleep(2000);
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']/span[text()='Create Project']")).click();
        
        driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expProj);
        driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Ashwini");
        
        WebElement selectValue = driver.findElement(By.xpath("//select[@name='status']"));
        Select select = new Select(selectValue);
        select.selectByValue("Created");
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();
        
        //Register the DataBase
        Driver driver1 = new Driver();
        DriverManager.registerDriver(driver1);
         con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
        Statement state = con.createStatement();
        String query="select * from project";
        result = state.executeQuery(query);
        
        boolean flag=false;
        while(result.next())
        {
        	//Project name is in the 4th column
        	String actProj=result.getString(4);
        	System.out.println(actProj);
        	if(actProj.equalsIgnoreCase(actProj))
        	{
        		flag=true;
        		break;
            }
        }
       
        if(flag)
        {
        	System.out.println("Project is Created");
        }
        else 
        	System.out.println("Project is not created");
        
       con.close();
    	 driver.quit();
            
  

}

}
