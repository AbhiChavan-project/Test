package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser(String url) {//this method returns WebDriver which is driver
		ChromeOptions options = new ChromeOptions();//class of selenium
		options.addArguments("--disable-notifications");//will disable the chrome notification
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\ZerodhaAutomation\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait
		return driver;
	}

}
