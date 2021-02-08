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
import pageFunctions.web.SubmitmeterReadingFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.driver;
import utils.xmlreader;

public class SubmitMeterReadings {

	public webHelper webDriver;
	private bddDriver DriverInstance;
	public SubmitmeterReadingFunctions subMeter;
	PropertyReader prpertyreader = new PropertyReader();
	Integer meterReadingValue = null;
	String EnteredReading;

	// core.baseDriverHelper baseDriverHelperFunctions = null;
	public SubmitMeterReadings(WebDriver driver) throws IOException {
		webDriver = new baseDriverHelper(driver);
		System.out.println("First Constructor");
		subMeter = new SubmitmeterReadingFunctions(webDriver);
	}

	public SubmitMeterReadings(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		subMeter = new SubmitmeterReadingFunctions(webDriver);
	}

	@Given("^User is on meter submit reading pages$")
	public void SouthernWaterSumbitMeterReading() throws Exception {
		subMeter.accessUnauthSubmitMeterReading();
	}

	@When("^User click on Having trouble link$")
	public void TroubleLinkverification() throws Exception {
		subMeter.clickTroubleLink();
	}

	@Then("^User Should move to how to find your meter page$")
	public void VerifyHowtofindYourMeterPageOpen() throws InterruptedException, DocumentException {

		subMeter.verifyFindMeterOnpage();
	}

	// Test 2

	@Given("^User is on how to find your meter page$")
	public void VerifySubmitonline() throws Exception {

		subMeter.accessUnauthSubmitMeterReading();
		subMeter.clickTroubleLink();
		subMeter.verifyFindMeterOnpage();
	}

	@When("^User click on Submit Meter link")
	public void ClickSubmitonline() throws Exception {
		subMeter.submitOnlineClick();
	}

	@Then("^User Should move to Submit meter reading page")
	public void VerifySumbitMeterReadingOpen() throws Exception {
		subMeter.verifyMoveBackToSubmitMeterReadingPage();

	}

	// Scenario: I Want to Verify customer meter reading details
	@Given("^User is on submit meter reading page$")
	public void VerifySubmitMeterReadingPage() throws Exception {
		subMeter.accessUnauthSubmitMeterReading();
		subMeter.startClick();
	}

	@When("^User submit all the details of customer")
	public void ClickOnSubmitButtonAfterSubmitingCustomerDetails() throws Exception {
		subMeter.enterCustomerDetails("21301653", "4505530617", "Updahyll", "test@gmail.com");
		subMeter.continueClick();
	}

	@Then("^User Should able to verify all the details of customer")
	public void VerifySumbitMeterReadingDetailsOfgCustomer() throws Exception {
		/*
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/CheckYourDetailsHeader")), "Check your details");
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyYourMeterReadingLabel")), "Your meter reading");
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyCustomerNumber")), "21301653");
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyPaymentReferenceNumber")), "0004505530617");
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyLastName")), "Updahyll");
		 */

		subMeter.verifyCustomerDetails("21301653", "0004505530617", "Updahyll");

		/*
		 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ContinueHyperLink"))); webDriver.WaitforPageToBeReady();
		 * Thread.sleep(2000);
		 */
		subMeter.continueHyperlink();

		subMeter.enterMeterReading();

		// scroll screen at the bottom
		/*
		 * WebDriver driver = new ChromeDriver(); JavascriptExecutor jse =
		 * (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 * Thread.sleep(2000);
		 */
		subMeter.continueClickOnMeterReading();

		subMeter.confirmMeterReading();

		// subMeter.BackButtonClick();

		subMeter.confirmeterReadingClick();

		/*
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ConfirmMeterReadingHeader")), "Confirm meter reading");
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ConfirmMeterReadingValue")), String.valueOf(meterReading3));
		 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/BackButton"))); webDriver.WaitforPageToBeReady();
		 * Thread.sleep(2000);
		 */

		/*
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
		 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/BackButton"))); webDriver.WaitforPageToBeReady();
		 * Thread.sleep(2000);
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/CheckYourDetailsHeader")), "Check your details");
		 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ContinueHyperLink"))); webDriver.WaitforPageToBeReady();
		 * Thread.sleep(2000);
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/VerifyYourMeterReadingLabel2")), "Your meter reading");
		 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ContinueButton"))); webDriver.WaitforPageToBeReady();
		 * Thread.sleep(2000);
		 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ConfirmMeterReadingHeader")), "Confirm meter reading"); // This
		 * step is commented intentionally
		 * //webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/ConfirmReadingButton")));
		 */
	}

