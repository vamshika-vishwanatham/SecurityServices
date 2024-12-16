Feature: Annual Review request type ticket creation and complete flow
  I want to use this template for Security Services Category
  
	@AnnualReview
  Scenario: Annual Review request type ticket creation and complete flow
    Given User navigates to login page
    When User enters email as "vamshika.vishwanatham@cotiviti.com" and password as "Dell@9160"
    And User clicks on login button
    Then User redirects to Dashboard page
    Then User Is On Securiy Services Form
    Then User select Request Type as "Annual Review"
    And User select Category as "Application Whitelist/Blacklist"
    Then User submit the form
    And User Selects IT request number
    Then Open subtask of ticket in same page
    And User updates the ticket Assignment group
    And User assigns the ticket
    And User moves the ticket to inprogress
    Then User cancel the ticket and check subtask is cancelled

