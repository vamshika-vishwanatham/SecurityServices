package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommonStepsPage;

public class CommonSteps {

	CommonStepsPage csp;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws InterruptedException, IOException {
		csp = new CommonStepsPage();
		csp.hitURL();
		System.out.println("User is on Login page");
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
		csp.setEmail(string);
		csp.setPassword(string2);
	}

	@And("User clicks on login button")
	public void User_clicks_on_login_button() throws IOException, InterruptedException {
		csp.signIn();
	}

	@Then("User redirects to Dashboard page")
	public void User_redirects_to_dashboard_page() throws IOException, InterruptedException {
		System.out.println("User is on Dashboard Page");
		csp.serviceDeskPortal();
	}
	
	@Then("User Is On Securiy Services Form")
	public void User_Is_On_Securiy_Services_Form() {
		System.out.println("User is on Security Services form");
	}
	@Then("User select Request Type as {string}")
	public void UserselectWAFRequestTypeas(String string) throws InterruptedException {
		csp.requestType(string);
	}
	@Then("User submit the form")
	public void Usersubmittheform() throws InterruptedException {
		csp.submitForm();
	}
	
	@And("User Selects IT request number")
	public void UserSelectsITrequestnumber() throws InterruptedException {
		csp.ITView();
	}
	@Then("Open subtask of ticket in same page")
	public void Opensubtaskofticketinsamepage() throws InterruptedException {
		csp.subtask();
	}

	@And("User updates the ticket Assignment group")
	public void UserupdatestheticketAssignmentgroup() throws InterruptedException {
		csp.updateAssignmentGroup();
	}

	@And("User assigns the ticket")
	public void Userassignstheticket() throws InterruptedException {
		csp.updateAssignee();
	}

	@And("User moves the ticket to inprogress")
	public void Usermovesthetickettoinprogress() throws InterruptedException {
		csp.inProgressTransition();
	}
	
	@Then("User closed the ticket and check parent ticket is closed")
	public void Userclosedtheticketandcheckparentticketisclosed() throws InterruptedException {
		csp.closeTransition();
	}
	
	@Then("User cancel the ticket and check subtask is cancelled")
	public void Usercanceltheticketandchecksubtaskiscancelled() throws InterruptedException {
		csp.cancelTransition();
	}
}
