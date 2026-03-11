package com.complya.tests;

import com.complya.framework.base.BaseTest;
import com.complya.framework.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void smoke_titleIsNotNull() {
        Assert.assertNotNull(DriverManager.getDriver().getTitle(), "Page title should not be null");
    }
}

