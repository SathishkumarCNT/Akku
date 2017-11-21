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

public class AKKU_33_Edit_Delete_Suspend_Activity_Users extends Browser_Setup {
	
	
	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_33 = "Edit User information in user Management page with valid data";
String AK_35 = "Edit User Details in User Management page with Invalid data";
String AK_36 = "Edit User Details with invalid Email ID format";
String AK_37 = "Suspend User from User Management page";
String AK_38 = "Delete User from User Management page";
String AK_40 = "Reset User Password with invalid password policy";
String AK_42 = "Reset New password with not matching with Confirm Password";
String AK_43 = "Reset Password from User List with valid password";
String AK_44 = "Select multiple user from user list and Verify Action buttons";
String AK_45 = "Reset Password and Change Password in Next Login";
String AK_47 = "Search user from user list using valid keyword";
String AK_48 = "Search user from user list using invalid keyword";
String AK_49 = "Verify Last Login date & time in user List";
String AK_50 = "View User details, by selecting Full Name Link Text";
String AK_51 = "User list count in a page, based on Show Count selected";
	String build = "Build1";
	String notes = null;
	String result = null;

	@DataProvider(name = "Edit_with_Valid_Data")
	public Object[][] dataProvider_ClientName_Validdata() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Edit_Delete_Suspend_Activate", "EditUser");

