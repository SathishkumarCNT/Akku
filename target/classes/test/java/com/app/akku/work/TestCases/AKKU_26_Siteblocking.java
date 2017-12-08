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

public class AKKU_26_Siteblocking extends Browser_Setup {
	
	

	String testProject = "AkkuAppTC";
	String testPlan = "AutomateManualTC";
	String AK_21 = "Add Duplicate Site Url with valid Site Description";
	String AK_22 = "Click on Add Site without Entering any Data in Url & Desc text field";
	String AK_23 = "Add Invalid Site Url and valid Site Description in Site Blocking";
	String AK_24 = "Add Valid Site Url and Invalid Site Description in Site Blocking";
	String AK_25 = "Blocking a Site with Valid Site details";
	String AK_26 = "Edit Site Details and save it by Removing url & Description details";
	String AK_27 = "Edit Site Details and save it by Duplicate url & Valid Description details";
	String AK_28 = "Edit Site Details and save it by valid site url & empty site Description";
	String AK_29 = "Edit Site Details and save it by valid site url & valid site Description";
	String AK_30 = "Edit Site Details and save it by Invalid site url & valid site Description";
	String AK_31 = "Delete One Site URL from site Blocked list";
	String build = "Build 2";
	String notes = null;
	String result = null;
	
	Logger log = Logger.getLogger(AKKU_26_Siteblocking.class.getName());

