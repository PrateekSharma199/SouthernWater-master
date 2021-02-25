Feature: This feature file contains scenarios related to UnAuth Submit Meter Reading 

@SIT123
Scenario: To verify user is able to Submit my meter reading 
    Given User is on meter submit reading pages
    When User click on Having trouble link
    Then User Should move to how to find your meter page
    
@SIT123
Scenario: To verify user can Access Submit meter reading 
    Given User is on how to find your meter page
    When User click on Submit Meter link
    Then User Should move to Submit meter reading page

@SIT123
Scenario: To Verify customer meter reading details 
    Given User is on submit meter reading page
    When User submit all the details of customer
    Then User Should able to verify all the details of customer 
    

@SIT123
  Scenario Outline: To verify as Unregistered User Can Submit my Meter Reading 
    Given User is on Unregistered Submit meter Reading page
    And  User Click on Start Button
    And User Enter CustomerNumber <CustomerNumber> PaymentReference <PayRef> and LastName <LastName>
    And User Click on Continue
    And User Click again on  Continue
    When User Can Enter Updated Meter Reading 
    And User can click to continue Button of Your meter reading page
    Then User can view updated meter reading on Confirm meter reading 
  
 Examples:
    |CustomerNumber|PayRef|LastName|
    |11860577|0004508310701|POCKETT|
