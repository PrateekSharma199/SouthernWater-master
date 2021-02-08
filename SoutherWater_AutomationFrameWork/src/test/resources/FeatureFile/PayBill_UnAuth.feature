Feature: This feature file contains scenarios related to Pay Bill UnAuth functionality


@SIT 
Scenario: Check the SouthernWater App Access
    Given User is on SouthernWater Pay Bill page 
    When User Click on Start
    Then User move to customer details page
    And Back link is also available 
   
@SIT
Scenario: Verify Pay Bill Back Button Functionality
		Given User is on SouthernWater Pay Bill detail Page
		When User Click on Back Button
		Then User is navigated to Pay Detail Main Page

@SIT
Scenario: Verify Question Mark ToolTip
		Given User is on SouthernWater PayBill detail Page
		When User Click First Time on Question Mark Icons
		Then User Can see the Suggestion Message
		When User Click Second Time on Question Mark Icons
		Then User Suggestion Message should hide

@SIT1
Scenario: Check the mandatory field error message for Pay Bill
		Given User is on The SouthernWater UnAuth Pay Bill Page
		And User already Click on Start Button
		When User Perform Click Action on Continue Button of Pay Bill Detail Page
		Then User should not be able to Proceed & System throw the mandatory field Error Message
		
@SIT
Scenario: Check the error message for Incorrect Data
		Given User is on SouthernWater Pay Bill on Your Detail Step
		When User enter all details
		And User click on Continue on Detail page
		Then User Should see the error Message for incorrect Data
		

@SIT
Scenario: Check the error message removed after entering mandatory field
		Given User is on SouthernWater Pay Bill with mandatory field error message
		When User enter all details in form
		Then User Should not see the error Message for mandatory fields
		

@SmokeTest
Scenario Outline: As a Unregistered user User Can Pay Partial Amount of My Bill
		Given User is Accesing Pay Bill Detail Page
		And User Click Start Button on Page
		And User Enter Details Customer Number <CustNum> Payment Reference <PayRef> Last Name <LastName> EmailID <Email>
		And User Do Click Action on Continue Button of Pay Bill Detail Page
		And User Do Click Action on Continue Button of Check Detail Step
		And User Select Pay another Amount
		And User Enter Partial Amount<Amount>
		And User Click on Make Payment
		When User Enter Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear>  and SecurityCode <SecureCode>
		And User Click on Pay Now on Make Payment Step
		Then User Can see Payment Confirmation Message
		And Thankyou Message
		And Transaction with Transaction Number
		And Payment Reference With Reference Number
		And Same Amount <Amount> as User Pay
		
		 Examples:
    |CustNum|PayRef|LastName|Email|Amount|Card|Name|expiryMonth|expiryYear|SecureCode|
    |13417979|4050614612|Vardy|devesh.kumar@southernwater.co.uk|1|122000000000003|Fiona Vardy|08|27|453|
		 


@SIT
Scenario Outline: As a Unregistered user User Can Pay Full Amount of My Bill
		Given User have Open Pay Bill Detail Page
		And User Click Start Link on Page
		And User enter my details Customer Number <CustNum> Payment Reference <PayRef> Last Name <LastName> EmailID <Email>
		And User Do Click Action on Continue Button of Pay Bill Detail Page
		And User Do Click Action on Continue Button of Check Detail Step
		And User Select Pay Full Amount
		And User Click on Make Payment Link
		When User Enter Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear>  and SecurityCode <SecureCode>
		And User Click on Pay Now Button on Make Payment Step
		Then User Can see Payment Confirmation Message on Page
		And Thankyou Message on Page
		And Transaction with Transaction Number on Receipt
		And Payment Reference With Reference Number
		And Same Amount as User Pay on Receipt
		
		 Examples:
    |CustNum|PayRef|LastName|Email|Card|Name|expiryMonth|expiryYear|SecureCode|
    |13417979|4050614612|Vardy|devesh.kumar@southernwater.co.uk|122000000000003|Fiona Vardy|08|27|453|		