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


public class AKKU_48_Uploadcsvfile extends Browser_Setup{
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_39 = "Add Bulk User from Upload file(CSV) with Valid Data";
	String AK_34 = "Add Bulk User from Upload file(CSV) with Invalid Data";
	String build = "Build1";
	String notes = null;
	String result = null;
	
	@DataProvider(name = "CSVFileUploadLogin_Details")
	public Object[][] dataProvider_ClientName_name() {

		Object[][] testData = poi_Reader_e.readExcelData(
				"..//App_Akku_Work//src//test//resources//input//Login.xlsx", "uploadscvfile",
				"Valid_LoginDetails");

		return testData;
	}
	@Test(dataProvider = "CSVFileUploadLogin_Details", retryAnalyzer = Retry.class)
public void AK_39_AddBulkUserfromUploadfilewithValidData(String email, String password, String CSVEmail) throws Exception {
		
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			
			loginpage.verifyloggedinUserFNameAndLName();
			Thread.sleep(5000);
			usermanagement.clickUsermanagementBtn();
			usermanagement.clickOnAddUserManualy();
			usermanagement.clickOnaddUserbyBulkOption();
			
			usermanagement.isDownloadSampleFilebtn();
			
			usermanagement.selectvalidcsvfile();
			Thread.sleep(5000);
				
			
			usermanagement.clickOnUploadBtn();
			
			usermanagement.ValidateSuccessfullyresetmsg();
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
		} catch (AssertionError e) {

			String message = e.getMessage();
			System.out.println(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_39, build, notes, result);

		}
		
	}
	
	@Test(dataProvider = "CSVFileUploadLogin_Details", retryAnalyzer = Retry.class)
	public void AK_34_AddBulkUserfromUploadfileCSVwithInvalidData(String email, String password, String CSVEmail) throws Exception {
		
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			
			loginpage.verifyloggedinUserFNameAndLName();
			Thread.sleep(5000);
			usermanagement.clickUsermanagementBtn();
			usermanagement.clickOnAddUserManualy();
			usermanagement.clickOnaddUserbyBulkOption();
			
			usermanagement.isDownloadSampleFilebtn();
			
			usermanagement.selectinvalidcsvfile();
			Thread.sleep(5000);
				
			
			usermanagement.clickOnUploadBtn();
			
			usermanagement.ValidateErrormsg();
			usermanagement.CloseBulkuserpopscreen();
			
					
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
		} catch (Exception e) {
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

		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_34, build, notes, result);

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
