package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private WebElement removeButton;

    public void viewCart() {
        cartButton.click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public void removeItemFromCart() {
        removeButton.click();
    }
}
