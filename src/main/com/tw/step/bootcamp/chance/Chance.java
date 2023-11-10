package com.tw.step.bootcamp.chance;

public class Chance {
  private final double probability;

  private Chance(double probability) {
    this.probability = probability;
  }

  public boolean equals(Chance anotherChance) {
    return this.probability == anotherChance.probability;
  }

  public Chance and(Chance anotherChance) throws InvalidChanceException {
    return of(this.probability * anotherChance.probability);
  }

  public Chance inverse() throws InvalidChanceException {
    return of(1 - this.probability);
  }

  public static Chance of(double probability) throws InvalidChanceException {
    if (probability > 1 || probability < 0) {
      throw new InvalidChanceException();
    }
    return new Chance(probability);
  }
}
