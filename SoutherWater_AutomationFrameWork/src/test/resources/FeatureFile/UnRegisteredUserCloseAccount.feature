Feature: The purpose of this feature is to test the Close Account Functionality of UnRegistered User

@SIT123
Scenario Outline: Verify that an unregistered user is able to close account successfully
Given User is on UnRegisterd User Close Account Page 
And User Click on Start of Close Account Page
And User Enter CustomerNumer <CustomerNumber> Payment Reference <PayReference> Last Name <LastName>
And User Click On Continue of Close Account Your Detail Step
And User Enter Moving Out Date of Close Account
And User Click On Continue of Close Account Moving Date Step
And User Click On Continue of Close Account Final Bill Step
And User Enter Address Post Code as <PostCode> on Forwarding Address Step
And User Click on Find Address Forwarding Address Step
And User Select <Address> from Address List on Forwarding Address Step
And User Click Continue on Forwarding Address Step
When User Click Confirm and Close Account on check and confirm Step
Then User Should see Account Close
And User Should See Account Closing Message

 Examples:
    |CustomerNumber|PayReference|LastName|PostCode|Address|
    |10470201|0004012407196|DOWNHYLL|CT16 3NR|18 WITLEY WALK, WHITFIELD, CT16 3NR|
    
 