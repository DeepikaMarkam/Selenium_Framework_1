package org.testingacdemcy.pages.PageObjectModel.VWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testingacdemcy.Utils.waitHelper.WaitHelper;

public class DashboardPage
{
    WebDriver driver;
            public DashboardPage(WebDriver driver)
            {
                this.driver = driver;
            }

            private By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

            public String loggedInUserName()
            {
                WaitHelper.waitForJVm(10000);
                driver.get("https://app.vwo.com/#/dashboard?accountId=1207845");
                WaitHelper.waitForJVm(2000);

                return driver.findElement(userNameOnDashboard).getText();
            }
}
