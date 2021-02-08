Feature: This feature file contains scenarios related New-Account-Registration functionality

  @SIT
  Scenario Outline: New Account Registration
    Given User is on Online Registration Link
    When User agree  Terms and Condition
    And User Click Start
    And User Enter Details as Customer Number <CustNumber> Last Name <LastName> Email <EmailID>
    And Click Continue Button Present on Screen
    And Click Confirm and Continue
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And Click on Login Detail Continue Button
    Then User Can See Activation Mail send on my EmailID

    Examples: 
      | CustNumber | LastName | EmailID              | Password   | Question1                                      | Answer1 | Question2                           | Answer2 |
      |   30041953 | Pinku    | xovisi7659@hmnmw.com | Apple@1234 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  @SIT
  Scenario Outline: Mandatory Field Validation
    Given User is on Online Registration Link
    And User agree  Terms and Condition
    And User Click Start
    And Click Continue Button Present on Screen
    And User should see the Mandatory Field Message on Register Now Step
    And User agree Terms and Condition
    And User Click Start
    And Enter My Detail Customer Number <WrongInput>
    And Click Continue Button Present on Screen
    And User should see the Mandatory Field Message on Your Details Step
    And User Enter Details as Customer Number <CustNumber> Last Name <LastName> Email <EmailID>
    And Click Continue Button Present on Screen
    And Click Confirm and Continue
    And Click on Login Detail Continue Button Without input
    And User should see the Mandatory Field Message on Login Details Step
    When User Enter Password <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    Then User Should not see any Mandatory Error Message

    Examples: 
      | WrongInput | CustNumber | LastName | EmailID              | Password   | Question1                                      | Answer1 | Question2                           | Answer2 |
      | test33     |   30041953 | Pinku    | xovisi7659@hmnmw.com | Apple@1234 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  @SIT
  Scenario Outline: Edit Email ID
    Given User has logged in using Customer Number <CustNumber> Last Name <LastName> Email <EmailID>
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    When User Click Back Button
    And User Move to Check and Confirm Step
    And User Click Back Button
    And User Update the New Email <newEmail>
    And Click Continue Button Present on Screen
    Then User Can see Updated Emails

    Examples: 
      | WrongInput | CustNumber | LastName | EmailID              | newEmail           | Password   | Question1                                      | Answer1 | Question2                           | Answer2 |
      | test33     |   30041953 | Pinku    | xovisi7659@hmnmw.com | newEmail@hmnmw.com | Apple@1234 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |
      
      
 @SIT
  Scenario Outline: Back Forward Traversal
    Given User has logged in using Customer Number <CustNumber> Last Name <LastName> Email <EmailID>
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    When User Click Back Button
    And User Move to Check and Confirm Step
    And User Click Back Button
    And User Should move to Your Details Step
    And Click Continue Button Present on Screen
    And Click Confirm and Continue
    Then User Should move back to Login Details Step

    Examples: 
      | WrongInput | CustNumber | LastName | EmailID              | newEmail           | Password   | Question1                                      | Answer1 | Question2                           | Answer2 |
      | test33     |   30041953 | Pinku    | xovisi7659@hmnmw.com | newEmail@hmnmw.com | Apple@1234 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |
