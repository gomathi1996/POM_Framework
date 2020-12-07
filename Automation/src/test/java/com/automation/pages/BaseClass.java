package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigReader;
import com.automation.utility.ExcelReader;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelReader excel;
	public ExtentReports report;
	public ConfigReader config;
	public ExtentTest logger;
	String reportPath;

	@BeforeSuite
	public void setupsuite() {

		Reporter.log("Setting up reports and Test is getting ready", true);

		excel = new ExcelReader();
		config = new ConfigReader();
		reportPath = System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html";

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(reportPath));
		report = new ExtentReports();
		report.attachReporter(extent);

		Reporter.log("Setting Done- Test can be started", true);

	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApp(driver, config.getBrowser(), config.getAppUrl());
		//adding commit

	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end ", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.TakeScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test passed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.TakeScreenshot(driver)).build());

		}

		report.flush();

		Reporter.log("Test Completed >>> Reports Generated", true);

		Reporter.log("Report can be accessed via >>> " + reportPath, true);

	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
