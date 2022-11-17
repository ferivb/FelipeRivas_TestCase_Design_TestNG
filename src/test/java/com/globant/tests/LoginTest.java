package com.globant.tests;

import com.globant.pages.WatchPage;
import com.globant.reporting.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        home.clickOnUserIcon();
        home.clickOnLoginIframeLauncher();
        home.goToLoginIframe();
        Reporter.info("Testing the Login iframe");
        checkThat("ESPN login Logo is present", home.isLoginLogoVisible(), is(true));
        checkThat("Login button is present", home.isLoginButtonVisible(), is(true));
        checkThat("Sing up button is present", home.isSingUpButtonVisible(), is(true));
        home.enterEmail("12345@fakemail.com");
        home.enterPassword("Abc123456");
        home.clickOnLoginSubmit();
        home.exitIframe();
        WatchPage watch = home.goToWatchPage();
        Reporter.info("Testing the Watch page");
        checkThat("There is at least one carousel with title and description on every card", watch.secondCarouselIsNotEmpty(), is(true));watch.secondCarouselIsNotEmpty();
        watch.clickOnCardByIndex(1);
        watch.waitForCardPopUp();
        Reporter.info("Testing the second card from the first carousel");
        checkThat("X button to exit card is present", watch.confirmCloseButtonExist(), is(true));
        watch.closeCard();
        home = watch.goBackHome();
        home.hoverOverProfileButton();
        home.waitForWelcomeMessage();
        Reporter.info("Testing the Welcome bar");
        checkThat("the user name is showing", home.isCustomNameShowing(), is(true));
        home.clickOnUserIcon();
        Reporter.info("Logging Out");
        home.clickOnLogout();
        home.refreshHomePage();
        home.clickOnUserIcon();
        home.waitForWelcomeMessage();
        Reporter.info("Testing if logout was successful");
        checkThat("The user name is no longer showing", home.isCustomNameShowing(), is(false));
    }
}
