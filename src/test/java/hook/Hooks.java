package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    public static WebDriver driver;

    // @Before
    // public void setupAutomation() throws IOException {
    //     Properties properties = new Properties();
    //     FileInputStream fileInputStream = new FileInputStream("D:\\QA\\selenium1\\selenium\\src\\main\\resources\\GlobalData.properties");
    //     properties.load(fileInputStream);
    //     String browserName = properties.getProperty("browser");

    //     if (browserName.equalsIgnoreCase("chrome")) {
    //         WebDriverManager.chromedriver().setup();
    //         driver = new ChromeDriver();
    //     } else if (browserName.equalsIgnoreCase("firefox")) {
    //         WebDriverManager.firefoxdriver().setup();
    //         driver = new FirefoxDriver();
    //     } else {
    //         throw new IllegalArgumentException("Browser not supported: " + browserName);
    //     }

    //     driver.manage().window().maximize();
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //     driver.get("https://www.saucedemo.com/v1/");

    //     // Explicit Wait - Tunggu elemen login muncul
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))); 
    // }

    // // @After
    // // public void tearDownAutomation() {
    // //     if (driver != null) {
    // //         driver.quit(); // Gunakan quit() untuk menutup browser sepenuhnya
    // //     }
    // // }

    // public static WebDriver initializeDriver() {
    //     if (driver == null) {
    //         throw new IllegalStateException("WebDriver is not initialized. Ensure @Before is executed.");
    //     }
    //     return driver;
    // }

    @Before
public void setupAutomation() throws IOException {
    Properties properties = new Properties();
    FileInputStream fileInputStream = new FileInputStream("D:\\QA\\selenium1\\selenium\\src\\main\\resources\\GlobalData.properties");

    properties.load(fileInputStream);
    String browserName = properties.getProperty("browser");

    if (browserName.equals("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } else {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://www.saucedemo.com/v1/");
    System.out.println("WebDriver initialized and navigated to login page.");
}

public static WebDriver initializeDriver() {
    return driver;
}
}
