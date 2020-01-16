package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().clickOnHome();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("An",null,"Vanijja",null,null,null),false);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Jo",null,"Vanilla",null,null,null);
    app.getContactHelper().addNewContact(contact,false) ;
    app.getContactHelper().clickOnUpdateButton();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId =(c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
