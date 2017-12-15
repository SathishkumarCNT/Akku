package com.app.akku.work.pageobjects.siteblocking;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	public void issiteblockingscreen() throws Exception {

		log.info("Trying to Validating Site Blocking page displayed or not... ");
		waitTillAssertElementPresent(By.xpath("//a[contains(.,'Site Blocking')]"), "Site Blocking");
		String actual_msg = driver.findElement(By.xpath("//a[contains(.,'Site Blocking')]")).getText();

		String expect = "Site Blocking";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking page displayed");
		test.log(Status.INFO, "We think Site Blocking page displayed");

	}

	public void ErrorPopup_NotAvalidURLMessage() throws Exception {

		log.info("Trying to Validate Site Blocking error popup message--> Not a Valid Url !! message... ");
		waitTillAssertElementPresent(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Error_Popup_xpath")),
				"Not a valid URL !!");
		String actual_msg = getText(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Error_Popup_xpath")));

		log.info(actual_msg);
		String expect = "Not a valid URL !!";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking error popup message--> Not a Valid Url !! message displayed");

		test.log(Status.INFO, "We think Site Blocking error popup message--> " + actual_msg + " message displayed");
	}

	public void ErrorPopup_PleaseEnterDescription() throws Exception {

		log.info("Trying to Validate Site Blocking error popup message--> Please Enter Description message... ");
		waitTillAssertElementPresent(By.xpath("//div[contains(@class,'swal-title')]"), "Please Enter Description");

		String actual_msg = driver.findElement(By.xpath("//div[contains(@class,'swal-title')]")).getText();
		String expect = "Please Enter Description";

		Assert.assertEquals(actual_msg, expect);
		log.info(actual_msg);

		Assert.assertEquals(actual_msg, expect);

		log.info("We think Site Blocking error popup message--> Please Enter Description message displayed");

		test.log(Status.INFO, "We think Site Blocking error popup message--> " + actual_msg + " message displayed");

	}

	public void SuccessPopup_AddUrlSuccessfullyMessage() throws Exception {

		log.info("Trying to Validate Url Successfully Added message...");
		String Actual = driver.getPageSource();
		String expect = "Success!";
		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		log.info("Popup with Url Successfully Added message displayed...");
		test.log(Status.INFO, "Popup with Url Successfully Added message displayed");

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

		click(By.xpath(prop.getAppProperty("SiteBlocking_update_btn_editsiteurl_ID_xpath")));

		test.log(Status.INFO, "We think we Click on Update button");
		log.info("We think we Click on Update button...");

	}

	public void Validateurl(String siteURl) throws Exception {

		log.info("Trying to Validate Url Successfully Added message...");

		String Actual = driver.getPageSource();
		String expect = "Success!";
		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		log.info("We think Site Blocking pop up displayed with Text --> Url Successfully Added <--");
		test.log(Status.INFO, "We think Site Blocking pop up displayed with Text --> Url Successfully Added <--");

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

		String actual_msg = getvalidationMessage(
				By.xpath(prop.getAppProperty("AppManagement_siteblocking_Input_SiteUrl_xpath")));

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

			for (int j = 0; j <= toatlSitecount; j++) {

				String listelement = elements.get(j).getText();
				log.info(siteURl);
				log.info(listelement);
				log.info(j);
				int delcount = j + 1;
				String path = "//*[@id=\"siteBlockTable\"]/tbody/tr[" + delcount + "]/td[3]/button[2]";
				if (listelement.contains(siteURl)) {

					log.info(" Duplicate Found");

					log.info("Trying to Click on Site Blocking Delete button..." + path + "");

					driver.findElement(By.xpath("" + path + "")).click();

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

	public void clickDeletebtnforaddedurl(String siteURl) throws Exception

	{

		log.info("Trying to Click on " + siteURl + " Delete button Path.");
		driver.findElement(By.xpath("//td[contains(.," + siteURl + "')]")).click();

		log.info("We think we Clicked Delete " + siteURl + " Button");
		test.log(Status.INFO, "We think we Clicked Delete " + siteURl + " Button");
	}

	// td[contains(.,'www.google.com')]

	public void clickondeltconfirmation() throws Exception {

		log.info("Confirm to Delete Url");
		checkPageIsReady();
		String Confirmationmessage = driver.getPageSource();
		String actual_msg = Confirmationmessage;
		String expect = "Are you sure want to delete?";
		if (Confirmationmessage.contains(expect)) {

			Assert.assertEquals(actual_msg, actual_msg);
			click(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_pop_Confirm_Xpath")));
		} else {
			Assert.assertNotEquals(actual_msg, actual_msg);
			log.info("We think we have not get Delete Confirmation PopUp...");
			Assert.fail();
		}

		log.info("We think we Clicked on Delete button...");

		test.log(Status.INFO, "We think we Clicked on Delete button");

	}

	public void ValidateDeletemessage() throws Exception {

		log.info("Verify to Deleted Confirmation message");
		checkPageIsReady();
		String Deletedmessage = driver.getPageSource();
		String actual_msg = Deletedmessage;

		String expect = "Deleted successfully";

		if (Deletedmessage.contains(expect)) {

			Assert.assertEquals(actual_msg, actual_msg);
			click(By.xpath(prop.getAppProperty("SiteBlocking_Delete_Close_Pop_Xpath")));
		} else {
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

		for (int j = 0; j <= toatlSitecount; j++) {

			String listelement = elements.get(j).getText();
			log.info(siteURl);
			log.info(listelement);
			log.info(j);

			if (listelement.contains(siteURl)) {

				log.info(" Duplicate Found");

				break;
			}

		}

		log.info("Duplicate Url Found in list..");
		test.log(Status.INFO, "Duplicate Url Found in list..");

	}

	public void EditValidateDuplicateerrormessage() throws Exception {

		log.info("Trying to Verifiy Duplicate Url message");

		String Actual = driver.getPageSource();
		String expect = "Something went wrong. Please try after sometime";
		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		log.info("We think we Verifeid to Duplicate Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Duplicate Url Message message");

	}

	public void AddValidateDuplicateerrormessage() throws Exception {

		log.info("Trying to Verifiy Duplicate Url message");

		String Actual = driver.getPageSource();
		String expect = "URL already exists";
		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		log.info("We think we Verifeid to Duplicate Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Duplicate Url Message message");

	}

	public void ValidateinvalidUrlerrormessage() throws Exception {

		log.info("Trying to Verifiy Invalid Url message");

		String expect = "Not a valid URL !!";
		String Actual = driver.getPageSource();

		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));

		log.info("We think we Verifeid to Invalid Url Message message");

		test.log(Status.INFO, "We think we Verifeid to Invalid Url Message message");
		driver.navigate().refresh();
	}

	public void enterProxyCredentials(String Proxyusername, String Proxypassword) throws Exception {
		Robot rb = new Robot();
		StringSelection username = new StringSelection(Proxyusername);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		StringSelection pwd = new StringSelection(Proxypassword);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void ClickExpandORCollapsBtnInSiteBlocking() throws Exception {

		log.info("Trying to Expand or Collaps OU...");

		click(By.cssSelector(prop.getAppProperty("SiteBlocking_Ou_Expand_OU_css")));

		log.info("We think we Expanded or Collaps OU ...");
		test.log(Status.INFO, "We think we Expanded or Collaps OU ...");

	}

	public void clickOnparentOUInSiteBlocking(String NewOu) throws Exception {

		log.info("Trying to Click OU Name...");

		int totalcount = driver.findElements(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li")).size();
		log.info(totalcount);
		for (int i = 1; i <= totalcount; i++) {

			String rowvalue = driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]"))
					.getText();
			log.info(rowvalue);
			if (rowvalue.contains(NewOu)) {

				driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]/a/span"))
						.click();

				log.info(rowvalue);

			}
		}

		test.log(Status.INFO, "We think Click OU Name");
		log.info("We think Click OU Name...");

	}

	public void clickOnChildOUInSiteBlocking(String NewOu) throws Exception {

		log.info("Trying to Click OU Name...");

		int totalcount = driver.findElements(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li")).size();
		log.info(totalcount);
		for (int i = 1; i <= totalcount; i++) {

			String rowvalue = driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]"))
					.getText();
			log.info(rowvalue);
			if (rowvalue.contains(NewOu)) {

				driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]/ul/li/a"))
						.click();

				log.info(rowvalue);

			}
		}

		test.log(Status.INFO, "We think Click OU Name");
		log.info("We think Click OU Name...");

	}

	public void clickExpandParentOUInSiteBlocking(String ParentOu) throws Exception {

		log.info("Trying to Expand " + ParentOu + " OU ...");
		int totalcount = driver.findElements(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li")).size();
		log.info(totalcount);
		for (int i = 1; i <= totalcount; i++) {

			String rowvalue = driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]"))
					.getText();
			log.info(rowvalue);
			if (rowvalue.contains(ParentOu)) {

				driver.findElement(By.xpath("//*[@id='siteBlock']/div/div[1]/nav/ul/li/ul/li[" + i + "]/span/span[1]"))
						.click();

			}
		}
		log.info("We think Expanded " + ParentOu + " OU ......");

		test.log(Status.INFO, "We think Expanded " + ParentOu + "OU");
	}

	public void verfirySiteBlockedmessage() throws Exception {

		log.info("Trying to Validate URL Blocked  message...");
		String Actual = driver.getPageSource();
		String expect = "Access Denied";
		Thread.sleep(5000);
		if (Actual.contains(expect)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}

		log.info("We think we verified URL Blocked Message...");
		test.log(Status.INFO, "We think we verified URL Blocked Message...");

	}

	public void openUrlInNewTab(String url) throws Exception {

		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get(url);

	}

	public void selectParentOU(String ParentOU) throws Exception {

		log.info("Trying to Select Parent OU Name...");

		log.info("Trying to Expand " + ParentOU + " OU ...");

		driver.findElement(By.xpath("//*[@id='edituserouiv']/div/button")).click();

		WebElement options = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul"));
		List<WebElement> Oulist = options.findElements(By.tagName("label"));

		for (WebElement li : Oulist) {
			if (li.getText().equals(ParentOU)) {
				li.click();
			}

		}

		log.info("We think we Selected Parent OU Name..." + ParentOU);

		test.log(Status.INFO, "We think we Selected Parent OU Name" + ParentOU);
	}

	public void selectChildOU(String ParentOU) throws Exception {

		log.info("Trying to Select Child OU Name...");

		log.info("Trying to Expand " + ParentOU + " OU ...");

		driver.findElement(By.xpath("//*[@id='edituserouiv']/div/button")).click();

		int totalcount = driver.findElements(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul/li/label")).size();
		log.info(totalcount);

		for (int i = 1; i <= totalcount; i++) {

			String OuName = driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/label")).getText();
			log.info(i);
			log.info(OuName);
			if (OuName.contains(ParentOU)) {
				log.info("inside if");	
				driver.findElement(By.xpath("//*[@id='edituserouiv']/div/ul/li/ul[" + i + "]/li/ul/li/label")).click();
			}
			

		}
		log.info("We think we Selected Child OU Name..." + ParentOU);

		test.log(Status.INFO, "We think we Child Parent OU Name" + ParentOU);
	}
}
