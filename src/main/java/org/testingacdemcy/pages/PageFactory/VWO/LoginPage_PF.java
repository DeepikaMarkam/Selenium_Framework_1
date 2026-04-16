package org.testingacdemcy.pages.PageFactory.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testingacdemcy.Utils.waitHelper.PropertiesReader;
import org.testingacdemcy.Utils.waitHelper.WaitHelper;
import org.testingacdemcy.base.CommonToAllPages;

import static org.testingacdemcy.driver.DriverManger.getDriver;

public class LoginPage_PF extends CommonToAllPages {

    WebDriver driver;
    public  LoginPage_PF(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    //Page Loctors
//    private By username = By.id("login-username");
    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id="js-login-btn")
    private WebElement signButton;

//    @FindBy(id="js-notification-box-msg")
//    private WebElement error_message;
    @FindBy(css="#js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public  String loginToVWOInvaildCreds()
    {
        try{
            openVWOUrl();
            enterInput(username, PropertiesReader.readKey("invalid_username"));
            enterInput(password,PropertiesReader.readKey("invalid_password"));
            clickElement(signButton);
            WaitHelper.waitForJVm(5000);
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return getText(error_message);
    }
    //
}
