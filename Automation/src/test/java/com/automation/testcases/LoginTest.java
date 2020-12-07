package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.Helper;

public class LoginTest extends BaseClass {

	@Test
	public void LoginApp() {
		logger = report.createTest("Login to CRM...");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application....");
		loginPage.loginToApp(excel.getdata("login", 0, 0), excel.getdata("login", 0, 1));
		logger.pass("Successfully excecuted........");
		Helper.TakeScreenshot(driver);
		logger.info("Captured Screenshot.......");
	}

}
