package com.utilities.factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utilities.constants.EnvironmentConstants;

public class BrowserFactory {

	private static Map<String,WebDriver> webDrivers= new HashMap<String, WebDriver>();
	
	public static WebDriver initializeDriver(String browserName){
		
		WebDriver webDriver = null;
		switch(browserName){
		case "firefox":
			webDriver = webDrivers.get("firefox");
			if(webDriver==null){
				webDriver = new FirefoxDriver();
				webDrivers.put("firefox", webDriver);
			}
			break;
		case "chrome":
			webDriver = webDrivers.get("chrome");
			if(webDriver==null){
				System.setProperty(EnvironmentConstants.CHROME_DRIVER_KEY, EnvironmentConstants.CHROME_DRIVER_PATH);
				webDriver = new ChromeDriver();
			}
			break;
		case "IE":
			webDriver = webDrivers.get("IE");
			if(webDriver==null){
				System.setProperty(EnvironmentConstants.IE_DRIVER_KEY, EnvironmentConstants.IE_DRIVER_PATH);
				webDriver = new InternetExplorerDriver();
			}
			break;
		}
		return webDriver;
	}
	
	public static void closeAllDrivers(){
		
		for(String key : webDrivers.keySet()){
			if(webDrivers.get(key)!=null){
				webDrivers.get(key).close();
				webDrivers.get(key).quit();
			}
		}
	}
}
