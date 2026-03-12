package com.complya.tests;

import com.complya.framework.base.BaseTest;
import com.complya.framework.driver.DriverManager;
import com.complya.framework.pages.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Complya Home Page functionality.
 * Adjusted to match the methods defined in the HomePage Page Object.
 */
public class HomePageTests extends BaseTest {

    private HomePage home;

    @BeforeMethod
    public void initPage(){
        home = new HomePage(DriverManager.getDriver());
    }

    @Feature("Verify Home Page UI")
    @Story("Test to verify that the components of the Home Page loads properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Verify that all critical components are visible on the Home page")
    public void testVerifyUiLoadsProperly(){
        home.verifyUi();
        System.out.println("Home page UI loads properly");
    }

    @Feature("Verify Login Button Redirection")
    @Story("Test to verify that the login button redirects to the login page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "Verify that the login button navigates to the login page")
    public void testLoginButtonRedirection(){
        home.verifyUi();
        home.navigateToLoginPage();
        System.out.println("Navigated to the Login page");
    }

    @Feature("Verify Demo Button Redirection")
    @Story("Test to verify that the demo button redirects to the book a demo page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "Verify that the demo button navigates to the Google Calendar booking page")
    public void testDemoButtonRedirection(){
        home.verifyUi();
        // Updated to match the method name 'clickGetADemo' in the HomePage class
        home.clickGetADemo();
        System.out.println("Navigated to the Get Demo Page");
    }
}