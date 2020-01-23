package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {



    app.contact().initContactCreation();
    File photo= new File("src/test/resources/bo.jpg");
    app.contact().fillContactForm(new ContactData().withFirstName("lo").withLastName("NO").withPhoto(photo),true);
    app.contact().clickSubmitContactCreation();
    app.contact().clickOnHome();




  }


}