	// Meter Reading after login - scenario-1
	/*
	 * @Given("^I have logged in with ([^\"]*) and ([^\"]*)$") public void
	 * LoginInByEnterEmailAndPassword(String email, String password) throws
	 * Exception { Thread.sleep(2000);
	 * //webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/AcceptCokies"))); webDriver.WaitforPageToBeReady();
	 * webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
	 * webDriver.WaitforPageToBeReady(); Thread.sleep(2000);
	 * webDriver.VerifyTitle("My account"); Thread.sleep(2000);
	 * System.out.println("Email ID : " + email); System.out.println("PassWord : " +
	 * password); System.out.println("Email Locator  : " +
	 * loginLoct.getlocator("//locators/EmailId"));
	 * System.out.println("PassWord Locator : " +
	 * loginLoct.getlocator("//locators/Password"));
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/EmailId")),email);
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/Password")),password);
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/LoginButton"))); }
	 */

	@When("^I click to submit meter reading$")
	public void ClickSubmitMeterReadingButton() throws Exception {
		/*
		 * webDriver.WaitforPageToBeReady();
		 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
		 * "//locators/SubmitMeterReading")));
		 */
		subMeter.enterMeterReading();
	}

	@Then("^User can view Your meter reading page$")
	public void VerifyYourMeterReadingPage() throws InterruptedException, DocumentException, Exception {
		subMeter.verifyMeterReading();
	}

	// Meter Reading after login - scenario-2
	/*
	 * @Given("^I am on submit meter reading page with credentials ([^\"]*) and ([^\"]*)$"
	 * ) public void LoginByEnterEmailAndPassword(String email, String password)
	 * throws Exception { Thread.sleep(2000);
	 * //webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/AcceptCokies"))); webDriver.WaitforPageToBeReady();
	 * webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
	 * webDriver.WaitforPageToBeReady(); Thread.sleep(2000);
	 * webDriver.VerifyTitle("My account"); Thread.sleep(2000);
	 * System.out.println("Email ID : " + email); System.out.println("PassWord : " +
	 * password); System.out.println("Email Locator  : " +
	 * loginLoct.getlocator("//locators/EmailId"));
	 * System.out.println("PassWord Locator : " +
	 * loginLoct.getlocator("//locators/Password"));
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/EmailId")),email);
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/Password")),password);
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/LoginButton"))); }
	 */

	@And("^I move to Your meter reading page$")
	public void MoveToYourMeterReadingPage() throws Exception {
		subMeter.submitYourMeterReadingClick();
		subMeter.yourMeterReadingPage();

	}

	@When("^User click Back button on Your meter reading page$")
	public void ClickOnBackButton() throws Exception {
		subMeter.backButtonClick();
	}

	@Then("^User should navigate to my account dashboard$")
	public void DashBaordLoaded() throws InterruptedException, DocumentException, Exception {
		//webDriver.WaitforPageToBeReady();
		subMeter.dashBoardLoaded();

	}

	@And("^User verifies Customer Number & Payment Reference$")
	public void VerifyCustmerNumberAndPaymentRef() throws Exception {
		subMeter.custAndPayRefNumber();
	}

	// subMeter.VerifyMeterReadingPageOpen();

