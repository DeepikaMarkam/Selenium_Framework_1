package org.testingacdemcy.tests.vwoTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testingacdemcy.Utils.waitHelper.PropertiesReader;
import org.testingacdemcy.baseTests.CommonToAllTest;
import org.testingacdemcy.driver.DriverManger;
import org.testingacdemcy.pages.PageFactory.VWO.LoginPage_PF;
import org.testingacdemcy.pages.PageObjectModel.VWO.improved_POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;


public class TestVWO_Login_03_PageFactory extends CommonToAllTest
{
    private static final Logger logger = LogManager.getLogger(TestVWO_Login_03_PageFactory.class);

    @Test
    public void testLoginNegativeVWO_PM()
    {
        logger.info("Starting the Page Factory testcase");

        LoginPage_PF LoginPage_PF = new LoginPage_PF(DriverManger.getDriver());
        String error_msg = LoginPage_PF.loginToVWOInvaildCreds();

        logger.info("Finsed the Testcase Page Factory");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}


