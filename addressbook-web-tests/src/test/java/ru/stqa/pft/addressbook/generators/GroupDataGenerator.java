package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.GropupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c" , description="Group count")
  public  int count;

  @Parameter(names = "-f" , description="Target count")
  public String file;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander jCommander=new JCommander(generator);
    try{
      jCommander.parse(args);
    }catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
   // int count = Integer.parseInt(args[0]);
    //File file = new File(args[1]);
}

  private void run() throws IOException {
    List<GropupData> groups = generateGroups(count);
    save(groups,new File (file));
  }

  private void save(List<GropupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for(GropupData group:groups){
      writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),
              group.getFooter()));
    }
    writer.close();
  }

  private  List<GropupData> generateGroups(int count) {
    List<GropupData> groups = new ArrayList<GropupData>();
    for (int i=0; i <count; i++){
      groups.add(new GropupData().withName(String.format("test %s",i))
      .withtHeader(String.format("header %s",i)).withFooter(String.format("footer %s",i)));
    }
   return groups;
  }
}
