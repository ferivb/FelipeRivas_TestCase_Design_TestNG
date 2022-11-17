package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
    private WebElement loginESPNLogo;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(id = "oneid-iframe")
    private WebElement profileSettingsIframe;

    @FindBy(className = "promo-banner-container")
    private WebElement promoBanner;

    @FindBy(className = "PromoBanner__CloseBtn")
    private WebElement closeBannerButton;

    @FindBy(css = "a[href=\"http://www.espn.com/watch/\"]")
    private WebElement watchButton;

    @FindBy(css = ".display-user")
    private WebElement welcomeMessage;

     @FindBy(css = ".display-user span")
     private WebElement customNameField;

     @FindBy(css = ".account-management li:last-child a")
     private WebElement logoutButton;

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

    public boolean isLoginLogoVisible(){
        return loginESPNLogo.isDisplayed();
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

    public void goToProfileSettingsIframe(){
        getDriver().switchTo().frame(profileSettingsIframe);
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

}
