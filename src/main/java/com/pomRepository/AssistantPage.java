package com.pomRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.IPathConstant;
import com.GenericUtilities.WebDriverUtility;

public class AssistantPage extends WebDriverUtility {
	

	WebDriver driver;
	public AssistantPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item has-treeview']//p[contains(.,'EMPLOYEE')]")
	private WebElement assitantEmpModule;
	
	@FindBy(xpath = "//a[@href='Add_employee.php']//p[.='Add Employee']")
	private WebElement assistantEmpLink;
	
	@FindBy(xpath = "//button[normalize-space()='Add Employee']")
	private WebElement assitantAddEmpBtn;
	
	@FindBy(xpath = "//h4[text()='Add Employee']/../..//input[@name='employee_file201']")
	private WebElement upLoadFile;
	
	@FindBy(xpath = "//h4[text()='Add Employee']/../..//input[@name='employee_image']")
	private WebElement upLoadImg;
	
	
	
	
	
	@FindBy(xpath = "//h4[text()='Add Employee']/../..//button[.='Save']")
	private WebElement saveForm;
	
	
	
	
	
	
	public void getAddEmpForm() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOf(assitantEmpModule)).click();
		 wait.until(ExpectedConditions.visibilityOf(assistantEmpLink)).click();
		 wait.until(ExpectedConditions.visibilityOf(assitantAddEmpBtn)).click();
//		assitantEmpModule.click();
//		assistantEmpLink.click();
//		assitantAddEmpBtn.click();
	}
	
	
	
	public void fillEmpFormAs(HashMap<String, String> map) {
		for(Entry<String, String> emp:map.entrySet())
	    {
	    	if(emp.getKey().equals("employee_department")) {
	    	    WebElement selectDepatment = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
//	    	    Select selectDep = new Select(selectDepatment);
//	    	    selectDep.selectByValue(emp.getValue());
	    	    selectByVisibleText(selectDepatment,emp.getValue());
	    	    
	    	}
	    	else if (emp.getKey().equals("employee_branches")) {
	    	    WebElement selectBranches = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
//	    	    Select selectBran = new Select(selectBranches);
//	    	    selectBran.selectByValue(emp.getValue());
	    	    selectByVisibleText(selectBranches, emp.getValue());
			}
	    	else {
				driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='"+emp.getKey()+"']")).sendKeys(emp.getValue());
			}
	    }

		
		
	}
	
	
	public void uploadFileAndImg()
	{
		upLoadFile.sendKeys(IPathConstant.UPLOADFILEPATH);
		upLoadImg.sendKeys(IPathConstant.UPLOADIMGPATH);
		saveForm.click();
	}
		
//		upLoadImg.sendKeys(uploadImagePath);
//		upLoadFile.sendKeys(upLoadFilePath);
//		
//		saveForm.click();
		
		
	
	
	public boolean validateInsertPopUp(String expectedPopUpText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		if(alert.getText().equals(expectedPopUpText))
		{
			alert.accept();
			return true;
		}
		else
		return false;
				
		
	}
	
}
