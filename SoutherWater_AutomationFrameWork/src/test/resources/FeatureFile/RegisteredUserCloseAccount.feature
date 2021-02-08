Feature: The purpose of this feature is to test the Close Account Functionality of Registered User

#Background: I should be Login in SouthernWater Portal
#Given I have SouthernWater Login Page on Browser
#When I Enter my Account EmailID and Password
#And I Click on Login Button On Page
#Then I Should Login to SouthernWater Portal

@SIT
Scenario Outline: User Should be navigated to DashBoard after clicking back button of Close Account
Given User is on account dashboard using Credentials <Email> and <Password>
When User Click on 'Tell us you are moving' from Dashboard
Then User Should see Your Account link on the Page

Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|

@SIT
Scenario Outline: Verify Registered User is able to close the account 
Given User is on account dashboard using Credentials <Email> and <Password>
When User Click on 'Tell us you are moving' from Dashboard
And User Click Close your account from you are moving 
And User Enter the MoveOut Date
And User Click On Continue of Move Out Step
And User Click On Continue of Final Bill Step
And User Enter Post Code as <PostCode>
And User Click on Find Address
And User Select <Address> from Address List
And User Click Continue of Forwarding Address
And User Click Confirm and Close Account
Then User account should be marked closed
And User Can See Closing Message

 Examples:
    |Email|Password|PostCode|Address|
    |kumar.devesh82@yahoo.com|Apple@123|CT16 3NR|18 WITLEY WALK, WHITFIELD, CT16 3NR|