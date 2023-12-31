package com.tw.step.bootcamp.measurements;

import com.tw.step.bootcamp.measurements.exceptions.IllegalOperationException;
import com.tw.step.bootcamp.measurements.exceptions.NegativeMagnitudeException;
import com.tw.step.bootcamp.measurements.units.LengthUnit;
import com.tw.step.bootcamp.measurements.units.TemperatureUnit;
import com.tw.step.bootcamp.measurements.units.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
  @Test
  void shouldThrowNegativeMagnitudeExceptionWhenMagnitudeIsNegative() {
    assertThrows(NegativeMagnitudeException.class, () -> Measurement.of(-2, LengthUnit.CM));
  }

  @Test
  void measurementsOfSameMagnitudeButDifferentUnitShouldNotBeEqual() throws NegativeMagnitudeException {
    Measurement oneFeet = Measurement.of(1.0d, LengthUnit.FEET);
    Measurement oneLitre = Measurement.of(1.0d, VolumeUnit.LITRE);

    assertNotEquals(oneFeet, oneLitre);
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

  @Test
  void oneHundredCelsiusShouldBeEqualToTwoHundredTwelveDegreeFahrenheit() throws NegativeMagnitudeException {
    Measurement hundredCelsius = Measurement.of(100.0d, TemperatureUnit.CELSIUS);
    Measurement twoHundredTwelveFahrenheit = Measurement.of(212.0d, TemperatureUnit.FAHRENHEIT);

    assertEquals(hundredCelsius, twoHundredTwelveFahrenheit);
  }

  @Test
  void zeroDegreeCelsiusShouldBeEqualToTwoHundredSeventyThreeKelvin() throws NegativeMagnitudeException {
    Measurement zeroCelsius = Measurement.of(0.0d, TemperatureUnit.CELSIUS);
    Measurement twoHundredSeventyThreeKelvin = Measurement.of(273.0d, TemperatureUnit.KELVIN);

    assertEquals(zeroCelsius, twoHundredSeventyThreeKelvin);
  }

  @Test
  void hundredDegreeFahrenheitShouldBeEqualToThreeHundredTenPointKelvin() throws NegativeMagnitudeException {
    Measurement hundredDegreeFahrenheit = Measurement.of(100.0d, TemperatureUnit.FAHRENHEIT);
    Measurement threeHundredTenPointNineKelvin = Measurement.of(310.9d, TemperatureUnit.KELVIN);

    assertEquals(hundredDegreeFahrenheit, threeHundredTenPointNineKelvin);
  }

  @Test
  void zeroKelvinShouldBeEqualToNegativeTwoHundredSeventyThreeDegreeCelsius() throws NegativeMagnitudeException {
    Measurement zeroKelvin = Measurement.of(0.0d, TemperatureUnit.KELVIN);
    Measurement negativeTwoHundredSeventyThreeDegreeCelsius = Measurement.of(-273.0d, TemperatureUnit.CELSIUS);

    assertEquals(zeroKelvin, negativeTwoHundredSeventyThreeDegreeCelsius);
  }
}