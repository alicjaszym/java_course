package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToCase();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.goBackToGroupPage();
  }
}







