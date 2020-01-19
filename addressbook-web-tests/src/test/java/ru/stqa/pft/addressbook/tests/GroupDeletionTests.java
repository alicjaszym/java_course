package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.contact().list().size()==0) {
      app.group().create(new GropupData("Manana", null, null));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    List<GropupData> before = app.group().list();
    int index = (before.size() -1);
    app.group().delete(index);
    List<GropupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(index);
    Assert.assertEquals(before, after);
     }
}








