package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.common.Product;
import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CheckPopularProductsTest extends BaseTest {

    @Test
    public void checkPopularProducts() {
        MainPage mainPage = new MainPage();
        List<Product> nameOfProducts = mainPage.getProductsOnPage();
        for (Product product : nameOfProducts) {
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getNameWebEl().isDisplayed());
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getNewPriceWebEl().isDisplayed());
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(product.getNewPrice()).isGreaterThan(0.00);
            });
            assertSoftly(softAssertions -> {
                softAssertions.assertAll();
            });
        }
    }
}
