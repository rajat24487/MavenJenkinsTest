package framework.Tests;

import org.testng.annotations.Test;

import framework.pageObjects.PageObjects;
import framework.util.DriverUtil;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TestScenarios1 extends DriverUtil {
	@BeforeMethod
	public void beforeMethod() {
		//Open Chrome Browser
	  	DriverUtil.getDefaultDriver();
	  //Open Website in German language
		DriverUtil.openWebSite();
	}	
	@Test
	public void verifyEnglishLanguageTest() {
	  	PageFactory.initElements(driver, PageObjects.class);
	  //Verify Home Page
	  	PageObjects.verifyHomePage();
		//Verify Home Page language
		PageObjects.verifyHomePageLanguage();
		//Click on English button
		PageObjects.clickEnglish();
		//Verify Home Page language
		PageObjects.verifyHomePageLanguage();
	}
	@AfterMethod
	public void afterMethod() {
		//close connection
	  	DriverUtil.closeDriver();
	}
}
