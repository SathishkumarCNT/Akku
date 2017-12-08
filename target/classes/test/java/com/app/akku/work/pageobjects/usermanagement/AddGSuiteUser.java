package com.app.akku.work.pageobjects.usermanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.app.akku.work.pageobjects.siteblocking.SiteBlockingpage;
import com.aventstack.extentreports.Status;

public class AddGSuiteUser extends Keywords {
	
	Logger log = Logger.getLogger(AddGSuiteUser.class.getName());

	public AddGSuiteUser(WebDriver driver) {
		super(driver);
	}

	ReadfromProperties prop = new ReadfromProperties();

	public void typeGSuiteEmail(String GSuiteEmail) throws Exception {

		log.info("Trying to Enter Gsuite Admin email in the text field...");

		type(By.id(prop.getAppProperty("GSuite_EmailID_ID")), GSuiteEmail);

		test.log(Status.INFO, "We think we Entered Gsuite Admin email in the text field: " + GSuiteEmail);
		log.info("We think we Entered Gsuite Admin email in the text field...");

	}

	public void typeGSuitePwd(String GSuitePwd) throws Exception {

		log.info("Trying to Enter Gsuite Admin password in the text field...");
		type(By.xpath(prop.getAppProperty("GSuite_Password_Xpath")), GSuitePwd);

		test.log(Status.INFO, "We think we Entered Gsuite Admin password in the text field:" + GSuitePwd);

		log.info("We think we Entered Gsuite Admin password in the text field");

	}

	public void verifyGSuiteDahsboardtext() {

		log.info("Trying to Validated GSuite Dashboard Text");

		String actual_msg = driver.findElement(By.xpath("//span[@class='semi-bold']")).getText();
		String expected = "G-Suite Users Synchronization";
		Assert.assertEquals(actual_msg, expected);

		log.info("We think we Validated GSuite Dashboard Text");

		test.log(Status.INFO, "We think we Validated GSuite Dashboard Text");
	}

	public void clickOnNextBtnofGSuiteFormEmail() throws Exception {

		log.info("Trying to click on Next button in GSuite Login After Email Entered...");

		click(By.id(prop.getAppProperty("GSuite_EmailID_Email_Next_Btn_ID")));

		log.info("We think we clicked on Next button in GSuite Login form...");
		test.log(Status.INFO, "We think we clicked on Next button in GSuite Login form");

	}

	public void clickOnNextBtnofGSuiteFormPassword() throws Exception {

		log.info("Trying to click on Next button in GSuite Login form...");

		click(By.xpath(prop.getAppProperty("GSuite_EmailID_Password_Next_Btn_Xpath")));

		test.log(Status.INFO, "We think we clicked on Next button in GSuite Login form");
		log.info("We think we clicked on Next button in GSuite Login form...");

	}

	public void clickOnAddnewuser() throws Exception {

		log.info("Trying to click on Add new button in G-Suite Users Synchronization List...");

		click(By.xpath(prop.getAppProperty("GSuite_Adduser_btn_Xpath")));

		log.info("We think we clicked Add new button in G-Suite Users Synchronization List.");

		test.log(Status.INFO, "We think we clicked Add new button in G-Suite Users Synchronization List");

	}

	public void EnterFirsttName(String Fname) throws Exception {

		log.info("Enter Last Name ..");

		clear(By.xpath(prop.getAppProperty("GSuite_Adduser_FName_btn_Xpath")));
		type(By.xpath(prop.getAppProperty("GSuite_Adduser_FName_btn_Xpath")), Fname);

		log.info("We think we entered Last name: " + Fname);
		test.log(Status.INFO, "We think we entered Last name: " + Fname);

	}

	public void EnterLastName() throws Exception {

		log.info("Enter Last Name ..");

		String Lastname = "User";
		log.info(Lastname);
		clear(By.xpath(prop.getAppProperty("GSuite_Adduser_LName_btn_Xpath")));
		type(By.xpath(prop.getAppProperty("GSuite_Adduser_LName_btn_Xpath")), Lastname);

		log.info("We think we entered Last name:" + Lastname);
		test.log(Status.INFO, "We think we entered Last name:" + Lastname);
	}

	public void Password(String Confnewpassword) throws Exception {

		log.info("Enter Password ..");

		clear(By.xpath(prop.getAppProperty("GSuite_Adduser_password_btn_Xpath")));

		type(By.xpath(prop.getAppProperty("GSuite_Adduser_password_btn_Xpath")), Confnewpassword);

		log.info("We think we entered password: " + Confnewpassword);
		test.log(Status.INFO, "We think we entered Last name: " + Confnewpassword);

	}

	public void clickAddUser() throws Exception {

		log.info("Clicking AddUser Button ..");

		click(By.xpath(prop.getAppProperty("GSuite_Adduser_Add_btn_btn_Xpath")));

		log.info("We think we Click AddUser Button...");

		test.log(Status.INFO, "We think we Click AddUser Button");

	}

	public void Validateuserlist(String Fname) throws Exception {

		log.info("Trying to Verify User Found in List");

		clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), Fname);

		int totalusercount;

		totalusercount = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr")).size();

		log.info(totalusercount);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr/td[2]"));


		String Filter = Fname;
		for (int i = 0; i <= totalusercount; i++) {
			String listelement = elements.get(i).getText();

			log.info(i);
			if (listelement.contains(Filter)) {
				log.info("Record Found");
	
				break;
			}
			else
			{
				Assert.fail();
			}

		}
		log.info("We think we found User in Grid...");

		test.log(Status.INFO, "We think we found User in Grid...");
	}
}
