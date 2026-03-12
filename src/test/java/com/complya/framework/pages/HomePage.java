package com.complya.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Page Object for Complya Home Page.
 * Updated to use robust relative XPaths based on the latest site structure.
 */
public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // --- Authentication & Lead Gen ---
    @FindBy(xpath = "//a[contains(@href, '/app/') and text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class, 'hero-buttons')]//a[text()='Try for free']")
    private WebElement tryForFreeBtn;

    @FindBy(xpath = "//nav//button[contains(text(), 'Get a demo')]")
    private WebElement getADemoNavBtn;

    // --- Branding & Content ---
    @FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
    private WebElement siteLogo;

    @FindBy(xpath = "//div[contains(@class, 'banner-content')]//h1")
    private WebElement mainHeading;

    @FindBy(xpath = "//div[contains(@class, 'banner-content')]//p")
    private WebElement heroDescription;

    // --- Sections ---
    @FindBy(xpath = "//section[contains(@class, 'pricing-section')]")
    private WebElement pricingSection;

    @FindBy(xpath = "//footer[contains(@class, 'footer-main-wrapper')]")
    private WebElement footer;

    @Step("Verify the Home Page UI loads properly")
    public HomePage verifyUi() {
        waits.untilVisible(siteLogo);
        waits.untilVisible(loginBtn);
        waits.untilVisible(getADemoNavBtn);
        waits.untilVisible(mainHeading);
        waits.untilVisible(heroDescription);
        waits.untilVisible(pricingSection);
        waits.untilVisible(footer);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("complya.com"),
                "Expected url to contain 'complya.com' but found: " + actualUrl);

        Assert.assertTrue(mainHeading.getText().contains("Modern"),
                "Heading text mismatch. Found: " + mainHeading.getText());
        return this;
    }

    @Step("Verify the login button redirects to the application sign-in page")
    public LoginPage navigateToLoginPage() {
        helper.click(loginBtn);
        // The URL redirects to the /app/ context
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("app"),
                "Expected URL to contain 'app' after clicking login, but found: " + actualUrl);
        return new LoginPage(driver);
    }

    @Step("Click 'Get a demo' in the navigation bar and verify redirection to calendar")
    public void clickGetADemo() {
        helper.click(getADemoNavBtn);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("calendar.google"), "Expected url to contain 'calendar.google' but found: " + actualUrl);
    }
}