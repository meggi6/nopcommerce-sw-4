package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutCompletedPage extends Utility {
    By thankYouText = By.cssSelector("div[class='page-title'] h1");
    By yourOrderHasProcessedText = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By checkoutCompletedContinueButton= By.cssSelector(".button-1.order-completed-continue-button");

    public String getThankYouText() {
        return getTextFromElement(thankYouText);
    }

    public String getYourOrderHasProcessedText() {
        return getTextFromElement(yourOrderHasProcessedText);
    }

    public void clickOnCheckoutCompletedContinueButton() {
        clickOnElement(checkoutCompletedContinueButton);
    }
}
