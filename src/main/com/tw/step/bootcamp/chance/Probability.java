package com.tw.step.bootcamp.chance;

public class Probability {
  private final double probability;

  private Probability(double probability) {
    this.probability = probability;
  }

  public boolean equals(Probability anotherChance) {
    return this.probability == anotherChance.probability;
  }

  public Probability and(Probability anotherChance) throws InvalidChanceException {
    return of(this.probability * anotherChance.probability);
  }

  public Probability or(Probability anotherChance) throws InvalidChanceException {
    double chanceOrAnotherChance = (this.probability + anotherChance.probability) - this.and(anotherChance).probability;
    return of(chanceOrAnotherChance);
  }

  public Probability inverse() throws InvalidChanceException {
    return of(1 - this.probability);
  }

  public static Probability of(double probability) throws InvalidChanceException {
    if (probability > 1 || probability < 0) {
      throw new InvalidChanceException();
    }
    return new Probability(probability);
  }

}
