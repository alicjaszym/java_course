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
  }

  public void clickSubmitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void clickOnHome(){
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
}


