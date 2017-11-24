package com.app.akku.work.TestCases;


import org.testng.ITestNGMethod;
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
		
		
		try {
			System.out.println("Inside of loginwithvalidEmailANDinvalidPWD");
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

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_02, build, notes, result);

		}
		
		
	}

	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_03_LoginwithValidUserNameandEmptyPassword(String email, String password) throws Exception {

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

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan,AK_03, build, notes, result);

		}

	}


	@Test(dataProvider = "Invalid_LoginDetails", retryAnalyzer = Retry.class)
	public void AK_04_LoginwithinvalidUsernameandinvalidPassword(String email, String password) throws Exception {
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

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan,AK_04, build, notes, result);

		}
	}
	
	@Test(dataProvider = "Login_Details", retryAnalyzer = Retry.class)
	public void AK_05_LoginwithemptyUsernameandValidPassword(String email, String password) throws Exception {

		try {
			System.out.println("Inside of login with Empty Email AND PWD");

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			loginpage.inputemailerrormsgvalidation();

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan,AK_05, build, notes, result);

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

				System.out.println("Test case Failed & Screenshot taken in Tear Down method");
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
