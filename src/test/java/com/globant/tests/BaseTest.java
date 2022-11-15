package com.globant.tests;

import com.globant.configuration.Driver;
import com.globant.pages.HomePage;
import com.globant.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static java.lang.String.format;

public class BaseTest {

    private Driver driver;
    protected HomePage home;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void testSetUp(String browser, String url){
        driver = new Driver(browser);
        Reporter.info("Deleting all Cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        home = new HomePage(driver.getDriver());

    }

    @AfterTest
    public void tearDown() {
        driver.getDriver().quit();
    }

    protected <T> void checkThat(
            String description, T actualValue, Matcher<? super T> expectedValue){
        Reporter.info(
                format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e){
            Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }
}
