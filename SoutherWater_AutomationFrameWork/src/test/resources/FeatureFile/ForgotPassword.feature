Feature: This feature file contains scenario related to Forgot Password funtionality

@SIT
  Scenario: To verify user is able to reset the password  
    Given User is on login page
    When User Click on Forgot Password
    Then User Should navigate to Forgot Password Page 
    And User Should See Email address field for reset password
    And Back to login, Continue links 
  
@SIT
  Scenario Outline: To verify user is notified that Reset Password link is sent on mail   
    Given User is at Reset Password Page
    When User Enter <Email> in Reset Password 
    And Click on Continue 
    Then User Can See the Verification Link Sent Message
		Examples:
    |Email|
    |abc@yahoo.com|