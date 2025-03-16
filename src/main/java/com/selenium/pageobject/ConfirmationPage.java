package com.selenium.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    @FindBy (className="error-button")
    private WebElement errorAlert;


    public String getThanksMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(thanksMessage));
        return thanksMessage.getText().trim();
    }

public String getPonyExpress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ponyExpress));
        return ponyExpress.getText().trim();
    }

public String getErrorAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        return errorAlert.getText().trim();
    }


}
