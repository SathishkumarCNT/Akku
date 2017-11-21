package com.app.akku.work.pageobjects.siteblocking;



import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;


public class SiteBlockingpage extends Keywords {

	public SiteBlockingpage(WebDriver driver) {
		super(driver);

	}

	ReadfromProperties prop = new ReadfromProperties();

	public void issiteblockingscreen() {

		System.out.println("Trying to Validating Site Blocking page displayed or not... ");

		String actual_msg = driver.findElement(By.xpath("//a[contains(.,'Site Blocking')]")).getText();

		String expect = "Site Blocking";

		Assert.assertEquals(actual_msg, expect);

		System.out.println("We think Site Blocking page displayed");

		System.out.println("We think Site Blocking page not displayed");

	}

	public void ErrorPopup_NotAvalidURLMessage() throws Exception {

		System.out.println("Trying to Validate Site Blocking error popup message--> Not a Valid Url !! message... ");

		String actual_msg = getText(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Error_Popup_xpath")));

		System.out.println(actual_msg);
		String expect = "Not a valid URL !!";

		Assert.assertEquals(actual_msg, expect);

		System.out.println("We think Site Blocking error popup message--> Not a Valid Url !! message displayed");

		System.out.println("We think Site Blocking error message Popup not displayed");
	}

	public void ErrorPopup_PleaseEnterDescription() {

		System.out.println(
				"Trying to Validate Site Blocking error popup message--> Please Enter Description message... ");

		String actual_msg = driver.findElement(By.xpath("//div[contains(@class,'swal-title')]")).getText();
		String expect = "Please Enter Description";

		Assert.assertEquals(actual_msg, expect);
		System.out.println(actual_msg);

		System.out.println("We think Site Blocking error popup message--> Please Enter Description message displayed");

		System.out.println("We think Site Blocking error message Popup not displayed");

	}

	public void SuccessPopup_AddUrlSuccessfullyMessage() {

		System.out.println("Trying to Validate Url Successfully Added message...");

		String actual_msg = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
		String expect = "Success!";
		Assert.assertEquals(actual_msg, expect);

		System.out.println(actual_msg);

		System.out.println("Popup with Url Successfully Added message displayed...");
	}

	public void clickonAppManagement() throws Exception {

		System.out.println("Trying to Click on App Management button...");
		
	
		click(By.partialLinkText(prop.getAppProperty("Home_AppManagement_btn_xpath")));

		System.out.println("We think we Click on App Management button...");
	}
	

	public void clickonSiteBlockingBtn() throws Exception {

		System.out.println("Trying to Click on Site Blocking button...");

		click(By.xpath(prop.getAppProperty("AppManagement_siteblocking_btn_xpath")));

		System.out.println("We think we Click on Site Blocking button...");
	}

	public void clickonAddbtn() throws Exception {

		System.out.println("Trying to Click on Site Blocking ADD button...");

		click(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Add_btn_xpath")));

		System.out.println("We think we Click on Site Blocking  ADD button...");
	}

	public void clickonEditbtn() throws Exception {

		System.out.println("Trying to Click on Site Blocking Edit button...");

		click(By.xpath(prop.getAppProperty("SiteBlocking_EditBtn_Xpath")));

		System.out.println("We think we Click on Site Blocking  Edit button...");
	}

	public void typesiteurl(String siteURl) throws Exception {

		System.out.println("Trying to Validate Url Entered or Not...");

		type(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Input_SiteUrl_xpath")), siteURl);

		System.out.println("We think We Entered Url succesfully ");

		System.out.println("We think We didn't Entered Url ");

	}

	public void typesiteDescription(String siteDescription) throws Exception {

		System.out.println("Trying to Enter Site Description in the Description text field...");

		type(By.xpath(prop.getAppProperty("AppManagement_siteblocking_Input_SiteDescription_xpath")),siteDescription);

		System.out.println("We think we Entered Site Description in the Description text field...");
	}

	public void EditUrl(String siteURl) throws Exception {

		System.out.println("Trying to Clear and Url...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));

		type(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")), siteURl);

	}

	public void EditUrlDescription(String siteDescription) throws Exception {

		System.out.println("Trying to Clear Url Description...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));

		type(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")), siteDescription);

	}

	public void clickonUpdatebtn() throws Exception {

		System.out.println("Trying to Click on Update button...");

		Thread.sleep(2000);
		click(By.xpath(prop.getAppProperty("SiteBlocking_update_btn_editsiteurl_ID_xpath")));

	}

	public void Validateurl(String siteURl) throws Exception {

		System.out.println("Trying to Validate Url Successfully Added message...");

		String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_Edit_Sucessfull_Pop_Xpath")));

		System.out.println(Actual);
		System.out.println(siteURl);

		
		String expect = siteURl;

		if (Actual.contains(expect)) {

			System.out.println("Popup with Url Successfully Added message displayed...");
		}

		System.out.println("We think Site Blocking Popup not displayed with Text --> Url Successfully Added <--");

	}

	public void ClearurlDescription() throws Exception {

		System.out.println("Clearing Url Description...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));

		System.out.println("We think we Cleared Url Description...");

	}

	public void InputSiteDescriptionErrorMsgValidation() throws Exception {
	
			
		String actual_msg = getvalidationMessage(
					By.xpath(prop.getAppProperty("SiteBlocking_EditSiteUrlDescription_xpath")));
		System.out.println(actual_msg);

		String expect = "Please fill out this field.";
			
		Assert.assertEquals(actual_msg, expect);
	
		System.out.println("We think we Validate Site Description Field ");

	}

	public void Clearsiteurl() throws Exception {

		System.out.println("Clearing Site Url...");

		clear(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));

			
		System.out.println("We think we Cleared Site Url Field...");
	
	}

	public void InputSiteUrlErrorMsgValidation() throws Exception {

		String actual_msg = getvalidationMessage(By.xpath(prop.getAppProperty("SiteBlocking_EditsiteUrl_xpath")));
		
		System.out.println(actual_msg);

		String 	expect = "Please fill out this field.";
		Assert.assertEquals(actual_msg, expect);
		
		System.out.println("We think we Validate Site Url Field ");		
	}

	public void CloseEditPopup() throws Exception {
	
			System.out.println("Closing Edit Screen ...");

			click(By.xpath(prop.getAppProperty("SiteBlocking_Edit_Close_Pop_Xpath")));

			System.out.println("We think we Closing Edit PopUp Screen...");

	}

	public void clickondeltbtn() throws Exception

	{
		System.out.println("Trying to Click on Site Blocking Delete button...");

		click(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Xpath")));

	}
	
	public void clickondeltbtnforaddedurl(String siteURl) throws Exception

	{
		
		
		
		try {
			int toatlSitecount;

			toatlSitecount = sizeOf(By.xpath(prop.getAppProperty("SiteBlocking_List_Row_Count_Xpath")));
				System.out.println(toatlSitecount);

			List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"siteBlockTable\"]/tbody/tr/td[1]"));
			
			Thread.sleep(2000);
			
			for (int j = 0; j <= toatlSitecount; j++) {
				
				
				String listelement = elements.get(j).getText();
			System.out.println(siteURl);
				System.out.println(listelement);
				System.out.println(j);
				int delcount =j+2;
				String path ="//*[@id=\"siteBlockTable\"]/tbody/tr["+delcount+"]/td[3]/button[2]";
				if (listelement.contains(siteURl)) {
				
				
					System.out.println(" Duplicate Found");
			
					
					System.out.println("Trying to Click on Site Blocking Delete button..."+path+"");
					
					driver.findElement(By.xpath(""+path+"")).click();
					
					
					Thread.sleep(2000);
					break;
				}

			}
		
			System.out.println("Trying to Click on Site Blocking Delete button..Path.");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
					
			do {
				
				e.printStackTrace();
				break;
				}while(false);
		}

	}

	public void clickondeltconfirmation() throws Exception {
		
			System.out.println("Confirm to Delete Url");

			String Confirmationmessage = getText(
					By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_Confirm_Message_Xpath")));

			String actual_msg = Confirmationmessage;

			String expect = "Are you sure want to delete?";

			Assert.assertEquals(actual_msg, expect);

			click(By.xpath(prop.getAppProperty("SiteBlocking_DeleteBtn_pop_Confirm_Xpath")));

			System.out.println("We think we Clicked on Delete button...");

			
	}

	public void ValidateDeletemessage() throws Exception {
	
			System.out.println("Verify to Deleted Confirmation message");

			
			String Deletedmessage = getText(By.xpath(prop.getAppProperty("SiteBlocking_Delete_Sucessfull_Pop_Xpath")));
			String actual_msg = Deletedmessage;

			String expect = "Deleted successfully";
			Assert.assertEquals(actual_msg, expect);

			click(By.xpath(prop.getAppProperty("SiteBlocking_Delete_Close_Pop_Xpath")));
		

			System.out.println("We think we Clicked on Delete button...");
		
			
		
	}

	public void readduplicate(String siteURl) throws Exception {
		System.out.println("Validate Url with Existing List");

		int toatlSitecount;

		toatlSitecount = sizeOf(By.xpath(prop.getAppProperty("SiteBlocking_List_Row_Count_Xpath")));
			System.out.println(toatlSitecount);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"siteBlockTable\"]/tbody/tr/td[1]"));
		
		Thread.sleep(2000);
		
		for (int j = 0; j <= toatlSitecount; j++) {
			
			
			String listelement = elements.get(j).getText();
		System.out.println(siteURl);
			System.out.println(listelement);
			System.out.println(j);
			
			
			if (listelement.contains(siteURl)) {
			
			
				System.out.println(" Duplicate Found");
						
							
				
				Thread.sleep(2000);
				break;
			}

		}
	
		System.out.println("Trying to Click on Site Blocking Delete button..Path.");

	}

	public void EditValidateDuplicateerrormessage() {
		try {
			String Actual = getText(
					By.xpath(prop.getAppProperty("SiteBlocking_EditDuplandinvalid_Error_message_Xpath")));
			String expect = "Something went wrong. Please try after sometime";
			Assert.assertEquals(Actual, expect);

			click(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Accept_Xpath")));
		} catch (Exception e) {
			System.out.println("We think we Accepted Duplicate Error message...");
			e.printStackTrace();

		}

	}

	public void AddValidateDuplicateerrormessage() {
		try {
			String Actual = getText(
					By.xpath(prop.getAppProperty("SiteBlocking_AddDuplandinvalid_Error_message_Xpath")));
			String expect = "URL already exists";
			Assert.assertEquals(Actual, expect);
			driver.navigate().refresh();
			
		} catch (Exception e) {
			System.out.println("We think we Accepted Duplicate Error message...");
			e.printStackTrace();

		}

	}

	public void ValidateinvalidUrlerrormessage() {
		try {
			String Actual = getText(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Xpath")));
			String expect = "Not a valid URL !!";
			Assert.assertEquals(Actual, expect);

			click(By.xpath(prop.getAppProperty("SiteBlocking_Duplandinvalid_Error_message_Accept_Xpath")));
		} catch (Exception e) {
			System.out.println("We think we Accepted Invalid Error message...");
			e.printStackTrace();

		}

	}

}
