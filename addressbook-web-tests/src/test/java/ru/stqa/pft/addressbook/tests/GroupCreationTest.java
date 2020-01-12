package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GropupData("Manana", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
