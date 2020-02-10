package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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

  public void verifyContactListInUI() throws IOException {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().alll();
      MatcherAssert.assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> {
                        try {
                          return new ContactData().withId(g.getId()).withFirstName(g.getFirstName()).withLastName(g.getLastName());
                        } catch (IOException e) {
                          e.printStackTrace();
                        }
                        return g;
                      }
              )
              .collect(Collectors.toSet())));
    }
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      MatcherAssert.assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
    }
  }
}




