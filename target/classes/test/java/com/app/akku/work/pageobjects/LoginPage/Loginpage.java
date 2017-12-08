package com.app.akku.work.pageobjects.LoginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;
import com.aventstack.extentreports.Status;

public class Loginpage extends Keywords {
	
	
	ReadfromProperties prop = new ReadfromProperties();
	
	Logger log = Logger.getLogger(Loginpage.class.getName());
	
	  
	public Loginpage(WebDriver driver) {
		super(driver);
	}

	public void loginpageTitle() throws Exception {

		log.info("Trying to Validating Url Title");
		
		wait.until(ExpectedConditions.titleContains("Akku - Security and Privacy"));
		String actual_msg = driver.getTitle();
		String expect = "Akku - Security and Privacy";
		Assert.assertEquals(actual_msg, expect);
		System.out.println(actual_msg);
        test.log(Status.INFO,"We think we Validated Url Title "+ actual_msg);

        log.info("We think we Validated Url Title");

	}

	public void inputpassworderrormsgvalidation() throws Exception
	{

		log.info("Trying to Validate Password Error Message");
		waitTillElementlocate(By.xpath("//input[@id='password']"));
		String message = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("validationMessage");
		System.out.println(message);
		
		Assert.assertEquals(message, "Please fill out this field.");
		 test.log(Status.INFO,"We think we Validated Error message of Invalid Password: "+ message);
	}

	public void inputemailerrormsgvalidation() throws Exception {
		
		log.info("Trying to Validate Email ID Error Message");
		
		waitTillElementlocate(By.xpath("//input[@type='email']"));
		String Excepted ="Please fill out this field.";
		String Actual = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("validationMessage");
	
		Assert.assertEquals(Actual, Excepted);
	
		 test.log(Status.INFO," We think we Validated Error message of Invalid Email ID: "+ Actual);

	}

	public void EmailANDPwdErrorValidation() throws Exception {
		
		log.info(" Validating Error message of Invalid Email ID & password");

		waitTillAssertElementPresent(By.id("error"),"Invalid Username Or Password");


		String actual_msg = driver.findElement(By.id("error")).getText();
		String expect = "Invalid Username Or Password";

		System.out.println(actual_msg);
		System.out.println(expect);
		Assert.assertEquals(actual_msg, expect);
		
		
		log.info("We think we Validated Error message of Invalid Email ID & password");
		test.log(Status.INFO,"We think we Validated Error message of Invalid Email ID & password: "+ actual_msg);
		

	}

	public void typeUseremail(String email) throws Exception {
		
		log.info("Trying to Enter Email ID: "+email+" in the Email text field...");
		

	
		type(By.xpath(prop.getAppProperty("Login_email_xpath")), email);
				
		log.info("We think we Entered Email ID: "+email+" in the Email ID text field...");
		
		test.log(Status.INFO,"We think we Entered Email ID: "+ email);

	}

	public void typepassword(String password) throws Exception {

		log.info("Trying to Enter Password:"+password+" in the Password text field...");
	
		
		type(By.xpath(prop.getAppProperty("Login_pwd_xpath")), password);
		log.info("We think we Entered Password:"+password+" in the Password text field...");
		test.log(Status.INFO,"We think we Entered Password: "+ password);

	}

	public void clickLogin() throws Exception {
		
		log.info("Trying to Click on Login button...");
	
		click(By.xpath(prop.getAppProperty("Login_login_bnt_xpath")));
		log.info("Login button Clicked Sucessfully...");
		test.log(Status.INFO,"Trying to Click on Login button...");

	}

	public void clickLogout() throws Exception {

		log.info("Trying to Click on logout button...");
		

		click(By.xpath(prop.getAppProperty("Home_logout_btn_xpath")));

		wait.until(ExpectedConditions.titleContains("Akku - Security and Privacy"));

		String actual_msg = driver.findElement(By.xpath("//h2[contains(.,'Login to Akku Dashboard')]")).getText();
		String expect = "Login to Akku Dashboard";

		Assert.assertEquals(actual_msg, expect);

		log.info("We think we Clicked on logout button...");
		test.log(Status.INFO,"We think we Clicked on logout button...");

	}

	public void validatedloggedinUserDetailsEmailID(String email ) throws Exception {

		System.out.println("Trying to Validate Loggedin User Ac details...");
		checkPageIsReady();
		log.info(checkPageIsReady());
		
		boolean Actual = driver.getPageSource().contains(email);
		
		boolean expect = true;
		System.out.println(Actual);
	
		Assert.assertEquals(Actual, expect);
		System.out.println("We think we Validate Loggedin User Ac details...");
		test.log(Status.INFO,"We think we Validate Loggedin User Ac details...");

	}

	public void verifyloggedinFnameineditinfo() throws Exception {

	log.info("Trying to Validate Loggedin User First Name in Edit Info...");
	checkPageIsReady();
	log.info(checkPageIsReady());
		boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

		

		log.info("We think we Validate Loggedin First Name details in Edit Info...");
		
		test.log(Status.INFO,"We think we Validate Loggedin First Name details in Edit Info..."+Actual);

	}

	public void verifyloggedinLnameineditinfo() throws Exception {

		log.info("Trying to Validate Loggedin User Last Name in Edit Info...");
		checkPageIsReady();
		log.info(checkPageIsReady());
		boolean Actual = driver.getPageSource().contains("Duvoori");

		boolean expect = Actual;
		System.out.println(Actual);
		System.out.println(expect);

		Assert.assertEquals(Actual, expect);

		log.info("We think we Validate Logged in User Last Name  in Edit Info...");
		
		test.log(Status.INFO,"We think we Validate Logged in User Last Name  in Edit Info..."+Actual);

	}

	public void verifyloggedinUserFNameAndLName() throws Exception {

		log.info("Trying to Validate Loggedin User Ac details...");
		checkPageIsReady();
		log.info(checkPageIsReady());
		boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

		boolean expect = true;

		Assert.assertEquals(Actual, expect);
		log.info("We think we Validate Loggedin User FName And LName...");
		
		test.log(Status.INFO,"We think we Validate Loggedin user First Name Last Name details in Edit Info"+Actual);

	}
}
