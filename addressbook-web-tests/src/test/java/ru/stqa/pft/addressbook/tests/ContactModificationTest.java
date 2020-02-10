package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws IOException {
    if (app.db().groups().size()==0) {
      app.contact().clickOnHome();
      app.contact().create(new ContactData().withFirstName("An").withLastName("Vanilla"), false);
    }
  }

  @Test
  public void testContactModification() throws IOException {
    Contacts before = app.db().contacts();
    ContactData modifiedContact= before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("lo").withLastName("NO");
    app.contact().clickOnHome();
    app.contact().modify( contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
