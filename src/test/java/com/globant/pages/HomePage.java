package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void goToProfileSettingsIframe(){
        getDriver().switchTo().frame(profileSettingsIframe);
    }


}
