package framework.util;
import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class DriverUtil extends TestUtil {
	
	    public static long DEFAULT_WAIT = 20;
	    protected static WebDriver driver=null;

	    public static WebDriver getDefaultDriver() {
			if (driver != null) {
				return driver;
			}
	        DesiredCapabilities capabilities = null;
			capabilities = DesiredCapabilities.firefox();
	        capabilities.setJavascriptEnabled(true);
	        capabilities.setCapability("takesScreenshot", true);
	        driver = chooseDriver(capabilities);
	        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        return driver;
	    }

	   
	    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
			String preferredDriver = browserType;
	
			switch (preferredDriver.toLowerCase()) {
				case "chrome":
					try{
					File file = new File("lib/chromedriver.exe");
					System.setProperty("webdriver.chrome.driver",
							file.getAbsolutePath());
					DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
				    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					driver=new ChromeDriver(capabilities);
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
				return driver;
				default:
					try {
						driver = new FirefoxDriver(capabilities);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						System.exit(0);
					}
					return driver;
			}
	    }
	    public static void openWebSite()
	  		{
	  			driver.get(HOST);
	  		}
	
	    public static void openWebSiteEnglish()
  		{
  			driver.get(HOST+"/en");
  		}
	  		public static void closeDriver() {
			if (driver != null) {
				try {
					driver.close();
					driver.quit(); 
				} catch (NoSuchMethodError nsme) { // in case quit fails
				} catch (NoSuchSessionException nsse) { // in case close fails
				} catch (SessionNotCreatedException snce) {} // in case close fails
				driver = null;
			}
		}
	}
