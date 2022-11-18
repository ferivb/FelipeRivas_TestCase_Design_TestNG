package com.globant.tests;

import com.globant.reporting.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class AccountDeactivationTest extends BaseTest {

    @BeforeMethod
    public void login(){
        home.waitForUserIconButton();
        home.closePromoBanner();
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        home.enterEmail(user);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.exitIframe();
    }

    @Test
    public void accountDeactivationTest(){
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
        home.enterEmail(user);
        home.enterPassword(password);
        home.clickOnLoginSubmit();
        home.waitForAccountDeactivatedTextBlock();
        checkThat("account deactivated message appears", home.isAccountDeactivated(), is(true));
        home.clickCloseAccountDeactivatedPopUp();
        home.exitIframe();
    }
}
