package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.TicketCreationPage;

public class TicketCreation {

	TicketCreationPage tcp;
	
	public TicketCreation() {
        tcp = new TicketCreationPage(); // Use the shared WebDriver instance
    }
	@Then("Users Is On Securiy Services Form")
	public void user_is_on_securiy_services_form() {
		System.out.println("User is on Security Services form");
	}

	@Then("Users select Request Type as {string}")
	public void user_select_request_type_as(String string) throws InterruptedException {
		tcp.requestType(string);
	}

	@And("Users select Category as {string}")
	public void user_select_category_as(String string) throws InterruptedException {
		tcp.selectCategory(string);
	}

	@Then("Users submit the form")
	public void user_submit_the_form() throws InterruptedException {
		tcp.submitForm();
	}

}
