package com.globant.tests;

import com.globant.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class AccountDeactivationTest extends BaseTest {

    private String email = "1234567@fakemail.com";
    private String password = "Abc123456";

    @BeforeMethod
    public void login(){
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(email);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.exitIframe();
    }

    @Test
    public void accountDeactivationTest(){
        home.clickOnUserIcon();
        home.clickOnModifyAccount();
        home.goToModifyAccountIframe();
        checkThat("Logo is present in the modify account iframe", home.isIframeLogoVisible(), is(true));
        home.scrollToDeleteLink();
        home.clickOnDeleteAccountLink();
        Reporter.info("Clicked on account delete");
//        home.goToDeletionConfirmIframe();
        checkThat("Delete confirmation button is visible", home.isDeleteConfirmationButtonVisible(), is(true));
        home.clickConfirmDeleteAccount();
        home.clickFinalDeleteDisclosure();
//        checkThat("Green checkmark appears", home.validateGreenCheckmark(), is(true));
        home.exitIframe();
        home.refreshHomePage();
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(email);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        checkThat("account deactivated message appears", home.isAccountDeactivated(), is(true));
        home.exitIframe();
    }
}
