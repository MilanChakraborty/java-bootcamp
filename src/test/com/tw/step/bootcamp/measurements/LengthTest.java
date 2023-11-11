package com.tw.step.bootcamp.measurements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldThrowNegativeMagnitudeExceptionWhenMagnitudeIsNegative() {
    assertThrows(NegativeMagnitudeException.class, () -> Length.of(-2, LengthUnit.CM));
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws NegativeMagnitudeException {
    Length oneFeet = Length.of(1.0d, LengthUnit.FEET);
    Length twelveInches = Length.of(12.0d, LengthUnit.INCH);
    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void twoInchShouldBeEqualToFiveCentimeter() throws NegativeMagnitudeException {
    Length twoInch = Length.of(2.0d, LengthUnit.INCH);
    Length fiveCentimeter = Length.of(5.08d, LengthUnit.CM);
    assertEquals(twoInch, fiveCentimeter);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() throws NegativeMagnitudeException {
    Length oneCm = Length.of(1.0d, LengthUnit.CM);
    Length tenMm = Length.of(10.0d, LengthUnit.MM);
    assertEquals(oneCm, tenMm);
  }

}