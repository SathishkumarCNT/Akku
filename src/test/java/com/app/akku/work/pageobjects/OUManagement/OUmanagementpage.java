package com.app.akku.work.pageobjects.OUManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.akku.work.common.ReadfromProperties;
import com.app.akku.work.keywords.Keywords;

public class OUmanagementpage extends Keywords {
	ReadfromProperties prop = new ReadfromProperties();
	
	public OUmanagementpage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOUmanagementBtn() throws Exception {

		System.out.println("Trying to Click on OU button...");

		click(By.xpath(prop.getAppProperty("Home_OuManagement_btn_xpath")));
			

		System.out.println("We think we Click on OU button...");
	}
	
	public void clickAddOUBtn() throws Exception {


		System.out.println("Trying to Click on Add OU button...");

		moveMouse(By.xpath(prop.getAppProperty("OuManagement_Plus_btn_xpath")));

		Thread.sleep(2000);
		

		click(By.xpath(prop.getAppProperty("OuManagement_AddOu_tooltip_btn_Xpath")));

		System.out.println("We think we Click on Add OU Manually button...");
	}
	

}
