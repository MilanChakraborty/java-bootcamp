package com.tw.step.bootcamp.measurements;

import com.tw.step.bootcamp.measurements.exceptions.IllegalOperationException;
import com.tw.step.bootcamp.measurements.exceptions.NegativeMagnitudeException;
import com.tw.step.bootcamp.measurements.units.TemperatureUnit;
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
    if (magnitude < 0 && unit.standard() != TemperatureUnit.CELSIUS) throw new NegativeMagnitudeException();
    return new Measurement(magnitude, unit);
  }

  private boolean areMagnitudesEqual(Measurement otherToStandard) {
    double difference = this.toStandard() - otherToStandard.toStandard();
    return difference > -0.1 && difference < 0.1;
  }

  private double toStandard() {
    return this.unit.toStandard(this.magnitude);
  }


  private boolean areUnitsEqual(Measurement otherToStandard) {
    return this.getStandardUnit() == otherToStandard.getStandardUnit();
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

    Measurement thisToStandard = new Measurement(this.toStandard(), this.getStandardUnit());
    Measurement otherToStandard = new Measurement(otherMeasurement.toStandard(), otherMeasurement.getStandardUnit());

    return new Measurement(thisToStandard.magnitude + otherToStandard.magnitude, this.getStandardUnit());
  }

  private Unit getStandardUnit() {
    return this.unit.standard();
  }
}
