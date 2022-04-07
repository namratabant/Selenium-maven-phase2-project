package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	WebDriver driver = BaseClass.driver;

ExtentTest test = BaseClass.test;

//================WebElements================

@FindBy(name = "user-name")
WebElement UserName;

@FindBy(id = "password")
WebElement Password;

@FindBy(name = "login-button")
WebElement LoginButton;

public LoginPage() {
	
	PageFactory.initElements(driver, this);
}

//=====================Functions===========================

public void LoginFunction(String UserNameVal, String PasswordVal) {
	
	UserName.sendKeys(UserNameVal);
	test.log(LogStatus.PASS, "Enter UserName", "UserName entered successfully");
	
	Password.sendKeys(PasswordVal);
	test.log(LogStatus.PASS, "Enter Password", "Password successfully");
	
	LoginButton.click();
	test.log(LogStatus.PASS, "Click on LoginButton", "LoginButton clicked successfully");
}

public void UICheck() {
Assert.assertTrue(UserName.isDisplayed());
}


}
