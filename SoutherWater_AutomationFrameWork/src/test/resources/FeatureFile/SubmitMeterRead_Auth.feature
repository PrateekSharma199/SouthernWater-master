Feature: Auth Submit Meter Reading 

@SmokeTest
 Scenario Outline: Authorized User Should have Access Submit Meter Page   
    Given User is on account dashboard using Credentials <Email> and <Password>
    When User Click on 'Submit a meter reading' from Dashboard
    Then User can view Your meter reading page
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|
    
@SIT
 Scenario Outline: Authorized Submit Meter Page Back Button
    Given User is on account dashboard using Credentials <Email> and <Password>
    When User Click on 'Submit a meter reading' from Dashboard
    And User click Back button on Your meter reading page
    Then User should navigate to my account dashboard
    And User verifies Customer Number & Payment Reference
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|    
    
@SIT
  Scenario Outline: Login with Valid credentials to verify updated Meter Reading and today date 
    Given User is on account dashboard using Credentials <Email> and <Password>
    When User Click on 'Submit a meter reading' from Dashboard
    And User enter meter reading 
    And User click on Continue button
    Then User should move to Confirm meter reading step 
    And User can view updated Meter Reading 
    And User can view today date 
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|
  
  @SIT
  Scenario Outline: Login with Valid credentials to update meter reading  
    Given User is on account dashboard using Credentials <Email> and <Password>
    When User Click on 'Submit a meter reading' from Dashboard
    When User click Back button of Confirm meter reading page
    Then User can update the new meter reading
    And User can click to continue Button of Your meter reading page
    And User can view updated meter reading on Confirm meter reading 
  
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|
    
 