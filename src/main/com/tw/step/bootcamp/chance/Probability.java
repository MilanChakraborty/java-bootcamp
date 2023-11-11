package com.tw.step.bootcamp.chance;

import java.util.Objects;

public class Probability {
  private final double probability;

  private Probability(double probability) {
    this.probability = probability;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Probability that = (Probability) o;
    return Double.compare(probability, that.probability) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(probability);
  }

  public Probability and(Probability anotherChance) throws InvalidChanceException {
    return Probability.of(this.probability * anotherChance.probability);
  }

  public Probability or(Probability anotherChance) throws InvalidChanceException {
    double chanceOrAnotherChance = (this.probability + anotherChance.probability) - this.and(anotherChance).probability;
    return Probability.of(chanceOrAnotherChance);
  }

  public Probability inverse() throws InvalidChanceException {
    return Probability.of(1 - this.probability);
  }

  public static Probability of(double probability) throws InvalidChanceException {
    if (probability > 1 || probability < 0) {
      throw new InvalidChanceException();
    }
    return new Probability(probability);
  }

}
