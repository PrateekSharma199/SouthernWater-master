Feature: This feature file consist of scenario related to account dashboard options for different user type

	@SIT
  Scenario: To verify account type is showing unmetered for assessed user 
    Given assessed user has logged in successfully
    When assessed user check the meter reading card on dashboard
    Then assessed user should verify the account is not metered
  
  @SIT  
  Scenario: To verify for assessed user meter reading option is not displayed during move out process
    Given assessed user has logged in successfully
    When assessed user select move out with change address option
    Then assessed user should verify meter reading is not displayed on Your final bill screen
    
  @SIT
  Scenario: To verify meter reading is visible on meter reading card for metered account dashboard
   	Given metered user has logged in successfully
   	When metered user check the meter reading card on dashboard
   	Then metered user should verify the last meter reading,meter number and date last read
  
  @SIT
  Scenario: To verify account type is showing unmetered for unmetered user 
    Given unmetered user has logged in successfully
    When unmetered user check the meter reading card on dashboard
    Then unmetered user should verify the account is not metered
    
  @SIT
  Scenario: To verify mode of payment is showing direct debit for for metered direct debit customer
    Given metered direct debit user has logged in successfully
    When metered DD user navigates to payment history
    Then user should verify transaction history is showing mode as direct debit  
    
  @SIT
  Scenario: To verify mode of payment is showing payment received for metered cash customer
    Given metered cash user has logged in successfully
    When metered cash user navigates to payment history
    Then user should verify transaction history is showing payment received	
    
  @SIT
  Scenario Outline: To verify the option Setup direct debit and Amend direct debit is displayed as per the user logged in
    Given <usertype> customer has logged in successfully
    When <usertype> customer navigates to dashboard options
    Then <usertype> customer is displayed provision to setup or amend direct debit as per the account setup
		
     Examples:
     					|usertype|
     					|DirectDebit|
     					|CashType|	
  @SIT
  Scenario Outline: To verify the last bill amount of user displayed on dashboard is same as displayed 
  on payment history screen
  	 Given <usertype> customer has logged in successfully
  	 When <usertype> customer compare the last bill on dashboard and billing history
  	 Then <usertype> should confirm last bill	is being displayed on top in billing history
  	 
  	 Examples:
     					|usertype|
     					|DirectDebit|
     					|CashType|							
     					
    