package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutAsGuestPage extends Utility {
    //Billing Address
    By firstNameField = By.id("BillingNewAddress_FirstName");
    By lastNameField = By.id("BillingNewAddress_LastName");
    By emailIdField = By.id("BillingNewAddress_Email");
    By countryDropDown = By.id("BillingNewAddress_CountryId");
    By cityField = By.xpath("//input[@id='BillingNewAddress_City']");
    By addressField = By.id("BillingNewAddress_Address1");
    By postalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumberField = By.xpath("//div[@class='section new-billing-address']//input[@id='BillingNewAddress_PhoneNumber']");
    By asGuestContinueButton = By.xpath("//button[@onclick='Billing.save()']");


    public void enterFirstName(String text) {
        sendTextToElement(firstNameField, text);
    }

    public void enterLastName(String text) {
        sendTextToElement(lastNameField, text);
    }

    public void enterEmailId(String text) {
        sendTextToElement(emailIdField, text);
    }

    public void selectCountry(String text) {
        selectByVisibleTextFromDropDown(countryDropDown, text);
    }

    public void enterCity(String text) {
        sendTextToElement(cityField, text);
    }

    public void enterAddressField(String text) {
        sendTextToElement(addressField, text);
    }

    public void enterPostalCode(String text) {
        sendTextToElement(postalCodeField, text);
    }

    public void enterPhoneNumber(String text) {
        sendTextToElement(phoneNumberField, text);
    }

    public void clickOnContinueButton() {
        clickOnElement(asGuestContinueButton);
    }

}
