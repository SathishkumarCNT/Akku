package com.app.akku.work.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.app.akku.work.common.Browser_Setup;
import com.app.akku.work.common.Retry;
import com.app.akku.work.common.TestLinkIntegration;
import com.app.akku.work.common.poi_Reader_e;

import com.app.akku.work.keywords.Keywords;

import testlink.api.java.client.TestLinkAPIResults;

/**
 * 
 * @author Arjun on 11-10-2017
 *
 */

public class AKKU_09_Editpwdinformation extends Browser_Setup {
	
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_06 = "Verification of User Info in Home page & Edit Info page";
	String AK_08 = "Update New Password without entering Old password";
	String AK_09 = "Update New Password with All Valid Details";
	String AK_32 = "Change New Password to Old Password";
	String AK_10 = "Update New Password with invalid Confirm password";
	String AK_11 = "Update New Password with entering invalid Old password";
	String AK_12 = "Update New Password With Empty Pwd & Empty Confirm Pwd";
	String AK_13 = "Update password without matching with Password policy";
	String AK_14 = "Update New Password With Same value of new pwd & Confirm pwd";
	
	String build = "Build1";
	String notes = null;
	String result = null;

	
	@DataProvider(name = "EditPwd_Details")
	public Object[][] dataProvider_ChangeOldPWdtoNewPWD() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "UpdateNewPwd_Details");

		return testData;
	}

	@DataProvider(name = "EditPwdChanged_Details")
	public Object[][] dataProvider_ChangeNewPWDtoOldPWD() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "ChangeNewPWDtoOldPWD");

		return testData;
	}

	@DataProvider(name = "EditPwd_DetailswithInvalidConfirmpassword")
	public Object[][] dataProvider_ClientName() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "InvalidConfirmpassword_Details");

		return testData;
	}

	@DataProvider(name = "EditPwd_DetailswithInvalidoldpassword")
	public Object[][] dataProvider_ClientName_withInvalidoldpassword() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "InvalidOldpassword_Details");

		return testData;
	}

	@DataProvider(name = "EditPwd_DetailswithPassworNotmatchPolicy")
	public Object[][] dataProvider_ClientName_PassworNotmatchPolicy() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "Password_Not_Match_Password policy_Details");

		return testData;
	}
	
	@Test(dataProvider = "EditPwd_Details", retryAnalyzer = Retry.class)
	public void AK_06_VerificationofUserInfoinHomepageEditInfopage(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {
				
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			
			editinfo.clickEditbtn();
			loginpage.verifyloggedinFnameineditinfo();
			loginpage.verifyloggedinLnameineditinfo();
			loginpage.validatedloggedinUserDetailsEmailID(email);
					
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_06, build, notes, result);

		}
	}
	@Test(dataProvider = "EditPwd_DetailswithInvalidoldpassword", retryAnalyzer = Retry.class)
	public void AK_08_UpdateNewPasswordwithoutenteringOldpassword(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			
			editinfo.typenewpassword(Newpassword);
			Thread.sleep(1000);
			editinfo.typeConfnewpassword(Confnewpassword);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			editinfo.emptyoldpassworderrormsg();
			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_08, build, notes, result);

		}

	}
	@Test(dataProvider = "EditPwd_Details", retryAnalyzer = Retry.class)
	public void AK_09_ChangeOldPasswordtoNewPassword(String email, String password, String Oldpassword, String Newpassword, String Confnewpassword)
			throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			
			editinfo.isEditInfobtn();
			
			editinfo.updatenewpassword(Oldpassword, Newpassword, Confnewpassword);
			
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} catch (Exception e) {
			
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_09, build, notes, result);

		}

	}
	
	@Test(dataProvider = "EditPwdChanged_Details", retryAnalyzer = Retry.class)
	public void AK_32_ChangeNewPasswordtoOldPassword(String email, String password, String Oldpassword, String Newpassword, String Confnewpassword)
			throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			
			editinfo.isEditInfobtn();
			
			editinfo.updatenewpassword(Oldpassword, Newpassword, Confnewpassword);
			
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}
		finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			//TestLinkIntegration.reportResult(testProject, testPlan, AK_32, build, notes, result);
			TestLinkIntegration.reportResult(testProject, testPlan, AK_32, build, notes, result);
		}

	}

	@Test(dataProvider = "EditPwd_DetailswithInvalidConfirmpassword", retryAnalyzer = Retry.class)
	public void AK_10_UpdateNewPasswordwithinvalidConfirmpassword(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			editinfo.typeOldpassword(Oldpassword);
			editinfo.typenewpassword(Newpassword);
			Thread.sleep(1000);
			editinfo.typeConfnewpassword(Confnewpassword);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			editinfo.invalidconfirmpassworderrormsg(Confnewpassword);
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_10, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DetailswithInvalidoldpassword", retryAnalyzer = Retry.class)
	public void AK_11_UpdateNewPasswordwithenteringinvalidOldpassword(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			
			editinfo.typenewpassword(Newpassword);
			Thread.sleep(1000);
			editinfo.typeConfnewpassword(Confnewpassword);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			editinfo.invalidoldpassworderrormsg(Oldpassword);
			editinfo.closeAlertpopup();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_11, build, notes, result);

		}

	}
	
	
	@Test(dataProvider = "EditPwd_DetailswithInvalidConfirmpassword", retryAnalyzer = Retry.class)
		public void AK_12_UpdateNewPasswordWithEmptyPwdEmptyConfirmPwd(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			editinfo.typeOldpassword(Oldpassword);
			Thread.sleep(1000);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			editinfo.emptynewandConfirmpassworderrormsg();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}
		finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_12, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DetailswithPassworNotmatchPolicy", retryAnalyzer = Retry.class)
	public void AK_13_UpdatepasswordwithoutmatchingwithPasswordpolicy(String email, String password, String Oldpassword,	String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			editinfo.typeOldpassword(Oldpassword);
			editinfo.typenewpassword(Newpassword);
			Thread.sleep(1000);
			editinfo.typeConfnewpassword(Confnewpassword);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			
			editinfo.ValidateErrormessageforpasswordPolicy();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_13, build, notes, result);

		}

	}
	
	@Test(dataProvider = "EditPwd_DetailswithPassworNotmatchPolicy", retryAnalyzer = Retry.class)
	public void AK_14_UpdateNewPasswordWithSamevalueofnewpwdConfirmpwd(String email, String password, String Oldpassword,	String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			editinfo.isEditInfobtn();
			editinfo.clickEditbtn();
			editinfo.isPWDEditInformationpage();
			editinfo.typeOldpassword(Oldpassword);
			editinfo.typenewpassword(Oldpassword);
			Thread.sleep(1000);
			editinfo.typeConfnewpassword(Oldpassword);
			editinfo.clickUpdatebtn();
			Thread.sleep(1000);
			
			editinfo.ValidateErrormessagefornewpwdsameasold();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_14, build, notes, result);

		}

	}

	
	/**
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {

		System.out.println("Inside of tearDown Method");

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
