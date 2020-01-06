package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;

public class GroupModificationTests extends TestBase {

 @Test
 public void testGroupModification(){
   app.getNavigationHelper().goToGroupPage();
   if(!app.getGroupHelper().isThereAGroup()){
     app.getGroupHelper().createGroup(new GropupData("Manana", null, null));
   }
   app.getGroupHelper().selectGroup();
   app.getGroupHelper().initGroupModification();
   app.getGroupHelper().fillTheForm(new GropupData("Modified", null, null));
   app.getGroupHelper().submitGroupModification();
   app.getGroupHelper().goBackToGroupPage();
 }
}
