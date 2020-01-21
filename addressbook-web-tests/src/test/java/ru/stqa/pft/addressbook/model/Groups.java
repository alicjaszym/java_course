package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GropupData> {

  private Set<GropupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GropupData>(groups.delegate);
  }

  public Groups(){
    this.delegate =new HashSet<GropupData>();
  }

  @Override
  protected Set<GropupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GropupData group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(GropupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}