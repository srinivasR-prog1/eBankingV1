package com.enetBanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement clkNewCustomer;

	@FindBy(name = "name")
	WebElement txtcustName;

	@FindBy(name = "rad1")
	WebElement custGender;

	@FindBy(name = "dob")
	WebElement txtCustDOB;

	@FindBy(name = "addr")
	WebElement custAddr;

	@FindBy(name = "city")
	WebElement custCity;

	@FindBy(name = "state")
	WebElement custState;

	@FindBy(name = "pinno")
	WebElement custPin;
	@FindBy(name = "telephoneno")
	WebElement custMobno;
	@FindBy(name = "emailid")
	WebElement custEmailid;
	@FindBy(name = "password")
	WebElement custPwd;
	@FindBy(name = "sub")
	WebElement custSubmit;
	
/*	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnCustLogout;*/
	
/*   @FindBy(xpath="//a[text()='Home']")
     WebElement btnCustomerLogout;*/
	
	public void addNewCust() {
		clkNewCustomer.click();

	}
	
	

	public void setCustName(String cName) {

		txtcustName.clear();
		txtcustName.sendKeys(cName);

	}

	public void setGender() {
		custGender.click();

	}

	public void setCustDOB(String dd, String mm, String yyyy) {
		txtCustDOB.clear();
		txtCustDOB.sendKeys(dd);
		txtCustDOB.sendKeys(mm);
		txtCustDOB.sendKeys(yyyy);
	}
	
	public void setCustAddr(String cAddr) {
		custAddr.clear();
		custAddr.sendKeys(cAddr);

	}
	public void setCustCity(String cCity) {
		custCity.clear();
		custCity.sendKeys(cCity);

	}
	public void setCustState(String cState) {
		custState.clear();
		custState.sendKeys(cState);

	}
	public void setCustPin(String cPin) {
		custPin.clear();
		custPin.sendKeys(cPin);

	}
	public void setCustMobno(String cMobno) {
		custMobno.clear();
		custMobno.sendKeys(cMobno);

	}
	public void setCustEmail(String cEmailid) {
		custEmailid.clear();
		custEmailid.sendKeys(cEmailid);

	}
	public void setCustPwd(String cPwd) {
		custPwd.clear();
		custPwd.sendKeys(cPwd);

	}
	
	public void clkSubmit() {
		custSubmit.click();
	}
	
	/*public void btnCustomerLogout()
	{
		
		btnCustLogout.click();
		
		
	}*/

}
