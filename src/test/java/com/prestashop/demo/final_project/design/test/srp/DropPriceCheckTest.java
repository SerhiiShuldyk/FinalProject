package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.common.Product;
import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_progect.design.pages.PriceDropPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class DropPriceCheckTest extends BaseTest {
    @Test
    public void checkPriceDropCheck() {
        MainPage mainPage = new MainPage();
        PriceDropPage pricesDropPage = new PriceDropPage();
        mainPage.clickPricesDropButton();
        List<Product> nameOfProducts = pricesDropPage.getProductsOnPage();
        for (Product product : nameOfProducts) {
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getNewPriceWebEl().isDisplayed());
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getOldPriceWebEl().isDisplayed());
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getNewPrice()).isEqualTo(product.countExpectedPrice());
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertAll();
            });
        }
    }
}

