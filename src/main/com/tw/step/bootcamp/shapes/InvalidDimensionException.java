package com.tw.step.bootcamp.shapes;

public class InvalidDimensionException extends Throwable {
  public InvalidDimensionException() {
    super("Dimension cannot be negative");
  }
}
