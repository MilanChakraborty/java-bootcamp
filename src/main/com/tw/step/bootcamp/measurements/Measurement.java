package com.tw.step.bootcamp.measurements;

import java.util.Objects;

public class Measurement {
  private final double magnitude;
  private final Unit unit;

  private Measurement(double magnitude, Unit unit) {
    this.magnitude = magnitude;
    this.unit = unit;
  }

  public static Measurement of(double magnitude, Unit unit) throws NegativeMagnitudeException {
    if(magnitude < 0) throw new NegativeMagnitudeException();
    return new Measurement(magnitude, unit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Measurement otherLength = (Measurement) o;
    Measurement thisToStandard = new Measurement(unit.toStandard(magnitude), LengthUnit.CM);
    Measurement otherToStandard = new Measurement(otherLength.unit.toStandard(otherLength.magnitude), LengthUnit.CM);
    return Double.compare(thisToStandard.magnitude, otherToStandard.magnitude) == 0 && thisToStandard.unit == otherToStandard.unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(magnitude, unit);
  }
}
