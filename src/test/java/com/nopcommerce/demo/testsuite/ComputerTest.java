package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ComputerTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    CheckOutAsGuestPage checkOutAsGuestPage = new CheckOutAsGuestPage();
    PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
    PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
    ShippingMethodPage shippingMethodPage = new ShippingMethodPage();
    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
    CheckOutCompletedPage checkOutCompletedPage = new CheckOutCompletedPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.mouseHoverOnComputerMenu();
        homePage.clickOnDesktopsSubTab();
        List<String> actual= desktopPage.clickOnSortByPosition("Name: Z to A");
        List<String> expected= desktopPage.productsArrangeInReverseOrder();
        Assert.assertEquals(actual, expected,"Products are not arranged in Descending order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverOnComputerMenu();
        homePage.clickOnDesktopsSubTab();
        desktopPage.clickOnSortByPosition("Name: A to Z");
        desktopPage.clickOnAddToCartButton();
        String expected = "Build your own computer";
        String actual = productPage.getTextFromBuildYourComputer();
        Assert.assertEquals(actual, expected, "product name is not matching");
        productPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        productPage.selectRam("8GB [+$60.00]");
        productPage.clickOnHDD();
        productPage.clickOnOS();
        productPage.clickOnMicrosoftOfficeCheckBox();
        productPage.clickOnMicrosoftOfficeCheckBox();
        Thread.sleep(2000);
        productPage.clickOnTotalCommanderCheckBox();
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getTextFromPrice(), "$1,475.00", "price is not matching");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getTextFromProductHasBeenAdded().contains( "The product has been added to your shopping cart"), "Text is not matching");
        productPage.clickOnCrossButton();
        productPage.mouseHoverOnShoppingCartLink();
        productPage.clickOnGoToCartButton();
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping cart", "error");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdateShoppingCartButton();
        // 2.17 Verify the Total"$2,950.00" 2.18 click on checkbox “I agree with the terms of service”
        Assert.assertEquals(shoppingCartPage.getTotalPriceText(), "$2,950.00", "error");
        shoppingCartPage.clickOnIAgreeCheckBox();
        // 2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertTrue(checkOutPage.getWelcomePleaseSignText().contains("Welcome, Please Sign In!"), "error");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        checkOutPage.clickOnCheckOutAsGuest();
        // 2.22 Fill the all mandatory field
        checkOutAsGuestPage.enterFirstName("prime");
        checkOutAsGuestPage.enterLastName("institute");
        checkOutAsGuestPage.enterEmailId("prime123@gmail.com");
        checkOutAsGuestPage.selectCountry("United Kingdom");
        checkOutAsGuestPage.enterCity("London");
        checkOutAsGuestPage.enterAddressField("Lewes road");
        checkOutAsGuestPage.enterPostalCode("N12 9NH");
        Thread.sleep(5);
        checkOutAsGuestPage.enterPhoneNumber("447782839999");
        //2.23 Click on “CONTINUE”
        checkOutAsGuestPage.clickOnContinueButton();
        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        shippingMethodPage.clickOnNextDayAirRadioButton();
        // 2.25 Click on “CONTINUE”
        shippingMethodPage.clickOnShippingMethodContinueButton();
        // 2.26 Select Radio Button “Credit Card”
        paymentMethodPage.clickOnCreditCardRadioButton();
        Thread.sleep(2000);
        paymentMethodPage.clickOnPaymentMethodContinueButton();
        // 2.27 Select “Master card” From Select credit card dropdown
        paymentInformationPage.selectCreditCardDropDown("Master card");
        // 2.28 Fill all the details
        paymentInformationPage.enterCardholderName("Ajay kumar");
        paymentInformationPage.enterCardNumber("5431 1111 1111 1111");
        paymentInformationPage.selectExpirationMonthDropDown("07");
        paymentInformationPage.selectExpirationYearDropDown("2025");
        paymentInformationPage.enterCardCode("544");
        // 2.29 Click on “CONTINUE”
        paymentInformationPage.clickOnPaymentInformationContinueButton();
        // 2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(confirmOrderPage.paymentMethodVerifyText(), "Credit Card", "error");
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(confirmOrderPage.shippingMethodVerifyText(), "Next Day Air", "error");
        // 2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(confirmOrderPage.totalAmountVerifyText(), "$2,950.00", "error");
        // 2.34 Click on “CONFIRM”
        confirmOrderPage.clickOnConfirmButton();
        // 2.35 Verify the Text “Thank You”
        Thread.sleep(6);
        //Assert.assertTrue(checkOutCompletedPage.getThankYouText().contains("Thank You"), "error");
        // 2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertTrue(checkOutCompletedPage.getYourOrderHasProcessedText().contains( "Your order has been successfully processed!"), "error");
        // 2.37 Click on “CONTINUE”
        checkOutCompletedPage.clickOnCheckoutCompletedContinueButton();
        // 2.37 Verify the text “Welcome to our store
        Assert.assertTrue(homePage.getWelcomeToTheStoreText().contains( "Welcome to our store"), "error");

    }


}

