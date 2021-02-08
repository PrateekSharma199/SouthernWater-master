package pageHelper.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import core.apiHelper;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import pageFunctions.web.CloseAccountFunctions;
import pageFunctions.web.MoveInFunction;
import pageFunctions.web.RegistrationFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class MoveInPageHelper {

	public webHelper webDriver;
	public CloseAccountFunctions closeAcc;
	private bddDriver DriverInstance;
	public MoveInFunction moveIN;
	public RegistrationFunctions reg;
	private xmlreader loginLoct = new xmlreader("src\\test\\resources\\locators\\Login.xml");
	PropertyReader prpertyreader = new PropertyReader();
	String TestFirstName = "TestFirstName";
	String TestMiddleName = "TestMiddleName";
	String TestLastName = "TestLastName";
	String CustomerEmailAddress = "neeraj.m@360logica.com";
	Integer NumberOfOccupants = 3;
	Integer AccountNumber = 55779911;

	public MoveInPageHelper(WebDriver driver) throws IOException {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		moveIN = new MoveInFunction(webDriver);
		reg=new RegistrationFunctions(webDriver);
	}

	public MoveInPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		moveIN = new MoveInFunction(webDriver);
		reg=new RegistrationFunctions(webDriver);
	}

	@Given("^I am on create an account page$")
	public void NavigateToMoveInAccountPage() throws Exception {
		moveIN.openMoveInPage();
	}

	@And("^User click on Start button$")
	public void ClickOnStartButton() throws InterruptedException, DocumentException, Exception {
		moveIN.startClick();
	}

	@When("^User fill all moving details$")
	public void FillCustomerMoveInDetails() throws Exception {
		moveIN.fillMoveINDetails("SO22 5JN", "10 GODWIN");

		moveIN.enterMoveINDate();

		moveIN.enterOccupant();

		moveIN.commonContinue();

		moveIN.verifyYourDetailsSteps();

		moveIN.enterYourDetails("Mr", TestFirstName, TestMiddleName, TestLastName, "09/12/1980", "901590951",
				CustomerEmailAddress);

		moveIN.commonContinue();

	}

	@And("^I fill all the payment details$")
	public void CustomerPaymentDetails() throws InterruptedException, DocumentException, Exception {
		moveIN.enterCustomerPaymentDetails("testAccountHolderName", "20", "00", "00", String.valueOf(AccountNumber));

		moveIN.commonContinue();
	}

	@Then("^I Should be able to move in$")
	public void CustomerIsAbleToMoveIn() throws InterruptedException, DocumentException, Exception {
		moveIN.verifyMoveINDetails(TestFirstName, TestMiddleName, TestLastName, CustomerEmailAddress,
				String.valueOf(NumberOfOccupants), String.valueOf(AccountNumber));

		moveIN.confirmDetailButton();

	}

	// Scenario: Verify that user is able to move to Moving details page
	@Given("^I am on a create an account page$")
	public void NavigateToCreateAccountPage() throws Exception {
		moveIN.openMoveInPage();
	}

	@When("^I click on Start button to Moving details page$")
	public void ClickOnStartButton3() throws InterruptedException, DocumentException, Exception {
		moveIN.startClick();
	}

	@Then("^I should be able to move to Moving details page$")
	public void VerifyMovingDetailsPage() throws Exception {
		moveIN.verifyMoveInDetailPageLoaded();
	}

	// Scenario: Verify that user will get error messages on Moving details page for
	// not filling any values
	@Given("^I am on Moving details page$")
	public void NavigateToMovingDetailsPage() throws Exception {
		moveIN.openMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();

	}

	@When("^I clicked on Continue button$")
	public void ClickOnContinueButton() throws InterruptedException, DocumentException, Exception {
		moveIN.commonContinue();
	}

	@Then("^I should be able to see error messages on Moving details page for not filling any values$")
	public void VerifyErrorMessagesOnMovingDetailsPage() throws Exception {
		moveIN.verifyMandatoryFieldsMessage();
	}

	// Scenario Outline: Verify that user will get error message on Moving details
	// page for not entering valid value in postcode
	@Given("^I am on the Moving details page$")
	public void MoveToDetailsPage() throws Exception {
		moveIN.openMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();
	}

	@When("^User enter invalid ([^\"]*) in Enter the postcode$")
	public void EnterInvalidPostcode(String postcode) throws InterruptedException, DocumentException, Exception {
		moveIN.enterPostCode(postcode);
	}

	@And("^User click on Find address button$")
	public void ClickOnFindAddressButton() throws InterruptedException, DocumentException, Exception {
		moveIN.findAddressClick();
	}

	@Then("^User should be able to see error messages on Moving details page for invalid postcode$")
	public void VerifyErrorMessagesOnMovingDetailsPageForInvalidPostcode() throws Exception {
		moveIN.inValidAddressMessage();
	}

	// Scenario: Verify that user will get error messages on Moving details page for
	// not selecting an address
	@Given("^I am on the moving details page$")
	public void MovingToDetailsPage() throws Exception {
		moveIN.openMoveInPage();
		moveIN.startClick();
		moveIN.verifyMoveInDetailPageLoaded();
	}

	@When("^I am not selecting the address$")
	public void DoNotSelectAddress() throws InterruptedException, DocumentException, Exception {
		Thread.sleep(2000);
		moveIN.enterPostCode("SO22 5JN");
		moveIN.findAddressClick();
		moveIN.verifyEnterAddressManually();

	}

	@And("^I clicked on the Continue button$")
	public void ClickedOnContinueButton() throws InterruptedException, DocumentException, Exception {
		moveIN.commonContinue();
	}

	@Then("^I should be able to see error messages on Moving details page$")
	public void ErrorMessagesOnMovingDetailsPage() throws Exception {
		Thread.sleep(2000);
		webDriver.WaitforPageToBeReady();
		moveIN.pleaseSelectAddressAndOtherErrorMessage();
	}

	// New Test Cases

	@Given("^User have open the move-in page$")
	public void i_have_open_the_move_in_page() throws Throwable {
		moveIN.openMoveInPage();
	}

	@And("^User enter Address post code ([^\"]*)$")
	public void i_enter_Address_post(String postcode) throws Throwable {
		moveIN.enterPostCode(postcode);
	}

	@And("^User Select my Address ([^\"]*) from address list$")
	public void i_Select_my_Address_Logica_from_address_list(String address) throws Throwable {
		System.out.print(address);
		moveIN.selectAddress(address);
	}

	@And("^User Enter my  moving date$")
	public void i_Enter_my_moving_date() throws Throwable {
		moveIN.enterMoveINDate();
	}

	@And("^User Select Correspondence address yes$")
	public void i_Select_Correspondence_address_yes() throws Throwable {
		// moveIN.SelectAddress(address);
	}

	@And("^User Enter Number of occupant$")
	public void i_Enter_Number_of_occupant() throws Throwable {
		moveIN.enterOccupant();
	}

	@SuppressWarnings("deprecation")
	@When("^User fills the mandatory details for move out$")
	public void user_fills_the_mandatory_details_for_move_out() throws Throwable 
	{
		Date date = new Date(); 
		date.setDate(date.getDate()+2); 
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY"); 
		String formattedDate = df.format(date);        
		System.out.println(formattedDate);
		
		String locator = loginLoct.getlocator("//locators/MovingDate");
		webDriver.getwebelement(locator).sendKeys(formattedDate);
		
		moveIN.commonContinue();
		Thread.sleep(800);
		moveIN.commonContinue();
		//Add address step
		moveIN.enterPostCode("PO16 7GZ");
		moveIN.findAddressClick();
		moveIN.selectAddress();
		Thread.sleep(800);
		locator = loginLoct.getlocator("//locators/MovingDate");
		webDriver.getwebelement(locator).sendKeys(formattedDate);
		moveIN.enterOccupant();		
		moveIN.commonContinue();
		moveIN.confirmDetailButton();
		
	}

	@And("^User Click Continue in MoveIN$")
	public void i_Click_Continue_MoveIN() throws Throwable {
		moveIN.commonContinue();
	}

	@And("^User Enter NameTitle ([^\"]*) FirstName ([^\"]*) MName ([^\"]*) LName ([^\"]*) Date of Birth([^\"]*) PhoneNumber ([^\"]*) email ([^\"]*)$")
	public void i_Enter_Title_Mr_FirstName_FTest_LName_LTest_Date_of_Birth_PhoneNumber_email_test_yahoo_com(
			String NTitle, String FName, String MName, String LName, String DOB, String PNumber, String email)
			throws Throwable {
		moveIN.enterYourDetails(NTitle, FName, MName, LName, DOB, PNumber, email);
	}

	@And("^User Select Direct Debit as Yes$")
	public void select_Direct_Debit_as_Yes() throws Throwable {
		moveIN.selectDebitasYes();
	}

	@And("^User Enter BankDetail ([^\"]*) Sort Code ([^\"]*) Account Number ([^\"]*)$")
	public void i_Enter_BankDetail_FTest_Sort_Code_Account_Number(String FName, String SortCode, String AccNumber)
			throws Throwable {
		String fcode = SortCode.substring(0, 2);
		String scode = SortCode.substring(2, 4);
		String tcode = SortCode.substring(4, 6);
		moveIN.enterCustomerPaymentDetails(FName, fcode, scode, tcode, AccNumber);
	}

	@Given("^User Select Pay in Monthly Statement$")
	public void i_Select_Pay_in_Monthly_Statement() throws Throwable {

	}

	@When("^User Click Confirm Details$")
	public void i_Click_Confirm_Details() throws Throwable {
		moveIN.confirmDetailButton();
	}

	@Then("^User Should Movin$")
	public void i_Should_Movin() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^Customer ID, Payment Referecne depict on Screen$")
	public void customer_ID_Payment_Referecne_depict_on_Screen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@And("^Customer ID, Payment Reference depict on Screen$")
	public void customer_ID_Payment_Reference_depict_on_Screen() throws Throwable {

		moveIN.verifyCustomeridGenerated();

	}

	@Then("^User Should  See Activation Mail send on my EmailID Message$")
	public void i_Should_See_Activation_Mail_send_on_my_EmailID_Message() throws Throwable {

		moveIN.verifyEmailMessage();
	}

	@And("^Click on Finish$")
	public void click_on_Finish() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		moveIN.clickonFinish();
	}

	@And("^Confirmation Message$")
	public void confirmation_Message() throws Throwable {
		moveIN.confirmationMessage(); // Write code here that turns the phrase above into concrete actions

	}

	@And("^User Select Direct Debit as No$")
	public void Select_DebitAsNo() throws InterruptedException, DocumentException {
		moveIN.selectDebitasNo();
	}

	@And("^User Select Correspondence address No$")
	public void i_Select_Correspondence_address_No() throws Throwable {
		moveIN.correspondenceAddNo();
	}

	@And("^User enter Correspodant Address post code ([^\"]*)$")
	public void i_enter_Correspodant_Address_post_code_SO_JY(String CorCode) throws Throwable {
		moveIN.correspondanceCode(CorCode);
	}

	@And("^Use Select my Correspodant Address ([^\"]*) from address list$")
	public void i_Select_my_Correspodant_Address_from_address_list(String address) throws Throwable {
		moveIN.selectCorresponAdd(address);
	}

	@Given("^User Select my Address from address list$")
	public void i_Select_my_Address_from_address_list() throws Throwable {
		moveIN.selectAddress();
	}

	@Then("^User can see Mobile and Home number for Contact Details$")
	public void i_can_see_Mobile_and_Home_number_for_Contact_Details() throws Throwable {
		moveIN.mobileHomeContactPresent();
	}

	@Then("^User can select one at a time$")
	public void i_can_select_one_at_a_time() throws Throwable {
		moveIN.verifyToggelingMobileHomeToggelButton();
	}

	@When("^Click on Title$")
	public void click_on_Title() throws Throwable {
		moveIN.clickOnTitle();
	}

	@Then("^I can See Title Dropdow with Miss,Mr,Mrs,Ms,Dr\\.,Prof$")
	public void i_can_See_Title_Dropdow_with_Miss_Mr_Mrs_Ms_Dr_Prof() throws Throwable {
		moveIN.verifyTitleOptions();
	}

	@When("^I Select Direct Debit as Yes$")
	public void i_Select_Direct_Debit_as_Yes() throws Throwable {
		moveIN.selectDebitasYes();
	}

	@Then("^I can See 'Pay in monthly installments'$")
	public void i_can_See_Pay_in_monthly_installments() throws Throwable {
		moveIN.verifyPayInMonthlyInstall();
	}

	@And("^'Pay in Full'$")
	public void pay_in_Full() throws Throwable {
		moveIN.verifyPayInFull();
	}

	@And("^I am able to select to 'Pay in monthly installments'$")
	public void i_am_able_to_select_to_Pay_in_monthly_installments() throws Throwable {
		moveIN.selectPayInMonthlyInstall();
	}

	@And("^I am able to select to 'Pay in Full'$")
	public void i_am_able_to_select_to_Pay_in_Full() throws Throwable {
		moveIN.selectPayInFull();
	}

	@And("^I select to 'Pay in monthly installments'$")
	public void i_select_to_Pay_in_monthly_installments() throws Throwable {
		moveIN.selectPayInMonthlyInstall();
	}

	@Then("^User Can Select any day of Month for Direct Debit$")
	public void i_Can_Select_any_day_of_Month_for_Direct_Dabit() throws Throwable {
		moveIN.verifyDayofDirectDebitOption();
		moveIN.clickDayofDirectDebitOption();

	}

	@When("^User select to 'Pay in Full'$")
	public void i_select_to_Pay_in_Full() throws Throwable {
		moveIN.selectPayInFull();
	}

	@And("^User See Mandatory Field Error Message Moving Details$")
	public void i_See_Mandatory_Field_Error_Message() throws Throwable {
		moveIN.mandatoryFieldVerification("Moving details");
	}

	@And("^User Enter Mandatory Fileds Moving Details$")
	public void i_Enter_Mandatory_Fileds() throws Throwable {
		moveIN.enterMandatoryField("Moving details");
	}

	@And("^User See Mandatory Field Error Message Your Details$")
	public void i_See_Mandatory_Field_Error_Message_Your_Details() throws Throwable {
		moveIN.mandatoryFieldVerification("Your details");
	}

	@And("^User Enter Mandatory Fileds Your Details$")
	public void i_Enter_Mandatory_Fileds_Your_Details() throws Throwable {
		moveIN.enterMandatoryField("Your details");
	}

	@And("^User See Mandatory Field Error Message Payment Details$")
	public void i_See_Mandatory_Field_Error_Message_Payment_Details() throws Throwable {
		moveIN.mandatoryFieldVerification("Payment details");

	}

	@And("^User Enter Mandatory Fileds Payment Details$")
	public void i_Enter_Mandatory_Fileds_Payment_Details() throws Throwable {
		moveIN.enterMandatoryField("Payment details");

	}

	@Then("^User Should move to Check Detail Page$")
	public void i_Should_move_to_Check_Detail_Page() throws Throwable {
		moveIN.verifyCheckDetailsPageIsOpen();

	}

	@And("^User Select Randome Day of Month$")
	public void i_Select_Randome_Day_of_Month() throws Exception {
		moveIN.randomClickDayofDirectDebitOption();
	}

	@And("^User Select Home as Contact$")
	public void i_Select_Home_as_Contact() throws Throwable {
		moveIN.clickHomeAsContact();
	}

	@Given("^User is at Check Detail Step of Move-in$")
	public void i_am_at_Check_Detail_Step_of_Move_in() throws Throwable {
		moveIN.openMoveInPage();
		moveIN.startClick();
		moveIN.enterPostCode("SO22 5JN");
		moveIN.findAddressClick();
		moveIN.selectAddress();
		moveIN.enterMoveINDate();
		moveIN.enterOccupant();
		moveIN.commonContinue();
		moveIN.enterYourDetails("Mr", "Mark", "Bone", "Taylor", "26/09/1987", "9810203040", "backTrave@Automation.com");
		moveIN.commonContinue();
		moveIN.enterCustomerPaymentDetails("Mark Taylor", "10", "20", "30", "55779911");
		moveIN.commonContinue();
	}

	@When("User Click Back on Button$")
	public void i_Click_Back_Button() throws Throwable {
		moveIN.commonBack();
	}

	@Then("^User Should move to Payment Detail Page$")
	public void i_Should_move_to_Payment_Detail_Page() throws Throwable {
		moveIN.verifyPaymentDetailPageOpen();
	}

	@Then("^I Click Back$")
	public void i_Click_Back() throws Throwable {
		moveIN.commonBack();
	}

	@Then("^User Should move to Your Detail Page$")
	public void i_Should_move_to_Your_Detail_Page() throws Throwable {
		moveIN.verifyYourDetailPageOpen();
	}

	@Then("^User Should move to Moving Detail Page$")
	public void i_Should_move_to_Moving_Detail_Page() throws Throwable {
		moveIN.verifyMovingDetailPageOpen();
	}

	@And("^User Should see the Update Address ([^\"]*)$")
	public void i_Should_see_the_Update_PostCode_and_Address(String address) throws Throwable {
		moveIN.verifyUpdateAddress(address);
	}

	@When("^User Moved till Check Detail Page$")
	public void i_Moved_till_Check_Detail_Page() throws Throwable {
		moveIN.openMoveInPage();
		moveIN.verifySWlogoLoaded();
		moveIN.verifyCreateAccountContent();
		moveIN.startClick();
		moveIN.verifySWlogoLoaded();
		moveIN.verifyMovingPageContent();
		moveIN.enterPostCode("SO22 5JN");
		moveIN.findAddressClick();
		moveIN.selectAddress();
		moveIN.enterMoveINDate();
		moveIN.enterOccupant();
		moveIN.commonContinue();
		moveIN.verifySWlogoLoaded();
		moveIN.verifyYourDetailPageContent();
		moveIN.enterYourDetails("Mr", "Mark", "Bone", "Taylor", "26/09/1987", "9810203040", "backTrave@Automation.com");
		moveIN.commonContinue();
		moveIN.verifySWlogoLoaded();
		moveIN.verifyPaymentPageContent();
		moveIN.enterCustomerPaymentDetails("Mark Taylor", "10", "20", "30", "55779911");
		moveIN.commonContinue();
		moveIN.verifySWlogoLoaded();
		moveIN.verifyCheckDetailPageContent();
	}

	@Then("^User Can See UI is loaded Correctly$")
	public void i_Can_See_UI_is_loaded_Correctly() throws Throwable {

	}

	// excel 
	
	@And("^User Enter Address PostCode for TestCase ([^\"]*)$")
	public void i_Enter_Address_PostCode_for_TestCase(String TestCode) throws Throwable 
	{
		System.out.println();
		System.out.println(TestCode);
		moveIN.enterPostCodefromExcel(TestCode);
	}

	@And("^User Enter Customer Detail for ([^\"]*)$")
	public void i_Enter_Customer_Detail_for_(String TestCode) throws Throwable 
	{
		moveIN.enterCustomerDetailsfromExcel(TestCode);
	}

	@And("^First Security Question and Answer ([^\"]*)$")
	public void first_Security_Question_and_Answer_(String TestCode) throws Throwable {
	   reg.firstQuestionAnswerFromExcel(TestCode);
	}

	@And("^Second Security Question and Answer ([^\"]*)$")
	public void second_Security_Question_and_Answer_(String TestCode) throws Throwable {
		reg.secondQuestionAnswerFromExcel(TestCode);
	}
	
	@And("^Set Login Password as ([^\"]*)$")
	public void set_Login_Password_as_(String TestCode) throws Throwable {
		reg.setPasswordFromExcel(TestCode);
	}

	
	@And("^User enter Correspodant Address PostCode ([^\"]*)$")
	public void i_enter_Correspodant_Address_PostCode_(String TestCode) throws Throwable {
		moveIN.correspondanceCodeFromExcel(TestCode);
	}

	@And("^User Select my Correspodant Address ([^\"]*)$")
	public void i_Select_my_Correspodant_Address_(String TestCode) throws Throwable {
		moveIN.selectCorresponAddExcel(TestCode);
	}


}
