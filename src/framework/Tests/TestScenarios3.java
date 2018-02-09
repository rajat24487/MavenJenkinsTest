package framework.Tests;

import org.testng.annotations.Test;
import framework.pageObjects.PageObjects;
import framework.util.DriverUtil;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TestScenarios3 extends DriverUtil {
	@BeforeMethod
	public void beforeMethod() {
		//Open Chrome Browser
	  	DriverUtil.getDefaultDriver();
	  	//Open Website in English language
		DriverUtil.openWebSiteEnglish();
	}	
	@Test
	public void verifyFileUploadTest() throws InterruptedException, IOException {
	  	PageFactory.initElements(driver, PageObjects.class);
	  	//Verify Home Page language
	  	PageObjects.verifyHomePageLanguage();
		//Click on Career menu
	  	PageObjects.clickCareerMenu();
	  	//verify career page
	  	PageObjects.verifyCareerPage();
		//Click Apply now
	  	PageObjects.clickApplyNow();
	  	//verify Modal is opened
	  	Thread.sleep(2000);
	  	PageObjects.verifyModalOpen();
	  	//Click Add new file button
	  	PageObjects.btnAddNewFile.click();
	  	Thread.sleep(5000);
	  	//Execute AutoIT Script to upload file
		Runtime.getRuntime().exec("Scripts/fileupload.exe");
		Thread.sleep(10000);
		//click upload button
		PageObjects.clickUploadButton();
	   // click on German language button
		PageObjects.clickGerman();
	  //verify Modal is opened
	  	PageObjects.verifyModalOpen();
	  	//Check Language is German
		PageObjects.verifyHomePageLanguage();	
	}
	@AfterMethod
	public void afterMethod() {
		//close connection
	 	DriverUtil.closeDriver();
	}
}
