package com.globant.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.globant.reporting.Reporter;

public class Listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result){
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
