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

    assertEquals(expectedProbability, probabilityOfEventHappening.not());
  }

  @Test
  void probabilityOfGettingTailsWhenOneCoinFlippedIsHalf() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability half = Probability.of(0.5);

    assertEquals(chanceOfGettingTails, half);
  }

  @Test
  void probabilityOfNotGettingTailsWhenOneCoinFlippedIsHalf() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5).not();
    Probability half = Probability.of(0.5);

    assertEquals(chanceOfGettingTails, half);
  }

  @Test
  void shouldGiveChanceOfGettingTailsWhenTwoCoinsAreFlipped() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability chanceOfGettingTailsOnTwoCoinFlip = chanceOfGettingTails.and(chanceOfGettingTails);

    assertEquals(chanceOfGettingTailsOnTwoCoinFlip, Probability.of(0.25));
  }

  @Test
  void shouldGiveChanceOfGettingAtleastOneTailWhenTwoCoinsAreFlipped() throws InvalidChanceException {
    Probability chanceOfGettingTails = Probability.of(0.5);
    Probability chanceOfGettingAtleastOneTailOnTwoCoinFlip = chanceOfGettingTails.or(chanceOfGettingTails);

    assertEquals(chanceOfGettingAtleastOneTailOnTwoCoinFlip, Probability.of(0.75));
  }
}