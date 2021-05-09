package com.prestashop.demo.final_progect.design.pages;

import com.prestashop.demo.final_progect.design.common.Product;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.prestashop.demo.final_progect.design.common.Product.getProduct;
import static com.prestashop.demo.final_progect.design.common.SubMenuCategories.*;
import static com.prestashop.demo.final_progect.design.common.TopMenuCategories.*;
import static com.prestashop.demo.final_progect.design.driverFactory.DriverFactory.getDriver;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//input[@name='submitNewsletter']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//i[contains(@class,'expand-more')]")
    private WebElement dropDownMenuWithLanguages;

    @FindBy(xpath = ".//ul[contains(@class,'dropdown')]/li")
    private List<WebElement> languagesContainers;

    @FindBy(xpath = "//div[contains(@class,'popover')]")
    private WebElement fieldUnderClothesAndAccessoriesButton;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    @FindBy(xpath = "//a[contains(@href, 'prices-drop')]")
    private WebElement pricesDropButton;

    @FindBy(xpath = "//a[contains(@class,'all-product')]")
    private WebElement allProductsButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @SneakyThrows
    public  MainPage setEmail(String eMail) {
        scrollToElement(inputEmailField);
        inputEmailField.sendKeys(eMail);
        return this;
    }

    public MainPage clickSubscribeButton() {
        subscribeButton.click();
        return this;
    }

    public MainPage clickLanguagesDropDownMenu() {
        dropDownMenuWithLanguages.click();
        return this;
    }

    public Boolean isErrorMessageExist() {
        return isErrorExist(inputEmailField);
    }

    public int getCountOfLanguage() {
        return languagesContainers.size();
    }

    public String getLanguageFromTheDropList(String language) {
        if (languagesContainers.contains(language)) ;
        return language;
    }

    public boolean isEmptyFieldUnderArtButton() {
        return fieldUnderClothesAndAccessoriesButton.getText().isEmpty();
    }

    public List<Product> getProductsOnPage() {
        List<Product> allProducts = getProduct(productContainer);
        return allProducts;
    }

    @SneakyThrows
    public PriceDropPage clickPricesDropButton() {
        WebElement element = pricesDropButton;
        scrollToElement(pricesDropButton);
        pricesDropButton.click();
        return new PriceDropPage();
    }
    Actions actions = new Actions(getDriver());

    public MainPage hoverOverTopMenuLinks(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case CLOTHES:
                categoryId = "3";
                break;
            case ACCESSORIES:
                categoryId = "6";
                break;
            case ART:
                categoryId = "9";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        actions.moveToElement(getDriver().findElement(By.xpath(baseXpath))).build().perform();
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return this;
    }

    public boolean isCategoryDisplaying (String linkName) {
        String categoryId = null;
        switch (linkName) {
            case MEN:
                categoryId = "4";
                break;
            case WOMEN:
                categoryId = "5";
                break;
            case STATIONERY:
                categoryId = "7";
                break;
            case HOME_ACCESSORIES:
                categoryId = "8";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        return getDriver().findElement(By.xpath(baseXpath)).isDisplayed();
    }
}
