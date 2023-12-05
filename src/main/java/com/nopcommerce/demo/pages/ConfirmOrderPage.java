package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends Utility {
    //Computer Test
    By paymentMethodVerifyText = By.xpath("//span[contains(text(),'Credit Card')]");
    By shippingMethodVerifyText = By.xpath("//span[contains(text(),'Next Day Air')]");
    By totalAmountVerifyText = By.xpath("//span[@class='value-summary']/strong[text()='$2,950.00']");
    By confirmButton = By.xpath("//button[contains(text(),'Confirm')]");

    //Electronic Test
    By secondDayAirShippingMethod =  By.cssSelector("li[class='shipping-method'] span[class='value']");

    //Computer Test
    public String paymentMethodVerifyText() {
        return getTextFromElement(paymentMethodVerifyText);
    }

    public String shippingMethodVerifyText() {
        return getTextFromElement(shippingMethodVerifyText);
    }

    public String totalAmountVerifyText() {
        return getTextFromElement(totalAmountVerifyText);
    }

    public void clickOnConfirmButton() {
        clickOnElement(confirmButton);
    }

    //Electronic Test
    public String verifySecondDayShippingMethod(){
        return getTextFromElement(secondDayAirShippingMethod);
    }

}
