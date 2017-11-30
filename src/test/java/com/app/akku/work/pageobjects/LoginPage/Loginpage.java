package com.app.akku.work.pageobjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.aventstack.extentreports.Status;

public class Loginpage extends Keywords {

	
	ReadfromProperties prop = new ReadfromProperties();

	public Loginpage(WebDriver driver) {
		super(driver);
	}

	public void loginpageTitle() throws Exception {

	

		System.out.println("Trying to Validating Url Title");

		String actual_msg = driver.getTitle();
		String expect = "Akku - Security and Privacy";

		Assert.assertEquals(actual_msg, expect);

		System.out.println(actual_msg);
        test.log(Status.INFO,"Validated Url Title:"+ actual_msg);

		System.out.println("We think we Validated Url Title");

	}

	public void inputpassworderrormsgvalidation() throws Exception{

		String message = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("validationMessage");
		System.out.println(message);
		
		 test.log(Status.INFO,"Password Error Message Validated: "+ message);
	}

	public void inputemailerrormsgvalidation() throws Exception {

		String message = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("validationMessage");
		System.out.println(message);
		
	
		 test.log(Status.INFO,"Email ID Error Message Validated: "+ message);

	}

	public void EmailANDPwdErrorValidation() throws Exception {
		
		log.error(" Validating Error message of Invalid Email ID & password");

		System.out.println("Trying to Validating Error message of Invalid Email & Pwsd");

		String actual_msg = driver.findElement(By.id("error")).getText();
		String expect = "Invalid Username Or Password";

		System.out.println(actual_msg);
		System.out.println(expect);
		Assert.assertEquals(actual_msg, expect);
		
		
		log.info("Validated Error message of Invalid Email ID & password");
		test.log(Status.INFO,"Email ID and Password Error Message Validated: "+ actual_msg);
		

	}

	public void typeUseremail(String email) throws Exception {
		
		log.info("Trying to Enter Email ID: "+email+" in the Email text field...");

		System.out.println("Trying to Enter email in the Email text field...");
		
		clear(By.xpath(prop.getAppProperty("Login_email_xpath")));

		type(By.xpath(prop.getAppProperty("Login_email_xpath")), email);

		System.out.println("We think we Entered Email in text field...");
		
		log.info("We think we Entered Email ID: "+email+" in the Email ID text field...");
		
		test.log(Status.INFO,"Email ID Entered: "+ email);

	}

	public void typepassword(String password) throws Exception {

		log.info("Trying to Enter Password:"+password+" in the Password text field...");
		System.out.println("Trying to Enter Password in the text field...");

		Thread.sleep(2000);
		type(By.xpath(prop.getAppProperty("Login_pwd_xpath")), password);

		System.out.println("We think we Entered Password in text field...");
		log.info("We think we Entered Password:"+password+" in the Password text field...");
		
		test.log(Status.INFO,"Password  Entered: "+ password);

	}

	public void clickLogin() throws Exception {
		
		log.info("Trying to Click on Login button...");

		System.out.println("Trying to Click on Login button...");

		click(By.xpath(prop.getAppProperty("Login_login_bnt_xpath")));

		System.out.println("We think we Clicked on Login button...");
		log.info("Login button Clicked Sucessfully...");
		
		test.log(Status.INFO,"Login Button Clicked");

	}

	public void clickLogout() throws Exception {

		System.out.println("Trying to Click on logout button...");

		click(By.xpath(prop.getAppProperty("Home_logout_btn_xpath")));

		String actual_msg = driver.findElement(By.xpath("//h2[contains(.,'Login to Akku Dashboard')]")).getText();
		String expect = "Login to Akku Dashboard";

		Assert.assertEquals(actual_msg, expect);

		System.out.println("We think we Clicked on logout button...");
		test.log(Status.INFO,"Logout Button Clicked");

	}

	public void validatedloggedinUserDetailsEmailID(String email) throws Exception {

		System.out.println("Trying to Validate Loggedin User Ac details...");

		boolean Actual = driver.getPageSource().contains(email);

		boolean expect = true;
		Assert.assertEquals(Actual, expect);
		System.out.println("We think we Validate Loggedin User Ac details...");
		test.log(Status.INFO,"Validated Loggedin User Ac");

	}

	public void verifyloggedinFnameineditinfo() throws Exception {

		System.out.println("Trying to Validate Loggedin User First Name in Edit Info...");

		boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

		boolean expect = Actual;
		System.out.println(Actual);
		System.out.println(expect);

		Assert.assertEquals(Actual, expect);

		System.out.println("We think we Validate Loggedin First Name details in Edit Info...");
		
		test.log(Status.INFO,"Validated Loggedin user First Name details in Edit Info"+Actual);

	}

	public void verifyloggedinLnameineditinfo() throws Exception {

		System.out.println("Trying to Validate Loggedin User Last Name in Edit Info...");

		boolean Actual = driver.getPageSource().contains("Duvoori");

		boolean expect = Actual;
		System.out.println(Actual);
		System.out.println(expect);

		Assert.assertEquals(Actual, expect);

		System.out.println("We think we Validate Logged in User Last Name  in Edit Info...");
		
		test.log(Status.INFO,"Validated Loggedin user Last Name details in Edit Info"+Actual);

	}

	public void verifyloggedinUserFNameAndLName() throws Exception {

		System.out.println("Trying to Validate Loggedin User Ac details...");

		boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

		boolean expect = true;

		Assert.assertEquals(Actual, expect);
		System.out.println("We think we Validate Loggedin User FName And LName...");
		
		test.log(Status.INFO,"Validated Loggedin user First Name Last Name details in Edit Info"+Actual);

	}
}
