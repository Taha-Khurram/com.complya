package com.complya.framework.base;

import com.complya.framework.config.ConfigReader;
import com.complya.framework.driver.BrowserFactory;
import com.complya.framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = BrowserFactory.createDriver();
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();

        // Optional: open baseUrl by default for UI tests.
        String baseUrl = ConfigReader.get("baseUrl", "");
        if (!baseUrl.isBlank()) {
            driver.get(baseUrl);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

