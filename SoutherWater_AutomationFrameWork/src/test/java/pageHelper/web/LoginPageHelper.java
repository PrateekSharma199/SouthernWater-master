
package pageHelper.web;

import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import core.baseDriverHelper;
import core.webHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageFunctions.web.AccountDashBoardFunctions;
import pageFunctions.web.LoginFunctions;
import pageHelper.bddDriver;
import utils.PropertyReader;
import utils.xmlreader;

public class LoginPageHelper {
	public webHelper webDriver;
	public LoginFunctions login;
	public AccountDashBoardFunctions dashBoard;
	private bddDriver DriverInstance;
	String EmailID = null;
	PropertyReader prpertyreader = new PropertyReader();

	public LoginPageHelper(WebDriver driver) {
		webDriver = new baseDriverHelper(driver);
		login = new LoginFunctions(webDriver);
		System.out.println("First Constructor");
		dashBoard = new AccountDashBoardFunctions(webDriver);
	}

	public LoginPageHelper(bddDriver contextSteps) throws Exception {
		this.DriverInstance = contextSteps;
		System.out.println(this.DriverInstance);
		webDriver = new baseDriverHelper(DriverInstance.getWebDriver());
		login = new LoginFunctions(webDriver);
		dashBoard = new AccountDashBoardFunctions(webDriver);
	}

	@Given("^Usr is on login page$")
	public void I_am_at_login_page() throws Exception {
		login.OpenLoginPage();
	}

	@When("^User Enter ([^\"]*) and([^\"]*) into respective fields$")
	public void EnterEmailAndPassword(String email, String password) throws Exception {
		login.enterEmailAndPassword(email, password);
	}

	@And("^Click on Login$")
	public void ClickOnLogin() throws Exception {
		login.clickOnLogin();
	}

	@Then("^User Should not be able to login$")
	public void LoginFailed() throws Exception {
		login.loginError();
	}

	@And("^User is presented with Login error message$")
	public void LoginError() throws Exception {
		login.clickOnLogin();
	}

	// Second
	@Given("^I am on login page$")
	public void I_am_on_login_page() throws Exception {
		login.OpenLoginPage();
	}

	@When("^User logs using credentials ([^\"]*) and([^\"]*) into respective fields$")
	public void EnterCredentials(String email, String password) throws Exception {
		login.enterEmailAndPassword(email, password);
	}

	@And("^Click on Login button$")
	public void ClickOnLoginButton() throws Exception {
		login.clickOnLogin();
	}

	@Then("^I should see the Dashboard$")
	public void LoginCompleted() throws InterruptedException, DocumentException {
		login.loginCompleted();
	}

	/*
	 * public void ClickYourAccount() throws Exception {
	 * dashBoard.YourAccountClick(); } public void ClickLogout() throws Exception {
	 * dashBoard.LogoutClick(); }
	 */
	// Third

//	@Given("^User is on login page$")
//	public void UserAtLogin() throws Exception {
//		login.OpenLoginPage();
//
//	}

	@When("^User Click on Forgot Password$")
	public void ClickForgotPassword() throws Exception {
		login.clickForgotPassword();
	}

	@Then("^User Should navigate to Forgot Password Page$")
	public void NavigateToForgetPassword() throws InterruptedException, DocumentException {
		login.navigateToForgetPassword();
	}

	@And("^User Should See Email address field for reset password$")
	public void ForgotPasswordEmailId() throws Exception {
		login.forgotPasswordEmailId();

	}

	@And("^Back to login, Continue links$")
	public void BackToLoginAndContinue() throws Exception {
		login.backToLoginAndContinue();
	}

	// Fourth

	@Given("^User is at Reset Password Page$")
	public void ResetPasswordPage() throws Exception {
		login.OpenLoginPage();
		login.clickForgotPassword();
	}

	@When("^User Enter ([^\"]*) in Reset Password$")
	public void EnterEmailForgotPassword(String email) throws Exception {
		EmailID = email;
		login.enterEmailForgotPassword(email);
	}

	@And("^Click on Continue$")
	public void ClickContinue() throws Exception {
		login.clickForgotContinue();

	}

	@Then("^User Can See the Verification Link Sent Message$")
	public void ResetPasswordLinkVerification() throws InterruptedException, DocumentException {
		login.resetPasswordLinkVerification(EmailID);
	}

	// Fifth

	@Given("^I am accessing the Login Page$")
	public void OpenLoginPage() throws Exception {
		login.OpenLoginPage();
	}

	@When("^User Click on Registration$")
	public void ClickOnRegisration() throws Exception {
		login.clickOnRegisration();
	}

	@Then("^User Should be navigated to Registration Page$")
	public void VerifyRegisrationPageOpen() throws InterruptedException, DocumentException {
		login.verifyRegisrationPageOpen();
	}
}
