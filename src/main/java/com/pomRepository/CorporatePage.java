package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;

public class CorporatePage extends ExcelUtility{

	@FindBy(xpath ="//button[normalize-space()='Add Corporate']")
	private WebElement addCorporateBtn;
	
	@FindBy(xpath = "//input[@placeholder='Corporate Name']")
	private WebElement corporateNameTextField;                            //h4[text()='Add Corporate']
	
	@FindBy(xpath = "//button[.='Save']")
	private WebElement saveBtn;
	
	//Initialization
	public CorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddCorporateBtn() {
		return addCorporateBtn;
	}

	public WebElement getCorporateNameTextField() {
		return corporateNameTextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void clickOnCorporateBtn() throws Throwable
	{
		Thread.sleep(2000);
		addCorporateBtn.click();
		Thread.sleep(2000);
	}

	public void enterCorporateName(String corporate_name) throws Throwable {
		corporateNameTextField.sendKeys(corporate_name);
		saveBtn.click();
		
	}

}
