package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCase() throws Exception {
    app.goTo().groupPage();
    List<GropupData> before = app.group().list();
    GropupData group = new GropupData().withName("Manana");
    app.group().create(group);
    List<GropupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GropupData> byId =(g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
