package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class AddinNewConTest extends TestBase {

    @Test
  public void addingNewContact() throws Exception {
   app.contact().initContactCreation();
    File photo= new File("src/test/resources/bo.jpg");
    app.contact().fillContactForm(new ContactData().withFirstName("lo").withLastName("NO").withPhoto(photo),false);
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
