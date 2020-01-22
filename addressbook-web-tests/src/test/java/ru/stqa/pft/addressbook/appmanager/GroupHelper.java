package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GropupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void goBackToGroupPage() {
      click(By.linkText("group page"));
    }

  public void fillTheForm(GropupData gropupData) {
    type(By.name("group_name"), gropupData.getName());
    type(By.name("group_header"), gropupData.getHeader());
    type(By.name("group_footer"), gropupData.getFooter());

  }

  public void submitFormButton() {
    click(By.name("submit"));
  }

  public void initCase() {
    click(By.name("new"));
 }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }



  public void create(GropupData group) {
   initCase();
   fillTheForm(group);
   submitFormButton();
    groupCache=null;
   goBackToGroupPage();
  }


  public void modify( GropupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillTheForm(group);
    submitGroupModification();
    groupCache=null;
    goBackToGroupPage();
  }

public int count(){
    return wd.findElements(By.name("selected[]")).size();
}

  public Groups all() {
    if (groupCache !=null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for(WebElement element:elements){
      String name= element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GropupData().withId(id).withName(name));
      System.out.println(groupCache.size());
    }
    return new Groups(groupCache);
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  private Groups groupCache=null;


  public void delete(GropupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache=null;
    goBackToGroupPage();
  }
}
