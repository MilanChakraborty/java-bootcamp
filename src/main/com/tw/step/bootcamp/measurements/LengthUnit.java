package com.tw.step.bootcamp.measurements;

public enum LengthUnit {
  FEET(30.48),
  INCH(2.54),
  CM(1),
  MM(0.1);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double magnitude) {
    return magnitude * conversionFactor;
  }
}
