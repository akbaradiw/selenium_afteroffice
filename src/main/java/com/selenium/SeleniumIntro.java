package com.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumIntro {
    static WebDriver driver; // Gunakan satu instance driver

    public static void main(String[] args) throws InterruptedException {
        // Set driver hanya sekali
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Jalankan semua metode
        radioButton();
        alertExample();
        checkBox();
        windowExample();
        tabExample();
        hideShow();
        dropdDownExp();
        fourButtons();
        webTableExample();



        // Tutup browser setelah selesai
        // driver.quit();
    }

    public static void radioButton() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@value='radio2']")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@value='radio3']")).click();
        Thread.sleep(300);


        
    }

    public static void alertExample() throws InterruptedException {
      driver.findElement(By.id("name")).sendKeys("wowo");
      Thread.sleep(300);
      driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().accept();
      Thread.sleep(300);
      driver.findElement(By.id("confirmbtn")).click();
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().dismiss();
      Thread.sleep(300);
    }

    public static void checkBox() throws InterruptedException {
        WebElement optionOne = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        optionOne.click();
        Thread.sleep(300);
        WebElement optionTwo = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        optionTwo.click();
        Thread.sleep(300);
        WebElement optionThree = driver.findElement(By.xpath("//input[@id='checkBoxOption3']"));
        optionThree.click();
        Thread.sleep(300);
    }

    public static void windowExample() throws InterruptedException {
      WebElement openWindow = driver.findElement(By.id("openwindow"));
      openWindow.click();
      Thread.sleep(300);
  
      Set<String> windows = driver.getWindowHandles();
      Iterator<String> iterator = windows.iterator();
  
      String parentId = iterator.next();
      if (iterator.hasNext()) {
          String childId = iterator.next();
          driver.switchTo().window(childId);
          
          System.out.println("Berpindah ke jendela baru: " + driver.getTitle());
  
          driver.close();
          driver.switchTo().window(parentId);
      } else {
          System.out.println("Tidak ada jendela baru yang terbuka.");
      }
      Thread.sleep(450);
  }
  

    public static void tabExample() throws InterruptedException {
      WebElement openTab = driver.findElement(By.id("opentab"));
      openTab.click();
      Thread.sleep(300);

      Set<String> windows = driver.getWindowHandles();
      Iterator<String> iterator = windows.iterator();

      String parentId = iterator.next();
      String childId = iterator.next();

      driver.switchTo().window(childId);
      Thread.sleep(300);
      driver.switchTo().window(parentId);
      Thread.sleep(410);
    }

    public static void hideShow() throws InterruptedException {
      WebElement hideButton = driver.findElement(By.id("hide-textbox"));
      hideButton.click();
      Thread.sleep(300);
      WebElement showButton = driver.findElement(By.id("show-textbox"));
      showButton.click();
      Thread.sleep(300);
      WebElement showTextbox = driver.findElement(By.id("displayed-text"));
      showTextbox.sendKeys("ganyang fufufafa"); 
      Thread.sleep(300);
    }

  public static void dropdDownExp() throws InterruptedException {
    WebElement optioneOne = driver.findElement(By.id("dropdown-class-example")); 
    Select dropdown = new Select(optioneOne);
    dropdown.selectByValue("option1");
    Thread.sleep(300);

   WebElement optioneTwo = driver.findElement(By.id("dropdown-class-example")); 
   Select dropdown2 = new Select(optioneTwo);
   dropdown2.selectByValue("option2"); 
   Thread.sleep(300);

   WebElement optioneThree = driver.findElement(By.id("dropdown-class-example")); 
   Select dropdown3 = new Select(optioneThree);
   dropdown3.selectByValue("option3");  
   Thread.sleep(300);
}

public static void webTableExample() {
  WebElement webTable = driver.findElement(By.id("product"));
		
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());
		
		List<WebElement> tableColumns = webTable.findElements(By.tagName("th"));
		System.out.println(tableColumns.size());
		
		List<WebElement> secondRowDataList = tableRows.get(4).findElements(By.tagName("td"));
		for(WebElement column : secondRowDataList) {
			System.out.println(column.getText());
    }
}

public static void fourButtons () throws InterruptedException {
  WebElement practiceButton = driver.findElement(By.xpath("//button[normalize-space()='Practice']"));
  practiceButton.click();
  System.out.println("practice"+practiceButton); 
  Thread.sleep(300);

  WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
  loginButton.click();
  System.out.println("login"+loginButton); 
  Thread.sleep(300);
  
  WebElement signupButton =   driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
  signupButton.click();
  System.out.println("signup"+signupButton); 
  Thread.sleep(300);

  WebElement homeButton = driver.findElement(By.xpath("//button[normalize-space()='Home']"));
  homeButton.click();
  Thread.sleep(300);
}

    
}
