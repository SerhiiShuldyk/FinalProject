package com.prestashop.demo.final_progect.design.listener;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


@Slf4j
@Getter
@Setter
public class TestsListeners implements WebDriverEventListener{

    @Override
    public void beforeAlertAccept(WebDriver driver) {
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Try find: " + element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Successful find: " + element);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("Try click on: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info("Successful click on: " + element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        log.info("Try get text with: " + element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        log.info("Successful get text with: " + element);
    }
}
