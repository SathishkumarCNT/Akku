package com.app.akku.work.common;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadfromProperties {

	public String getConfigProperty(String object) throws Exception
	{		
		FileInputStream fs = new FileInputStream("..//App_Akku_Work//src//test//resources//Properties//config.properties");		
		Properties config= new Properties();													
		config.load(fs);	
		return config.getProperty(object);
		
	}
	
	public String getAppProperty(String object) throws Exception
	{
		FileInputStream fs = new FileInputStream("..//App_Akku_Work//src//test//resources//Properties//app.properties");		
		Properties app= new Properties();													
		app.load(fs);	
		return app.getProperty(object);
		
	}	
}
