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

/**
 * 
 * @author Arjun on 20-10-2017
 *
 */

public class AKKU_47_AddsingleuserManually extends Browser_Setup {
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_46 = "Add Users Manually";
	String build = "Build1";
	String notes = null;
	String result = null;
	
		
	@DataProvider(name = "Confirm_And_Add_User")
	public Object[][] dataProvider_ClientName() {

		Object[][] testData = poi_Reader_e.readExcelData(
				"..//App_Akku_Work//src//test//resources//input//Login.xlsx", "AddSingleUserManually",
				"AddSingleUser");

		return testData;
	}
		
	@Test(dataProvider = "Confirm_And_Add_User")
	public void AK_46_AddUsersManually(String email, String password,String FName, String Lname,String Confnewpassword ) throws Exception {
		
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			
			loginpage.verifyloggedinUserFNameAndLName();
			
			usermanagement.clickUsermanagementBtn();
			Thread.sleep(5000);
			usermanagement.isUsermanagementpage();
			usermanagement.clickOnAddUserManualy();
			Thread.sleep(5000);   	
			addsingleuser.typeFname(FName);
			addsingleuser.typeLname(Lname);
			addsingleuser.typeEmail();
			Thread.sleep(2000);
			addsingleuser.clickondropdowntoselectusertypeASuser();
			Thread.sleep(2000);
			loginpage.typepassword(password);
			addsingleuser.typeConfnewpassword(Confnewpassword);
			addsingleuser.clickonConfirmAndAddUser();
			editinfo.closeAlertpopup();
			
			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_46, build, notes, result);

		}
	} 
	
	@Test(dataProvider = "Confirm_And_Add_User")
	public void addAdmin(String email, String password,String FName, String Lname,String Confnewpassword ) throws Exception {
		
		try {
			loginpage.loginpageTitle();
			
			loginpage.typeUseremail(email);
			
			loginpage.typepassword(password);
			
			loginpage.clickLogin();
			
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			
			loginpage.verifyloggedinUserFNameAndLName();
			
			usermanagement.clickUsermanagementBtn();
			Thread.sleep(5000);
			usermanagement.isUsermanagementpage();
			usermanagement.clickOnAddUserManualy();
			Thread.sleep(5000);   	
			addsingleuser.typeFname(FName);
			addsingleuser.typeLname(Lname);
			addsingleuser.typeEmail();
			Thread.sleep(2000);
			addsingleuser.clickondropdowntoselectusertypeASAdmin();
			Thread.sleep(2000);
			
			loginpage.typepassword(password);
			addsingleuser.typeConfnewpassword(Confnewpassword);
			addsingleuser.clickonConfirmAndAddUser();
			editinfo.closeAlertpopup();
			
			loginpage.clickLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
