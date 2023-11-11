package com.tw.step.bootcamp.measurements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldThrowNegativeMagnitudeExceptionWhenMagnitudeIsNegative() {
    assertThrows(NegativeMagnitudeException.class, () -> Measurement.of(-2, LengthUnit.CM));
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() throws NegativeMagnitudeException {
    Measurement oneFeet = Measurement.of(1.0d, LengthUnit.FEET);
    Measurement twelveInches = Measurement.of(12.0d, LengthUnit.INCH);
    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void twoInchShouldBeEqualToFivePointZeroEightCentimeter() throws NegativeMagnitudeException {
    Measurement twoInch = Measurement.of(2.0d, LengthUnit.INCH);
    Measurement fiveCentimeter = Measurement.of(5.08d, LengthUnit.CM);
    assertEquals(twoInch, fiveCentimeter);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() throws NegativeMagnitudeException {
    Measurement oneCm = Measurement.of(1.0d, LengthUnit.CM);
    Measurement tenMm = Measurement.of(10.0d, LengthUnit.MM);
    assertEquals(oneCm, tenMm);
  }

  @Test
  void oneGallonShouldBeEqualToThreePointSevenEightLiters() throws NegativeMagnitudeException {
    Measurement oneGallon = Measurement.of(1.0d, VolumeUnit.GALLON);
    Measurement threePointSevenEight = Measurement.of(3.78d, VolumeUnit.LITRE);
  }
}