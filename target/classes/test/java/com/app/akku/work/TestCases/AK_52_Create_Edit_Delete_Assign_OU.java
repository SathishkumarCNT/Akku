package com.app.akku.work.TestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.akku.work.common.Browser_Setup;
import com.app.akku.work.common.Retry;
import com.app.akku.work.common.poi_Reader_e;
import com.app.akku.work.keywords.Keywords;


/**
 * Purpose: This test case verifies that the user can able to Create new OU, Edit OU, Delete OU and Assign User in OU management Page
 * AK Test ID : 52 - Create OU,Edit,Delete OU and Assign user to OU 
 *
 * @author SathishKumar
 * @version Rel17.11.r2.0
 */

public class AK_52_Create_Edit_Delete_Assign_OU extends Browser_Setup {
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_52 = "Add Valid New OU with Parent CNT";
	String build = "Build1";
	String notes = null;
	String result = null;
	
	@DataProvider(name = "Create_OU")
	public Object[][] dataProvider_ClientName_ChangePwdinnextlogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "AddOU");

		return testData;
	}

	@Test(dataProvider = "Create_OU", retryAnalyzer = Retry.class)
	public void AK_52_AddValidNewOUwithParentCNT(String email, String password, String NewOu, String ParentOU) throws Exception {
		
		loginpage.loginpageTitle();
		
		loginpage.typeUseremail(email);
		
		loginpage.typepassword(password);
		
		loginpage.clickLogin();
		
		Thread.sleep(2000);
		loginpage.validatedloggedinUserDetailsEmailID(email);
		
		loginpage.verifyloggedinUserFNameAndLName();
		
		oumangement.clickOUmanagementBtn();
		oumangement.clickAddOUBtn();
	}
	
	
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
