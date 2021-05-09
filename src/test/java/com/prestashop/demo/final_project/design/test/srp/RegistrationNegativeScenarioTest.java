package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.pages.LogInPage;
import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test(dataProvider = "getData",enabled = true)
    public void registrationNegativeScenario(Map<String,String> data) {
        MainPage mainPage = new MainPage();
        LogInPage logInPage =
                mainPage.clickSingInButton()
                        .clickCreateNewAccountButton()
                        .chooseSocialTitle()
                        .inputFirstName(data.get("firstName"))
                        .inputLastName(data.get("lastName"))
                        .inputEmail(data.get("email"))
                        .inputPassword(data.get("password"))
                        .inputBirthdayDate(data.get("birthdayDate"))
                        .clickCustomerPrivacyButton()
                        .clickAgreeButton()
                        .clickSaveButtonWithIncorrectData();
        String actualTextInvalidMessage = logInPage.getTextFromInvalidForm();
        String actualColorOfField = logInPage.getColorOfTheFirstNameField();
        assertSoftly(softAssertions -> {softAssertions.assertThat(actualTextInvalidMessage).isEqualTo("Invalid format.");});
        assertSoftly(softAssertions -> {softAssertions.assertThat(actualColorOfField).isEqualTo("rgba(255, 76, 76, 1)");
        });
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("firstName", "Sergii19");
        map.put("lastName", "Shuldyk");
        map.put("email", "s3267077s@gmail.com");
        map.put("password", "12345678");
        map.put("birthdayDate", "09/11/1991");
        return new Object[][] {
                {map}
        };
    }
}

