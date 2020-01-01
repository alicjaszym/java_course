package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GropupData;

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

  public void selectGroup() {
    click(By.name("selected[]"));
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
}
