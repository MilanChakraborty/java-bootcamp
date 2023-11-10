package com.tw.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

  @Test
  void shouldCalculateArea() {
    Square square = Square.create(2);
    assertEquals(4, square.area());
  }

  @Test
  void shouldCalculatePerimeter() {
    Square square = Square.create(2);
    assertEquals(8, square.perimeter());
  }
}