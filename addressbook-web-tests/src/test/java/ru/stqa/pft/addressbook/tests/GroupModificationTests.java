package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

 @Test
 public void testGroupModification(){
   app.getNavigationHelper().goToGroupPage();
   if(!app.getGroupHelper().isThereAGroup()){
     app.getGroupHelper().createGroup(new GropupData("Manana", null, null));
   }
   List<GropupData> before = app.getGroupHelper().getGroupList();
   app.getGroupHelper().selectGroup(before.size() -1);
   app.getGroupHelper().initGroupModification();
   GropupData group = new GropupData(before.get(before.size()-1).getId(),"Test1", null, null);
   app.getGroupHelper().fillTheForm(group);
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().goBackToGroupPage();
   List<GropupData> after = app.getGroupHelper().getGroupList();
   Assert.assertEquals(after.size(), before.size());

   before.remove(before.size() -1);
   before.add(group);
   Comparator<? super GropupData> byId =(g1,g2) -> Integer.compare(g1.getId(), g2.getId());
   before.sort(byId);
   after.sort(byId);
   Assert.assertEquals(before,after);
 }
}
