package com.Essan_Rad.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String mName=result.getMethod().getMethodName();
		test=report.createTest(mName);
		Reporter.log(mName+"----- Execution starts");
	}

	public void onTestSuccess(ITestResult result) {
		String mName= result.getMethod().getMethodName();
		test.log(Status.PASS, mName+"----- passed");
		Reporter.log(mName+"----- Passed");
	}

	public void onTestFailure(ITestResult result) {
		String mName= result.getMethod().getMethodName();
		String failure= WebdriverUtility.takeScreenShot(BaseClass.iDriver, mName);
		test.addScreenCaptureFromPath(failure);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, mName+"-----Failed");
		Reporter.log(mName+"-----Failed");
	}

	public void onTestSkipped(ITestResult result) {
		String mName= result.getName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, mName+"----- Skipped");
		Reporter.log(mName+"----- Skipped");
	}
	

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extent Report/ TestReport.html");
		htmlReport.config().setDocumentTitle("SDET-51");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("ESSAN-RAD");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Laptop", "HP-2014");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Processor", "12th Gen Intel(R) Core(TM) i5-1235U   1.30 GHz");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Browser version", "Version 116.0.5845.188 (Official Build) (64-bit)");
		report.setSystemInfo("Reporter", "Sivabalan Selvaraj");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
