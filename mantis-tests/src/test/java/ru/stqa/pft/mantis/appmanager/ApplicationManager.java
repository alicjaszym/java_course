package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  private final String browser;
  private WebDriver wd;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }


  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public HttpSession newSession(){
    return new HttpSession(this);
  }

  public String getProperty(String key){
    return properties.getProperty(key);
  }

  public FtpHelper ftp(){
    if (ftp==null){
      ftp =new FtpHelper(this);
    }
   return ftp;
  }


  public RegistrationHelper registration() {
   if(registrationHelper==null){
     registrationHelper = new RegistrationHelper(this);
   }
    return registrationHelper ;
  }

  public WebDriver getDriver() {
    if(wd ==null){

      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      } else if (browser.equals(BrowserType.EDGE)) {
        wd = new EdgeDriver();
      }
     wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

public MailHelper mail() {
  if (mailHelper == null) {
    mailHelper = new MailHelper(this);
  }
  return mailHelper;
}

}