	// Meter Reading after login - scenario-3
	/*
	 * @Given("^I am on meter reading page using credentials ([^\"]*) and ([^\"]*)$"
	 * ) public void LoginByEmailAndPasswordToReachMeterReadingPage(String email,
	 * String password) throws Exception { Thread.sleep(2000);
	 * //webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/AcceptCokies"))); webDriver.WaitforPageToBeReady();
	 * webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
	 * webDriver.WaitforPageToBeReady(); Thread.sleep(2000);
	 * //webDriver.VerifyTitle("My account"); Thread.sleep(2000);
	 * System.out.println("Email ID : " + email); System.out.println("PassWord : " +
	 * password); System.out.println("Email Locator  : " +
	 * loginLoct.getlocator("//locators/EmailId"));
	 * System.out.println("PassWord Locator : " +
	 * loginLoct.getlocator("//locators/Password"));
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/EmailId")),email);
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/Password")),password);
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/LoginButton"))); webDriver.WaitforPageToBeReady();
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/SubmitMeterReading")));
	 * webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/YourMeterReadingPageHeading")), "Your meter reading"); }
	 */

	@When("^User enter meter reading$")
	public void EnterMeterReading() throws Exception {
		subMeter.enterMeterReading();
		/*
		 * meterReadingValue =
		 * Integer.valueOf(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/LastMeterReadingValueOfYourReadingPage")).getText());
		 * meterReadingValue = meterReadingValue +100;
		 * webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator(
		 * "//locators/CustomerMeterReading")),String.valueOf(meterReadingValue));
		 */
	}

	@And("^User click on Continue button$")
	public void ClickOnContinueButton() throws Exception {
		subMeter.continueClick();
	}

	@Then("^User should move to Confirm meter reading step$")
	public void ConfirmMeterReadingSteps() throws InterruptedException, DocumentException, Exception {
		subMeter.confirmMeterReading();
	}

	@And("^User can view updated Meter Reading$")
	public void ViewUpdatedMeterReading() throws Exception {
		subMeter.verifyUpdatedMeterReading();
	}

	@And("^User can view today date$")
	public void ViewTodaysDate() throws Exception {
		subMeter.todayDateonSubmitMeterReading();
	}

	// Meter Reading after login - scenario-4
	/*
	 * @Given("^I am on Confirm meter reading page using credentials ([^\"]*) and ([^\"]*)$"
	 * ) public void LoginByEmailAndPasswordToReachConfirmMeterReadingPage(String
	 * email, String password) throws Exception { Thread.sleep(2000);
	 * //webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/AcceptCokies"))); webDriver.WaitforPageToBeReady();
	 * webDriver.OpenURL(prpertyreader.readproperty("LoginUrl"));
	 * webDriver.WaitforPageToBeReady(); Thread.sleep(2000); webDriver.GetTitle();
	 * Thread.sleep(2000); System.out.println("Email ID : " + email);
	 * System.out.println("PassWord : " + password);
	 * System.out.println("Email Locator  : " +
	 * loginLoct.getlocator("//locators/EmailId"));
	 * System.out.println("PassWord Locator : " +
	 * loginLoct.getlocator("//locators/Password"));
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/EmailId")),email);
	 * webDriver.SendKeys(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/Password")),password);
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/LoginButton"))); webDriver.WaitforPageToBeReady();
	 * webDriver.Clickon(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/SubmitMeterReading")));
	 * webDriver.VerifyText(webDriver.getwebelement(loginLoct.getlocator(
	 * "//locators/YourMeterReadingPageHeading")), "Your meter reading");
	 * meterReadingValue =
	 * Integer.valueOf(webDriver.getwebelement(payBillLoct.getlocator(
	 * "//locators/LastMeterReadingValueOfYourReadingPage")).getText());
	 * meterReadingValue = meterReadingValue +100;
	 * System.out.println(meterReadingValue);
	 * webDriver.SendKeys(webDriver.getwebelement(payBillLoct.getlocator(
	 * "//locators/CustomerMeterReading")),String.valueOf(meterReadingValue));
	 * Thread.sleep(2000);
	 * webDriver.Clickon(webDriver.getwebelement(payBillLoct.getlocator(
	 * "//locators/ContinueButton2"))); webDriver.WaitforPageToBeReady();
	 * webDriver.VerifyText(webDriver.getwebelement(payBillLoct.getlocator(
	 * "//locators/ConfirmMeterReadingHeader")), "Confirm meter reading"); }
	 */

