package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ProductPage extends Utility {
    /**
     * Build your own computer
     * 2.5 Verify the Text "Build your own computer"
     * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
     * 2.7.Select "8GB [+$60.00]" using Select class.
     * 2.8 Select HDD radio "400 GB [+$100.00]"
     * 2.9 Select OS radio "Vista Premium [+$60.00]"
     * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
     * 2.11 Verify the price "$1,475.00"
     * 2.12 Click on "ADD TO CARD" Button.
     * 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
     * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     */

    By buildYourComputerText = By.xpath("//h1[normalize-space()='Build your own computer']");
    By processorDropDown = By.cssSelector("#product_attribute_1");
    By ramDropDown = By.cssSelector("#product_attribute_2");
    By hddRadioButton = By.id("product_attribute_3_7");
    By osRadioButton = By.id("product_attribute_4_9");
    By microsoftOfficeCheckBox = By.id("product_attribute_5_10");
    By totalCommanderCheckBox = By.id("product_attribute_5_12");
    By priceText = By.cssSelector("#price-value-1");
    By addToCartButton = By.id("add-to-cart-button-1");
    By productHasBeenAddedText = By.xpath("//p[@class='content']");
    By crossButton = By.xpath("//span[@title='Close']");
    By shoppingCartLink = By.xpath("//span[@class='cart-label']");
    By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");

    /**
     * Nokia Lumia
     * 2.6 Verify the text “Nokia Lumia 1020”
     * 2.7 Verify the price “$349.00”
     * 2.8 Change quantity to 2
     * 2.9 Click on “ADD TO CART” tab
     * 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
     * After that close the bar clicking on the cross button.
     * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     */

    By nokiaLumiaText = By.xpath("//h1[normalize-space()='Nokia Lumia 1020']");
    By priceTextOfNokiaLumia = By.xpath("//span[@id='price-value-20']");
    By qtyTextBox = By.id("product_enteredQuantity_20");
    By addToCartTab = By.xpath("//button[@id='add-to-cart-button-20']");
    By CartMassage = By.xpath("//p[@class='content']");
    By closeCrossButton = By.xpath("//span[@title='Close']");
    By shoppingCartLinkAndClickOnGoTOCart = By.xpath("//span[@class='cart-label']");

    //Computer Product
    public void selectProcessor(String text) {
        selectByVisibleTextFromDropDown(processorDropDown, text);
    }

    public void selectRam(String text) {
        selectByVisibleTextFromDropDown(ramDropDown, text);
    }

    public void clickOnHDD() {
        clickOnElement(hddRadioButton);
    }

    public void clickOnOS() {
        clickOnElement(osRadioButton);
    }

    public void clickOnMicrosoftOfficeCheckBox() {
        clickOnElement(microsoftOfficeCheckBox);
    }

    public void clickOnTotalCommanderCheckBox() {
        mouseHoverToElementAndClick(totalCommanderCheckBox);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public void clickOnCrossButton() {
        clickOnElement(crossButton);
    }

    public void mouseHoverOnShoppingCartLink() {
        mouseHoverToElement(shoppingCartLink);
    }

    public void clickOnGoToCartButton() {
        clickOnElement(goToCartButton);
    }

    public String getTextFromBuildYourComputer() {
        return getTextFromElement(buildYourComputerText);
    }

    public String getTextFromPrice() {
        mouseHoverToElement(priceText);
        return getTextFromElement(priceText);
    }

    public String getTextFromProductHasBeenAdded() {
        return getTextFromElement(productHasBeenAddedText);
    }

    //Nokia Lumia Product
    public String verifyNokiaLumia1020() {
        return getTextFromElement(nokiaLumiaText);
    }

    public String verifyPriceOfNokiaLumia() {
        return getTextFromElement(priceTextOfNokiaLumia);
    }

    public void changeTheQty(String qty) {
        clearField(qtyTextBox);
        sendTextToElement(qtyTextBox, qty);
    }

    public void addToCartNokiaLumiaCellPhone() {
        clickOnElement(addToCartTab);
    }

    public String verifyTheCartMassage() {
        return getTextFromElement(CartMassage);
    }

    public void clickOnNokiaCrossButton() {
        clickOnElement(closeCrossButton);
    }

    public void mouseHoverOnShoppingCartLinkAndClick() {
        mouseHoverToElementAndClick(shoppingCartLinkAndClickOnGoTOCart);
    }
}
