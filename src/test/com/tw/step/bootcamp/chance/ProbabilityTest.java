package com.tw.step.bootcamp.chance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
  @Test
  void probabilityShouldNotBeGreaterThanOne() {
    assertThrows(InvalidChanceException.class, () -> Probability.of(1.2));
  }

  @Test
  void probabilityShouldNotBeLesserThanOne() {
    assertThrows(InvalidChanceException.class, () -> Probability.of(-1));
  }

  @Test
  void shouldBeAbleToCalculateProbabilityOfEventNotHappening() throws InvalidChanceException {
    Probability probabilityOfEventHappening = Probability.of(0.25);
    Probability expectedProbability = Probability.of(0.75);

    assertTrue(expectedProbability.equals(probabilityOfEventHappening.inverse()));
  }

  @Test
  void probabilityOfGettingTailsWhenOneCoinFlippedIsHalf() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability half = Probability.of(0.5);

    assertTrue(chanceOfGettingTails.equals(half));
  }

  @Test
  void probabilityOfNotGettingTailsWhenOneCoinFlippedIsHalf() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5).inverse();
    Probability half = Probability.of(0.5);

    assertTrue(chanceOfGettingTails.equals(half));
  }

  @Test
  void shouldGiveChanceOfGettingTailsWhenTwoCoinsAreFlipped() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability chanceOfGettingTailsOnTwoCoinFlip = chanceOfGettingTails.and(chanceOfGettingTails);

    assertTrue(chanceOfGettingTailsOnTwoCoinFlip.equals(Probability.of(0.25)));
  }

  @Test
  void shouldGiveChanceOfGettingAtleastOneTailWhenTwoCoinsAreFlipped() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability chanceOfGettingAtleastOneTailOnTwoCoinFlip = chanceOfGettingTails.or(chanceOfGettingTails);

    assertTrue(chanceOfGettingAtleastOneTailOnTwoCoinFlip.equals(Probability.of(0.75)));
  }
}