		return testData;
	}

	@DataProvider(name = "Edit_with_Invalid_Data")
	public Object[][] dataProvider_ClientName_InvalidData() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Edit_Delete_Suspend_Activate", "InvalidEmailFormat");

		return testData;
	}

	@DataProvider(name = "EditPwd_DetailswithPassworNotmatchPolicy")
	public Object[][] dataProvider_ClientName_PassworNotmatchPolicy() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "Password_Not_Match_Password policy_Details");

		return testData;
	}

	@DataProvider(name = "EditPwd_DInvalidConfirmpassword_Details")
	public Object[][] dataProvider_ClientName_ConPwdNotmatch() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "InvalidConfirmpassword_Details");

		return testData;
	}

	@DataProvider(name = "EditPwd_validpassword_Details")
	public Object[][] dataProvider_ClientName_validPwd() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"EditPwd", "UpdateNewPwd_Details");

		return testData;
	}

	@DataProvider(name = "EditPwd_Changepwdinnextlogin_Details")
	public Object[][] dataProvider_ClientName_ChangePwdinnextlogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Edit_Delete_Suspend_Activate", "UpdateNewPwd_Details");

		return testData;
	}

	@DataProvider(name = "SearchKeywordingridwithvaliddata")
	public Object[][] dataProvider_ClientName_Searchvalidkeyword() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Edit_Delete_Suspend_Activate", "SearchwithValidKeyword");

		return testData;
	}

	@DataProvider(name = "SearchKeywordingridwithinvaliddata")
	public Object[][] dataProvider_ClientName_Searchinvalidkeyword() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Edit_Delete_Suspend_Activate", "SearchwithinValidKeyword");

		return testData;
	}

	@Test(dataProvider = "Edit_with_Valid_Data")
	public void Akku_33_EditUsermanagementwithvaliddata(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {
		
		
		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			usermanagement.isUsermanagementpage();

			editUser.clickonEditbtninusermanagement();
			editUser.EditFnameinusermanagement(Fname);
			editUser.EditLnameinusermanagement(Lname);
			editUser.EditEmailinusermanagement(NewEmail);
			editUser.Editusertypeinusermanagement();
			editUser.clickonUpdatebtn();
			editUser.UpdateSucessfulValidate();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_33, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_with_Invalid_Data")
	public void Akku_34_EditUsermanagementwithEmptyEmailId(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();

			for (int i = 1; i <= 3; i++) {
				if (i == 1) {

					Thread.sleep(2000);
					editUser.clickonEditbtninusermanagement();
					editUser.EditemptyEmailinusermanagement();
					editUser.EditFnameinusermanagement(Fname);
					editUser.EditLnameinusermanagement(Lname);
					editUser.clickonUpdatebtn();
					editUser.validateEmptyemailidErrormsg();

				}
				if (i == 2) {
					Thread.sleep(2000);
					editUser.clickonEditbtninusermanagement();
					editUser.EditEmailinusermanagement(NewEmail);
					editUser.EditemptyFnameinusermanagement();
					editUser.EditLnameinusermanagement(Lname);
					editUser.clickonUpdatebtn();
					editUser.validateEmptyFnameErrormsg();

				}
				if (i == 3) {
					Thread.sleep(2000);
					editUser.clickonEditbtninusermanagement();
					editUser.EditEmailinusermanagement(NewEmail);
					editUser.EditFnameinusermanagement(Fname);
					editUser.EditemptyLnameinusermanagement();
					editUser.clickonUpdatebtn();
					editUser.validateEmptyLnameErrormsg();

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_35, build, notes, result);

		}

	}

	@Test(dataProvider = "Edit_with_Valid_Data")
	public void Akku_35_EditUsermanagementwithinvaliddata(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			editUser.clickonEditbtninusermanagement();
			editUser.EditEmailinusermanagement(NewEmail);
			editUser.EditFnameinusermanagement(Fname);
			editUser.EditLnameinusermanagement(Lname);
			editUser.Editusertypeinusermanagement();
			editUser.clickonUpdatebtn();
			editUser.updatefailValidation();
			loginpage.clickLogout();
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_36, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_with_Valid_Data")
	public void Akku_36_SuspendUserfromUserManagementgrid(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			
			editUser.clickonSuspendbtninusermanagement();
			editUser.AcceptSuspendbtninusermanagement();
			editUser.ValidateSuspendusermsg();
			editUser.AcceptSuspendbtninusermanagement();
			loginpage.clickLogout();
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_37, build, notes, result);

		}

	}

	@Test(dataProvider = "Edit_with_Valid_Data")
	public void Akku_37_DeleteUserfromUserManagementgrid(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			editUser.clickonDeletebtninusermanagement();
			editUser.AcceptDeletebtninusermanagement();
			editUser.ValidateDeleteusermsg();
			editUser.AcceptDeletebtninusermanagement();
			loginpage.clickLogout();
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_38, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DetailswithPassworNotmatchPolicy")
	public void Akku_38_Resetwithinvalidpasswordpolicy(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Confnewpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			editUser.Validateerormsg();

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_40, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DInvalidConfirmpassword_Details")
	public void Akku_39_Resetwithdifferentconfirmpwd(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Newpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			editUser.Validateerormsgforcompwdnotmatch();

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_42, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_validpassword_Details")
	public void Akku_40_Resetwithvalidpwd(String email, String password, String Oldpassword, String Newpassword,
			String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Newpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			editUser.ValidateSuccessfullyresetmsg();

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_43, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details")
	public void Akku_41_ChangePasswordinNextLogin(String email, String password, String Oldpassword, String NewEmail,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.SearchEmailIdinGrid(NewEmail);
			editUser.typenewpassword(Newpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.SelectChangePwd();

			editUser.ResetbtnClick();
			editUser.ValidateSuccessfullyresetmsg();
			loginpage.clickLogout();
			loginpage.typeUseremail(NewEmail);
			loginpage.typepassword(Newpassword);
			loginpage.clickLogin();
			editUser.EnterpwdinChangePage(Oldpassword);
			editUser.EnterconpwdinChangePage(Oldpassword);
			editUser.ClickupdatepwdinChangePage();
			editUser.validateChangepasswordmsg();
			editUser.ClickDashboardbtn();
			driver.navigate().to("http://pre-prod.akku.work/");
			Thread.sleep(2000);
			loginpage.typeUseremail(NewEmail);
			loginpage.typepassword(Oldpassword);

			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(NewEmail);
			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
			
	
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_45, build, notes, result);

		}
	}

	@Test(dataProvider = "SearchKeywordingridwithvaliddata")
	public void Akku_42_Searchuserfromuserlistusingvalidkeyword(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);
			editUser.ValidateSearchkeyword(SearchKey);

			Thread.sleep(5000);

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_47, build, notes, result);

		}

	}

	@Test(dataProvider = "SearchKeywordingridwithinvaliddata")
	public void Akku_43_Searchuserfromuserlistusinginvalidkeyword(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);
			editUser.Validaterecordnotfoundmsg();

			Thread.sleep(5000);

			loginpage.clickLogout();
			
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_48, build, notes, result);

		}

	}

	@Test(dataProvider = "SearchKeywordingridwithinvaliddata")
	public void Akku_44_Userlistcountbasedonshowdropdown(String email, String password, String Fname, String Lname,
			String SearchKey) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.SelectShowdropdown();

			Thread.sleep(5000);

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_51, build, notes, result);

		}

	}

	@Test(dataProvider = "SearchKeywordingridwithvaliddata")
	public void Akku_45_UserdetailsbyselectingFullNameLinkText(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);

			editUser.Selectfirstnamelinktxt();
			editUser.ValidateEmailinlinktxtpopup(SearchKey);
			editUser.CloseEditPopup();

			Thread.sleep(3000);

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_50, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details")
	public void Akku_46_VerifyLastLogindatetimeinuserList(String email, String password, String Oldpassword,
			String NewEmail, String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(NewEmail);
			loginpage.typepassword(Oldpassword);
			loginpage.clickLogin();
			editUser.Getdatetime();
			loginpage.clickLogout();
			Thread.sleep(3000);
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(NewEmail);
			editUser.ValidateDatetimefromgrid();

			Thread.sleep(3000);

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_49, build, notes, result);

		}
	}

	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details")
	public void Akku_50_VerifyActionbuttondisplay(String email, String password, String Oldpassword, String NewEmail,
			String Newpassword, String Confnewpassword) throws Exception {

		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

			Thread.sleep(2000);

			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);

			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();

			editUser.Selectalluser();
			editUser.ValidateDeleteandsuspendbtndisplay();

			Thread.sleep(3000);

			editUser.SelectSuspenduserfromstatusdropdown();
			editUser.Clicksearchbutton();
			editUser.Selectalluser();

			Thread.sleep(5000);

			editUser.ValidateDeleteandActivebtndisplay();

			Thread.sleep(3000);
			editUser.SelectDeleteduserfromstatusdropdown();

			editUser.Clicksearchbutton();
			editUser.Selectalluser();

			editUser.ValidateSuspendandActivebtndisplay();

			Thread.sleep(3000);

			loginpage.clickLogout();
			
			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			
			
		} catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
		}finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_44, build, notes, result);

		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
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
