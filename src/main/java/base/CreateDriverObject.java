package base;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonMethods.FindElementByText;
import utils.PropertyFileReader;


public class CreateDriverObject {
	static Logger log = LogManager.getLogger(FindElementByText.class.getName());
	static WebDriver driver ;
	
	public static WebDriver getDriver() throws IOException {
		try 
		{
		String browserType =PropertyFileReader.getKeyValue("browser");

		if(browserType.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserType.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();			
		}



		else if(browserType.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			log.info("Please enter only Chrome or edge or Firefox for browseType");
			
		}
		
		driver.manage().window().maximize();
		}
		catch(Exception e) {
			
			log.info("Exception occured while intializing webdriver:"+e.getMessage());
		}
		return driver;
		
		
	}
		

	}