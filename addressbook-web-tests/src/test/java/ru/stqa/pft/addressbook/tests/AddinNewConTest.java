package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
import java.util.stream.Collectors;

public class AddinNewConTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
  // list.add(new Object[]{new ContactData().withFirstName("firstname1").withLastName("lastname1").withMobilePhone("phone1")});
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml ="";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contact =(List<ContactData>)xstream.fromXML(xml);
    return contact.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }


  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    // list.add(new Object[]{new ContactData().withFirstName("firstname1").withLastName("lastname1").withMobilePhone("phone1")});
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json ="";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts =gson.fromJson(json,new TypeToken<List<ContactData>>(){}.getType());
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

    @Test(dataProvider = "validContactsFromJson")
  public void addingNewContact(ContactData contact) throws Exception {

        app.contact().initContactCreation();
        File photo = new File("src/test/resources/bo.jpg");
        app.contact().fillContactForm(new ContactData().withFirstName("lo").withLastName("NO").withMobilePhone("123465"), false);
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
