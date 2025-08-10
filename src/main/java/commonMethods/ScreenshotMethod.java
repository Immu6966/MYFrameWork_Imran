package commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotMethod {
    private WebDriver driver;
    private Actions actions;
    private static final Logger logger = LogManager.getLogger(ScreenshotMethod.class);

    // Constructor to initialize WebDriver and Actions
    public ScreenshotMethod(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        logger.info("ScreenshotMethod class initialized with WebDriver for automation framework");
    }

    /**
     * Captures a screenshot and saves it to the specified directory with a timestamp.
     * @param screenshotName Name of the screenshot file (without extension)
     * @return Path to the saved screenshot
     * @throws IOException If an error occurs while saving the file
     */
    public String takeScreenshot(String screenshotName) throws IOException {
        logger.info("Attempting to capture screenshot: {}", screenshotName);
        try {
            // Cast driver to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination path with timestamp within the project
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

            // Ensure screenshots directory exists
            File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Copy screenshot to destination
            FileUtils.copyFile(source, new File(destination));
            logger.info("Screenshot saved at: {}", destination);
            return destination;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: {}", screenshotName, e);
            throw e;
        }
    }

    /**
     * Performs a right-click on the specified web element.
     * @param element The web element to right-click on
     */
    public void rightClick(WebElement element) {
        try {
            actions.contextClick(element).build().perform();
            logger.info("Performed right-click on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to perform right-click on element: {}", element, e);
            throw e;
        }
    }

    /**
     * Performs a double-click on the specified web element.
     * @param element The web element to double-click on
     */
    public void doubleClick(WebElement element) {
        try {
            actions.doubleClick(element).build().perform();
            logger.info("Performed double-click on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to perform double-click on element: {}", element, e);
            throw e;
        }
    }

    /**
     * Performs a mouse hover over the specified web element.
     * @param element The web element to hover over
     */
    public void mouseHover(WebElement element) {
        try {
            actions.moveToElement(element).build().perform();
            logger.info("Performed mouse hover on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to perform mouse hover on element: {}", element, e);
            throw e;
        }
    }
}
