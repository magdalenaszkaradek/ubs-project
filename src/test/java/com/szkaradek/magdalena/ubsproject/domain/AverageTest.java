package com.szkaradek.magdalena.ubsproject.domain;

import com.szkaradek.magdalena.ubsproject.domain.Average;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AverageTest {

    @Test
    void add_zeroNumbers() {
        Average average = new Average();

        assertEquals(0, average.getValue());
    }

    @Test
    void add_oneNumber() {
        Average average = new Average();
        average.add(1);

        assertEquals(1, average.getValue());
    }

    @Test
    void add_twoNumbers() {
        Average average = new Average();
        average.add(1);
        average.add(2);

        assertEquals(1.5, average.getValue());
    }
}