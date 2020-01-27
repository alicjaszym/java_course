package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GropupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
 public Iterator<Object[]> validGroups() throws IOException {
   List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null) {
      String [] split = line.split(";");
      list.add(new Object[]{new GropupData().withName(split[0]).withFooter(split[1]).withtHeader(split[2])});
      line = reader.readLine();
    }

    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void groupCase(GropupData group) throws Exception {

      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }



  //@Test
  public void groupCaseBad() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GropupData group = new GropupData().withName("Manana'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before));
  }
}
