package com.selenium.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 @FindBy(id = "user-name")
 private WebElement userName;

 @FindBy(id = "password")
 private WebElement userPassword;

 @FindBy(id = "login-button")
 private WebElement loginButton;



public void loginApplication(String username, String password){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    // Menunggu hingga input username terlihat
    wait.until(ExpectedConditions.visibilityOf(userName));

    actions.moveToElement(userName).click().sendKeys(username).perform();
    actions.moveToElement(userPassword).click().sendKeys(password).perform();
    actions.moveToElement(loginButton).click().perform();
}

 public void clickLoginButton() {
     loginButton.click();
 }

}