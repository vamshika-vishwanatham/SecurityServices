package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UtilityCode;

public class WAFPage extends UtilityCode {

	public WAFPage() {
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
	
	@FindBy(id = "s2id_customfield_11370")
	WebElement category;
	@FindBy(id = "insight-atlas-select-27303") // xpath="//input[@aria-labelledby = 'customfield_27303-label']")
	WebElement applicationName;
	@FindBy(id = "customfield_27400")
	WebElement applicationURL;
	@FindBy(xpath = "//input[@id='customfield_27306']")
	WebElement applicationExternal;
	@FindBy(id = "s2id_customfield_29400")
	WebElement stakeholdersInvolved;
	@FindBy(id="description-textarea-control")
	WebElement descriptiontextarea;
	@FindBy(xpath = "//*[@role='textbox']/p")
	WebElement description;
	@FindBy(id = "react-select-5-input")
	WebElement dropdownInput;
	@FindBy(id="s2id_autogen19")
	WebElement Input;

	public void addFields(String Category, String ApplicationName, String ApplicationURL, String ApplicationExternalIP,
			String Stakeholdersinvolved, String Description) throws InterruptedException {
		Thread.sleep(2000);
		fillDropdownField(category, Category);
		Thread.sleep(3000);
		applicationName.click();
		Thread.sleep(1000);
		dropdownInput.sendKeys(ApplicationName);
		Thread.sleep(2000); // Wait for dropdown to appear
		dropdownInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		fillTextField(applicationURL, ApplicationURL);
		Thread.sleep(2000);
		fillTextField(applicationExternal, ApplicationExternalIP);
		Thread.sleep(2000);
		stakeholdersInvolved.click();
		Thread.sleep(2000);
		Input.sendKeys(Stakeholdersinvolved);
		Thread.sleep(2000); 
		Input.sendKeys(Keys.ENTER);
		//stakeholdersInvolved.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		descriptiontextarea.click();
		description.click();
		description.sendKeys(Description);
		//fillTextField(description, Description);

	}
	 
	public void Approval() throws InterruptedException {
		String name = driver.findElement(By.xpath("//li[@class='sd-approval-status-panel']/dl/dd/ul/li")).getText();
		switchUser();
		userProfileSwitch(name);
	}
}
