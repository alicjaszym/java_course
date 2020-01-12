package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().clickOnHome();
    int before = app.getContactHelper().getCountactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Anna",null,null,null,"344546",null),false);
    }
    app.getContactHelper().editContact();
    app.getContactHelper().addNewContact(new ContactData("Jo ",null,null,null,"1212",null),false) ;
    app.getContactHelper().clickOnUpdateButton();
    int after = app.getContactHelper().getCountactCount();
    Assert.assertEquals(after, before);
  }
}
