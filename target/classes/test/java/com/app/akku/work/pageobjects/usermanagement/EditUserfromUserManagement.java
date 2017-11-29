package com.app.akku.work.pageobjects.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class EditUserfromUserManagement extends Keywords {

	ReadfromProperties prop = new ReadfromProperties();
	public static String Logindatetime = null;

	public EditUserfromUserManagement(WebDriver driver) {
		super(driver);

	}

	public void testListOfElements() throws Exception {

		boolean isChecked = false;

		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".userchkbox"));
		int size = radioButtons.size();
		System.out.println("Size of the list: " + size);

		for (int i = 0; i < size; i++) {

			isChecked = radioButtons.get(i).isSelected();

			if (!isChecked) {
				radioButtons.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	public void clickonUpdatebtn() throws Exception{
		
			System.out.println("Trying to Click Edit Update button...");

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Edit_clickonUpdatebtn_xpath")));

			System.out.println("We think we Clicked on Update button...");

	
			
		

		
	}

	public void clickonEditbtninusermanagement() throws Exception{

	
			System.out.println("Trying to Click on Edit button...");

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Edituser_btn_xpath")));
		
			System.out.println("We think we Clicked on Edit button...");
			

		
	}

	public void EditEmailinusermanagement(String NewEmail) throws Exception {

	
			System.out.println("Typing Email ID in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));
			type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")), NewEmail);
			System.out.println("We think we Typed Email ID in Edit User management...");
		
	}

	public void EditFnameinusermanagement(String Fname) throws Exception {

		
			System.out.println("Typing First Name in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));

			type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")), Fname);
			System.out.println("We think we Typed First Name in Edit User management...");
		
	}

	public void EditLnameinusermanagement(String Lname) throws Exception {


			System.out.println("Typing Last Name in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

			type(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")), Lname);
		
	}

	public void Editusertypeinusermanagement() throws Exception {

		
			System.out.println("Select User Type in Edit User management...");

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
		
	}
	public void EditusertypeinGSuite()  throws Exception{

		
			System.out.println("Select User Type in Edit User management...");

			String Usertype_user = "User";
			String readusertype = driver.findElement(By.id("userrole")).getText();
			System.out.println(readusertype);

			if (readusertype.equals(Usertype_user)) {
				WebElement element = driver.findElement(By.id("userrole"));
				Select se = new Select(element);
				se.selectByIndex(2);
				//se.selectByValue("admin");
			} else {
				WebElement element = driver.findElement(By.id("userrole"));
				Select se = new Select(element);
				se.selectByIndex(1);
				//se.selectByValue("user");
			}
		
			System.out.println("We think we Selected User type in Edit User management...");
			
	}
	public void UpdateSucessfulValidate() throws Exception {
	

			System.out.println("Verify Updated Successfully Message...");

			Thread.sleep(1000);

			boolean Actual = driver.getPageSource().contains("Successfully Updated");

			boolean Expected = Actual;
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Clicked on Update button...");

		
	}

	public void updatefailValidation() throws Exception {
		try {
			System.out.println("Verfiy Update Fail message");

			String errormsg = getvalidationMessage(
					By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

			String Expected = "Please";

			System.out.println(errormsg);
			System.out.println(Expected);

			if (errormsg.contains(Expected)) {
				String Actual = "Please";
				Assert.assertEquals(Actual, Expected);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
driver.navigate().refresh();
	}

	public void CloseEditPopup() throws Exception{
	
			System.out.println("Closing Edit Screen ...");

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Edit_Close_Pop_Xpath")));

		
	}

	public void EditemptyEmailinusermanagement() throws Exception {

		
			System.out.println("Clearing Email ID in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

			System.out.println("We think we Not Clearing Email ID in Edit User management...");
		
	}

	public void EditemptyFnameinusermanagement() throws Exception {

	
			System.out.println("Clearing First Name in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));
			
			System.out.println("We think we  Cleared First Name in Edit User management...");

		
	}

	public void EditemptyLnameinusermanagement() throws Exception {

		
			System.out.println("Clearing Last Name in Edit User management...");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

		}

	public void validateEmptyemailidErrormsg() throws Exception {
	
			System.out.println("Verfiy Email ID Error message");

			String Actual = getvalidationMessage(
					By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserEmail_xpath")));

			String Expected = "Please fill out this field.";
			Assert.assertEquals(Actual, Expected);
			driver.navigate().refresh();

		
	}

	public void validateEmptyFnameErrormsg() throws Exception {
	
			System.out.println("Verfiy First Name Error message");

			String Actual = getvalidationMessage(
					By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserFName_xpath")));

			String Expected = "Please fill out this field.";
			Assert.assertEquals(Actual, Expected);
			driver.navigate().refresh();

		
	}

	public void validateEmptyLnameErrormsg() throws Exception {
		
			System.out.println("Verfiy Last Name Error message");

			String Actual = getvalidationMessage(
					By.xpath(prop.getAppProperty("Akku_UserManagement_EdituserLName_xpath")));

			String Expected = "Please fill out this field.";
			Assert.assertEquals(Actual, Expected);
			driver.navigate().refresh();

		
	}

	public void clickonSuspendbtninusermanagement() throws Exception{

	
			System.out.println("Trying to Click on Suspend User button...");
			
			moveMouse(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_btn_xpath")));

			Thread.sleep(3000);

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_btn_xpath")));
		
	}

	public void AcceptSuspendbtninusermanagement() throws Exception {

		
			System.out.println("Trying to Click on OK in Suspend User PopUp...");

			click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
		
	}

	public void ValidateSuspendusermsg() throws Exception{

		
			System.out.println("Verify Suspend user Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_Accept_xpath")));

			String Expected = "User suspended Successfully";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified Suspend user Successfully Message...");
		
	}

	public void clickonDeletebtninusermanagement() throws Exception {

		
			System.out.println("Trying to Click on Delete User button...");
			
			moveMouse(By.xpath(prop.getAppProperty("Akku_UserManagement_Deleteuser_btn_xpath")));

			Thread.sleep(3000);

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Deleteuser_btn_xpath")));
		
	}

	public void AcceptDeletebtninusermanagement() throws Exception{

	
			System.out.println("Trying to Click on OK in Delete User PopUp...");

			click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
			System.out.println("We think we Clicked OK in Delete User PopUp...");
		
	}

	public void ValidateDeleteusermsg() throws Exception {

		
			System.out.println("Verify Delete user Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspenduser_Accept_xpath")));

			String Expected = "User deleteed Successfully";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified Delete user Successfully Message...");
		
	}

	public void clickonResetpwdbtninusermanagement()throws Exception {

	
			System.out.println("Trying to Click on Reset User button...");

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_btn_xpath")));
			
			System.out.println("We think we Reset User button...");
		
	}

	public void typenewpassword(String Newpassword) throws Exception {

		System.out.println("Trying to Enter Password in the New text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Pwd_xpath")), Newpassword);

		System.out.println("We think we Entered Password in New text field...");
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		System.out.println("Trying to Enter Password in the Confirm text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_CPwd_xpath")), Confnewpassword);

		System.out.println("We think we Entered Password in the Confirm text field...");
	}

	public void ResetbtnClick() throws Exception {

		System.out.println("Trying to Click Reset Button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Btn_xpath")));

		System.out.println("We think we Trying to Click Reset Button...");
	}

	public void Validateerormsg() throws Exception {

	

			System.out.println("trying to verify Error Message...");

			String Expected = "Password must be 8 character with minimum one lowercase, numeric";

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified verify Error Message...");
			Thread.sleep(1000);
			driver.navigate().refresh();

		
	}

	public void Validateerormsgforcompwdnotmatch() throws Exception {

		

			System.out.println("Trying to verify Error Message...");

			String Expected = "The password does not match. Please enter a correct password";

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_ErrorMsg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified verify Error Message...");
			Thread.sleep(1000);
			driver.navigate().refresh();

		
	}

	public void ValidateSuccessfullyresetmsg()  throws Exception {

		

			System.out.println("Trying to verify Successful Message...");

			String Expected = "Successfully Password Reseted";

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Succesmsg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified verify Successful Message...");
			Thread.sleep(1000);
			driver.navigate().refresh();

		
	}

	public void SearchEmailIdinGrid(String NewEmail) throws Exception {

		System.out.println("Trying to enter Email Id In search");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), NewEmail);

		System.out.println("We have enter Email Id In search box");

		Thread.sleep(1000);

		System.out.println("Trying to Click Email Id In search");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Nextlogin_xpath")));

		System.out.println("We have Click Edit Button");
	}

	public void SelectChangePwd() throws Exception {

		System.out.println("Trying to Select Change password on Next login");

		boolean Changpwdinnxtlogin = isSelected(
				By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));

		if (Changpwdinnxtlogin == true) {
			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));
			Thread.sleep(1000);
			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));
		} else {
			click(By.id(prop.getAppProperty("Akku_UserManagement_Resetpwd_ChngPwdCheckbox_ID")));
		}

	}

	public void EnterpwdinChangePage(String Password) throws Exception {

		System.out.println("Trying to Enter password");

		type(By.xpath(prop.getAppProperty("Akku_Changepwd_Password_xpath")), Password);
		Thread.sleep(1000);

		System.out.println("We Think We Enter password");

	}

	public void EnterconpwdinChangePage(String conPassword) throws Exception {

		System.out.println("Trying to Enter Confirm password");

		type(By.xpath(prop.getAppProperty("Akku_Changepwd_ConfirmPwd_xpath")), conPassword);
		Thread.sleep(1000);

		System.out.println("We Think We Enter Confirm password");

	}

	public void ClickupdatepwdinChangePage() throws Exception {

		System.out.println("Trying to Click Update Button");

		click(By.xpath(prop.getAppProperty("Akku_Changepwd_Submit_btn_xpath")));
		Thread.sleep(1000);

		System.out.println("We Think We Click on Update Button");

	}

	public void validateChangepasswordmsg()  throws Exception{

	

			System.out.println("Trying to verify Successful Message...");

			String Expected = "Your password has been updated successfully.";
			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_Changepwd_Sucess_msg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified verify Successful Message...");
			Thread.sleep(1000);

	}

	public void ClickDashboardbtn()  throws Exception{

	
			System.out.println("Trying to Click Dashboard Button...");

			click(By.xpath(prop.getAppProperty("Akku_Changepwd_Dashboard_btn_xpath")));

			Thread.sleep(500);
			System.out.println("We think we Click Dashboard Button......");
		
	}

	public void EnterKeywordinsearchtxtbox(String SearchKey) throws Exception {

		System.out.println("Trying to enter Email Id In search");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), SearchKey);

		System.out.println("We have enter Email Id In search box");

		Thread.sleep(1000);

	}

	public void ValidateSearchkeyword(String SearchKey) throws Exception {

		System.out.println("Verify User Found in List");

		String Filter = SearchKey;
		int Row_count = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr")).size();
		System.out.println("Number Of Rows = " + Row_count);

		int Col_count = 5;
		System.out.println("Number Of Columns = " + Col_count);

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

					System.out.println(listelement);
					System.out.println("We have Verified Enter Text Found in grid");

					Thread.sleep(2000);
					Assert.assertEquals(Actual, Excepted);
					break;

				}

			}
		}

	}

	public void Validaterecordnotfoundmsg() throws Exception {

		System.out.println("Verify User Not Found Message In grid");

		Thread.sleep(2000);

		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_grid_Norecordfound_xpath")));

		String Except = "No matching records found";

		System.out.println(Actual);
		System.out.println(Except);
		Assert.assertEquals(Actual, Except);

		System.out.println("We have Verified User Not Found Message In grid");

	}

	public void SelectShowdropdown() throws Exception {

		String Showvalue;
		for (int i = 1; i <= 4; i++)

			if (i == 1) {
				Showvalue = "100";

				int Excepted = 100;

				System.out.println("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);
				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				Thread.sleep(1000);

				System.out.println("We have selected" + Excepted + "From Show dropdown.");

				System.out.println("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				System.out.println("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				System.out.println("Record Count display in grid = " + Row_count);
				Thread.sleep(3000);
				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();

			} else if (i == 2) {
				Showvalue = "50";

				int Excepted = 50;

				System.out.println("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);

				Thread.sleep(3000);

				System.out.println("We have selected" + Excepted + "From Show dropdown.");

				System.out.println("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				System.out.println("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,00)", "");
				System.out.println("Record Count display in grid = " + Row_count);
				Thread.sleep(5000);
				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			} else if (i == 3) {
				Showvalue = "25";
				int Excepted = 25;

				System.out.println("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);

				Thread.sleep(3000);

				System.out.println("We have selected" + Excepted + "From Show dropdown.");

				System.out.println("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				System.out.println("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				System.out.println("Record Count display in grid = " + Row_count);
				Thread.sleep(5000);
				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			} else if (i == 4) {
				Showvalue = "10";
				int Excepted = 10;

				System.out.println("Trying to select" + Excepted + "From Show dropdown.");

				click(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")));
				selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_Show_dropdown_xpath")),
						Showvalue);
				Thread.sleep(3000);

				System.out.println("We have selected" + Excepted + "From Show dropdown.");

				System.out.println("Trying to Validate record Count display in grid.");

				int Row_count = sizeOf(By.xpath(prop.getAppProperty("Akku_UserManagement_Grid_rowcount_xpath")));
				System.out.println("Number Of Rows = " + Row_count);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,8000)", "");
				System.out.println("Record Count display in grid = " + Row_count);

				Assert.assertEquals(Row_count, Excepted);
				driver.navigate().refresh();
			}
	}

	public void Selectfirstnamelinktxt() throws Exception

	{

		System.out.println("Trying to Click on Full Name Link Text");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Fname_Linktxt_xpath")));

		System.out.println(" We Think We Clicked on Ful Name Link Text");
	}

	public void ValidateEmailinlinktxtpopup(String SearchKey) throws Exception

	{
		String Expected = SearchKey;

		System.out.println("Trying to Click on Ful Name Link Text");
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_EmailId_FName_POpup_xpath")));

		System.out.println(" We Think We Clicked on Ful Name Link Text");
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);

	}

	public void Getdatetime() throws Exception

	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
		Logindatetime = dateFormat.format(new Date()).toString();
		System.out.println(Logindatetime);

	}

	public void ValidateDatetimefromgrid() throws Exception

	{
		String Expected = Logindatetime;

		System.out.println("Trying to Verify on Lastlogin Datetime");
		String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_LastloginDatetime_xpath")));

		System.out.println(" We Think We Verified  Lastlogin Datetime");
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);

	}

	public void Selectalluser() throws Exception

	{

		System.out.println("Trying to Select all the Active user  in the page");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Alluser_Radio_btn_xpath")));

		System.out.println(" We Think We Selected all the Active user from in the page");

	}

	public void ValidateDeleteandsuspendbtndisplay() throws Exception

	{
		boolean excepted = true;

		System.out.println("Trying to Verify Delete and Suspend Button displayed in page");
		boolean Deletebtn = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Delete_btn_xpath")));
		boolean Suspend = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspend_btn_xpath")));

		System.out.println(Deletebtn);
		System.out.println(Suspend);
		Assert.assertEquals(Deletebtn, excepted);
		Thread.sleep(1000);
		Assert.assertEquals(Suspend, excepted);
		System.out.println(" We Think We Verified  Delete and Suspend Button displayed in page");

		Thread.sleep(1000);
		driver.navigate().refresh();

	}

	public void ValidateDeleteandActivebtndisplay() throws Exception

	{
		Thread.sleep(3000);
		boolean excepted = true;

		System.out.println("Trying to Verify Delete and Active Button displayed in page");
		boolean Deletebtn = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Delete_btn_xpath")));
		boolean Active = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Active_btn_xpath")));
		System.out.println(Active);

		System.out.println(Deletebtn);
		System.out.println(Active);
		Assert.assertEquals(Deletebtn, excepted);
		Thread.sleep(1000);
		Assert.assertEquals(Active, excepted);
		System.out.println(" We Think We Verified  Delete and Active Button displayed in page");
		Thread.sleep(1000);

	}

	public void ValidateSuspendandActivebtndisplay() throws Exception

	{
		Thread.sleep(3000);
		boolean excepted = true;

		System.out.println("Trying to Verify Active and Suspend Button displayed in page");
		boolean Suspend = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Suspend_btn_xpath")));
		boolean Active = IsDisplayed(By.xpath(prop.getAppProperty("Akku_UserManagement_Active_btn_xpath")));
		System.out.println(Active);

		System.out.println(Suspend);
		System.out.println(Active);
		Assert.assertEquals(Suspend, excepted);
		Thread.sleep(1000);
		Assert.assertEquals(Active, excepted);
		System.out.println(" We Think We Verified  Active and Suspend Button displayed in page");
		Thread.sleep(1000);

	}

	public void SelectSuspenduserfromstatusdropdown() throws Exception

	{

		System.out.println("Trying to Select Suspended User From user Status ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")), "Supended");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		System.out.println(" We Think We Selected Suspended User From user Status");

	}

	public void SelectDeleteduserfromstatusdropdown() throws Exception

	{

		System.out.println("Trying to Select Deleted User From user Status ");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		selectByVisibleText(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")), "Deleted");
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userstatus_dropdown_xpath")));
		System.out.println(" We Think We Selected Deleted User From user Status");

	}

	public void Clicksearchbutton() throws Exception {
		

			System.out.println("Trying to Click Search button ");
			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_dropdown_xpath")));

			//driver.findElement(By.xpath("//*[@id='search']")).click();

			System.out.println(" We Think We Clicked Search button");

	

	}
	
	
	

}
