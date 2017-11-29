package com.app.akku.work.common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class Browser_Setup {

	public WebDriver driver;

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
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

    Logger log = Logger.getLogger(Browser_Setup.class.getName());

	@BeforeSuite
	public void setUp() {
		System.out.println("Before Suite");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Host Name", "AKKU");
		report.setSystemInfo("Environment", "Pre-Prod");
		report.setSystemInfo("User Name", "SathishKumar");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(" AKKU Report");
		htmlReporter.config().setReportName("AKKU Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

	}

	@BeforeTest
	@Parameters({ "Environment", "browser" })
	public void setup(String Environment, String browser) throws Exception {

		environment = Environment;

		if (browser.equalsIgnoreCase("U_firefox")) {
			log.info("Launching firefox browser.");

		

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
			log.info("Launching Chrome browser in Windows");

			System.out.println("launching chrome browser");

			System.setProperty("webdriver.chrome.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Win_32_chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome browser Launched Sucessfully in Windows.");

		} else if (browser.equalsIgnoreCase("IE")) {

			System.out.println("launching IE browser");

			System.setProperty("webdriver.ie.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Win_X64_IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {

			System.out.println("launching Edge browser");

			System.setProperty("webdriver.edge.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Environment);
		driver.manage().deleteAllCookies();

		loginpage = new Loginpage(driver);
		usermanagement = new Usermanagementpage(driver);
		editinfo = new EditInformationpage(driver);
		addsingleuser = new AddsingleUser(driver);
		editUser = new EditUserfromUserManagement(driver);
		addgsuiteuser = new AddGSuiteUser(driver);
		siteblocking = new SiteBlockingpage(driver);
		Pwdpolicy = new PasswordPolicy(driver);
		oumangement = new OUmanagementpage(driver);

	}

	public String getOSBrowserDetails() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String BrowserName = cap.getBrowserName().toLowerCase();
		String os = System.getProperty("os.name").toLowerCase();
		String BrowserVersion = cap.getVersion().toString();
		System.out.println("OS = " + os + ", Browser = " + BrowserName + ", BrowserVersion=" + BrowserVersion + "");
		String OSBrowserDetails = "Test Execution Successfully Passed in OS = " + os + ", Browser = " + BrowserName
				+ ", BrowserVersion=" + BrowserVersion + "";
		return OSBrowserDetails;

	}

	@AfterSuite
	public void teardown() throws Exception {
		System.out.println("Test Suite Execution Finished");

		report.close();

	}
}
