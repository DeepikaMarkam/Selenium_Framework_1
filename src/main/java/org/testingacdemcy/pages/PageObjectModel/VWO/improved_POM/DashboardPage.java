package org.testingacdemcy.pages.PageObjectModel.VWO.improved_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testingacdemcy.Utils.waitHelper.WaitHelper;
import org.testingacdemcy.base.CommonToAllPages;

public class DashboardPage extends CommonToAllPages {

    WebDriver driver;
    public DashboardPage(WebDriver driver)
    {
        this.driver =driver;
    }

    private By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    //Page Actions
    public String loggedIntUserName()
    {
        WaitHelper.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
