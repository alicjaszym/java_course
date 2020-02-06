package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws IOException {
    app.contact().clickOnHome();
    if (app.contact().alll().size()==0) {
      app.contact().create(new ContactData().withFirstName("Anna").withLastName("Dee").withPhone("32322"), false);
    }
  }


  @Test
  public void testContactDeletion() {

   Contacts before = app.db().contacts();
   ContactData deletedContact= before.iterator().next();
    app.contact().delete(deletedContact );
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();;
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}