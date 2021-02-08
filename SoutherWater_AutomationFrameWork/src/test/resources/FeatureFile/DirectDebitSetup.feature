Feature: This feature file contains scenarios related to direct debit setup

@SIT
Scenario: To verify navigation of user to direct debit page
    Given User has logged in successfully
    When User Click Set Up Direct Debit from menu
    Then User Should move to Setup Direct Debit Page
    
@SIT 
Scenario: To verify user is not able to setup direct debit with incorrect bank details
     Given User has logged in successfully
     When User Click Set Up Direct Debit from menu
     And User enter incorrect bank details for direct debit
     Then User should be presented with the error message for incorrect bank details
@SIT
Scenario: To verify user is able to setup direct debit with valid bank details
     Given User has logged in successfully
     When User Click Set Up Direct Debit from menu
     And User enter correct bank details for direct debit
     Then User should be able to setup direct debit successfully

@SIT
Scenario: To verify user is presented with validation message when mandatory details are not filled for 
direct debit setup 
     Given User has logged in successfully
     When User Click Set Up Direct Debit from menu
     And User click continue without filling bank details for direct debit
     Then User should be presented with validation messages for mandatory bank details required for DD setup
    	 
     