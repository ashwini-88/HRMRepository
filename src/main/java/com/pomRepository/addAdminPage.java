package com.pomRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.WebDriverUtility;

import hrmPOM.AdminModule;

public class addAdminPage extends WebDriverUtility{

	WebDriver driver=null;
	//Declaration
	

	@FindBy(xpath = "//p[contains(text(),'ADMIN')]")
	private WebElement adminModule;
	
	@FindBy(xpath = "//p[contains(text(),'Add Admin')]")
	private WebElement addAdminLink;
	
	@FindBy(xpath = "//button[normalize-space()='Add Admin']")
	private WebElement addAdminBtn;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_companyid']")
	private WebElement hrCompanyid;
	
	@FindBy(xpath ="//h4[text()='Add Admin']/../..//input[@name='hr_firstname']")
	private WebElement hrFirstname;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_lastname']")
	private WebElement hrLastname;

	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_middlename']")
	private WebElement hrMiddlename;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_contactno']")
	private WebElement hrContactno;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//select[@name='hr_type']")
	private WebElement hrType;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_email']")
	private WebElement hrEmail;
	
	@FindBy(xpath = "//h4[text()='Add Admin']/../..//input[@name='hr_password']")
	private WebElement hrPassword;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;
	
	//Initialization
		public addAdminPage(WebDriver driver)
		{
			this.driver = driver;
			//PageFactory.initElements(driver, this);
	PageFactory.initElements(driver, this);
		}

		//Utilization
		
//		public WebElement getAddAdminBtn() {
//			return addAdminBtn;
//		}
//
//		public WebElement getHrCompanyid() {
//			return hrCompanyid;
//		}
//
//		public WebElement getHrFirstname() {
//			return hrFirstname;
//		}
//
//		public WebElement getHrLastname() {
//			return hrLastname;
//		}
//
//		public WebElement getHrMiddlename() {
//			return hrMiddlename;
//		}
//		
//
//		public WebElement getHrContactno() {
//			return hrContactno;
//		}
//
//		public WebElement getHrType() {
//			return hrType;
//		}
//
//		public WebElement getHrEmail() {
//			return hrEmail;
//		}
//
//		public WebElement getHrPassword() {
//			return hrPassword;
//		}
//
//		public WebElement getSaveBtn() {
//			return saveBtn;
//		}
	
   public void getAdminAddForm()
   {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(adminModule)).click();
	   wait.until(ExpectedConditions.visibilityOf(addAdminLink)).click();
	   wait.until(ExpectedConditions.visibilityOf(addAdminBtn)).click();
	  
   }
   

  /* public void (String companyId)
   {
	   hrCompanyid.sendKeys(companyId);
   }*/
   
	public void hrFirstname(String firstName)
	{
		hrFirstname.sendKeys(firstName);
	}
	
	public void hrLastname(String lastName)
	{
		hrLastname.sendKeys(lastName);
	}
	
	public void hrMiddlename(String middleName)
	{
		hrMiddlename.sendKeys(middleName);
	}
	
	public void hrContactno(String contactNo)
	{
		hrContactno.sendKeys(contactNo);
	}
	
	public void hrType(String position)
	{
		selectByValue(hrType, position);
	}
	
	public void hrEmail(String email)
	{
		hrEmail.sendKeys(email);
	}
	
	public void hrPassword(String password)
	{
		hrPassword.sendKeys(password);
	}
	
	public void saveBtn()
	{
		saveBtn.click();
	}

	
	public void fillEmpForm(WebDriver driver, HashMap<String, String> map)
	{
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
}
}