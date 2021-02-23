package pageHelper.web;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pageFunctions.web.AccountDashBoardFunctions;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageFunctions.web.AccountDashBoardFunctions;
import pageFunctions.web.AssertionExceptionManager;
import pageFunctions.web.ExcelWork;
import pageFunctions.web.LoginFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class AccountDashBoardPageHelper {

	public webHelper webDriver;
	public webHelper pageDriver;
	private xmlreader loginLoct = new xmlreader("src\\test\\resources\\locators\\Login.xml");
	public AccountDashBoardFunctions dashBoard;
	public AssertionExceptionManager custException;
	public LoginFunctions login;
	private bddDriver DriverInstance;
	public String enteredName, enteredCustomerNumber, enteredEmailID, newEmail, firstSecurityQuest;
	PropertyReader prpertyreader = new PropertyReader();
	ExcelWork excel = new ExcelWork();

	public AccountDashBoardPageHelper(WebDriver driver) {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		dashBoard = new AccountDashBoardFunctions(webDriver);
		login = new LoginFunctions(webDriver);
	}

	public AccountDashBoardPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		dashBoard = new AccountDashBoardFunctions(webDriver);
		login = new LoginFunctions(webDriver);
	}

	// New Functions
	@Then("^User Should see Your Account link on the Page$")
	public void i_Should_see_Your_Account_link_on_the_Page() throws Throwable {
		dashBoard.yourAccountDisplayed();
	}

	@And("^User Click on 'Your Account' Option$")
	public void click_on_Your_Account_Option() throws Throwable {
		dashBoard.yourAccountClick();
	}

	@Then("^I Should see 'Dashboard' Option$")
	public void i_Should_see_Dashboard_Option() throws Throwable {
		dashBoard.dashBoardHead();
	}

	@And("^I Should See 'Log out' Option$")
	public void i_Should_See_Logout_Option() throws Throwable {
		dashBoard.logoutOption();
	}

	@And("^I Should See 'Make a payment' Option$")
	public void i_Should_See_Make_a_payment_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Make a payment");
	}

	@And("^I Should See 'Payment history' Option$")
	public void i_Should_See_Payment_history_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Payment history");
	}

	@And("^I Should See 'Tell us you are moving' Option$")
	public void i_Should_See_Close_your_account_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Tell us you're moving");
	}

	@And("^I Should See 'Set up/Amend a Direct Debit' Option$")
	public void i_Should_See_Set_up_a_Direct_Debit_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Set up/Amend a Direct Debit");
	}

	@And("^I Should See 'Paperless settings' Option$")
	public void i_Should_See_Paperless_settings_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Paperless settings");
	}

	@And("^I Should See 'Your profile' Option$")
	public void i_Should_See_Your_profile_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Your profile");

	}

	@And("^I Should See 'View bills/Account statement' Option$")
	public void i_Should_See_Account_statement_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("View bills/Account statement");
	}

	@And("^I Should See 'Submit a meter reading' Option$")
	public void i_Should_See_Submit_a_meter_reading_Option() throws Throwable {
		dashBoard.dashBoardOptionsVerification("Submit a meter reading");

	}

	@Given("^User is on account dashboard using Credentials ([^\"]*) and ([^\"]*)$")
	public void DashBoard_Using_Login_Credentials(String email, String password) throws Throwable {
		login.OpenLoginPage();
		login.enterEmailAndPassword(email, password);
		login.clickOnLogin();
		dashBoard.yourAccountClick();

	}
	

	@When("^User Click on Logout from Dashboard$")
	public void i_Click_on_Logout_from_Dashboard() throws Throwable {
		dashBoard.logoutClick();
	}

	@Then("^User Should See 'Thank You' Message after Logout$")
	public void i_Should_See_Thank_You_Message_after_Logout() throws Throwable {
		dashBoard.logoutSuccessfully();
	}

	@Then("^User should not able to see 'Your Account' Option$")
	public void i_am_not_able_to_see_Your_Account_Option() throws Throwable {
		dashBoard.yourAccountShouldNotVisible();
	}

	@When("^User Click on 'Submit a meter reading' from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_from_Dashboard() throws Throwable {
		dashBoard.dashBoardOptionsClick("Submit a meter reading");
	}

	@Then("^User Should Move to Submit Meter Reading Page$")
	public void i_Should_Move_to_Submit_Meter_Reading_Page() throws Throwable {
		dashBoard.submitMeterReadingPageOpen();
	}

	@When("^User Click on 'Make a payment' from Dashboard$")
	public void i_Click_on_Make_a_payment_from_Dashboard() throws Throwable {
		dashBoard.dashBoardOptionsClick("Make a payment");
	}

	@Then("^User Should Move to Payment Page$")
	public void i_Should_Move_to_Payment_Page() throws Throwable {
		dashBoard.makePaymentPageOpen();
	}

	@When("^User Click on 'Tell us you are moving' from Dashboard$")
	public void User_Click_on_moving_from_Dashboard() throws Throwable {
		dashBoard.clickYouAreMovingButton();
	}

	@Then("^User Should Move to You are moving screen$")
	public void i_Should_Move_to_moving_screen() throws Throwable {
		dashBoard.closeAccountPageOpen();
	}

	// New Function

	@Then("^I Should See Quick Link for 'Set up a Direct Debit'$")
	public void i_Should_Quick_Link_for_Set_up_a_Direct_Debit() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("Set up a Direct Debit");
	}

	@And("^I Should See Quick Link for 'View bills/account statement'$")
	public void i_Should_Quick_Link_for_View_bills_account_statement() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("View bills/account statement");
	}

	@And("^I Should See Quick Link for 'View payment history'$")
	public void i_Should_Quick_Link_for_View_payment_history() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("View payment history");
	}

	@And("^I Should See Quick Link for 'Change paperless settings'$")
	public void i_Should_Quick_Link_for_Change_paperless_settings() throws Throwable {
		dashBoard.dashBoardQuickLinkFound("Change paperless settings");
	}

	@Then("^I Should See Quick Link for 'Make a payment'$")
	public void i_Should_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.dashBoardMakePaymentButton();
	}

	@Then("^I Should not see Quick Link for 'Make a payment'$")
	public void i_Should_not_see_Quick_Link_for_Make_a_payment() throws Throwable {
		dashBoard.dashBoardMakePaymentButtonNotDisplay();
	}

	@Then("^I Should See Quick Link for 'Amend Direct Debit'$")
	public void i_Should_See_Quick_Link_for_Amend_Direct_Debit() throws Throwable {
		dashBoard.dashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Struggling to pay'$")
	public void i_Should_Quick_Link_for_Struggling_to_pay() throws Throwable {
		dashBoard.dashBoardStruggglingToPay();
	}

	@And("^I Should See Quick Link for 'Submit a meter reading'$")
	public void i_Should_Quick_Link_for_Submit_a_meter_reading() throws Throwable {
		dashBoard.dashBoardSubmitReading();
	}

	@And("^I Should See Quick Link for 'Tell us you are moving'$")
	public void i_Should_Quick_Link_for_Tell_us_you_are_moving() throws Throwable {
		dashBoard.dashBoardMovingLink();
	}

	@And("^I Should See Quick Link for 'Contact us'$")
	public void i_Should_Quick_Link_for_Contact_us() throws Throwable {
		dashBoard.dashBoardFooterButton("Contact us");
	}

	@And("^I Should See Quick Link for 'Find out more'$")
	public void i_Should_Quick_Link_for_Find_out_more() throws Throwable {
		dashBoard.dashBoardFooterButton("Find out more");
	}

	@And("^I Should See Quick Link for 'How to keep it clear'$")
	public void i_Should_Quick_Link_for_How_to_keep_it_clear() throws Throwable {
		dashBoard.dashBoardFooterButton("How to keep it clear");
	}

	@Then("^I Should See Latest Bill$")
	public void i_Should_See_Latest_Bill() throws Throwable {
		dashBoard.dashBoardLatestBillMainHeading();
	}

	@And("^Latest Bill Amount$")
	public void latest_Bill_Amount() throws Throwable {
		dashBoard.dashBoardLatestBillAmount();
	}

	@And("^Latest Bill Date$")
	public void latest_Bill_Date() throws Throwable {
		dashBoard.dashBoardLatestBillDate();
	}

	@Then("^I Should Customer Number on dashboard$")
	public void i_Should_Customer_Number_on_dashboard() throws Throwable {
		dashBoard.dashBoardCustomerReferenceNumber();

	}

	@And("^Payment Reference Number on dashboard$")
	public void payment_Reference_Number_on_dashboard() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoard.dashBoardPaymentReferenceNumber();
	}

	@Then("^I Should See Amount Due Label on Dashboard$")
	public void i_Should_See_Amount_Due_Label_on_Dashboard() throws Throwable {
		dashBoard.dashBoardBillDueLabel();
	}

	@And("^Latest Bill Amount Due on Dashboard$")
	public void latest_Bill_Amount_Due_on_Dashboard() throws Throwable {
		dashBoard.dashBoardBillAmount();
	}

	@And("^Bill Date on Date$")
	public void bill_Date_on_Date() throws Throwable {
		dashBoard.dashBoardBillAmountDate();
	}

	@Then("^i Should see latest Bill Date, Due Dates are same$")
	public void i_Should_see_latest_Bill_Date_Due_Dates_are_same() throws Throwable {
		dashBoard.matchBillDateAndDueDateisSame();
	}

	@Then("^I Should see the Meter Reading Heading$")
	public void i_Should_see_the_Meter_Reading_Heading() throws Throwable {
		dashBoard.meterReadingHeading();
	}

	@And("^Last Meter Reading label with Value$")
	public void last_Meter_Reading_label_with_Value() throws Throwable {
		dashBoard.meterReadingLabelAndValues();
	}

	@And("^Meter Number label with Value$")
	public void meter_Number_label_with_Value() throws Throwable {
		dashBoard.meterNumberLabelAndValues();
	}

	@And("^Date Last Read label with Value$")
	public void date_Last_Read_label_with_Value() throws Throwable {
		dashBoard.meterReadLabelAndValues();
	}

	@Given("^I have open login page$")
	public void i_have_open_login_page() throws Throwable {
		login.OpenLoginPage();
	}

	@And("^Login With  my ([^\"]*) and ([^\"]*)$")
	public void login_With_my_Kumar_devesh_yahoo_com_and_Apple(String email, String password) throws Throwable {
		login.enterEmailAndPassword(email, password);
	}

	@And("^User Click Change Paperless Setting$")
	public void i_Click_Change_Paperless_Setting() throws Throwable {
		dashBoard.dashBoardQuickLinkClick("Change paperless settings");
	}

	@And("^User Should move to Paperless Setting Page$")
	public void i_Should_move_to_Paperless_Setting_Page() throws Throwable {
		Thread.sleep(7000);
		dashBoard.paperlessSettingPageOpen();
	}

	@When("^User Click on Update$")
	public void i_Click_on_Update() throws Throwable {
		Thread.sleep(4000);
		dashBoard.clickUpdateofPaperless();
	}

	@Then("^User Can See Thankyou Message$")
	public void i_Can_See_Thankyou_Message() throws Throwable {
		dashBoard.thankYouMessage();
	}

	@When("^User Click Set Up Direct Debit$")
	public void i_Click_Set_Up_Direct_Debit() throws Throwable {
		dashBoard.dashBoardQuickLinkClick("Set up a Direct Debit ");
	}
	@When("^User Click Set Up Direct Debit from menu$")
	public void i_Click_Set_Up_Direct_Debit_menu() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MenuClick");
		 webDriver.getwebelement(locator).click();
		 locator = loginLoct.getlocator("//locators/DDMenuClick");
		 webDriver.getwebelement(locator).click();
		
	}

	@Then("^User Should move to Setup Direct Debit Page$")
	public void i_Should_move_to_Setup_Direct_Debit_Page() throws Throwable {
		dashBoard.setupDirectDebitPageOpen();
	}
	@When("^User enter correct bank details for direct debit$")
	public void user_enter_correct_bank_details_for_direct_debit() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/AccountHolderName");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("Fiona Vardy");
		 locator = loginLoct.getlocator("//locators/sortcodeone");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("20");
		 locator = loginLoct.getlocator("//locators/sortcodetwo");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("00");
		 locator = loginLoct.getlocator("//locators/sortcodethree");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("00");
		 locator = loginLoct.getlocator("//locators/bankaccount");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("55779911");
		 locator = loginLoct.getlocator("//locators/CommonContinue");
		 webDriver.getwebelement(locator).click();
		 locator = loginLoct.getlocator("//locators/ConfirmButton");
		 webDriver.getwebelement(locator).click();
		 
	}
	
	@When("^User click continue without filling bank details for direct debit$")
	public void user_click_continue_without_filling_bank_details_for_direct_debit() throws Throwable 
	{
		

		String locator = loginLoct.getlocator("//locators/AccountHolderName");
		 webDriver.getwebelement(locator).clear();
		 locator = loginLoct.getlocator("//locators/sortcodeone");
		 webDriver.getwebelement(locator).clear();
		 locator = loginLoct.getlocator("//locators/sortcodetwo");
		 webDriver.getwebelement(locator).clear();
		 locator = loginLoct.getlocator("//locators/sortcodethree");
		 webDriver.getwebelement(locator).clear();
		 locator = loginLoct.getlocator("//locators/bankaccount");
		 webDriver.getwebelement(locator).clear();
		 
	
		
		
		 locator = loginLoct.getlocator("//locators/CommonContinue");
		 webDriver.getwebelement(locator).click();
	}
	

	@Then("^User should be presented with validation messages for mandatory bank details required for DD setup$")
	public void user_should_be_presented_with_validation_messages_for_mandatory_bank_details_required_for_DD_setup() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/AccountHolderValidation");
		String txt=  webDriver.getwebelement(locator).getText();
		if(txt.contains("Please enter the name of the account holder"))
		{
			locator = loginLoct.getlocator("//locators/SortCodeValidation");
			txt = webDriver.getwebelement(locator).getText();
			if(txt.contains("Please enter the sort code"))
			{
				locator = loginLoct.getlocator("//locators/AccountNumberValidation");
				txt = webDriver.getwebelement(locator).getText();
				if(txt.contains("Please enter the account number"))
				{
				System.out.println("All validation checked");
				assert true;
				}
			}
		}
		
	}
	

	@Then("^User should be able to setup direct debit successfully$")
	public void user_should_be_able_to_setup_direct_debit_successfully() throws Throwable 
	{
	
		String locator = loginLoct.getlocator("//locators/DDReview");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Fiona Vardy"))
		{
			System.out.println("Check 1");
		}
		locator = loginLoct.getlocator("//locators/Confirmation");
		String txt1 = webDriver.getwebelement(locator).getText();
		if(txt1.contains("Confirmation"))
		{
			System.out.println("Check 2");
		}
		
	}
	
	
	@When("^User enter incorrect bank details for direct debit$")
	public void user_enter_incorrect_bank_details_for_direct_debit() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/AccountHolderName");
		webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("Testing");
		 locator = loginLoct.getlocator("//locators/sortcodeone");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/sortcodetwo");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/sortcodethree");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/bankaccount");
		 webDriver.getwebelement(locator).clear();
		 webDriver.getwebelement(locator).sendKeys("11111111");
		 locator = loginLoct.getlocator("//locators/CommonContinue");
		 webDriver.getwebelement(locator).click();
		 locator = loginLoct.getlocator("//locators/ConfirmButton");
		 webDriver.getwebelement(locator).click();
		 
	}

	@Then("^User should be presented with the error message for incorrect bank details$")
	public void user_should_be_presented_with_the_error_message_for_incorrect_bank_details() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/ValidationDirectDebit");
		 String txt = webDriver.getwebelement(locator).getText();
		 if(txt.contains("unable to set up your Direct Debit Instructions"))
		 {
		 locator = loginLoct.getlocator("//locators/ValidationTextDD");
		 txt = webDriver.getwebelement(locator).getText();		 
		 }
		 if(txt.contains("Sorry") || txt.contains("bank account details you’ve provided are incorrect"))
		 {
			 assert true;
		 }
		
	}
	

	@When("^User Click Contact us$")
	public void i_Click_Contact_us() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Contact us");
	}

	@Then("^Contact Us page should open in new tab$")
	public void contact_Us_page_should_open_in_new_tab() throws Throwable {
		dashBoard.contactUsPageOpenInNewTab();
	}

	@When("^User Click Discover ways to save$")
	public void i_Click_Discover_ways_to_save() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Discover ways to save");
	}

	@Then("^Save Water page should open in new tab$")
	public void save_Water_page_should_open_in_new_tab() throws Throwable {
		dashBoard.saveWaterPageOpenInNewTab();
	}

	@When("^User Click Learn more$")
	public void i_Click_Learn_more() throws Throwable {
		dashBoard.dashBoardFooterButtonClick("Learn more");
	}

	@Then("^How to prevent blockage page should open in new tab$")
	public void how_to_prevent_blockagepage_should_open_in_new_tab() throws Throwable {
		dashBoard.preventBlockagePageOpenInNewTab();
	}

	@When("^I Click Set Up your Profile$")
	public void i_Click_Set_Up_your_Profile() throws Throwable {
		dashBoard.dashBoardOptionsClick("Update profile");
	}

	@Then("^User Should move to View Profile Page$")
	public void i_Should_move_to_View_Profile_Page() throws Throwable {
		dashBoard.updateProfilePageOpen();
	}

	@When("^User Click Set Up Payment history$")
	public void i_Click_Set_Up_Payment_history() throws Throwable {

		dashBoard.dashBoardOptionsClick("View payment history");
	}

	@Then("^User Should move to Payment history Page$")
	public void i_Should_move_to_Payment_history_Page() throws Throwable {

		dashBoard.paymentHistoryPageOpen();
	}

	// New Dashboard

	@Given("^User is on login page$")
	public void am_at_login_Page() throws Throwable {
		login.OpenLoginPage();
	}
	@Given("^User has logged in successfully$")
	public void user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortal();
		login.clickOnLogin();
		
	}
	
	//New code base 16-2-2021
	String locator, locateMe, latestBill, PreviousBill, billHistoryAmount, historicalBill;
	
	@When("^([^\\\"]*) customer compare the last bill on dashboard and billing history$")
	public void customer_compare_last_bill_on_dashboard_and_billing_history(String usertype) throws Throwable 
	{
		if(usertype.equals("DirectDebit"))
		{}
		else if(usertype.equals("CashType"))
		{}
	}
	@Then("^([^\\\"]*) should confirm last bill	is being displayed on top in billing history$")
	public void confirm_last_bill_is_being_displayed_on_top_in_billing_history(String usertype) throws Throwable 
	{
		if(usertype.equals("DirectDebit"))
		{
			locator = loginLoct.getlocator("//locators/LatestBillAmount");
			latestBill = webDriver.getwebelement(locator).getText();
			
			latestBill= latestBill.substring(1);
			latestBill= latestBill.replaceAll("\\s.*", "");
			System.out.println("Latest bill is as per dashboard "+latestBill);
			
			dashBoard.dashBoardOptionsClick("View billing history");
			locator = loginLoct.getlocator("//locators/BillHistoryAmount");
			billHistoryAmount = webDriver.getwebelement(locator).getText();
			
			billHistoryAmount = billHistoryAmount.substring(1);
			billHistoryAmount = billHistoryAmount.replaceAll("\\s.*", "");
			System.out.println("Last bill as per billing history " +billHistoryAmount);
			float LB = Float.parseFloat(latestBill);
			float BHA = Float.parseFloat(billHistoryAmount);
			if(LB == BHA)
			{
				System.out.println("Validated amount with dashboard amount");
			}
		}
		else if(usertype.equals("CashType"))
		{

			
			locator = loginLoct.getlocator("//locators/LatestBillAmount");
			latestBill = webDriver.getwebelement(locator).getText();
			
			latestBill= latestBill.substring(1);
			latestBill= latestBill.replaceAll("\\s.*", "");
			System.out.println("Latest bill is as per dashboard "+latestBill);
			
			locateMe = loginLoct.getlocator("//locators/PreviousBill");
			PreviousBill = webDriver.getwebelement(locateMe).getText();
			
			PreviousBill= PreviousBill.substring(1);
			PreviousBill= PreviousBill.replaceAll("\\s.*", "");
			System.out.println("Previous bill as per dashboard "+PreviousBill);
		
			
			
			dashBoard.dashBoardOptionsClick("View billing history");
			locator = loginLoct.getlocator("//locators/BillHistoryAmount");
			billHistoryAmount = webDriver.getwebelement(locator).getText();
			
			billHistoryAmount = billHistoryAmount.substring(1);
			billHistoryAmount = billHistoryAmount.replaceAll("\\s.*", "");
			System.out.println("Last bill as per billing history " +billHistoryAmount);
			
			locateMe = loginLoct.getlocator("//locators/BillHistoryPrevious");
			historicalBill = webDriver.getwebelement(locateMe).getText();
			historicalBill = historicalBill.substring(1);
			historicalBill = historicalBill.replaceAll("\\s.*", "");
			System.out.println("Second last bill as per billing history" +historicalBill);
			float LB = Float.parseFloat(latestBill);
			float BHA = Float.parseFloat(billHistoryAmount);
			if(LB==BHA)
			{
				System.out.println("Validated amounts");
				LB = Float.parseFloat(PreviousBill);
				BHA = Float.parseFloat(historicalBill);
				if(LB==BHA)
				{
					System.out.println("Validated historical bill");
				}
			}
		}
	}
	
	
	@Given("^([^\\\"]*) customer has logged in successfully$")
	public void customer_has_logged_in_successfully(String usertype) throws Throwable 
	{
		if(usertype.equals("DirectDebit"))
		{
			metered_direct_debit_user_has_logged_in_successfully();
		}
		else if(usertype.equals("CashType"))
		{
			metered_cash_user_has_logged_in_successfully();
		}
	}

	@When("^([^\\\"]*) customer navigates to dashboard options$")
	public void customer_navigates_to_dashboard_options(String usertype) throws Throwable 
	{
		String locator;
		if(usertype.equals("DirectDebit"))
		{
			//check click of amend direct debit from dashboard
			locator = loginLoct.getlocator("//locators/AmendDDDashboard");
			webDriver.getwebelement(locator).click();
		}
		else if(usertype.equals("CashType"))
		{
			//check click of set up direct debit from dashboard
			locator = loginLoct.getlocator("//locators/SetupDDDashboard");
			webDriver.getwebelement(locator).click();
			
		}
	}

	@Then("^([^\\\"]*) customer is displayed provision to setup or amend direct debit as per the account setup$")
	public void customer_is_displayed_provision_to_setup_or_amend_direct_debit_as_per_the_account_setup(String usertype) throws Throwable 
	{
		String pageName, locator,checker;

		if(usertype.equals("DirectDebit"))
	{
			//Verify heading on the page setup direct debit or pagesource text
			Thread.sleep(300);	
			pageName= webDriver.CurrentURL();
			locator = loginLoct.getlocator("//locators/DirectDDHeading");
			checker = webDriver.getwebelement(locator).getText();
			
			if(pageName.contains("amend-direct-debit") && checker.contains("Amend Direct Debit"))
			{
				System.out.println("Checked heading and pagesource");
				assert true;
			}
			
	}
	else if(usertype.equals("CashType"))
	{
		//Verify heading on the page setup direct debit or pagesource text
		Thread.sleep(300);	
		pageName= webDriver.CurrentURL();
		locator = loginLoct.getlocator("//locators/DirectDDHeading");
		checker = webDriver.getwebelement(locator).getText();
		
		if(pageName.contains("set-up-direct-debit") && checker.contains("Set up Direct Debit"))
		{
			System.out.println("Checked heading and pagesource");
			assert true;
		}
		
	}
	
		
	}
	
	
	//15-2-2021
	
	@Given("^metered cash user has logged in successfully$")
	public void metered_cash_user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortalMeteredCash();
		login.clickOnLogin();
		
	}

	@When("^metered cash user navigates to payment history$")
	public void metered_cash_user_navigates_to_payment_history() throws Throwable 
	{
		dashBoard.dashBoardOptionsClick("View payment history");
		}

	@Then("^user should verify transaction history is showing payment received$")
	public void user_should_verify_transaction_history_is_showing_payment_received() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/PaymentReceived");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Payment received"))
		{
			System.out.println("Cheers completed");
			assert true;
			
		}
		
	}

	@Given("^unmetered user has logged in successfully$")
	public void unmetered_user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortalUnMetered();
		login.clickOnLogin();
		
	}
	
	@Given("^metered direct debit user has logged in successfully$")
	public void metered_direct_debit_user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortalDD();
		login.clickOnLogin();
		
	}

	@When("^metered DD user navigates to payment history$")
	public void metered_DD_user_navigates_to_payment_history() throws Throwable 
	{
		dashBoard.dashBoardOptionsClick("View payment history");
	}

	@Then("^user should verify transaction history is showing mode as direct debit$")
	public void user_should_verify_transaction_history_is_showing_mode_as_direct_debit() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/DirectDebitPayment");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Direct Debit"))
		{
			System.out.println("Cheers completed");
			assert true;
			
		}
		
	}

	@When("^unmetered user check the meter reading card on dashboard$")
	public void unmetered_user_check_the_meter_reading_card_on_dashboard() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MeterReadingHeading");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Meter reading"))
		{
			System.out.println("Checked");
		}
		
	
	}

	@Then("^unmetered user should verify the account is not metered$")
	public void unmetered_user_should_verify_the_account_is_not_metered() throws Throwable 
	{
		//Check meter reading card text showing unmetered account
		String locator = loginLoct.getlocator("//locators/UnmeterHeading");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("This account is not metered"))
		{
			System.out.println("Checked again");
			assert true;
		}
		
	}
	@Given("^metered user has logged in successfully$")
	public void metered_user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortalMetered();
		login.clickOnLogin();
	}

	@When("^metered user check the meter reading card on dashboard$")
	public void metered_user_check_the_meter_reading_card_on_dashboard() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MeterReadingHeading");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Meter reading"))
		{
			System.out.println("Checked heading");
		}
		
	}

	@Then("^metered user should verify the last meter reading,meter number and date last read$")
	public void metered_user_should_verify_the_last_meter_reading_meter_number_and_date_last_read() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/LastMeterReadingValue");
		String txt = webDriver.getwebelement(locator).getText();
		int meterReading = Integer.parseInt(txt);
		if(meterReading> 0)
		{
			System.out.println("Meter Reading is greater than zero");
			locator = loginLoct.getlocator("//locators/MeterNumberValue");
			txt = webDriver.getwebelement(locator).getText();
			meterReading = Integer.parseInt(txt);
			if(meterReading == 8093500)
			{
				System.out.println("Meter number has been verified");
				locator = loginLoct.getlocator("//locators/LastReadDate");
				txt = webDriver.getwebelement(locator).getText();
				if(txt.contains("20"))
				{
					System.out.println("Last read date has been verified");
				}
				
			}
			
		}
		
	}

	
	@Given("^assessed user has logged in successfully$")
	public void assessed_user_has_logged_in_successfully() throws Throwable 
	{
		login.OpenLoginPage();
		login.loginPortalAssessed();
		login.clickOnLogin();
		
	}

	@When("^assessed user check the meter reading card on dashboard$")
	public void assessed_user_check_the_meter_reading_card_on_dashboard() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MeterReadingHeading");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("Meter reading"))
		{
			System.out.println("Checked");
		}
		
	}

	@Then("^assessed user should verify the account is not metered$")
	public void assessed_user_should_verify_the_account_is_not_metered() throws Throwable 
	{
		//Check meter reading card text showing unmetered account
		String locator = loginLoct.getlocator("//locators/UnmeterHeading");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("This account is not metered"))
		{
			System.out.println("Checked again");
			assert true;
		}
		
	}

	@When("^assessed user select move out with change address option$")
	public void assessed_user_select_move_out_with_change_address_option() throws Throwable 
	{

		dashBoard.clickYouAreMovingButton();
		String locator = loginLoct.getlocator("//locators/ChangeAddress");
		webDriver.getwebelement(locator).click();
		
	}

	@Then("^assessed user should verify meter reading is not displayed on Your final bill screen$")
	public void assessed_user_should_verify_meter_reading_is_not_displayed_on_Your_final_bill_screen() throws Throwable 
	{
		Date date = new Date(); 
		date.setDate(date.getDate()+2); 
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY"); 
		String formattedDate = df.format(date);        
		System.out.println(formattedDate);
		
		String locator = loginLoct.getlocator("//locators/MovingDate");
		webDriver.getwebelement(locator).sendKeys(formattedDate);
		locator = loginLoct.getlocator("//locators/CommonContinue");
		 webDriver.getwebelement(locator).click();
		 
		 locator = loginLoct.getlocator("//locators/FinalBill");
		 String txt = webDriver.getwebelement(locator).getText();
		 if(txt.contains("final bill"))
		 {
			 locator = loginLoct.getlocator("//locators/NoMeterText");
			 txt = webDriver.getwebelement(locator).getText();
			 if(txt.contains("doesn’t have a water meter, we’ll calculate your final bill amount based on your moving date"))
			 {
				 assert true;
				 
			 }
		 }
		 
	}
	
	
	
	
	//15-2-2021
	
		
	 @When("^User Click on 'Tell us you are moving' from menu$")
		public void User_Click_on_moving_from_menu() throws Throwable 
	 {
		 String locator = loginLoct.getlocator("//locators/MenuClick");
		 webDriver.getwebelement(locator).click();
	     locator = loginLoct.getlocator("//locators/MovingClick");
		 webDriver.getwebelement(locator).click();	

	 }
	@When("^User click on Change your address button$")
	public void user_click_on_Change_your_address_button() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/ChangeAddress");
		webDriver.getwebelement(locator).click();
		
	}
	
	@Then("^User should be presented with success message for move out process$")
	public void user_should_be_presented_with_success_message_for_move_out_process() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/UpdatedAccount");
		String txt = webDriver.getwebelement(locator).getText();
		locator = loginLoct.getlocator("//locators/Confirmation");
		String txt1 = webDriver.getwebelement(locator).getText();
		if(txt.contains("updated account") && txt1.contains("Confirmation"))
		{
			System.out.println("Passed all good");
		}
	}

	@Then("^User should be navigated to moving from page$")
	public void user_should_be_navigated_to_moving_from_page() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MovingFrom");
		String source = webDriver.CurrentURL();
		String txt = webDriver.getwebelement(locator).getText();
		if(source.contains("move-within/moving-from") && txt.contains("Moving"))
		{
			System.out.println("Pass");
		}
		
	}
	@SuppressWarnings("deprecation")
	@When("^User enter a move out date more than thirty days from current date$")
	public void user_enter_a_move_out_date_more_than_thirty_days_from_current_date() throws Throwable 
	{
		Date date = new Date(); 
		date.setDate(date.getDate()+40); 
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY"); 
		String formattedDate = df.format(date); 
		System.out.println(formattedDate);
		
		String locator = loginLoct.getlocator("//locators/MovingDate");
		webDriver.getwebelement(locator).sendKeys(formattedDate);
		
		locator = loginLoct.getlocator("//locators/CommonContinue");
		webDriver.getwebelement(locator).click();
		
	}

	@Then("^User should be presented with error message stating to inform move out thirty days before$")
	public void user_should_be_presented_with_error_message_stating_to_inform_move_out_thirty_days_before() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/MovingDateValidation");
		String txt = webDriver.getwebelement(locator).getText();
		if(txt.contains("you’re moving 30 days before"))
		{
			System.out.println("Pass");
		}
	}
	

	@Then("^User should see option to Change address on move in page$")
	public void user_should_see_option_to_Change_address_on_move_in_page() throws Throwable 
	{
		String locator = loginLoct.getlocator("//locators/ChangeAddress");
		String message = webDriver.getwebelement(locator).getText();
		if(message.contains("Change your address"))
		{
			System.out.println("Pass");
		}
	}

	@And("^User enters login credentials$")
	public void login_with_Credentials() throws Throwable {
		Map<String, HashMap<String, String>> DataSet=excel.ReadTestData("Dashboard");
		System.out.println("");
		System.out.println(DataSet.size());
		HashMap<String, String>map=DataSet.get("NDD");
		System.out.println(map.get("Email"));
		System.out.println(map.get("Password"));
		login.enterEmailAndPassword(map.get("Email"), map.get("Password"));
	}

	@Then("^User can see the QuickLinks ([^\"]*) on Dashboard$")
	public void i_can_see_the_QucikLinks(String links) throws Throwable {
		String[] Listlinks = links.split(",");
		//dashBoard.MakeMenuDisplay();
		for (int i = 0; i < Listlinks.length; i++) {
			String temp = Listlinks[i].trim();
			System.out.println(temp);
			dashBoard.dashBoardQuickLinkFound(temp.trim());

		}
	}

	@Then("^User can see Customer Number,Payment Reference on Dashboard$")
	public void customer_Number_Payment_Reference_on_Dashboard() throws Throwable {
		dashBoard.dashBoardPaymentReferenceNumber();
		dashBoard.dashBoardCustomerReferenceNumber();
	}

	@Then("^User Can see Customer Email ID, Correspondence Address under your profile section$")
	public void i_Can_see_Customer_Email_ID_Correspondence_Address_under_your_profile_section() throws Throwable {
		dashBoard.yourProfileHeadingDashBoard();
		dashBoard.yourProfileEmailHeadingAndEmailID();
		dashBoard.yourProfileAddressLabelAndValue();

	}

	@Then("^User Can see Last Meter Reading, Meter Number, Date last Read$")
	public void i_Can_see_Last_Meter_Reading_Meter_Number_Date_last_Read() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoard.meterReadingHeading();
		dashBoard.meterReadingLabelAndValues();
		dashBoard.meterNumberLabelAndValues();
		dashBoard.meterReadLabelAndValues();

	}

	@Then("^User Can see Property address, Your Services$")
	public void i_Can_see_Property_address_Your_Services() throws Throwable {
		dashBoard.accountDetailsSectionVerification();
	}

	@Then("^User Can see Latest Bill, Bill Amount, Bill Date$")
	public void i_Can_see_Latest_Bill_Bill_Amount_Bill_Date() throws Throwable {
		dashBoard.dashBoardLatestBillMainHeading();
		dashBoard.dashBoardLatestBillAmount();
		dashBoard.dashBoardLatestBillDate();
	}

	@Then("^User Can see Amount Due, Amount, date$")
	public void i_Can_see_Amount_Due_Amount_date() throws Throwable {
	try
	{
		dashBoard.dashBoardBillDueLabel();
		dashBoard.dashBoardBillAmount();
		dashBoard.dashBoardBillAmountDate();
	}
	catch (Exception e)
	{
		
	}
	}

	@Then("^User Can See Following Menu ([^\"]*) Items$")
	public void i_Can_See_Following_Menu_Items(String MenuList) throws Throwable {
		String[] Listlinks = MenuList.split(",");
		for (int i = 0; i < Listlinks.length; i++) {
			String temp = Listlinks[i].trim();
			temp = temp.replace("_", "'");
			System.out.println(temp);
			dashBoard.dashBoardOptionsVerification(temp.trim());

		}
	}

	@And("^User Click View bills/Account statement$")
	public void i_Click_View_bills_Account_statement() throws Throwable {
		dashBoard.dashBoardOptionsClick("View account statement");
	}

	@Then("^User Should move to View Bill Account Statement Page$")
	public void i_Should_move_to_View_Bill_Account_Statement_Page() throws Throwable {
		dashBoard.yourViewBillsPageOpen();
	}

	@And("^User Click on 'Submit a meter reading' button from Dashboard$")
	public void i_Click_on_Submit_a_meter_reading_button_from_Dashboard() throws Throwable {
		dashBoard.clickSubmitMeterReadingButton();
	}

	@And("^User Click on 'Tell us you are moving' button from Dashboard$")
	public void i_Click_on_Tell_us_you_are_moving_button_from_Dashboard() throws Throwable {
		dashBoard.clickYouAreMovingButton();
	}

	@And("^User Click on 'Make a payment' button from Dashboard$")
	public void i_Click_on_Make_a_payment_button_from_Dashboard() throws Throwable {

		dashBoard.clickMakeAPaymentButton();
	}

	@When("^User Click 'View Profile' button from Dashboard$")
	public void i_Click_View_Profile_button_from_Dashboard() throws Throwable {
		dashBoard.clickViewProfileButton();

	}
	
	@Given("^User Login with ([^\"]*) Credentials$")
	public void login_with_Non_DD_Credentials(String CustType) throws Throwable {
		login.loginCustomerType(CustType);
	}
	
	@When("^User Click update Profile$")
	public void i_Click_update_Profile() throws Throwable {
		dashBoard.dashBoardOptionsClick("Update profile");
	}
	
	@And("^User Can see Struggling to Pay,Amend Direct Debit$")
	public void i_Can_see_Struggling_to_Pay_Amend_Direct_Debit() throws Throwable {
		dashBoard.dashBoardStruggglingToPay();
		dashBoard.dashBoardAmendDirectDebit();
	    
	}
	@And("^User Can see Meter Reading, This account is not metered$")
	public void i_Can_see_Meter_Reading_This_account_is_not_metered() throws Throwable {
		dashBoard.meterReadingHeading();
		dashBoard.unMeterReadingHeading();
	}
	
	@And("^User Click Struggling to Pay$")
	public void i_Click_Struggling_to_Pay() throws Throwable {
		dashBoard.struggglingToPayClick();
	}

	@Then("^Struggling to Pay page should open in new tab$")
	public void struggling_to_Pay_page_should_open_in_new_tab() throws Throwable {
		dashBoard.strugglingPageOpenInNewTab();
	}

}
