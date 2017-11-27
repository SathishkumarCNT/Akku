package com.app.akku.work.pageobjects.OUManagement;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;


public class OUmanagementpage extends Keywords {
	ReadfromProperties prop = new ReadfromProperties();

	public OUmanagementpage(WebDriver driver) {
		super(driver);
	}

	public void clickOUmanagementBtn() throws Exception {

		System.out.println("Trying to Click on OU button...");

		click(By.xpath(prop.getAppProperty("Home_OuManagement_btn_xpath")));

		System.out.println("We think we Click on OU button...");
	}

	public void clickAddOUBtn() throws Exception {

		System.out.println("Trying to Click on Add OU button...");

		moveMouse(By.xpath(prop.getAppProperty("OuManagement_Plus_btn_xpath")));

		Thread.sleep(2000);

		click(By.xpath(prop.getAppProperty("OuManagement_AddOu_tooltip_btn_Xpath")));

		System.out.println("We think we Click on Add OU Manually button...");
	}

	public void Enterouname(String NewOu) throws Exception{
		
			System.out.println("Trying to Enter OU Name...");

			type(By.xpath(prop.getAppProperty("OuManagement_AddOu_OuName_Xpath")), NewOu);

			System.out.println("We think Entered OU Name...");
		
		}

	

	public void SelectparentOU(String ParentOU) throws Exception {
		
			System.out.println("Trying to Select Parent OU Name...");

			click(By.xpath(prop.getAppProperty("OuManagement_AddOu_parentOu_Xpath")));
			Thread.sleep(2000);

			driver.findElement(By.xpath("//label[contains(.,'" + ParentOU + "')]")).click();
			click(By.xpath(prop.getAppProperty("OuManagement_AddOu_OuName_Xpath")));

			System.out.println("We think we Selected Parent OU Name...");
		
	}

	public void ClickCreate() throws Exception {
		
			System.out.println("Trying to Click on Create button...");

			click(By.xpath(prop.getAppProperty("OuManagement_AddOu_Create_btn_xpath")));

			System.out.println("We think we Click on Create button...");
		

	}

	public void ValidateSuccessfullmsg() throws Exception {
	

			System.out.println("Verify Updated Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

			String Expected = "OU Successfully Created";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Clicked on Update button...");

	}

	public void ClickExpandbtn() throws Exception {
		
			System.out.println("Trying to Expand OU ...");

			click(By.xpath(prop.getAppProperty("OuManagement_Expand_OU_Xpath")));

			System.out.println("We think Expand or decrease OU ...");
		

	}

	public void ClickOUEditbtn(String NewOu) throws Exception {
	
			System.out.println("Trying to Click OU Name...");

			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[1]")).click();

			System.out.println("We think Click OU Name...");
		

	}

	public void EditeOUName(String ParentOU, String NewOu) throws Exception {
		
			System.out.println("Type OU Name...");
			click(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")));

			System.out.println("Click...");
			// clear(By.id(prop.getAppProperty("OuManagement_Edit_OUName_ID")));

			System.out.println(NewOu);
			int Oulength = NewOu.length();
			System.out.println(Oulength);
			for (int i = 1; i <= Oulength; i++) {
				keytype(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")), Keys.BACK_SPACE);
				System.out.println("Cleared...");
			}
			Thread.sleep(1000);
			type(By.xpath(prop.getAppProperty("OuManagement_Edit_OUName_xpath")), ParentOU);
			System.out.println("Typed...");
			Thread.sleep(2000);

			System.out.println("We think Type OU Name...");
		

	}

	public void Clickonupdate() throws Exception {
	
			System.out.println("Click OU Update button...");

			click(By.xpath(prop.getAppProperty("OuManagement_Edit_OUupdate_Xpath")));

			Thread.sleep(3000);

			System.out.println("We think Click on OU Update update button...");
		

	}

	public void ValidateSuccessfullupdatedmsg()throws Exception {
	
			System.out.println("Verify Updated Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

			String Expected = "OU Successfully Updated";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Clicked on Update button...");

		
	}

	public void Validateupdatefaileddmsg() throws Exception {
		

			System.out.println("Verify Updated Failed Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Edit_Fail_Msg_Xpath")));

			String Expected = "Please Enter the Valid OU Name";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified Failed Message...");

			Thread.sleep(4000);
			driver.navigate().refresh();
		
	}

	public void ValidateDulicateoumsg() throws Exception {
		
			System.out.println("Verify OU Already Exist Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Edit_Duplicate_Msg_Xpath")));

			String Expected = "Ou name already exists";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we OU Already Exist Message...");

			Thread.sleep(4000);
			driver.navigate().refresh();
		
	}

