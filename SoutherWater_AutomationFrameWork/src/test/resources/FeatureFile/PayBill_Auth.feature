Feature: This feature file contains scenarios related to Pay Bill Auth functionality

@SIT123
Scenario Outline: To verify as a Registered user I Can Pay Partial Amount of My Bill
	 	Given User is on account dashboard using Credentials <Email> and <Password>
		And User Click on 'Make a payment' from Dashboard
		And User Click Select Pay Another Amount Option
		And User Enter Amount as <Amount>
		And User Click on Make Payment Link on Page
		When User Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>
		And User Click on Pay Now Button on Make Payment
		Then User Should see Payment Confirmation Message
		And User Should See Thankyou Message
		And User Should See Transaction with Transaction
		And User Should See Payment Reference With Reference
		And User Can See Same Amount as <Amount> user Pay on Portal
		
		 Examples:
    |Email|Password|Amount|Card|Name|expiryMonth|expiryYear|SecureCode|
    |kumar.devesh82@yahoo.com|Apple@123|1|122000000000003|Fiona Vardy|08|27|453|
    
 @SIT123
Scenario Outline: As a Registered user I Can Pay Full Amount of My Bill
		Given User is on account dashboard using Credentials <Email> and <Password>
		And User Click on 'Make a payment' from Dashboard
		And User Click Select Pay Full Amount Option
		And User Click on Make Payment Link on Portal
		When User Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>
		And User Click on Pay Now Button on Make Payment
		Then User Should see Payment Confirmation Message
		
		And User Should See Thankyou Message
		And User Should See Transaction with Transaction
		And User Should See Payment Reference With Reference
		And User Should See Payment Amount as user Pay on Portal
		
		 Examples:
    |Email|Password|Card|Name|expiryMonth|expiryYear|SecureCode|
    |kumar.devesh82@yahoo.com|Apple@123|122000000000003|Fiona Vardy|08|27|453|