package com.globant.pages;

import com.globant.reporting.Reporter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "global-user-trigger")
    private WebElement profileInfoButton;

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

    public WebElement getProfileInfoButton() {
        return profileInfoButton;
    }

    public WebElement getLoginSubmitButton() {
        return loginSubmitButton;
    }

    public void clickOnProfileManager(){
        clickElement(profileInfoButton);
    }

    public void clickOnLoginIframeLauncher(){
        clickElement(loginIframeLauncher);
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
        super.getDriver().switchTo().defaultContent();
    }

    public boolean isLoginIframeVisible(){
        return loginIframe.isDisplayed();
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

    public boolean confirmIfBannerIsVisible(){
        boolean visible = false;
        try {
            waitForPresence(".promo-banner-container");
            visible = promoBanner.isDisplayed();
        } catch (TimeoutException e) {
            visible = false;
        }
        return visible;
    }

    public void goToProfileSettingsIframe(){
        getDriver().switchTo().frame(profileSettingsIframe);
    }


}
