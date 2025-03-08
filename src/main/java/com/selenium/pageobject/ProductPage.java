package com.selenium.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // List produk berdasarkan class name
    @FindBy(className = "inventory_item_name")
    private List<WebElement> listProduct;

    public List<WebElement> getListProduct() {
        return listProduct;
    }

    // Metode untuk mendapatkan tombol "Add to Cart" berdasarkan nama produk
    public WebElement getAddToCartButton(String productName) {
        String xpath = "//div[contains(text(),'" + productName + "')]/ancestor::div[@class='inventory_item']//button";
        return driver.findElement(By.xpath(xpath));
    }

    // Metode untuk menambahkan produk ke keranjang berdasarkan nama produk
    public void addProductToCart(String productName) {
        WebElement addToCartBtn = getAddToCartButton(productName);
        addToCartBtn.click();
    }
}
