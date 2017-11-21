package com.app.akku.work.pageobjects.editinfopage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class EditInformationpage extends Keywords {

	public EditInformationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	ReadfromProperties prop = new ReadfromProperties();

	public boolean isEditInfobtn() throws Exception {

		boolean status = isElementPresent(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath")));

		return status;

	}

	public boolean isPWDEditInformationpage() throws Exception {

		boolean status = isElementPresent(By.xpath(prop.getAppProperty("Editinformatiom_text_xpath")));

		return status;

	}

	public void clickEditbtn() throws Exception {

		System.out.println("Trying to Click on Edit button...");

		
		click(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath")));

		System.out.println("We think we Click on Edit button...");
	}

	public void typeOldpassword(String Oldpassword) throws Exception {

		System.out.println("Trying to Enter Password in Old text field...");

		
		type(By.xpath(prop.getAppProperty("Home_Edit_oldPwd_text_xpath")), Oldpassword);

		System.out.println("We think we Entered Password in Old text field...");
	}

	public void typenewpassword(String Newpassword) throws Exception {

		System.out.println("Trying to Enter Password in the New text field...");

		
		type(By.xpath(prop.getAppProperty("Home_Edit_newPwd_text_xpath")), Newpassword);

		System.out.println("We think we Entered Password in New text field...");
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		System.out.println("Trying to Enter Password in the Confirm text field...");

	
		type(By.xpath(prop.getAppProperty("Home_Edit_confPwd_text_xpath")), Confnewpassword);

		System.out.println("We think we Entered Password in the Confirm text field...");
	}

	public void clickUpdatebtn() throws Exception {

		System.out.println("Trying to Click on Update button...");

		
		click(By.xpath(prop.getAppProperty("Home_Edit_Update_btn_xpath")));

		System.out.println("We think we Click on Update button...");
	}

	public void closeAlertpopup() throws Exception {

		System.out.println("Trying to Click on Popup OK button...");

	
		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
		// CloseAlertBox();

		System.out.println("We think we Click on Popup OK button...");
	}

	public void invalidconfirmpassworderrormsg(String Confnewpassword) throws Exception {

		System.out.println("Trying to Verify Error Message for Invalid Confirm Password...");

		String Expected;

		Expected = "The password does not match. Please enter a correct password";

		String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);

		System.out.println("We think we Verify Confirm Password...");
	}

	public void invalidoldpassworderrormsg(String Oldpassword) throws Exception {

		System.out.println("Trying to Verify Error Message for Invalid Old Password...");
		System.out.println("Invalid Old Password.."+Oldpassword+"");
		
				type(By.xpath(prop.getAppProperty("Home_Edit_oldPwd_text_xpath")),Oldpassword);

				System.out.println("We think we Entered Password in Old text field...");
				clickUpdatebtn();
				Thread.sleep(1000);
				String Expected = "Incorrect old password";
				String Actual = getText(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
				System.out.println(Actual);
				System.out.println(Expected);
				System.out.println(Actual);
				Assert.assertEquals(Actual, Expected);
					
	
		System.out.println("We think we Verifed Error Message for Invalid Old Password...");
	}
	
	
	public void emptyoldpassworderrormsg() throws Exception {

		System.out.println("Trying to Verify Error Message for Empty Old Password...");
				
			clickUpdatebtn();	
			Thread.sleep(1000);
			String Expected = "Please Enter the Old Password";
			String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
			System.out.println(Actual);
			System.out.println(Expected);
			System.out.println(Actual);
			Assert.assertEquals(Actual, Expected);
			
			

		System.out.println("We think we Verifed Error Message for Empty Old Password...");
	}
	
	
	public void emptynewandConfirmpassworderrormsg() throws Exception {

		System.out.println("Trying to Verify Error Message without entering text in New Password and Confirm password...");
				
			Thread.sleep(1000);
			String Expected = "Please Enter the Password";
			String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
			System.out.println(Actual);
			System.out.println(Expected);
			System.out.println(Actual);
			Assert.assertEquals(Actual, Expected);
						
		System.out.println("We think we Verifed Error Message for New Password and Confirm password Empty Field...");
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

		System.out.println("Trying to Validate Password Error message..");
				
			Thread.sleep(1000);
			
			String Expected = "Password must be 8 character with minimum one lowercase, numeric";
			String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
			System.out.println(Actual);
			System.out.println(Expected);
			Assert.assertEquals(Actual, Expected);
			
						
		System.out.println("We think we Verifed  Validate Password Error message...");
	}
	
	public void ValidateErrormessagefornewpwdsameasold() throws Exception {

		System.out.println("Trying to Validate Password Error message..");
				
			Thread.sleep(1000);
			
			String Expected = "Your new password should not match with current password";
			String Actual = getText(By.xpath(prop.getAppProperty("Home_Edit_Update_Errormsg_xpath")));
			System.out.println(Actual);
			System.out.println(Expected);
			Assert.assertEquals(Actual, Expected);
			
						
		System.out.println("We think we Verifed  Validate Password Error message...");
	}
	
	public void ValidateminpassErrormessageforpasswordPolicy() throws Exception
	{
		System.out.println("Trying to Validate Password Error message..");
		
	String ReadHelptext= "DemoLN.DemoLNDemoLN.DemoLNDemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN.DemoLN@demo";
	System.out.println(ReadHelptext);
		

		int password_length= Integer.parseInt(ReadHelptext.replaceAll("[\\D]", ""));
	
		
		System.out.println(password_length);
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        Random random = new Random();
        int randomLen = 1+random.nextInt(password_length);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            s+=c;
        }
         
        System.out.println(s);
    }
		
		
		
		
	}
	

