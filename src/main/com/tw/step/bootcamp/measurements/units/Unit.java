package com.tw.step.bootcamp.measurements.units;

public interface Unit {
  Unit getStandard();

  double toStandard(double magnitude);
}
