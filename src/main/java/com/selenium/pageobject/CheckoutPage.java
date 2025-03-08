package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(css = "input[value='CONTINUE']")
    private WebElement continueButton;

    @FindBy (css =".btn_action.cart_button")
    private WebElement finishButton;

    public void inputFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void inputLastName(String name) {
        lastName.sendKeys(name);
    }

    public void inputPostalCode(String name) {
        postalCode.sendKeys(name);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }
}
