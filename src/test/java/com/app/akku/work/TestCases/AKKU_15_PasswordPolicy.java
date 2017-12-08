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

public class AKKU_15_PasswordPolicy extends Browser_Setup {
	
	Logger log = Logger.getLogger(AKKU_15_PasswordPolicy.class.getName());

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_15 = "Update Pwd policy by selecting only one Pwd Complexity";
	String AK_16 = "Update Pwd policy by selecting more than one Pwd Complexity";
	String AK_17 = "Update Password Length with invalid data";
	String AK_18 = "Update Password Length with valid data";
	String AK_19 = "Verify if Expiration of Pwd is displayed when Enable Pwd Expiry Radio btn Checked";
	String AK_20 = "Verify if Expiration of Pwd is hide, when Enable Pwd Expiry Radio is unchecked";
	String AK_62 = "Create new parent OU and set password policy";
	String AK_63 = "Create new Sub OU and set password policy";
	String AK_64 = "Update password policy for  parent OU";
	String AK_65 = "Update password policy for Child OU";
	String AK_66 = "Verify Password Help text display based on parent OU Password policy details";
	String AK_67 = "Verify Password Help text display based on Sub OU Password policy details";

	String build = "Build 2";
	String notes = null;
	String result = null;

	@DataProvider(name = "SiteBlockingLogin_Details")
	public Object[][] dataProvider_LoginDetails() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "Valid_LoginDetails");

		return testData;
	}

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

	@DataProvider(name = "Verify_OU_As_Pwdpolicy")
	public Object[][] dataProvider_ClientName_VerifyoupasswordPolicy() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"Create_Edit_Delete_Assign_OU", "VerfiyOUpasswordpolicy");

		return testData;
	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_15_UpdatePwdpolicybyselectingonlyonePwdComplexity(String email, String password, String siteURl,
			String siteDescription) throws Exception{

	test = report.createTest("AK_15", "Update Pwd policy by selecting only one Pwd Complexity");
	

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.SelectonepwdComplexity();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateerrormsgforonepwdComplexity();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

			// loginpage.clickLogout();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_15, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_16_UpdatePwdpolicybyselectingmorethanonePwdComplexity(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		test = report.createTest("AK_16", "Update Pwd policy by selecting more than one Pwd Complexity");
		

		try {
			for (int i = 1; i <= 3; i++) {
				if (i == 1) {

					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					usermanagement.clickAppmanagementBtn();
					Pwdpolicy.SelecttwopwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					loginpage.clickLogout();

				}
				if (i == 2) {
					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					usermanagement.clickAppmanagementBtn();
					Pwdpolicy.SelectthreepwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					Thread.sleep(2000);
					loginpage.clickLogout();

				}
				if (i == 3) {
					loginpage.loginpageTitle();
					loginpage.typeUseremail(email);
					loginpage.typepassword(password);
					loginpage.clickLogin();
					loginpage.validatedloggedinUserDetailsEmailID(email);
					loginpage.verifyloggedinUserFNameAndLName();
					usermanagement.clickAppmanagementBtn();
					Pwdpolicy.SelectfourpwdComplexity();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateSucessfullyaddedmsg();
					loginpage.clickLogout();

				}
			}

			// loginpage.clickLogout();

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_16, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_17_UpdatePasswordLengthwithinvaliddata(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_17", "Update Password Length with invalid data");
		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();

			for (int i = 1; i <= 3; i++) {
				if (i == 1) {
					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.Validateerrormsgforblankpwdlength();
					Pwdpolicy.closeAlertpopup();

				}
				if (i == 2) {

					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.EnterCharinpwdlength();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.ValidateerrormsgforCharinpwdlength();

				}
				if (i == 3) {
					Pwdpolicy.Clearpwdlength();
					Pwdpolicy.Enterpwdlengthof7char();
					Pwdpolicy.Clickonsave();
					Pwdpolicy.Validateerrormsgforpwdlength7char();

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_17, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_18_UpdatePasswordLengthwithvaliddata(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_18", "Update Password Length with valid data");
		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.Entervalidpwdlength();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_18, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_19_VerifyifExpirationofPwdisdisplayedwhenEnablePwdExpiryRadiobtnChecked(String email,
			String password, String siteURl, String siteDescription) throws Exception

	{
		test = report.createTest("AK_19", "Verify if Expiration of Pwd is displayed when Enable Pwd Expiry Radio btn Checked");

		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.VerifyExpirationofPwddispaly();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_19, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_20_VerifyifExpirationofPwdishidehenEnablePwdExpiryRadioisunchecked(String email, String password,
			String siteURl, String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_20", "Verify if Expiration of Pwd is hide, when Enable Pwd Expiry Radio is unchecked");
	
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.DisablePasswordExpiry();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.VerifyExpirationofPwddisable();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_20, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void Updateoldpasswordpolicy(String email, String password, String siteURl, String siteDescription)
			throws Exception

	{

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			Pwdpolicy.ChangeEntervalidpwdlength();

			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.SelecttwopwdComplexity();

			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			loginpage.clickLogout();
		}catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test(dataProvider = "Create_OU", retryAnalyzer = Retry.class)
	public void AK_62_CreatenewparentOUandsetpasswordpolicy(String email, String password, String NewOu,
			String ParentOU) throws Exception

	{
		
		test = report.createTest("AK_62", "Create new parent OU and set password policy");
		
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
			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			Pwdpolicy.ClickOnparentOU(NewOu);
			Pwdpolicy.ChangeEntervalidpwdlength();
			Pwdpolicy.SelecttwopwdComplexity();
			Pwdpolicy.EnablePasswordExpiry();

			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			loginpage.clickLogout();

			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;

		} 
		
		catch (Exception e) {
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();
			//e.getMessage();
		}
		catch (AssertionError e) {

			String message = e.getMessage();
			log.info(message);
			result = TestLinkAPIResults.TEST_FAILED;
			notes = e.getMessage();
			e.printStackTrace();
			Assert.fail();
			

		} finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_62, build, notes, result);

		}

	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void AK_63_CreatenewSubOUandsetpasswordpolicy(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		
		test = report.createTest("AK_63", "Create new Sub OU and set password policy");

		
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

			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			Pwdpolicy.ClickOnparentOU(NewOu);
			Pwdpolicy.ChangeEntervalidpwdlengthasten("10");
			Pwdpolicy.SelectthreepwdComplexity();
			Pwdpolicy.EnablePasswordExpiry();

			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_63, build, notes, result);

		}
	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void AK_64_UpdatepasswordpolicyforparentOU(String email, String password, String NewOu, String ParentOU)
			throws Exception {
		
		test = report.createTest("AK_64", "Update password policy for  parent OU");
		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			Pwdpolicy.ClickOnparentOU(ParentOU);
			Pwdpolicy.ChangeEntervalidpwdlengthasten("12");
			Pwdpolicy.SelectfourpwdComplexity();
			Pwdpolicy.EnablePasswordExpiry();

			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			Pwdpolicy.ClickOnparentOU(NewOu);
			Pwdpolicy.verifySubOupasswordlengthlsochange("12");
			Pwdpolicy.VerifySubOUPasswordComplexity();

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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_64, build, notes, result);

		}

	}

	@Test(dataProvider = "Create_OU_As_SUBOU", retryAnalyzer = Retry.class)
	public void Ak_65_UpdatepasswordpolicyforChildOU(String email, String password, String NewOu, String ParentOU)
			throws Exception

	{
		test = report.createTest("AK_65", "Update password policy for Child OU");
		

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			Pwdpolicy.ClickOnparentOU(NewOu);
			Pwdpolicy.ChangeEntervalidpwdlengthasten("08");
			Pwdpolicy.SelecttwopwdComplexity();
			Pwdpolicy.EnablePasswordExpiry();
			Pwdpolicy.Clickonsave();
			Pwdpolicy.ValidateSucessfullyaddedmsg();
			usermanagement.clickAppmanagementBtn();
			oumangement.ClickExpandORCollapsBtn();
			oumangement.ClickexpandonParentOu(ParentOU);
			Pwdpolicy.ClickOnparentOU(ParentOU);
			Pwdpolicy.verifySubOupasswordlengthlsochange("12");
			Pwdpolicy.VerifySubOUPasswordComplexity();
			Pwdpolicy.VerifySubOUPasswordComplexity();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_65, build, notes, result);

		}

	}

	@Test(dataProvider = "Verify_OU_As_Pwdpolicy", retryAnalyzer = Retry.class)
	public void Ak_66_VerifyPasswordHelptextdisplaybasedonparentOUPasswordpolicydetails(String email, String password,
			String NewOu, String ParentOU, String SearchEmail) throws Exception

	{
		test = report.createTest("AK_66", "Verify Password Help text display based on parent OU Password policy details");
		

		try {

			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();

			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchEmail);
			editUser.ValidateSearchkeyword(SearchEmail);
			Pwdpolicy.clickonEditbtninusermanagement();
			Pwdpolicy.SelectParentOU(ParentOU);
			editUser.clickonUpdatebtn();
			editUser.UpdateSucessfulValidate();
			editinfo.closeAlertpopup();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchEmail);
			editUser.ValidateSearchkeyword(SearchEmail);
			Pwdpolicy.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword("Password@2345");
			editUser.typeConfnewpassword("Password@2345");
			editUser.ResetbtnClick();
			editUser.ValidateSuccessfullyresetmsg();
			loginpage.clickLogout();
			loginpage.typeUseremail(SearchEmail);
			loginpage.typepassword("Password@2345");
			loginpage.clickLogin();
			editUser.EnterpwdinChangePage("Password@1234");
			editUser.EnterconpwdinChangePage("Password@1234");
			Pwdpolicy.verifychildhelptextmessage(
					"Password must be 12 character with minimum one   lowercase,   uppercase,  numeric,  special character");
			editUser.ClickupdatepwdinChangePage();
			editUser.validateChangepasswordmsg();
			editUser.ClickDashboardbtn();
			driver.navigate().to("http://pre-prod.akku.work/");
			loginpage.typeUseremail(SearchEmail);
			loginpage.typepassword("Password@1234");
			loginpage.clickLogin();
			editinfo.isEditInfobtn();
			Pwdpolicy.clickEditbtn();
			Pwdpolicy.typeOldpassword("Password@1234");
			Pwdpolicy.verifychildhelptextmessage(
					"Password must be 12 character with minimum one   lowercase,   uppercase,  numeric,  special character");
			Pwdpolicy.typenewpassword("Password@12345");
			Pwdpolicy.typeConfnewpassword("Password@12345");
			Pwdpolicy.clickUpdatebtn();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_66, build, notes, result);

		}

	}

	@Test(dataProvider = "Verify_OU_As_Pwdpolicy", retryAnalyzer = Retry.class)
	public void Ak_67_VerifyPasswordHelptextdisplaybasedonSubOUPasswordpolicydetails(String email, String password,
			String NewOu, String ParentOU, String SearchEmail) throws Exception

	{
		test = report.createTest("AK_67", "Verify Password Help text display based on Sub OU Password policy details");

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchEmail);
			editUser.ValidateSearchkeyword(SearchEmail);
			Pwdpolicy.clickonEditbtninusermanagement();
			Pwdpolicy.SelectchildOU(ParentOU, NewOu);
			editUser.clickonUpdatebtn();
			editUser.UpdateSucessfulValidate();
			editinfo.closeAlertpopup();
			usermanagement.clickUsermanagementBtn();
			editUser.EnterKeywordinsearchtxtbox(SearchEmail);
			editUser.ValidateSearchkeyword(SearchEmail);
			Pwdpolicy.clickonResetpwdbtninusermanagement();
			editUser.typenewpassword("password2");
			editUser.typeConfnewpassword("password2");
			editUser.ResetbtnClick();
			editUser.ValidateSuccessfullyresetmsg();
			loginpage.clickLogout();
			loginpage.typeUseremail(SearchEmail);
			loginpage.typepassword("password2");
			loginpage.clickLogin();
			editUser.EnterpwdinChangePage("password3");
			editUser.EnterconpwdinChangePage("password3");
			Pwdpolicy.verifychildhelptextmessage("Password must be 08 character with minimum one   lowercase,  numeric");
			editUser.ClickupdatepwdinChangePage();
			editUser.validateChangepasswordmsg();
			editUser.ClickDashboardbtn();
			driver.navigate().to("http://pre-prod.akku.work/");
			loginpage.typeUseremail(SearchEmail);
			loginpage.typepassword("password3");
			loginpage.clickLogin();
			editinfo.isEditInfobtn();
			Pwdpolicy.clickEditbtn();
			Pwdpolicy.typeOldpassword("password3");
			Pwdpolicy.verifychildhelptextmessage("Password must be 08 character with minimum one   lowercase,  numeric");
			Pwdpolicy.typenewpassword(password);
			Pwdpolicy.typeConfnewpassword(password);
			Pwdpolicy.clickUpdatebtn();
			editinfo.closeAlertpopup();
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
			TestLinkIntegration.reportResult(testProject, testPlan, AK_67, build, notes, result);

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

		}
	}
	

	
}
