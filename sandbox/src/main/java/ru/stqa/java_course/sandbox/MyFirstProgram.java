package ru.stqa.java_course.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alicja");

    double a = 6;
    double b = 4;
      System.out.println("powierzchania kwadratu"+a+b+"="+area(a,b));
  }

  public static void hello(String somebody){
      System.out.println("Hello, "+somebody+"!");
  }

  public static double area(double a, double b){
    return   a*b;
  }
}