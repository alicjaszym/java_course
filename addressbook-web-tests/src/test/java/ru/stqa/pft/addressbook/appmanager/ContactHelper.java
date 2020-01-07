package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd){
    super(wd);
  }
  public void clickOnContactTable() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::td[2]"));
  }


  public void addNewContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getSecondName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone());

    if(creation && isElementPresent(By.name("new_group"))){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      return;
    }
}

  public void clickSubmitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void clickOnHome(){
    if(isElementPresent(By.tagName("id"))
            && wd.findElement(By.tagName("id")).getText().equals("search_count")
            &&isElementPresent(By.name("new"))){
      return;}
    click(By.linkText("home"));
  }

  public void clickOnAddNew() {
    click(By.linkText("add new"));
  }

  public void clickOnContact(){
    click(By.xpath("//*[@type='checkbox']"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void clickOnUpdateButton() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contact,boolean con) {
    clickOnAddNew();
    addNewContact(contact,con);
    clickSubmitContactCreation();
    clickOnContactTable();
  }

  public boolean isThereContact() {
    return  isElementPresent(By.name("selected[]"));
  }
}


