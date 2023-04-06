package com.pomRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.FileUtility;

public class LoginPage extends FileUtility {

	WebDriver driver;
	
	// Initialization
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// private By hr_EmailTextField = By.name("hr_email");
	@FindBy(name = "hr_email")
	private WebElement hr_EmailTextField;

	// private By hr_PasswordTextField = By.name("hr_password");
	@FindBy(name = "hr_password")
	private WebElement hr_PasswordTextField;

	// private By selectTypeDropDown = By.id("hr_type");
	// go with value
	// "HR Head"
	// "HR Officer"
	// "HR Officer"
	@FindBy(id = "hr_type")
	private WebElement selectTypeDropDown;

	// private By rememberMeCheckBox = By.id("remember");
	@FindBy(id = "remember")
	private WebElement rememberMeCheckBox;

	public void markCheckbox() {
		if (rememberMeCheckBox.isSelected()) {

		} else
			rememberMeCheckBox.click();
	}

	// private By rememberMeText = By.className("icheck-primary");
	@FindBy(className = "icheck-primary")
	private WebElement rememberMeText;

	public String checkboxName() {
		return rememberMeText.getText();
	}

	// private By signInSubmit = By.name("login_hr");
	@FindBy(name = "login_hr")
	private WebElement signInSubmit;

	// afetr submitting the details you will get one js popup

	public void hrEmailText(String hrEmail) {
		hr_EmailTextField.sendKeys(hrEmail);
	}

	public void hrPasswordText(String hrPassword) {
		hr_PasswordTextField.sendKeys(hrPassword);
	}

	public void selectType(String position) {
		Select select = new Select(selectTypeDropDown);
		select.selectByValue(position);
	}

	public void signInToDashboardpage() throws Throwable {
		signInSubmit.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// return the dashboard page object here
	}

	public void signInToAppASHrHead(String headusername, String headpassword) throws Throwable {
		hrEmailText(headusername);
		hrPasswordText(headpassword);
//		hrEmailText(readDataFromPropertyFile("headusername"));
//		hrPasswordText(readDataFromPropertyFile("headpassword"));
		selectType(readDataFromPropertyFile("hrhead"));
		signInToDashboardpage();
	}

	public void signInToAppASHrOfficer(String officerusename, String officerpassword) throws Throwable {
		hrEmailText(officerpassword);
		hrPasswordText(officerpassword);
//		hrEmailText(readDataFromPropertyFile("officerusename"));
//		hrPasswordText(readDataFromPropertyFile("officerpassword"));
		selectType(readDataFromPropertyFile("hrofficer"));
		signInToDashboardpage();
	}

	public void signInToAppASHrAssistant(String assistantusename, String assistantpassword) throws Throwable {
		hrEmailText(assistantusename);
		hrPasswordText(assistantpassword);
		selectType(readDataFromPropertyFile("hrassistant"));
		signInToDashboardpage();
	}

	public boolean validateLoginPage(String expectedLoginTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedLoginTitle)) {
			return true;
		} else
			return false;

	}

}
