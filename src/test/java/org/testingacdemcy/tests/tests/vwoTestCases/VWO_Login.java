package org.testingacdemcy.tests.tests.vwoTestCases;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VWO_Login {

    @Description("Verfiy that with invaild email,pass,error message is shown")
    @Test
    public void test_negative_app_vwo_com() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        //Step1 Driver Mangeing
        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        //Step2 Locator
//        <input type="email" class="text-input W(100%)" name="username"
//        vwo-html-translate-attr="placeholder" vwo-html-translate-placeholder="login:enterEmailID"
//        id="login-username" data-qa="hocewoqisi" placeholder="Enter email ID">

        Thread.sleep(5000);
        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("deepikamarkam58@");

        WebElement password_input_box= driver.findElement(By.id("login-password"));
        password_input_box.sendKeys("password");

        Thread.sleep(2000);
        WebElement submit_input_box= driver.findElement(By.id("js-login-btn"));
        submit_input_box.click();

        //Step3 -Wait
        Thread.sleep(2000);

//        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
//        System.out.println(error_message.getText());
        String actualError = error_message.getText();
        System.out.println("Error Message is: " + actualError);
        Thread.sleep(5000);

        //ASSERTION
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        //Assert.assertEquals(error_message.getText(),error_message.getText());

        driver.quit();
    }
}
