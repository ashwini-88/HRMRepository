package com.HRM.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneWayTripInMakeMyTrip {
public static void main(String[] args) throws Throwable {
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
	//Close popup
	driver.findElement(By.xpath("//span[.='From']")).click();
	WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
	from.sendKeys("Bangalore");
	driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
	
	driver.findElement(By.xpath("//span[.='To']")).click();
	WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
	to.sendKeys("Mangalore");
	driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
	
	driver.findElement(By.xpath("//div[.='March 2023']/parent::div[@class='DayPicker-Month']//p[.='21']")).click();
	
	//driver.findElement(By.xpath("//p[@data-cy='travellerText']")).click();
	driver.findElement(By.xpath("//div[@data-cy='flightTraveller']")).click();
	driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
	driver.findElement(By.xpath("//ul/li[text()='Premium Economy']")).click();
	driver.findElement(By.xpath("//button[.='APPLY']")).click();
	
	driver.findElement(By.xpath("//a[.='Search']")).click();
}
}
