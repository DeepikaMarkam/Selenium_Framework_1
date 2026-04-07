package org.testingacdemcy.Utils.waitHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static org.testingacdemcy.driver.DriverManger.driver;
import static org.testingacdemcy.driver.DriverManger.getDriver;

public class WaitHelper {
    //try-catch-thread-wait
    public static void waitJVM(int time) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Implicitlywait
        public static  void waitImplictWait(WebDriver driver,int time)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        }

        //Visibiblity with time
        public static void checkvisibility(WebDriver driver,By locator,int time)
        {
            WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            Wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }

    //Visibiblity without time
    public static void checkvisibility(WebDriver driver,By locator)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //checkvisibilityofChecktobePresent
    public static  void checkvisibilityofChecktobePresent(WebDriver driver, WebElement element,String text)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Wait.until(ExpectedConditions.visibilityOf(element));
        Wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    //waitforvisibility
    public static  void waitforvisibility(WebDriver driver,int timeInsecond,String xpath)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(timeInsecond));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

     public static void waitFulentVisiblity(WebDriver driver,int maxTime,String xpath)
{
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

    WebElement error = wait.until(new Function<WebDriver, WebElement>() {
        @Override
        public WebElement apply(WebDriver webDriver) {
            return driver.findElement(By.id("js-notification-box-msg"));
        }
    });
}

    //WaitForVisiblity
    public  void waitForVisibilty(WebDriver driver,int timeinSec,String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeinSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    //waitForTextTobePresent
    public  void waitForTextTobePresent(WebDriver driver,int timeinSec,String xpath,String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeinSec));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(xpath)), text));
    }

    //AlertToPresent
    public  void waitForAlert(WebDriver driver,int timeinSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeinSec));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //WaitForJVM
    public static  void waitForJVm(int time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
    //
    public static WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement presenceOfElement(WebDriver driver,By elementLocation) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public static WebElement visibilityOfElement(WebElement elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elementLocation));
    }




}

