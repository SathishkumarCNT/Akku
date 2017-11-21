package com.app.akku.work.TestCases;


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
 * @author Arjun on 27-10-2017
 *
 */

public class AKKU_49_AdduserViaGSuite extends Browser_Setup {
	
	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_41 = "Add new user Via G-suite";
	String build = "Build1";
	String notes = null;
	String result = null;

	@DataProvider(name = "Gsuite_Login")
	public Object[][] dataProvider_ClientName() {

		Object[][] testData = poi_Reader_e.readExcelData(
				"..//App_Akku_Work//src//test//resources//input//Login.xlsx", "AddSingleUserManually",
				"GsuiteLogin");

		return testData;
	}
		
	@Test(dataProvider = "Gsuite_Login", retryAnalyzer = Retry.class)
	public void AK_41_AddnewuserViaGsuite(String email, String password, String GSuiteEmail, String GSuitePwd, String Fname,
			String Confnewpassword)throws Exception {
		
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			Thread.sleep(3000);
			usermanagement.isUsermanagementpage();
			usermanagement.clickonAddUserViaGSuite();
			addgsuiteuser.typeGSuiteEmail(GSuiteEmail);
			addgsuiteuser.clickOnNextBtnofGSuiteFormEmail();
			Thread.sleep(2000);
			addgsuiteuser.typeGSuitePwd(GSuitePwd);
			
			addgsuiteuser.clickOnNextBtnofGSuiteFormPassword();

			Thread.sleep(5000);

			addgsuiteuser.verifyGSuiteDahsboardtext();
			addgsuiteuser.clickOnAddnewuser();
			addgsuiteuser.EnterFirsttName(Fname);
			addgsuiteuser.EnterLastName();
			addgsuiteuser.Password(Confnewpassword);
			Thread.sleep(5000);
			addsingleuser.typeConfnewpassword(Confnewpassword);
			editUser.EditusertypeinGSuite();
			addgsuiteuser.clickAddUser();
			Thread.sleep(3000);
			usermanagement.clickUsermanagementBtn();
			usermanagement.isUsermanagementpage();
			Thread.sleep(3000);

			addgsuiteuser.Validateuserlist(Fname);

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_41, build, notes, result);

		}
	} 	
	/**
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		System.out.println("Inside of tearDown Method");
				
		try
	    {
	        if(result.getStatus() == ITestResult.SUCCESS)
	        {
	        	System.out.println("Test case passed");
	        	driver.quit();
				
	        }
	        else if(result.getStatus() == ITestResult.FAILURE)
	        {
	        	
	        	Keywords.captureScreenShot(driver);
				
				System.out.println("Screenshot taken in Tear Down method");
				driver.quit();
				
			} else if(result.getStatus() == ITestResult.SKIP)
			{
				
				Keywords.captureScreenShot(driver);
				
				System.out.println("Test case Skipped");
				driver.quit();
			}
	    }
	   	    catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			
		}
	
	/**
	 * 
	 * @throws Exception
	 */
	@AfterTest
	public void teardown() throws Exception {
		
		
		//driver.quit();
		System.out.println("Test Execution Finished");

	}
}
