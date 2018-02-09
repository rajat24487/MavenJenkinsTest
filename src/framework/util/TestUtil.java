package framework.util;


import java.io.FileInputStream;

import java.util.Properties;

/**
 * This class  has methods for loading properties file.
  */
public class TestUtil  {

	public static Properties properties;
	protected static String HOST = "";
	protected static String browserType = "";
	protected static Properties configProp = null;
	protected static String configPropFile = "config.properties";
	protected static Boolean debugFlag =false;
	
	protected static final String HOST_PropKey = "host";
	protected static final String browserType_PropKey = "browserType";
	
	static {
		configProp = new Properties();

		try {
				String propFilePath = null;
				
				propFilePath = "resources/" + configPropFile;
				
				configProp.load(new FileInputStream(propFilePath));
				HOST = configProp.getProperty(HOST_PropKey);
				browserType = configProp.getProperty(browserType_PropKey);
			
				} catch (Exception e) {
			System.out.println("Fatal error:"+ e.getMessage() );
						}
	}	
	/** Constructor */
	public TestUtil() {
		
	}

}

