package com.thoughtworks.capability.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ParkingLot {
    @Getter
    private String id;
    private long capacity;
    private List<ParkingRecord> parkingRecords = new ArrayList<>();

    public ParkingLot(String id, long capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public ParkingLot(long capacity) {
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
    }

    public boolean validate() {
        return parkingRecords.size() < capacity;
    }

    public TicketNumber park(CarNumber carNumber) {
        if (!validate()) {
            throw new NoEnoughCapacityException();
        }
        TicketNumber ticketNumber = TicketNumber.generate();
        ParkingRecord parkingRecord = new ParkingRecord(carNumber, ticketNumber);
        parkingRecords.add(parkingRecord);
        return ticketNumber;
    }

    public long getCapacity() {
        return capacity;
    }

    public boolean contains(TicketNumber ticketNumber) {
        return parkingRecords.stream()
                .anyMatch(parkingRecord -> parkingRecord.getTicketNumber().equals(ticketNumber));
    }

    public CarNumber pickCar(TicketNumber ticketNumber) {
        return parkingRecords.stream()
                .filter(record -> record.getTicketNumber().equals(ticketNumber))
                .findFirst()
                .map(ParkingRecord::getCarNumber)
                .orElseThrow(IllegalTicketException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
