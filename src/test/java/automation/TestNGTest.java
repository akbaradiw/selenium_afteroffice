package automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pageobject.CartPage;
import com.selenium.pageobject.CheckoutPage;
import com.selenium.pageobject.ConfirmationPage;
import com.selenium.pageobject.LoginPage;
import com.selenium.pageobject.ProductPage;

public class TestNGTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\kodingan sendiri\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/");

    }

    @Test
    public void checkoutProduct () {

        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication("standard_user", "secret_sauce");

         
        // List Produk
        String productName = "Test.allTheThings() T-Shirt (Red)";
        ProductPage productPage = new ProductPage(driver);

        productPage.addProductToCart(productName);

        // view cart
        CartPage cartPage = new CartPage(driver);
        cartPage.viewCart();
        cartPage.proceedToCheckout();
        
        // checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstName("Tan");
        checkoutPage.inputLastName("Malaka");
        checkoutPage.inputPostalCode("666");
        checkoutPage.clickContinue();
        checkoutPage.finishCheckout();

        // confirmation
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getThanksMessage(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(confirmationPage.getPonyExpress(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}






