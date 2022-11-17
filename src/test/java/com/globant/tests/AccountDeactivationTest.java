package com.globant.tests;

import com.globant.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class AccountDeactivationTest extends BaseTest {

    @Parameters({"email", "password"})
    @BeforeMethod
    public void login(String email, String password){
        home.waitForUserIconButton();
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(email);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.exitIframe();
    }

    @Parameters({"email", "password"})
    @Test
    public void accountDeactivationTest(String email, String password){
        home.waitForUserIconButton();
        home.clickOnUserIcon();
        home.clickOnModifyAccount();
        home.goToModifyAccountIframe();
        checkThat("Logo is present in the modify account iframe", home.isIframeLogoVisible(), is(true));
        home.scrollToDeleteLink();
        home.clickOnDeleteAccountLink();
        Reporter.info("Clicked on account delete");
        home.waitForCancelDeletionButton();
        checkThat("Delete confirmation button is visible", home.isDeleteConfirmationButtonVisible(), is(true));
        home.clickConfirmDeleteAccount();
        home.waitForIfThisIsAnErrorText();
        home.clickFinalDeleteDisclosure();
        home.exitIframe();
        home.refreshHomePage();
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(email);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.waitForAccountDeactivatedTextBlock();
        checkThat("account deactivated message appears", home.isAccountDeactivated(), is(true));
        home.clickCloseAccountDeactivatedPopUp();
        home.exitIframe();
    }
}
