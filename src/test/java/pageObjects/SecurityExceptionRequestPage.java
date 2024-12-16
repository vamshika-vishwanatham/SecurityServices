package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UtilityCode;

public class SecurityExceptionRequestPage extends UtilityCode {

	@FindBy(id = "s2id_customfield_11370")
	WebElement category;
	@FindBy(id ="s2id_customfield_13026")
	WebElement typeofexceptionperiod;
	@FindBy(id = "react-select-5-input")
	WebElement dropdownInput;
	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	WebElement Input;
	@FindBy(id="customfield_13025")
	WebElement temporaryExceptionDate;
	@FindBy(id="s2id_customfield_13024")
	WebElement accesstoclientdataPHIorPII;
	@FindBy(id="customfield_11543")
	WebElement justification;
	
	public void addFields(String Category, String Typeofexceptionperiod, String AccesstoclientdataPHIorPII, String Justification,
			String TemporaryExceptionDate) throws InterruptedException {
		Thread.sleep(2000);
		fillDropdownField(category, Category);
		Thread.sleep(3000);
		fillDropdownField(typeofexceptionperiod, Typeofexceptionperiod);
		Thread.sleep(2000);
		if(Typeofexceptionperiod == "Temporary") {
		fillTextField(temporaryExceptionDate, TemporaryExceptionDate);
		Thread.sleep(2000);
		}
		fillTextField(justification, Justification);
		Thread.sleep(2000);
		fillDropdownField(accesstoclientdataPHIorPII, AccesstoclientdataPHIorPII);
	}
	
	public void Approval() throws InterruptedException {
		String name = driver.findElement(By.xpath("//li[@class='sd-approval-status-panel']/dl/dd/ul/li")).getText();
		switchUser();
		userProfileSwitch(name);
		multiThread();
	}
	
	public void UserApproval() throws InterruptedException {
		String name = driver.findElement(By.xpath("//li[@class='sd-approval-status-panel']/dl/dd/ul/li[6]")).getText();
		switchUser();
		userProfileSwitch(name);
	}
	
}
