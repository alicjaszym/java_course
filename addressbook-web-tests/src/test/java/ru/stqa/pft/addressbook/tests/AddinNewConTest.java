package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddinNewConTest extends TestBase {

  @Test
  public void addingNewContact() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Mo",null,"Bunilla",null,null,null);
    app.contact().create(contact,false);
    List<ContactData> after = app.contact().list();
    System.out.println( after);
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId =(c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
