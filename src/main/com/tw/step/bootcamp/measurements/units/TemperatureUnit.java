package com.tw.step.bootcamp.measurements.units;

public enum TemperatureUnit implements Unit {
  CELSIUS(1),
  FAHRENHEIT(0);

  private final double conversionFactor;

  TemperatureUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  @Override
  public Unit standard() {
    return CELSIUS;
  }

  @Override
  public double toStandard(double magnitude) {
    if (this == FAHRENHEIT) return (magnitude - 32) * (5.0 / 9.0);
    return magnitude * this.conversionFactor;
  }
}
