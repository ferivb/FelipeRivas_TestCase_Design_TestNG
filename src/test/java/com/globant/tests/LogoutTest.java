package com.globant.tests;

import com.globant.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class LogoutTest extends BaseTest {

    @Parameters({"email", "password"})
    @BeforeMethod
    public void login(String email, String password){
        home.waitForUserIconButton();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(email);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.exitIframe();
    }

    @Test
    public void logoutTest(){
        home.waitForUserIconButton();
        home.clickOnUserIcon();
        Reporter.info("Beginning the Logout Test Case");
        home.clickOnLogout();
        home.refreshHomePage();
        home.clickOnUserIcon();
        home.waitForWelcomeMessage();
        Reporter.info("Testing if logout was successful");
        checkThat("The user name is no longer showing", home.isCustomNameShowing(), is(false));
    }
}
