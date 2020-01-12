import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[]args){
    String[] langss = new String[4];
    langss[0]="Java";
    langss[1]="C#";
    langss[2]="Python";
    langss[3]="PHP";
    //or shorter way /W tablicy rozmiar jest znany, wskazany po inicjalizacji i nie moze sie zmieniac

    String[] langs = {"Java","C#","Python","PHP"};

    List<String> languages = new ArrayList<String>();
      //interfejs               //konkretna klasa która go realizuje
    languages.add("Java"); //lista na poczatku ma rozmiar 0 -a u dodanie
    languages.add("C#");
    languages.add("Python");

    List<String> languagess = Arrays.asList("Java","C#","Python","PHP");


    for(String l:languagess ){
      System.out.println("I want to learn "+l);
    }
  }
}
