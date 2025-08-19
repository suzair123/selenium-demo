package com.example.selenium.tests;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.DashboardPage;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // similar to Playwright's beforeAll
public class LoginTest {

    private WebDriver driver;
    private DashboardPage dashboardPage;

    @BeforeAll
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new"); // enable for CI
        driver = new ChromeDriver(options);

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        // Open and login once before all tests
        loginPage.open();
        loginPage.login("Admin", "admin123");
    }

    @Test
    void successfulLoginShowsDashboard() {
        assertTrue(dashboardPage.isDashboardVisible(), "Dashboard should be visible after login");
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
