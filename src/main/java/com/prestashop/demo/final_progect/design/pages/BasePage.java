package com.prestashop.demo.final_progect.design.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.prestashop.demo.final_progect.design.driverFactory.DriverFactory.getDriver;


public class BasePage {

    @FindBy(xpath = "//a[contains(@title,'Log in')]")
    private WebElement singInButton;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']")
    private WebElement userLoginField;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    protected Boolean isErrorExist(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (Boolean) js.executeScript("return arguments[0].checkValidity();", element);

    }

    public RegistrationPage clickSingInButton() {
        singInButton.click();
        return new RegistrationPage();
    }

    public String getTextFromUserLoginField() {
        return userLoginField.getText();

    }
}

