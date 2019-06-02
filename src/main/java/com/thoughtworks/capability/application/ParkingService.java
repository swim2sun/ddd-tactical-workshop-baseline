package com.thoughtworks.capability.application;

import com.thoughtworks.capability.domain.CarNumber;
import com.thoughtworks.capability.domain.ParkingLot;
import com.thoughtworks.capability.domain.TicketNumber;

public class ParkingService {
    private ParkingLot parkingLot = new ParkingLot(10);

    public TicketNumber park(CarNumber carNumber) {
        return parkingLot.park(carNumber);
    }

    public CarNumber getCar(TicketNumber ticketNumber) {
        return parkingLot.get(ticketNumber);
    }

    public long getCapacity() {
        return parkingLot.getCapacity();
    }
}
