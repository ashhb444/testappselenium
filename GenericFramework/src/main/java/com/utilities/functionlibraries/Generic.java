package com.utilities.functionlibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.factory.BrowserFactory;

public class Generic {

	private static WebDriver webDriver;
	
	public static WebDriver initializeDriver(String browserName){
		webDriver = BrowserFactory.initializeDriver(browserName);
		return webDriver;
	}
	
	public static void navigateToURL(String applicationURL){
		webDriver.get(applicationURL);
		webDriver.manage().window().maximize();
	}
	
	public static void closeDriver(WebDriver webDriver){
		webDriver.close();
	}
	
	public static WebElement getWebElement(String locatorType, String locatorValue){
		
		WebElement webElement = null;
		switch(locatorType){
		case "id":
			webElement = webDriver.findElement(By.id(locatorValue));
			break;
		case "name":
			webElement = webDriver.findElement(By.name(locatorValue));
			break;
		case "xpath":
			webElement = webDriver.findElement(By.xpath(locatorValue));
			break;
		case "tagName":
			webElement = webDriver.findElement(By.tagName(locatorValue));
			break;
		case "className":
			webElement = webDriver.findElement(By.className(locatorValue));
			break;
		case "cssSelector":
			webElement = webDriver.findElement(By.cssSelector(locatorValue));
			break;
		case "linkText":
			webElement = webDriver.findElement(By.linkText(locatorValue));
			break;
		case "partialLinkText":
			webElement = webDriver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		return webElement;
	}
	
	public static WebElement waitForElement(long time, String locatorType, String locatorValue){
		
		WebElement webElement=null;
		WebDriverWait wait = new WebDriverWait(webDriver, time);
		switch(locatorType){
		case "id":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			break;
		case "name":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			break;
		case "xpath":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			break;
		case "tagName":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			break;
		case "className":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			break;
		case "cssSelector":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "linkText":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			break;
		case "partialLinkText":
			webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		}
		return webElement;
	}
	
	public static boolean validateElement(WebElement webElement) {
		return webElement!=null && webElement.isDisplayed() && webElement.isEnabled();
	}
	
	public static void clickElement(String locatorType, String locatorValue) throws Exception{
		
		WebElement webElement = getWebElement(locatorType, locatorValue);
		if(validateElement(webElement)){
			webElement.click();
		}else{
			throw new Exception("Exception on clicking web element: " + "Type: "+locatorType +" Value: " + locatorValue);
		}
	}
	
	public static boolean enterValueInTextfield(String locatorType, String locatorValue, String inputFieldValue) throws Exception{
		
		WebElement webElement = getWebElement(locatorType, locatorValue);
		if(validateElement(webElement)){
			webElement.sendKeys(inputFieldValue);
			if(webElement.getAttribute("value").equals(inputFieldValue)){
				return true;
			}else{
				return false;
			}
		} else{
			throw new Exception("Exception on inserting value in web element" + "Type: "+locatorType +" Value: " + locatorValue);
		}
	}
	
	public static String getElementText(String locatorType, String locatorValue){
		
		String elementText = null;
		WebElement webElement = getWebElement(locatorType, locatorValue);
		if(webElement!=null && webElement.isDisplayed()){
			elementText=webElement.getText();
		}
		return elementText;
	}
}
