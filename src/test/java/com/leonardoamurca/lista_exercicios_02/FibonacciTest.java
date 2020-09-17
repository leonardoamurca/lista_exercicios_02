package com.leonardoamurca.lista_exercicios_02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldReturnInputNumberWhenInputNumberIsEqualToOne() {
        // Arrange
        int inputNumber = 1;

        // Act
        int result = Fibonacci.fib(inputNumber);

        // Assert
        assertEquals(inputNumber, result);
    }

    @Test
    public void shouldReturnInputNumberWhenInputNumberIsEqualToZero() {
        // Arrange
        int inputNumber = 0;

        // Act
        int result = Fibonacci.fib(inputNumber);

        // Assert
        assertEquals(inputNumber, result);
    }

    @Test
    public void shouldReturnCorrectValueWhenInputNumberIsGreaterThanOne() {
        // Arrange
        int inputNumber = 3;

        // Act
        int result = Fibonacci.fib(inputNumber);

        // Assert
        assertEquals(2, result);
    }

    @Test
    public void shouldThrowEmptyStackExceptionWhenPopEmptyStack() {
        exceptionRule.expect(EmptyStackException.class);

        Stack s = new Stack();
        s.pop();
    }
}