package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.selenium.pageobject.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    
    private static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/v1/");
    }

    @Given("User logged into the website")
    public void userLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication("standard_user", "secret_sauce");
    }

    @When("User adds an item to the cart")
    public void addCart(){
        String productName = "Test.allTheThings() T-Shirt (Red)";
        ProductPage productPage = new ProductPage(driver);
        
        productPage.addProductToCart(productName);
        
        CartPage cartPage = new CartPage(driver);
        cartPage.viewCart();
        cartPage.proceedToCheckout();
    }

    @And("User checks out the item")
    public void checkoutItem(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstName("Tan");
        checkoutPage.inputLastName("Malaka");
        checkoutPage.inputPostalCode("666");
        checkoutPage.clickContinue();
        checkoutPage.finishCheckout();
    }

    @Then("User will see a confirmation message")
    public void confirmationPage(){
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getThanksMessage(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(confirmationPage.getPonyExpress(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
