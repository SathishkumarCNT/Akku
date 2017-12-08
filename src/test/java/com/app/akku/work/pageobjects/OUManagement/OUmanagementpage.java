package com.app.akku.work.pageobjects.OUManagement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.app.akku.work.pageobjects.LoginPage.Loginpage;
import com.aventstack.extentreports.Status;

public class OUmanagementpage extends Keywords {
	ReadfromProperties prop = new ReadfromProperties();

	Logger log = Logger.getLogger(OUmanagementpage.class.getName());

	public OUmanagementpage(WebDriver driver) {
		super(driver);
	}

	public void clickOUmanagementBtn() throws Exception {

		log.info("Trying to Click on OU button...");

		click(By.xpath(prop.getAppProperty("Home_OuManagement_btn_xpath")));

		test.log(Status.INFO, "We think we Click on OU button...");

		log.info("We think we Click on OU button...");
	}

	public void clickAddOUBtn() throws Exception {

		log.info("Trying to Click on Add OU button...");

		moveMouse(By.xpath(prop.getAppProperty("OuManagement_Plus_btn_xpath")));
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getAppProperty("OuManagement_AddOU_Manually_css"))));
		click(By.cssSelector(prop.getAppProperty("OuManagement_AddOU_Manually_css")));

		test.log(Status.INFO, "We think we Click on Add OU Manually button...");

		log.info("We think we Click on Add OU Manually button...");
	}

	public void Enterouname(String NewOu) throws Exception {

		log.info("Trying to Enter OU Name...");

		type(By.xpath(prop.getAppProperty("OuManagement_AddOu_OuName_Xpath")), NewOu);

		log.info("We think We Entered OU Name as:" + NewOu);

		test.log(Status.INFO, "We think We Entered OU Name as:" + NewOu);

	}

	public void SelectparentOU(String ParentOU) throws Exception {

		log.info("Trying to Select Parent OU Name...");

		click(By.xpath(prop.getAppProperty("OuManagement_AddOu_parentOu_Xpath")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'" + ParentOU + "')]")));
		driver.findElement(By.xpath("//label[contains(.,'" + ParentOU + "')]")).click();

		click(By.xpath(prop.getAppProperty("OuManagement_AddOu_OuName_Xpath")));

		log.info("We think we Selected Parent OU Name...");

		test.log(Status.INFO, "We think we Selected Parent OU Name" + ParentOU);

	}

	public void ClickCreate() throws Exception {

		log.info("Trying to Click on Create button...");

		boolean Actual = IsDisplayed(By.xpath(prop.getAppProperty("OuManagement_AddOu_Create_btn_xpath")));
		Assert.assertEquals(Actual, true);

		if (Actual = true) {
			click(By.xpath(prop.getAppProperty("OuManagement_AddOu_Create_btn_xpath")));
		} else {
			throw new Exception();
		}

		log.info("We think we Clicked on Create button...");

		test.log(Status.INFO, "We think we Clicked on Create button...");

	}

	public void ValidateSuccessfullmsg() throws Exception {

		log.info("Verify Updated Successfully Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")),
				"OU Successfully Created");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

		String Expected = "OU Successfully Created";
		log.info(Actual);
		log.info(Expected);

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Updated Successfully Message...");

		test.log(Status.INFO, "We think we Verified Updated Successfully Message...");

	}

	public void ClickExpandORCollapsBtn() throws Exception {

		log.info("Trying to Expand or Collaps OU...");

		click(By.xpath(prop.getAppProperty("OuManagement_Expand_OU_Xpath")));

		log.info("We think we Expanded or Collaps OU ...");
		test.log(Status.INFO, "We think we Expanded or Collaps OU ...");

	}

	public void ClickOUEditbtn(String NewOu) throws Exception {

		log.info("Trying to Click Edit OU Name...");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[1]")));

		driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[1]")).click();

		log.info("We think we Clicked On Edit OU Name...");
		test.log(Status.INFO, "We think we clicked on Edit OU Name...");

	}

	public void EditeOUName(String ParentOU, String NewOu) throws Exception {

		log.info("Trying to Clear OU name and Type new OU Name...");

		click(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")));

		log.info("Click...");

		log.info(NewOu);

		int Oulength = NewOu.length();
		log.info(Oulength);
		for (int i = 1; i <= Oulength; i++) {
			keytype(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")), Keys.BACK_SPACE);

		}

		type(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")), ParentOU);

		log.info("We think We Cleared Ou Name and typed New OU Name...");
		test.log(Status.INFO, "We think We Cleared OU Name and typed New OU Name...");

	}

	public void Clickonupdate() throws Exception {

		log.info("Trying to Click OU Update button...");

		click(By.xpath(prop.getAppProperty("OuManagement_Edit_OUupdate_Xpath")));

		log.info("We think Clicked on OU Update update button...");

		test.log(Status.INFO, "We think Clicked on OU Update update button...");

	}

	public void ValidateSuccessfullupdatedmsg() throws Exception {

		log.info("Verifying Updated Successfully Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")),
				"OU Successfully Created");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

		String Expected = "OU Successfully Updated";

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Clicked on Update button...");

		test.log(Status.INFO, "We think we Verified Updated Successfully Message...");

	}

	public void Validateupdatefaileddmsg() throws Exception {

		log.info("Trying to Verify Updated Failed Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_Edit_Fail_Msg_Xpath")),
				"Please Enter the Valid OU Name");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Edit_Fail_Msg_Xpath")));

		String Expected = "Please Enter the Valid OU Name";
		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Failed Message...");
		test.log(Status.INFO, "We think we Verified Failed Message...");

		driver.navigate().refresh();

	}

	public void ValidateDulicateoumsg() throws Exception {

		log.info("Verify OU Already Exist Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_Edit_Duplicate_Msg_Xpath")),
				"Ou name already exists");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Edit_Duplicate_Msg_Xpath")));

		String Expected = "Ou name already exists";

		Assert.assertEquals(Actual, Expected);

		log.info("We think we verified OU Already Exist Message...");
		test.log(Status.INFO, "We think we verified OU Already Exist Message...");

		driver.navigate().refresh();

	}

	public void ClickexpandonParentOu(String ParentOu) throws Exception {

		log.info("Trying to Expand " + ParentOu + " OU ...");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ParentOu + "')]/../span/span[1]")));

		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'" + ParentOu + "')]/../span/span[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

		driver.findElement(By.xpath("//a[contains(text(),'" + ParentOu + "')]/../span/span[1]")).click();

		log.info("We think Expanded " + ParentOu + " OU ......");

		test.log(Status.INFO, "We think Expanded " + ParentOu + "OU");
	}

	public void ClickdeleteonOu(String NewOu) throws Exception {

		log.info("Trying to Delete " + NewOu + " OU...");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[2]")));

		driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[2]")).click();

		log.info("We think we not Deleted " + NewOu + " OU.....");

		test.log(Status.INFO, "We think we Deleted" + NewOu + " OU");

	}

	public void ValidateDeleteOUmsg(String NewOu) throws Exception {

		log.info("Verify Delete OU Successfully Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_Delete_Sucess_Msg_Xpath")),
				"" + NewOu + " ou successfully deleted");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Delete_Sucess_Msg_Xpath")));

		String Expected = "" + NewOu + " ou successfully deleted";

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified Delete Ou Successfully Message...");
		test.log(Status.INFO, "We think we Verified Delete Ou Successfully Message...");

	}

	public void ValidatDeleteFailOUhavesuboumsg() throws Exception {

		log.info("Verify Delete OU Failed Message...");

		checkPageIsReady();

		String Actual = driver.getPageSource();

		String Expected = "This OU has sub-ou. Cannot delete it.";
		boolean Expected_Result = true;

		if (Actual.contains(Expected)) {
			boolean Actual_Result = true;

			Assert.assertEquals(Actual_Result, Expected_Result);

		} else {
			boolean Actual_Result = false;

			Assert.assertEquals(Actual_Result, Expected_Result);
		}

		log.info("We think we Verified Delete Ou Failed Message...");

		test.log(Status.INFO, "We think we Verified Delete Ou Failed Message...");
	}

	public void ValidatDeleteFailOUhaveusermsg() throws Exception {

		log.info("Verify Delete OU Failed Message...");

		checkPageIsReady();
		String Actual = driver.getPageSource();

		String Expected = "This OU has users. Cannot delete it.";
		boolean Expected_Result = true;

		if (Actual.contains(Expected)) {
			boolean Actual_Result = true;

			Assert.assertEquals(Actual_Result, Expected_Result);

		} else {
			boolean Actual_Result = false;

			Assert.assertEquals(Actual_Result, Expected_Result);
		}

		log.info("We think we Verified Delete Ou Failed Message...");

		test.log(Status.INFO, "We think we Verified Delete Ou Failed Message..");
	}

	public void ClickOUAssginuserbtn(String NewOu) throws Exception {

		log.info("Trying to Click " + NewOu + "Assign user button..");

		waitTillElementlocate(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[3]"));

		driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[3]")).click();

		log.info("We think to Clicked " + NewOu + "Assign user button..");

		test.log(Status.INFO, "We think to Clicked " + NewOu + "Assign user button..");
	}

	public void ClickonAllusermovefromNonusertoexistinguserlist() throws Exception {

		log.info("Try to Move All the user from Non user list to Existing User list...");

		click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_AllNtoE_btn_Xpath")));

		log.info("We think we Moved All the user from Non user list to Existing User list...");

		test.log(Status.INFO, "We think we Moved All the user from Non user list to Existing User list...");
	}

	public void ClickononeusermovefromNonusertoexistinguserlist() throws Exception {

		log.info("Try to Move ONE user from Non user list to Existing User list...");

		click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_1NtoE_btn_Xpath")));

		log.info("We think we Moved ONE the user from Non user list to Existing User list...");

		test.log(Status.INFO, "We think we Moved ONE the user from Non user list to Existing User list...");
	}

	public void ClickononeusermovefromexistinguserlisttoNonuser() throws Exception {

		log.info("Try to Move ONE the user from Existing user list to NON User list...");

		click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_1EtoN_btn_Xpath")));

		log.info("Try to Move ONE the user from Existing user list to NON User list...");

		test.log(Status.INFO, "Try to Move ONE the user from Existing user list to NON User list...");

	}

	public void ClickonallusermovefromexistinguserlisttoNonuser() throws Exception {

		log.info("Try to Move ALL the user from Existing user list to NON User list...");

		click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_AllEtoN_btn_Xpath")));

		log.info("We think we Moved All the user from Existing user list to NON User list...");

		test.log(Status.INFO, "Try to Move ONE the user from Existing user list to NON User list...");
	}

	public void ClickonAssignusersavebtn() throws Exception {

		log.info("Click On Assign User Save button...");

		click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_Save_btn_xpath")));

		log.info("We think We Clicked On Assign User Save button...");

		test.log(Status.INFO, "We think We Clicked On Assign User Save button...");
	}

	public void ValidateNousermovederrormsg() throws Exception {

		log.info("Verify No changes in userlist Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_Assignuser_NoChanges_Errormsg_Xpath")),
				"No changes have been made");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Assignuser_NoChanges_Errormsg_Xpath")));

		String Expected = "No changes have been made";

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified No changes in userlist Message...");
		test.log(Status.INFO, "We think we Verified No changes in userlist Message...");

		driver.navigate().refresh();

	}

	public void useravaliableinnonuserlist() throws Exception {

		log.info("trying to select one user from non user list...");

		selectByindexvalue((By.xpath(prop.getAppProperty("OuManagement_select_nonuserlist_xpath"))), 1);

		log.info("we think we selected one user  from Non user list...");

		test.log(Status.INFO, "we think we selected one user in Non user list...");
	}

	public void useravaliableinexistinglist() throws Exception {

		log.info("trying to select one user from existing user list...");

		selectByindexvalue((By.xpath(prop.getAppProperty("OuManagement_select_Existuserlist_xpath"))), 1);

		log.info("we think we selected one user...");

		test.log(Status.INFO, "we think we selected one user in Existing user list...");
	}

	public void Selectallusereinnonoulist() throws Exception {

		log.info("trying to select one user.from non user list..");

		selectall(By.xpath(prop.getAppProperty("OuManagement_select_nonuserlist_xpath")));

		log.info("we think we select edall user from Non user list...");
		test.log(Status.INFO, "we think we selected all user from Non user list");

	}

	public void Selectallusereinexistinguserlist() throws Exception {

		log.info("trying to select one user from Existing user list...");

		selectall(By.xpath(prop.getAppProperty("OuManagement_select_Existuserlist_xpath")));

		log.info("we think we selected all user from Existing user list...");
		test.log(Status.INFO, "we think we selected all user from xisting user list");

	}

	public void ValidateAssignuserSuccessfullmsg() throws Exception {

		log.info("Trying to Verify Updated Successfully Message...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")),
				"Users Successfully Updated");

		String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

		String Expected = "Users Successfully Updated";

		Assert.assertEquals(Actual, Expected);

		log.info("We think we Verified  Sucessfully updated message...");
		test.log(Status.INFO, "We think we Verified  Sucessfully updated message...");
	}

	public void clicksyncOUviagsuieBtn() throws Exception {

		log.info("Trying to Click on Sync OU via G-suite button...");

		moveMouse(By.xpath(prop.getAppProperty("OuManagement_Plus_btn_xpath")));
		Thread.sleep(5000);
	
		click(By.cssSelector(prop.getAppProperty("OuManagement_AddOU_via_G_suite_css")));

		test.log(Status.INFO, "We think we Click on Sync OU via G-suite button...");

		log.info("We think we Click on Sync OU via G-suite button...");
	}
	
	public void clickgsuitetooglebutton() throws Exception {

		log.info("Trying to Click on G-suite Toogle button...");

	
		Thread.sleep(5000);
	
		click(By.cssSelector(prop.getAppProperty("OuManagement_Click_G_suite_Toogle_css")));

		test.log(Status.INFO, "We think we Click on G-suite Toogle  button...");

		log.info("We think we Click on G-suite Toogle  button...");
	}
	
	
	public void clickgsuitemorebutton() throws Exception {

		log.info("Trying to Click on G-suite More button...");

	
		Thread.sleep(5000);
	
		click(By.cssSelector(prop.getAppProperty("OuManagement_Click_G_suite_More_css")));

		test.log(Status.INFO, "We think we Click on G-suite More  button...");

		log.info("We think we Click on G-suite more  button...");
	}


	
	public void clickgsuiteAdminbutton() throws Exception {

		log.info("Trying to Click on G-suite Admin button...");

	
		Thread.sleep(5000);
	
		click(By.xpath(prop.getAppProperty("OuManagement_Click_G_suite_Admin_xpath")));

		test.log(Status.INFO, "We think we Click on G-suite Admin  button...");

		log.info("We think we Click on G-suite Admin  button...");
	}
	
	public void clickgsuiteuserbutton() throws Exception {

		log.info("Trying to Click on G-suite user button...");

	
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getAppProperty("OuManagement_Click_G_suite_user_xpath"))));
	
		click(By.xpath(prop.getAppProperty("OuManagement_Click_G_suite_user_xpath")));

		test.log(Status.INFO, "We think we Click on G-suite user  button...");

		log.info("We think we Click on G-suite user  button...");
	}
	
	

	public void logoutfromgsuite() throws Exception {

		log.info("Trying to logout from Gsuite...");

		
		driver.findElement(By.cssSelector(".gb_ab")).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".gb_Vf")).click();	
	
		
		test.log(Status.INFO, "We think we logout from Gsuite");

		log.info("We think we logout from Gsuite");
	}
	
	public void validateAkkuoulistwithguiteoulist(String email,String password ) throws Exception {

		log.info("Trying to Verify Akku Ou List with Gsuite OU List...");
		
		log.info("Trying to Read OU List...");

		
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getAppProperty("OuManagement_Click_G_suite_Oulist_xpath"))));
		String Oulist = getText(By.xpath(prop.getAppProperty("OuManagement_Click_G_suite_Oulist_xpath")));
		
		test.log(Status.INFO, "We think we Got Ou List :" + Oulist);

		log.info("We think we Got Ou List :" + Oulist);
		
		
		logoutfromgsuite();

		driver.navigate().to("http://pre-prod.akku.work/index.php");
		
		
		
		loginpage.typeUseremail(email);
		loginpage.typepassword(password);
		loginpage.clickLogin();
		oumangement.clickOUmanagementBtn();
		oumangement.ClickExpandORCollapsBtn();
		
		
		String akkuoupagesource = driver.getPageSource();
		boolean Actual = true;
		boolean Excepted =  true;
		
		if(akkuoupagesource.contains(Oulist));
		{
			
			Assert.assertEquals(Actual, Excepted);

			
		}
	
		
		test.log(Status.INFO, "We think we Verified Akku Ou List with Gsuite OU List");

		log.info("We think we Verified Akku Ou List with Gsuite OU List");
	}
}