	public void ClickexpandonParentOu(String ParentOu) throws Exception {
	
			System.out.println("Trying to Expand " + ParentOu + " OU ...");

			Thread.sleep(3000);

			WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'" + ParentOu + "')]/../span/span[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'" + ParentOu + "')]/../span/span[1]")).click();

			System.out.println("We think Expanded " + ParentOu + " OU ......");
		
	}

	public void ClickdeleteonOu(String NewOu) throws Exception {
		
			System.out.println("Trying to Delete " + NewOu + " OU...");

			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[2]")).click();

			System.out.println("We think we Deleted " + NewOu + " OU.....");
		

	}

	public void ValidateDeleteOUmsg(String NewOu) throws Exception {

	
			System.out.println("Verify Delete OU Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Delete_Sucess_Msg_Xpath")));

			String Expected = "" + NewOu + " ou successfully deleted";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified Delete Ou Successfully Message...");
		
	}

	public void ValidatDeleteFailOUhavesuboumsg() throws Exception {

		
			System.out.println("Verify Delete OU Failed Message...");

			Thread.sleep(1000);

			String Actual = driver.getPageSource();
			Thread.sleep(3000);
			System.out.println("Need to print" + Actual + "");
			String Expected = "This OU has sub-ou. Cannot delete it.";
			boolean Expected_Result = true;
			// System.out.println(Actual);
			System.out.println(Expected);
			if (Actual.contains(Expected)) {
				boolean Actual_Result = true;
				System.out.println(Actual_Result);
				System.out.println(Expected_Result);
				Assert.assertEquals(Actual_Result, Expected_Result);

			} else {
				boolean Actual_Result = false;
				System.out.println(Actual_Result);
				System.out.println(Expected_Result);
				Assert.assertEquals(Actual_Result, Expected_Result);
			}

			System.out.println("We think we Verified Delete Ou Failed Message...");
		
	}

	public void ValidatDeleteFailOUhaveusermsg() throws Exception {

	
			System.out.println("Verify Delete OU Failed Message...");

			Thread.sleep(1000);

			String Actual = driver.getPageSource();
			Thread.sleep(3000);
			System.out.println("Need to print" + Actual + "");
			String Expected = "This OU has users. Cannot delete it.";
			boolean Expected_Result = true;
			// System.out.println(Actual);
			System.out.println(Expected);
			if (Actual.contains(Expected)) {
				boolean Actual_Result = true;
				System.out.println(Actual_Result);
				System.out.println(Expected_Result);
				Assert.assertEquals(Actual_Result, Expected_Result);

			} else {
				boolean Actual_Result = false;
				System.out.println(Actual_Result);
				System.out.println(Expected_Result);
				Assert.assertEquals(Actual_Result, Expected_Result);
			}

			System.out.println("We think we Verified Delete Ou Failed Message...");
		
	}

	public void ClickOUAssginuserbtn(String NewOu) throws Exception {
	
			System.out.println("Trying to Click " + NewOu + "Assign user button..");

			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]/../div/button[3]")).click();

			System.out.println("We think to Clicked " + NewOu + "Assign user button..");
		

	}

	public void ClickonAllusermovefromNonusertoexistinguserlist() throws Exception {
	
			System.out.println("Try to Move All the user from Non user list to Existing User list...");

			Thread.sleep(3000);

			click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_AllNtoE_btn_Xpath")));

			System.out.println("We think we Moved All the user from Non user list to Existing User list...");
		

	}

	public void ClickononeusermovefromNonusertoexistinguserlist() throws Exception {
		
			System.out.println("Try to Move All the user from Non user list to Existing User list...");

			click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_1NtoE_btn_Xpath")));

			Thread.sleep(3000);

			System.out.println("We think we Moved All the user from Non user list to Existing User list...");
		

	}

	public void ClickononeusermovefromexistinguserlisttoNonuser() throws Exception {
		
			System.out.println("Try to Move All the user from Non user list to Existing User list...");

			click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_1EtoN_btn_Xpath")));

			Thread.sleep(3000);

			System.out.println("We think we Moved All the user from Non user list to Existing User list...");
		
	}

	public void ClickonallusermovefromexistinguserlisttoNonuser() throws Exception {

			System.out.println("Try to Move All the user from Non user list to Existing User list...");

			click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_AllEtoN_btn_Xpath")));

			Thread.sleep(3000);

			System.out.println("We think we Moved All the user from Non user list to Existing User list...");
		

	}

	public void ClickonAssignusersavebtn() throws Exception {
	
			System.out.println("Click On Assign User Save button...");

			Thread.sleep(3000);

			click(By.xpath(prop.getAppProperty("OuManagement_Assignuser_Save_btn_xpath")));

			System.out.println("Clicked...");
			Thread.sleep(3000);

			System.out.println("We think Clicked on On Assign User Save button...");
		
	}

	public void ValidateNousermovederrormsg() throws Exception {
	

			System.out.println("Verify No changes in userlist Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_Assignuser_NoChanges_Errormsg_Xpath")));

			String Expected = "No changes have been made";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified No changes in userlist Message...");

			Thread.sleep(3000);
			driver.navigate().refresh();
		
	}

	public void useravaliableinnonuserlist() throws Exception {
	

			System.out.println("Verify trying to select one user...");

			selectByindexvalue((By.xpath(prop.getAppProperty("OuManagement_select_nonuserlist_xpath"))), 1);

			System.out.println("we think we select one user...");

		}

		
	

	public void useravaliableinexistinglist() throws Exception {
		

			System.out.println("Verify trying to select one user...");

			selectByindexvalue((By.xpath(prop.getAppProperty("OuManagement_select_Existuserlist_xpath"))), 1);

			System.out.println("we think we select one user...");

		}

		
	public void Selectallusereinnonoulist() throws Exception {
		
			System.out.println("Verify trying to select one user...");

			selectall(By.xpath(prop.getAppProperty("OuManagement_select_nonuserlist_xpath")));

			System.out.println("we think we select one user...");

		
	}

	public void Selectallusereinexistinguserlist() throws Exception {
	

			System.out.println("Verify trying to select one user...");

			selectall(By.xpath(prop.getAppProperty("OuManagement_select_Existuserlist_xpath")));

			System.out.println("we think we select one user...");

		}

		

	public void ValidateAssignuserSuccessfullmsg() throws Exception {

			System.out.println("Verify Updated Successfully Message...");

			Thread.sleep(1000);

			String Actual = getText(By.xpath(prop.getAppProperty("OuManagement_AddOu_success_msg_Xpath")));

			String Expected = "Users Successfully Updated";
			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Clicked on Update button...");
		
	}

	

}
