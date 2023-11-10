package com.tw.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void shouldBeZeroWhenEitherDimensionsAreZero() {
    Rectangle rect1 = new Rectangle(0, 1);
    Rectangle rect2 = new Rectangle(1, 0);
    Rectangle rect3 = new Rectangle(0, 0);

    assertEquals(0, rect1.area());
    assertEquals(0, rect2.area());
    assertEquals(0, rect3.area());
  }

  @Test
  void shouldNotBeZeroWhenDimensionsAreNonZero() {
    Rectangle rect1 = new Rectangle(1, 1);
    Rectangle rect2 = new Rectangle(2, 1);

    assertEquals(1, rect1.area());
    assertEquals(2, rect2.area());
  }

}