package com.szkaradek.magdalena.ubsproject.domain;

import lombok.Getter;

public class Average {

    @Getter
    private Double value = 0.0;

    private int counter = 0;

    public void add(int number) {
        value = (value * counter + number) / (counter + 1);
        counter = counter + 1;
    }
}
