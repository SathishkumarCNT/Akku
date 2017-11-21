package com.app.akku.work.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.app.akku.work.pageobjects.LoginPage.Loginpage;
import com.app.akku.work.pageobjects.OUManagement.OUmanagementpage;
import com.app.akku.work.pageobjects.editinfopage.EditInformationpage;
import com.app.akku.work.pageobjects.passwordPolicy.PasswordPolicy;
import com.app.akku.work.pageobjects.siteblocking.SiteBlockingpage;
import com.app.akku.work.pageobjects.usermanagement.AddGSuiteUser;
import com.app.akku.work.pageobjects.usermanagement.AddsingleUser;
import com.app.akku.work.pageobjects.usermanagement.EditUserfromUserManagement;
import com.app.akku.work.pageobjects.usermanagement.Usermanagementpage;


public class Browser_Setup {
	
	public  WebDriver driver;
	
	String environment;
	public static Loginpage loginpage;
	public static EditInformationpage editinfo;
	public static SiteBlockingpage siteblocking;
	public static Usermanagementpage usermanagement;
	public static AddsingleUser addsingleuser;
	public static EditUserfromUserManagement editUser;
	public static AddGSuiteUser addgsuiteuser;
	public static PasswordPolicy Pwdpolicy;
	public static OUmanagementpage oumangement;
	
	@BeforeMethod
	@Parameters({ "Environment","browser"})
	public void setup(String Environment, String browser) throws Exception {

		environment = Environment;
	
		if (browser.equalsIgnoreCase("U_firefox")) {
			
			System.out.println("launching firefox browser");
			
			System.setProperty("webdriver.gecko.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Ubuntu_geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("M_firefox")) {
		
			System.out.println("launching firefox browser");
			
			System.setProperty("webdriver.gecko.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//MAC_OS_geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("W_firefox")) {
		
			System.out.println("launching firefox browser");
			
			System.setProperty("webdriver.gecko.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Win_64_geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("U_chrome")) {
		
			System.out.println("launching chrome browser");
			
			System.setProperty("webdriver.chrome.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Ubuntu_chromedriver"); 																												
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("M_chrome")) {
		
			System.out.println("launching chrome browser");
			
			System.setProperty("webdriver.chrome.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//MAC_OS_chromedriver"); 																												
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("W_chrome")) {
		
			System.out.println("launching chrome browser");
			
			System.setProperty("webdriver.chrome.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Win_32_chromedriver.exe"); 																												
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
		
			System.out.println("launching IE browser");
			
			System.setProperty("webdriver.ie.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Win_X64_IEDriverServer.exe"); 																												
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
		
			System.out.println("launching IE browser");
			
			System.setProperty("webdriver.edge.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//MicrosoftWebDriver.exe"); 																												
			driver = new EdgeDriver();

		}	
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Environment);
				
		loginpage = new Loginpage(driver);
		usermanagement = new Usermanagementpage(driver);
		editinfo = new EditInformationpage(driver); 
		addsingleuser = new AddsingleUser(driver);
		editUser = new EditUserfromUserManagement(driver);
		addgsuiteuser = new AddGSuiteUser(driver);
		siteblocking =new SiteBlockingpage(driver);
		Pwdpolicy = new PasswordPolicy(driver);
		oumangement =new OUmanagementpage(driver);
		
	}
	
}
