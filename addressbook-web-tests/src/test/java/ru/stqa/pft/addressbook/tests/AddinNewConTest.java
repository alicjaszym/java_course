package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {
    int before = app.getContactHelper().getCountactCount();
    app.getContactHelper().createContact(new ContactData("Anna",null,null,null,"344546",null),false);
    int after = app.getContactHelper().getCountactCount();
    Assert.assertEquals(after, before + 1);
  }
}
