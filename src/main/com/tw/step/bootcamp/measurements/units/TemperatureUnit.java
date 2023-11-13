package com.tw.step.bootcamp.measurements.units;

public enum TemperatureUnit implements Unit {
  CELSIUS(1.0, 0),
  FAHRENHEIT(5.0 / 9.0, 32),
  KELVIN(1, 273);

  private final double conversionFactor;
  private final double freezingPointOfWater;

  TemperatureUnit(double conversionFactor, double freezingPointOfWater) {
    this.conversionFactor = conversionFactor;
    this.freezingPointOfWater = freezingPointOfWater;
  }

  @Override
  public Unit getStandardUnit() {
    return CELSIUS;
  }

  @Override
  public double toStandard(double magnitude) {
    return (magnitude - this.freezingPointOfWater) * this.conversionFactor;
  }
}
