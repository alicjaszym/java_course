package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class testContactEmail extends TestBase {
  @Test
  public void emailTest(){
   app.contact().clickOnHome();
  ContactData contact= app.contact().all().iterator().next();
    if (app.contact().all().size()==0) {
    app.contact().create(new ContactData().withFirstName("Anna").withLastName("Dee").withEmail("lololo@yopmail.com"), true);
  }
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  assertThat(contact.getEmail(), equalTo((contactInfoFromEditForm.getEmail())));


  }
}
