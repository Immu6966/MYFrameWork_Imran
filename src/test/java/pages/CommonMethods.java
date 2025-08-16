package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class CommonMethods{
	WebDriver driver;
	
	public CommonMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	

	
	
	public void getSwtichToFrameByWebElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	
	}
	
	


