package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.selenium.pageobject.CartPage;
import com.selenium.pageobject.CheckoutPage;
import com.selenium.pageobject.ConfirmationPage;
import com.selenium.pageobject.LoginPage;
import com.selenium.pageobject.ProductPage;
import com.selenium.pageobject.SignOut;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {
    
    WebDriver driver;

    @Given ("User landing to ecommerce")
    public void landingPage() throws IOException{
        driver=Hooks.initializeDriver();
    }

  
    @Given("^User Logged to website with username (.+) and password (.+)$")
    public void userLogin( String username, String password) {
    if (driver == null) {
        System.out.println("Driver is null. Initializing driver...");
        driver = Hooks.initializeDriver();
    }
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginApplication( username, password);
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

@And ("User checkout item and input first name {string} last name {string} and postal code {string}")
    public void checkoutItem( String first_name, String last_name, String postal_code) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstName(first_name);
        checkoutPage.inputLastName(last_name);
        checkoutPage.inputPostalCode(postal_code);
        checkoutPage.clickContinue();
        checkoutPage.finishCheckout();
    }

@And ("User Click Continue Button")
    public void clickContinue(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinue();
    }


@Then("User will see message is displayed on confirmation page")
    public void confirmationPage() {
    ConfirmationPage confirmationPage = new ConfirmationPage(driver);

    String actualThanksMessage = confirmationPage.getThanksMessage();

    System.out.println("Actual Thanks Message: " + actualThanksMessage);

    Assert.assertEquals(actualThanksMessage, "THANK YOU FOR YOUR ORDER");
}

@Then ("User Logout from website")
public void logout(){
  SignOut signOut = new SignOut(driver);
  signOut.clickSignOutButton();

  Assert.assertEquals(driver.getTitle(), "Swag Labs");
}

@Then("User Then User will see error message")
public void errorMessage() {
    ConfirmationPage confirmationPage = new ConfirmationPage(driver);
    String actualErrorMessage = confirmationPage.getErrorAlert();
    Assert.assertEquals(actualErrorMessage, "Error: Postal Code required");
}

}