package com.app.akku.work.pageobjects.siteblocking;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.app.akku.work.pageobjects.passwordPolicy.PasswordPolicy;
import com.aventstack.extentreports.Status;

public class SiteBlockingpage extends Keywords {
	
	Logger log = Logger.getLogger(SiteBlockingpage.class.getName());

	public SiteBlockingpage(WebDriver driver) {
		super(driver);

	}

	ReadfromProperties prop = new ReadfromProperties();

	public void issiteblockingscreen() {

		log.info("Trying to Validating Site Blocking page displayed or not... ");

		String actual_msg = driver.findElement(By.xpath("//a[contains(.,'Site Blocking')]")).getText();

		String expect = "Site Blocking";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking page displayed");
		test.log(Status.INFO, "We think Site Blocking page displayed");

	}

	public void ErrorPopup_NotAvalidURLMessage() throws Exception {

		log.info("Trying to Validate Site Blocking error popup message--> Not a Valid Url !! message... ");

		String actual_msg = getText(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Error_Popup_xpath")));

		log.info(actual_msg);
		String expect = "Not a valid URL !!";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking error popup message--> Not a Valid Url !! message displayed");

		test.log(Status.INFO, "We think Site Blocking error popup message--> " + actual_msg + " message displayed");
	}

	public void ErrorPopup_PleaseEnterDescription() {

		log.info("Trying to Validate Site Blocking error popup message--> Please Enter Description message... ");

		String actual_msg = driver.findElement(By.xpath("//div[contains(@class,'swal-title')]")).getText();
		String expect = "Please Enter Description";

		Assert.assertEquals(actual_msg, expect);
		log.info(actual_msg);

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking error popup message--> Please Enter Description message displayed");

		test.log(Status.INFO, "We think Site Blocking error popup message--> " + actual_msg + " message displayed");

	}

	public void SuccessPopup_AddUrlSuccessfullyMessage() {

		log.info("Trying to Validate Url Successfully Added message...");

		String actual_msg = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
		String expect = "Success!";
		Assert.assertEquals(actual_msg, expect);

		log.info(actual_msg);

		log.info("Popup with Url Successfully Added message displayed...");
		test.log(Status.INFO, "Popup with Url Successfully Added message displayed: " + actual_msg);

	}

	public void clickonAppManagement() throws Exception {

		log.info("Trying to Click on App Management button...");

		click(By.partialLinkText(prop.getAppProperty("Home_AppManagement_btn_xpath")));

		log.info("We think we Click on App Management button...");

		test.log(Status.INFO, "We think we Click on App Management button");
	}

	public void clickonSiteBlockingBtn() throws Exception {

		log.info("Trying to Click on Site Blocking button...");

		click(By.xpath(prop.getAppProperty("AppManagement_siteblocking_btn_xpath")));

		log.info("We think we Click on Site Blocking button...");
		test.log(Status.INFO, "We think we Click on Site Blocking button");
	}

	public void clickonAddbtn() throws Exception {

		log.info("Trying to Click on Site Blocking ADD button...");

		click(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Add_btn_xpath")));

		log.info("We think we Click on Site Blocking  ADD button...");

		test.log(Status.INFO, "We think we Click on Site Blocking ADD button");
	}

	public void clickonEditbtn() throws Exception {

		log.info("Trying to Click on Site Blocking Edit button...");

		click(By.xpath(prop.getAppProperty("SiteBlocking_EditBtn_Xpath")));

		log.info("We think we Click on Site Blocking  Edit button...");

		test.log(Status.INFO, "We think we Click on Site Blocking Edit button");
	}

	public void typesiteurl(String siteURl) throws Exception {

		log.info("Trying to Validate Url Entered or Not...");

		type(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Input_SiteUrl_xpath")), siteURl);

		log.info("We think We Entered Url succesfully ");

		test.log(Status.INFO, "We think We Entered Url succesfully");

	}

	public void typesiteDescription(String siteDescription) throws Exception {

		log.info("Trying to Enter Site Description in the Description text field...");

		type(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Input_SiteDescription_xpath")), siteDescription);

		log.info("We think we Entered Site Description in the Description text field...");

		test.log(Status.INFO, "We think we Entered Site Description in the Description text field");
	}

	public void EditUrl(String siteURl) throws Exception {

		log.info("Trying to Clear and type Url...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));

		type(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")), siteURl);

		log.info(" We think we typed typed Url: " + siteURl);

		test.log(Status.INFO, " We think we typed typed Url: " + siteURl);

	}

	public void EditUrlDescription(String siteDescription) throws Exception {

		log.info("Trying to Clear Url Description...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));

		type(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")), siteDescription);

		log.info(" We think we typed typed Description: " + siteDescription);

		test.log(Status.INFO, " We think we typed typed Description: " + siteDescription);

	}

	public void clickonUpdatebtn() throws Exception {

		log.info("Trying to Click on Update button...");

		Thread.sleep(2000);
		click(By.xpath(prop.getAppProperty("SiteBlocking_update_btn_editsiteurl_ID_xpath")));

		test.log(Status.INFO, "We think we Click on Update button");
		log.info("We think we Click on Update button...");

	}

	public void Validateurl(String siteURl) throws Exception {

		log.info("Trying to Validate Url Successfully Added message...");

		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_Edit_Sucessfull_Pop_Xpath")));

		log.info(Actual);
		log.info(siteURl);

		String expect = siteURl;

		if (Actual.contains(expect)) {

			log.info("We think we Popup with Url Successfully Added message displayed  with Text: " + Actual);
			test.log(Status.INFO,
					"We think we Popup with Url Successfully Added message displayed  with Text: " + Actual);
		} else {

			log.info("We think Site Blocking Popup not displayed with Text --> Url Successfully Added <--");
			test.log(Status.INFO,
					"We think Site Blocking Popup not displayed with Text --> Url Successfully Added <--");

		}
	}

	public void ClearurlDescription() throws Exception {

		log.info("Clearing Url Description...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));

		log.info("We think we Cleared Url Description...");
		test.log(Status.INFO, "We think we Cleared Url Description...");

	}

	public void InputSiteDescriptionErrorMsgValidation() throws Exception {

		String actual_msg = getvalidationMessage(
				By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));
		log.info(actual_msg);

		String expect = "Please fill out this field.";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think we Validate Site Description Field ");
		test.log(Status.INFO, "We think we Cleared Url Description");

	}

	public void Clearsiteurl() throws Exception {

		log.info("Clearing Site Url...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));

		log.info("We think we Cleared Site Url Field...");
		test.log(Status.INFO, "We think we Cleared Site Url Field");

	}

	public void InputSiteUrlErrorMsgValidation() throws Exception {

		String actual_msg = getvalidationMessage(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));

		log.info(actual_msg);

		String expect = "Please fill out this field.";
		Assert.assertEquals(actual_msg, expect);

		log.info("We think we Validate Site Url Field ");
		test.log(Status.INFO, "We think we Validate Site Url Field");
	}

	public void CloseEditPopup() throws Exception {

		log.info("Closing Edit Screen ...");

		click(By.xpath(prop.getAppProperty("SiteBlocking_Edit_Close_Pop_Xpath")));

		log.info("We think we Closing Edit PopUp Screen...");
		test.log(Status.INFO, "We think we Closing Edit PopUp Screen");
	}

	public void clickondeltbtn() throws Exception

	{
		log.info("Trying to Click on Site Blocking Delete button...");

		click(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Xpath")));

		log.info("We think we Click on Site Blocking Delete button...");
		test.log(Status.INFO, "We think weClick on Site Blocking Delete button");

	}

	public void clickondeltbtnforaddedurl(String siteURl) throws Exception

	{

		try {
			int toatlSitecount;

			toatlSitecount = sizeOf(By.xpath(prop.getAppProperty("SiteBlocking_List_Row_Count_Xpath")));
			log.info(toatlSitecount);

			List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"siteBlockTable\"]/tbody/tr/td[1]"));

			Thread.sleep(2000);

			for (int j = 0; j <= toatlSitecount; j++) {

				String listelement = elements.get(j).getText();
				log.info(siteURl);
				log.info(listelement);
				log.info(j);
				int delcount = j + 2;
				String path = "//*[@id=\"siteBlockTable\"]/tbody/tr[" + delcount + "]/td[3]/button[2]";
				if (listelement.contains(siteURl)) {

					log.info(" Duplicate Found");

					log.info("Trying to Click on Site Blocking Delete button..." + path + "");

					driver.findElement(By.xpath("" + path + "")).click();

					Thread.sleep(2000);
					break;
				}

			}

			log.info("Trying to Click on Site Blocking Delete button..Path.");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			do {

				e.printStackTrace();
				break;
			} while (false);
		}

	}

	public void clickondeltconfirmation() throws Exception {

		log.info("Confirm to Delete Url");

		String Confirmationmessage =driver.getPageSource();
		String actual_msg = Confirmationmessage;
		String expect = "Are you sure want to delete?";
		if(Confirmationmessage.contains(expect))
		{
		
		Assert.assertEquals(actual_msg, actual_msg);
		click(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_pop_Confirm_Xpath")));
		}
		else 
		{
			Assert.assertNotEquals(actual_msg, actual_msg);
			log.info("We think we have not get Delete Confirmation PopUp...");
			Assert.fail();
		}
		

		log.info("We think we Clicked on Delete button...");

		test.log(Status.INFO, "We think we Clicked on Delete button");

	}

	public void ValidateDeletemessage() throws Exception {

		log.info("Verify to Deleted Confirmation message");

		String Deletedmessage = driver.getPageSource();
		String actual_msg = Deletedmessage;

		String expect = "Deleted successfully";
		Thread.sleep(5000);
		if(Deletedmessage.contains(expect))
		{
		
		Assert.assertEquals(actual_msg, actual_msg);
		click(By.xpath(prop.getAppProperty("SiteBlocking_Delete_Close_Pop_Xpath")));
		}
		else 
		{
			Assert.assertNotEquals(actual_msg, actual_msg);
			log.info("We think we Verified to Deleted Sucessful message...");
			Assert.fail();
		}
		


		

		log.info("We think we Verified to Deleted Confirmation message");

		test.log(Status.INFO, "We think we Verifeid to Deleted Confirmation message");

	}

	public void readduplicate(String siteURl) throws Exception {
		log.info("Validate Url with Existing List");

		int toatlSitecount;

		toatlSitecount = sizeOf(By.xpath(prop.getAppProperty("SiteBlocking_List_Row_Count_Xpath")));
		log.info(toatlSitecount);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"siteBlockTable\"]/tbody/tr/td[1]"));

		Thread.sleep(2000);

		for (int j = 0; j <= toatlSitecount; j++) {

			String listelement = elements.get(j).getText();
			log.info(siteURl);
			log.info(listelement);
			log.info(j);

			if (listelement.contains(siteURl)) {

				log.info(" Duplicate Found");

				Thread.sleep(2000);
				break;
			}

		}

		log.info("Duplicate Url Found in list..");
		test.log(Status.INFO, "Duplicate Url Found in list..");

	}

	public void EditValidateDuplicateerrormessage() throws Exception {
		
		log.info("Trying to Verifiy Duplicate Url message");

		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_EditDuplandinvalid_Error_message_Xpath")));
		String expect = "Something went wrong. Please try after sometime";
		Assert.assertEquals(Actual, expect);

		click(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Accept_Xpath")));
		
		log.info("We think we Verifeid to Duplicate Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Duplicate Url Message message");

	}

	public void AddValidateDuplicateerrormessage() throws Exception {
		
		log.info("Trying to Verifiy Duplicate Url message");

		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_AddDuplandinvalid_Error_message_Xpath")));
		String expect = "URL already exists";
		Assert.assertEquals(Actual, expect);
		driver.navigate().refresh();

		log.info("We think we Verifeid to Duplicate Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Duplicate Url Message message");

	}

	public void ValidateinvalidUrlerrormessage() throws Exception {

		log.info("Trying to Verifiy Invalid Url message");

		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Xpath")));
		String expect = "Not a valid URL !!";
		Assert.assertEquals(Actual, expect);

		click(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Accept_Xpath")));

		log.info("We think we Verifeid to Invalid Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Invalid Url Message message");
	}

}
