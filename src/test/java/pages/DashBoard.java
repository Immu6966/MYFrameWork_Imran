package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashBoard {
    private WebDriverWait wait;

    // Locators
    private final By welcomeMessage = By.className("welcome-text");
    private final By logoutButton = By.id("logout-btn");

    public DashBoard(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).getText();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}