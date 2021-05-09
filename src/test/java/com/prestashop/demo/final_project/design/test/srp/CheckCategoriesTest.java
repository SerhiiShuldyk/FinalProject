package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.pages.BasePage;
import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.testng.annotations.Test;

import static com.prestashop.demo.final_progect.design.common.SubMenuCategories.*;
import static com.prestashop.demo.final_progect.design.common.TopMenuCategories.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void checkCategories()  {
        MainPage mainPage = new MainPage();
        boolean resultMenCategories =
                mainPage.hoverOverTopMenuLinks(CLOTHES)
                        .isCategoryDisplaying(MEN);
        boolean resultWomenCategories =
                mainPage.isCategoryDisplaying(WOMEN);
        assertSoftly(softAssertions -> {softAssertions.assertThat(resultMenCategories).as("MEN subcategory is not displayed").isTrue();});
        assertSoftly(softAssertions -> {softAssertions.assertThat(resultWomenCategories).as("Women subcategory is not displayed").isTrue();});
        boolean resultHomeAccessoriesButton =
                mainPage.hoverOverTopMenuLinks(ACCESSORIES)
                        .isCategoryDisplaying(STATIONERY);
        boolean resultStationeryButton = mainPage.isCategoryDisplaying(HOME_ACCESSORIES);
        assertSoftly(softAssertions -> {softAssertions.assertThat(resultHomeAccessoriesButton).as("Home_Accessories subcategory is not displayed").isTrue();});
        assertSoftly(softAssertions -> {softAssertions.assertThat(resultStationeryButton).as(" Stationery subcategory is not displayed").isTrue();});
        boolean resultArtButton =
                mainPage.hoverOverTopMenuLinks(ART)
                        .isEmptyFieldUnderArtButton();
        assertSoftly(softAssertions -> {softAssertions.assertThat(resultArtButton).as("Art category is not empty").isFalse();});
    }
}
