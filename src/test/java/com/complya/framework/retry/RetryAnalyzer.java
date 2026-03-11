package com.complya.framework.retry;

import com.complya.framework.config.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private final int maxRetries = ConfigReader.getInt("retry.count", 0);

    @Override
    public boolean retry(ITestResult result) {
        if (maxRetries <= 0) {
            return false;
        }
        if (retryCount < maxRetries) {
            retryCount++;
            return true;
        }
        return false;
    }
}

