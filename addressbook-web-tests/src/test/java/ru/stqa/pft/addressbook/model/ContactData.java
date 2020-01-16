package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id;
  private final String firstName;
  private final String secondName;
  private final String lastName;
  private final String address;
  private final String phone;
  private final String group;

  public ContactData(int id,String firstName, String secondName, String lastName, String address, String phone, String group) {
    this.id=id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  public ContactData(String firstName, String secondName, String lastName, String address, String phone, String group) {
    this.id= Integer.MAX_VALUE;
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
    this.group = group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
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
