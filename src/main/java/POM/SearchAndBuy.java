package POM;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndBuy {
	
//	@FindBy(xpath = "//input[@type='text']") private WebElement userName;
//	@FindBy(xpath = "//input[@type='password']") private WebElement password;
//	@FindBy(xpath = "//button[@type='submit']") private WebElement submit;
//	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
//	@FindBy(xpath = "//button[@type='submit']") private WebElement continueButton;
	
//	@FindBy(xpath = "//div[@id='avatar-83']") private WebElement avatar;
	@FindBy(xpath = "//span[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath = "//input[@icon='search']") private WebElement search;//we can use this WebElement for both- buy & sell
	@FindBy(xpath = "//ul[@class='omnisearch-results']//div//li[1]") private WebElement firstStock;//we can use this WebElement for both- buy & sell
	@FindBy(xpath = "//span[text()='TATACOFFEE']") private WebElement company;//we can use this WebElement for both- buy & sell
	@FindBy(xpath = "//button[@data-balloon='Buy']") private WebElement buyB;
	@FindBy(xpath = "//input[@step='1']") private WebElement quantity;//we can use this WebElement for both- buy & sell
	@FindBy(xpath = "(//span[text()='Buy'])[2]") private WebElement buyButton;
	@FindBy(xpath = "//button[@data-balloon='Sell']") private WebElement sell;
	@FindBy(xpath = "(//span[text()='Sell'])[2]") private WebElement sellButton;
	@FindBy(xpath = "//label[text()='Market']") private WebElement market;
	@FindBy(xpath = "//label[text()='Limit']") private WebElement limit;
	@FindBy(xpath = "//label[text()='Intraday ']") private WebElement intraday;
	@FindBy(xpath = "//label[text()='Longterm ']") private WebElement longterm;
	@FindBy(xpath = "//input[@label='Price']") private WebElement price;
	@FindBy(xpath = "//label[text()='SL']") private WebElement stopLoss;
	@FindBy(xpath = "//label[text()='SL-M']") private WebElement marketStopLoss;
	@FindBy(xpath = "//input[@label='Trigger price']") private WebElement triggerPrice;
	
	 
	public SearchAndBuy(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	public void enterUserName(String name) {
//		userName.sendKeys(name);
//	}
//	
//	public void enterPassword(String pass) {
//		password.sendKeys(pass);
//	}
//	
//	public void clickOnSubmit() {
//		submit.click();
//	}
//	
//	public void enterPin(String value) {
//		pin.sendKeys(value);
//	}
//	
//	public void clickOnContinue() {
//		continueButton.click();
//	}
	
//	public boolean avatarIsDisplayed(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
//		return avatar.isDisplayed();
//	}
	
	public boolean dashboardIsDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		return dashboard.isDisplayed();
	}
	
	
	public void clickOnSearch(String shareName) {//we can use this method for both- buy & sell
		search.sendKeys(shareName);
	}
		
	public void selectFirstStock(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(firstStock));
		Actions act = new Actions(driver);
		act.moveToElement(firstStock);
		act.click();
		act.build().perform();
	}
	
	public void clickOnBuy() {			
		buyB.click();
	}
	
	public void enterQtyInBox(String value) {//we can use this method for both- buy & sell
		quantity.sendKeys(value);
	}
	
	public void clickOnBuyButton() {
		buyButton.click();
	}
	
	public void clickOnSell() {
		sell.click();
	}
	
	public void clickOnMarket(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(market);
		act.click();
		act.build().perform();
	}
	
	public void clickOnLimit(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(limit);
		act.click();
		act.build().perform();
	}
	
	public void clickOnSellButton() {
		sellButton.click();
	}
	
	public void clickOnIntraday(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(intraday));
		Actions act = new Actions(driver);
		act.moveToElement(intraday);
		act.click();
		act.build().perform();
//		intraday.click();
	}
	
	public void clickOnLongterm() {
		longterm.click();
	}
	
	public void clickOnPrice() {
		price.click();
	}
	
	public void clickOnStopLoss() {
		stopLoss.click();
	}
	
	public void clickOnMarketStopLoss() {
		marketStopLoss.click();
	}
	
	public void clickOnTriggerPrice(WebDriver driver, String TriggerPrice) {
		triggerPrice.click();
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		triggerPrice.sendKeys(TriggerPrice);
	}
	
}
