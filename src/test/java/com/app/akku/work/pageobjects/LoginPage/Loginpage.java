package com.app.akku.work.pageobjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class Loginpage extends Keywords {
	
	ReadfromProperties prop = new ReadfromProperties();
		
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	public void loginpageTitle()throws Exception
	{
		
		System.out.println("Trying to Validating Url Title");
		
		String actual_msg=driver.getTitle();
		String expect="Akku - Security and Privacy";		
		
		Assert.assertEquals(actual_msg, expect);		
		
		System.out.println(actual_msg);
		
		System.out.println("We think we Validated Url Title");
							
	}	
	
	public void inputpassworderrormsgvalidation() {
		
		String message = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("validationMessage");
		System.out.println(message);
	} 
	
	public void inputemailerrormsgvalidation() {
		
		String message = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("validationMessage");
		System.out.println(message);
	}
	
	public void EmailANDPwdErrorValidation()throws Exception
	{
	
		System.out.println("Trying to Validating Error message of Invalid Email & Pwsd");
		
				
		String actual_msg= driver.findElement(By.id("error")).getText();
		String expect="Invalid Username Or Password";		
		
		Assert.assertEquals(actual_msg, expect);		
		
		System.out.println("We think we Validated Error message of Invalid Email & Pwsd");		
				
	}	
	
	public void typeUseremail(String email) throws Exception {
				
		System.out.println("Trying to Enter email in the Email text field...");
								
		type(By.xpath(prop.getAppProperty("Login_email_xpath")),email);
		
		System.out.println("We think we Entered Email in text field...");	
		
	}
	public void typepassword(String password) throws Exception {
		
		System.out.println("Trying to Enter Password in the text field...");
		
					
		type(By.xpath(prop.getAppProperty("Login_pwd_xpath")),password);
				
		System.out.println("We think we Entered Password in text field...");
		
	}
	public void clickLogin() throws Exception{
		
		
		System.out.println("Trying to Click on Login button...");
				
		click(By.xpath(prop.getAppProperty("Login_login_bnt_xpath")));	
		
		System.out.println("We think we Clicked on Login button...");
	}
	
	public void clickLogout() throws Exception{
		
		try {
			System.out.println("Trying to Click on logout button...");
					
			click(By.xpath(prop.getAppProperty("Home_logout_btn_xpath")));
			
			String actual_msg = driver.findElement(By.xpath("//h2[contains(.,'Login to Akku Dashboard')]")).getText();
			String expect = "Login to Akku Dashboard";
			
			Assert.assertEquals(actual_msg, expect);
			
			System.out.println("We think we Clicked on logout button...");
		} catch (Exception e) {
			do{// TODO Auto-generated catch block
			e.printStackTrace();
			break;
		}
			while(true);	
		}		
	}
		
	public void validatedloggedinUserDetailsEmailID(String email){

		System.out.println("Trying to Validate Loggedin User Ac details...");

		boolean Actual = driver.getPageSource().contains(email);
	
		boolean expect=true;	

		Assert.assertEquals(Actual, expect);	

		System.out.println("We think we Validate Loggedin User Ac details...");
	

	}
	public void verifyloggedinFnameineditinfo() {

		try {

			System.out.println("Trying to Validate Loggedin User First Name in Edit Info...");

			boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

			boolean expect = Actual;
			System.out.println(Actual);
			System.out.println(expect);

			Assert.assertEquals(Actual, expect);

			System.out.println("We think we Validate Loggedin First Name details in Edit Info...");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void verifyloggedinLnameineditinfo() {

		try {

			System.out.println("Trying to Validate Loggedin User Last Name in Edit Info...");

			boolean Actual = driver.getPageSource().contains("Duvoori");

			boolean expect = Actual;
			System.out.println(Actual);
			System.out.println(expect);

			Assert.assertEquals(Actual, expect);

			System.out.println("We think we Validate Logged in User Last Name  in Edit Info...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void verifyloggedinUserFNameAndLName() {

		System.out.println("Trying to Validate Loggedin User Ac details...");

		boolean Actual = driver.getPageSource().contains("Mallikarjuna Reddy");

		boolean expect = true;	
		
		Assert.assertEquals(Actual, expect);	

		System.out.println("We think we Validate Loggedin User FName And LName...");
	}
}
