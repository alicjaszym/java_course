package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GropupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GropupData(null,"Manana", null, null));
    List<GropupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
