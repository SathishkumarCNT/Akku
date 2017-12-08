package com.app.akku.work.TestCases;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import com.app.akku.work.pageobjects.usermanagement.EditUserfromUserManagement;
import com.aventstack.extentreports.Status;

import testlink.api.java.client.TestLinkAPIResults;

/**
 * Purpose: This test case verifies that the user can able to Create new OU,
 * Edit OU, Delete OU and Assign User in OU management Page AK Test ID : 52 -
 * Create OU,Edit,Delete OU and Assign user to OU
 *
 * @author SathishKumar
 * @version Rel17.11.r2.0
 */

public class AK_52_Create_Edit_Delete_Assign_OU extends Browser_Setup {

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_52 = "Add Valid New OU with Parent CNT";
	String AK_53 = "Edit OU Name with Valid Name format";
	String AK_54 = "Add Valid New OU with any Child OU";
	String AK_55 = "Add Duplicate OU under same Parent OU";
	String AK_56 = "Add Duplicate OU under different Parent OU";
	String AK_57 = "Edit OU Name with Invalid Name format";
	String AK_58 = "Delete OU in OU Management page";
	String AK_59 = "Assign Users";
	String AK_60 = "Delete Parent OU which have SubOU in OU Management page";
	String AK_61 = "Delete OU which have user in OU Management page";
	String AK_68 = "Synchronization OU via G-Suite";
	String build = "Build 2";
	String notes = null;
	String result = null;

	Logger log = Logger.getLogger(AK_52_Create_Edit_Delete_Assign_OU.class.getName());

