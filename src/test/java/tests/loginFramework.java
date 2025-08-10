package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.LoginPage;
import pages.DashBoard;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class loginFramework {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoard dashboardPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashBoard(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUsername("shaik3305@gmail.com");
        loginPage.enterPassword("Iamimran@6966");
        loginPage.clickLogin();

        String welcomeText = dashboardPage.getWelcomeMessage();
        assertTrue(welcomeText.contains("Welcome, valid_user!"), "Welcome message is incorrect");

        dashboardPage.clickLogout();
    }

    @Test
    public void testFailedLogin() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Invalid credentials", "Error message is incorrect");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}