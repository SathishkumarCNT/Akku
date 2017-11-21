package com.app.akku.work.TestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.akku.work.common.Browser_Setup;
import com.app.akku.work.common.TestLinkIntegration;
import com.app.akku.work.common.poi_Reader_e;
import com.app.akku.work.keywords.Keywords;

import testlink.api.java.client.TestLinkAPIResults;

public class AKKU_15_PasswordPolicy extends Browser_Setup {
	
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_15 = "Update Pwd policy by selecting only one Pwd Complexity";
	String AK_16 = "Update Pwd policy by selecting more than one Pwd Complexity";
	String AK_17 = "Update Password Length with invalid data";
	String AK_18 = "Update Password Length with valid data";
	String AK_19 = "Verify if Expiration of Pwd is displayed when Enable Pwd Expiry Radio btn Checked";
	String AK_20 = "Verify if Expiration of Pwd is hide, when Enable Pwd Expiry Radio is unchecked";
	
	
	String build = "Build1";
	String notes = null;
	String result = null;


	@DataProvider(name = "SiteBlockingLogin_Details")
	public Object[][] dataProvider_LoginDetails() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "Valid_LoginDetails");

		return testData;
	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_15_UpdatePwdpolicybyselectingonlyonePwdComplexity(String email, String password,
			String siteURl, String siteDescription) throws Exception

	{
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.SelectonepwdComplexity();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateerrormsgforonepwdComplexity();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			// loginpage.clickLogout();
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_15, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_16_UpdatePwdpolicybyselectingmorethanonePwdComplexity(String email, String password,
			String siteURl, String siteDescription) throws Exception

	{

		try {
			for (int i = 1; i <= 3; i++) {
				if (i == 1) {

					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					Thread.sleep(2000);
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					Thread.sleep(2000);
					usermanagement.clickAppmanagementBtn();
					Pwdpolicy.SelecttwopwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					loginpage.clickLogout();

				}
				if (i == 2) {
					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					Thread.sleep(2000);
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					usermanagement.clickAppmanagementBtn();
					Thread.sleep(2000);
					Pwdpolicy.SelectthreepwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					Thread.sleep(2000);
					loginpage.clickLogout();

				}
				if (i == 3) {
					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					Thread.sleep(2000);
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					usermanagement.clickAppmanagementBtn();
					Thread.sleep(2000);

					Pwdpolicy.SelectfourpwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					Thread.sleep(2000);
					loginpage.clickLogout();

				}
			}
			
			// loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_16, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_17_UpdatePasswordLengthwithinvaliddata(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();

			for (int i = 1; i <= 3; i++) {
				if (i == 1) {

					Thread.sleep(2000);
					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.Validateerrormsgforblankpwdlength();
					Pwdpolicy.closeAlertpopup();

				}
				if (i == 2) {
					Thread.sleep(2000);
					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.EnterCharinpwdlength();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateerrormsgforCharinpwdlength();
					Thread.sleep(2000);

				}
				if (i == 3) {
					Thread.sleep(2000);
					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.Enterpwdlengthof7char();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.Validateerrormsgforpwdlength7char();
					Thread.sleep(2000);

				}

			}

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_17, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_18_UpdatePasswordLengthwithvaliddata(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.Entervalidpwdlength();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_18, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_19_VerifyifExpirationofPwdisdisplayedwhenEnablePwdExpiryRadiobtnChecked(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();

			Thread.sleep(1000);
			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.VerifyExpirationofPwddispaly();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_19, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void AK_20_VerifyifExpirationofPwdishidehenEnablePwdExpiryRadioisunchecked(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();

			Thread.sleep(1000);
			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.DisablePasswordExpiry();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.VerifyExpirationofPwddisable();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_20, build, notes, result);

		}

	}
	
	@Test(dataProvider = "SiteBlockingLogin_Details")
	public void Updateoldpasswordpolicy(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
			try {
				loginpage.loginpageTitle();
				loginpage.typeUseremail(email);
				loginpage.typepassword(password);
				loginpage.clickLogin();
				Thread.sleep(2000);
				loginpage.validatedloggedinUserDetailsEmailID(email);
				loginpage.verifyloggedinUserFNameAndLName();
				usermanagement.clickAppmanagementBtn();
				Pwdpolicy.ChangeEntervalidpwdlength();
				
				Pwdpolicy.EnablePasswordExpiry();
				Pwdpolicy.SelecttwopwdComplexity();
				
				Pwdpolicy.Clickonsave();
				Pwdpolicy.ValidateSucessfullyaddedmsg();
				loginpage.clickLogout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("Test case passed");
				driver.quit();
			} else if (result.getStatus() == ITestResult.FAILURE) {

				Keywords.captureScreenShot(driver);

				System.out.println("Screenshot taken in Tear Down method");
				driver.quit();
			} else if (result.getStatus() == ITestResult.SKIP) {

				Keywords.captureScreenShot(driver);

				System.out.println("Test case Skipped");
				driver.quit();
			}
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	@AfterTest
	public void teardown() throws Exception {

		// driver.quit();
		System.out.println("Test Execution Finished");
	}
}
