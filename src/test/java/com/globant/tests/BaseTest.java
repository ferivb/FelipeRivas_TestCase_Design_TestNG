package com.globant.tests;

import com.globant.configuration.Driver;
import com.globant.pages.HomePage;
import com.globant.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static java.lang.String.format;
import java.util.Random;

public class BaseTest {

    private Driver driver;
    protected HomePage home;
    protected static String user = "fake";
    protected static String password = "Abc123456";

    @Parameters({"browser", "url"})
    @BeforeTest
    public void createAccount(String browser, String url){
        randomizeEmail();
        testSetUp(browser, url);
        Reporter.info("Creating testing account");
        home.waitForUserIconButton();
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.clickOnCreateAccount();
        home.enterFirstName("Test");
        home.enterLastName("Account");
        home.enterRegistrationEmail(user);
        home.enterRegistrationPassword(password);
        home.scrollToRegisterButton();
        home.clickOnRegister();
        home.waitIframeInvisibility();
        home.exitIframe();
        tearDown();
    }

    public void randomizeEmail(){
        Random random = new Random();
        int randomizer = random.nextInt(99999);
        randomizer += 10;
        user = user + randomizer + "@fakemail.com";
    }

    @Parameters({"browser", "url"})
    @BeforeClass
    public void testSetUp(String browser, String url){
        driver = new Driver(browser);
        Reporter.info("Deleting all Cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        home = new HomePage(driver.getDriver());

    }

    @AfterClass
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
