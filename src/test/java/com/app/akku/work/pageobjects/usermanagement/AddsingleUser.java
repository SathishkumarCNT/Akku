package com.app.akku.work.pageobjects.usermanagement;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class AddsingleUser extends Keywords {
	
	public AddsingleUser(WebDriver driver) {
		super(driver);
		
	}
	
	ReadfromProperties prop = new ReadfromProperties();
	String Email;
	
	public void typeFname(String Fname) throws Exception {
    			
		System.out.println("Trying to Enter FName in the FName text field...");
		
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_FName_xpath")), Fname);
		
		System.out.println("We think we Entered FName in the FName text field...");
							
	}

	public void typeLname(String Lname) throws Exception {
    				
		System.out.println("Trying to Enter LName in the LName text field...");
				
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_LName_xpath")), Lname);
					
		System.out.println("We think we Entered LName in the LName text field...");
	}

	
    public void typeEmail() throws Exception {
    	
		System.out.println("Trying to Enter email in the email text field...");
						
		String Email="Testuser"+(int)(Math.random()*1000)+"@demo.cloudnowtech.com";
			

		 System.out.println(Email);
				
		
		type(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_email_xpath")),Email);	
				
		System.out.println("We think we Entered email in the email text field...");
	}
    
    public void typeConfnewpassword(String Confnewpassword) throws Exception {
    
		System.out.println("Trying to Enter Confirm Password in the Email text field...");
		
		click(By.xpath(prop.getAppProperty("conpassword_Xpath")));
		type(By.xpath(prop.getAppProperty("conpassword_Xpath")), Confnewpassword);
				
		System.out.println("We think we Entered Confirm  Password in then Email text field...");
	}
    
    public void clickonConfirmAndAddUser() throws Exception {
    
    	System.out.println("Trying to Click on Confirm And Add button...");
		
		click(By.xpath(prop.getAppProperty("Akku_UserManagement_AddUserManually_ConfirmAndAddUser_xpath")));
		    	
		System.out.println("We think we Clicked on Confirm And Add button...");
    	
    }
    
    public void clickondropdowntoselectusertypeASuser() throws Exception {
    	
    
    	
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
		Select se = new Select(element);
		se.selectByIndex(0);
    	
    }
    
    public void clickondropdowntoselectusertypeASAdmin() throws Exception {
    	
    	
    	
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"autype\"]"));
		Select se = new Select(element);
		se.selectByIndex(1);
    	
    	
    }
    
    public void addusertypeinusermanagement() {

		try {
			System.out.println("Select User Type in Edit User management...");

			String Usertype_user = "User";
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
		} catch (Exception e) {
			System.out.println("We think we Selected User type in Edit User management...");
			e.printStackTrace();

		}
 
    
}
}
