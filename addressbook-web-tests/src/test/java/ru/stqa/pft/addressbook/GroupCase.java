package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCase extends TestBase{

  @Test
  public void groupCase() throws Exception {
    goToCase();
    initCase();
    fillTheForm(new GropupData("G1", "G2", "G3"));
    goBackToGroupPage();
    logout();
  }
}
