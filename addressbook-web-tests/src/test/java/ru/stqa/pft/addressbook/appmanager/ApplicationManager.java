package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;
  WebDriver wd;

  public ApplicationManager(String browser) {
    this.browser=browser;
  }

  public void init() {

    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
      } else if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
      }
      else if(browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
      }
      else if(browser.equals(BrowserType.EDGE)) {
        wd = new EdgeDriver();
      }

    wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin","secret");
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
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


  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact(){
    return contactHelper;
  }

}
