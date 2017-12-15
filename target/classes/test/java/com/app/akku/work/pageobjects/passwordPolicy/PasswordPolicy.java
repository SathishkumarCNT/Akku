package com.app.akku.work.pageobjects.passwordPolicy;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetPageSource;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.app.akku.work.pageobjects.OUManagement.OUmanagementpage;
import com.aventstack.extentreports.Status;

public class PasswordPolicy extends Keywords {
	
	Logger log = Logger.getLogger(PasswordPolicy.class.getName());

	public int pwdlen;

	public PasswordPolicy(WebDriver driver) {
		super(driver);

	}

	ReadfromProperties prop = new ReadfromProperties();

	public void clickonpwdpolicyBtn() throws Exception {

		log.info("Trying to Click on Password Policy button...");

		click(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_btn_xpath ")));

		test.log(Status.INFO,"We think we Click on Password Policy button");
		log.info("We think we Click on Password Policy button...");
	}

	public void Clearpwdlength() throws Exception {

		log.info("Trying to Clear on Min password Length field");

		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		log.info("We think we Clear on Min password Length field");
		test.log(Status.INFO,"We think we Clear on Min password Length field");
	}

	public void Clickonsave() throws Exception {

		log.info("Trying to Click on Password Policy Save button..");

		click(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_Save_btn_xpath")));

		test.log(Status.INFO,"We think we Click on Password Policy Save button.");
		log.info("We think we Click on Password Policy Save button.");

	}

	public void Validateerrormsgforblankpwdlength() throws Exception {

		log.info("Trying to verify Password Policy Error Message..");
		waitTillElementlocate(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
		String Expected = "Updation failed. Please try after some time.";
		String Actual = getText(By.xpath(prop.getAppProperty("ishome_home_update_error_popup_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Trying to verified Password Policy Error Message.");
		log.info("We think we Trying to verified Password Policy Error Message.");

	}

	public void closeAlertpopup() throws Exception {

		log.info("Trying to Click on Popup OK button...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));
		test.log(Status.INFO,"We think we Click on Popup OK button");
		log.info("We think we Click on Popup OK button...");
	}

	public void EnterCharinpwdlength() throws Exception {

		log.info("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "e");
		test.log(Status.INFO,"We think we Clear on Min password Length field");
		log.info("We think we Clear on Min password Length field");
	}

	public void ValidateerrormsgforCharinpwdlength() throws Exception {

		log.info("Trying to verify Password Policy Error Message..");
		waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		String Expected = "Please enter a number.";
		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Trying to verified Password Policy Error Message.");
		log.info("We think we Trying to verified Password Policy Error Message.");
		driver.navigate().refresh();

	}

	public void Enterpwdlengthof7char() throws Exception {

		log.info("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "7");
		
		test.log(Status.INFO,"We think we Clear on Min password Length field");
		log.info("We think we Clear on Min password Length field");
	}

	public void Validateerrormsgforpwdlength7char() throws Exception {

		log.info("Trying to verify Password Policy Error Message..");
		waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		String Expected = "Value must be greater than or equal to 8.";
		String Actual = getvalidationMessage(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		test.log(Status.INFO,"We think we Trying to verified Password Policy Error Message.");
		log.info("We think we Trying to verified Password Policy Error Message.");
		driver.navigate().refresh();

	}

	public void SelectonepwdComplexity() throws Exception {

		log.info("Trying to Select One password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		log.info("Upper Case: " + Uppercase + "");
		log.info("Lower Case: " + lowercase + "");
		log.info("Numeric Case: " + numeric + "");
		log.info("special Case: " + special + "");

		if (Uppercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
			
			test.log(Status.INFO,"We think we Un Select Uppercase");
			log.info("We think we Un Select Uppercase...");

		}
		if (lowercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
		
			test.log(Status.INFO,"We think we Select Lowercase");
			log.info("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
	
			test.log(Status.INFO,"We think we Select Numeric");
			log.info("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
		
			test.log(Status.INFO,"We think we UnSelect  Special Character");
			log.info("We think we  UnSelect Special Character...");

		}

		test.log(Status.INFO,"We think we Select One password Complexity");
		log.info("We think we Select One password Complexity...");
	}

	public void SelecttwopwdComplexity() throws Exception {

		log.info("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		log.info("Upper Case: " + Uppercase + "");
		log.info("Lower Case: " + lowercase + "");
		log.info("Numeric Case: " + numeric + "");
		log.info("special Case: " + special + "");

		if (Uppercase == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
	
			test.log(Status.INFO,"We think we Un Select Uppercase");
			log.info("We think we Un Select Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
		
			test.log(Status.INFO,"We think we Select Lowercase");
			log.info("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));
		
			test.log(Status.INFO,"We think we Select Numeric");
			log.info("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));
	
			
		
			test.log(Status.INFO,"We think we UnSelect  Special Character");
			log.info("We think we  UnSelect Special Character...");
		}

		test.log(Status.INFO,"We think we Select two password Complexity");
		log.info("We think we Select two password Complexity...");
	}

	public void SelectthreepwdComplexity() throws Exception {

		log.info("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		log.info("Upper Case: " + Uppercase + "");
		log.info("Lower Case: " + lowercase + "");
		log.info("Numeric Case: " + numeric + "");
		log.info("special Case: " + special + "");

		if (Uppercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));
		
			test.log(Status.INFO,"We think we Un Select Uppercase");
			log.info("We think we Un Select Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));
	
			test.log(Status.INFO,"We think we Select Lowercase");
			log.info("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));

			test.log(Status.INFO,"We think we Select Numeric");
			log.info("We think we Select Numeric...");

		}
		if (special == true)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));

			test.log(Status.INFO,"We think we UnSelect  Special Character");
			log.info("We think we  UnSelectSpecial Character...");

		}

		test.log(Status.INFO,"We think we Select two password Complexity");
		log.info("We think we Select two password Complexity...");
	}

	public void SelectfourpwdComplexity() throws Exception {

		log.info("Trying to Select Two password Complexity...");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		log.info("Upper Case: " + Uppercase + "");
		log.info("Lower Case: " + lowercase + "");
		log.info("Numeric Case: " + numeric + "");
		log.info("special Case: " + special + "");

		if (Uppercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklUChar_xpath")));

			test.log(Status.INFO,"We think we UnSelect Uppercase");
			log.info("We think we UnSelect Uppercase...");

		}
		if (lowercase == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklLChar_xpath")));

			test.log(Status.INFO,"We think we Select Lowercase");
			log.info("We think we Select Lowercase...");

		}
		if (numeric == false)

		{

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklnumChar_xpath")));

			test.log(Status.INFO,"We think we Select Numeric");
			log.info("We think we Select Numeric...");
			

		}
		if (special == false)

		{
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClicklsplChar_xpath")));

			test.log(Status.INFO,"We think we Select UnSpecial Character");
			log.info("We think we Select UnSpecial Character...");

		}
		test.log(Status.INFO,"We think we Select two password Complexity");
		log.info("We think we Select two password Complexity...");
	}

	public void ValidateerrormsgforonepwdComplexity() throws Exception {

		log.info("Trying to verify Password Complixty Error Message..");
		waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_error_popup_xpath")));

		String Expected = "Check at least two checkboxs in Password Complexity.";
		String Actual = getText(By.xpath(prop.getAppProperty("AppManagement_passwordpolicy_error_popup_xpath")));
		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		log.info("We think we Trying to verified Password Complixty Error Message.");
		
		test.log(Status.INFO,"We think we Trying to verified Password Complixty Error Message");

		driver.navigate().refresh();

	}

	public void Entervalidpwdlength() throws Exception

	{
		log.info("Trying to Clear on Min password Length field");

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "9");
		
		test.log(Status.INFO,"We think we Clear on Min password Length field: 9");

		log.info("We think we Clear on Min password Length field");
	}

	public void ChangeEntervalidpwdlength() throws Exception

	{
		log.info("Trying to Clear on Min password Length field");
		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), "8");
		
		test.log(Status.INFO,"We think we Clear on Min password Length field: 8");

		log.info("We think we Clear on Min password Length field");
	}

	public void ChangeEntervalidpwdlengthasten(String length) throws Exception

	{
		log.info("Trying to Clear on Min password Length field");
		click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		clear(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")));

		type(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_MinpwdLen_xpath")), length);
		
		test.log(Status.INFO,"We think we Clear on Min password Length field");

		log.info("We think we Clear on Min password Length field");
	}

	public void ValidateSucessfullyaddedmsg() throws Exception {

		log.info("Trying to verify Password policy Updated Message..");

		waitTillElementlocate(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Confirm_Message_Xpath")));

		String Expected = "Successfully Updated";
		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Confirm_Message_Xpath")));

		log.info(Actual);
		log.info(Expected);
		Assert.assertEquals(Actual, Expected);
		log.info("We think we Trying to verified Password policy Updated Message.");
		
		test.log(Status.INFO,"We think we Trying to verified Password policy Updated Message");
		driver.navigate().refresh();

	}

	public void EnablePasswordExpiry() throws Exception

	{
		log.info("Trying to Enable Password Expiry");
//waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));
		boolean Enablepwdexpriy = isSelected(
				By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		log.info(Enablepwdexpriy);

		if (Enablepwdexpriy == false) {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		} else {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		}

		log.info("We think we Clear on Min password Length field");
		test.log(Status.INFO,"We think we Clear on Min password Length field");
	}

	public void DisablePasswordExpiry() throws Exception

	{
		log.info("Trying to Disable Password Expiry");
		//waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		boolean Enablepwdexpriy = isSelected(
				By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		log.info(Enablepwdexpriy);

		if (Enablepwdexpriy == false) {
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));
			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		} else {


			click(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ClickEnablePwdExpiry_xpath")));

		}

		log.info("We think we Disable Password Expiry");
		
		test.log(Status.INFO,"We think we Disable Password Expiry");

	}

	public void VerifyExpirationofPwddisable() throws Exception

	{

		log.info("Trying to Verify Expiration of Password Option Disable");
	
		boolean Actual = isSelected(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_EnablePwdExpiry_xpath")));

		Assert.assertEquals(Actual, false);

		log.info("We think we Verify Expiration of Password Option Disabale");
		driver.navigate().refresh();
		
		test.log(Status.INFO,"We think we Verify Expiration of Password Option Disable");

	}

	public void VerifyExpirationofPwddispaly() throws Exception

	{

		log.info("Trying to Verify Expiration of Password Option enable");
		waitTillElementlocate(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")));

		boolean Actual = IsDisplayed(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")));

		Assert.assertEquals(Actual, true);

		log.info("We think we Verify Expiration of Password Option enabled");

		log.info("Trying to Select Expiration of Password 60 Days");

		selectBy(By.xpath(prop.getAppProperty("AppManagement_pwdpolicy_ExpofPwd_xpath")), 2);
		log.info("We think we Selected Expiration as Password 60 Days");
		
		test.log(Status.INFO,"We think we Selected Expiration as Password 60 Days");

	}

	public void ClickOnparentOU(String NewOu) throws Exception {

		log.info("Trying to Click OU Name...");
		
		int totalcount= driver.findElements(By.xpath("//*[@id='ouList']/ul/li/ul/li")).size();
		log.info(totalcount);
		for(int i=1;i<=totalcount;i++)
		{
				
		String rowvalue = driver.findElement(By.xpath("//*[@id='ouList']/ul/li/ul/li["+i+"]/a/span")).getText(); 
		log.info(rowvalue);
		if (rowvalue.contains(NewOu))
		{	

	
			driver.findElement(By.xpath("//*[@id='ouList']/ul/li/ul/li["+i+"]/a/span")).click();

		log.info(rowvalue);

	

		}
		}
		
		test.log(Status.INFO,"We think Click OU Name");
		log.info("We think Click OU Name...");

	}
	
	public void ClickOnChildOU(String NewOu) throws Exception {

		log.info("Trying to Click OU Name...");
		
		int totalcount= driver.findElements(By.xpath("//*[@id='ouList']/ul/li/ul/li")).size();
		log.info(totalcount);
		for(int i=1;i<=totalcount;i++)
		{
				
		String rowvalue = driver.findElement(By.xpath("//*[@id='ouList']/ul/li/ul/li["+i+"]/a/span")).getText(); 
		log.info(rowvalue);
		if (rowvalue.contains(NewOu))
		{	

	
			driver.findElement(By.xpath("//*[@id='ouList']/ul/li/ul/li["+i+"]/ul/li/a/span")).click();
			
			//*[@id="ouList"]/ul/li/ul/li[4]/ul/li/a/span
			
		log.info(rowvalue);

	

		}
		}
		
		test.log(Status.INFO,"We think Click OU Name");
		log.info("We think Click OU Name...");

	}

	public void verifySubOupasswordlengthlsochange(String NewOu) throws Exception {

		checkPageIsReady();
		log.info("Validating Sub OU Password Length");
		String passwordlength = driver.getPageSource();
		log.info(passwordlength);
		log.info(NewOu);
		if (passwordlength.contains(NewOu)) {
			String Actual = NewOu;
			String Excepted = NewOu;
			Assert.assertEquals(Actual, Excepted);
			log.info("We think we Validating Sub OU Password Length");
			
			test.log(Status.INFO,"We think we Validating Sub OU Password Length");

		}

	}

	public void VerifySubOUPasswordComplexity() throws Exception {

		log.info("Validating Password Complexity ");

		boolean Uppercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplUChar_ID")));
		boolean lowercase = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplLChar_ID")));
		boolean numeric = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplNumChar_ID")));
		boolean special = isSelected(By.id(prop.getAppProperty("AppManagement_pwdpolicy_ComplsplChar_ID")));

		Assert.assertEquals(Uppercase, true);
		Assert.assertEquals(lowercase, true);
		Assert.assertEquals(numeric, true);
		//Assert.assertEquals(special, true);

		test.log(Status.INFO,"We think we Validate Password Complexity");
		log.info("We think we Validate Password Complexity");
	}

	public void clickonEditbtninusermanagement() throws Exception {

	
			log.info("Trying to Click on Edit button...");

			click(By.xpath(prop.getAppProperty("Akku_OuManagementUserOU_Edit_btn_xpath")));
		
			log.info("We think we Clicked on Edit button...");
			
			test.log(Status.INFO,"We think we Clicked on Edit button");
			
			

	
	}

	public void SelectParentOU(String parentOU) throws Exception {

		log.info("Trying to Select " + parentOU + " OU Name...");

		click(By.xpath(prop.getAppProperty("Akku_UserOU_Edit_btn_xpath")));
waitTillElementlocate(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul"));
		List<WebElement> liElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul"));

		log.info(liElements.size());

		for (int i = 1; i < liElements.size() + 1; i++) {
			WebElement linkElement = driver
					.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label"));

			log.info(linkElement.getText());

			String OU = linkElement.getText();

			if (OU.contains(parentOU)) {

				driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label")).click();
			}

		}

	}

	public void SelectchildOU(String parentOU, String NewOu) throws Exception {

		log.info("Trying to Select " + parentOU + " OU Name...");

		click(By.xpath(prop.getAppProperty("Akku_UserOU_Edit_btn_xpath")));

		List<WebElement> liparentElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul"));

		log.info(liparentElements.size());

		for (int i = 1; i < liparentElements.size() + 1; i++) {
			WebElement linklocateparentou = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label"));

			log.info(linklocateparentou.getText());

			String OU = linklocateparentou.getText();

			log.info(OU);

			if (OU.contains(parentOU)) {

				List<WebElement> lichildOUElements = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul/li"));
				log.info(lichildOUElements.size());

				for (int j = 1; j < lichildOUElements.size() + 1; j++) {
					WebElement lichildOUlocate = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul[" + j + "]/li/label"));

					log.info(linklocateparentou.getText());

					String subOU = lichildOUlocate.getText();

					log.info(subOU);

					if (subOU.contains(NewOu)) {

						driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul[" + j + "]/li/label")).click();
					}
				}

			}

		}

	}
	
	public void clickonResetpwdbtninusermanagement() throws Exception {

		
			log.info("Trying to Click on Reset User button...");

			click(By.xpath(prop.getAppProperty("Akku_UserOU_Reset_btn_xpath")));
			log.info("We think we Clicked on Reset User button...");
		
			test.log(Status.INFO,"We think we Clicked on Reset User button");
		
	}
	
	public void verifychildhelptextmessage(String Helptextforchidou) throws Exception {

		
		log.info("Trying to Validate on Helptext...");
		checkPageIsReady();
		String gethelptext =driver.getPageSource();
		
		log.info(gethelptext);
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
		
		test.log(Status.INFO,"We think we Validate on Helptext");
		
		log.info("We think we Validate on Helptext...");
	

	
}
	
	public void clickEditbtn() throws Exception {

		log.info("Trying to Click on Edit button...");

		
		click(By.xpath(prop.getAppProperty("Home_Edit_btn_xpath")));
		
		log.info("We think we Click on Edit button...");

		log.info("We think we Click on Edit button...");
	}

	public void typeOldpassword(String Oldpassword) throws Exception {

		log.info("Trying to Enter Password in Old text field...");

		
		type(By.xpath(prop.getAppProperty("Home_Edit_oldPwd_text_xpath")), Oldpassword);
		
		test.log(Status.INFO,"We think we Entered Password in Old text field : "+ Oldpassword);
		
		log.info("We think we Entered Password in Old text field...");
	}

	public void typenewpassword(String Newpassword) throws Exception {

		log.info("Trying to Enter Password in the New text field...");
		click(By.xpath(prop.getAppProperty("Home_Edit_newPwd_text_xpath")));

		type(By.xpath(prop.getAppProperty("Home_Edit_newPwd_text_xpath")), Newpassword);
		test.log(Status.INFO,"We think we Entered Password in New text field : "+ Newpassword);

		log.info("We think we Entered Password in New text field...");
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		log.info("Trying to Enter Password in the Confirm text field...");

	
		type(By.xpath(prop.getAppProperty("Home_Edit_confPwd_text_xpath")), Confnewpassword);

		test.log(Status.INFO,"We think we Entered Password in the Confirm text field : "+ Confnewpassword);
		log.info("We think we Entered Password in the Confirm text field...");
	}

	public void clickUpdatebtn() throws Exception {

		log.info("Trying to Click on Update button...");

		
		click(By.xpath(prop.getAppProperty("Home_Edit_Update_btn_xpath")));

		test.log(Status.INFO,"We think we Click on Update button");
		log.info("We think we Click on Update button...");
	}

	
	
	
}
