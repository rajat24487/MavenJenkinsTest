package framework.pageObjects;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import framework.util.DriverUtil;

public class PageObjects extends DriverUtil {
	@FindBy(xpath="//div/div[6]/ul/li[6]/a") public static WebElement txtQualityHub;
	@FindBy(xpath="//div/div[6]/ul/li[1]/a") public static WebElement txtMenuOption1;
	@FindBy(xpath="//div/div[3]/ul/li[1]/a") public static WebElement btnEnglish;
	@FindBy(xpath="//div/div[3]/ul/li[2]/a") public static WebElement btnGerman;
	@FindBy(xpath="//div/div[6]/ul/li[1]/ul/li") public static List<WebElement> elementsServicesSubMenu;
	@FindBy(xpath="//div/div[6]/ul/li[1]/ul/li[3]/a") public static WebElement elementMobileTesting;
	@FindBy(xpath=".//*[@id='ui-id-8']") public static WebElement elementVerifyMobileTesting;
	@FindBy(xpath=".//*[@id='node-69']/div[1]/div[1]/a") public static WebElement btnMore;
	@FindBy(xpath=".//*[@id='node-220']/p[2]") public static WebElement txtContact;
	@FindBy(xpath=".//*[@id='overlay-close']/div") public static WebElement btnCloseModal;
	@FindBy(xpath="//div/div[6]/ul/li[3]/a") public static WebElement menuCareer;
	@FindBy(xpath=".//*[@id='node-57']/div[2]/h3/a") public static WebElement elementApplyNow;
	@FindBy(xpath=".//*[@id='node-21']/div[1]/div/div/h2") public static WebElement txtCareerPage;
	@FindBy(xpath=".//*[@id='edit-submitted-right-files-0-upload']") public static WebElement btnAddNewFile;
	@FindBy(xpath=".//*[@id='edit-submitted-right-files-0-upload-button']") public static WebElement btnUpload;
	@FindBy(xpath=".//*[@id='edit-submitted-right-files-0-remove-button']") public static WebElement btnRemoveFile;
	
	
	
	
	
	
		
	public static void verifyHomePage()
	{
		Assert.assertEquals("QualityHub",txtQualityHub.getText());
		Reporter.log("Home Page is displayed");
	}
	
	public static void verifyHomePageLanguage()
	{
		try{
			if (("Kompetenzen").equals(txtMenuOption1.getText()))
				Reporter.log("Website Language is German");
			else if (("Services").equals(txtMenuOption1.getText()))
				Reporter.log("Website Language is English");
		}catch(Exception e)
		{
		Reporter.log("Website Language is unknown");
		e.getMessage();
		}
	}
		
	
	public static void clickEnglish()
	{
		try{
			btnEnglish.click();
			Reporter.log("English button is clicked");
		}catch(Exception e)
		{
			Reporter.log("English button is not clicked");
			e.getMessage();
		}
	}
	public static void moveToServices()
	{
		try{
			Actions action =new Actions(driver);
			action.moveToElement(txtMenuOption1).build().perform();
		}catch(Exception e)
		{
			Reporter.log("Unable to move to element");
			e.getMessage();
		}
		
	}
	
	public static void verifySubMenu()
	{
		//System.out.println(elementsServicesSubMenu.size());
		try{
			if(elementsServicesSubMenu.size()>0)
			{		
				Reporter.log("Submenu is displayed");
			}
		}catch(Exception e)
			{
			Reporter.log("Submenu is not displayed");
			e.getMessage();
			}
	}
	public static void clickMobileTesting()
	{
		try{
			elementMobileTesting.click();
			Reporter.log("Mobile Testing link is clicked");
		}catch(Exception e)
		{
			Reporter.log("Mobile Testing link is not clicked");
			e.getMessage();
		}	
	}
	
	public static void verifyMobileTestingSection()
	{
		try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementVerifyMobileTesting);
			Thread.sleep(200);
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
			String text=elementVerifyMobileTesting.getText();
			if (text.equals("MOBILE EXPERIENCE"))
			Reporter.log("Mobile Testing section is displayed");
		}catch(Exception e)
		{
			Reporter.log("Mobile Testing section is not displayed");
			e.getMessage();
		}	
	}
	public static void clickMoreButton()
	{
		try{
			btnMore.click();
			Reporter.log("More button is clicked");
		}catch(Exception e)
		{
			Reporter.log("More button is not clicked");
			e.getMessage();
		}	
	}
	public static void extractContactInfo()
	{
		try{
			String name=txtContact.getText();
			String text1= name.substring(0, 10);
			if(text1.equalsIgnoreCase("Ron Werner"))
				Reporter.log("contact information contains " +text1);
			else
				Reporter.log("contact information does not contain " +text1);
				
			Thread.sleep(2000);
			btnCloseModal.click();
		}catch(Exception e)
		{
			Reporter.log("Contact information is not extracted");
			e.getMessage();
		}	
	}
	public static void clickCareerMenu()
	{
		try{
			menuCareer.click();
			Reporter.log("Career menu is clicked");
		}catch(Exception e)
		{
			Reporter.log("Career menu is not clicked");
			e.getMessage();
		}	
	}
	
	public static void verifyCareerPage()
	{
		Assert.assertEquals("Our employees",txtCareerPage.getText());
		Reporter.log("Career Page is displayed");
	}
	public static void clickApplyNow()
	{
		try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementApplyNow);
				Thread.sleep(200);
			 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
			 elementApplyNow.click();
			Reporter.log("Apply now is clicked");
		}catch(Exception e)
		{
			Reporter.log("Apply now is not clicked");
			e.getMessage();
		}	
	}
	public static void verifyModalOpen()
	{
		boolean b= btnCloseModal.isDisplayed();
		if(b)
			Reporter.log("Modal is opened by Apply now link");
		else
			Reporter.log("Modal is not opened by Apply now link or modal is not displayed after click on german language");
	}
	
	public static void clickAddNewFileButton()
	{
		try{
			btnAddNewFile.click();
			}catch(Exception e){
				e.getMessage();}
	}
	

	public static void clickUploadButton()
	{
		try{
			btnUpload.click();
			if(btnRemoveFile.isDisplayed())
			Reporter.log("File is uploaded successfully");
			}catch(Exception e)
		{
			Reporter.log("File is not uploaded successfully");
			e.getMessage();
		}	
	}
		
	public static void clickGerman()
	{
		try{
			btnGerman.click();
			Reporter.log("German button is clicked");
		}catch(Exception e)
		{
			Reporter.log("German button is not clicked");
			e.getMessage();
		}
	}
}
