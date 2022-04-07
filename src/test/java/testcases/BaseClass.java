package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	public static WebDriver driver; 


 
   //object of extend report
public static ExtentReports report;
public static ExtentTest test;
   
   @BeforeTest
public void DatasetUP()   {
   
  report = new ExtentReports("ExtentReport.html");
   
    }
@AfterTest
public void DataTearDown()   {
	

	report.flush();
	report.close();
}

@BeforeMethod
public void SetUp(Method method) {
	
	test = report.startTest(method.getName());
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	
	
driver =new ChromeDriver(); //imp
	
	//WebDriver driver =new FirefoxDriver();
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);

	}
@AfterMethod
public void TearDown() {
	
	report.endTest(test);
	driver.quit();
	
}


}
