package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CheckLanguagesTest extends BaseTest {
    String expectedResult = "Українська";

    @Test
    public void checkLanguagesInADropDownMenu(){
        SoftAssertions sa = new SoftAssertions();
        MainPage mainPage = new MainPage();
        List<WebElement> language = mainPage.clickLanguagesDropDownMenu()
                .getLanguagesContainers();
        List<String> languageList = language.stream().map(s -> s.getText()).collect(Collectors.toList());
        sa.assertThat(language.size()).isEqualTo(44);
        sa.assertThat(languageList).as("List doesn't contain language " + expectedResult).contains(expectedResult);
        sa.assertAll();
    }
}
