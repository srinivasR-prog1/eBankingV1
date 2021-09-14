package com.enetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.enetBanking.pageObjects.AddCustomerPage;
import com.enetBanking.pageObjects.LoginPage;
import com.enetBanking.utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws InterruptedException {

		JavascriptExecutor js= (JavascriptExecutor)driver;
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered UserName");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.btnLogin();
		Thread.sleep(3000);		
		

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login TestCase Failed");

		}
		
		else {
			Assert.assertTrue(true);
			logger.info("Login TestCase Passed");
			
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
				Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			}

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

	@DataProvider(name = "LoginData")
	public String[][] getdata() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/enetBanking/testData/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "loginData");
		int colCount = XLUtils.getCellCount(path, "loginData", 1);
		String logindata[][] = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "loginData", i, j);

			}

		}

		return logindata;

	}

}
