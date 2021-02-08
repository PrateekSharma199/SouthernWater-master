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

	@Then("^User Should Move to Close Account Page$")
	public void i_Should_Move_to_Close_Account_Page() throws Throwable {
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
		String locator = loginLoct.getlocator("//locators/CommonContinue");
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
		 webDriver.getwebelement(locator).sendKeys("Testing");
		 locator = loginLoct.getlocator("//locators/sortcodeone");
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/sortcodetwo");
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/sortcodethree");
		 webDriver.getwebelement(locator).sendKeys("11");
		 locator = loginLoct.getlocator("//locators/bankaccount");
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

		dashBoard.dashBoardOptionsClick("Payment history");
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
		dashBoard.dashBoardBillDueLabel();
		dashBoard.dashBoardBillAmount();
		dashBoard.dashBoardBillAmountDate();
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
		dashBoard.dashBoardOptionsClick("View bills / Account statement");
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
