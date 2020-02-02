package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private  int id= Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private  String firstName;
  @Transient
  private  String secondName;
  @Expose
  @Column(name = "lastname")
  private  String lastName;
  @Transient
  private  String address;
  @Transient
  private  String phone;
  @Transient
  private  String group;
  @Expose
  @Column(name = "mobile")
  @Type(type="text")
  private String mobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type="text")
  private String workPhone;
  @Expose
  @Column(name = "home")
  @Type(type="text")
  private String homePhone;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Column(name="photo")
  @Type(type="text")
  private String photo;


  public ContactData() {
  }

  public String getEmailSpecial() {
    return emailSpecial;
  }

  public ContactData withEmailSpecial(String emailSpecial) {
    this.emailSpecial = emailSpecial;
    return this;
  }

  private String emailSpecial;


  public String getStreet() {
    return street;
  }

  public ContactData withStreet(String street) {
    this.street = street;
    return this;
  }

  private String street;

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  private String email;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo= photo.getPath();
    return this;
  }

  public ContactData withFirstName(String firstName) throws IOException {
    Properties properties = new Properties();
    String target = System.getProperty("target", "local" );
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
    this.firstName = firstName;
    return this;
  }
  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.mobilePhone = workPhone;
    return this;
  }
  public ContactData withHomePhone(String homePhone) {
    this.mobilePhone = homePhone;
    return this;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getHomePhone() {
    return homePhone;
  }
  public ContactData withSecondName(String secondName) {
    this.secondName = secondName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(mobilePhone, that.mobilePhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, mobilePhone);
  }

  public int getId() {
    return id;
  }

  public String getFirstName()  {

    return firstName;
  }



  public String getSecondName() {
    return secondName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getGroup() {
    return group;
  }
}
