Feature: Scenario related Move-In functionality

  @SIT
  Scenario: Verify End to End Move-In Mandatory Field
    Given User have open the move-in page
    And User click on Start button
    And User Click Continue in MoveIN
    And User See Mandatory Field Error Message Moving Details
    And User Enter Mandatory Fileds Moving Details
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User See Mandatory Field Error Message Your Details
    And User Enter Mandatory Fileds Your Details
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User See Mandatory Field Error Message Payment Details
    And User Enter Mandatory Fileds Payment Details
    When User Click Continue in MoveIN
    Then User Should move to Check Detail Page

  #Via Excel
  @excel
  Scenario Outline: Move-In into Metered Property as non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User Enter Address PostCode for TestCase <TestCase>
    And User Click on Find Address
    And User Select my Address <TestCase> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter Customer Detail for <TestCase>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And Set Login Password as <TestCase>
    And First Security Question and Answer <TestCase>
    And Second Security Question and Answer <TestCase>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | TestCase |
      | MPNDD    |

  @excel
  Scenario Outline: Move-In Asses Property as non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User Enter Address PostCode for TestCase <TestCase>
    And User Click on Find Address
    And User Select my Address <TestCase> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter Customer Detail for <TestCase>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And Set Login Password as <TestCase>
    And First Security Question and Answer <TestCase>
    And Second Security Question and Answer <TestCase>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | TestCase |
      | APNDD    |

  @excel
  Scenario Outline: Move-in into Unmetered Property non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User Enter Address PostCode for TestCase <TestCase>
    And User Click on Find Address
    And User Select my Address <TestCase> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter Customer Detail for <TestCase>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And Set Login Password as <TestCase>
    And First Security Question and Answer <TestCase>
    And Second Security Question and Answer <TestCase>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | TestCase |
      | UPNDD    |

  @excel
  Scenario Outline: Move-In into Metered Property as non DD Customer different Corespondence address
    Given User have open the move-in page
    And User click on Start button
    And User Enter Address PostCode for TestCase <TestCase>
    And User Click on Find Address
    And User Select my Address <TestCase> from address list
    And User Enter my  moving date
    And User Select Correspondence address No
    And User enter Correspodant Address PostCode <TestCase>
    And User Select my Correspodant Address <TestCase>
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter Customer Detail for <TestCase>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And Set Login Password as <TestCase>
    And First Security Question and Answer <TestCase>
    And Second Security Question and Answer <TestCase>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | TestCase |
      | MPNDDC   |

  #Non Excel
  
  Scenario Outline: Move-In into Metered Property as non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                            | NTitle | FName   | MName   | LName   | DOB        | PNumber    | email            | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO33 1AT | 155 MARLBOROUGH ROAD,RYDE,PO33 1AT | Dr.    | FTest21 | MTest21 | LTest21 | 25/10/1985 | 9818156878 | test2A@yahoo.com | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  @SmokeTest
  Scenario Outline: Move-In Asses Property as non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                            | NTitle | FName   | MName   | LName   | DOB        | PNumber    | email            | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO33 1AT | 155 MARLBOROUGH ROAD,RYDE,PO33 1AT | Dr.    | FTest21 | MTest21 | LTest21 | 25/10/1985 | 9818156878 | test2A@yahoo.com | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  
  Scenario Outline: Move-in into Unmetered Property non DD Customer
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                            | NTitle | FName   | MName   | LName   | DOB        | PNumber    | email            | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO33 1AT | 155 MARLBOROUGH ROAD,RYDE,PO33 1AT | Dr.    | FTest21 | MTest21 | LTest21 | 25/10/1985 | 9818156878 | test2A@yahoo.com | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  
  Scenario Outline: Move-In into Metered Property as non DD Customer different Corespondence address
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address No
    And User enter Correspodant Address post code <PostCode2>
    And User Select my Correspodant Address <Address2> from address list
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as No
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                            | PostCode2 | Address2                           | NTitle | FName   | MName   | LName   | DOB        | PNumber    | email            | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO33 1AT | 155 MARLBOROUGH ROAD,RYDE,PO33 1AT | PO33 2JT  | 19 RIBOLEAU STREET, RYDE, PO33 2JT | Dr.    | FTest21 | MTest21 | LTest21 | 25/10/1985 | 9818156878 | test2A@yahoo.com | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  @SIT
  Scenario Outline: Move-in into metered Property as DD Customer Full payment
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as Yes
    And User Enter BankDetail <FName> Sort Code <SortCode> Account Number <AccNumber>
    And User select to 'Pay in Full'
    And User Select Randome Day of Month
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                                     | NTitle | FName  | MName  | LName  | DOB        | PNumber    | email           | SortCode | AccNumber | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO39 0AN | IVYHURST ,  THE BROADWAY, TOTLAND, PO39 0AN | Miss   | FTest1 | MTest1 | LTest1 | 25/10/1985 | 9818156878 | test1@yahoo.com |   200000 |  55779911 | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  
  Scenario Outline: Move-in Asses Property as non  Customer Full payment
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Select Home as Contact
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as Yes
    And User Enter BankDetail <FName> Sort Code <SortCode> Account Number <AccNumber>
    And User select to 'Pay in Full'
    And User Select Randome Day of Month
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                                     | NTitle | FName  | MName  | LName  | DOB        | PNumber    | email           | SortCode | AccNumber | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO39 0AN | IVYHURST ,  THE BROADWAY, TOTLAND, PO39 0AN | Miss   | FTest1 | MTest1 | LTest1 | 25/10/1985 | 9818156878 | test1@yahoo.com |   200000 |  55779911 | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  
  Scenario Outline: Move-in into Unmetered Property DD customer
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    And User Select Direct Debit as Yes
    And User Enter BankDetail <FName> Sort Code <SortCode> Account Number <AccNumber>
    And User Select Pay in Monthly Statement
    And User Click Continue in MoveIN
    When User Click Confirm Details
    And Customer ID, Payment Reference depict on Screen
    And User Click Continue in MoveIN
    And User Set Password as <Password>
    And First Security Question <Question1> and Answer <Answer1>
    And Second Security Question <Question2> and Answer <Answer2>
    And User agree  Terms and Condition
    And User Click Continue in MoveIN
    Then User Should  See Activation Mail send on my EmailID Message
    And Click on Finish
    And Confirmation Message

    Examples: 
      | PostCode | Address                                     | NTitle | FName  | MName  | LName  | DOB        | PNumber    | email           | SortCode | AccNumber | Password  | Question1                                      | Answer1 | Question2                           | Answer2 |
      | PO39 0AN | IVYHURST ,  THE BROADWAY, TOTLAND, PO39 0AN | Miss   | FTest1 | MTest1 | LTest1 | 25/10/1985 | 9818156878 | test1@yahoo.com |   200000 |  55779911 | Apple@123 | What was the model of the first car you owned? | Maruti  | What is the name of your first pet? | Dog     |

  @SIT
  Scenario: Verify the Back and Continue Traversal from Check and Confirm
    Given User is at Check Detail Step of Move-in
    When User Click Back Button
    Then User Should move to Payment Detail Page
    And User Click Back Button
    And User Should move to Your Detail Page
    And User Click Back Button
    And User Should move to Moving Detail Page
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User Should move to Check Detail Page

  @SIT
  Scenario Outline: Verify Address Edit from Check and Confirm Step
    Given User is at Check Detail Step of Move-in
    When User Click Back Button
    Then User Should move to Payment Detail Page
    And User Click Back Button
    And User Should move to Your Detail Page
    And User Click Back Button
    And User Should move to Moving Detail Page
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User Click Continue in MoveIN
    And User Should move to Check Detail Page
    And User Should see the Update Address <Address>

    Examples: 
      | PostCode | Address                                     |
      | PO39 0AN | IVYHURST ,  THE BROADWAY, TOTLAND, PO39 0AN |

  @SIT
  Scenario: Verify the User interface is loaded Correctly
    Given User have open the move-in page
    When User Moved till Check Detail Page
    Then User Can See UI is loaded Correctly
    
  
  Scenario Outline: Verify that user can Select Payment Frequency different day of month with Direct Debit and Pay in Full
    Given User have open the move-in page
    And User click on Start button
    And User enter Address post code <PostCode>
    And User Click on Find Address
    And User Select my Address <Address> from address list
    And User Enter my  moving date
    And User Select Correspondence address yes
    And User Enter Number of occupant
    And User Click Continue in MoveIN
    And User Enter NameTitle <NTitle> FirstName <FName> MName <MName> LName <LName> Date of Birth <DOB> PhoneNumber <PNumber> email <email>
    And User Click Continue in MoveIN
    When User Select Direct Debit as Yes
    And User select to 'Pay in Full'
    Then User Can Select any day of Month for Direct Debit

    Examples: 
      | PostCode | Address                                          | NTitle | FName   | MName   | LName   | DOB        | PNumber    | email            | 
      | PO39 0AN | IVYHURST ,  THE BROADWAY, TOTLAND, PO39 0AN      | Miss   | FTest1  | MTest1  | LTest1  | 25/10/1985 | 9818156878 | test1@yahoo.com  |     
  
