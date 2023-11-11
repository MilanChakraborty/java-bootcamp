package com.tw.step.bootcamp.measurements.exceptions;

public class NegativeMagnitudeException extends Throwable {
  public NegativeMagnitudeException() {
    super("Magnitude cannot be negative");
  }
}
