package stepDefinations;

import io.cucumber.java.en.And;
import pageObjects.AnnualReviewPage;

public class AnnualReviewSteps {

	AnnualReviewPage Arp = new AnnualReviewPage();
	
	@And("User select Category as {string}") 
	public void User_select_Category_as(String string) throws InterruptedException {
	  Arp.selectCategory(string); 
	  }
}