	@DataProvider(name = "SiteBlockingLogin_Details")
	public Object[][] dataProvider_LoginDetails() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "Valid_LoginDetails");

		return testData;
	}

	@DataProvider(name = "InvalidUrlFormat")
	public Object[][] dataProvider_Invalid_UrlFormat() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "InvalidUrlFormat");

		return testData;
	}

	@DataProvider(name = "Edit_SiteBlockingLogin_Details")
	public Object[][] dataProvider_LoginDetails_Siteblock_Edit() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "Edit_Valid_LoginDetails");

		return testData;
	}

	@DataProvider(name = "DuplicateUrl")
	public Object[][] dataProvider_DuplicateUrl() {

		Object[][] testData = poi_Reader_e.readExcelData("..//App_Akku_Work//src//test//resources//input//Login.xlsx",
				"siteBlocking", "DuplicateUrl");

		return testData;
	}

	@Test(dataProvider = "DuplicateUrl", retryAnalyzer = Retry.class)
	public void AK_21_AddDuplicateSiteUrlwithvalidSiteDescription(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_21", "Add Duplicate Site Url with valid Site Description");
		
	
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.typesiteurl(siteURl);
			siteblocking.typesiteDescription(siteDescription);
        	siteblocking.clickonAddbtn();
			siteblocking.AddValidateDuplicateerrormessage();
			loginpage.clickLogout();
			
			log.info("####################################################################");
			result = TestLinkAPIResults.TEST_PASSED;
			notes = "Test Case Pass Successfully";
			
			
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

		}
		finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_21, build, notes, result);

		}
	}
	

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_22_ClickonAddSitewithoutEnteringanyDatainUrlDesctextfield(String email, String password, String siteURl,
			String siteDescription) throws Exception {
		
		test = report.createTest("AK_22", "Click on Add Site without Entering any Data in Url & Desc text field");
		


		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonAddbtn();
			siteblocking.InputSiteUrlErrorMsgValidation();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_22, build, notes, result);

		}
	}

	@Test(dataProvider = "InvalidUrlFormat", retryAnalyzer = Retry.class)
	public void AK_23_AddInvalidSiteUrlandvalidSiteDescriptioninSiteBlocking(String email, String password, String siteURl,
			String siteDescription) throws Exception {
		
		test = report.createTest("AK_23", "Add Invalid Site Url and valid Site Description in Site Blocking");
		

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.typesiteurl(siteURl);
			siteblocking.typesiteDescription(siteDescription);
			siteblocking.clickonAddbtn();
			siteblocking.ErrorPopup_NotAvalidURLMessage();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_23, build, notes, result);

		}
	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_24_AddValidSiteUrlandInvalidSiteDescriptioninSiteBlocking(String email, String password, String siteURl,
			String siteDescription) throws Exception {
		
		test = report.createTest("AK_24", "Add Valid Site Url and Invalid Site Description in Site Blocking");
		

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.typesiteurl(siteURl);
			siteblocking.clickonAddbtn();
			siteblocking.ErrorPopup_PleaseEnterDescription();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_24, build, notes, result);

		}
	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_25_BlockingaSitewithValidSitedetails(String email, String password, String siteURl, String siteDescription)
			throws Exception {
		
		test = report.createTest("AK_25", "Blocking a Site with Valid Site details");

		

		try {
			loginpage.loginpageTitle();
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.typesiteurl(siteURl);
			siteblocking.typesiteDescription(siteDescription);
			siteblocking.clickonAddbtn();
			siteblocking.SuccessPopup_AddUrlSuccessfullyMessage();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_25, build, notes, result);

		}
	}


	@Test(dataProvider = "Edit_SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_26_EditSiteDetailsandsaveitbyRemovingurlDescriptiondetails(String email, String password, String siteURl,
			String siteDescription) throws Exception {
		
		test = report.createTest("AK_26", "Edit Site Details and save it by Removing url & Description details");
		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonEditbtn();
			siteblocking.Clearsiteurl();
			siteblocking.ClearurlDescription();
			siteblocking.InputSiteUrlErrorMsgValidation();
			siteblocking.CloseEditPopup();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_26, build, notes, result);

		}

	}

	@Test(dataProvider = "DuplicateUrl", retryAnalyzer = Retry.class)
	public void AK_27_EditSiteDetailsandsaveitbyDuplicateurlValidDescriptiondetails(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_27", "Edit Site Details and save it by Duplicate url & Valid Description details");
		

		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonEditbtn();
			siteblocking.EditUrl(siteURl);
			siteblocking.EditUrlDescription(siteDescription);
			siteblocking.clickonUpdatebtn();
			siteblocking.EditValidateDuplicateerrormessage();
			
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_27, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_28_EditSiteDetailsandsaveitbyvalidsiteurlemptysiteDescription(String email, String password, String siteURl, String siteDescription)
			throws Exception {
		
		test = report.createTest("AK_28", "Edit Site Details and save it by valid site url & empty site Description");
	
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonEditbtn();
			siteblocking.EditUrl(siteURl);
			siteblocking.ClearurlDescription();
			siteblocking.InputSiteDescriptionErrorMsgValidation();
			siteblocking.CloseEditPopup();
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_28, build, notes, result);

		}

	}

	@Test(dataProvider = "Edit_SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_29_EditSiteDetailsandsaveitbyvalidsiteurlvalidsiteDescription(String email, String password, String siteURl,
			String siteDescription) throws Exception {

		test = report.createTest("AK_29", "Edit Site Details and save it by valid site url & valid site Description");
		
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonEditbtn();
			siteblocking.EditUrl(siteURl);
			siteblocking.EditUrlDescription(siteDescription);
			siteblocking.clickonUpdatebtn();
			siteblocking.Validateurl(siteURl);
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_29, build, notes, result);

		}

	}

	@Test(dataProvider = "InvalidUrlFormat", retryAnalyzer = Retry.class)
	public void AK_30_EditSiteDetailsandsaveitbyInvalidsiteurlvalidsiteDescription(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_30", "Edit Site Details and save it by Invalid site url & valid site Description");
	
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			loginpage.validatedloggedinUserDetailsEmailID(email);
			loginpage.verifyloggedinUserFNameAndLName();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickonEditbtn();
			siteblocking.EditUrl(siteURl);
			siteblocking.EditUrlDescription(siteDescription);
			siteblocking.clickonUpdatebtn();
			siteblocking.ValidateinvalidUrlerrormessage();
			
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_30, build, notes, result);

		}

	}

	@Test(dataProvider = "SiteBlockingLogin_Details", retryAnalyzer = Retry.class)
	public void AK_31_DeleteOneSiteURLfromsiteBlockedlist(String email, String password, String siteURl,
			String siteDescription) throws Exception

	{
		
		test = report.createTest("AK_31", "Delete One Site URL from site Blocked list");
		
	
		try {
			loginpage.loginpageTitle();
			loginpage.typeUseremail(email);
			loginpage.typepassword(password);
			loginpage.clickLogin();
			usermanagement.clickAppmanagementBtn();
			siteblocking.clickonSiteBlockingBtn();
			siteblocking.issiteblockingscreen();
			siteblocking.clickondeltbtnforaddedurl(siteURl);
			siteblocking.clickondeltconfirmation();
			siteblocking.ValidateDeletemessage();
			loginpage.clickLogout();
			
			log.info("####################################################################");
			log.info("Test Case Pass");
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

		}finally {

			log.info("Updating TestCase Execution Status in TestLink");
			TestLinkIntegration.reportResult(testProject, testPlan, AK_31, build, notes, result);

		}

	}

	
}
