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

    public static void radioButton() {
        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        driver.findElement(By.xpath("//input[@value='radio2']")).click();
        driver.findElement(By.xpath("//input[@value='radio3']")).click();
    }

    public static void alertExample() {
      driver.findElement(By.id("name")).sendKeys("wowo");
      driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().accept();
      driver.findElement(By.id("confirmbtn")).click();
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().dismiss();
    }

    public static void checkBox() {
        WebElement optionOne = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        optionOne.click();
        WebElement optionTwo = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        optionTwo.click();
        WebElement optionThree = driver.findElement(By.xpath("//input[@id='checkBoxOption3']"));
        optionThree.click();
    }

    public static void windowExample() {
      WebElement openWindow = driver.findElement(By.id("openwindow"));
      openWindow.click();
  
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
  }
  

    public static void tabExample() {
      WebElement openTab = driver.findElement(By.id("opentab"));
      openTab.click();
      Set<String> windows = driver.getWindowHandles();
      Iterator<String> iterator = windows.iterator();

      String parentId = iterator.next();
      String childId = iterator.next();

      driver.switchTo().window(childId);
      driver.switchTo().window(parentId);
    }

    public static void hideShow() {
      WebElement hideButton = driver.findElement(By.id("hide-textbox"));
      hideButton.click();
      WebElement showButton = driver.findElement(By.id("show-textbox"));
      showButton.click();
      WebElement showTextbox = driver.findElement(By.id("displayed-text"));
      showTextbox.sendKeys("ganyang fufufafa"); 
    }

  public static void dropdDownExp() {
    WebElement optioneOne = driver.findElement(By.id("dropdown-class-example")); 
    Select dropdown = new Select(optioneOne);
    dropdown.selectByValue("option1");

   WebElement optioneTwo = driver.findElement(By.id("dropdown-class-example")); 
   Select dropdown2 = new Select(optioneTwo);
   dropdown2.selectByValue("option2"); 

   WebElement optioneThree = driver.findElement(By.id("dropdown-class-example")); 
   Select dropdown3 = new Select(optioneThree);
   dropdown3.selectByValue("option3");  
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

public static void fourButtons() {
  driver.findElement(By.xpath("//button[normalize-space()='Practice']")).click();
  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
  driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
  WebElement homeButton = driver.findElement(By.xpath("//button[normalize-space()='Home']"));
  homeButton.click();
}

    
}
