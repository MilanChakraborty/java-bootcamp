package com.tw.step.bootcamp.shapes;

public class Square {
  private final double side;

  private Square(double side) {
    this.side = side;
  }

  public static Square create(double side) {
    return new Square(side);
  }

  public double area() {
    return this.side * this.side;
  }

  public double perimeter() {
    return 4 * this.side;
  }
}
