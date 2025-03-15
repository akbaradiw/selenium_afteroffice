package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOut {

    WebDriver driver;

    public SignOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="bm-burger-button")
    private WebElement menuButton;

    @FindBy(id="logout_sidebar_link")
    private WebElement signOutButton;

    public void clickSignOutButton() {
        menuButton.click();
        signOutButton.click();
    }

}
