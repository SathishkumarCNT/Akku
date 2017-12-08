package com.app.akku.work.pageobjects.editinfopage;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.aventstack.extentreports.Status;

public class EditInformationpage extends Keywords {

	Logger log = Logger.getLogger(EditInformationpage.class.getName());

	public EditInformationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	ReadfromProperties prop = new ReadfromProperties();

	public boolean isEditInfobtn() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath"))));
		boolean status = isElementPresent(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath")));

		return status;

	}

	public boolean isPWDEditInformationpage() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getAppProperty("Editinformatiom_text_xpath"))));

		boolean status = isElementPresent(By.xpath(prop.getAppProperty("Editinformatiom_text_xpath")));

		return status;

	}

	public void clickEditbtn() throws Exception {

		try {
			log.info("Trying to Click on Edit button...");

			click(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath")));

			test.log(Status.INFO, "We think we Click on Edit button");

			log.info("We think we Click on Edit button...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void typeOldpassword(String Oldpassword) throws Exception {

		log.info("Trying to Enter Password in Old text field...");

		type(By.xpath(prop.getAppProperty("Home_Edit_oldPwd_text_xpath")), Oldpassword);
		
		test.log(Status.INFO,"We think we Entered Password in Old text field: "+ Oldpassword);

		log.info("We think we Entered Password in Old text field:"+ Oldpassword);
	}

	public void typenewpassword(String Newpassword) throws Exception {

		log.info("Trying to Enter Password in the New text field...");

		type(By.xpath(prop.getAppProperty("Home_Edit_newPwd_text_xpath")), Newpassword);
		
		test.log(Status.INFO,"We think we Entered Password in New text field: "+ Newpassword);

		log.info("We think we Entered Password in New text field...");
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		log.info("Trying to Enter Password in the Confirm text field...");

		type(By.xpath(prop.getAppProperty("Home_Edit_confPwd_text_xpath")), Confnewpassword);
		
		test.log(Status.INFO,"We think we Entered Password in the Confirm text field: "+ Confnewpassword);

		log.info("We think we Entered Password in the Confirm text field...");
	}

	public void clickUpdatebtn() throws Exception {

		log.info("Trying to Click on Update button...");

		click(By.xpath(prop.getAppProperty("Home_Edit_Update_btn_xpath")));
		
		test.log(Status.INFO, "We think we Click on Update button");

		log.info("We think we Click on Update button...");
	}

	public void closeAlertpopup() throws Exception {

		log.info("Trying to Click on Popup OK button...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
		// CloseAlertBox();
		test.log(Status.INFO, "We think we Click on Popup OK button");
		
		log.info("We think we Click on Popup OK button...");
	}

	public void invalidconfirmpassworderrormsg(String Confnewpassword) throws Exception {

		log.info("Trying to Verify Error Message for Invalid Confirm Password...");
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")),"The password does not match. Please enter a correct password");

		String Expected;

		Expected = "The password does not match. Please enter a correct password";

		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO, "We think we Verify Confirm Password: "+ Actual);
		log.info("We think we Verify Confirm Password...");
	}

	public void invalidoldpassworderrormsg(String Oldpassword) throws Exception {

		log.info("Trying to Verify Error Message for Invalid Old Password...");
		log.info("Invalid Old Password.." + Oldpassword + "");

		type(By.xpath(prop.getAppProperty("Home_Edit_oldPwd_text_xpath")), Oldpassword);

		log.info("We think we Entered Password in Old text field...");
		clickUpdatebtn();
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")),"Incorrect old password");

		String Expected = "Incorrect old password";
		String Actual = getText(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
		log.info(Actual);
		log.info(Expected);
		
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Verifed Error Message for Invalid Old Password : "+ Actual);
		log.info("We think we Verifed Error Message for Invalid Old Password...");
	}

	public void emptyoldpassworderrormsg() throws Exception {

		log.info("Trying to Verify Error Message for Empty Old Password...");

	
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")),"Please Enter the Old Password");
		String Expected = "Please Enter the Old Password";
		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		log.info(Actual);
		log.info(Expected);
		log.info(Actual);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Verifed Error Message for Empty Old Password : "+ Actual);
		log.info("We think we Verifed Error Message for Empty Old Password...");
	}

	public void emptynewandConfirmpassworderrormsg() throws Exception {

		log.info("Trying to Verify Error Message without entering text in New Password and Confirm password...");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")),"Please Enter the Password");
		String Expected = "Please Enter the Password";
		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		log.info(Actual);
		log.info(Expected);
		log.info(Actual);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Verifed Error Message for New Password and Confirm password Empty Field : "+ Actual);
		log.info("We think we Verifed Error Message for New Password and Confirm password Empty Field...");
	}

	public void updatenewpassword(String Oldpassword, String Newpassword, String Confnewpassword) throws Exception {

		clickEditbtn();
		isPWDEditInformationpage();
		typeOldpassword(Oldpassword);
		typenewpassword(Newpassword);
		typeConfnewpassword(Confnewpassword);
		clickUpdatebtn();
		closeAlertpopup();
	}

	public void ValidateErrormessageforpasswordPolicy() throws Exception {

		log.info("Trying to Validate Password Error message..");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")),"Password must be 8 character with minimum one lowercase, numeric");

		String Expected = "Password must be 8 character with minimum one lowercase, numeric";
		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		
		test.log(Status.INFO,"We think we Verifed  Validate Password Error message : "+ Actual);

		log.info("We think we Verifed  Validate Password Error message...");
	}

	public void ValidateErrormessagefornewpwdsameasold() throws Exception {

		log.info("Trying to Validate Password Error message..");

		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")),"Your new password should not match with current password");

		String Expected = "Your new password should not match with current password";
		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		
		test.log(Status.INFO,"We think we Verifed  Validate Password Error message: "+ Actual);

		log.info("We think we Verifed  Validate Password Error message...");
	}

	public void ValidateminpassErrormessageforpasswordPolicy() throws Exception {
		log.info("Trying to Validate Password Error message..");

		String ReadHelptext = "DemoLN.DemoLNDemoLN.DemoLNDemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN@demo";
		log.info(ReadHelptext);

		int password_length = Integer.parseInt(ReadHelptext.replaceAll("[\\D]", ""));

		log.info(password_length);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String s = "";
		Random random = new Random();
		int randomLen = 1 + random.nextInt(password_length);
		for (int i = 0; i < randomLen; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			s += c;
		}

		log.info(s);
	}

}
