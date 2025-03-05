package com.selenium.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));


        // List Produk
        List<WebElement> listProduct = driver.findElements(By.className("inventory_item"));

        String productName = "Test.allTheThings() T-Shirt (Red)";

        WebElement product = listProduct.stream()
            .filter(prod -> prod.findElement(By.className("inventory_item_name")).getText().equals(productName))
            .findFirst()
            .orElse(null);

        if (product != null) {
            product.findElement(By.tagName("button")).click();
            System.out.println("Produk berhasil ditambahkan ke keranjang!");
        } else {
            System.out.println("Produk tidak ditemukan!");
            driver.quit();
            return;
        }

        // View Cart
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        viewCart.click();

        // Checkout
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.checkout_button"))).click();

        // Isi Form Checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Carmen");
        driver.findElement(By.id("last-name")).sendKeys("Hearts2Hearts");
        driver.findElement(By.id("postal-code")).sendKeys("666");
        Thread.sleep(600);


        // Checkout Continue
        driver.findElement(By.cssSelector("input[value='CONTINUE']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("summary_info")));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.cart_button"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pony_express")));

        System.out.println("Checkout selesai!");
        
        driver.quit();
    }
}
