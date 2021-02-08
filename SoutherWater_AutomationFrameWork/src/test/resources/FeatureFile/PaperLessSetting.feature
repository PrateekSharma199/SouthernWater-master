 Feature: This feature file contains scenarios related to Paper Less Setting option

    
 
 @SIT
  Scenario: Verify the paperless Setting for online Bill
    Given User is on login page
    And User enters login credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click Change Paperless Setting
    And User Should move to Paperless Setting Page
    And User Click on Update
    Then User Can See Thankyou Message
