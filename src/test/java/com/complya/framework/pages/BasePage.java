package com.complya.framework.pages;

import com.complya.framework.driver.DriverManager;
import com.complya.framework.utils.Helper;
import com.complya.framework.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final Waits waits;
    protected final Helper helper;

    protected BasePage() {
        this(DriverManager.getDriver());
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
        this.helper = new Helper(driver);
        PageFactory.initElements(driver, this);
    }
}
