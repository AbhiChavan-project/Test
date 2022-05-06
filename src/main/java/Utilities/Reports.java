package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports addReport() {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("extentReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Env", "UAT");
		reports.setSystemInfo("Testing", "Regression");
		return reports;
	}

}
