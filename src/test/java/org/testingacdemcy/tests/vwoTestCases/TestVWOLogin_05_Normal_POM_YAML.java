package org.testingacdemcy.tests.vwoTestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingacdemcy.Utils.waitHelper.EnvUtil;
import org.testingacdemcy.Utils.waitHelper.YamlReader;
import org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;





public class TestVWOLogin_05_Normal_POM_YAML {

    @Owner("Deepi")
    @Description("Verfiy that with invaild email,pass,error message is shown")
    @Test
public void Test_Negative_vwo_login()
    {

        YamlReader yamlReader = new YamlReader("config.yaml");

        //DRIVER//DRiver Manager Code -1 -D
    WebDriver driver = new ChromeDriver();
//driver.get("https://app.vwo.com/#/login");
        driver.get(yamlReader.getString("project1.url"));

    //LOCATOR
    LoginPage loginPage = new LoginPage(driver);
    String error_mess = loginPage.loginToVWOInvaildCreds(yamlReader.getString("project1.invalid_username"),yamlReader.getString("project1.invalid_password"));

    //VERIFICATION//Assertions
   //        assertThat(error_mess).idNotNull();
   Assert.assertEquals(error_mess,yamlReader.getString("project1.invalid_error_message"));

   driver.quit();
    }



}
