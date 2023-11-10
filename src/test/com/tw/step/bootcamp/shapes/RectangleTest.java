package com.tw.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void areaShouldBeZeroWhenEitherDimensionsAreZero() {
    Rectangle rect1 = Rectangle.create(0, 1);
    Rectangle rect2 = Rectangle.create(1, 0);
    Rectangle rect3 = Rectangle.create(0, 0);

    assertEquals(0, rect1.area());
    assertEquals(0, rect2.area());
    assertEquals(0, rect3.area());
  }

  @Test
  void areaShouldNotBeZeroWhenDimensionsAreNonZero() {
    Rectangle rect1 = Rectangle.create(1, 1);
    Rectangle rect2 = Rectangle.create(2, 1);

    assertEquals(1, rect1.area());
    assertEquals(2, rect2.area());
  }

  @Test
  void perimeterShouldBeZeroWhenBothDimensionsAreZero() {
    Rectangle rect1 = Rectangle.create(0, 0);

    assertEquals(0, rect1.perimeter());
  }

  @Test
  void perimeterShouldNotBeZeroWhenBothDimensionsAreNonZero() {
    Rectangle rect1 = Rectangle.create(1, 2);

    assertEquals(6, rect1.perimeter());
  }
}