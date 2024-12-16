package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UtilityCode;

public class CommonStepsPage extends UtilityCode{

	public CommonStepsPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	String frame = "rw_iframe";
	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement enterInput;
	@FindBy(xpath = "//input[@name ='identifier']")
	WebElement emailId;
	@FindBy(xpath = "//input[@name='credentials.passcode']")
	WebElement passcode;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement signIn;
	@FindBy(xpath = "//input[@value='Receive a code via SMS']")
	WebElement codeViaSMS;
	@FindBy(name = "credentials.passcode")
	WebElement enterCode;
	@FindBy(xpath = "//input[@value='Verify']")
	WebElement verify;
	@FindBy(linkText = "ServiceDesk Portal")
	WebElement serviceDeskPortal;
	@FindBy(xpath = "//img[@alt='Security Services']")
	WebElement securityCatalog;
	@FindBy(id = "s2id_customfield_11372")
	WebElement requestType;
	
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
		Thread.sleep(2000);
	}
	public void requestType(String text) throws InterruptedException {
		fillDropdownField(requestType, text);
	}
	 public void submitForm() throws InterruptedException {
		  driver.switchTo().parentFrame(); 
		  submit.click(); 
		  Thread.sleep(5000); // Wait for form submission 
		  }
	 
	 public void ITView() throws InterruptedException {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[@class='rw_request_key rw_request_key_link']")).click();
			windowHandle();
			Thread.sleep(15000);
			driver.navigate().refresh();
			Thread.sleep(15000);
			driver.navigate().refresh();
			Thread.sleep(15000);
			driver.findElement(By.xpath("//div[@class='aui-sidebar-footer']/button")).click();
			Thread.sleep(3000);
		}
}
