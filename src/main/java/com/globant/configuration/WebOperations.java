package com.globant.configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {

    private final WebDriver driver;
    protected final WebDriverWait wait;

    public WebOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public void clickElement(WebElement element){
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    public void hoverOverElement(WebElement element){
        waitForVisibility(element);
        waitForClickable(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void scrollToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    public boolean retryingFindClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                clickElement(element);
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
}
