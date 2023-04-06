package com.HRM.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {
public static void main(String[] args) {
	//Notification Popup
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disabled-notifications");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.spicejet.com/");
	driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
    driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
    WebElement from = driver.findElement(By.xpath("//div[text()='From']/..//input"));
    from.sendKeys("Bengaluru");
    driver.findElement(By.cssSelector("div[@data-testid='to-testID-destination']"));
}
}
