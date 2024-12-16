package pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.UtilityCode;

public class AnnualReviewPage extends UtilityCode {
	public AnnualReviewPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name ='identifier']")
	WebElement emailId;
	@FindBy(xpath = "//input[@name='credentials.passcode']")
	WebElement passcode;
	Properties p;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement signIn;
	@FindBy(xpath = "//input[@value='Receive a code via SMS']")
	WebElement codeViaSMS;
	@FindBy(name = "credentials.passcode")
	WebElement enterCode;
	@FindBy(xpath = "//input[@value='Verify']")
	WebElement verify;
	@FindBy(xpath = "//div[@role='alert']/p")
	WebElement errorMessage;
	@FindBy(linkText = "ServiceDesk Portal")
	WebElement serviceDeskPortal;
	@FindBy(xpath = "//img[@alt='Security Services']")
	WebElement securityCatalog;
	String frame = "rw_iframe";
	@FindBy(id = "s2id_customfield_11372")
	WebElement requestType;
	@FindBy(id = "s2id_customfield_11370")
	WebElement category;
	@FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
	List<WebElement> subtaskList;
	@FindBy(id = "summary-val")
	WebElement summary;
	@FindBy(className = "dialog-error")
	WebElement alert;
	@FindBy(id="opsbar-transitions_more")
	WebElement statusDropDown;
	@FindBy(id="customfield_11321")
	WebElement closeNote;
	@FindBy(id="edit-issue")
	WebElement editScreen;
	@FindBy(id="customfield_11333-field")
	WebElement assignmentGroup;
	@FindBy(id="customfield_19701")
	WebElement estimateSize;
	@FindBy(id="edit-issue-submit")
	WebElement submitButton;
	@FindBy(id="assignee-field")
	WebElement assigne;
	@FindBy(xpath="//*[@id='action_id_11']")
	WebElement inProgress;
	@FindBy(id="status-val")
	WebElement statusText;
	@FindBy(xpath="//*[@id='action_id_61']")
	WebElement onHold;
	@FindBy(id="customfield_12711")
	WebElement subState;
	@FindBy(xpath="//*[@title='Rich Text Area']")
	WebElement richTextAreaFrame;
	@FindBy(id="customfield_19700")
	WebElement actualSize;
	@FindBy(xpath="//*[@id='action_id_31']")
	WebElement close;
	@FindBy(id="customfield_11648")
	WebElement closeCode;
	@FindBy(xpath="//*[@id='issue-workflow-transition-submit']")
	WebElement onHoldCloseButton;
	@FindBy(id="tinymce")
	WebElement onHoldCommentBody;
	@FindBy(id="action_id_131")
	WebElement cancel;

	public void requestType(String text) throws InterruptedException {
		fillDropdownField(requestType, text);
	}

	public void selectCategory(String text) throws InterruptedException {
		fillDropdownField(category, text);

	}

	public void submitForm() throws InterruptedException {
		driver.switchTo().parentFrame();
		submit.click();
		Thread.sleep(5000); // Wait for form submission
	}

	public void hitURL() throws InterruptedException {
		driver.get("https://jiraet.cotiviti.com");
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

	public void subtask() throws InterruptedException {
		for (int i = 1; i <= subtaskList.size(); i++) {
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver.findElement(By.xpath("//tr[" + i + "]/td[@class='issuekey']/a")).click();
			Thread.sleep(4000);
			System.out.println("************** Subtask" + " : " + summary.getText() + "**************");
		}
	}
	
	public void updateAssignmentGroup() throws InterruptedException {
		Thread.sleep(3000);
		editScreen.click();
		Thread.sleep(2000);
		assignmentGroup.click();
		Thread.sleep(4000);
		assignmentGroup.sendKeys("TestAssignmentGroupJIRA");
		Thread.sleep(2000);
		assignmentGroup.sendKeys(Keys.ENTER);
		
		Select estimate = new Select(estimateSize);
		estimate.selectByIndex(2);

		submitButton.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("************** Assignment Group Updated **************");
	}
	
	public void updateAssignee() throws InterruptedException {
		Thread.sleep(3000);
		editScreen.click();
		Thread.sleep(2000);
		assigne.click();
		Thread.sleep(2000);
		assigne.sendKeys("vamshika.vishwanatham@cotiviti.com");
		Thread.sleep(4000);
		assigne.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		submitButton.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("************** Assignee Updated **************");
	}
	
	public void inProgressTransition() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		statusDropDown.click();
		inProgress.click();
		Thread.sleep(5000);
		System.out.println("--------------------------------");
		System.out.println(" ");
		System.out.println("Ticket Status: " + statusDropDown.getText());
	}
	
	public void closeTransition() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		statusDropDown.click();
		close.click();
		Select closecodevalue = new Select(closeCode);
		Thread.sleep(2000);
		closecodevalue.selectByIndex(3);
		Thread.sleep(2000);
		closeNote.sendKeys("Test ticket please ignore");
		Select ActualSizeValue = new Select(actualSize);
		Thread.sleep(2000);
		ActualSizeValue.selectByIndex(4);
		Thread.sleep(2000);
		driver.switchTo().frame(richTextAreaFrame);
		Thread.sleep(3000);
		onHoldCommentBody.sendKeys("Tested");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		onHoldCloseButton.click();
		try {
			  Alert alert = driver.switchTo().alert();
			  alert.accept(); // or alert.dismiss(); to cancel the alert
			} catch (NoAlertPresentException e) {
			  System.out.println("No alert was present");
			}
		Thread.sleep(30000);
		driver.navigate().refresh();
		System.out.println("--------------------------------");
		System.out.println("Ticket Status: " + statusDropDown.getText());
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(7000);
	}
	
	public void cancelTransition() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
		statusDropDown.click();
		cancel.click();
		Thread.sleep(2000);
		driver.switchTo().frame(richTextAreaFrame);
		Thread.sleep(3000);
		onHoldCommentBody.sendKeys("Tested");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		onHoldCloseButton.click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		
	}
}
