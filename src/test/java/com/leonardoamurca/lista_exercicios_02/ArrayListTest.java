package com.leonardoamurca.lista_exercicios_02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldReturnTrueWhenListIsEmpty() {
        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Assert
        assertTrue(s.isEmpty());
    }

    @Test
    public void shouldReturnFalseWhenListIsNotEmpty() {
        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Act
        s.add(1);

        // Assert
        assertFalse(s.isEmpty());
    }

    @Test
    public void shouldReturnCorrectListSize() {
        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Act
        s.add(1);
        s.add(2);
        s.add(3);

        // Assert
        assertEquals(3, s.size());
    }

    @Test
    public void shouldRetrieveCorrectElementsByIndex() {
        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Act
        s.add(1);
        s.add(2);
        s.add(3);

        // Assert
        assertEquals((Integer) 1, s.get(0));
        assertEquals((Integer) 2, s.get(1));
        assertEquals((Integer) 3, s.get(2));
    }

    @Test
    public void shouldRetrieveCorrectElementsByIndexWhenDeleteItem() {
        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Act
        s.add(1);
        s.add(2);
        s.add(3);
        s.remove(1);

        // Assert
        assertEquals((Integer) 1, s.get(0));
        assertEquals((Integer) 3, s.get(1));
    }

    @Test
    public void shouldThrowIndexOutOfBoundsException() {
        // Assert
        exceptionRule.expect(IndexOutOfBoundsException.class);

        // Arange
        List<Integer> s = new ArrayList<Integer>();

        // Act
        s.add(1);
        s.remove(2);
    }
}
