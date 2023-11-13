package com.tw.step.bootcamp.measurements.units;

public interface Unit {
  Unit getStandardUnit();

  double toStandard(double magnitude);
}
