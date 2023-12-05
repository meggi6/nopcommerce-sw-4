package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class PaymentInformationPage extends Utility {

    By creditCardDropDown = By.id("CreditCardType");
    By cardholderNameField = By.id("CardholderName");
    By cardNumberField = By.id("CardNumber");
    By expirationMonthDropDown = By.id("ExpireMonth");
    By expirationYearDropDown = By.id("ExpireYear");
    By cardCodeField = By.id("CardCode");
    By paymentInformationContinueButton = By.cssSelector(".button-1.payment-info-next-step-button");


    public void selectCreditCardDropDown(String text) {
        selectByVisibleTextFromDropDown(creditCardDropDown, text);
    }

    public void enterCardholderName(String text) {
        sendTextToElement(cardholderNameField, text);
    }

    public void enterCardNumber(String text) {
        sendTextToElement(cardNumberField, text);
    }

    public void selectExpirationMonthDropDown(String text) {
        selectByVisibleTextFromDropDown(expirationMonthDropDown, text);
    }

    public void selectExpirationYearDropDown(String text) {
        selectByVisibleTextFromDropDown(expirationYearDropDown, text);
    }

    public void enterCardCode(String text) {
        sendTextToElement(cardCodeField, text);
    }

    public void clickOnPaymentInformationContinueButton() {
        clickOnElement(paymentInformationContinueButton);
    }
}
