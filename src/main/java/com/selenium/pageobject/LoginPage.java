package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

 public void loginApplication(String username, String password) {
     userName.sendKeys(username);
     userPassword.sendKeys(password);
     loginButton.click();
 }

 public void clickLoginButton() {
     loginButton.click();
 }

}