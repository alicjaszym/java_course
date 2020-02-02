package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestContactAddress extends TestBase {




    @Test
    public void contactTest() throws IOException {
      app.contact().clickOnHome();
      ContactData contact = app.contact().all().iterator().next();
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData().withFirstName("Anna").withLastName("Dee").withStreet("czekoladowa 12/2"), true);
      }
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      assertThat(contact.getStreet(), equalTo((contactInfoFromEditForm.getStreet())));
    }
  }




