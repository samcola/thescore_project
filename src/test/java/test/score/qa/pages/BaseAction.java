package test.score.qa.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import test.score.qa.managers.AppiumDriverManager;
import test.score.qa.stepdefs.TestScenarioAutomationStepDef;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseAction {
    public AppiumDriver driver;

    private static final Logger logger = Logger.getLogger(BaseAction.class.getName());

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

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void waitAndSoftClick(By by){
        new FluentWait<AppiumDriver>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean isLoaded (WebElement el){
        boolean bool = false;
        try {
            bool = !((RemoteWebElement) el).getId().isEmpty();
        } catch (Exception ignored) {
        }
        return bool;
    }

//    public void wait(Integer seconds) {
//        driver.manage().timeouts().(Duration.ofSeconds(seconds));
//    }

    public void dismissAlert(By by) {
        if (isElementPresent(by)) {
            click(by);
        }
    }

    public void getNestedElements(By by, By by2) {
        if (isElementPresent(by)) {
            List<WebElement> elements = driver.findElements(by2);
            logger.log(Level.INFO, "WEB ELEMENTS: " + elements);
            for ( WebElement el : elements) {
                logger.log(Level.INFO, "ELE : " + el.getText());
            }
        }
    }

}
