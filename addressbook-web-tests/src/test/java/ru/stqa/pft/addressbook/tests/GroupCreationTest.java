package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initCase();
    app.getGroupHelper().fillTheForm(new GropupData("Manana", null, null));
    app.getGroupHelper().submitFormButton();
    app.getGroupHelper().goBackToGroupPage();
    app.logout();
  }
}
