package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class TestCase extends TestBase{

  @Test
  public void testCase() throws Exception {
    goToCase();
    initCase();
    fillTheForm(new GropupData("G1", "G2", "G3"));
    goBackToGroupPage();
    logout();
  }
}
