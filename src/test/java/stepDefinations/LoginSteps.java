package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps{
	 LoginPage lp;
  
	@Given("Users navigates to login page")
	public void users_navigates_to_login_page() throws InterruptedException, IOException {
		lp=new LoginPage();
		lp.hitURL();
		System.out.println("User is on Login page");
	}

	@When("Users enters email as {string} and password as {string}")
	public void users_enters_email_as_and_password_as(String string, String string2) {
		lp.setEmail(string);
		lp.setPassword(string2);
	}

	@And("users clicks login button")
	public void users_clicks_login_button() throws IOException, InterruptedException {
		lp.signIn();
	}

	@Then("users redirects to Dashboard page")
	public void users_redirects_to_dashboard_page() throws IOException, InterruptedException {
		System.out.println("User is on Dashboard Page");
		lp.serviceDeskPortal();
	}
	
}
