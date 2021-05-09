package com.prestashop.demo.final_project.design.test.srp;

import com.prestashop.demo.final_progect.design.pages.MainPage;
import com.prestashop.demo.final_project.design.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegistrationWithValidDataTest extends BaseTest {

    @Test(dataProvider = "getData",enabled = true)
    public void createANewAccount(Map<String,String> data){
        MainPage mainPage = new MainPage();
        String expectedAccountName = data.get("firstName") + " " + data.get("lastName");
        String actualAccountName =
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
                        .clickSaveButton()
                        .getTextFromUserLoginField();
        Assert.assertEquals(actualAccountName, expectedAccountName);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("firstName", "Serhii");
        map.put("lastName", "Shuldyk");
        map.put("email", "s3267077s@gmail.com");
        map.put("password", "12345678");
        map.put("birthdayDate", "09/11/1991");
        return new Object[][] {
                {map}
        };
    }
}

