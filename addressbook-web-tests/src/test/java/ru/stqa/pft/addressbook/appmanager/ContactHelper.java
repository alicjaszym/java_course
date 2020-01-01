package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd){
    super(wd);
  }
  public void clickOnContactTable() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::td[2]"));
  }


  public void addNewContact(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("middlename"),contactData.getSecondName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getPhone());
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void clickOnAddNew() {
    click(By.linkText("add new"));
  }
}


