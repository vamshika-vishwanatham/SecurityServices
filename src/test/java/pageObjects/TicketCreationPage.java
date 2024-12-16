package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.UtilityCode;

public class TicketCreationPage extends UtilityCode {

	//WebDriver driver = getDriver();
	@FindBy(id = "s2id_customfield_11372")
	WebElement requestType;

	@FindBy(id = "s2id_customfield_11370")
	WebElement category;

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

}
