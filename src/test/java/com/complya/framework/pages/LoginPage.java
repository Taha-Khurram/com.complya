package com.complya.framework.pages;

import com.complya.framework.driver.DriverManager;
import io.qameta.allure.Step;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LoginPage extends BasePage{

    public LoginPage() { super(); }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h4[@class='semibold']")
    WebElement welcomeText;

    @FindBy(xpath = "//strong[@class='strong grey']")
    WebElement welcomeParagraph;

    @FindBy(xpath = "//button[normalize-space()='Sign in with Google']")
    WebElement googleBtn;

    @FindBy(xpath = "//input[@placeholder='Enter your email address']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='rememberMe']")
    WebElement rememberMeCheckbox;

    @FindBy(xpath = "//a[normalize-space()='Forget password']")
    WebElement forgetPasswordLnk;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    WebElement signUpLnk;

    @FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
    WebElement privacyPolicyLnk;

    @FindBy(xpath = "//a[normalize-space()='Support']")
    WebElement supportLnk;

    @FindBy(xpath = "//div[normalize-space()='Sign Out']")
    WebElement signOutLnk;

    @FindBy(xpath = "//div[contains(text(),'Sign-in successful!')]")
    WebElement validLoginMsg;

    @FindBy(xpath = "//div[contains(text(),'Invalid email or password. Please try again.')]")
    WebElement invalidLoginMsg;

    @FindBy(xpath = "//span[normalize-space()='Email is required']")
    WebElement emptyEmailMsg;

    @FindBy(xpath = "//span[normalize-space()='Password is required']")
    WebElement emptyPasswordMsg;


    @Step("Verify the Login page UI loads properly")
    public LoginPage verifyUI(){
        waits.untilVisible(welcomeText);
        waits.untilVisible(welcomeParagraph);
        waits.untilVisible(googleBtn);
        waits.untilVisible(emailField);
        waits.untilVisible(passwordField);
        waits.untilVisible(rememberMeCheckbox);
        waits.untilVisible(forgetPasswordLnk);
        waits.untilVisible(signInBtn);
        waits.untilVisible(signUpLnk);
        waits.untilVisible(privacyPolicyLnk);
        waits.untilVisible(supportLnk);
        waits.untilVisible(signUpLnk);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("sign-in"),"Expected url to contain 'sign-in' but found: " + actualUrl);
        return this;
    }

    @Step("Method for valid login")
    public DashboardPage validLoginUser(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        helper.click(rememberMeCheckbox);
        helper.click(signInBtn);
        waits.untilVisible(validLoginMsg);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("app"),"Expected url to contain 'app' but found: " + actualUrl);
        return new DashboardPage(driver);
    }


    @Step("Method for invalid login")
    public LoginPage invalidLoginUser(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        helper.click(rememberMeCheckbox);
        helper.click(signInBtn);
        waits.untilVisible(invalidLoginMsg);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("sign-in"),"Expected url to contain 'sign-in' but found: " + actualUrl);
        return this;
    }

    @Step("Method for the empty login")
    public LoginPage emptyLoginUser(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        helper.click(rememberMeCheckbox);
        helper.click(signInBtn);
        waits.untilVisible(emptyEmailMsg);
        waits.untilVisible(emptyPasswordMsg);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("sign-in"),"Expected url to contain 'sign-in' but found: " + actualUrl);
        return this;
    }


}
