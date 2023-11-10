package com.tw.step.bootcamp.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

  @Test
  void probabilityShouldBeHalfOfGettingTailsOnCoinToss() {
    double probabilityOfGettingTails = Math.calculateProbability(1, 2);
    assertEquals(0.5, probabilityOfGettingTails);
  }
}