package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// Test Script excecution Strats here

		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName + "---> TestScript excecution started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName + "-->Passed");
		Reporter.log(MethodName + "---> TEstScript Excecution Successfull");
	}

	public void onTestFailure(ITestResult result) {
		String FScript = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShot/" + FScript + ".png");
		// File path = dst.getAbsoluteFile();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(dst.getAbsolutePath(), "GetMethodName" + FScript);
		Reporter.log("TestScripts Exc Failed");

//		EventFiringWebDriver edriver=new EventFiringWebDriver(Baseclass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./errorScreenShots/"+result.getMethod().getMethodName()+LocalDateTime.now().toString().replace(':', '-')+".png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		test.log(Status.FAIL, result.getTestName());
//		test.addScreenCaptureFromPath(dst.getAbsolutePath(), "GetMethodName"+FScript);
//        Reporter.log("TestScript Exc Failed");
	}

	public void onTestSkipped(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + "---->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("TestScript Excecution Skipped");
	}

	public void onStart(ITestContext context) {

		// create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("TestYantra");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("HRM");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/HRM_System/");
		report.setSystemInfo("ReporterName", "Ashwini");
	}

	public void onFinish(ITestContext context) {

		// Consolidate the report
		report.flush();
	}

}
