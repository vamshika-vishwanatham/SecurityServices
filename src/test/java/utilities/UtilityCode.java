package utilities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import factory.BaseClass;

public class UtilityCode extends BaseClass {
	public UtilityCode() {
		super(driver);
		 PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement enterInput;
	@FindBy(xpath = "//div[@class='rw_item_footer']/button[2]/span")
    public WebElement submit;
	
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

	String currentUrl;
	String switchUserUrl;

	
	@FindBy(xpath="//a[@title='Administration']")
	WebElement administrator;
	@FindBy(xpath="//div[@id='system-admin-menu-content']/div/ul/li[10]")
	WebElement scriptRunner;
	@FindBy(xpath="//*[@class='sr-rs__control css-b4cy4q-control']")
	WebElement selectUser;
	@FindBy(xpath="//button[@data-cy='execute-button']/span")
	WebElement runProfile;
	@FindBy(id="com.atlassian.servicedesk.approvals-plugin:approve-approval")
	WebElement approveButton;
	@FindBy(partialLinkText="Return to your session as ")
	WebElement returnToSession;
	@FindBy(id="searchScripts")
	WebElement searchScripts;	
	@FindBy(xpath="//div[@data-testid='scriptContainer']/a")
	WebElement switchUser;
	public void windowHandle() {

		Set<String> windows = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows) {
			driver.switchTo().window(ServiceDeskPortal);
		}
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void fillTextField(WebElement element, String value) {
		  element.clear(); 
		  element.sendKeys(value);
		 
    }

	public void multiThread() throws InterruptedException {
		Thread.sleep(60000);
		driver.navigate().refresh();
		/*
		 * Thread.sleep(60000); driver.navigate().refresh();
		 */
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
    public void fillDropdownField(WebElement element, String value) throws InterruptedException {
        element.click();
        Thread.sleep(1000);
        enterInput.sendKeys(value);
        Thread.sleep(1000); // Wait for dropdown to appear
        enterInput.sendKeys(Keys.ENTER);
    }

    public void submitForm() throws InterruptedException {
        driver.switchTo().parentFrame();
        submit.click();
        Thread.sleep(5000); // Wait for form submission
    }
    public void sideArrow() throws InterruptedException {
		Thread.sleep(3000);
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
	
	
	public void switchUser() throws InterruptedException {
		
		currentUrl = driver.getCurrentUrl();
		administrator.click();
		scriptRunner.click();
		Thread.sleep(1000);
		searchScripts.sendKeys("Switch to a different user");
		Thread.sleep(2000);
		switchUser.click();
		Thread.sleep(3000);
		switchUserUrl = driver.getCurrentUrl();
	}
	
	
	public void userProfileSwitch(String name) throws InterruptedException {
		
		//multiThread();
		selectUser.click();
		driver.findElement(By.id("react-select-2-input")).sendKeys(name);
		Thread.sleep(3000);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		runProfile.click();
		Thread.sleep(5000);
		driver.get(currentUrl);
		Thread.sleep(3000);
		approveButton.click();
		Thread.sleep(4000);
		//driver.get(switchUserUrl);
		driver.navigate().back();
		returnToSession.click();
		Thread.sleep(2000);
		driver.get(currentUrl);
		System.out.println("************** Ticket Approved "+ name +"**************");
		Thread.sleep(30000);
		driver.navigate().refresh();
		Thread.sleep(30000);
		driver.navigate().refresh();
		
	}
}
