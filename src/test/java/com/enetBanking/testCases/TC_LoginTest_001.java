package com.enetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.enetBanking.pageObjects.AddCustomerPage;
import com.enetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.btnLogin();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login test passed");

			AddCustomerPage adp = new AddCustomerPage(driver);
			adp.addNewCust();
			adp.setCustName("Chandramukhi");
			adp.setGender();
			adp.setCustDOB("13", "12", "1976");
			adp.setCustAddr("Hanumanagar");
			adp.setCustCity("Hyderabad");
			adp.setCustState("Telengana");
			adp.setCustPin("423456");
			adp.setCustMobno("9912456789");
			String email=randomString()+"@gmail.com";
			adp.setCustEmail(email);
			adp.setCustPwd("HelloMan");
			adp.clkSubmit();
			Thread.sleep(3000);
			WebElement btnCustLogout=driver.findElement(By.xpath("//a[text()='Log out']"));
			js.executeScript("arguments[0].click()", btnCustLogout);
		//	adp.btnCustomerLogout();
			

			if (isAlertPresent() == true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();

			}

		} else {
			captureScreen("loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");

		}

	}

	public boolean isAlertPresent() {

		try {

			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {

			return false;

		}

	}
	
	public String randomString()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
		
	}

}
