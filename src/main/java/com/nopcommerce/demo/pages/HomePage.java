package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    // Topmenu Test
    By allMenu = By.xpath("//ul[@class='top-menu notmobile']//li//a");

    //Computer Test
    By computerTab = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    By desktopsTab = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']");
    By welcomeToTheStoreText = By.xpath("//h2[contains(text(),'Welcome to our store')]");

    //Electronics Test
    By electronicsTab = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
    By cellPhonesTab = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");
    By logoutLink = By.xpath("//a[contains(text(),'Log out')]");

    //Top menu test
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(allMenu);
        try {
            for (WebElement list : topMenuList) {
                if (list.getText().contains(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(allMenu);
        }
    }

    //Computer test
    public void clickOnDesktopsSubTab() {
        mouseHoverToElementAndClick(desktopsTab);
    }

    public void mouseHoverOnComputerMenu() {
        mouseHoverToElement(computerTab);
    }

    public String getWelcomeToTheStoreText() {
        return getTextFromElement(welcomeToTheStoreText);
    }

    //Electronic test
    public void clickOnElectronicsTab() {
        mouseHoverToElement(electronicsTab);
    }

    public void mouseHoverAndClickOnCellPhones() {
        mouseHoverToElementAndClick(cellPhonesTab);
    }

    public void clickOnLogoutLink() {
        clickOnElement(logoutLink);
    }

}
