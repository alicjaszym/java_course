package ru.stqa.pft.mantis.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;

public class TestBase {

  // protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
  protected static final ApplicationManager app = new ApplicationManager(System.getProperty(
          "browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop();
  }
}




