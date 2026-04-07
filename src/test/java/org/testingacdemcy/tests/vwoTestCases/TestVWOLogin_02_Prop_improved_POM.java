package org.testingacdemcy.tests.vwoTestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingacdemcy.Utils.waitHelper.PropertiesReader;
import org.testingacdemcy.baseTests.CommonToAllTest;
import org.testingacdemcy.driver.DriverManger;
import org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testingacdemcy.driver.DriverManger.driver;
import static org.testingacdemcy.driver.DriverManger.getDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestVWOLogin_02_Prop_improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_improved_POM.class);
    @Owner("Deepi2")
    @Description("Verfiy that with vaild email,pass Open DashBoard Page")
    @Test
    public void Test_negative_vwo_login() {

        logger.info("Browser is started....");
        driver.get(PropertiesReader.readKey("url"));
        LoginPage loginPage = new LoginPage(DriverManger.getDriver());
        logger.info("Verifying the Invalid credentials....");

        String error_msg = loginPage.loginToVWOInvaildCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Final Assert Verifications....");
        // System.out.println(error_msg); No now!!
        logger.info(error_msg.toString());

        logger.error("Failed to verify");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));


    }



    }

