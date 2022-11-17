package com.globant.pages;

import com.globant.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.String.format;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = "li a[tref=\"/members/v3_1/login\"]")
    private WebElement loginIframeLauncher;

    @FindBy(id = "InputLoginValue")
    private WebElement loginNameField;

    @FindBy(id = "InputPassword")
    private WebElement loginPasswordField;

    @FindBy(id = "BtnSubmit")
    private WebElement loginSubmitButton;

    @FindBy(id = "logo")
    private WebElement iframeESPNLogo;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(id = "oneid-iframe")
    private WebElement profileSettingsIframe;

    @FindBy(id = "oneid-iframe")
    private WebElement deleteConfirmationIframe;

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement promoBanner;

    @FindBy(css = ".PromoBanner__CloseBtn svg")
    private WebElement closeBannerButton;

    @FindBy(css = "a[href=\"http://www.espn.com/watch/\"]")
    private WebElement watchButton;

    @FindBy(css = ".display-user")
    private WebElement welcomeMessage;

     @FindBy(css = ".display-user span")
     private WebElement customNameField;

     @FindBy(css = ".account-management li:last-child a")
     private WebElement logoutButton;

     @FindBy(css = "a[tref=\"/members/v3_1/modifyAccount\"]")
     private WebElement modifyAccountButton;

     @FindBy(id = "AccountDeleteLink")
     private WebElement deleteAccountLink;

     @FindBy(id = "BtnSubmit")
     private WebElement deleteConfirmationSubmit;

     @FindBy(id = "BtnSubmit")
     private WebElement deletionConfirmedOk;

     @FindBy(css = "#Title span")
     private WebElement accountDeactivatedNotification;

     @FindBy(css = "div.loading-indicator state-success")
     private WebElement greenCheckmark;


    public void clickOnUserIcon(){
        clickElement(userIconButton);
    }

    public void clickOnLoginIframeLauncher(){
        clickElement(loginIframeLauncher);
    }

    public void hoverOverProfileButton(){
        hoverOverElement(userIconButton);
    }

    public void goToLoginIframe(){
        getDriver().switchTo().frame(loginIframe);
    }

    public void enterEmail(String email){
        loginNameField.sendKeys(email);
    }

    public void enterPassword(String password){
        loginPasswordField.sendKeys(password);
    }

    public void clickOnLoginSubmit(){
        clickElement(loginSubmitButton);
    }

    public void exitIframe(){
        super.getDriver().switchTo().parentFrame();
        super.wait.until(ExpectedConditions.invisibilityOf(loginIframe));
    }

    public boolean isIframeLogoVisible(){
        return iframeESPNLogo.isDisplayed();
    }

    public boolean isLoginButtonVisible(){
        return loginSubmitButton.isDisplayed();
    }

    public boolean isSingUpButtonVisible(){
        return signUpButton.isDisplayed();
    }

//    public boolean confirmIfBannerIsVisible(){
//        boolean visible = false;
//        try {
//            waitForPresence(".promo-banner-container");
//            visible = promoBanner.isDisplayed();
//        } catch (TimeoutException e) {
//            visible = false;
//        }
//        return visible;
//    }

    public WatchPage goToWatchPage(){
        clickElement(watchButton);
        return new WatchPage(getDriver());
    }

    public void clickOnModifyAccount(){
        clickElement(modifyAccountButton);
    }

    public void goToModifyAccountIframe(){
        getDriver().switchTo().frame(profileSettingsIframe);
    }

    public void goToDeletionConfirmIframe(){
        getDriver().switchTo().frame(deleteConfirmationIframe);
    }

    public void waitForWelcomeMessage(){
        super.wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
    }

//    public boolean isCustomNameShowing(){
//        return customNameField.isDisplayed();
//    }

    public boolean isCustomNameShowing(){
        return hasChildren(welcomeMessage);
    }

    public boolean hasChildren(WebElement element){
        return element.findElements(By.xpath("./descendant-or-self::*")).size() > 1;
    }

    public void clickOnLogout(){
        clickElement(logoutButton);
    }

    public void refreshHomePage(){
        refreshPage();
    }

    public void clickOnDeleteAccountLink(){
        clickElement(deleteAccountLink);
    }

    public boolean isDeleteConfirmationButtonVisible(){
        return deleteConfirmationSubmit.isDisplayed();
    }

    public void clickConfirmDeleteAccount(){
        clickElement(deleteConfirmationSubmit);
    }

    public boolean promoBannerExists(){
        return super.getDriver().findElements(By.cssSelector("div.promo-banner-container > iframe")).size() != 0;
    }

    public void closePromoBanner(){
        if(promoBannerExists()){
            Reporter.info("Banner is visible");
            getDriver().switchTo().frame(promoBanner);
            Reporter.info("Switched to banner iframe");
            clickElement(closeBannerButton);
            super.getDriver().switchTo().parentFrame();
        }
    }

    public void scrollToDeleteLink(){
        scrollToElement(deleteAccountLink);
    }

    public boolean validateGreenCheckmark(){
        return greenCheckmark.isDisplayed();
    }

    public void clickFinalDeleteDisclosure(){
        wait.until(ExpectedConditions.visibilityOf(deletionConfirmedOk));
        clickElement(deletionConfirmedOk);
    }

    public boolean isAccountDeactivated(){
        return accountDeactivatedNotification.getText().equals("Account Deactivated");
    }
}
