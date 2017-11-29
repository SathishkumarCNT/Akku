package com.app.akku.work.pageobjects.passwordPolicy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetPageSource;
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
		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "8");

		System.out.println("We think we Clear on Min password Length field");
	}

	public void ChangeEntervalidpwdlengthasten(String length) throws Exception

	{
		System.out.println("Trying to Clear on Min password Length field");
		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), length);

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

	public void ClickOnparentOU(String NewOu) throws Exception {

		System.out.println("Trying to Click OU Name...");

		Thread.sleep(3000);
		boolean A = driver.findElement(By.xpath("//a[contains(text()," + NewOu + ")]")).isDisplayed();
		System.out.println(A);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'" + NewOu + "')]")).click();

		System.out.println("We think Click OU Name...");

	}

	public void verifySubOupasswordlengthlsochange(String NewOu) throws Exception {

		Thread.sleep(5000);
		System.out.println("Validating Sub OU Password Length");
		String passwordlength = driver.getPageSource();
		System.out.println(passwordlength);
		System.out.println(NewOu);
		if (passwordlength.contains(NewOu)) {
			String Actual = NewOu;
			String Excepted = NewOu;
			Assert.assertEquals(Actual, Excepted);
			System.out.println("We think we Validating Sub OU Password Length");

		}

	}

	public void VerifySubOUPasswordComplexity() throws Exception {

		System.out.println("Validating Password Complexity ");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		Assert.assertEquals(Uppercase, true);
		Assert.assertEquals(lowercase, true);
		Assert.assertEquals(numeric, true);
		Assert.assertEquals(special, true);

		System.out.println("We think we Validate Password Complexity");
	}

	public void clickonEditbtninusermanagement() {

		try {
			System.out.println("Trying to Click on Edit button...");

			click(By.xpath(prop.getAppProperty("Akku_OuManagementUserOU_Edit_btn_xpath")));
		} catch (Exception e) {
			System.out.println("We think we Clicked on Edit button...");
			e.printStackTrace();

		}
	}

	public void SelectParentOU(String parentOU) throws Exception {

		System.out.println("Trying to Select " + parentOU + " OU Name...");

		click(By.xpath(prop.getAppProperty("Akku_UserOU_Edit_btn_xpath")));

		List<WebElement> liElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul"));

		System.out.println(liElements.size());

		for (int i = 1; i < liElements.size() + 1; i++) {
			WebElement linkElement = driver
					.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label"));

			System.out.println(linkElement.getText());

			String OU = linkElement.getText();

			if (OU.contains(parentOU)) {

				driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label")).click();
			}

		}

	}

	public void SelectchildOU(String parentOU, String NewOu) throws Exception {

		System.out.println("Trying to Select " + parentOU + " OU Name...");

		click(By.xpath(prop.getAppProperty("Akku_UserOU_Edit_btn_xpath")));

		List<WebElement> liparentElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul"));

		System.out.println(liparentElements.size());

		for (int i = 1; i < liparentElements.size() + 1; i++) {
			WebElement linklocateparentou = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label"));

			System.out.println(linklocateparentou.getText());

			String OU = linklocateparentou.getText();

			System.out.println(OU);

			if (OU.contains(parentOU)) {

				List<WebElement> lichildOUElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul/li"));
				System.out.println(lichildOUElements.size());

				for (int j = 1; j < lichildOUElements.size() + 1; j++) {
					WebElement lichildOUlocate = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul[" + j + "]/li/label"));

					System.out.println(linklocateparentou.getText());

					String subOU = lichildOUlocate.getText();

					System.out.println(subOU);

					if (subOU.contains(NewOu)) {

						driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul[" + j + "]/li/label")).click();
					}
				}

			}

		}

	}
	
	public void clickonResetpwdbtninusermanagement() throws Exception {

		
			System.out.println("Trying to Click on Reset User button...");

			click(By.xpath(prop.getAppProperty("Akku_UserOU_Reset_btn_xpath")));
			System.out.println("We think we Clicked on Reset User button...");
		

		
	}
	
	public void verifychildhelptextmessage(String Helptextforchidou) throws Exception {

		
		System.out.println("Trying to Validate on Helptext...");
		
		String gethelptext =driver.getPageSource();
		
		System.out.println(gethelptext);
		boolean Excepted =true;
		if(gethelptext.contains(Helptextforchidou))
				{
			boolean Actual =true;
			Assert.assertEquals(Actual, Excepted);
			
				}
		else
		{
			boolean Actual =false;
			Assert.assertEquals(Actual, Excepted);
		}
		
		System.out.println("We think we Validate on Helptext...");
	

	
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
		click(By.xpath(prop.getAppProperty("Home_Edit_newPwd_text_xpath")));
		Thread.sleep(5000);
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

	
	
	
}
