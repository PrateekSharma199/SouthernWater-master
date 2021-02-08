package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageHelper.web.AccountDashBoardPageHelper;
import pageHelper.web.CustomerRegistrationPageHelper;
import pageHelper.web.LogOutPageHelper;
import pageHelper.web.LoginPageHelper;
import pageHelper.web.MoveInPageHelper;
import pageHelper.web.PayBillPageHelper;
import pageHelper.web.RegisteredUserCloseAccountPageHelper;
import pageHelper.web.SubmitMeterReadings;
import pageHelper.web.UnRegisteredUserCloseAccountPageHelper;
import pageHelper.api.EmployeeHelper;
import pageHelper.api.SPQR;



public class pageController {

		public static final ThreadLocal<SPQR> SP= new InheritableThreadLocal<>();
		public static final ThreadLocal<PayBillPageHelper> PayBill= new InheritableThreadLocal<>();
		public static final ThreadLocal<SubmitMeterReadings> Meter= new InheritableThreadLocal<>();
		public static final ThreadLocal<LoginPageHelper> Login= new InheritableThreadLocal<>();
		public static final ThreadLocal<LogOutPageHelper> Logout= new InheritableThreadLocal<>();
		public static final ThreadLocal<CustomerRegistrationPageHelper> Register= new InheritableThreadLocal<>();
		public static final ThreadLocal<AccountDashBoardPageHelper> Account= new InheritableThreadLocal<>();
		public static final ThreadLocal<RegisteredUserCloseAccountPageHelper> RegisterUser= new InheritableThreadLocal<>();
		public static final ThreadLocal<UnRegisteredUserCloseAccountPageHelper> UnRegisterUser= new InheritableThreadLocal<>();
		public static final ThreadLocal<EmployeeHelper> EmployeeService= new InheritableThreadLocal<>();
		public static final ThreadLocal<MoveInPageHelper> MoveIn= new InheritableThreadLocal<>();
		
		public void initPage(WebDriver driver) throws IOException
		{
			
			
			PayBillPageHelper PU= new PayBillPageHelper(driver);
			PayBill.set(PU);
			
			SubmitMeterReadings ME= new SubmitMeterReadings(driver);
			Meter.set(ME);
			
			CustomerRegistrationPageHelper RE= new CustomerRegistrationPageHelper(driver);
			Register.set(RE);
				
			LoginPageHelper LG=new LoginPageHelper(driver);
			Login.set(LG);
			
			LogOutPageHelper LO=new LogOutPageHelper(driver);
			Logout.set(LO);
			
			MoveInPageHelper MO=new MoveInPageHelper(driver);
			MoveIn.set(MO);
			
			AccountDashBoardPageHelper AC=new AccountDashBoardPageHelper(driver);
			Account.set(AC);
			
			RegisteredUserCloseAccountPageHelper RegUser=new RegisteredUserCloseAccountPageHelper(driver);
			RegisterUser.set(RegUser);
			
			UnRegisteredUserCloseAccountPageHelper UnRegUser=new UnRegisteredUserCloseAccountPageHelper(driver);
			UnRegisterUser.set(UnRegUser);
		}
		public void initPage(RequestSpecification dr,Response respoence)
		{
			EmployeeHelper EH= new EmployeeHelper(dr,respoence);
			EmployeeService.set(EH);
			
			SPQR SP1= new SPQR(dr,respoence);
			SP.set(SP1);
				
		}
		
}


