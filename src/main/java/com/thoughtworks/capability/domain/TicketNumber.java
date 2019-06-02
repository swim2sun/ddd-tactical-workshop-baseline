package com.thoughtworks.capability.domain;

import java.util.Objects;
import java.util.UUID;

public class TicketNumber {
    private String number;

    public TicketNumber() {
        this.number = UUID.randomUUID().toString();
    }

    public static TicketNumber generate() {
        return new TicketNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketNumber that = (TicketNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
