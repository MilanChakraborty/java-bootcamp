package com.tw.step.bootcamp.chance;

public class InvalidChanceException extends Throwable {
  public InvalidChanceException() {
    super("Chance should lie between 0 and 1");
  }
}
