package com.tw.step.bootcamp.measurements.units;

public enum VolumeUnit implements Unit {
  GALLON(3.78),
  LITRE(1);

  private final double conversionFactor;

  VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  @Override
  public Unit standard() {
    return LITRE;
  }

  @Override
  public double toStandard(double magnitude) {
    return magnitude * this.conversionFactor;
  }
}
