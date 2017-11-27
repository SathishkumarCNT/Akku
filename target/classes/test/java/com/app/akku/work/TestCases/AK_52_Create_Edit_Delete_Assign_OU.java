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

	String build = "Build1";
	String notes = null;
	String result = null;

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

	@Test(dataProvider = "Create_OU")
	public void AK_52_AddValidNewOUwithParentCNT(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.clickAddOUBtn();
			oumangement.Enterouname(NewOu);
			oumangement.ClickCreate();
			oumangement.ValidateSuccessfullmsg();
			editinfo.closeAlertpopup();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_52, build, notes, result);

		}

	}

	@Test(dataProvider = "Create_OU_As_SUBOU")
	public void AK_54_AddValidNewOUwithanyChildOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
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

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_54, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_In_Same_ParentOU")
	public void AK_55_AddDuplicateOUundersameParentOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
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

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_55, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_with_differnt_ParentOU")
	public void AK_56_AddDuplicateOUunderdifferentParentOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
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

			System.out.println("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = getOSBrowserDetails();

		} catch (Exception e) {

			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();

		} finally {

			System.out.println("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_56, build, notes, result);

		}
	}


	@Test(dataProvider = "Edit_OU")
	public void AK_53_EditOUNamewithValidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickOUEditbtn(NewOu);
			oumangement.EditeOUName(ParentOU, NewOu);
			oumangement.Clickonupdate();
			oumangement.ValidateSuccessfullupdatedmsg();

			editinfo.closeAlertpopup();
			Thread.sleep(2000);
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_53, build, notes, result);

		}
	}
	
	@Test(dataProvider = "Edit_OU")
	public void RevertbackEditedOUNamewithValidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickOUEditbtn(ParentOU);
			oumangement.EditeOUName(NewOu, ParentOU);
			oumangement.Clickonupdate();
			oumangement.ValidateSuccessfullupdatedmsg();

			editinfo.closeAlertpopup();
			Thread.sleep(2000);
			loginpage.clickLogout();

			

		} catch (Exception e) {

			
			e.printStackTrace();

		} 
	}

	@Test(dataProvider = "Edit_OU_With_InvalidName")
	public void AK_57_EditOUNamewithInvalidNameformat(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickOUEditbtn(NewOu);
			oumangement.EditeOUName(ParentOU,ParentOU );
			oumangement.Clickonupdate();
			oumangement.Validateupdatefaileddmsg();

			Thread.sleep(2000);
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_57, build, notes, result);

		}
	}

	@Test(dataProvider = "Edit_OU_With_InvalidName")
	public void AK_59_AssignUsers(String email, String password, String NewOu, String ParentOU) throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();

			for (int i = 1; i <= 5; i++) {

				if (i == 1) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandbtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					oumangement.ClickonAssignusersavebtn();
					oumangement.ValidateNousermovederrormsg();
					editinfo.closeAlertpopup();
				}
				if (i == 2) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandbtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					Thread.sleep(2000);
					oumangement.useravaliableinnonuserlist();
					Thread.sleep(2000);
					oumangement.ClickononeusermovefromNonusertoexistinguserlist();
					Thread.sleep(2000);
					oumangement.ClickonAssignusersavebtn();
					Thread.sleep(2000);
					oumangement.ValidateAssignuserSuccessfullmsg();
					Thread.sleep(2000);
					editinfo.closeAlertpopup();
					

				}
				if (i == 3) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandbtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					Thread.sleep(2000);
					oumangement.Selectallusereinnonoulist();
					Thread.sleep(2000);
					oumangement.ClickonAllusermovefromNonusertoexistinguserlist();
					Thread.sleep(2000);
					oumangement.ClickonAssignusersavebtn();
					Thread.sleep(2000);
					oumangement.ValidateAssignuserSuccessfullmsg();
					Thread.sleep(2000);
					editinfo.closeAlertpopup();
				}
				if (i == 4) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandbtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					Thread.sleep(2000);
					oumangement.useravaliableinexistinglist();
					Thread.sleep(2000);
					oumangement.ClickononeusermovefromexistinguserlisttoNonuser();
					Thread.sleep(2000);
					oumangement.ClickonAssignusersavebtn();
					Thread.sleep(2000);
					oumangement.ValidateAssignuserSuccessfullmsg();
					Thread.sleep(2000);
					editinfo.closeAlertpopup();

				}
				if (i == 5) {
					oumangement.clickOUmanagementBtn();
					oumangement.ClickExpandbtn();
					oumangement.ClickOUAssginuserbtn(NewOu);
					Thread.sleep(2000);
					oumangement.Selectallusereinexistinguserlist();
					Thread.sleep(2000);
					oumangement.ClickonallusermovefromexistinguserlisttoNonuser();
					Thread.sleep(2000);
					oumangement.ClickonAssignusersavebtn();
					Thread.sleep(2000);
					oumangement.ValidateAssignuserSuccessfullmsg();
					Thread.sleep(2000);
					editinfo.closeAlertpopup();
				}

			}

			Thread.sleep(2000);
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
			 TestLinkIntegration.reportResult(testProject, testPlan, AK_59, build, notes, result);

		}
	}

	@Test(dataProvider = "Duplicate_OU_with_differnt_ParentOU")
	public void AK_58_DeleteOUinOUManagementpage(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			Thread.sleep(2000);
			oumangement.ClickdeleteonOu(NewOu);
			Thread.sleep(2000);
			editUser.AcceptDeletebtninusermanagement();
			Thread.sleep(2000);
			oumangement.ValidateDeleteOUmsg(NewOu);
			Thread.sleep(2000);
			editinfo.closeAlertpopup();
			Thread.sleep(2000);
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_58, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU")
	public void AK_60_DeleteParentOUwhichhaveSubOUinOUManagementpage(String email, String password, String NewOu,
			String ParentOU) throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();

			oumangement.ClickexpandonParentOu(ParentOU);
			Thread.sleep(2000);
			oumangement.ClickdeleteonOu(ParentOU);
			Thread.sleep(2000);
			editUser.AcceptDeletebtninusermanagement();
			Thread.sleep(2000);
			oumangement.ValidatDeleteFailOUhavesuboumsg();
			Thread.sleep(2000);
			editinfo.closeAlertpopup();
			Thread.sleep(10000);
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_60, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU")
	public void AK_61_DeleteOUwhichhaveuserinOUManagementpage(String email, String password, String NewOu,
			String ParentOU) throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();

			
			oumangement.ClickexpandonParentOu(ParentOU);
			Thread.sleep(2000);
			
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickOUAssginuserbtn(NewOu);
			oumangement.ClickonAssignusersavebtn();
			oumangement.ValidateNousermovederrormsg();
			editinfo.closeAlertpopup();
			
			oumangement.ClickdeleteonOu(NewOu);
			Thread.sleep(2000);
			
			
			editUser.AcceptDeletebtninusermanagement();
			Thread.sleep(2000);
			oumangement.ValidatDeleteFailOUhaveusermsg();
			Thread.sleep(2000);
			editinfo.closeAlertpopup();
			
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			oumangement.ClickOUAssginuserbtn(NewOu);
			Thread.sleep(2000);
			oumangement.Selectallusereinexistinguserlist();
			Thread.sleep(2000);
			oumangement.ClickonallusermovefromexistinguserlisttoNonuser();
			Thread.sleep(2000);
			oumangement.ClickonAssignusersavebtn();
			Thread.sleep(2000);
			oumangement.ValidateAssignuserSuccessfullmsg();
			Thread.sleep(2000);
			editinfo.closeAlertpopup();
			Thread.sleep(10000);
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_61, build, notes, result);

		}
	}
	
	@Test(dataProvider = "Create_OU_As_SUBOU")
	public void DeleteCreatedOufromPage(String email, String password, String NewOu, String ParentOU) throws Exception {
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			Thread.sleep(2000);
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();

			oumangement.ClickexpandonParentOu(ParentOU);
			Thread.sleep(2000);
			oumangement.ClickdeleteonOu(NewOu);
			Thread.sleep(2000);
			editUser.AcceptDeletebtninusermanagement();
			editinfo.closeAlertpopup();
			driver.navigate().refresh();
			Thread.sleep(2000);
			oumangement.clickOUmanagementBtn();
			oumangement.ClickExpandbtn();
			Thread.sleep(2000);
			oumangement.ClickdeleteonOu(ParentOU);
			Thread.sleep(2000);
			editUser.AcceptDeletebtninusermanagement();
			Thread.sleep(2000);
			editinfo.closeAlertpopup();

			Thread.sleep(10000);
			loginpage.clickLogout();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	

	@AfterMethod
	public void tearDown(ITestResult result) {

		System.out.println("Inside of tearDown Method");

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("Test case passed");
				driver.quit();

			} else if (result.getStatus() == ITestResult.FAILURE) {

				Keywords.captureScreenShot(driver);

				System.out.println("Screenshot taken in Tear Down method");
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
