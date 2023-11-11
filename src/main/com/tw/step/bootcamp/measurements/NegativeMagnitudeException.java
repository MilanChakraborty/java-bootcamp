package com.tw.step.bootcamp.measurements;

public class NegativeMagnitudeException extends Throwable {
  public NegativeMagnitudeException() {
    super("Magnitude cannot be negative");
  }
}
