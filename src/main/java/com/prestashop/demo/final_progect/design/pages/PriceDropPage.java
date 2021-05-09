package com.prestashop.demo.final_progect.design.pages;

import com.prestashop.demo.final_progect.design.common.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.prestashop.demo.final_progect.design.common.Product.getProduct;
import static com.prestashop.demo.final_progect.design.driverFactory.DriverFactory.getDriver;

public class PriceDropPage extends BasePage {

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainer;

    public PriceDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<Product> getProductsOnPage() {
        List<Product> allProducts = getProduct(productContainer);
        return allProducts;
    }
}
