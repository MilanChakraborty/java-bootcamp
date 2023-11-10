package com.tw.step.bootcamp.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  private Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle create(double length, double breadth) {
    return new Rectangle(length, breadth);
  }

  public double area() {
    return this.length * this.breadth;
  }

  public double perimeter() {
    return 2 * (this.length + this.breadth);
  }
}
