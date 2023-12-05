package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    By shoppingCartText = By.xpath("//h1[normalize-space()='Shopping cart']");
    By changeQuantityBox = By.xpath("//td[@class='quantity']//input");
    By updateShoppingCartButton = By.cssSelector("#updatecart");
    By totalPriceText = By.cssSelector("span[class='value-summary'] strong");
    By iAgreeCheckBox = By.cssSelector("#termsofservice");
    By checkOutButton = By.xpath("//button[@id='checkout']");
    By clickOnLogIn = By.xpath("//a[normalize-space()='Log in']");



    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public void changeQuantity(String text) {

        clearField(changeQuantityBox);
        sendTextToElement(changeQuantityBox, "2");
    }

    public void clickOnUpdateShoppingCartButton() {
        clickOnElement(updateShoppingCartButton);
    }

    public String getTotalPriceText() {
        return getTextFromElement(totalPriceText);
    }

    public void clickOnIAgreeCheckBox() {
        clickOnElement(iAgreeCheckBox);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }

    public void clickOnLogInButton(){
        clickOnElement(clickOnLogIn);
    }

}
