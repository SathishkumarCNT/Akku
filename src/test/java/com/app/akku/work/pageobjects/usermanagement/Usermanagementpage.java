package com.app.akku.work.pageobjects.usermanagement;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;


public class Usermanagementpage extends Keywords {

	ReadfromProperties prop = new ReadfromProperties();

	Logger log = Logger.getLogger(Usermanagementpage.class);

	public Usermanagementpage(WebDriver driver) {
		super(driver);
	}

	public boolean isUsermanagementpage() throws Exception {

		boolean status = isElementPresent(By.xpath(prop.getAppProperty("Akku_UserManagement_HeaderText_xpath")));
		return status;
	}

	public void clickUsermanagementBtn() throws Exception {

		System.out.println("Trying to Click on Users button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_userlist_xpath")));
		
		

		System.out.println("We think we Click on Users button...");
	}
	
	public void clickAppmanagementBtn() throws Exception {

		System.out.println("Trying to Click on Users button...");

		//click(By.xpath(prop.getAppProperty("Akku_UserManagement_userlist_xpath")));
		
		click(By.xpath(prop.getAppProperty("Home_AppManagement_btn_xpath")));

		System.out.println("We think we Click on Users button...");
	}

	public void clickOnAddUserManualy() throws Exception {

		System.out.println("Trying to Click on Add Users Manually button...");

		moveMouse(By.xpath(prop.getAppProperty("Akku_UserManagement_plus_btn_xpath")));

		Thread.sleep(2000);
		//WaitForElement(By.xpath(prop.getAppProperty("Akku_UserManagement_adduser_Manually_btn_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_adduser_Manually_btn_xpath")));

		System.out.println("We think we Click on Add Users Manually button...");
	}

	public void clickonAddUserViaGSuite() throws Exception {

			System.out.println("Trying to Click on Add Users by using GSuite button...");

			moveMouse(By.xpath(prop.getAppProperty("Akku_UserManagement_plus_btn_xpath")));

			Thread.sleep(2000);
			//WaitForElement(By.xpath(prop.getAppProperty("Akku_UserManagement_adduservia_Gsuite_btn_xpath")));

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_adduservia_Gsuite_btn_xpath")));

			System.out.println("We think we Click on Add user via GSuite  Button...");

			}

	public void clickOnaddUserbyBulkOption() throws Exception {

		System.out.println("Trying to Click on Add Users by Bulk option button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_AdduserbyBulk_btn_xpath")));

		System.out.println("We think we Click on Add Users by Bulk option button...");

	}

	public boolean isDownloadSampleFilebtn() throws Exception {

		boolean status = isElementPresent(
				By.xpath(prop.getAppProperty("Akku_UserManagement_DownloadSampleFile_btn_xpath")));
		return status;
	}
	

	public void selectvalidcsvfile() throws Exception {

		/*WebElement uploadcsv = findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_Browse..._btn_xpath")));

		uploadcsv.sendKeys("..//App_Akku_Work//src//test//resources//input//Invalid_user.csv");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		

		WebElement elementUpload=findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_Bulkuser_upload_btn_xpath")));
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elementUpload));

		elementUpload.sendKeys("F://Automation_Workspace//Akku_Master//App_Akku_Work//src//test//resources//input//valid.csv");

		
		
	
	    
	}
	
	public void selectinvalidcsvfile() throws Exception {

		/*WebElement uploadcsv = findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_Browse..._btn_xpath")));

		uploadcsv.sendKeys("..//App_Akku_Work//src//test//resources//input//Invalid_user.csv");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		

		WebElement elementUpload=findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_Bulkuser_upload_btn_xpath")));
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elementUpload));

		elementUpload.sendKeys("F://Automation_Workspace//Akku_Master//App_Akku_Work//src//test//resources//input//Invalid_user.csv");

		
		
	
	    
	}
	
	
	public void ValidateErrormsg() {

		try {

			System.out.println("Trying to verify Error Message...");

			String Expected = "Upload failed invalid email id.";

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Bulkuser_upload_Errormsg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified Error Message...");
			Thread.sleep(1000);
			

		} catch (Exception e) {
			System.out.println("We think we Not Verified Error Message...");
			e.printStackTrace();
			

		}
	}

	public void CloseBulkuserpopscreen() {

		try {

			System.out.println("Trying to Close Pop Screen...");

			

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Bulkuser_popup_Close_xpath")));

		System.out.println("We think we Closed Bulk user Pop up window...");
		Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("We think we Not Closed...");
			e.printStackTrace();

		}
	}
	public void ValidateSuccessfullyresetmsg() {

		try {

			System.out.println("Trying to verify Successful Message...");

			String Expected = "Users Successfully Added";

			String Actual = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_Resetpwd_Succesmsg_xpath")));

			Assert.assertEquals(Actual, Expected);

			System.out.println("We think we Verified verify Successful Message...");
			Thread.sleep(1000);
			driver.navigate().refresh();

		} catch (Exception e) {
			System.out.println("We think we Typed Email ID in Edit User management...");
			e.printStackTrace();
			driver.navigate().refresh();

		}
	}

	public void clickOnBrowseBtn() throws Exception {

		System.out.println("Trying to Click on Browse button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Browse..._btn_xpath")));

		System.out.println("We think we Click on Browse button...");

	}

	public void clickOnUploadBtn() throws Exception {

		System.out.println("Trying to Click on Browse button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Upload_btn_xpath")));

		System.out.println("We think we Click on Browse button...");

	}

	public void selectcsvfile() throws Exception {

		WebElement uploadcsv = findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_Browse..._btn_xpath")));

		uploadcsv.sendKeys("..//App_Akku_Work//src//test//resources//input//qacsv.csv");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void closeAlertpopup() throws Exception {

		System.out.println("Trying to Click on Popup OK button...");

		click(By.xpath(prop.getAppProperty("Akku_EditInfo_Ok_btn_xpath")));

		System.out.println("We think we Click on Popup OK button...");
	}

	public void typeinsearchfield(String CSVEmail) throws Exception {
	
		System.out.println("Trying to Enter CSV email in the search text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_textfield_xpath")), CSVEmail);
			
		System.out.println("We think we Entered CSV email in the search text field...");
	}

	public boolean isCSVEmailDisplayed() throws Exception {

		WebElement CSVEmail = driver
				.findElement(By.xpath(prop.getAppProperty("Akku_UserManagement_csvemailtext_xpath")));
		if (CSVEmail.isDisplayed()) {
			log.info("After uploading the csv file, CSVEmail is updated and displayed");
			return false;
		} else {
			log.info("After uploading the csv file, CSVEmail is not displayed");
			return true;
		}
	}
}
