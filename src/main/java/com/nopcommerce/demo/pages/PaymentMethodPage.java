package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class PaymentMethodPage extends Utility {
    By creditCardRadioButton = By.id("paymentmethod_1");
    By paymentMethodContinueButton = By.className("payment-method-next-step-button");

    public void clickOnCreditCardRadioButton() {
        clickOnElement(creditCardRadioButton);
    }

    public void clickOnPaymentMethodContinueButton() {
        clickOnElement(paymentMethodContinueButton);
    }
}
