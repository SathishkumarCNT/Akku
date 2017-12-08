package com.app.akku.work.TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import com.app.akku.work.common.Browser_Setup;
import com.app.akku.work.common.Retry;
import com.app.akku.work.common.TestLinkIntegration;
import com.app.akku.work.common.poi_Reader_e;

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
	String build = "Build 2";
	String notes = null;
	String result = null;	

	Logger log = Logger.getLogger(AKKU_33_Edit_Delete_Suspend_Activity_Users.class.getName());

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
	public void AK_33_EditUserinformationinuserManagementpagewithvaliddata(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		test = report.createTest("AK_33", "Edit User information in user Management page with valid data");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
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

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} catch (Exception e) {
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_33, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_with_Invalid_Data", retryAnalyzer = Retry.class)
	public void AK_35_EditUserDetailsinUserManagementpagewithInvaliddata(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {	

		test = report.createTest("AK_35", "Edit User Details in User Management page with Invalid data");		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();

			for (int i = 1; i <= 3; i++) {
				if (i == 1) {

				
					editUser.clickonEditbtninusermanagement();
					editUser.EditemptyEmailinusermanagement();
					editUser.EditFnameinusermanagement(Fname);
					editUser.EditLnameinusermanagement(Lname);
					editUser.clickonUpdatebtn();
					editUser.validateEmptyemailidErrormsg();

				}
				if (i == 2) {
					
					editUser.clickonEditbtninusermanagement();
					editUser.EditEmailinusermanagement(NewEmail);
					editUser.EditemptyFnameinusermanagement();
					editUser.EditLnameinusermanagement(Lname);
					editUser.clickonUpdatebtn();
					editUser.validateEmptyFnameErrormsg();

				}
				if (i == 3) {
			
					editUser.clickonEditbtninusermanagement();
					editUser.EditEmailinusermanagement(NewEmail);
					editUser.EditFnameinusermanagement(Fname);
					editUser.EditemptyLnameinusermanagement();
					editUser.clickonUpdatebtn();
					editUser.validateEmptyLnameErrormsg();

				}

			}

			loginpage.clickLogout();
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_35, build, notes, result);

		}

	}

	@Test(dataProvider = "Edit_with_Valid_Data", retryAnalyzer = Retry.class)
	public void AK_36_EditUserDetailswithinvalidEmailIDformat(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		test = report.createTest("AK_36", "Edit User Details with invalid Email ID format");
		try {
			loginpage.loginpageTitle();

			loginpage.typeUseremail(email);

			loginpage.typepassword(password);

			loginpage.clickLogin();

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
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_36, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_with_Valid_Data", retryAnalyzer = Retry.class)
	public void AK_37_SuspendUserfromUserManagementpage(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		test = report.createTest("AK_37", "Suspend User from User Management page");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonSuspendbtninusermanagement();
			editUser.AcceptSuspendbtninusermanagement();
			editUser.ValidateSuspendusermsg();
			editUser.AcceptSuspendbtninusermanagement();
			loginpage.clickLogout();
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} catch (Exception e) {
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_37, build, notes, result);

		}

	}

	@Test(dataProvider = "Edit_with_Valid_Data", retryAnalyzer = Retry.class)
	public void AK_38_DeleteUserfromUserManagementpage(String email, String password, String Fname, String Lname,
			String NewEmail) throws Exception {

		test = report.createTest("AK_38", "Delete User from User Management page");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonDeletebtninusermanagement();
			editUser.AcceptDeletebtninusermanagement();
			editUser.ValidateDeleteusermsg();
			editUser.AcceptDeletebtninusermanagement();
			loginpage.clickLogout();
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_38, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DetailswithPassworNotmatchPolicy", retryAnalyzer = Retry.class)
	public void AK_40_ResetUserPasswordwithinvalidpasswordpolicy(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		test = report.createTest("AK_40", "Reset User Password with invalid password policy");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Confnewpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			editUser.Validateerormsg();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_40, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_DInvalidConfirmpassword_Details", retryAnalyzer = Retry.class)
	public void AK_42_ResetNewpasswordwithnotmatchingwithConfirmPassword(String email, String password, String Oldpassword,
			String Newpassword, String Confnewpassword) throws Exception {

		test = report.createTest("AK_42", "Reset New password with not matching with Confirm Password");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Newpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			Thread.sleep(3000);
			editUser.Validateerormsgforcompwdnotmatch();

			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_42, build, notes, result);

		}

	}

	@Test(dataProvider = "EditPwd_validpassword_Details", retryAnalyzer = Retry.class)
	public void AK_43_ResetPasswordfromUserListwithvalidpassword(String email, String password, String Oldpassword, String Newpassword,
			String Confnewpassword) throws Exception {

		test = report.createTest("AK_43", "Reset Password from User List with valid password");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword(Newpassword);
			editUser.typeConfnewpassword(Confnewpassword);
			editUser.ResetbtnClick();
			editUser.ValidateSuccessfullyresetmsg();

			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_43, build, notes, result);

		}

	}


	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details", retryAnalyzer = Retry.class)
	public void AK_44_SelectmultipleuserfromuserlistandVerifyActionbuttons(String email, String password, String Oldpassword, String NewEmail,
			String Newpassword, String Confnewpassword) throws Exception {

		test = report.createTest("AK_44", "Select multiple user from user list and Verify Action buttons");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.Selectalluser();
			editUser.ValidateDeleteandsuspendbtndisplay();
			editUser.SelectSuspenduserfromstatusdropdown();
			editUser.Clicksearchbutton();
			editUser.Selectalluser();
			editUser.ValidateDeleteandActivebtndisplay();
			editUser.SelectDeleteduserfromstatusdropdown();
			editUser.Clicksearchbutton();
			editUser.Selectalluser();
			editUser.ValidateSuspendandActivebtndisplay();
    		loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} catch (Exception e) {
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_44, build, notes, result);

		}

	}	

	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details", retryAnalyzer = Retry.class)
	public void AK_45_ResetPasswordandChangePasswordinNextLogin(String email, String password, String Oldpassword, String NewEmail,
			String Newpassword, String Confnewpassword) throws Exception {

		test = report.createTest("AK_45", "Reset Password and Change Password in Next Login");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
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
			loginpage.typeUseremail(NewEmail);
			loginpage.typepassword(Oldpassword);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(NewEmail);
			loginpage.clickLogout();
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} catch (Exception e) {
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_45, build, notes, result);

		}
	}

	@Test(dataProvider = "SearchKeywordingridwithvaliddata", retryAnalyzer = Retry.class)
	public void AK_47_Searchuserfromuserlistusingvalidkeyword(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		test = report.createTest("AK_47", "Search user from User List Using Valid keyword");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
         	loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);
			editUser.ValidateSearchkeyword(SearchKey);
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_47, build, notes, result);

		}

	}

	@Test(dataProvider = "SearchKeywordingridwithinvaliddata", retryAnalyzer = Retry.class)
	public void AK_48_Searchuserfromuserlistusinginvalidkeyword(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		test = report.createTest("AK_48", "Search user from User List using Invalid keyword");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);
			editUser.Validaterecordnotfoundmsg();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_48, build, notes, result);

		}

	}	

	@Test(dataProvider = "EditPwd_Changepwdinnextlogin_Details", retryAnalyzer = Retry.class)
	public void AK_49_VerifyLastLogindatetimeinuserList(String email, String password, String Oldpassword,
			String NewEmail, String Newpassword, String Confnewpassword) throws Exception {		

		test = report.createTest("AK_49", "Verify Last Login date & time in user List");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(NewEmail);
			loginpage.typepassword(Oldpassword);
			loginpage.clickLogin();
			editUser.Getdatetime();
			loginpage.clickLogout();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(NewEmail);
			editUser.ValidateDatetimefromgrid();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_49, build, notes, result);

		}
	}

	@Test(dataProvider = "SearchKeywordingridwithvaliddata", retryAnalyzer = Retry.class)
	public void AK_50_ViewUserdetailsbyselectingFullNameLinkText(String email, String password, String Fname,
			String Lname, String SearchKey) throws Exception {

		test = report.createTest("AK_50", "View User details, by selecting Full Name Link Text");		

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchKey);
			editUser.Selectfirstnamelinktxt();
			editUser.ValidateEmailinlinktxtpopup(SearchKey);
			editUser.CloseEditPopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} catch (Exception e) {
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_50, build, notes, result);

		}

	}
	

	@Test(dataProvider = "SearchKeywordingridwithinvaliddata", retryAnalyzer = Retry.class)
	public void AK_51_UserlistcountinapagebasedonShowCountselected(String email, String password, String Fname, String Lname,
			String SearchKey) throws Exception {

		test = report.createTest("AK_51", "User list count in a page, based on Show Count selected");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.SelectShowdropdown();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_51, build, notes, result);

		}

	}


}