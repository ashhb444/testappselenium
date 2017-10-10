package com.testscripts.pageobjects.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.pageobjects.LoginPage;
import com.testscripts.TestBaseSetUp;
import com.utilities.functionlibraries.Generic;

public class LoginPageTest extends TestBaseSetUp{

	@Test(testName="Login")
	public void testLogin(){
		new LoginPage().login("admin", "admin");
	}
	
	@AfterSuite
	public void afterClass() {
		//Generic.closeDriver(getWebDriver());
	}
}
