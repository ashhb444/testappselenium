package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.functionlibraries.Generic;

public class TestBaseSetUp {

	private WebDriver webDriver;
	
	@Parameters({"browserName","applicationURL"})
	@BeforeClass
	public void initializeBaseSetUp(String browserName, String applicationURL) {
		
		webDriver=Generic.initializeDriver(browserName);
		Generic.navigateToURL(applicationURL);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
}
