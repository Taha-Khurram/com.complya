package com.complya.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Add @FindBy WebElements and page actions here.
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[normalize-space()='Book a Demo.']")
    WebElement bookDemoBtn;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    WebElement siteLogo;

    @FindBy(xpath = "//img[@alt='banner']")
    WebElement heroImage;

    @FindBy(xpath = "//body//main//h1[1]")
    WebElement headingText;

    @FindBy(xpath = "//p[@class='mt-3']")
    WebElement paragraphText;

    @FindBy(xpath = "//p[normalize-space()='Backed by']")
    WebElement backedByText;

    @FindBy(xpath = "//img[@alt='techstars']")
    WebElement techStarsText;

    @FindBy(xpath = "//div[@class='footer-wrapper']")
    WebElement footer;

    @Step("Verify the Home Page Ui loads properly")
    public HomePage verifyUi(){
        waits.untilVisible(loginBtn);
        waits.untilVisible(bookDemoBtn);
        waits.untilVisible(siteLogo);
        waits.untilVisible(heroImage);
        waits.untilVisible(headingText);
        waits.untilVisible(paragraphText);
        waits.untilVisible(backedByText);
        waits.untilVisible(techStarsText);
        //Footer visibility
        waits.untilVisible(footer);
        String expectedUrl = "https://complya.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("complya.com"),"Expected url to contain 'complya.com' but found: " + actualUrl);
        return this;
    }

    @Step("Verify the login button is redirecting to the login page")
    public LoginPage navigateToLoginPage(){
        helper.click(loginBtn);
        String expectedUrl = "https://complya.com/app/sign-in";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("sign-in"),"Expected url to contain 'sign-in' but found: " + actualUrl);
        return new LoginPage(driver);
    }

    @Step("Verify the Book a Demo button is redirecting to the book demo page")
    public BookDemoPage navigateToDemoPage(){
        helper.click(bookDemoBtn);
        String expectedUrl = "https://calendar.google.com/calendar/u/0/appointments/schedules/AcZssZ2ZNOxZq59QlpRpfLa7olva7xhVPTUJlBwNAz8ODNvnaKSiBoXjklE0x7fk3b7ljwm-C-urQWvE";String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("calendar.google"),"Expected url to contain 'calendar.google' but found: " + actualUrl);
        return new BookDemoPage(driver);
    }


}

