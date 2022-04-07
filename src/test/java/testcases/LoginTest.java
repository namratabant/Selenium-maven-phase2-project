package testcases;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass{
	
@Test
	public void LoginFailiureTest()  {
	
	LoginPage login = new LoginPage();
	login.LoginFunction("standard_user", "secret_s");
	
	
	WebElement ErrorMsg = driver.findElement(By.xpath("//*[@class='error-message-container error']/h3"));
	
	String ActualMsg = ErrorMsg.getText();
	String ExpMsg = "Epic sadface: Username and password do not match any user in this service";
	
	Assert.assertEquals(ActualMsg, ExpMsg);
	//report.endTest(test);
}
//see here
@Test
public void LoginSuccessTest() {
	
	
	
	LoginPage login = new LoginPage();
	login.LoginFunction("standard_user", "secret_sauce");		
}



}










