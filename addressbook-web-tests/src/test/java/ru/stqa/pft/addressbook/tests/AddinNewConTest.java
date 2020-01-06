package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {
    app.getContactHelper().createContact(new ContactData("Anna",null,null,null,"344546",null),false);
  }
}
