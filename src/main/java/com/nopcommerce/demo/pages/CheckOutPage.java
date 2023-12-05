package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    //Computer Test
    By welcomePleaseSignText = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
    By checkOutAsGuest = By.xpath("//button[normalize-space()='Checkout as Guest']");
    //Electronic Test
    By registerButton =  By.xpath("//button[normalize-space()='Register']");
    By emailId = By.id("Email");
    By passwordField = By.id("Password");
    By logInButton = By.xpath("//button[normalize-space()='Log in']");

    //Computer Test
    public String getWelcomePleaseSignText() {
        return getTextFromElement(welcomePleaseSignText);
    }

    public void clickOnCheckOutAsGuest() {
        clickOnElement(checkOutAsGuest);
    }

    //Electronic Test
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }

    public void emailId(String email){
        sendTextToElement(emailId, email);
    }

    public void password(String password){
        sendTextToElement(passwordField, password);
    }

    public void clickOnLogInButton(){
        clickOnElement(logInButton);
    }
}
