package com.tw.step.bootcamp.measurements;

import java.util.Objects;

public class Length {
  private final double magnitude;
  private final LengthUnit unit;

  private Length(double magnitude, LengthUnit unit) {
    this.magnitude = magnitude;
    this.unit = unit;
  }

  public static Length of(double magnitude, LengthUnit unit) throws NegativeMagnitudeException {
    if(magnitude < 0) throw new NegativeMagnitudeException();
    return new Length(magnitude, unit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length otherLength = (Length) o;
    Length thisToStandard = new Length(unit.toStandard(magnitude), LengthUnit.CM);
    Length otherToStandard = new Length(otherLength.unit.toStandard(otherLength.magnitude), LengthUnit.CM);
    return Double.compare(thisToStandard.magnitude, otherToStandard.magnitude) == 0 && thisToStandard.unit == otherToStandard.unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(magnitude, unit);
  }
}
