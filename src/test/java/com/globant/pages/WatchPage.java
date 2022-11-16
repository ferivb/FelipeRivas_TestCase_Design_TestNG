package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage{
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul.Carousel__Inner:first-of-type")
    private List<WebElement> carouselList;

    public boolean secondCarouselIsNotEmpty(){
        List<WebElement> secondCarousel = carouselList.get(1).findElements(By.cssSelector("li"));
        return secondCarousel.stream()
                        .allMatch(element -> element.getText().length() > 0);
    }

    public void clickOnCardByIndex(int index){
        List<WebElement> firstCarousel = carouselList.get(0).findElements(By.cssSelector("li"));
        clickElement(firstCarousel.get(index));
    }
}
