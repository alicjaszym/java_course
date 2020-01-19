package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
 public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size()==0){
      app.group().create(new GropupData("Manana", null, null));
    }
  }


 @Test
 public void testGroupModification(){

   List<GropupData> before = app.group().list();
   int index = (before.size()-1);
   GropupData group = new GropupData(before.get(index).getId(),"Test1", null, null);
   app.group().modify(index, group);
   List<GropupData> after = app.group().list();
   Assert.assertEquals(after.size(), before.size());

   before.remove(index);
   before.add(group);
   Comparator<? super GropupData> byId =(g1,g2) -> Integer.compare(g1.getId(), g2.getId());
   before.sort(byId);
   after.sort(byId);
   Assert.assertEquals(before,after);
 }


}
