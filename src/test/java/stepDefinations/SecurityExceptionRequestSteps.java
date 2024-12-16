package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.SecurityExceptionRequestPage;

public class SecurityExceptionRequestSteps {
	
	SecurityExceptionRequestPage Serp = new SecurityExceptionRequestPage();

	@And("User selects all the field values of Send Attachments")
	public void UserselectsallthefieldvaluesofSendAttachments(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> user : users) {
			String Category = user.get("Category");
			String Typeofexceptionperiod = user.get("Type of exception period");
			String AccesstoclientdataPHIorPII = user.get("Access to client data specifically PHIorPII");
			String Justification = user.get("Justification");
			String TemporaryExceptionDate = user.get("Temporary Exception Date");
			Serp.addFields(Category,Typeofexceptionperiod,AccesstoclientdataPHIorPII,Justification,TemporaryExceptionDate);
		}
	}

	@And("User gets the approval from Manager Approver in Send Attachments ticket")
	public void user_gets_the_approval_from_Manager_approver_in_send_attachments_ticket() throws InterruptedException {
		Serp.Approval();
	}
	
	@And("User gets the approval from User Approver in Send Attachments ticket")
	public void user_gets_the_approval_from_User_approver_in_send_attachments_ticket() throws InterruptedException {
		Serp.UserApproval();
	}

}
