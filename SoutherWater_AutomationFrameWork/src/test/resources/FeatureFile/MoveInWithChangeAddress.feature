Feature: This feature file contains test scenarios related to movein with a change address request
  
	@SIT
  Scenario: To verify the option to change address on move in page
    Given User has logged in successfully
    When User Click on 'Tell us you are moving' from menu
    Then User should see option to Change address on move in page

  @SIT
  Scenario: To verify user navigation to moving from page 	
   Given User has logged in successfully
   When User Click on 'Tell us you are moving' from menu
   And User click on Change your address button
   Then User should be navigated to moving from page
   
  @SIT
  Scenario: To verify validation message when user enter move out date more than 30 days from current date
   Given User has logged in successfully
   When User Click on 'Tell us you are moving' from menu
   And User click on Change your address button
   And User enter a move out date more than thirty days from current date
   Then User should be presented with error message stating to inform move out thirty days before
   
	@SIT
  Scenario: To verify success message when user have successfully completed move out process
   Given User has logged in successfully
   When User Click on 'Tell us you are moving' from menu
   And User click on Change your address button
   And User fills the mandatory details for move out
   Then User should be presented with success message for move out process
   