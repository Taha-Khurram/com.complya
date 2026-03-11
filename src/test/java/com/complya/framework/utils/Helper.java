package com.complya.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
    private final Waits waits;

    public Helper(WebDriver driver) {
        this.waits = new Waits(driver);
    }

    // Add your reusable helper actions here (click/type/select/assert/etc).
    public void click(WebElement element) {
        waits.untilClickable(element).click();
    }
}
