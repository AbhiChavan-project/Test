package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.Screenshot;


	public class ZerodhaLoginPageTest {
		WebDriver driver;
	
		@BeforeMethod
		public void LaunchBrowser() {
			driver = Browser.OpenBrowser("https://kite.zerodha.com/");
//			System.out.println("Zerodha Before Method");//just for checking whether it shows result or not
		}
	
		@Test
		public void LoginWithValidCredentials() throws InterruptedException, EncryptedDocumentException, IOException {
	
			LoginPage login = new LoginPage(driver);//softcoded
			
			
			String userName = Excel.getData(0, 1, "Credentials");//calling by 'className.MethodName'....static method
			String password = Excel.getData(1, 1, "Credentials");
			String pincode = Excel.getData(2, 1, "Credentials");
			
			login.enterUserName(userName);
			login.enterPassword(password);
			login.clickOnSubmit();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			login.enterPin(pincode);
			login.clickOnContinue();
			
			//use assertion bcz take a screenshot after displaying dashboard page	
			SoftAssert softAssert = new SoftAssert();//object of soft assert
			boolean status = login.avatarIsDisplayed(driver);
			softAssert.assertTrue(status);
			
			softAssert.assertAll();//will display the failure
	
			
//			LoginPage login = new LoginPage(driver);//hardcoded
//			login.enterUserName("OKP335");
//			login.enterPassword("QAZ123456");
//			login.clickOnSubmit();
//			Thread.sleep(2000);
//			login.enterPin("456789");
//			login.clickOnContinue();
		}
	
		@Test
		public void clickOnForgotPassword() {
			LoginPage login = new LoginPage(driver);
			login.clickOnForgotButton();
		}
	
		@Test
		public void clickOnSignUpNewUser() {
			LoginPage login = new LoginPage(driver);
			login.clickOnSignUp();
			
			ArrayList<String> list = new ArrayList(driver.getWindowHandles());
			for(int i=1;i<list.size();i++)
			{
				driver.switchTo().window(list.get(i));
			}
			login.enterMobNumber("8806012893");
		}
		
	
		@AfterMethod
		public void closeBrowser() throws IOException {
			Screenshot.Getscreenshot(driver, "Zerodha");//static method
			driver.close();
		}

}
