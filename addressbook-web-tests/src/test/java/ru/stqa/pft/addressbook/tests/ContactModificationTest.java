package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().clickOnHome();
    app.getContactHelper().editContact();
    app.getContactHelper().addNewContact(new ContactData("Anna","Ma","Dee","Ra","344546"));
    app.getContactHelper().clickOnUpdateButton();
  }
}
