package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhone(){
    app.contact().clickOnHome();
    ContactData deletedContact= app.contact().all().iterator().next();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("Anna").withLastName("Dee").withPhone("32322"), false);
    }
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
