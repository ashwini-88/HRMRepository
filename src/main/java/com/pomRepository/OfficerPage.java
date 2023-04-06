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

public class OfficerPage extends WebDriverUtility{


	WebDriver driver;
	public OfficerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "")
	private WebElement officerEmpModule;
	
	@FindBy(xpath = "")
	private WebElement officerEmpLink;
	
	@FindBy(xpath = "")
	private WebElement officerAddEmpBtn;
	
	@FindBy(xpath = "")
	private WebElement upLoadImg;
	
	@FindBy(xpath = "")
	private WebElement upLoadFile;
	
	@FindBy(xpath = "")
	private WebElement saveForm;
	
	
	
	
	

	public void getAddEmpForm() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOf(officerEmpModule)).click();
		 wait.until(ExpectedConditions.visibilityOf(officerEmpLink)).click();
		 wait.until(ExpectedConditions.visibilityOf(officerAddEmpBtn)).click();
	
	}
		
	
	
	public void fillEmpFormAs(HashMap<String, String> map) {
				for(Entry<String, String> emp:map.entrySet())
			    {
			    	if(emp.getKey().equals("employee_department")) {
			    	    WebElement selectDepatment = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
//			    	    Select selectDep = new Select(selectDepatment);
//			    	    selectDep.selectByValue(emp.getValue());
			    	    selectByVisibleText(selectDepatment,emp.getValue());
			    	    
			    	}else if (emp.getKey().equals("employee_branches")) {
			    	    WebElement selectBranches = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+emp.getKey()+"']"));
//			    	    Select selectBran = new Select(selectBranches);
//			    	    selectBran.selectByValue(emp.getValue());
			    	    selectByVisibleText(selectBranches, emp.getValue());
					}else {
						driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='"+emp.getKey()+"']")).sendKeys(emp.getValue());
					}
			    }
//				upLoadFile.sendKeys(IPathConstant.UPLOADFILEPATH);
//				upLoadImg.sendKeys(IPathConstant.UPLOADIMGPATH);
				//saveForm.click();
				
			}
			
			
			public void uploadFileAndImg()
			{
				upLoadFile.sendKeys(IPathConstant.UPLOADFILEPATH);
				upLoadImg.sendKeys(IPathConstant.UPLOADIMGPATH);
				saveForm.click();
			}
				
//				upLoadImg.sendKeys(uploadImagePath);
//				upLoadFile.sendKeys(upLoadFilePath);
//				
//				saveForm.click();
				
				
			
			
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

