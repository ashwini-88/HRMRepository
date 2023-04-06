package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;

public class BranchPage  extends ExcelUtility{

	@FindBy(xpath = "//button[contains(text(),'Add Branches')]")
	private WebElement addBranchBtn;
	
	@FindBy(xpath = "//input[@placeholder='Branches Name']")
	private WebElement branchNameTextField;
	
	@FindBy(xpath ="//button[.='Save']")
	private WebElement saveBtn;
	
	//Initialization
			public BranchPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			public WebElement getAddBranchBtn() {
				return addBranchBtn;
			}

			public WebElement getBranchNameTextField() {
				return branchNameTextField;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}
			
			public void clickOnAddBranchBtn()
			{
				addBranchBtn.click();
			}
			
			public void enterBranchName(String branch_name) throws Throwable
			{
				branchNameTextField.sendKeys(branch_name);
				saveBtn.click();
			}
	
}
