package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.WAFPage;

public class WAFSteps {

	WAFPage WafPage = new WAFPage();

	

	@And("User selects all the field values")
	public void Userselectsallthefieldvalues(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> user : users) {
			String Category = user.get("Category");
			String ApplicationName = user.get("Application Name");
			String ApplicationURL = user.get("Application URL");
			String ApplicationExternalIP = user.get("Application External IP");
			String Stakeholdersinvolved = user.get("Stakeholders involved");
			String Description = user.get("Description");
			WafPage.addFields(Category, ApplicationName, ApplicationURL, ApplicationExternalIP, Stakeholdersinvolved,
					Description);
		}
	}

	@And("User gets the approval from Approver in WAF ticket")
	public void UsergetstheapprovalfromApproverinWAFticket() throws InterruptedException {
		WafPage.Approval();
	}

}
