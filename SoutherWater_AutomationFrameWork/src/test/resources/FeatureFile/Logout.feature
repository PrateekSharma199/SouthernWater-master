Feature: This feature file consist of scenarios related to logout functionality
 
 @SIT
  Scenario Outline: To verify Registered User Can Log out from Protal   
    Given User is on account dashboard using Credentials <Email> and <Password>
    When User Click on Logout from Dashboard
    Then User Should See 'Thank You' Message after Logout
    And User should not able to see 'Your Account' Option
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|   
 
  @SIT
  Scenario Outline: To verify User can login again after logout
    Given User is on account dashboard using Credentials <Email> and <Password>
    And User Logout from SW Portal
    When User Relogin Using Login Credentials <Email> and <Password> 
   	Then User Should see Your Account link on the Page 
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|   
 
