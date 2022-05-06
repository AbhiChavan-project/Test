package Test;//we use ExtentReports in this class

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.Reports;
import Utilities.Screenshot;

@Listeners(ListenerTest.class)
public class ZerodhaLoginTest_Listener extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void configureExtentReport() {
		reports = Reports.addReport();
	}
	
	@BeforeMethod
	public void LaunchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	}

	@Test
	public void LoginWithValidCredentials() throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("LoginWithValidCredentials");

		LoginPage login = new LoginPage(driver);
		
		String userName = Excel.getData(0, 1, "Credentials");
		String password = Excel.getData(1, 1, "Credentials");
		String pincode = Excel.getData(2, 1, "Credentials");
		
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		login.enterPin(pincode);
		login.clickOnContinue();
	}

	@Test(dependsOnMethods = {"clickOnSignUpNewUser"})
	public void clickOnForgotPassword() {
		test = reports.createTest("clickOnForgotPassword");
		LoginPage login = new LoginPage(driver);
		login.clickOnForgotButton();
	}

	@Test
	public void clickOnSignUpNewUser() {
		test = reports.createTest("clickOnSighUpNewUser");
		LoginPage login = new LoginPage(driver);
		login.clickOnSignUp();
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void addTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else {
			if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, result.getName());
			}
			else {
				test.log(Status.SKIP, result.getName());
			}
		}
	}
	
	@AfterClass
	public void flushResults() {
		reports.flush();
	}

}
