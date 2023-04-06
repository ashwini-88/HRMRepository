package com.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
     
	/**
	 * This is to max the window
	 * driver
	 * @author Ashwini
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * Wait
	 * driver
	 * @author Ashwini
	 */
	
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait until element to be visible
	 * driver
	 * @author Ashwini 
	 */
	 
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
//wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will select data from dropDown using value
	 * element
	 * value
	 */
	public void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select the data from dropdown using index
	 * element
	 * index
	 */
	public void selectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will select the data from dropDown using visible text
	 * visibleText
	 * element
	 */
	public void selectByVisibleText(WebElement element,String visibleText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * this method is used to perform mouseHover action
	 * driver
	 * element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will perform drag and drop action 
	 * driver
	 * src
	 * dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dsc)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dsc).perform();;
	}
    /**
     * this method is used double click on webPage
     * driver
     */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will preform right click
	 * driver
	 */
	public void rightclick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * right click on the element
	 * driver
	 * element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 *Press enter key
	 *driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method will press Enter key
	 * robot
	 * driver
	 * @throws Throwable 
	 */
	public void enterKeyPressRobot(WebDriver driver) throws Throwable
	{
	Robot rb = new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);	
	}
	/**
	 * Release the key
	 * Robot 
	 * driver
	 * @throws Throwable 
	 */
	public void enterKeyReleaseRobot(WebDriver driver) throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will switcc the frame based on index
	 * driver
	 * index
	 */
	public void switchToFrameIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId) 
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * switch the frame based on address
	 * driver
	 * address
	 */
	public void switchToFrameUsingAddress(WebDriver driver, String address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * accept alet Popup
	 * driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * cancel alert popup
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * switch to window
	 * 
	 */
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//stept1: use getWindowHandle to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through thr windows 
		Iterator<String> it = windows.iterator();
		
		//spet3: check whether ther is next window 
		while(it.hasNext())
		{
			//step4: capture current window id 
			String windId = it.next();
			
			//switch to current window and capture title 
			String currentWindowTitle = driver.switchTo().window(windId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWindowTitle.contains(partialTitle))
	         {
				break;
	         }
		}
	}
	/**
	 * take ScreenShot and store it in the folder called screenShot
	 * @param driver
	 * @param screenShotName
	 * @return 
	 * @throws Throwable 
	 */
	 public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	 {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String path = "./screenshot/"+screenShotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	 }
	 /**
	  * to perform random scroll
	  * @author Ashwini
	  * @param driver
	  */
	public void scrollBarAction(WebDriver driver)
	{
	  JavascriptExecutor jse= (JavascriptExecutor) driver;
	  jse.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This method will scroll until the specifiedelement is found
	 * 
	 */
	public void scrollActionUntillSpecifiedElement(WebDriver driver,WebElement element)
	{ 
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.selectBy(0,"+y+")", element);
	}
	/**
	 * used to wait for element to be clickable in GUI , & check for specific element for every 500 
	milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) 
	{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
   
	public void waitForElementWithCustomTimeOut(WebDriver driver,int pollingTime,WebElement element) throws Throwable
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}

