package testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utils.driver;

public class Accessibility extends driver 
{
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SoutherWaterLogin_withAccessibility(String Browser) throws Throwable {

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_AccessibilityAccessing(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_Detail(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			PayBill.get().StartButtonofPage();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy","devesh.kumar@southernwater.co.uk");
			Run_AccessibilityTest();
		
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_CheckDetail(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			Run_AccessibilityTest();
			PayBill.get().StartButtonofPage();
			Run_AccessibilityTest();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy","devesh.kumar@southernwater.co.uk");
			PayBill.get().ContinueButtonofDetailStep();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_ChooseAmount(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			PayBill.get().StartButtonofPage();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy","devesh.kumar@southernwater.co.uk");
			PayBill.get().ContinueButtonofDetailStep();
			PayBill.get().And_I_Click_on_Continue_Button_of_Check_Detail_Step();
			Run_AccessibilityTest();
		
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_Payment(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			PayBill.get().StartButtonofPage();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy","devesh.kumar@southernwater.co.uk");
			PayBill.get().ContinueButtonofDetailStep();
			PayBill.get().And_I_Click_on_Continue_Button_of_Check_Detail_Step();
			PayBill.get().SelectPayAnotherAmount();
			PayBill.get().EnterPartialAmount("1");
			PayBill.get().ClickMakePayment();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void PayBill_PaymentCompleted(String Browser) throws Throwable {
		// PayBill
		try {
			PayBill.get().AccessingPayBillPage();
			PayBill.get().StartButtonofPage();
			PayBill.get().IEnterCustDetailWithPaymentRef("13417979", "4050614612", "Vardy","devesh.kumar@southernwater.co.uk");
			PayBill.get().ContinueButtonofDetailStep();
			PayBill.get().And_I_Click_on_Continue_Button_of_Check_Detail_Step();
			PayBill.get().SelectPayAnotherAmount();
			PayBill.get().EnterPartialAmount("1");
			PayBill.get().ClickMakePayment();
			PayBill.get().EnterPaymentCardDetails("122000000000003", "Fiona Vardy", "08", "27", "453");
			PayBill.get().ClickPayNow();
			PayBill.get().PyamentConfirmationMessage();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_Access(String Browser) throws Throwable 
	{
		// MoveIn
		try 
		{
			MoveIn.get().NavigateToMoveInAccountPage();
			Run_AccessibilityTest();
		} 
		catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_Start(String Browser) throws Throwable {
		// MoveIn

		try {
			MoveIn.get().NavigateToMoveInAccountPage();
			MoveIn.get().ClickOnStartButton();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_CustomerDetails(String Browser) throws Throwable {
		// MoveIn

		try {
			MoveIn.get().NavigateToMoveInAccountPage();
			MoveIn.get().ClickOnStartButton();
			MoveIn.get().FillCustomerMoveInDetails();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_PaymentDetail(String Browser) throws Throwable {
		// MoveIn

		try {
			MoveIn.get().NavigateToMoveInAccountPage();
			MoveIn.get().ClickOnStartButton();
			MoveIn.get().FillCustomerMoveInDetails();
			MoveIn.get().CustomerPaymentDetails();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void MoveIn_Complete(String Browser) throws Throwable {
		// MoveIn

		try {
			MoveIn.get().NavigateToMoveInAccountPage();
			MoveIn.get().ClickOnStartButton();
			MoveIn.get().FillCustomerMoveInDetails();
			MoveIn.get().CustomerPaymentDetails();
			MoveIn.get().CustomerIsAbleToMoveIn();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_Access(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_Start(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();

			Register.get().I_AgreeTesrAndConditions();
			Register.get().IClickStartButtonOnWebPage();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_FillDetails(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();
			Register.get().I_AgreeTesrAndConditions();
			Register.get().IClickStartButtonOnWebPage();
			Register.get().EnterMyCustomerDetail("22129519", "Testone", "wecoyif894@5y5u.com");
			Register.get().ClickContinueButtonOnPage();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_ConfirmDetails(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();
			Register.get().I_AgreeTesrAndConditions();
			Register.get().IClickStartButtonOnWebPage();
			Register.get().EnterMyCustomerDetail("22129519", "Testone", "wecoyif894@5y5u.com");
			Register.get().ClickContinueButtonOnPage();
			Register.get().ClickOnConfirmContinue();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Registration_SetDetails(String Browser) throws Throwable {
		// Registration
		try {
			Register.get().OpenCustomerRegistrationPage();
			Register.get().I_AgreeTesrAndConditions();
			Register.get().IClickStartButtonOnWebPage();
			Register.get().EnterMyCustomerDetail("22129519", "Testone", "wecoyif894@5y5u.com");
			Register.get().ClickContinueButtonOnPage();
			Register.get().ClickOnConfirmContinue();
			Register.get().SetPassword("360@Logica");
			Register.get().SetFirstQuestionAnswer("What was the model of the first car you owned?", "Ford");
			Register.get().SetSecondQuestionAnswer("What is the name of your first pet?", "Dog");
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_Access(String Browser) throws Throwable 
	{
		try 
		{
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			Run_AccessibilityTest();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_Start(String Browser) throws Throwable {
		try {
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			UnRegisterUser.get().i_Click_on_Start_of_Close_Account_Page();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_CheckDetails(String Browser) throws Throwable {
		try 
		{
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			UnRegisterUser.get().i_Click_on_Start_of_Close_Account_Page();
			UnRegisterUser.get().I_Enter_CustomerNumer_Payment_Reference_LastName("10470201", "0004012407196",
					"DOWNHYLL");
			//UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Your_Detail_Step();
			Run_AccessibilityTest();
			
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_MoveOutDate(String Browser) throws Throwable {
		try {
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			UnRegisterUser.get().i_Click_on_Start_of_Close_Account_Page();
			UnRegisterUser.get().I_Enter_CustomerNumer_Payment_Reference_LastName("10470201", "0004012407196",
					"DOWNHYLL");
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Your_Detail_Step();
			UnRegisterUser.get().I_Enter_Moving_Out_Date_of_Close_Account();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Moving_Date_Step();
			Run_AccessibilityTest();
			

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_PaymentBill(String Browser) throws Throwable {
		try {
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			
			UnRegisterUser.get().i_Click_on_Start_of_Close_Account_Page();
			
			UnRegisterUser.get().I_Enter_CustomerNumer_Payment_Reference_LastName("10470201", "0004012407196",
					"DOWNHYLL");
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Your_Detail_Step();
			
			UnRegisterUser.get().I_Enter_Moving_Out_Date_of_Close_Account();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Moving_Date_Step();
			
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Final_Bill_Step();
			UnRegisterUser.get().I_Enter_Post_Code_as_on_Forwarding_Address("CT16 3NR");
			UnRegisterUser.get().I_Click_on_Find_Address_Forwarding_Address();
			UnRegisterUser.get().I_Select_from_Address_List_on_Forwarding_Address("18 WITLEY WALK, WHITFIELD, CT16 3NR");
			UnRegisterUser.get().I_Click_Continue_on_Forwarding_Address();
			Run_AccessibilityTest();
		

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void CloseAccount_Forwarding(String Browser) throws Throwable {
		try {
			UnRegisterUser.get().i_have_Open_UnRegisterd_User_Close_Account_Page();
			UnRegisterUser.get().i_Click_on_Start_of_Close_Account_Page();
			UnRegisterUser.get().I_Enter_CustomerNumer_Payment_Reference_LastName("10470201", "0004012407196","DOWNHYLL");
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Your_Detail_Step();
			UnRegisterUser.get().I_Enter_Moving_Out_Date_of_Close_Account();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Moving_Date_Step();
			UnRegisterUser.get().I_Click_On_Continue_of_Close_Account_Final_Bill_Step();
			UnRegisterUser.get().I_Enter_Post_Code_as_on_Forwarding_Address("CT16 3NR");
			UnRegisterUser.get().I_Click_on_Find_Address_Forwarding_Address();
			UnRegisterUser.get().I_Select_from_Address_List_on_Forwarding_Address("18 WITLEY WALK, WHITFIELD, CT16 3NR");
			UnRegisterUser.get().I_Click_Continue_on_Forwarding_Address();
			UnRegisterUser.get().I_Click_Confirm_and_Close_Account_on_check_and_confirm_step();
			Run_AccessibilityTest();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_PayBillAuth_Amount(String Browser) throws Throwable {
		try {
			PayBill.get().LoginWithYouAccountCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			
			PayBill.get().MakePaymentFromDashBoard();
			
			PayBill.get().SelectPayAnotherAmountOption();
			Run_AccessibilityTest();
			PayBill.get().EnterPartialAmountForPayment("1");
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_PayBillAuth_Accessibility(String Browser) throws Throwable {
		try {
			PayBill.get().LoginWithYouAccountCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Run_AccessibilityTest();
			PayBill.get().MakePaymentFromDashBoard();
			Run_AccessibilityTest();
			PayBill.get().SelectPayAnotherAmountOption();
			PayBill.get().EnterPartialAmountForPayment("1");
			PayBill.get().MakePaymentLink();
			Run_AccessibilityTest();
			PayBill.get().EnterPaymentcardDetails("122000000000003", "Fiona Vardy", "08", "27", "453");
			PayBill.get().i_Click_on_Pay_Now_Button_on_Make_Payment();
			Run_AccessibilityTest();
			PayBill.get().PaymentConfirmationMessages();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_Access(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_YourDetails(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Meter.get().I_Click_on_Start_Button();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_CheckDetails(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Meter.get().I_Click_on_Start_Button();
			
			Meter.get().I_Enter_CustomerNumber_Payment_Reference__and_LastName("10470201", "0004012407196", "DOWNHYLL");
			Meter.get().I_Click_on_Continue();

			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_YourReading(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Meter.get().I_Click_on_Start_Button();
			Meter.get().I_Enter_CustomerNumber_Payment_Reference__and_LastName("10470201", "0004012407196", "DOWNHYLL");
			Meter.get().I_Click_on_Continue();
			Meter.get().I_Click_again_on_Continue();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void SubmitMeterReading_ConfirmReadingDetails(String Browser) throws Throwable {

		try {
			Meter.get().I_am_on_Unregistered_Submit_meter_Reading_page();
			Meter.get().I_Click_on_Start_Button();
			Meter.get().I_Enter_CustomerNumber_Payment_Reference__and_LastName("10470201", "0004012407196", "DOWNHYLL");
			Meter.get().I_Click_on_Continue();
			Meter.get().I_Click_again_on_Continue();
			Meter.get().I_Can_Enter_Updated_Meter_Reading();
			Meter.get().I_can_click_to_continue_Button_of_Your_meter_reading_page();
			Meter.get().I_can_view_updated_meter_reading_on_Confirm_meter_reading();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}

	}

	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Logout_Accessibility(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
			Account.get().click_on_Your_Account_Option();
			Run_AccessibilityTest();
			Account.get().i_Click_on_Logout_from_Dashboard();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
		
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard1(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
			Account.get().click_on_Your_Account_Option();
			Run_AccessibilityTest();
		
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard2(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
			Account.get().click_on_Your_Account_Option();
			Run_AccessibilityTest();
			Account.get().i_Click_on_Submit_a_meter_reading_from_Dashboard();
			Run_AccessibilityTest();
			
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard3(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Make_a_payment_from_Dashboard();
			Run_AccessibilityTest();
			
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard4(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Run_AccessibilityTest();
			Account.get().click_on_Your_Account_Option();
			Run_AccessibilityTest();
			Account.get().i_Click_on_Close_your_account_from_Dashboard();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_Dashboard5(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Logout_from_Dashboard();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_DashboardPaperlessSetting(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().i_Click_Change_Paperless_Setting();
			Account.get().i_Click_on_Update();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_DashboardDirectDebit(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().i_Click_Set_Up_Direct_Debit();
			Account.get().i_Should_move_to_Setup_Direct_Debit_Page();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Account_DashboardContactUs(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().i_Click_Contact_us();
			Account.get().contact_Us_page_should_open_in_new_tab();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_MoveOutDate(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Close_your_account_from_Dashboard();
			RegisterUser.get().i_Click_Close_your_account_from_you_are_moving();
			Run_AccessibilityTest();
			
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_BillStep(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Close_your_account_from_Dashboard();
			RegisterUser.get().i_Click_Close_your_account_from_you_are_moving();
			RegisterUser.get().i_Enter_the_MoveOut_Date();
			RegisterUser.get().i_Click_On_Continue_of_Move_Out_Step();
			Run_AccessibilityTest();
			
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_ForwardingAddress(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Close_your_account_from_Dashboard();
			RegisterUser.get().i_Click_Close_your_account_from_you_are_moving();
			RegisterUser.get().i_Enter_the_MoveOut_Date();
			RegisterUser.get().i_Click_On_Continue_of_Move_Out_Step();
			RegisterUser.get().i_Click_On_Continue_of_Final_Bill_Step();
			RegisterUser.get().i_Enter_Post_Code_as("CT16 3NR");
			Run_AccessibilityTest();
			RegisterUser.get().i_Click_Find_Address_as();
			Run_AccessibilityTest();
			RegisterUser.get().i_Select_Address_from_Address_List("18 WITLEY WALK, WHITFIELD, CT16 3NR");
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_CloseConfirm(String Browser) throws Throwable {
		try {
			
			Login.get().I_am_on_login_page();
			Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
			Login.get().ClickOnLogin();
			Account.get().click_on_Your_Account_Option();
			Account.get().i_Click_on_Close_your_account_from_Dashboard();
			RegisterUser.get().i_Click_Close_your_account_from_you_are_moving();
			RegisterUser.get().i_Enter_the_MoveOut_Date();
			RegisterUser.get().i_Click_On_Continue_of_Move_Out_Step();
			RegisterUser.get().i_Click_On_Continue_of_Final_Bill_Step();
			RegisterUser.get().i_Enter_Post_Code_as("CT16 3NR");
			
			RegisterUser.get().i_Click_Find_Address_as();
			RegisterUser.get().i_Select_Address_from_Address_List("18 WITLEY WALK, WHITFIELD, CT16 3NR");
			RegisterUser.get().i_Click_Continue_of_Forwarding_Address();
			Run_AccessibilityTest();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_SubmitMeterReading_YourReading(String Browser) throws Throwable
	{
		Login.get().I_am_on_login_page();
		Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
		Login.get().ClickOnLogin();
		Account.get().click_on_Your_Account_Option();
		Account.get().i_Click_on_Submit_a_meter_reading_from_Dashboard();
		Meter.get().EnterMeterReading();
		Run_AccessibilityTest();
	}
	
	
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Auth_SubmitMeterReading_ConfirmReading(String Browser) throws Throwable
	{
		Login.get().I_am_on_login_page();
		Login.get().EnterCredentials("kumar.devesh82@yahoo.com", "Apple@123");
		Login.get().ClickOnLogin();
		Run_AccessibilityTest();
		Account.get().click_on_Your_Account_Option();
		Run_AccessibilityTest();
		Account.get().i_Click_on_Submit_a_meter_reading_from_Dashboard();
		Run_AccessibilityTest();
		Meter.get().EnterMeterReading();
		Run_AccessibilityTest();
		Meter.get().ClickOnContinueButton();
		Run_AccessibilityTest();
		Meter.get().ViewUpdatedMeterReading();
		Run_AccessibilityTest();
	}
	
	
	@Parameters("Browser")
	@Test(groups = { "web" })
	public void Reset_Password(String Browser) throws Throwable
	{
		Login.get().I_am_on_login_page();
		Login.get().ClickForgotPassword();
		Run_AccessibilityTest();
		
	}
}


//Run_AccessibilityTest();