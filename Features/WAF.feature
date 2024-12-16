Feature: WAF request type ticket creation and complete flow
  I want to use this template for Security Services Category

@WAF
  Scenario: WAF request type ticket creation and complete flow
    Given User navigates to login page
    When User enters email as "vamshika.vishwanatham@cotiviti.com" and password as "Dell@9160"
    And User clicks on login button
    Then User redirects to Dashboard page
    Then User Is On Securiy Services Form
    Then User select Request Type as "WAF"
    And User selects all the field values 
    | Category | Application Name | Application URL | Application External IP | Stakeholders involved | Description |
    | Onboarding new application | Internal Infra | Test URL | Test ticket | Sai.Kompella@cotiviti.com | Test ticket please ignore |
    Then User submit the form
    And User Selects IT request number
    And User gets the approval from Approver in WAF ticket
    Then Open subtask of ticket in same page
    And User updates the ticket Assignment group
    And User assigns the ticket
    And User moves the ticket to inprogress
    Then User closed the ticket and check parent ticket is closed