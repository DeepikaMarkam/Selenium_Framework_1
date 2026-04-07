package org.testingacdemcy.tests.vwoTestCases.DDT;

import org.testingacdemcy.Utils.waitHelper.PropertiesReader;
import org.testingacdemcy.pages.PageObjectModel.VWO.improved_POM.LoginPage;
import org.testng.annotations.Test;
import static org.testingacdemcy.driver.DriverManger.getDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class DataDrivenTesting {

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {

        // Page Class Code (POM Code) - 2 - L
//        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        LoginPage loginPage = new LoginPage(getDriver());


        String error_msg = loginPage.loginToVWOInvaildCreds(email,password);

        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }
}
