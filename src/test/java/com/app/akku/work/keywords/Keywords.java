package com.app.akku.work.keywords;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Keywords {

	public  static String ImagesPath = "..//App_Akku_Work//src//test//resources//Screenshots//"; 
	
	String Email;
	
	public WebDriver driver;
	
	Logger log = Logger.getLogger(Keywords.class);
		
	public Keywords(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getvalidationMessage(By object) {
		return driver.findElement(object).getAttribute("validationMessage");
	}
	
	
	public void generateUserAc() {
		
		String prefix="Automation_";	
		String suff="@demo.cloudnowtech.com";	
		String Email;
		
		String Date = getTimeStamp();
		//Date=Date.replaceAll("[/:]","");		
		Email=prefix.concat(Date);
		Email=Email.concat(suff);
		
		
		
		System.out.println(Email);
		
	}
	
	protected String getTimeStamp() {
		
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
		Calendar cal = Calendar.getInstance();
		String dateformat = dateFormat.format(cal.getTime());
		log.info("inside time stamp method:"+dateFormat.format(cal.getTime()));
		log.info("inside time stamp method:"+dateFormat);
		return dateformat;
	}
	public String date1() 
	{ 
		Date d = new Date();
		String date=d.toString().replaceAll(" ", "_");
		date=date.replaceAll(":", "_");
		date=date.replaceAll("\\+", "_");
		//log.info(date1);
		return date;
	}

	public static String date2()
	{
		String myformat = "dd_MM_yyyy_HH_mm_ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(myformat);
		String date = sdf.format(cal.getTime());
		//log.info(date2);
		return date;
	}
    
	public static String captureScreenShot(WebDriver driver){
        
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
		try {
			 
		FileUtils.copyFile(src, new File("..//App_Akku_Work//src//test//resources//Screenshots//"+System.currentTimeMillis()+".png"));   
		
		} catch (IOException e)
		 
		{
		  System.out.println(e.getMessage());
		 }
		return ImagesPath;		
	}
	
		
	public static String startdate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");	 
		 //get current date time with Date()
		 Date sdate = new Date();	 

		 // Now format the date
		 String st_date1= dateFormat.format(sdate);
		return  st_date1; 
	}

	public String enddate()
	{
			String myformat = "MM/dd/yyyy";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(myformat);
			cal.add(Calendar.DATE, 10);;
			String edate = sdf.format(cal.getTime());
			//log.info(date2);
			return edate; 
	}
	
	
	public String enddate1()
	{
			String myformat = "MM/dd/yyyy";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(myformat);
			cal.add(Calendar.DATE, 20);;
			String edate = sdf.format(cal.getTime());
			//log.info(date2);
			return edate; 
	}
	
	
	public void linkInNewWIndow(By object) throws Exception{
		Actions action = new Actions(driver);
		WebElement link =driver.findElement(object);
		action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(5000);
	}
		
	public  String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	public  String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	public boolean isSelected(By object) throws Exception {

		boolean select = driver.findElement(object).isSelected();

		if (select == true) {

			return true;
		} else {
			return false;
		}

	}

	public boolean IsDisplayed(By object) throws Exception {

		boolean select = driver.findElement(object).isDisplayed();

		if (select == true) {

			return true;
		} else {
			return false;
		}

	}
	
	public void doubleclick(By object) throws Exception
	{
		try{
			Actions action = new Actions(driver);
			WebElement element=driver.findElement(object);

			//Double click
			action.doubleClick(element).perform();
		}catch (Exception e) {
			log.info("Element is not doble clickable");
		}
	}
	
	public void doubleClick(By object) {
		try {
			Actions action = new Actions(driver);
			WebElement element=driver.findElement(object);

			//Double click
			action.doubleClick(element).perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + object + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + object + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public void switchToWindow() throws Exception{
		
			String parentWindow = driver.getWindowHandle();
			Set<String> handles =  driver.getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			          driver.switchTo().window(windowHandle);
			       //Perform your operation here for new window-->
			          Thread.sleep(3000);
			          driver.manage().window().maximize();
			          }
			       }
	}
	
	
	
	public boolean isverifyElementAbsent(By object) throws Exception {
	    try {
	        driver.findElement(object);
	        log.info("Element Present");
	        return false;
	    } 

	   catch (Exception e) {
	        log.info("Element is absent");
	        return true;
	    }
	}
	
	public boolean daterange(String testdate, String startdate, String enddate)throws Exception{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date testDate = df.parse(testdate);
		Date startDate = df.parse(startdate);
		Date endDate = df.parse(enddate);
		return testDate.getTime()>=startDate.getTime() && testDate.getTime()<=endDate.getTime();
	}

	public void click(By object) throws Exception {
		try{
			driver.findElement(object).click();
			Thread.sleep(1000);		
		}catch(Exception e) {
			
			
		}
	}
	
	public void clear(By object)throws Exception{
		try
		{
			driver.findElement(object).clear();
			Thread.sleep(1000);		
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public  WebElement clickelement(By object, WebElement element) throws Exception {
		try{
			driver.findElement(object).click();
			Thread.sleep(1000);			
		}catch(Exception e)
		{
			e.getMessage();
		}
		return null;
	}
	
	public void click(WebElement element) {
		try
		{
			element.click();
		}catch(Exception e)
		{
			String exp=element.toString();
			
		}
	}

	public void type(By object, String data) throws Exception {
		
		try{
			driver.findElement(object).sendKeys(data);
			}
		catch(Exception e)
		{
			String exp=object.toString();
			
		}
	}

	public void pressTabkey(By object) throws Exception{
		/*logs.debug("Executing___"+testName+"___"+stepName);*/
		try
		{
			driver.findElement(object).sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
	}

	public String getText(By object) throws Exception{
		try{
			String text = driver.findElement(object).getText();	 		
		
			return text;
		}catch(Exception e){
			
			return null;
		}
	}

	public String getWindowtitle() throws Exception{
		try{
			String text = driver.getTitle();	
			return text;
		} catch (Exception e) {
			log.info("fail-----");
			
			
		
			log.info("fail-----");
			return null;
		}
	}

	public WebElement findElement(By object) throws Exception {
		try
		{			
		WebElement element=driver.findElement(object);
		return element;
		}
		catch(Exception e)
		{		
			String exp=object.toString();
		
			throw e;
		}
	}

	public int sizeOf(By object) {
		int size=driver.findElements(object).size();
		return size;
	}


	public String getValue(By object) {
		return driver.findElement(object).getAttribute("value");
	}

	public boolean isTextPresent(By object, String text) {
		log.info(driver.findElement(object).getText());
		return driver.findElement(object).getText().contains(text);
	}
	
	public boolean waitForTextPresent(final String text1, final String text2) throws Exception {
		log.info(null);
		boolean result = true;
		for (int second = 0;; second++) {
			log.info(second);
			if (second >= 100) {
				
				result = false;
				break;
			}
			try {
				if(driver.getPageSource().contains(text1) || driver.getPageSource().contains(text2))
					break;
				else
					Thread.sleep(1000);
			} catch (Exception e) {}
		}
		return result;
	}

	public boolean waitForTextPresent(final String text) throws Exception {
		log.info(null);
		boolean result = true;
		for (int second = 0;; second++) {
			if (second >= 1) {
				
				result = false;
				break;
			}
			try {
				if(driver.getPageSource().contains(text))
					break;
				else
					log.info("Thread");
					Thread.sleep(1000);
			} catch (Exception e) {}
		}
		return result;
		
	}

	public boolean waitForTextPresent(final By object,final String text) throws Exception {
		boolean result = true;
		for (int second = 0;; second++) {
			log.info(second);
			if (second >= 60) {
			
				result = false;
				break;
			}
			try { 
				if(this.isElementPresent(object)){
					if(this.getText(object).equals(text))
						break;
					else
						Thread.sleep(1000);
				}
				else fail("Element not found");

			} catch (Exception e) {}
		}
		return result;
	}


	public boolean waitForTextToBeDisplayed(final By object) throws Exception{
		boolean result = true;
		for (int second = 0;; second++) {
			log.info(second);
			if (second >= 60) {
			
				result = false;
				break;
			}
			try { 
				if(this.isElementPresent(object))
					if(!this.getText(object).isEmpty())
						break;
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public void waitForTextboxValueTobepopulated(final By object){
		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !d.findElement(object).getAttribute("value").isEmpty();
			}
		});
	}


	public WebElement WaitForElement(By object) throws Exception {
		try	{		          
			WebDriverWait wait = new WebDriverWait(driver,60);
			return wait.until(ExpectedConditions.presenceOfElementLocated(object)); 

		}
		catch (Exception e) {
			throw e;
		}
	}

	public boolean isElementPresent(By object) throws Exception	{
		try{
			driver.findElement(object);
			return true;
		}catch(Exception e){
		
			
			return false;
		}
	}

	public void waitForElementPresent(By object) {
		log.info("wait for Xpath element present is reached");
		for (int second = 0;; second++) {
			log.info("second: "+second);
			if (second >= 10) fail("timeout");
			try { 
				if(this.isElementPresent(object)) 
					break;
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		log.info("wait for Xpath element present is reached");
	}

	public void SwitchToWindow(int index) throws Exception {	
		try{
			driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
		} catch(Exception e){
			
		}
	}

	public void SwitchToFrame(String object) throws Exception {
			try{
			driver.switchTo().frame(object);
		}catch(Exception e){
			
		}

	}	

	public void MaximizeWindow() {
		((JavascriptExecutor)driver).executeScript("if (window.screen)" +
				"{window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);};");
	}

	public void CloseAlertBox() throws InterruptedException{
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

	}

	public void GetIseleniumObject(String URL)
	{           
		try{		
		}catch (Exception e){ log.info("Cannot Perform Backed Selenium "+e);
		}
	}

	public void AutoIt(String path) throws InterruptedException, IOException {
		Thread.sleep(2000L);
		@SuppressWarnings("unused")
		Process p = Runtime.getRuntime().exec(path);
	}	

	public void AutoIt(String path, String windowname,String username, String password) throws InterruptedException, IOException {
		String[] dialog;
		Thread.sleep(3000);
		dialog =  new String[]{ path,windowname,username,password};
		Runtime.getRuntime().exec(dialog);
	}	

	public void moveMouse(By object)
	{
		try{
			WebElement mouseelement = null;
			mouseelement = driver.findElement(object);
			if(mouseelement != null)
			{
				Actions builder = new Actions(driver);
				builder.moveToElement(mouseelement).build().perform();
			}
		}catch (Exception e){
		}
	}

	public void moveMouse(WebElement element)  // Overloading Method
	{ 
		try{
			if(element != null)
			{
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
			}
		}catch (Exception e){
		}
	}

	public void selectByVisibleText(By object,String name) throws Exception {
		try{
			Select select = new Select(driver.findElement(object));
			select.selectByVisibleText(name);
			Thread.sleep(1000);
		}catch(Exception e)
		{
			
			throw e;
			
		}
		
	}

	public void selectBy(By object,String name) throws Exception {
		try{
			Select select = new Select(driver.findElement(object));
			select.selectByVisibleText(name);
			Thread.sleep(1000);
		}catch(Exception e){
			//TakeScreenshot("ERROR_TestName-"+testName+"_StepName-"+stepName+date1());
		}
	}

	
	public void selectBy(By object, int index) throws InterruptedException, IOException	{
		Thread.sleep(2000L);
		Select select = new Select(driver.findElement(object));
		select.selectByIndex(index);
	}	
	
	public void selectByValue(By object, String value ) throws Exception{
		if(driver.findElements(object).size()>0);
		
		try{
			 WebElement dropDown = driver.findElement(object);
	    dropDown.click();
	    List<WebElement> allOptions = dropDown.findElements(object);
	    for ( @SuppressWarnings("unused") WebElement we: allOptions) { 
	        dropDown.sendKeys( Keys.DOWN ); //simulate visual movement
	        Thread.sleep(2000);  
	        Select select = new Select(driver.findElement(object));
	        
	        //if ( we.getText().contains( text ) ) 
	        select.selectByVisibleText(value);
	    }
		}
		
		catch(Exception e){
			
			//TakeScreenshot("ERROR_TestName-"+testName+"_StepName-"+stepName+date1());
		}
		
	}
	
	public void selectByindexvalue(By object,int value) throws Exception {
		try{
			Select select = new Select(driver.findElement(object));
			select.selectByIndex(value);
			Thread.sleep(1000);
		}catch(Exception e)
		{
			
			throw e;
			
		}
		
	}
	
	public void selectall(By object) throws Exception {
		try{
			Select select = new Select(driver.findElement(object));
			select.getAllSelectedOptions();
			Thread.sleep(1000);
		}catch(Exception e)
		{
			
			throw e;
			
		}
		
	}
	
	public void readfromlist(By object) throws Exception {
		try{
			WebElement listbox =(driver.findElement(object));
			
			Select select = new Select(listbox);
			String Value = select.getFirstSelectedOption().getAttribute("value");
			
			System.out.println(Value);
			Thread.sleep(1000);
		}catch(Exception e)
		{
			
			throw e;
			
		}
		
	}
public void keytype(By object, Keys data) throws Exception {
		
		try{
			driver.findElement(object).sendKeys(data);
			}
		catch(Exception e)
		{
			String exp=object.toString();
			
		}
	}
	
}
