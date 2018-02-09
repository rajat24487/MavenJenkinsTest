package framework.Tests;

import org.testng.annotations.Test;

import framework.pageObjects.PageObjects;
import framework.util.DriverUtil;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TestScenarios2 extends DriverUtil {
	@BeforeMethod
	public void beforeMethod() {
		//Open Chrome Browser
	  	DriverUtil.getDefaultDriver();
	  	//Open Website in English language
		DriverUtil.openWebSiteEnglish();
	}	
	@Test
	public void verifyContactInformationTest() throws InterruptedException {
	  	PageFactory.initElements(driver, PageObjects.class);
	  	//Verify Home Page language
	  	PageObjects.verifyHomePageLanguage();
		// Move to Services Menu
	  	PageObjects.moveToServices();
		//Verify SubMenu displayed or not
	  	PageObjects.verifySubMenu();
		Thread.sleep(200);
		//click on Mobile Testing Link
		PageObjects.clickMobileTesting();
		//Verify Mobile Testing Section
		PageObjects.verifyMobileTestingSection();
		//Click on More button
		Thread.sleep(500);
		PageObjects.clickMoreButton();
		//Extract contact information and close modal
		Thread.sleep(1000);
		PageObjects.extractContactInfo();
	}
	@AfterMethod
	public void afterMethod() {
		//close connection
	 	DriverUtil.closeDriver();
	}
}
