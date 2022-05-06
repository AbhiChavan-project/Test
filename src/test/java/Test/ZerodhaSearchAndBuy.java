package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.SearchAndBuy;
import Pojo.Browser;
import Utilities.Excel;

public class ZerodhaSearchAndBuy {
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowserAndLogin() throws EncryptedDocumentException, IOException {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
		LoginPage loginpage = new LoginPage(driver);//we import methods from LoginPage POM class
		
		String userName = Excel.getData(0, 1, "Credentials");
		loginpage.enterUserName(userName);
		String password = Excel.getData(1, 1, "Credentials");
		loginpage.enterPassword(password);
		loginpage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String pincode = Excel.getData(2, 1, "Credentials");
		loginpage.enterPin(pincode);
		loginpage.clickOnContinue();
	}
	
	@Test
	public void BuyTheShare() throws EncryptedDocumentException, InterruptedException, IOException {
		SearchAndBuy obj = new SearchAndBuy(driver);
//		Assert.assertTrue(obj.dashboardIsDisplayed(driver));
		String shareName = Excel.getData(3, 1, "Credentials");
		String quantity = Excel.getData(4, 1, "Credentials");

		obj.clickOnSearch(shareName);
		obj.selectFirstStock(driver);
		obj.clickOnBuy();	
		obj.enterQtyInBox(quantity);
		obj.clickOnBuyButton();
	}
	
	@Test
	public void SellTheShare() throws EncryptedDocumentException, IOException {
		SearchAndBuy obj = new SearchAndBuy(driver);
		
		String shareName = Excel.getData(3, 1, "Credentials");
		String quantity = Excel.getData(4, 1, "Credentials");

		obj.clickOnSearch(shareName);
		obj.selectFirstStock(driver);
		obj.clickOnSell();
		obj.enterQtyInBox(quantity);
		obj.clickOnSellButton();
	}
	
	@Test
	public void buyTheShareForIntraday() throws EncryptedDocumentException, IOException {
		SearchAndBuy obj = new SearchAndBuy(driver);

		String shareName = Excel.getData(3, 1, "Credentials");
		String quantity = Excel.getData(4, 1, "Credentials");
		String TriggerPrice = Excel.getData(5, 1, "Credentials");

		obj.clickOnSearch(shareName);
		obj.selectFirstStock(driver);
		obj.clickOnBuy();
		obj.clickOnIntraday(driver);
		obj.enterQtyInBox(quantity);
		obj.clickOnStopLoss();
		obj.clickOnTriggerPrice(driver, TriggerPrice);
//		obj.clickOnTriggerPrice(driver, "200");
		obj.clickOnBuyButton();
		
	}
	
}