	@When("^User click Back button of Confirm meter reading page$")
	public void ClickBackButtonOfConfirmMeterMeterReadingPage() throws Exception {
		subMeter.submitYourMeterReadingClick();

		subMeter.enterMeterReading();

		subMeter.continueClick();

		subMeter.confirmMeterReading();

		subMeter.backButtonClick();
	}

	@Then("^User can update the new meter reading$")
	public void UpdateMeterReading() throws InterruptedException, DocumentException, Exception {
		System.out.println("User can update the meter reading successfully");
	}

	@And("^User can click to continue Button of Your meter reading page$")
	public void ClickToContinueButtonOfYourMeterReadingPage() throws Exception {
		subMeter.continueClick();
	}

	@And("^User can view updated meter reading on Confirm meter reading$")
	public void ViewUpdatedMeterReadingValue() throws Exception {
		subMeter.verifyUpdateMeterReading();
	}

	@Given("User is on Unregistered Submit meter Reading page")
	public void I_am_on_Unregistered_Submit_meter_Reading_page() throws Exception {
		subMeter.accessUnauthSubmitMeterReading();
	}

	@When("User Click on Start Button")
	public void I_Click_on_Start_Button() throws Exception {
		subMeter.startClick();
	}

	@And("^User Enter CustomerNumber ([^\\\"]*) PaymentReference ([^\\\"]*) and LastName ([^\\\"]*)$")
	public void I_Enter_CustomerNumber_Payment_Reference__and_LastName(String CustNumb, String PayRef, String LastName)
			throws Exception {
		subMeter.enterCustomerDetails(CustNumb, PayRef, LastName);
	}

	@And("User Click on Continue")
	public void I_Click_on_Continue() throws InterruptedException, Exception {
		/*
		 * webDriver.Clickon(webDriver.getwebelement("//button[@type='submit']"));
		 * webDriver.WaitforPageToBeReady(); Thread.sleep(5000);
		 */
		subMeter.continueClick();
	}

	@And("User Click again on  Continue")
	public void I_Click_again_on_Continue() throws Exception {
		/*
		 * webDriver.Clickon(webDriver.getwebelement("//a[text()='Continue']"));
		 * webDriver.WaitforPageToBeReady(); Thread.sleep(5000);
		 */

		subMeter.checkDetailsContinueClick();
	}

	@Then("User Can Enter Updated Meter Reading")
	public void I_Can_Enter_Updated_Meter_Reading() throws InterruptedException, IOException, DocumentException {
		/*
		 * WebElement el=webDriver.
		 * getwebelement("//h3[text()='Last meter reading']/following-sibling::p");
		 * String NewReading=el.getText(); int temp=Integer.parseInt(NewReading);
		 * temp=temp+100; NewReading=Integer.toString(temp); EnteredReading=NewReading;
		 * webDriver.SendKeys(webDriver.getwebelement(
		 * "//input[@id='customerMeterReading']"),NewReading+Keys.TAB);
		 */
		subMeter.enterMeterReading();
	}

	@And("click to continue Button of Your meter reading page")
	public void I_can_click_to_continue_Button_of_Your_meter_reading_page() throws InterruptedException, Exception {
		/*
		 * webDriver.Clickon(webDriver.getwebelement("//button[text()='Continue']"));
		 * webDriver.WaitforPageToBeReady(); Thread.sleep(5000);
		 */
		// subMeter.ContinueHyperlink();

		subMeter.continueClick();
	}

//	@And("User can view updated meter reading on Confirm meter reading")
//	public void I_can_view_updated_meter_reading_on_Confirm_meter_reading() throws InterruptedException {
//		subMeter.meterReadingOnConfirmPage();
//	}
}
