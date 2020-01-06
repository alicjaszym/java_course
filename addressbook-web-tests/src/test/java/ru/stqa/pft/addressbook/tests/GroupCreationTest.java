package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GropupData("Manana", null, null));
  }
}
