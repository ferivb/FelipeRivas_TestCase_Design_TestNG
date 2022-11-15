package com.globant.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        home.clickOnProfileManager();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail("1234@fakemail.com");
        home.enterPassword("Abc123456");
        home.clickOnLoginSubmit();
    }
}
