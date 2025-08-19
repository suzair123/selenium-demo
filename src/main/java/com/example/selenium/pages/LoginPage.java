package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10s timeout
    }

    // Open login page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Perform login
    public void login(String username, String password) {
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        userInput.sendKeys(username);

        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
