package com.app.akku.work.pageobjects.usermanagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.aventstack.extentreports.Status;

public class AddsingleUser extends Keywords {
	
	Logger log = Logger.getLogger(AddsingleUser.class.getName());

	public AddsingleUser(WebDriver driver) {
		super(driver);

	}

	ReadfromProperties prop = new ReadfromProperties();
	String Email;

	public void typeFname(String Fname) throws Exception {

		log.info("Trying to Enter FName in the FName text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_FName_xpath")), Fname);

		log.info("We think we  Enter FName in the FName text field: " + Fname);

		test.log(Status.INFO, "We think we  Enter FName in the FName text field: " + Fname);

	}

	public void typeLname(String Lname) throws Exception {

		log.info("Trying to Enter LName in the LName text field...");

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_LName_xpath")), Lname);

		log.info("We think we Entered LName in the LName text field...");
		test.log(Status.INFO, "We think we  Enter LName in the LName text field: " + Lname);
	}

	public void typeEmail() throws Exception {

		log.info("Trying to Enter email in the email text field...");

		String Email = "Testuser" + (int) (Math.random() * 1000) + "@demo.cloudnowtech.com";

		log.info(Email);

		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_email_xpath")), Email);

		log.info("We think we Entered email in the email text field: " + Email);

		test.log(Status.INFO, "We think we Entered email in the email text field: " + Email);
	}

	public void typeConfnewpassword(String Confnewpassword) throws Exception {

		log.info("Trying to Enter Confirm Password in the Email text field...");

		click(By.xpath(prop.getAppProperty("conpassword_Xpath")));
		type(By.xpath(prop.getAppProperty("conpassword_Xpath")), Confnewpassword);

		log.info("We think we Entered Confirm  Password in then Email text field: " + Confnewpassword);

		test.log(Status.INFO, "We think we Entered Confirm  Password in then Email text field: " + Confnewpassword);
	}

	public void clickonConfirmAndAddUser() throws Exception {

		log.info("Trying to Click on Confirm And Add button...");

		click(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_ConfirmAndAddUser_xpath")));

		log.info("We think we Clicked on Confirm And Add button...");

		test.log(Status.INFO, "We think we Click on Confirm And Add button");

	}

	public void clickondropdowntoselectusertypeASuser() throws Exception {

		log.info("Trying to Select  on User from User Type drop down...");
waitTillElementlocate(By.xpath("//*[@id=\"autype\"]"));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
		Select se = new Select(element);
		se.selectByIndex(0);

		log.info("We think we We selected User from Usertype drop down");

		test.log(Status.INFO, "We think we We selected User from Usertype drop down");

	}

	public void clickondropdowntoselectusertypeASAdmin() throws Exception {
		log.info("Trying to Select  on User from User Type drop down...");
		waitTillElementlocate(By.xpath("//*[@id=\"autype\"]"));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
		Select se = new Select(element);
		se.selectByIndex(1);

		log.info("We think we We selected Admin from Usertype drop down");

		test.log(Status.INFO, "We think we We selected Admin from Usertype drop down");

	}

	public void addusertypeinusermanagement()throws Exception {

	
			log.info("Select User Type in Edit User management...");

			String Usertype_user = "User";
			waitTillElementlocate(By.xpath(prop.getAppProperty("Akku_UserManagement_addusertype_xpath")));
			String readusertype = getText(By.xpath(prop.getAppProperty("Akku_UserManagement_addusertype_xpath")));

			if (readusertype.equals(Usertype_user)) {
				WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
				Select se = new Select(element);
				se.selectByIndex(2);
			} else {
				WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
				Select se = new Select(element);
				se.selectByIndex(1);
			}
		

		log.info("We think we We selected Usertype in drop down");

		test.log(Status.INFO, "We think we We selected Usertype from drop down");
	}
}
