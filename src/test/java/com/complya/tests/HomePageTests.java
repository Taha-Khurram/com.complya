package com.complya.tests;

import com.complya.framework.base.BaseTest;
import com.complya.framework.driver.DriverManager;
import com.complya.framework.pages.HomePage;
import com.complya.framework.pages.LoginPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    private HomePage home;

    @BeforeMethod
    public void initPage(){
        home = new HomePage(DriverManager.getDriver());
    }

    @Feature("Verify Home Page UI")
    @Story("Test to verify that the components of the Home Page loads properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that the all critical components are visible on the Home page")
    public void testVerifyUiLoadsProperly(){
        home.verifyUi();
    }

    @Feature("Verify Login Button Redirection")
    @Story("Test to verify that the login button redirects to the login page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that the login button navigates to the login page")
    public void testLoginButtonRedirection(){
        home.verifyUi();
        home.navigateToLoginPage();
    }


    @Feature("Verify Demo Button Redirection")
    @Story("Test to verify that the demo button redirects to the book a demo page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that the demo button navigates to the book demo page")
    public void testDemoButtonRedirection(){
        home.verifyUi();
        home.navigateToDemoPage();
    }






}

