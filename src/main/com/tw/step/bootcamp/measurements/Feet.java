package com.tw.step.bootcamp.measurements;

import java.util.Objects;

public class Feet {
  private final double magnitude;

  private Feet(double magnitude) {
    this.magnitude = magnitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Feet feet = (Feet) o;
    return Double.compare(magnitude, feet.magnitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(magnitude);
  }

  public static Feet of(double magnitude) throws NegativeMagnitudeException {
    if(magnitude < 0) throw new NegativeMagnitudeException();
    return new Feet(magnitude);
  }

  public Inch convertToInch() throws NegativeMagnitudeException {
    return Inch.of(magnitude * 12);
  }
}
