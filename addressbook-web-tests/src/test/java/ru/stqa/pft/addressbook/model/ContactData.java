package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;


@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private  int id= Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname", columnDefinition = "LONGTEXT")
  private  String firstName;
  @Transient
  private  String secondName;
  @Expose
  @Column(name = "lastname", columnDefinition = "LONGTEXT")
  private  String lastName;
  @Transient
  private  String address;
  @Transient
  private  String phone;

  // @Expose
  // @Column(name = "mobile", columnDefinition = "LONGTEXT")
   //@Type(type="varchar($l)")
  @Transient
  private String mobilePhone;
  @Transient
  // @Expose
  //@Column(name = "work", columnDefinition = "LONGTEXT")
  //@Type(type="varchar($l)")
  private String workPhone;
  private String FirstName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="address_in_groups",
          joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups=new HashSet<GroupData>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(secondName, that.secondName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(phone, that.phone) &&

            Objects.equals(street, that.street) &&
            Objects.equals(emailSpecial, that.emailSpecial) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, secondName, lastName, address, phone, street, emailSpecial, email);
  }

  @Transient
  // @Expose
  // @Column(name = "work", columnDefinition = "LONGTEXT")
  //@Type(type="varchar($l)")
  private String homePhone;

  @Transient
  private String photo;
  @Transient
  private String street;
  @Transient
  private String emailSpecial;
  @Transient
  private String email;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }


  public Groups getGroups() {
    return  new Groups(groups);
  }

  public ContactData() {
  }

  public String getEmailSpecial() {
    return emailSpecial;
  }

  public ContactData withEmailSpecial(String emailSpecial) {
    this.emailSpecial = emailSpecial;
    return this;
  }



  public String getStreet() {
    return street;
  }

  public ContactData withStreet(String street) {
    this.street = street;
    return this;
  }

  public ContactData withtFirstName(String FirstName) {
    this.FirstName = FirstName;
    return  this;
  }

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }



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



  public ContactData withId(int id) {
    this.id = id;
    return this;
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


  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
