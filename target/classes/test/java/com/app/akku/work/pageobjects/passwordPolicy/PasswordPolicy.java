package com.app.akku.work.pageobjects.passwordPolicy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class PasswordPolicy extends Keywords {

	public int pwdlen;

	public PasswordPolicy(WebDriver driver) {
		super(driver);

	}

	ReadfromProperties prop = new ReadfromProperties();

	public void clickonpwdpolicyBtn() throws Exception {

		System.out.println("Trying to Click on Password Policy button...");

		click(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_btn_xpath ")));

		System.out.println("We think we Click on Password Policy button...");
	}
	
	public void Clearpwdlength() throws Exception {

		System.out.println("Trying to Clear on Min password Length field");

		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		System.out.println("We think we Clear on Min password Length field");
	}

	public void Clickonsave() throws Exception {

		System.out.println("Trying to Click on Password Policy Save button..");

		click(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_Save_btn_xpath")));

		System.out.println("We think we Click on Password Policy Save button.");

	}

	public void Validateerrormsgforblankpwdlength() throws Exception {

		System.out.println("Trying to verify Password Policy Error Message..");

		String Expected = "Updation failed. Please try after some time.";
		String Actual = getText(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
		System.out.println("We think we Trying to verified Password Policy Error Message.");

	}

	public void closeAlertpopup() throws Exception {

		System.out.println("Trying to Click on Popup OK button...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));

		System.out.println("We think we Click on Popup OK button...");
	}

	public void EnterCharinpwdlength() throws Exception {

		System.out.println("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "e");

		System.out.println("We think we Clear on Min password Length field");
	}

	public void ValidateerrormsgforCharinpwdlength() throws Exception {

		System.out.println("Trying to verify Password Policy Error Message..");

		String Expected = "Please enter a number.";
		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
		System.out.println("We think we Trying to verified Password Policy Error Message.");
		driver.navigate().refresh();

	}

	public void Enterpwdlengthof7char() throws Exception {

		System.out.println("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "7");

		System.out.println("We think we Clear on Min password Length field");
	}

	public void Validateerrormsgforpwdlength7char() throws Exception {

		System.out.println("Trying to verify Password Policy Error Message..");

		String Expected = "Value must be greater than or equal to 8.";
		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
		System.out.println("We think we Trying to verified Password Policy Error Message.");
		driver.navigate().refresh();

	}

	public void SelectonepwdComplexity() throws Exception {

		System.out.println("Trying to Select One password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		System.out.println("Upper Case: " + Uppercase + "");
		System.out.println("Lower Case: " + lowercase + "");
		System.out.println("Numeric Case: " + numeric + "");
		System.out.println("special Case: " + special + "");

		if (Uppercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we UnSelect Uppercase...");

		}
		if (lowercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select UnSpecial Character...");

		}

		System.out.println("We think we Select One password Complexity...");
	}

	public void SelecttwopwdComplexity() throws Exception {

		System.out.println("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		System.out.println("Upper Case: " + Uppercase + "");
		System.out.println("Lower Case: " + lowercase + "");
		System.out.println("Numeric Case: " + numeric + "");
		System.out.println("special Case: " + special + "");

		if (Uppercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we UnSelect Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select UnSpecial Character...");

		}

		System.out.println("We think we Select two password Complexity...");
	}

	public void SelectthreepwdComplexity() throws Exception {

		System.out.println("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		System.out.println("Upper Case: " + Uppercase + "");
		System.out.println("Lower Case: " + lowercase + "");
		System.out.println("Numeric Case: " + numeric + "");
		System.out.println("special Case: " + special + "");

		if (Uppercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we UnSelect Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select UnSpecial Character...");

		}

		System.out.println("We think we Select two password Complexity...");
	}

	public void SelectfourpwdComplexity() throws Exception {

		System.out.println("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		System.out.println("Upper Case: " + Uppercase + "");
		System.out.println("Lower Case: " + lowercase + "");
		System.out.println("Numeric Case: " + numeric + "");
		System.out.println("special Case: " + special + "");

		if (Uppercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we UnSelect Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select Numeric...");

		}
		if (special == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
			Thread.sleep(500);
			System.out.println("We think we Select UnSpecial Character...");

		}

		System.out.println("We think we Select two password Complexity...");
	}

	public void ValidateerrormsgforonepwdComplexity() throws Exception {

		System.out.println("Trying to verify Password Complixty Error Message..");

		String Expected = "Check at least two checkboxs in Password Complexity.";
		String Actual = getText(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
		System.out.println("We think we Trying to verified Password Complixty Error Message.");
		Thread.sleep(1000);
		driver.navigate().refresh();

	}

	public void Entervalidpwdlength() throws Exception

	{
		System.out.println("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "9");

		System.out.println("We think we Clear on Min password Length field");
	}
	
	public void ChangeEntervalidpwdlength() throws Exception

	{
		System.out.println("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "8");

		System.out.println("We think we Clear on Min password Length field");
	}

	public void ValidateSucessfullyaddedmsg() throws Exception {

		System.out.println("Trying to verify Password policy Updated Message..");

		Thread.sleep(2000);
		String Expected = "Successfully Updated";
		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Confirm_Message_Xpath")));
		
		
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
		System.out.println("We think we Trying to verified Password policy Updated Message.");
		driver.navigate().refresh();

	}

	public void EnablePasswordExpiry() throws Exception

	{
		System.out.println("Trying to Enable Password Expiry");

		boolean Enablepwdexpriy = isSelected(
				By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		System.out.println(Enablepwdexpriy);

		if (Enablepwdexpriy == false) {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		} else {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));
			Thread.sleep(1000);
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		}

		System.out.println("We think we Clear on Min password Length field");
	}
	
	public void DisablePasswordExpiry() throws Exception

	{
		System.out.println("Trying to Disable Password Expiry");

		boolean Enablepwdexpriy = isSelected(
				By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		System.out.println(Enablepwdexpriy);

		if (Enablepwdexpriy == false) {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		} else {
			
			Thread.sleep(1000);
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		}

		System.out.println("We think we Disable Password Expiry");
		
	}

	public void VerifyExpirationofPwddisable() throws Exception

	{

		System.out.println("Trying to Verify Expiration of Password Option Disabale");

		boolean Actual = IsDisplayed(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")));

		Assert.assertEquals(Actual, false);

		System.out.println("We think we Verify Expiration of Password Option Disabale");
		driver.navigate().refresh();

	}
	
	public void VerifyExpirationofPwddispaly() throws Exception

	{

		System.out.println("Trying to Verify Expiration of Password Option enable");

		boolean Actual = IsDisplayed(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")));

		Assert.assertEquals(Actual, true);

		System.out.println("We think we Verify Expiration of Password Option enabled");

		System.out.println("Trying to Select Expiration of Password 60 Days");

		selectBy(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")), 2);
		System.out.println("We think we Selected Expiration as Password 60 Days");
		

	}

}
