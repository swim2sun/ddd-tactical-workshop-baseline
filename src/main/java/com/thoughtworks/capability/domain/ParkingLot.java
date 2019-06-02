package com.thoughtworks.capability.domain;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private long capacity;
    private List<ParkingRecord> parkingRecords = new ArrayList<>();

    public ParkingLot(long capacity) {
        this.capacity = capacity;
    }

    public TicketNumber park(CarNumber carNumber) {
        if (parkingRecords.size() >= capacity) {
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

    public CarNumber get(TicketNumber ticketNumber) {
        return null;
    }
}
