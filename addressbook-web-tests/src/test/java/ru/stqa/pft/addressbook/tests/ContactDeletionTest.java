package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().clickOnHome();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("Anna").withLastName("Dee").withPhone("32322"), false);
    }
  }


  @Test
  public void testContactDeletion() {

   Contacts before = app.contact().all();
   ContactData deletedContact= before.iterator().next();
    app.contact().delete(deletedContact );
    Contacts after = app.contact().all();
    assertEquals(after.size(),before.size() -1);
    assertThat(after, equalTo(before.without(deletedContact)));

  }
}