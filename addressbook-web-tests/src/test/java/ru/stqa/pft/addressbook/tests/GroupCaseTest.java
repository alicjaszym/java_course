package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

public class GroupCaseTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    app.goToCase();
    app.initCase();
    app.fillTheForm(new GropupData("G1", "G2", "G3"));
    app.goBackToGroupPage();
    app.logout();
  }
}
