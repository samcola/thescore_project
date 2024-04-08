package test.score.qa.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import test.score.qa.managers.AppiumDriverManager;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseAction {
    public AppiumDriver driver;

    public BaseAction() {
        driver = AppiumDriverManager.getAppiumDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public boolean isElementPresent(By by) {
        WebElement element;
        try {
            element = driver.findElement(by);
        }
        catch(NoSuchElementException exception){
            return false;
        }
        return element.isDisplayed();
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

    public void waitAndSoftClick(By by){
        new FluentWait<AppiumDriver>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void dismissAlert(By by) {
        if (isElementPresent(by)) {
            click(by);
        }
    }

}
