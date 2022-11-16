package com.globant.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        home.clickOnProfileManager();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        checkThat("ESPN login Logo is present", home.isLoginLogoVisible(), is(true));
        checkThat("Login button is present", home.isLoginButtonVisible(), is(true));
        checkThat("Sing up button is present", home.isSingUpButtonVisible(), is(true));
        home.enterEmail("1234@fakemail.com");
        home.enterPassword("Abc123456");
        home.clickOnLoginSubmit();
        home.exitIframe();
    }
}
