package com.HRM.Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoundTripInMakeMyTrip{
public static void main(String[] args) {
	//setup the browser setting to avoid the notification popup
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disabled-notifications");
		// options.addArguments("--header");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//trigger the MMT application
		driver.get("https://www.makemytrip.com/");
		//Close popup on the display
	driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
	//selecting the round trip 
	driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();

//	driver.findElement(By.xpath("//span[.='From']")).click();
//	WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
//	from.sendKeys("Bangalore");
//	driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
//	
//	driver.findElement(By.xpath("//span[.='To']")).click();
//	WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
//	to.sendKeys("Mangalore");
//	driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
	//select the from location
			driver.findElement(By.cssSelector("label[for='fromCity']")).click();
			driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("Bengalore");
			driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
			//select the to location
			driver.findElement(By.cssSelector("label[for='toCity']")).click();
			driver.findElement(By.cssSelector("input[placeholder='To']")).sendKeys("Mangalore");
			driver.findElement(By.xpath("//p[text()='Mangalore International Airport']")).click();
			
			//Select the travel date
			Date date = new Date();
			String[] cDate = date.toString().split(" ");
			String Tday = cDate[0];
			String Tmonth = cDate[1];
			String Tdate = cDate[2];
			String Tyear = cDate[5];
			
			// Thu Mar 16 2023
			String traveldate = Tday + " " + Tmonth + " " + Tdate + " " + Tyear;
			driver.findElement(By.xpath("//div[@aria-label='" + traveldate + "']")).click();
			//select the return date
			String returnDate = "Wed Jul 12 2023";
			
			for (;;) {
				try {
					driver.findElement(By.xpath("//div[@aria-label='" + returnDate + "']")).click();
					break;
				} catch (Exception e) {
					//driver.findElement(By.cssSelector("span[aria-label=\"Next Month\"]")).click();
				     driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				}
				
			}
			//Select the travelers
			driver.findElement(By.cssSelector("label[for='travellers']")).click();
			driver.findElement(By.cssSelector("li[data-cy='adults-7']")).click();
			driver.findElement(By.xpath("//button[text()='APPLY']")).click();
			//click on search button
			driver.findElement(By.cssSelector("a.primaryBtn.font24.latoBold.widgetSearchBtn")).click();
			//terminate the browser
			driver.quit();
	
    //driver.findElement(By.xpath("//div[.='March 2023']/parent::div[@class='DayPicker-Month']//p[.='21']")).click();
	
//	driver.findElement(By.xpath("//p[@data-cy='travellerText']")).click();
//	driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
//	driver.findElement(By.xpath("//button[.='APPLY']")).click();
//	
//	driver.findElement(By.xpath("//a[.='Search']")).click();
}
}
