package org.testingacdemcy.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class TestSample {

    @Description("Sample Test 0")
    @Test
    public void testSample0()
    {
        Assert.assertTrue(true);
    }

    @Description("Sample Test 0")
    @Test
    public void testSample2()
    {
        Assert.assertTrue(true);
    }



}
