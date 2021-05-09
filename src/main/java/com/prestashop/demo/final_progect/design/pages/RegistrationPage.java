package com.prestashop.demo.final_progect.design.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.prestashop.demo.final_progect.design.driverFactory.DriverFactory.getDriver;

public class RegistrationPage extends BasePage {


    @FindBy(xpath = "//a[contains(@href,'create_account=1')]")
    private WebElement createNewAccountButton;

    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LogInPage clickCreateNewAccountButton() {
        createNewAccountButton.click();
        return new LogInPage();
    }
}
