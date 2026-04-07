package org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testingacdemcy.Utils.waitHelper.WaitHelper;
import org.testingacdemcy.base.CommonToAllPages;

public class LoginPage  {


    WebDriver driver;

    public  LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }
    //Page Class


    //Page Locator
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    //Page Actions
    public String loginToVWOInvaildCreds(String usr,String pwd)
    {
        driver.findElement(username).sendKeys(usr);
//        enterInput(username,(usr));
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
//        clickElement(signButton);

        WaitHelper.checkvisibility(driver,error_message);
        String error_messge_text = driver.findElement(error_message).getText();
        return error_messge_text;
    }

    public void loginToVWOvaildCreds(String usr,String pwd)
    {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

    }
}
