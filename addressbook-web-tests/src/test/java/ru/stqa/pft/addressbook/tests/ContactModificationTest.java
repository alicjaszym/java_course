package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().clickOnHome();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData(null,"Anna",null,null,null,"344546",null),false);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Jo ",null,"Vanilla",null,"1212",null);
    app.getContactHelper().addNewContact(contact,false) ;
    app.getContactHelper().clickOnUpdateButton();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
