package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   WebDriver wd;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin","secret");
  }

  public void login(String username, String passoword) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(passoword);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void goBackToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void fillTheForm(GropupData gropupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(gropupData.getName());
    wd.findElement(By.name("group_header")).clear();

    wd.findElement(By.name("group_header")).sendKeys(gropupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(gropupData.getFooter());
    wd.findElement(By.name("submit")).click();
  }

  public void initCase() {
    wd.findElement(By.name("new")).click();
  }

  public void goToCase() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteSelectedGroup() {
    wd.findElement(By.name("delete")).click();
  }

  public void stop() {
    wd.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
