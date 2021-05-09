package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeWithInvalidEmailTest extends BaseTest {

    @Test
    public void subscribeWithInvalidEmailTest() {
        MainPage mainPage = new MainPage();
        String emailWithInvalidFormat = "ttt@ttt";
        boolean isErrorAppeared =
                mainPage.setEmail(emailWithInvalidFormat)
                        .clickSubscribeButton()
                        .isErrorMessageExist();
        Assertions.assertThat(isErrorAppeared);
    }
}
