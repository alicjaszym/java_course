package ru.stqa.java_course.sandbox;

public class Eqaution {

  private double a;
  private double b;
  private double c;
  private int n;

  public Eqaution(double a, double b, double c) {

    this.a = a;
    this.a = b;
    this.a = c;

    double d = b * b - 4 * a * c;

    if (a == 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }

    } else {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    }
  }
    public int rootNumber () {
      return n;
    }

  }

