package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.selenium.pageobject.CartPage;
import com.selenium.pageobject.CheckoutPage;
import com.selenium.pageobject.ConfirmationPage;
import com.selenium.pageobject.LoginPage;
import com.selenium.pageobject.ProductPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {
    
    WebDriver driver;

    // @Given ("User landing to ecommerce")
    // public void landingPage() {
    //     System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
    //     driver = new ChromeDriver();

    //     driver.get("https://www.saucedemo.com/v1/");
    // 

    @Given ("User landing to ecommerce")
    public void landingPage() throws IOException{
        driver=Hooks.initializeDriver();

    }

    @Given ("User Logged to website")
    public void userLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication("standard_user", "secret_sauce");
    }

  

    @When ("User add item to Cart")
    public void addCart(){
         String productName = "Test.allTheThings() T-Shirt (Red)";
        ProductPage productPage = new ProductPage(driver);
        
        productPage.addProductToCart(productName);
        
        CartPage cartPage = new CartPage(driver);
        cartPage.viewCart();
        cartPage.proceedToCheckout();
    }

    @And ("User checkout item")
    public void checkoutItem(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstName("Tan");
        checkoutPage.inputLastName("Malaka");
        checkoutPage.inputPostalCode("666");
        checkoutPage.clickContinue();
        checkoutPage.finishCheckout();
    }

    @Then ("User will see message is displayed on confirmation page")
    public void confirmationPage(){
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getThanksMessage(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(confirmationPage.getPonyExpress(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}