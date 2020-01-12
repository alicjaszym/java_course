package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().clickOnHome();
    int before = app.getContactHelper().getCountactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Anna","Ma","Dee","Ra","344546",null),false);
    }
    app.getContactHelper().clickOnContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().clickOnHome();
    int after = app.getContactHelper().getCountactCount();
    Assert.assertEquals(after, before - 1);
  }
}
