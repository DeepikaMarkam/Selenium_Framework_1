package org.testingacdemcy.pages.PageObjectModel.VWO.improved_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.testingacdemcy.Utils.waitHelper.WaitHelper;
import org.testingacdemcy.base.CommonToAllPages;

import static org.testingacdemcy.driver.DriverManger.getDriver;

public class LoginPage extends CommonToAllPages
{
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

    public String loginToVWOInvaildCreds(String user,String pwd)
    {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelper.checkvisibility(getDriver(),error_message);
        return getText(error_message);
    }
    public void loginToVWOvaildCreds(String user,String pwd)
    {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelper.waitForJVm(5000);

    }
}
