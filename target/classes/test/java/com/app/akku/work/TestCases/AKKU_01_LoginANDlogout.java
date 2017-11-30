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
	String build = "Build1";
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

			Thread.sleep(5000);
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);
			Thread.sleep(3000);
			loginpage.typepassword(password);
			Thread.sleep(5000);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			loginpage.clickLogout();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
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

			Thread.sleep(2000);
			loginpage.EmailANDPwdErrorValidation();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			System.out.println("Inside Catch");
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}

		finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_02, build, notes, result);

		}

	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_03_LoginwithValidUserNameandEmptyPassword(String email, String password) throws Exception {
		test = report.createTest("AK_03", "Trying to Login without Password");
		try {
			System.out.println("Inside of login with valid Email AND Empty PWD");
			loginpage.typeUseremail(email);

			loginpage.clickLogin();

			Thread.sleep(2000);

			loginpage.inputpassworderrormsgvalidation();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
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

			Thread.sleep(2000);

			loginpage.EmailANDPwdErrorValidation();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_04, build, notes, result);

		}
	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_05_LoginwithemptyUsernameandValidPassword(String email, String password) throws Exception {
		test = report.createTest("AK_05", "Trying to Login Without Enter Email ID and Valid Password");
		try {
			System.out.println("Inside of login with Empty Email AND PWD");

			loginpage.typepassword(password);

		     loginpage.clickLogin();

			Thread.sleep(2000);

			loginpage.inputemailerrormsgvalidation();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_05, build, notes, result);

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
				test.log(Status.PASS, "Test Case Passed");

			} else if (result.getStatus() == ITestResult.FAILURE) {

				String screenshot_path = Keywords.capture(driver, result.getName());
				test.fail(result.getThrowable());
				test.log(Status.FAIL, "Test case Failed & Screenshot taken in Tear Down method as: "
						+ test.addScreenCaptureFromPath(screenshot_path));

			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, "Test case Skipped");
				test.skip(result.getThrowable());

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

		System.out.println("Test Execution");
		driver.quit();
		report.flush();

	}

}