	@DataProvider(name = "Create_OU")
	public Object[][] dataProvider_ClientName_ChangePwdinnextlogin() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "AddOU");

		return testData;
	}

	@DataProvider(name = "Create_OU_As_SUBOU")
	public Object[][] dataProvider_ClientName_CreateOuasSubOu() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "AddOUASSubOU");

		return testData;
	}

	@DataProvider(name = "Duplicate_OU_In_Same_ParentOU")
	public Object[][] dataProvider_ClientName_DuplicateundersameOu() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "DuplicateOUInSameParentOU");

		return testData;
	}

	@DataProvider(name = "Duplicate_OU_with_differnt_ParentOU")
	public Object[][] dataProvider_ClientName_DuplicateunderdifferentOu() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "DuplicateOUwithdifferntParentOU");

		return testData;
	}

	@DataProvider(name = "Edit_OU")
	public Object[][] dataProvider_ClientName_EditOU() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "EditOU");

		return testData;
	}

	@DataProvider(name = "Edit_OU_With_InvalidName")
	public Object[][] dataProvider_ClientName_invalidName() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "EditOUWithInvalidName");

		return testData;
	}

	@DataProvider(name = "Gsuite_Login")
	public Object[][] dataProvider_ClientName() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"AddSingleUserManually", "GsuiteLogin");

		return testData;
	}

	@Test(dataProvider = "Create_OU", retryAnalyzer = Retry.class)
	public void AK_52_AddValidNewOUwithParentCNT(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_52", "Add Valid New OU with Parent CNT");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clickAddOUBtn();
			oumangement.Enterouname(NewOu);
			oumangement.ClickCreate();
			oumangement.ValidateSuccessfullmsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		}

		finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_52, build, notes, result);

		}

	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void AK_54_AddValidNewOUwithanyChildOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_54", "Add Valid New OU with any Child OU");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clickAddOUBtn();
			oumangement.Enterouname(NewOu);
			oumangement.SelectparentOU(ParentOU);
			oumangement.ClickCreate();
			oumangement.ValidateSuccessfullmsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_54, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_In_Same_ParentOU", retryAnalyzer = Retry.class)
	public void AK_55_AddDuplicateOUundersameParentOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_55", "Add Duplicate OU under same Parent OU");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clickAddOUBtn();
			oumangement.Enterouname(NewOu);
			oumangement.SelectparentOU(ParentOU);
			oumangement.ClickCreate();
			oumangement.ValidateDulicateoumsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_55, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_with_differnt_ParentOU", retryAnalyzer = Retry.class)
	public void AK_56_AddDuplicateOUunderdifferentParentOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_55", "Add Duplicate OU under different Parent OU");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clickAddOUBtn();
			oumangement.Enterouname(NewOu);
			oumangement.SelectparentOU(ParentOU);
			oumangement.ClickCreate();
			oumangement.ValidateSuccessfullmsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_56, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_OU", retryAnalyzer = Retry.class)
	public void AK_53_EditOUNamewithValidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_53", "Edit OU Name with Valid Name format");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickOUEditbtn(NewOu);
			oumangement.EditeOUName(ParentOU, NewOu);
			oumangement.Clickonupdate();
			oumangement.ValidateSuccessfullupdatedmsg();

			editinfo.closeAlertpopup();
			Thread.sleep(2000);
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_53, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_OU", retryAnalyzer = Retry.class)
	public void RevertbackEditedOUNamewithValidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickOUEditbtn(ParentOU);
			oumangement.EditeOUName(NewOu, ParentOU);
			oumangement.Clickonupdate();
			oumangement.ValidateSuccessfullupdatedmsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

		} catch (Exception e) {

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

	}

	@Test(dataProvider = "Edit_OU_With_InvalidName", retryAnalyzer = Retry.class)
	public void AK_57_EditOUNamewithInvalidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_57", "Edit OU Name with Invalid Name format");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickOUEditbtn(NewOu);
			oumangement.EditeOUName(ParentOU, ParentOU);
			oumangement.Clickonupdate();
			oumangement.Validateupdatefaileddmsg();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_57, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_OU_With_InvalidName", retryAnalyzer = Retry.class)
	public void AK_59_AssignUsers(String email, String password, String NewOu, String ParentOU) throws Exception {

		test = report.createTest("AK_59", "Assign Users");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();

			for (int i = 1; i <= 5; i++) {

				if (i == 1) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandORCollapsBtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateNousermovederrormsg();
					editinfo.closeAlertpopup();
				}
				if (i == 2) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandORCollapsBtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.useravaliableinnonuserlist();
					oumangement.ClickononeusermovefromNonusertoexistinguserlist();
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateAssignuserSuccessfullmsg();
					editinfo.closeAlertpopup();

				}
				if (i == 3) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandORCollapsBtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.Selectallusereinnonoulist();
					oumangement.ClickonAllusermovefromNonusertoexistinguserlist();
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateAssignuserSuccessfullmsg();
					editinfo.closeAlertpopup();
				}
				if (i == 4) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandORCollapsBtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.useravaliableinexistinglist();
					oumangement.ClickononeusermovefromexistinguserlisttoNonuser();
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateAssignuserSuccessfullmsg();
					editinfo.closeAlertpopup();

				}
				if (i == 5) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandORCollapsBtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.Selectallusereinexistinguserlist();
					oumangement.ClickonallusermovefromexistinguserlisttoNonuser();
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateAssignuserSuccessfullmsg();
					editinfo.closeAlertpopup();
				}

			}

			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_59, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_with_differnt_ParentOU", retryAnalyzer = Retry.class)
	public void AK_58_DeleteOUinOUManagementpage(String email, String password, String NewOu, String ParentOU)
			throws Exception {

		test = report.createTest("AK_58", "Delete OU in OU Management page");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			oumangement.ClickdeleteonOu(NewOu);
			editUser.AcceptDeletebtninusermanagement();
			oumangement.ValidateDeleteOUmsg(NewOu);
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_58, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void AK_60_DeleteParentOUwhichhaveSubOUinOUManagementpage(String email, String password, String NewOu,
			String ParentOU) throws Exception {

		test = report.createTest("AK_60", "Delete Parent OU which have SubOU in OU Management page");

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			oumangement.ClickdeleteonOu(ParentOU);
			oumangement.ValidatDeleteFailOUhavesuboumsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_60, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void AK_61_DeleteOUwhichhaveuserinOUManagementpage(String email, String password, String NewOu,
			String ParentOU) throws Exception {

		test = report.createTest("AK_61", "Delete OU which have user in OU Management page");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickOUAssginuserbtn(NewOu);
			oumangement.ClickonAssignusersavebtn();
			oumangement.ValidateNousermovederrormsg();
			editinfo.closeAlertpopup();
			oumangement.ClickdeleteonOu(NewOu);
			editUser.AcceptDeletebtninusermanagement();
			oumangement.ValidatDeleteFailOUhaveusermsg();
			editinfo.closeAlertpopup();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickOUAssginuserbtn(NewOu);
			oumangement.Selectallusereinexistinguserlist();
			oumangement.ClickonallusermovefromexistinguserlisttoNonuser();
			oumangement.ClickonAssignusersavebtn();
			oumangement.ValidateAssignuserSuccessfullmsg();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

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
		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_61, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void DeleteCreatedOufromPage(String email, String password, String NewOu, String ParentOU) throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			oumangement.ClickdeleteonOu(NewOu);
			editUser.AcceptDeletebtninusermanagement();
			editinfo.closeAlertpopup();
			driver.navigate().refresh();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickdeleteonOu(ParentOU);
			editUser.AcceptDeletebtninusermanagement();
			editinfo.closeAlertpopup();
			loginpage.clickLogout();

		} catch (Exception e) {

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
	}

	@Test(dataProvider = "Gsuite_Login",retryAnalyzer = Retry.class)
	public void AK_68_SynchronizationOUviaGSuite(String email, String password, String GSuiteEmail, String GSuitePwd,
			String Fname, String Confnewpassword) throws Exception {

		test = report.createTest("AK_68", "Synchronization OU via G-Suite");
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();

			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clicksyncOUviagsuieBtn();
			addgsuiteuser.typeGSuiteEmail(GSuiteEmail);
			addgsuiteuser.clickOnNextBtnofGSuiteFormEmail();
			addgsuiteuser.typeGSuitePwd(GSuitePwd);
			addgsuiteuser.clickOnNextBtnofGSuiteFormPassword();

			loginpage.clickLogout();

			driver.navigate().to("http://mail.google.com/");

			oumangement.clickgsuitetooglebutton();
			oumangement.clickgsuitemorebutton();
			oumangement.clickgsuiteAdminbutton();
			oumangement.clickgsuiteuserbutton();

			Thread.sleep(2000);
			oumangement.validateAkkuoulistwithguiteoulist(email, password);

			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {
			log.info("Fail");
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} catch (AssertionError e) {
			log.info("Fail");
			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();
		} finally {
			log.info("final");
			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan,AK_68, build, notes, result);

		}
	}
}