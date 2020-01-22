package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    type(By.name("mobile"), contactData.getMobilePhone());
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

  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobilePhone).withWorkPhone(work);
  }


  private void  initContactModificationById(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
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



  public void clickOnUpdateButton() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean con)  {
    clickOnAddNew();
    addNewContact(contact,con);
    clickSubmitContactCreation();
    contactCache=null;
    clickOnContactTable();
  }

  public void editContactById(int id) {
    // wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }
  public void modify( ContactData contact) {
    editContactById(contact.getId());
    addNewContact(contact, false);
    contactCache=null;
    clickOnUpdateButton();
  }

  public Set<ContactData> all(){
  Set<ContactData> contacts = new HashSet<ContactData>();
  List<WebElement> rows = wd.findElements(By.name("entry"));
  for (WebElement row:rows){
    List<WebElement> cells = row.findElements(By.tagName("td"));
    int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
    String lastname= cells.get(1).getText();
    String firstname= cells.get(2).getText();
    String[] phones=cells.get(5).getText().split("\n");
    contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
  }
return contacts;
  }

  /*public Contacts all() {
    if (contactCache !=null){
      return new Contacts(contactCache);
    }
    contactCache = new  Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,'entry')]"));
    System.out.println("elo" + elements);
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      String na = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(name).withLastName(na));
      System.out.println(contactCache.size());
    }
    return new Contacts(contactCache);*/

  public void clickOnContactById(int id){
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    //click(By.xpath("//*[@type='checkbox']"));
  }

  private Contacts contactCache=null;

  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(ContactData contact) {
    clickOnContactById(contact.getId());
    deleteContact();
    contactCache=null;
    clickOnHome();
  }
}


