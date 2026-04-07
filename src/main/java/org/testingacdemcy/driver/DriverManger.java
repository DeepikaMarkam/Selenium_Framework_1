package org.testingacdemcy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testingacdemcy.Utils.waitHelper.PropertiesReader;

import java.util.Locale;

public class DriverManger
{
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManger.driver = driver;

    }

        //When we wanr to start the browser
        public static void init()
        {
             String browser = PropertiesReader.readKey("browser");
               browser = browser.toLowerCase();
               switch (browser)
               {
                   case "edge":
                       EdgeOptions edgeOptions = new EdgeOptions();
                       edgeOptions.addArguments("--start-maximized");
                       edgeOptions.addArguments("--guest");
                       driver = new EdgeDriver(edgeOptions);
                       break;
                   case "chrome":
                       ChromeOptions chromeOptions = new ChromeOptions();
                       chromeOptions.addArguments("--start-maximized");
                       chromeOptions.addArguments("--guest");
                       driver = new ChromeDriver(chromeOptions);
                       break;
                   case "firefox":
                       FirefoxOptions firefoxOptions = new FirefoxOptions();
                       firefoxOptions.addArguments("--start-maximized");
                       firefoxOptions.addArguments("--guest");
                       driver = new FirefoxDriver(firefoxOptions);
                       break;
                   default:
                       System.out.println("Not Browser Support!!!!");
               }
        }

        //When we want to close the browser
        public static void down()
        {
            if(driver!=null)
            {
                driver.quit();
                driver = null;
            }

        }

}
