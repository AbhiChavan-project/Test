package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {
	public static void Getscreenshot(WebDriver driver, String name) throws IOException {
		String d = Screenshot.Date();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\Automation\\ZerodhaAutomation\\Screenshot\\"+name+""+d+".jpg");
		
		FileHandler.copy(source, destination);
	}
	
	public static String Date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");//format of time & date as required
		LocalDateTime now = LocalDateTime.now();//return current date
		String d= dtf.format(now);
//		System.out.println(d);
		return d;
	}

}
