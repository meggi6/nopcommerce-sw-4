package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    By sortByDropDown = By.xpath("//select[@id='products-orderby']");
    By addToCartButton = By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");
    By listOfProducts = By.xpath("//div[@class='item-grid']//div[@class='details']//a");
    By sortPositionNameAscendingOrder = By.name("products-orderby");

    public List<String> clickOnSortByPosition (String option) throws InterruptedException {
        selectByVisibleTextFromDropDown(sortByDropDown, option);

        Thread.sleep(2000);
        List<WebElement> afterApplyingZtoA = driver.findElements(listOfProducts);
        List<String> inDescendingOrder = new ArrayList<>();
        for (WebElement productsAfterSort : afterApplyingZtoA) {
            inDescendingOrder.add(productsAfterSort.getText());
        }
        return inDescendingOrder;
    }

    public List<String> productsArrangeInReverseOrder()  {
        List<WebElement> productElements = driver.findElements(listOfProducts);

        List<String> reverseProductNames = new ArrayList<>();
        for (WebElement e : productElements) {
            reverseProductNames.add(e.getText());
        }
        System.out.println(reverseProductNames);
        Collections.sort(reverseProductNames, Collections.reverseOrder());
        System.out.println(reverseProductNames);
        return reverseProductNames;

    }

    public void selectSortPositionNameAscendingOrder(String text){
        selectByVisibleTextFromDropDown(sortPositionNameAscendingOrder, text);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }


}
