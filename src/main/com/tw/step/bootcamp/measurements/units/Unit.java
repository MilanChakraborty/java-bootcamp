package com.tw.step.bootcamp.measurements.units;

public interface Unit {
  Unit standard();

  double toStandard(double magnitude);
}
