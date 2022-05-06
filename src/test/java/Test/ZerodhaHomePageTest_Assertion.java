package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.HomePage_Assertion;
import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;

public class ZerodhaHomePageTest_Assertion {
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	}
	
	@Test  //to check "Hard Assert"
	public void verifyLoginText1() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage_Assertion homePage = new HomePage_Assertion(driver);
		String actualText = homePage.getLoginText();
		String expectedText = "Login Kite";//actual text is "Login to Kite" so it not matches to our expected thats why it stop further execution
		Assert.assertEquals(actualText, expectedText);//Hard assert will immediately stop execution
		
		String userName = Excel.getData(0, 1, "Credentials");
		String password = Excel.getData(1, 1, "Credentials");
		String pincode = Excel.getData(2, 1, "Credentials");
		
		homePage.enterUserName(userName);
		homePage.enterPassword(password);
		homePage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		homePage.enterPin(pincode);
		homePage.clickOnContinue();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	@Test  //to check "Soft Assert"
	public void verifyLoginText2() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage_Assertion homePage = new HomePage_Assertion(driver);
		String actualText = homePage.getLoginText();
		String expectedText = "Login Kite";//actual text is "Login to Kite" so it not matches to our expected thats why it stop further execution
		
		SoftAssert softAssert = new SoftAssert();//object of soft assert
		softAssert.assertEquals(actualText, expectedText);//Soft assert will not stop execution
		
		String userName = Excel.getData(0, 1, "Credentials");
		String password = Excel.getData(1, 1, "Credentials");
		String pincode = Excel.getData(2, 1, "Credentials");
		
		homePage.enterUserName(userName);
		homePage.enterPassword(password);
		homePage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		homePage.enterPin(pincode);
		homePage.clickOnContinue();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		
		boolean status = homePage.avatarIsDisplayed(driver);
		softAssert.assertTrue(status);
		
		softAssert.assertAll();//will display the failure
	}
	

}
