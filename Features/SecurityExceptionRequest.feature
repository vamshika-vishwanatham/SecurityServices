Feature: Security Exception Request type and complete flow
  I want to use this template for Send Attachments to Personal Email Accounts

  @SecurityException
  Scenario: Send Attachments to Personal Email Accounts category complete flow
    Given User navigates to login page
    When User enters email as "vamshika.vishwanatham@cotiviti.com" and password as "Dell@9160"
    And User clicks on login button
    Then User redirects to Dashboard page
    Then User Is On Securiy Services Form
    Then User select Request Type as "Security Exception Request"
    And User selects all the field values of Send Attachments
    | Category | Type of exception period | Access to client data specifically PHIorPII |Justification | Temporary Exception Date |
    | Send Attachments to Personal Email Accounts| Permanent |  Yes | Test ticket |12/Dec/24 |    
    Then User submit the form
    And User Selects IT request number
    And User gets the approval from Manager Approver in Send Attachments ticket
    And User gets the approval from User Approver in Send Attachments ticket
    Then Open subtask of ticket in same page
    And User updates the ticket Assignment group
    And User assigns the ticket
    And User moves the ticket to inprogress
    Then User closed the ticket and check parent ticket is closed
    
    