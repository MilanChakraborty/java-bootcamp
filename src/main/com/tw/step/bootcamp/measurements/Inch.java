package com.tw.step.bootcamp.measurements;

import java.util.Objects;

public class Inch {
  private final double magnitude;

  private Inch(double magnitude) {
    this.magnitude = magnitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inch inch = (Inch) o;
    return Double.compare(magnitude, inch.magnitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(magnitude);
  }

  public static Inch of(double magnitude) throws NegativeMagnitudeException {
    if(magnitude < 0) throw new NegativeMagnitudeException();
    return new Inch(magnitude);
  }

  public Feet convertToFeet() throws NegativeMagnitudeException {
    return Feet.of(magnitude / 12.0);
  }
}
