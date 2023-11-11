package com.tw.step.bootcamp.measurements;

import com.tw.step.bootcamp.measurements.exceptions.IllegalOperationException;
import com.tw.step.bootcamp.measurements.exceptions.NegativeMagnitudeException;
import com.tw.step.bootcamp.measurements.units.LengthUnit;
import com.tw.step.bootcamp.measurements.units.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeasurementTest {
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
  void twoInchShouldBeEqualToFiveCentimeter() throws NegativeMagnitudeException {
    Measurement twoInch = Measurement.of(2.0d, LengthUnit.INCH);
    Measurement fiveCentimeter = Measurement.of(5.0d, LengthUnit.CM);
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
    assertEquals(oneGallon, threePointSevenEight);
  }

  @Test
  void shouldBeAbleToAddTwoSameMeasurements() throws NegativeMagnitudeException, IllegalOperationException {
    Measurement twoInch = Measurement.of(2.0d, LengthUnit.INCH);
    Measurement fourInch = Measurement.of(4.0d, LengthUnit.INCH);
    assertEquals(twoInch.add(twoInch), fourInch);
  }

  @Test
  void shouldBeAbleToAddTwoLengthMeasurementOfAnyUnit() throws NegativeMagnitudeException, IllegalOperationException {
    Measurement twoInch = Measurement.of(2.0d, LengthUnit.INCH);
    Measurement twoPointFiveCm = Measurement.of(2.5d, LengthUnit.CM);
    Measurement threeInch = Measurement.of(3.0d, LengthUnit.INCH);
    assertEquals(twoInch.add(twoPointFiveCm), threeInch);
  }

  @Test
  void shouldBeAbleToAddTwoVolumeMeasurementOfAnyUnit() throws NegativeMagnitudeException, IllegalOperationException {
    Measurement oneGallon = Measurement.of(1.0d, VolumeUnit.GALLON);
    Measurement oneLitre = Measurement.of(1.0d, VolumeUnit.LITRE);

    Measurement fourPointSevenEightLitre = Measurement.of(4.78d, VolumeUnit.LITRE);
    assertEquals(oneGallon.add(oneLitre), fourPointSevenEightLitre);
  }

  @Test
  void shouldThrowIllegalOperationExceptionWhenMeasurementOfDifferentUnitsAreAdded() throws NegativeMagnitudeException {
    Measurement twoInch = Measurement.of(2.0d, LengthUnit.INCH);
    Measurement oneGallon = Measurement.of(1.0d, VolumeUnit.GALLON);

    assertThrows(IllegalOperationException.class, () -> twoInch.add(oneGallon));
  }
}