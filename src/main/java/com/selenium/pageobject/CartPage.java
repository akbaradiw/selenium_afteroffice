package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tunggu hingga 10 detik
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private WebElement removeButton;

    public void viewCart() {
        wait.until(ExpectedConditions.visibilityOf(cartButton)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton)).click();
    }

    public void removeItemFromCart() {
        wait.until(ExpectedConditions.visibilityOf(removeButton)).click();
    }

}
