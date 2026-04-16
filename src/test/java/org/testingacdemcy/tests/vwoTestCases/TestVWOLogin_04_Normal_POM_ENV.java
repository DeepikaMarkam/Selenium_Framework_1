package org.testingacdemcy.tests.vwoTestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingacdemcy.Utils.waitHelper.EnvUtil;
import org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM.DashboardPage;
import org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVWOLogin_04_Normal_POM_ENV {

    @Owner("Deepi")
    @Description("Verfiy that with invaild email,pass,error message is shown")
    @Test
public void Test_Negative_vwo_login()
    {
        //DRIVER//DRiver Manager Code -1 -D
    WebDriver driver = new ChromeDriver();
driver.get("https://app.vwo.com/#/login");

    //LOCATOR
    LoginPage loginPage = new LoginPage(driver);
    String error_mess = loginPage.loginToVWOInvaildCreds("admin@123","124");

    //VERIFICATION//Assertions
   //        assertThat(error_mess).idNotNull();
   Assert.assertEquals(error_mess,"Your email, password, IP address or location did not match");

   driver.quit();
    }

    @Owner("Deepi2")
    @Description("Verfiy that with vaild email,pass Open DashBoard Page")
    @Test
    public void Test_Positive_vwo_login()
    {

        System.out.println("FROM ENV: " + EnvUtil.getUsername());

        //DRIVER//DRiver Manager Code -1 -D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        //LOCATOR
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOvaildCreds(EnvUtil.getUsername(),EnvUtil.getPassword());

        //VERIFICATION//Assertions
        //        assertThat(error_mess).idNotNull();

//        Not fectching the correct user name
//        DashboardPage dashboardPage = new DashboardPage(driver);
//        String userNameLoggenIn = dashboardPage.loggedInUserName();
//
//        Assert.assertEquals(userNameLoggenIn,"Kishore J");

        driver.quit();
    }

}
