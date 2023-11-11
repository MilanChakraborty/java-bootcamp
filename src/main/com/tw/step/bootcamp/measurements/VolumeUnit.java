package com.tw.step.bootcamp.measurements;

public enum VolumeUnit implements Unit{
  GALLON(3.78),
  LITRE(1);

  private final double conversionFactor;

  VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double toStandard(double magnitude) {
    return magnitude * conversionFactor;
  }
}
