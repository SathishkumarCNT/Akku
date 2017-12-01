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
	
	Logger log = Logger.getLogger(AKKU_47_AddsingleuserManually.class.getName());
		
	@DataProvider(name = "Confirm_And_Add_User")
	public Object[][] dataProvider_ClientName() {

		Object[][] testData = poi_Reader_e.readExcelData(
				"..//App_Akku_Work//src//test//resources//input//Login.xlsx", "AddSingleUserManually",
				"AddSingleUser");

		return testData;
	}
		
	@Test(dataProvider = "Confirm_And_Add_User", retryAnalyzer = Retry.class)
	public void AK_46_AddUsersManually(String email, String password,String FName, String Lname,String Confnewpassword ) throws Exception {
		
		
		test = report.createTest("AK_46", "Add Users Manually");
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
			
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		} catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_46, build, notes, result);

		}
	} 
	
	@Test(dataProvider = "Confirm_And_Add_User", retryAnalyzer = Retry.class)
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
		} catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		}
	
	}
	
	


}
