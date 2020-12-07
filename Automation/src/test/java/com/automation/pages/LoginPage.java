package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver Idriver){
		
		this.driver = Idriver;
		
	}
	
	@FindBy(name ="email") WebElement uname;
	@FindBy(name ="password") WebElement pwd;
	@FindBy(xpath ="//form/div/div[3]") WebElement login_btn;
	
	public void loginToApp(String User_name , String Pass_wd){
		
		uname.sendKeys(User_name);
		pwd.sendKeys(Pass_wd);
		login_btn.click();
	}

}
