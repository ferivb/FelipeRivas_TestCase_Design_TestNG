package com.globant.tests;

import com.globant.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void login(){
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail("123456@fakemail.com");
        home.enterPassword("Abc123456");
        home.clickOnLoginSubmit();
        home.exitIframe();
    }

    @Test
    public void logoutTest(){
        home.clickOnUserIcon();
        Reporter.info("Beginning the Login Test Case");
        home.clickOnLogout();
        home.refreshHomePage();
        home.clickOnUserIcon();
        home.waitForWelcomeMessage();
        Reporter.info("Testing if logout was successful");
        checkThat("The user name is no longer showing", home.isCustomNameShowing(), is(false));
    }
}
