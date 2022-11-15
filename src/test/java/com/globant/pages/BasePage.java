package com.globant.pages;

import com.globant.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "global-user-trigger")
    private WebElement userProfileButton;

    @FindBy(css = "li a[tref=\"/members/v3_1/login\"]")
    private WebElement loginButton;

    @FindBy(css = ".account-management li:last-child a")
    private WebElement logoutButton;

    @FindBy(css = "li a[tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement profileSettingsButton;
}
