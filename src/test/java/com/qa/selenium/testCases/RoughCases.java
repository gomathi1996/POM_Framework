package com.qa.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoughCases {
	public WebDriver driver;

	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Monika//Desktop//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//ExtentReports reports = new ExtentReports();

	}

	@Test
	public void test1() {

		driver.get("https://en-gb.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys("gomathiece1996@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Facebook@123");
		driver.findElement(By.id("loginbutton1")).click();
		System.out.println(driver.getTitle());
		String expectedtext = "Gomathi";
		String actualtext = driver
				.findElement(By
						.xpath("//div[@role='navigation'][@aria-label='Account controls and settings']//div[4]//a//span//span"))
				.getText();
		System.out.println("The actual text is :" + actualtext);
		Assert.assertEquals(actualtext, expectedtext);
		System.out.println("User logged in successfully!!!!!!!!!!");
		try {
			new Actions(driver).doubleClick().build().perform();
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println(e.getMessage());
		}

		driver.findElement(By
				.xpath("//div[@role='navigation'][@aria-label='Account controls and settings']//div//div[@aria-label='Account']/i"))
				.click();

		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();

		System.out.println(driver.getCurrentUrl());
	}

	@AfterMethod
	public void closingsession() {
		driver.close();
		driver.quit();

	}
	/*
	 * @Test public void test2() {
	 * 
	 * driver.get("https://www.browserstack.com/");
	 * 
	 * driver.findElement(By.xpath(
	 * "//div[@class='product-cards-wrapper--click']//a[@title='Automate']")).
	 * click(); System.out.println("The page url is :" +
	 * driver.getCurrentUrl()); String actualtext =
	 * driver.findElement(By.xpath("//a[@id='sec-header-title']//span")).getText
	 * (); Assert.assertEquals(actualtext, "Automate");
	 * System.out.println("Test Successfull!!!!!!!!!"); driver.close();
	 * driver.quit();
	 * 
	 * }
	 */

}
