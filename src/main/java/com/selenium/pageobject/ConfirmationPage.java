package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ConfirmationPage {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "complete-header")
    private WebElement thanksMessage;

    @FindBy (className="pony_express")
    private WebElement ponyExpress;

    public String getThanksMessage() {
        return thanksMessage.getText();
    }

    public String getPonyExpress() {
        return ponyExpress.getText();
    }

}
