package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShippingMethodPage extends Utility {
    By nextDayAir = By.id("shippingoption_1");
    By shippingMethodContinueButton = By.xpath("//button[@onclick='ShippingMethod.save()']");
    By click2ndDayAirRadioButton = By.id("shippingoption_2");


    public void clickOn2ndAirShippingMethod(){
        clickOnElement(click2ndDayAirRadioButton);
    }

    public void clickOnNextDayAirRadioButton() {
        clickOnElement(nextDayAir);
    }

    public void clickOnShippingMethodContinueButton() {
        clickOnElement(shippingMethodContinueButton);
    }
}
