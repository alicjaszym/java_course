package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Mo").withLastName("Bunilla");
    app.contact().create(contact,false);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    System.out.println( after);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

  @Test
  public void addingNewContactBad() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Mo'").withLastName("Bunilla");
    app.contact().create(contact,false);
    assertThat(app.contact().count(), equalTo(before.size() ));
    Contacts after = app.contact().all();
    System.out.println( after);
    assertThat(after, equalTo(
            before));
  }
}
