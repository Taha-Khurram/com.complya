package com.complya.tests;

import com.complya.framework.base.BaseTest;
import com.complya.framework.driver.DriverManager;
import com.complya.framework.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    private LoginPage login;

    @BeforeMethod
    public void initPages(){
        login = new LoginPage(DriverManager.getDriver());
    }


    @Feature("Verify Login Page UI")
    @Story("Test to verify that the components of the login Page loads properly")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Verify that the all critical components are visible on the login page")
    public void testVerifyUiLoadsProperly(){
        login.verifyUI();
        System.out.println("Login page UI loads properly");
    }

    @Feature("Verify Valid Login Functionality")
    @Story("Test to verify that the login functionality is working")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "Verify that valid user can log in")
    public void testValidUserLogin(){
        login.validLoginUser("m.tahaofficial007@gmail.com","comply@123");
        System.out.println("Login Successful");
    }

    @Feature("Verify Invalid Login Functionality")
    @Story("Test to verify that the invalid user cannot login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "Verify that invalid user can't log in")
    public void testInvalidUserLogin(){
        login.invalidLoginUser("m.tah007@gmail.com","com123");
        System.out.println("Invalid username or password");
    }






}
