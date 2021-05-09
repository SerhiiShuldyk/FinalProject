package com.prestashop.demo.final_progect.design.common;

import com.prestashop.demo.final_progect.design.driverFactory.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshotted {
    @Attachment("Screenshot on failure")
    public static byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}