package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddinNewCon {
  private WebDriver driver;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void addingNewContact() throws Exception {
    driver.get("http://localhost/addressbook/edit.php");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Joe");
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys("May");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Doe");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("Malarska");
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("123456");
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::td[2]")).click();
    driver.findElement(By.id("2")).click();
    driver.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();

    }


  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
