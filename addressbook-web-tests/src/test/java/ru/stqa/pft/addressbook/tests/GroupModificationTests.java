package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
 public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size()==0){
      app.group().create(new GropupData().withName("Test1"));
    }
  }


 @Test
 public void testGroupModification(){

   Groups before = app.group().all();
   GropupData modifiedGroup= before.iterator().next();
   GropupData group = new GropupData().withId(modifiedGroup.getId()).withName("Test1").withtHeader("Test2").withFooter("Reaz");
   app.group().modify( group);
   assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();
   assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

 }


}
