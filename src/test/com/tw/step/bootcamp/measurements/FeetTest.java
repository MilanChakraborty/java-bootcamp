package com.tw.step.bootcamp.measurements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeetTest {
  @Test
  void shouldThrowNegativeMagnitudeExceptionWhenMagnitudeIsNegative() {
    assertThrows(NegativeMagnitudeException.class, () -> Feet.of(-2));
  }

  @Test
  void shouldGiveTheEquivalentInch() throws NegativeMagnitudeException {
    Feet oneFeet = Feet.of(1.0d);
    assertEquals(oneFeet.convertToInch(), Inch.of(12));
  }
}