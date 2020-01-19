package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GropupData;

import java.util.ArrayList;
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

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void create(GropupData group) {
   initCase();
   fillTheForm(group);
   submitFormButton();
   goBackToGroupPage();
  }
  public boolean isThereAGroup() {

    return  isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    System.out.println(wd.findElements(By.name("selected[]")).size());
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(int index) {
   selectGroup(index);
   deleteSelectedGroup();
    goBackToGroupPage();
  }

  public void modify(int index, GropupData group) {
    selectGroup(index);
    initGroupModification();
    fillTheForm(group);
    submitGroupModification();
    goBackToGroupPage();
  }

  public List<GropupData> list() {
    List<GropupData> groups = new ArrayList<GropupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for(WebElement element:elements){
      String name= element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GropupData group = new GropupData(id,name,null,null);
      groups.add(group);
      System.out.println(groups.size());
    }
    return groups;
  }
}
