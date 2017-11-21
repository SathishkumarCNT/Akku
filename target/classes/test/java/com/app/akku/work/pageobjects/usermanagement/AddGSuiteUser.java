package com.app.akku.work.pageobjects.usermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;


public class AddGSuiteUser extends Keywords {

	public AddGSuiteUser(WebDriver driver) {
		super(driver);
	}

	ReadfromProperties prop = new ReadfromProperties();

	public void typeGSuiteEmail(String GSuiteEmail) throws Exception {

			System.out.println("Trying to Enter Gsuite Admin email in the text field...");

			type(By.id(prop.getAppProperty("GSuite_EmailID_ID")), GSuiteEmail);

			System.out.println("We think we Entered Gsuite Admin email in the text field...");

	}

	public void typeGSuitePwd(String GSuitePwd) throws Exception {
	
		System.out.println("Trying to Enter Gsuite Admin password in the text field...");
		type(By.xpath(prop.getAppProperty("GSuite_Password_Xpath")), GSuitePwd);

		
		System.out.println("We think we Entered Gsuite Admin password in the text field...");
	
	}

	public void verifyGSuiteDahsboardtext() {

			System.out.println("Trying to Validated GSuite Dashboard Text");

			String actual_msg = driver.findElement(By.xpath("//span[@class='semi-bold']")).getText(); // fa fa-google
			String expected = "G-Suite Users Synchronization";
			Assert.assertEquals(actual_msg, expected);

			System.out.println("We think we Validated GSuite Dashboard Text");

			System.out.println("We think we didn't Validated GSuite Dashboard Text");	
	}

	public void clickOnNextBtnofGSuiteFormEmail() throws Exception {
	
			System.out.println("Trying to click on Next button in GSuite Login After Email Entered...");

			

			click(By.id(prop.getAppProperty("GSuite_EmailID_Email_Next_Btn_ID")));

			

			System.out.println("We think we clicked on Next button in GSuite Login form...");
		
	}

	public void clickOnNextBtnofGSuiteFormPassword() throws Exception {
	
			System.out.println("Trying to click on Next button in GSuite Login form...");

			click(By.xpath(prop.getAppProperty("GSuite_EmailID_Password_Next_Btn_Xpath")));

			

			System.out.println("We think we clicked on Next button in GSuite Login form...");
		
	}

	public void clickOnAddnewuser() {
		try {
			System.out.println("Trying to click on Add new button in G-Suite Users Synchronization List...");

			click(By.xpath(prop.getAppProperty("GSuite_Adduser_btn_Xpath")));

			System.out.println("We think we clicked Add new button in G-Suite Users Synchronization List...");
		} catch (Exception e) {
			System.out.println("We think we didn't clicked Add new button in G-Suite Users Synchronization List...");
			e.printStackTrace();
		}
	}

	public void EnterFirsttName(String Fname) {
		try {
			System.out.println("Enter Last Name ..");

			clear(By.xpath(prop.getAppProperty("GSuite_Adduser_FName_btn_Xpath")));
			type(By.xpath(prop.getAppProperty("GSuite_Adduser_FName_btn_Xpath")), Fname);

			System.out.println("We think we entered Last name...");
		} catch (Exception e) {
			System.out.println("We think we didn't entered Last name...");
			e.printStackTrace();
		}
	}

	public void EnterLastName() {
		try {
			System.out.println("Enter Last Name ..");

			String Lastname = getTimeStamp();
			System.out.println(Lastname);
			clear(By.xpath(prop.getAppProperty("GSuite_Adduser_LName_btn_Xpath")));
			type(By.xpath(prop.getAppProperty("GSuite_Adduser_LName_btn_Xpath")), Lastname);

			System.out.println("We think we entered Last name...");
		} catch (Exception e) {
			System.out.println("We think we didn't entered Last name...");
			e.printStackTrace();
		}
	}

	public void Password(String Confnewpassword) {
		try {
			System.out.println("Enter Last Name ..");

			clear(By.xpath(prop.getAppProperty("GSuite_Adduser_password_btn_Xpath")));

			type(By.xpath(prop.getAppProperty("GSuite_Adduser_password_btn_Xpath")), Confnewpassword);

			System.out.println("We think we entered Last name...");
		} catch (Exception e) {
			System.out.println("We think we didn't entered Last name...");
			e.printStackTrace();
		}
	}

	public void clickAddUser() {
		try {
			System.out.println("Clicking AddUser Button ..");

			click(By.xpath(prop.getAppProperty("GSuite_Adduser_Add_btn_btn_Xpath")));

			System.out.println("We think Click AddUser Button...");
		} catch (Exception e) {
			System.out.println("We think we didn't Click AddUser Button ...");
			e.printStackTrace();
		}
	}

	public void Validateuserlist(String Fname) throws Exception {
		try {
			System.out.println("Verify User Found in List");

			clear(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));

			click(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")));
			type(By.xpath(prop.getAppProperty("Akku_UserManagement_Search_fromlist_xpath")), Fname);

			int totalusercount;

			totalusercount = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr")).size();

			System.out.println(totalusercount);

			List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"user-list\"]/tbody/tr/td[2]"));

			Thread.sleep(2000);
			String Filter = Fname;
			for (int i = 0; i <= totalusercount; i++) {
				String listelement = elements.get(i).getText();

				System.out.println(i);
				if (listelement.contains(Filter)) {
					System.out.println("Record Found");
					Thread.sleep(2000);
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
