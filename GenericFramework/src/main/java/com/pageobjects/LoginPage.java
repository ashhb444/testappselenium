package com.pageobjects;

import org.testng.Assert;

import com.pagerepository.LoginPageRepo;
import com.utilities.functionlibraries.Generic;

public class LoginPage {
	
	public boolean enterUserName(String userName) throws Exception{
		return Generic.enterValueInTextfield(LoginPageRepo.USER_NAME_FIELD_LOCATOR_TYPE, LoginPageRepo.USER_NAME_FIELD_LOCATOR_VALUE, 
				userName);
	}
	
	public boolean enterPassword(String password) throws Exception{
		return Generic.enterValueInTextfield(LoginPageRepo.PASSWORD_FIELD_LOCATOR_TYPE, LoginPageRepo.PASSWORD_FIELD_LOCATOR_VALUE, password);
	}
	
	public  void clickLoginButton() throws Exception{
		Generic.clickElement(LoginPageRepo.LOGIN_BUTTON_LOCATOR_TYPE, LoginPageRepo.LOGIN_BUTTON_LOCATOR_VALUE);
	}
	
	public void login(String userName, String password){
		
		try {
			if(this.enterUserName(userName)){
				
			}else{
				
			}
		} catch (Exception e) {
			
		}
		try {
			if(this.enterPassword(password)){
				
			}else{
				
			}
		} catch (Exception e) {
			
		}
		try {
			this.clickLoginButton();
			
		} catch (Exception e) {
			
		}
//		if(Generic.waitForElement(10, LoginPageRepo.DASHBOARD_MENU_LOCATOR_TYPE,LoginPageRepo.DASHBOARD_MENU_LOCATOR_VALUE).isDisplayed()){
//			Assert.assertEquals("Dashboard", getDashboardMenuText());
//		}
	}
	
//	public String getDashboardMenuText(){
//		return Generic.getElementText(LoginPageRepo.DASHBOARD_MENU_LOCATOR_TYPE, LoginPageRepo.DASHBOARD_MENU_LOCATOR_VALUE);
//	}
}
