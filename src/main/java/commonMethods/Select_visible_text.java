package commonMethods;
import org.apache.logging.log4j.LogManager;
//TODO
		import org.apache.logging.log4j.Logger;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class Select_visible_text {

	static Logger log = LogManager.getLogger(FindElementByText.class.getName());

		    public static void main(String[] args) throws IOException, SQLException {
		        // Get the driver instance
		        WebDriver driver = (WebDriver) DriverManager.getDriver(null);
 
		        driver.switchTo().frame("iframeResult");

		        // Example usage
		        WebElement element = driver.findElement(By.id("cars"));
		        System.out.println("Found element: " + element.getTagName());

		        // Close the driver
		        
		    }

		    public static WebElement findElementByText(String text) throws IOException, SQLException {
		        WebDriver driver = (WebDriver) DriverManager.getDriver(text);
		        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
		        return element;
		    }
		

}


