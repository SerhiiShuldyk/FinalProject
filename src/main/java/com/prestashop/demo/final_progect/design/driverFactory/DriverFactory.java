package com.prestashop.demo.final_progect.design.driverFactory;

import com.prestashop.demo.final_progect.design.listener.TestsListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

        private static ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

        public static void init() {
            WebDriverManager.chromedriver().setup();
            WebDriver originalDriver = new ChromeDriver();
            EventFiringWebDriver decoratedDriver = new EventFiringWebDriver(originalDriver);
            decoratedDriver.register(new TestsListeners());
            decoratedDriver.manage().window().maximize();
            decoratedDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            decoratedDriver.get(" https://demo.prestashop.com/");

            try {
                new WebDriverWait(originalDriver, 5).until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("loadingMessage")));
            } catch (Exception e) {
            }
            try {
                Boolean webElement = new WebDriverWait(originalDriver, 5).until(ExpectedConditions
                        .invisibilityOfElementLocated(By.id("loadingMessage")));
            } catch (Exception e) {
            }
            decoratedDriver.switchTo().frame("framelive");
            DRIVER_THREAD_LOCAL.set(decoratedDriver);
        }

        public static WebDriver getDriver() {
            return DRIVER_THREAD_LOCAL.get();
        }
}
