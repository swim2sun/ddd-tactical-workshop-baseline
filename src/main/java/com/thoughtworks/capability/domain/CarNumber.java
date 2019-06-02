package com.thoughtworks.capability.domain;

import java.util.Objects;

public class CarNumber {
    private String number;

    public CarNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber carNumber = (CarNumber) o;
        return Objects.equals(number, carNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
