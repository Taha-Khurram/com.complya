package com.complya.framework.pages;

import com.complya.framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPage extends BasePage{

    public LoginPage() { super(); }

    public LoginPage(WebDriver driver){
        super(driver);
    }



}
