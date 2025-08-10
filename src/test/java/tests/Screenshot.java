package tests;

import commonMethods.ScreenshotMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
    public static void main(String[] args) {
        // Set ChromeDriver path (or use WebDriverManager)
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe"); // Adjust path

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Initialize ScreenshotMethod utility
        ScreenshotMethod utility = new ScreenshotMethod(driver);

        try {
            // Navigate to a sample website
            driver.get("https://www.w3schools.com");
            
            driver.manage().window().maximize();

            // Take a screenshot
            String screenshotPath = utility.takeScreenshot("example_homepage");
            System.out.println("Screenshot saved at: " + screenshotPath);

            // Locate a web element
            WebElement link = driver.findElement(By.tagName("a"));

            // Perform actions
            utility.mouseHover(link);
            Thread.sleep(1000); // Pause for visibility
            utility.rightClick(link);
            Thread.sleep(1000);
            utility.doubleClick(link);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                String errorScreenshot = utility.takeScreenshot("error_state");
                System.out.println("Error screenshot saved at: " + errorScreenshot);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            driver.quit();
        }
    }
}