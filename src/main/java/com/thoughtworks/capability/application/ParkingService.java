package com.thoughtworks.capability.application;

import com.thoughtworks.capability.domain.CarNumber;
import com.thoughtworks.capability.domain.ParkingRobot;
import com.thoughtworks.capability.domain.TicketNumber;

public class ParkingService {
    private final ParkingRobot parkingRobot;

    public ParkingService(ParkingRobot parkingRobot) {
        this.parkingRobot = parkingRobot;
    }

    public TicketNumber park(CarNumber carNumber) {
        return parkingRobot.findParkingLot().park(carNumber);
    }

    public CarNumber pick(TicketNumber ticketNumber) {
        return parkingRobot.findParkingLot(ticketNumber).pickCar(ticketNumber);
    }
}
