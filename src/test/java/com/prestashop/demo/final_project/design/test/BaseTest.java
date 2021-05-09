package com.prestashop.demo.final_project.design.test;

import com.prestashop.demo.final_progect.design.driverFactory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void createDriver() {
        DriverFactory.init();
    }

    @AfterMethod(alwaysRun = true)
    public void quite() {
        DriverFactory.getDriver().quit();
    }
}
