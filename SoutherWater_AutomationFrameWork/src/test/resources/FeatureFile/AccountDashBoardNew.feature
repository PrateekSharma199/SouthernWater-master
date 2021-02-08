Feature: Scenario related to Account Dashboard for Non Direct Debit Customer

  # Non Direct Debit Customer >> NDD
  @SIT
  Scenario Outline: Verify Account Dashboard Quick links for Non Direct Debit Metered Customer
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    Then User can see the QuickLinks <Links> on Dashboard
    And User can see Customer Number,Payment Reference on Dashboard
    And User Can see Customer Email ID, Correspondence Address under your profile section
    And User Can see Last Meter Reading, Meter Number, Date last Read
    And User Can see Property address, Your Services
    And User Can see Latest Bill, Bill Amount, Bill Date
    And User Can see Amount Due, Amount, date

    Examples: 
      | CustType | Links                                                                                                |
      | NDD      | Set up a Direct Debit, View bills/account statement ,View payment history ,Change paperless settings |

  @SIT
  Scenario Outline: Verify Dashboard Menu Items
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    Then User Can See Following Menu <MenuItem> Items

    Examples: 
      | CustType | MenuItem                                                                                                                                                                   |
      | NDD      | Make a payment , Set up / Amend a Direct Debit ,View bills / Account statement ,Payment history,Submit a meter reading,Paperless settings,Tell us you_re moving,Update profile |

  @SIT
  Scenario Outline: Verify Logout Functionality
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click on Logout from Dashboard
    Then User Should See 'Thank You' Message after Logout
    And User should not able to see 'Your Account' Option

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Submit Meter Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click on 'Submit a meter reading' from Dashboard
    Then User Should Move to Submit Meter Reading Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Make a payment Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click on 'Make a payment' from Dashboard
    Then User Should Move to Payment Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Close Account Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click on 'Tell us you are moving' from Dashboard
    Then User Should Move to Close Account Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify the paperless Setting for online Bill
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click Change Paperless Setting
    And User Should move to Paperless Setting Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Direct Debit Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click Set Up Direct Debit
    Then User Should move to Setup Direct Debit Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Your Profile Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click update Profile
    Then User Should move to View Profile Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Payment History Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click Set Up Payment history
    Then User Should move to Payment history Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify View bills/Account statement Navigation
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Your Account' Option
    And User Click View bills/Account statement
    Then User Should move to View Bill Account Statement Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Submit Meter Navigation by quick link on Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Submit a meter reading' button from Dashboard
    Then User Should Move to Submit Meter Reading Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Close Account Navigation by quick link on Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Tell us you are moving' button from Dashboard
    Then User Should Move to Close Account Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Make a payment Navigation by quick link on Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click on 'Make a payment' button from Dashboard
    Then User Should Move to Payment Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Your Profile Navigation by quick link on Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click 'View Profile' button from Dashboard
    Then User Should move to View Profile Page

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Contact Us Navigation from Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click Contact us
    Then Contact Us page should open in new tab

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Verify Find out more Navigation from Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click Discover ways to save
    Then Save Water page should open in new tab

    Examples: 
      | CustType |
      | NDD      |

  @SIT
  Scenario Outline: Registered User can access How to keep it clear
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click Learn more
    Then How to prevent blockage page should open in new tab

    Examples: 
      | CustType |
      | NDD      |

  # UnMetered Non Direct Debit Customer >> UMNDD
  @SIT
  Scenario Outline: Verify Account Dashboard Quick links for Un-Metered Account
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    Then User can see the QuickLinks <Links> on Dashboard
    And User Can see Struggling to Pay,Amend Direct Debit
    And User Can see Meter Reading, This account is not metered
    And User Can see Customer Email ID, Correspondence Address under your profile section
    And User Can see Property address, Your Services
    And User Can see Latest Bill, Bill Amount, Bill Date

    #And I Can see Amount Due, Amount, date
    Examples: 
      | CustType | Links                                                                                          |
      | UMNDD    | Make a payment , View bills/account statement ,View payment history ,Change paperless settings |

  @SIT
  Scenario Outline: Verify Struggling to pay Navigation from Dashboard
    Given User is on login page
    And User Login with <CustType> Credentials
    When Click on Login
    And User Click Struggling to Pay
    Then Struggling to Pay page should open in new tab

    Examples: 
      | CustType |
      | UMNDD    |
