package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String secondName;
  private final String lastName;
  private final String address;
  private final String phone;

  public ContactData(String firstName, String secondName, String lastName, String address, String phone) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
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
}
