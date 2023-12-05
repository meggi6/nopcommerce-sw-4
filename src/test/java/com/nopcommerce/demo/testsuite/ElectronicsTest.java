package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ElectronicsTest extends BaseTest {
    String email;
    HomePage homePage = new HomePage();
    CellPhonesPage cellPhonePage = new CellPhonesPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    RegisterPage registerPage = new RegisterPage();
    ShippingMethodPage shippingMethodPage = new ShippingMethodPage();
    PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
    PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
    CheckOutCompletedPage checkOutCompletedPage = new CheckOutCompletedPage();
    CheckOutAsGuestPage checkOutAsGuestPage = new CheckOutAsGuestPage();


    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        homePage.clickOnElectronicsTab();
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhones();
        //1.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = cellPhonePage.verifyCellPhonesText();
        Assert.assertEquals(actualMessage, expectedMessage, "Invalid Text");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //2.1 Mouse Hover on “Electronics” Tab
        homePage.clickOnElectronicsTab();
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhones();
        //2.3 Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = cellPhonePage.verifyCellPhonesText();
        Assert.assertEquals(actualMessage, expectedMessage, "Invalid Text");
        //2.4 Click on List View Tab
        cellPhonePage.clickOnListViewTab();
        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        cellPhonePage.clickOnNokiaLumiaCellPhone();
        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedNokiaMessage = "Nokia Lumia 1020";
        String actualNokiaMessage = productPage.verifyNokiaLumia1020();
        Assert.assertEquals(actualNokiaMessage, expectedNokiaMessage, "Invalid Text");
        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = productPage.verifyPriceOfNokiaLumia();
        Assert.assertEquals(actualPrice, expectedPrice, "Invalid Text");
        //2.8 Change quantity to 2
        productPage.changeTheQty("2");
        //2.9 Click on “ADD TO CART” tab
        productPage.addToCartNokiaLumiaCellPhone();
        //2.10 Verify the Message "The product has been added to your shopping cart"
        String expectedProduct = "The product has been added to your shopping cart";
        String actualProduct = productPage.verifyTheCartMassage();
        Assert.assertEquals(actualProduct, expectedProduct, "Invalid Text");
        //After that close the bar clicking on the cross button.
        productPage.clickOnCrossButton();
        Thread.sleep(2000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        productPage.mouseHoverOnShoppingCartLinkAndClick();
        Thread.sleep(2000);
        //2.12 Verify the message "Shopping cart"
        String expectedCart = "Shopping cart";
        String actualCart = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualCart, expectedCart, "Invalid Text");
        Thread.sleep(2000);
        //2.13 Verify the quantity is 2
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdateShoppingCartButton();
        Thread.sleep(2000);
        //2.14 Verify the Total $698.00
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = shoppingCartPage.getTotalPriceText();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Price Not Match");
        Thread.sleep(2000);
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnIAgreeCheckBox();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText = "Welcome, Please Sign In!";
        String actualText = checkOutPage.getWelcomePleaseSignText();
        Assert.assertEquals(actualText, expectedText, "Invalid Text");
        Thread.sleep(2000);
        //2.18 Click on “REGISTER” tab
        checkOutPage.clickOnRegisterButton();
        //2.19 Verify the text “Register”
        String expectedRegisterMessage = "Register";
        String actualRegisterMessage = registerPage.verifyRegisterTitle();
        Assert.assertEquals(actualRegisterMessage, expectedRegisterMessage, "Invalid Text");
        Thread.sleep(2000);
        //2.20 Fill the mandatory fields
        registerPage.enterFirstName("nishant");
        registerPage.enterLastName("kumar");
        registerPage.enterEmail("nishantkumar123@gmail.com");
        registerPage.enterPassword("anil@123");
        registerPage.enterConfirmPassword("anil@123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        String expectedResult = "Your registration completed";
        String actualResult = registerPage.verifyRegistrationMessage();
        Assert.assertEquals(actualResult, expectedResult, "Invalid Text");
        Thread.sleep(2000);
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueToShoppingCart();
        //2.24 Verify the text “Shopping cart”
        String expectedShoppingMessage = "Shopping cart";
        String actualShoppingMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingMessage, expectedShoppingMessage, "Invalid Text");
        Thread.sleep(5000);
        //Login again because cart is empty
        shoppingCartPage.clickOnLogInButton();
        checkOutPage.emailId("nishantkumar123@gmail.com");
        checkOutPage.password("anil@123");
        checkOutPage.clickOnLogInButton();
        //2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnIAgreeCheckBox();
        //2.26 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        //2.27 Fill the Mandatory fields
        checkOutAsGuestPage.enterFirstName("anil");
        checkOutAsGuestPage.enterLastName("kumar");

        //3.5 Enter Email
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        checkOutAsGuestPage.enterEmailId(email);
        checkOutAsGuestPage.selectCountry("United Kingdom");
        checkOutAsGuestPage.enterCity("London");
        checkOutAsGuestPage.enterAddressField("Lewes Road");
        checkOutAsGuestPage.enterPostalCode("N12 9nh");
        checkOutAsGuestPage.enterPhoneNumber("+4478365766145");
        checkOutAsGuestPage.clickOnContinueButton();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        shippingMethodPage.clickOn2ndAirShippingMethod();
        //2.30 Click on “CONTINUE”
        shippingMethodPage.clickOnShippingMethodContinueButton();
        //2.31 Select Radio Button “Credit Card”
        paymentMethodPage.clickOnCreditCardRadioButton();
        Thread.sleep(2000);
        //2.32 Click on continue
        paymentMethodPage.clickOnPaymentMethodContinueButton();
        //2.34Fill all the details
        paymentInformationPage.selectCreditCardDropDown("Visa");
        paymentInformationPage.enterCardholderName("Anil Kumar");
        paymentInformationPage.enterCardNumber("5368392055488809");
        paymentInformationPage.selectExpirationMonthDropDown("05");
        paymentInformationPage.selectExpirationYearDropDown("2026");
        paymentInformationPage.enterCardCode("426");
        //2.35 Click on “CONTINUE”
        paymentInformationPage.clickOnPaymentInformationContinueButton();
        Thread.sleep(2000);
        //2.36 Verify “Payment Method” is “Credit Card”
        String expectedCredit = "Credit Card";
        String actualCredit = confirmOrderPage.paymentMethodVerifyText();
        Assert.assertEquals(actualCredit, expectedCredit, "Invalid Text");
        Thread.sleep(2000);
        //2.37 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMessage = "2nd Day Air";
        String actualShippingMessage = confirmOrderPage.verifySecondDayShippingMethod();
        Assert.assertEquals(actualShippingMessage, expectedShippingMessage, "Invalid Text");
        Thread.sleep(2000);
        //2.38 Verify Total is “$698.00”
        String expectedMessage9 = "$698.00";
        String actualMessage9 = confirmOrderPage.totalAmountVerifyText();
        Assert.assertEquals(actualMessage9, expectedMessage9, "Invalid Text");
        Thread.sleep(2000);
        //2.38 Click on “CONFIRM”
        confirmOrderPage.clickOnConfirmButton();
        //2.39 Verify the Text “Thank you”
        String expectedThankMessage = "Thank you";
        String actualThankMessage = checkOutCompletedPage.getThankYouText();
        Assert.assertEquals(actualThankMessage, expectedThankMessage, "Invalid Text");
        Thread.sleep(2000);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedOrderMessage = "Your order has been successfully processed!";
        String actualOrderMessage = checkOutCompletedPage.getYourOrderHasProcessedText();
        Assert.assertEquals(actualOrderMessage, expectedOrderMessage, "Invalid Text");
        Thread.sleep(2000);
        //2.37 Click on “CONTINUE”
        checkOutCompletedPage.clickOnCheckoutCompletedContinueButton();
        //2.37 Verify the text “Welcome to our store”
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = homePage.getWelcomeToTheStoreText();
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Invalid Text");
        Thread.sleep(2000);
        //2.38 Click on “Logout” link
        homePage.clickOnLogoutLink();



    }
}
