package com.thoughtworks.capability.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ParkingRecord {
    private final CarNumber carNumber;
    private final TicketNumber ticketNumber;

    public ParkingRecord(CarNumber carNumber, TicketNumber ticketNumber) {
        this.carNumber = carNumber;
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return carNumber + ", " + ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingRecord that = (ParkingRecord) o;
        return Objects.equals(carNumber, that.carNumber) &&
                Objects.equals(ticketNumber, that.ticketNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber, ticketNumber);
    }
}
