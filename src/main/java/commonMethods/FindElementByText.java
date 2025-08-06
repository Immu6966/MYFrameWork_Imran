package commonMethods;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CreateDriverObject;
import utils.PropertyFileReader;

import java.io.IOException;
import java.time.Duration;

public class FindElementByText {
  static  private WebDriver driver;
static Logger log = LogManager.getLogger(FindElementByText.class.getName());
  
   

	public static void main(String[] args) throws IOException {
		findElementByText("apache-log4j-2.25.1-src.zip");
		
	}	
	

		public static WebElement findElementByText(String text) throws IOException {
			String url = PropertyFileReader.getKeyValue("url");
			WebElement element = null;
	        try {
	            driver = CreateDriverObject.getDriver();		
	            driver.get(url);
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	           
	            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + text + "']")));
	            log.info("Element found with text: " + text);
	            
	            
	        } catch (Exception e) {
	            System.out.println("Could not find element with text: " + text);
	            
	        }
	        driver.close();
			return element;
		}
	}