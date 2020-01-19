package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd){
    super(wd);
  }

  public void clickOnContactTable()  {

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

  public void clickOnContact(int index){
    wd.findElements(By.xpath("//*[@type='checkbox']")).get(index).click();
    //click(By.xpath("//*[@type='checkbox']"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    //click(By.xpath("//img[@alt='Edit']"));
  }

  public void clickOnUpdateButton() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean con)  {
    clickOnAddNew();
    addNewContact(contact,con);
    clickSubmitContactCreation();
    clickOnContactTable();
  }

  public void modify(int index, ContactData contact) {
    editContact(index);
    addNewContact(contact,false) ;
    clickOnUpdateButton();
  }

  public boolean isThereContact() {
    return  isElementPresent(By.name("selected[]"));
  }

  public int getCountactCount() {
    System.out.println(wd.findElements(By.name("selected[]")).size());
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(int index) {
    clickOnContact(index);
    deleteContact();
    clickOnHome();
  }

  public List<ContactData> list() {
     List<ContactData> contacts = new ArrayList<ContactData>();
     List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,'entry')]"));
     System.out.println("elo"+elements);
     for(WebElement element:elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      String na = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name , null,na, null,null,null);
      contacts.add(contact);
      System.out.println(contacts.size());
    }
    return contacts;
  }
}


