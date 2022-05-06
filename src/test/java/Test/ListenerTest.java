package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.Screenshot;

public class ListenerTest extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult Result) {//this will run at the start of every test
		System.out.println(Result.getName()+":Test has started");
	}
	
	public void onTestSuccess(ITestResult Result) {//this will execute when test pass
		System.out.println(Result.getName()+":Test passed");
	}
	
	public void onTestFailure(ITestResult Result) {//this will execute when test fails
		try {
			Screenshot.Getscreenshot(driver, Result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Result.getName()+":Test failed");
	}
	
	public void onTestSkipped(ITestResult Result) {//this will execute when test skipped
		System.out.println(Result.getName()+":Test Skipped");
	}

}
