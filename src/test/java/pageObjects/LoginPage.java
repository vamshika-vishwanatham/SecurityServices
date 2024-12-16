package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UtilityCode;

public class LoginPage extends UtilityCode {
	  public LoginPage() {
		  super(); 
		  PageFactory.initElements(driver, this);
		  }

	@FindBy(xpath="//input[@name ='identifier']")
	WebElement emailId;
	@FindBy(xpath="//input[@name='credentials.passcode']")
	WebElement passcode;
	Properties p;
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement signIn;
	@FindBy(xpath="//input[@value='Receive a code via SMS']")
	WebElement codeViaSMS;
	@FindBy(name="credentials.passcode")
	WebElement enterCode;
	@FindBy(xpath="//input[@value='Verify']")
	WebElement verify; 
	@FindBy(xpath="//div[@role='alert']/p")
	WebElement errorMessage;
	@FindBy(linkText = "ServiceDesk Portal")
	WebElement serviceDeskPortal;
	@FindBy(xpath = "//img[@alt='Security Services']")
	WebElement securityCatalog;
	String frame = "rw_iframe";	

	@FindBy(id="s2id_customfield_11372")
	WebElement requestType;
	@FindBy(id="s2id_customfield_11370")
	WebElement category;

	public void hitURL() throws InterruptedException {
		driver.get("https://jiraet-qa.cotiviti.com");
		Thread.sleep(3000);
	}

	public void setEmail(String email) {
		emailId.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passcode.sendKeys(password);
	}
	public void signIn() throws InterruptedException {
		signIn.click();
		Thread.sleep(5000);
		codeViaSMS.click();
		enterCode.click();
		Thread.sleep(15000);
		verify.click();
	}
	public void serviceDeskPortal() throws InterruptedException {
		serviceDeskPortal.click();
		windowHandle();
		securityCatalog.click();
		Thread.sleep(3000);
		driver.switchTo().frame(frame);
		Thread.sleep(5000);
	}
		
}
