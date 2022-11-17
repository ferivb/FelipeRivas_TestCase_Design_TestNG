package com.globant.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public void typeOfInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresence(String locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
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
}
