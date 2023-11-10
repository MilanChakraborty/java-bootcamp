package com.tw.step.bootcamp.chance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
  @Test
  void chanceShouldNotBeGreaterThanOne() {
    assertThrows(InvalidChanceException.class, () -> Chance.of(1.2));
  }

  @Test
  void chanceShouldNotBeLesserThanOne() {
    assertThrows(InvalidChanceException.class, () -> Chance.of(-1));
  }

  @Test
  void chanceOfGettingTailsAndHeadShouldBeEqual() throws InvalidChanceException {
    Chance chanceOfGettingTails = Chance.of(0.5);
    Chance chanceOfGettingHead = Chance.of(0.5);

    assertTrue(chanceOfGettingTails.equals(chanceOfGettingHead));
  }

  @Test
  void chanceOfGettingTailsAndNotGettingTailsShouldBeEqual() throws InvalidChanceException {
    Chance chanceOfGettingTails = Chance.of(0.5);
    Chance chanceOfNotGettingTails = chanceOfGettingTails.inverse();

    assertTrue(chanceOfGettingTails.equals(chanceOfNotGettingTails));
  }

  @Test
  void shouldGiveChanceOfGettingTailWhenTwoCoinsAreFlipped() throws InvalidChanceException {
    Chance chanceOfGettingTails = Chance.of(0.5);
    Chance chanceOfGettingTailsOnTwoCoinFlip = chanceOfGettingTails.and(chanceOfGettingTails);

    assertTrue(chanceOfGettingTailsOnTwoCoinFlip.equals(Chance.of(0.25)));
  }
}