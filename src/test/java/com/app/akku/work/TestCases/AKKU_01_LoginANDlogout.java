package com.app.akku.work.TestCases;

import org.apache.log4j.Logger;
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
import com.aventstack.extentreports.Status;
import testlink.api.java.client.TestLinkAPIResults;

/**
 * 
 * @author Arjun on 10-10-2017
 *
 */

public class AKKU_01_LoginANDlogout extends Browser_Setup {

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_01 = "ValidLogin";
	String AK_02 = "LoginWithValidEmailAndInvalidPassword";
	String AK_03 = "Login with Valid User Name and Empty Password";
	String AK_04 = "Login with invalid Username and invalid Password";
	String AK_05 = "Login with empty Username and Valid Password";
	String build = "Build 2";
	String notes = null;
	String result = null;
	
	
	 Logger log = Logger.getLogger(AKKU_01_LoginANDlogout.class.getName());
	 
	 
	@DataProvider(name = "Login_Details")
	public Object[][] dataProvider_ValidLogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Login", "Valid_LoginDetails");

		return testData;
	}

	@DataProvider(name = "Invalid_LoginDetails")
	public Object[][] dataProvider_InvalidEmailLogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Login", "Invalid_LoginDetails");

		return testData;
	}

	@DataProvider(name = "Invalid_LoginPwdDetails")
	public Object[][] dataProvider_InvalidPWDLogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Login", "Invalid_LoginPwdDetails");

		return testData;
	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_01_ValidLogin(String email, String password) throws Exception {

		test = report.createTest("AK_01", "Login Page Validation with Valid Credential");
		try {

		
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		}catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} finally {
			
			
			

			log.info("Updating TestCase Execution Status in TestLink");
			
			log.info(testProject);
			log.info(testPlan);
			log.info(AK_01);
			log.info(build);
			log.info(notes);
			log.info(result);
			
			TestLinkIntegration.reportResult(testProject, testPlan, AK_01, build, notes, result);

		}
		

	}

	@Test(dataProvider = "Invalid_LoginPwdDetails", retryAnalyzer = Retry.class)
	public void AK_02_LoginWithValidEmailAndInvalidPassword(String email, String password) throws Exception {

		test = report.createTest("AK_02", "Trying to Login with Wrong Password");

		try {
			log.info("AK_02_LoginWithValidEmailAndInvalidPassword");
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.EmailANDPwdErrorValidation();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			log.info("Inside Catch");
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();
		} catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}

		finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_02, build, notes, result);

		}

	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_03_LoginwithValidUserNameandEmptyPassword(String email, String password) throws Exception {
		test = report.createTest("AK_03", "Trying to Login without Password");
		try {
			
			loginpage.typeUseremail(email);
			loginpage.clickLogin();
			loginpage.inputpassworderrormsgvalidation();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();
		}catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_03, build, notes, result);

		}

	}

	@Test(dataProvider = "Invalid_LoginDetails", retryAnalyzer = Retry.class)
	public void AK_04_LoginwithinvalidUsernameandinvalidPassword(String email, String password) throws Exception {
		test = report.createTest("AK_04", "Trying to Login invalid Credential");
		try {

			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.EmailANDPwdErrorValidation();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_04, build, notes, result);

		}
	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_05_LoginwithemptyUsernameandValidPassword(String email, String password) throws Exception {
		test = report.createTest("AK_05", "Trying to Login Without Enter Email ID and Valid Password");
		try {
			
			loginpage.typepassword(password);
    	    loginpage.clickLogin();
			loginpage.inputemailerrormsgvalidation();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_05, build, notes, result);

		}
	}

	
	
}
