package com.tw.step.bootcamp.measurements.exceptions;

public class IllegalOperationException extends Throwable {
  public IllegalOperationException() {
    super("Operation cannot be performed: Unit Mismatch");
  }
}
