package org.testingacdemcy.baseTests;

import org.testingacdemcy.driver.DriverManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest
{
    @BeforeMethod
    public void setUp()
    {
        DriverManger.init();
    }

    @AfterMethod
    public void TearDown()
    {
        DriverManger.down();
    }
}
