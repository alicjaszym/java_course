package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;


@XStreamAlias("group")
public class GropupData {
  @XStreamOmitField
  private  int id = Integer.MAX_VALUE;
 @Expose
  private  String name;
  @Expose
  private  String header;
  @Expose
  private  String footer;

  public GropupData withtHeader(String header) {
    this.header = header;
    return  this;
  }

  public GropupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GropupData withName(String name) {
    this.name = name;
    return this;
  }

  public GropupData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GropupData that = (GropupData) o;
    return id == that.id &&
            Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "GropupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  public int getId () {return id;}

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
