package com.tw.step.bootcamp.measurements;

import com.tw.step.bootcamp.measurements.exceptions.IllegalOperationException;
import com.tw.step.bootcamp.measurements.exceptions.NegativeMagnitudeException;
import com.tw.step.bootcamp.measurements.units.Unit;

import java.util.Objects;

public class Measurement {
  private final double magnitude;
  private final Unit unit;

  private Measurement(double magnitude, Unit unit) {
    this.magnitude = magnitude;
    this.unit = unit;
  }

  public static Measurement of(double magnitude, Unit unit) throws NegativeMagnitudeException {
    if (magnitude < 0) throw new NegativeMagnitudeException();
    return new Measurement(magnitude, unit);
  }

  private static boolean areUnitsEqual(Measurement thisToStandard, Measurement otherToStandard) {
    return thisToStandard.unit == otherToStandard.unit;
  }

  private static boolean areMagnitudesEqual(Measurement thisToStandard, Measurement otherToStandard) {
    double difference = thisToStandard.magnitude - otherToStandard.magnitude;
    return difference > -0.1 && difference < 0.1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Measurement otherMeasurement = (Measurement) o;
    Measurement thisToStandard = new Measurement(this.unit.toStandard(this.magnitude), this.unit.standard());
    Measurement otherToStandard = new Measurement(otherMeasurement.unit.toStandard(otherMeasurement.magnitude), this.unit.standard());

    return areMagnitudesEqual(thisToStandard, otherToStandard) && areUnitsEqual(thisToStandard, otherToStandard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.magnitude, this.unit);
  }

  public Measurement add(Measurement otherMeasurement) throws IllegalOperationException {
    if (otherMeasurement.unit.getClass() != this.unit.getClass()) throw new IllegalOperationException();
    Measurement thisToStandard = new Measurement(this.unit.toStandard(this.magnitude), this.unit.standard());
    Measurement otherToStandard = new Measurement(otherMeasurement.unit.toStandard(otherMeasurement.magnitude), this.unit.standard());

    return new Measurement(thisToStandard.magnitude + otherToStandard.magnitude, this.unit.standard());
  }
}
