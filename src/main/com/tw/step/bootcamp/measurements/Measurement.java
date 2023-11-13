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

  private boolean areMagnitudesEqual(Measurement otherToStandard) {
    double difference = this.unit.toStandard(this.magnitude) - otherToStandard.unit.toStandard(otherToStandard.magnitude);
    return difference > -0.1 && difference < 0.1;
  }

  private boolean areUnitsEqual(Measurement otherToStandard) {
    return this.unit.standard() == otherToStandard.unit.standard();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Measurement otherMeasurement = (Measurement) o;
    
    return this.areMagnitudesEqual(otherMeasurement) && this.areUnitsEqual(otherMeasurement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.magnitude, this.unit);
  }

  public Measurement add(Measurement otherMeasurement) throws IllegalOperationException {
    if (otherMeasurement.unit.getClass() != this.unit.getClass()) throw new IllegalOperationException();

    Measurement thisToStandard = new Measurement(this.unit.toStandard(this.magnitude), this.unit.standard());
    Measurement otherToStandard = new Measurement(otherMeasurement.unit.toStandard(otherMeasurement.magnitude), otherMeasurement.unit.standard());

    return new Measurement(thisToStandard.magnitude + otherToStandard.magnitude, this.unit.standard());
  }
}
