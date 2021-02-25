Feature: This feature file contains scenarios related to login functionality
 

@SIT123
  Scenario Outline: To verify user is not able Login with incorrect credentials 
    Given User is on login page
    When User Enter <Email> and <Password> into respective fields
    And Click on Login 
    Then User Should not be able to login 
    And User is presented with Login error message
    
    Examples:
    |Email|Password|
    |abc@yahoo.com|xyz123|
   
@SIT123
  Scenario Outline: To verify user is able Login with Valid credentials   
    Given User is on login page
    When User Enter <Email> and <Password> into respective fields
    And Click on Login button
    Then User Should see Your Account link on the Page
    
    
  Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|
    
@SIT123
  Scenario: To verify user navigation to move on Registration Page    
    Given User is on login page
    When User Click on Registration 
    Then User Should be navigated to Registration Page
	