package com.tw.step.bootcamp.measurements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InchTest {
  @Test
  void shouldGiveTheEquivalentFeet() throws NegativeMagnitudeException {
    Inch twelveInch = Inch.of(12.0d);
    assertEquals(twelveInch.convertToFeet(), Feet.of(1));
  }

  @Test
  void shouldThrowNegativeMagnitudeExceptionWhenMagnitudeIsNegative() {
    assertThrows(NegativeMagnitudeException.class, () -> Inch.of(-2));
  }
}