package com.tw.step.bootcamp.shapes;

public class Rectangle implements TwoDimensionalShape{
  private final double length;
  private final double breadth;

  private Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  @Override
  public double area() {
    return this.length * this.breadth;
  }

  @Override
  public double perimeter() {
    return 2 * (this.length + this.breadth);
  }

  public static Rectangle create(double length, double breadth) throws InvalidDimensionException {
    boolean areInvalidDimensions = length < 0 || breadth < 0;
    if(areInvalidDimensions) {
      throw new InvalidDimensionException();
    }
    return new Rectangle(length, breadth);
  }

  public static Rectangle createSquare(double side) throws InvalidDimensionException {
    return create(side, side);
  }
}
