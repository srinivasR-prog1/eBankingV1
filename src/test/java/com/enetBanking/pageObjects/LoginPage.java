package com.enetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "uid")
	WebElement txtUserId;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnLogout;

	public void setUsername(String uname) {

		txtUserId.clear();
		txtUserId.sendKeys(uname);

	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);

	}

	public void btnLogin() {

		btnSubmit.click();

	}
	
	public void btnLogout()
	{
		
		btnLogout.click();
		
		
	}

}
