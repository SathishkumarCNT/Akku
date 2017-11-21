package com.app.akku.work.TestCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.akku.work.keywords.Keywords;
import com.applitools.eyes.selenium.Eyes;

public class Applitools {

	public static WebDriver driver;
	String environment;
	Eyes eyes = new Eyes();

	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String browser) throws Exception {

		eyes.setApiKey("9y6zDXCi105rnY96ATnIcm9FRe8QN109A3pMZ1C0NeoM8BQ110");

		if (browser.equalsIgnoreCase("firefox")) {

			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Ubuntu_geckodriver");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			eyes.open(driver, "HRBX", "Fire Fox Web UI");

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver",
					"..//App_Akku_Work//src//test//resources//Drivers//Ubuntu_chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			eyes.open(driver, "HRBX", "Chrome Web UI");
		}

	}

	@Test()
	public void HRBX_COM() throws Exception {

		driver.get("http://beta.hornbillfx.com/");

		Thread.sleep(5000);

		eyes.checkWindow("HornbillFX Site After 5 Sec");

		Thread.sleep(2000);

		eyes.checkWindow("HornbillFX Site After 7 Sec");

		Thread.sleep(2000);

		eyes.checkWindow("HornbillFX Site After 9 Sec");

		Thread.sleep(1000);

		eyes.checkWindow("HornbillFX Site After 10 Sec");

		Thread.sleep(1000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("Test case passed");

			} else if (result.getStatus() == ITestResult.FAILURE) {

				Keywords.captureScreenShot(driver);

				System.out.println("Screenshot taken in Tear Down method");

			} else if (result.getStatus() == ITestResult.SKIP) {

				Keywords.captureScreenShot(driver);

				System.out.println("Test case Skipped");
			}
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	@AfterTest
	public void teardown() throws Exception {

		driver.quit();

		eyes.abortIfNotClosed();
	}
}
