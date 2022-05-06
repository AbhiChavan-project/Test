package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(xpath = "//input[@type='text']") private WebElement userName;
	//findElement
	@FindBy(xpath = "//input[@type='password']") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submit;
	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueButton;
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy(xpath = "//a[@class='text-light']") private WebElement signUp;
	@FindBy(xpath = "//input[@id='user_mobile']") private WebElement mobileNumber;
	@FindBy(xpath = "//h2[text()='Login to Kite']") private WebElement loginText;
	@FindBy(xpath = "//div[@id='avatar-83']") private WebElement avatar;
	
	public LoginPage(WebDriver driver) {//constructor
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
	public void enterPin(String value) {
		pin.sendKeys(value);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void clickOnForgotButton() {
		forgot.click();
	}
	
	public void clickOnSignUp() {
		signUp.click();
	}
	
	public void enterMobNumber(String number) {
		mobileNumber.sendKeys(number);
	}
	
	public String getLoginText() {
		return loginText.getText();//we can direct return String
	}
	
	public boolean avatarIsDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));//Explicit wait
		wait.until(ExpectedConditions.visibilityOf(avatar));
		return avatar.isDisplayed();
	}
	
}
