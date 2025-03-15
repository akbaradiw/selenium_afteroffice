package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    public static WebDriver driver;

    @Before
    public void setupAutomation() throws IOException{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\kodingan sendiri\\web_auto\\selenium_afteroffice\\src\\main\\resources\\GlobalData.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")){
 

            System.setProperty("webdriver.chrome.driver", "D:\\kodingan sendiri\\chromedriver-win64\\chromedriver.exe");
            // WebDriverManager.chromedriver().setup();
            driver =  new ChromeDriver();
        } else {
            // Driver firefox
            System.setProperty("webdriver.gecko.driver", "D:\\QA\\chromedriver-win64\\geckodriver.exe");
            driver =  new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDownAutomation() {
        if (driver != null) {
            driver.close();
        }
    }

    public static WebDriver initializeDriver (){
        return driver;
    }

}
