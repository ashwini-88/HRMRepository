package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardAdmin {
	
	//Declaration
	@FindBy(xpath="//p[normalize-space()='ADMIN']")
	private WebElement adminLink;
	
	@FindBy(xpath="//p[normalize-space()='Add Admin']")
	private WebElement addAdminLink;
	
	//Initialization
	public DashBoardAdmin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getAddAdminLink() {
		return addAdminLink;
	}
    
	public void DashBoardAdm()
	{
		adminLink.click();
	}
	
	public void DashBoardAdmLink()
	{
		addAdminLink.click();
	}
    //Business Library
	

	
	
		
}
