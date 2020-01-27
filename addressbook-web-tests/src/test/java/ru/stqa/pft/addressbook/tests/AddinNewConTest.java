package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddinNewConTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
  // list.add(new Object[]{new ContactData().withFirstName("firstname1").withLastName("lastname1").withPhone("phone1")});
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
     String [] split = line.split(";");
     list.add(new Object[]{new ContactData().withFirstName(split[0]).withLastName(split[1]).withPhone(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }



    @Test(dataProvider = "validContacts")
  public void addingNewContact(ContactData contact) throws Exception {

        app.contact().initContactCreation();
        File photo = new File("src/test/resources/bo.jpg");
        app.contact().fillContactForm(new ContactData().withFirstName("lo").withLastName("NO").withPhone("123465"), false);
        app.contact().clickSubmitContactCreation();
        app.contact().clickOnHome();
      }


 // @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo= new File("src/test/resources/bo.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
