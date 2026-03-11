package com.complya.framework.utils;

import com.complya.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriverWait wait;

    public Waits(WebDriver driver) {
        int timeoutSeconds = ConfigReader.getInt("explicitWaitSeconds", 15);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    // Use WebElement-based waits as requested; add more methods as needed.
    public WebElement untilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement untilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean untilInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
