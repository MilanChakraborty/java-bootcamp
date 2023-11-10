package com.tw.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void areaShouldBeZeroWhenLengthIsZero() throws InvalidDimensionException {
    Rectangle rect = Rectangle.create(0, 1);
    assertEquals(0, rect.area());
  }

  @Test
  void areaShouldBeZeroWhenBreadthIsZero() throws InvalidDimensionException {
    Rectangle rect = Rectangle.create(1, 0);
    assertEquals(0, rect.area());
  }

  @Test
  void areaShouldBeZeroWhenBothDimensionsAreZero() throws InvalidDimensionException {
    Rectangle rect = Rectangle.create(0, 0);
    assertEquals(0, rect.area());
  }

  @Test
  void areaShouldBeOneWhenDimensionsAreUnit() throws InvalidDimensionException {
    Rectangle rect = Rectangle.create(1, 1);
    assertEquals(1, rect.area());
  }

  @Test
  void areaShouldNotBeZeroWhenDimensionsAreNonZero() throws InvalidDimensionException {
    Rectangle rect2 = Rectangle.create(2, 1);
    assertEquals(2, rect2.area());
  }

  @Test
  void perimeterShouldBeZeroWhenBothDimensionsAreZero() throws InvalidDimensionException {
    Rectangle rect1 = Rectangle.create(0, 0);
    assertEquals(0, rect1.perimeter());
  }

  @Test
  void perimeterShouldNotBeZeroWhenBothDimensionsAreNonZero() throws InvalidDimensionException {
    Rectangle rect1 = Rectangle.create(1, 2);
    assertEquals(6, rect1.perimeter());
  }

  @Test
  void shouldCreateRectangleWithSameLengthAndBreadthWhenOneSideIsProvided() throws InvalidDimensionException {
    Rectangle square = Rectangle.createSquare(2);

    assertEquals(4, square.area());
    assertEquals(8, square.perimeter());
  }
}