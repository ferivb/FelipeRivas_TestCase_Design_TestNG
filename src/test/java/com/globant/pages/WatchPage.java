package com.globant.pages;

import com.globant.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WatchPage extends BasePage{
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul.Carousel__Inner:first-of-type")
    private List<WebElement> carouselList;

    @FindBy(id = "fittPortal_2")
    private WebElement providerSelector;

//    @FindBy(xpath = "//header/button[1]/div[1]/*[1]")
    @FindBy(className = "lightbox__closebtn")
    private WebElement cardCloseButton;

    @FindBy(className = "lightboxTitle")
    private WebElement cardTitle;

    @FindBy(id = "WatchProvider__Search")
    private WebElement popUpSearchBar;

    public boolean secondCarouselIsNotEmpty(){
        List<WebElement> secondCarousel = carouselList.get(1).findElements(By.cssSelector("li"));
        return secondCarousel.stream()
                        .allMatch(element -> element.getText().length() > 0);
    }

    public void clickOnCardByIndex(int index){
        List<WebElement> firstCarousel = carouselList.get(0).findElements(By.cssSelector("li"));
        clickElement(firstCarousel.get(index));
    }

    public void waitForCloseButton(){
        super.wait.until(ExpectedConditions.visibilityOf(cardCloseButton));
    }

    public void waitForCardPopUp(){
        super.wait.until(ExpectedConditions.visibilityOf(popUpSearchBar));
    }

    public boolean confirmCloseButtonExist(){
        return cardCloseButton.isDisplayed();
    }

    public void closeCard(){
        waitForCloseButton();
        clickElement(cardCloseButton);
    }

    public HomePage goBackHome(){
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }

    public void exitCardIframe(){
        super.getDriver().switchTo().parentFrame();
        super.wait.until(ExpectedConditions.invisibilityOf(providerSelector));
    }
}
