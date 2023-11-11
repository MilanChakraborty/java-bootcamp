package com.tw.step.bootcamp.measurements.units;

public enum LengthUnit implements Unit {
  FEET(12),
  INCH(1),
  CM(0.39),
  MM(0.039);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  @Override
  public LengthUnit standard() {
    return INCH;
  }

  @Override
  public double toStandard(double magnitude) {
    return magnitude * this.conversionFactor;
  }
}
