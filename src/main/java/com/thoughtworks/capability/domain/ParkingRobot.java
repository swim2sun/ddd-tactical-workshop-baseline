package com.thoughtworks.capability.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingRobot {
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingRobot(ParkingLot... parkingLot) {
        parkingLotList.addAll(Arrays.asList(parkingLot));
    }

    public ParkingLot findParkingLot() {
        return parkingLotList.stream()
                .filter(ParkingLot::validate)
                .findFirst()
                .orElseThrow(NoEnoughCapacityException::new);
    }

    public ParkingLot findParkingLot(TicketNumber ticketNumber) {
        return parkingLotList.stream()
                .filter(parkingLot -> parkingLot.contains(ticketNumber))
                .findFirst()
                .orElseThrow(IllegalTicketException::new);
    }
}
