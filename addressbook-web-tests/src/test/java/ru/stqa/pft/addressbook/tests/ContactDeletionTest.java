package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().clickOnHome();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData(null,"Anna", "Ma", "Dee", "Ra", "344546", null), false);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickOnContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().clickOnHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}