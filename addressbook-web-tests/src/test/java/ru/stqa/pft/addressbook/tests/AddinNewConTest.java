package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {
    app.getContactHelper().clickOnAddNew();
    app.getContactHelper().addNewContact(new ContactData("Joe","May","Doe","Malarksa","144546", "test1"),true);
    app.getContactHelper().clickSubmitContactCreation();
    app.getContactHelper().clickOnContactTable();
    app.logout();
  }
}
