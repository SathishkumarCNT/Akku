package com.app.akku.work.pageobjects.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.aventstack.extentreports.Status;

public class EditUserfromUserManagement extends Keywords {

	ReadfromProperties prop = new ReadfromProperties();

	Logger log = Logger.getLogger(EditUserfromUserManagement.class.getName());
	public static String Logindatetime = null;

	public EditUserfromUserManagement(WebDriver driver) {
		super(driver);

	}

	public void testListOfElements() throws Exception {

		boolean isChecked = false;

		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".userchkbox"));
		int size = radioButtons.size();
		log.info("Size of the list: " + size);

		for (int i = 0; i < size; i++) {

			isChecked = radioButtons.get(i).isSelected();

			if (!isChecked) {
				radioButtons.get(i).click();

			}
		}
	}

	public void clickonUpdatebtn() throws Exception {

		log.info("Trying to Click Edit Update button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Edit_clickonUpdatebtn_xpath")));

		log.info("We think we Clicked on Update button...");

		test.log(Status.INFO, "We think we Clicked on Update button");

	}

	public void clickonEditDeleteSuspendHamburgermenuinusermanagement() throws Exception {

		log.info("Trying to Click on Hamburger menu...");

		click(By.cssSelector(prop.getAppProperty("Akku_UserManagement_select_Hamburgermenu_btn_css")));

		log.info("We think we Clicked on Hamburger menu...");

		test.log(Status.INFO, "We think we Clicked on Hamburger menu");

	}

	public void clickonEditbtninusermanagement() throws Exception {

		log.info("Trying to Click on Edit button...");

		moveMouse(By.linkText(prop.getAppProperty("Akku_UserManagement_Edituser_btn_linktext")));

		Thread.sleep(3000);
		
		click(By.linkText(prop.getAppProperty("Akku_UserManagement_Edituser_btn_linktext")));

		log.info("We think we Clicked on Edit button...");

		test.log(Status.INFO, "We think we Clicked on Edit button");

	}

	public void EditEmailinusermanagement(String NewEmail) throws Exception {

		log.info("Trying to Typing Email ID in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")), NewEmail);
		log.info("We think we Typed Email ID in Edit User management...");

		test.log(Status.INFO, "We think we Typed Email ID in Edit User management :" + NewEmail);

	}

	public void EditFnameinusermanagement(String Fname) throws Exception {

		log.info("Trying to Typing First Name in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")), Fname);
		log.info("We think we Typed First Name in Edit User management...");

		test.log(Status.INFO, "We think we Typed First Name in Edit User management :" + Fname);

	}

	public void EditLnameinusermanagement(String Lname) throws Exception {

		log.info("Trying to Typing Last Name in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")), Lname);

		test.log(Status.INFO, "We think we Typed Last Name in Edit User management :" + Lname);

	}

	public void Editusertypeinusermanagement() throws Exception {

		log.info("Trying to Select User Type in Edit User management...");

		String Usertype_user = "User";
		String readusertype = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Editusertype_xpath")));

		if (readusertype.equals(Usertype_user)) {
			WebElement element = driver.findElement(By.xpath("//*[@id=\"editutype\"]"));
			Select se = new Select(element);
			se.selectByIndex(2);
		} else {
			WebElement element = driver.findElement(By.xpath("//*[@id=\"editutype\"]"));
			Select se = new Select(element);
			se.selectByIndex(1);
		}

		log.info("We think we Selected User Type");
		test.log(Status.INFO, "We think we Selected User Type");
	}

	public void EditusertypeinGSuite() throws Exception {

		log.info("Select User Type in Edit User management...");
		waitTillElementlocate(By.id("userrole"));
		String Usertype_user = "User";
		String readusertype = driver.findElement(By.id("userrole")).getText();
		log.info(readusertype);

		if (readusertype.equals(Usertype_user)) {
			WebElement element = driver.findElement(By.id("userrole"));
			Select se = new Select(element);
			se.selectByIndex(2);
			// se.selectByValue("admin");
		} else {
			WebElement element = driver.findElement(By.id("userrole"));
			Select se = new Select(element);
			se.selectByIndex(1);
			// se.selectByValue("user");
		}

		log.info("We think we Selected User type in Edit User management...");

		test.log(Status.INFO, "We think we Selected User type in Edit User management");

	}

	public void UpdateSucessfulValidate() throws Exception {

		log.info("Trying to Verify Updated Successfully Message...");

		checkPageIsReady();

		boolean Actual = driver.getPageSource().contains("Successfully Updated");

		boolean Expected = Actual;
		log.info(Actual);
		log.info(Expected);

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Clicked on Update button...");

		test.log(Status.INFO, "We think we Clicked on Update button");
	}

	public void updatefailValidation() throws Exception {

		log.info(" Trying to Verfiy Update Fail message");
		waitTillElementlocate(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));
		String errormsg = getvalidationMessage(
				By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

		String Expected = "Please";

		log.info(errormsg);
		log.info(Expected);

		if (errormsg.contains(Expected)) {
			String Actual = "Please";
			Assert.assertEquals(Actual, Expected);

		}

		log.info("We think verified Update Failed message...");

		test.log(Status.INFO, "We think verified Update Failed message");
		driver.navigate().refresh();
	}

	public void CloseEditPopup() throws Exception {

		log.info("Trying to Close Edit Screen ...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Edit_Close_Pop_Xpath")));
		log.info("We think we Close Edit Screen..");

		test.log(Status.INFO, "We think we Close Edit Screen.");

	}

	public void EditemptyEmailinusermanagement() throws Exception {

		log.info(" Trying to Clearing Email ID in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

		log.info("We think we Cleared Email ID in Edit User management...");

		test.log(Status.INFO, "We think we Cleared Email ID in Edit User management");

	}

	public void EditemptyFnameinusermanagement() throws Exception {

		log.info("Trying to Clearing First Name in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));

		log.info("We think we  Cleared First Name in Edit User management...");
		test.log(Status.INFO, "We think we  Cleared First Name in Edit User management");

	}

	public void EditemptyLnameinusermanagement() throws Exception {

		log.info("Trying toClearing Last Name in Edit User management...");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

		log.info("We think we  Cleared Last Name in Edit User management...");
		test.log(Status.INFO, "We think we  Cleared Last Name in Edit User management");

	}

	public void validateEmptyemailidErrormsg() throws Exception {

		log.info("Trying to Verfiy Email ID Error message");

		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

		String Expected = "Please fill out this field.";
		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Email ID Error message...");
		test.log(Status.INFO, "We think we Verified Email ID Error message: " + Actual);
		driver.navigate().refresh();

	}

	public void validateEmptyFnameErrormsg() throws Exception {

		log.info("Trying to Verfiy First Name Error message");

		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));

		String Expected = "Please fill out this field.";
		Assert.assertEquals(Actual, Expected);
		driver.navigate().refresh();
		log.info("We think we Verified First Name Error message...");
		test.log(Status.INFO, "We think we Verified First Name Error message: " + Actual);

	}

	public void validateEmptyLnameErrormsg() throws Exception {

		log.info("Trying to Verfiy Last Name Error message");

		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

		String Expected = "Please fill out this field.";
		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Last Name Error message...");
		test.log(Status.INFO, "We think we Verified Last Name Error message: " + Actual);

		driver.navigate().refresh();

	}

	public void clickonSuspendbtninusermanagement() throws Exception {

		log.info("Trying to Click on Suspend User button...");

		moveMouse(By.linkText(prop.getAppProperty("Akku_UserManagement_suspend_InHamburger_linktext")));

		Thread.sleep(3000);

		click(By.linkText(prop.getAppProperty("Akku_UserManagement_suspend_InHamburger_linktext")));

		log.info("We think we Clicked on Suspend User button");
		test.log(Status.INFO, "We think we Clicked on Suspend User button");

	}

	public void AcceptSuspendbtninusermanagement() throws Exception {

		log.info("Trying to Click on OK in Suspend User PopUp...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));

		log.info("We think we Clicked OK in Suspend User PopUp");
		test.log(Status.INFO, "We think we Clicked OK in Suspend User PopUp");

	}

	public void ValidateSuspendusermsg() throws Exception {

		log.info("Trying to Verify Suspend user Successfully Message...");

	

		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_Accept_xpath")));

		String Expected = "User suspended Successfully";
		log.info(Actual);
		log.info(Expected);

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Suspend user Successfully Message...");
		test.log(Status.INFO, "We think we Verified Suspend user Successfully Message");

	}

	public void clickonDeletebtninusermanagement() throws Exception {

		log.info("Trying to Click on Delete User button...");

		moveMouse(By.cssSelector(prop.getAppProperty("Akku_UserManagement_Delete_InHamburger_css")));

		Thread.sleep(3000);

		click(By.cssSelector(prop.getAppProperty("Akku_UserManagement_Delete_InHamburger_css")));

		log.info("We think we Clicked on Delete User button...");
		test.log(Status.INFO, "We think we Clicked on Delete User button");

	}

	public void AcceptDeletebtninusermanagement() throws Exception {

		log.info("Trying to Click on OK in Delete User PopUp...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
		log.info("We think we Clicked OK in Delete User PopUp...");
		test.log(Status.INFO, "We think we Clicked OK in Delete User PopUp");

	}

	public void ValidateDeleteusermsg() throws Exception {

		log.info("Verify Delete user Successfully Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_Accept_xpath")),
				"User deleteed Successfully");

		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_Accept_xpath")));

		String Expected = "User deleteed Successfully";
		log.info(Actual);
		log.info(Expected);

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Delete user Successfully Message...");

		test.log(Status.INFO, "We think we Verified Delete user Successfully Message");

	}

	public void clickonResetpwdbtninusermanagement() throws Exception {

		log.info("Trying to Click on Reset User button...");

		click(By.cssSelector(prop.getAppProperty("Akku_UserManagement_Resetpwd_btn_css")));

		log.info("We think we Clicked Reset User button...");

		test.log(Status.INFO, "We think we Clicked Reset User button");

	}

	public void typenewpassword(String Newpassword) throws Exception {

		log.info("Trying to Enter Password in the New text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Pwd_xpath")), Newpassword);

		log.info("We think we Entered Password in New text field...");

		test.log(Status.INFO, "We think we Entered Password in New text field :" + Newpassword);
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		log.info("Trying to Enter Password in the Confirm text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_CPwd_xpath")), Confnewpassword);

		log.info("We think we Entered Password in the Confirm text field...");

		test.log(Status.INFO, "We think we Entered Password in the Confirm text field :" + Confnewpassword);
	}

	public void ResetbtnClick() throws Exception {

		log.info("Trying to Click Reset Button...");

		click(By.cssSelector(prop.getAppProperty("Akku_UserManagement_Reset_Btn_btn")));

		log.info("We think we Clicked Reset Button...");

		test.log(Status.INFO, "We think we Clicked Reset Button");
	}

	public void Validateerormsg() throws Exception {

		log.info("trying to verify Error Message...");

		String Expected = "Password must be 8 character with minimum one lowercase, numeric";

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")),
				Expected);
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")));

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified verify Error Message...");
		test.log(Status.INFO, "We think we Verified verify Error Message");

		driver.navigate().refresh();

	}

	public void Validateerormsgforcompwdnotmatch() throws Exception {

		log.info("Trying to verify Error Message...");

		String Expected = "The password does not match. Please enter a correct password";
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")),
				Expected);
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")));

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified verified Confirm password Not matched Error Message...");
		test.log(Status.INFO, "We think we Verified verified Confirm password Not matched Error Message");

		driver.navigate().refresh();

	}

	public void ValidateSuccessfullyresetmsg() throws Exception {

		log.info("Trying to verify Successful Message...");

		String Expected = "Successfully Password Reseted";
		waitTillElementlocate(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Succesmsg_xpath")));
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Succesmsg_xpath")));

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified verify Successful Message...");

		test.log(Status.INFO, "We think we Verified verify Successful Message");

		driver.navigate().refresh();

	}

	public void SearchEmailIdinGrid(String NewEmail) throws Exception {

		log.info("Trying to enter Email Id In search");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), NewEmail);

		log.info("We have entered Email Id In search box");

		test.log(Status.INFO, "We have entered Email Id In search box");

	
	}

	public void SelectChangePwd() throws Exception {

		log.info("Trying to Select Change password on Next login");

		boolean Changpwdinnxtlogin = isSelected(
				By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));

		if (Changpwdinnxtlogin == true) {
			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));

			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));
		} else {
			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));
		}

		log.info("We think we have Select Change password on Next login");

		test.log(Status.INFO, "We think we have Select Change password on Next login");
	}

	public void EnterpwdinChangePage(String Password) throws Exception {

		log.info("Trying to Enter password");

		type(By.xpath(prop.getAppProperty("Akku_Changepwd_Password_xpath")), Password);

		log.info("We Think We Entered password");
		test.log(Status.INFO, "We Think We Entered password: " + Password);

	}

	public void EnterconpwdinChangePage(String conPassword) throws Exception {

		log.info("Trying to Enter Confirm password");

		type(By.xpath(prop.getAppProperty("Akku_Changepwd_ConfirmPwd_xpath")), conPassword);

		log.info("We Think We Enter Confirm password");

		log.info("We Think We Entered Confirm password");
		test.log(Status.INFO, "We Think We Entered password: " + conPassword);

	}

	public void ClickupdatepwdinChangePage() throws Exception {

		log.info("Trying to Click Update Button");

		click(By.xpath(prop.getAppProperty("Akku_Changepwd_Submit_btn_xpath")));

		log.info("We Think We Clicked on Update Button");

		test.log(Status.INFO, "We Think We Clicked on Update Button");

	}

	public void validateChangepasswordmsg() throws Exception {

		log.info("Trying to verify Successful Message...");

		String Expected = "Your password has been updated successfully.";
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_Changepwd_Sucess_msg_xpath")), Expected);

		String Actual = getText(By.xpath(prop.getAppProperty("Akku_Changepwd_Sucess_msg_xpath")));

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified  Successful Message...");
		test.log(Status.INFO, "We Think We Verified Successful Message: " + Actual);

	}

	public void ClickDashboardbtn() throws Exception {

		log.info("Trying to Click Dashboard Button...");

		click(By.xpath(prop.getAppProperty("Akku_Changepwd_Dashboard_btn_xpath")));

		log.info("We think we Click Dashboard Button......");

		log.info("We think we  Clicked Dashboard Button...");
		test.log(Status.INFO, "We Think We Clicked Dashboard Button");

	}

	public void EnterKeywordinsearchtxtbox(String SearchKey) throws Exception {

		log.info("Trying to enter Email Id In search");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);

		log.info("We think we entered Email Id In search box");
		test.log(Status.INFO, "We think we entered Email Id In search box");

		;

	}

	public void ValidateSearchkeyword(String SearchKey) throws Exception {

		log.info("Trying to Verify User Found in List");

		String Filter = SearchKey;
		waitTillElementlocate(By.xpath("//*[@id=\"user-list\"]/tbody/tr"));
		int Row_count = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr")).size();
		log.info("Number Of Rows = " + Row_count);

		int Col_count = 5;
		log.info("Number Of Columns = " + Col_count);

		String first_part = "//*[@id=\"user-list\"]/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";

		boolean Excepted = true;
		for (int i = 1; i <= Row_count; i++) {

			for (int j = 1; j <= Col_count; j++) {

				String final_xpath = first_part + i + second_part + j + third_part;

				String listelement = driver.findElement(By.xpath(final_xpath)).getText();

				if (listelement.contains(Filter)) {

					boolean Actual = true;

					log.info(listelement);
					log.info("We have Verified Enter Text Found in grid");
					test.log(Status.INFO, "We have Verified Enter Text Found in grid");

					Assert.assertEquals(Actual, Excepted);
					break;

				}

			}
		}

	}

	public void Validaterecordnotfoundmsg() throws Exception {

		log.info("Verify User Not Found Message In grid");

		String Except = "No matching records found";

		waitTillAssertElementPresent(By.cssSelector(prop.getAppProperty("Akku_UserManagement_grid_Norecordfound_css")),
				Except);
		String Actual = getText(By.cssSelector(prop.getAppProperty("Akku_UserManagement_grid_Norecordfound_css")));

		log.info(Actual);
		log.info(Except);
		Assert.assertEquals(Actual, Except);

		log.info("We have Verified User Not Found Message In grid");
		test.log(Status.INFO, "We have Verified User Not Found Message In grid");

	}

	public void SelectShowdropdown() throws Exception {

		String Showvalue;
		for (int i = 1; i <= 4; i++)

			if (i == 1) {
				Showvalue = "100";

				int Excepted = 100;

				log.info("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);
				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));

				log.info("We have selected" + Excepted + "From Show dropdown.");

				log.info("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				log.info("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				log.info("Record Count display in grid = " + Row_count);

				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();

			} else if (i == 2) {
				Showvalue = "50";

				int Excepted = 50;

				log.info("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);

				log.info("We have selected" + Excepted + "From Show dropdown.");

				log.info("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				log.info("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,00)", "");
				log.info("Record Count display in grid = " + Row_count);

				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			} else if (i == 3) {
				Showvalue = "25";
				int Excepted = 25;

				log.info("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);

				log.info("We have selected" + Excepted + "From Show dropdown.");

				log.info("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				log.info("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				log.info("Record Count display in grid = " + Row_count);

				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			} else if (i == 4) {
				Showvalue = "10";
				int Excepted = 10;

				log.info("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);

				log.info("We have selected" + Excepted + "From Show dropdown.");

				log.info("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				log.info("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				log.info("Record Count display in grid = " + Row_count);

				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			}
	}

	public void Selectfirstnamelinktxt() throws Exception

	{

		log.info("Trying to Click on Full Name Link Text");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Fname_Linktxt_xpath")));

		log.info(" We Think We Clicked on Full Name Link Text");

		test.log(Status.INFO, "We Think We Clicked on Full Name Link Text");
	}

	public void ValidateEmailinlinktxtpopup(String SearchKey) throws Exception

	{
		String Expected = SearchKey;
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_EmailId_FName_POpup_xpath")),
				Expected);
		log.info("Trying to verify on Ful Name Link Text");
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_EmailId_FName_POpup_xpath")));

		log.info(" We Think We Clicked on Ful Name Link Text");
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);

		log.info("We Think We verified on Email ID in Pop Up: " + Actual);

		test.log(Status.INFO, "We Think We verified on Email ID in Pop Up: " + Actual);

	}

	public void Getdatetime() throws Exception

	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
		Logindatetime = dateFormat.format(new Date()).toString();
		log.info(Logindatetime);

	}

	public void ValidateDatetimefromgrid() throws Exception

	{
		String Expected = Logindatetime;
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_LastloginDatetime_xpath")),
				Expected);
		log.info("Trying to Verify on Last login Date time");
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_LastloginDatetime_xpath")));

		log.info(" We Think We Verified  Lastlogin Datetime");
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);

		log.info("We Think We verified on Last login Date time : " + Actual);

		test.log(Status.INFO, "We Think We verified Last login Date time: " + Actual);
	}

	public void Selectalluser() throws Exception

	{

		log.info("Trying to Select all the Active user in the page");

		// click(By.xpath(prop.getAppProperty("Akku_UserManagement_Alluser_Radio_btn_css")));

		driver.findElement(By.cssSelector(".selAll-container [type]")).click();

		log.info(" We Think We Selected all the Active user from in the page");
		test.log(Status.INFO, " We Think We Selected all the Active user from in the page");

	}

	public void ValidateDeleteandsuspendbtndisplay() throws Exception

	{
		boolean excepted = true;

		log.info("Trying to Verify Delete and Suspend Button displayed in page");
		boolean Deletebtn = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Delete_btn_xpath")));
		boolean Suspend = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspend_btn_xpath")));

		log.info(Deletebtn);
		log.info(Suspend);
		Assert.assertEquals(Deletebtn, excepted);

		Assert.assertEquals(Suspend, excepted);
		log.info(" We Think We Verified  Delete and Suspend Button displayed in page");
		test.log(Status.INFO, " We Think We Verified  Delete and Suspend Button displayed in page");

		driver.navigate().refresh();

	}

	public void ValidateDeleteandActivebtndisplay() throws Exception

	{

		boolean excepted = true;

		log.info("Trying to Verify Delete and Active Button displayed in page");
		boolean Deletebtn = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Delete_btn_xpath")));
		boolean Active = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Active_btn_xpath")));
		log.info(Active);

		log.info(Deletebtn);
		log.info(Active);
		Assert.assertEquals(Deletebtn, excepted);

		Assert.assertEquals(Active, excepted);
		log.info(" We Think We Verified  Delete and Active Button displayed in page");
		test.log(Status.INFO, " We Think We Verified  Delete and Active Button displayed in page");

	}

	public void ValidateSuspendandActivebtndisplay() throws Exception

	{

		boolean excepted = true;

		log.info("Trying to Verify Active and Suspend Button displayed in page");
		boolean Suspend = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspend_btn_xpath")));
		boolean Active = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Active_btn_xpath")));
		log.info(Active);

		log.info(Suspend);
		log.info(Active);
		Assert.assertEquals(Suspend, excepted);

		Assert.assertEquals(Active, excepted);
		log.info(" We Think We Verified  Active and Suspend Button displayed in page");
		test.log(Status.INFO, "We Think We Verified  Active and Suspend Button displayed in page");

	}

	public void SelectSuspenduserfromuserstatusdropdown() throws Exception

	{

		log.info("Trying to Select Suspended User From user Status ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")), "Supended");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		log.info(" We Think We Selected Suspended User From user Status");
		test.log(Status.INFO, "We Think We Selected Suspended User From user Status");

	}

	public void SelectActiveuserfromstatusdropdown() throws Exception

	{

		log.info("Trying to Select Active User From user Status ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")), "Active");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		log.info(" We Think We Selected Active User From user Status");
		test.log(Status.INFO, "We Think We Selected Active User From user Status");

	}

	public void SelectDeleteduserfromstatusdropdown() throws Exception

	{

		log.info("Trying to Select Deleted User From user Status ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")), "Deleted");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		log.info(" We Think We Selected Deleted User From user Status");
		test.log(Status.INFO, "We Think We Selected Deleted User From user Status");

	}

	public void Clicksearchbutton() throws Exception {

		log.info("Trying to Click Search button ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_dropdown_xpath")));

		log.info(" We Think We Clicked Search button");

		test.log(Status.INFO, "We Think We Clicked Search button");
	}

	public void validatemailfoundingrid(String SearchKey) throws Exception {

		log.info("Trying to Verify User Found in List");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);

		String Except = "No matching records found";

		String gridmsginActive = driver.getPageSource();

		log.info(" User Found in Active List" + gridmsginActive);

		if (gridmsginActive.contains(Except)) {

			Searchremailid(SearchKey);

		} else {
			log.info(" User Found in Active List");

		}

	}

	public void Searchremailid(String SearchKey) throws Exception {

		log.info("Trying to Verify User List in Suspend");

		SelectSuspenduserfromuserstatusdropdown();
		Clicksearchbutton();
		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);

		String Except = "No matching records found";

		String gridmsginsuspended = driver.getPageSource();

		if (gridmsginsuspended.contains(Except))

		{

			log.info("We have not found Enter Text in Suspend list" + gridmsginsuspended);
			SelectDeleteduserfromstatusdropdown();
			Clicksearchbutton();
			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
			type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);
			clickonEditDeleteSuspendHamburgermenuinusermanagement();
			click(By.linkText(prop.getAppProperty("Akku_UserManagement_Active_InHamburger_linktext")));
			AcceptDeletebtninusermanagement();
			AcceptDeletebtninusermanagement();
			SelectActiveuserfromstatusdropdown();
			Clicksearchbutton();
			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
			type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);
			clickonEditDeleteSuspendHamburgermenuinusermanagement();
			

		} else {

			clickonEditDeleteSuspendHamburgermenuinusermanagement();
			click(By.linkText(prop.getAppProperty("Akku_UserManagement_Active_InHamburger_linktext")));
			AcceptSuspendbtninusermanagement();
			AcceptSuspendbtninusermanagement();
			SelectActiveuserfromstatusdropdown();
			Clicksearchbutton();
			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
			type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);
			clickonEditDeleteSuspendHamburgermenuinusermanagement();
		
		}
	}

}
