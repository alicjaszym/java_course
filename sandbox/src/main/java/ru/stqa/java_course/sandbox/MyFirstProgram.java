package ru.stqa.java_course.sandbox;

public class MyFirstProgram {

  public static void main (String[] args){

    Point p1 = new Point(12,3);
    Point p2 = new Point(10,6);

    System.out.println("Distance " + p1.distance(p2));
  }

  public static double distance (Point p1, Point p2){
  return  (p1.x-p2.y);

  }

}
