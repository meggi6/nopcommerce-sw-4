package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        //Verify that the page navigation was successful
        homePage.selectMenu("Electronics");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Electronics";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle), "Page navigation did not go as expected");

    }
}
