package com.thoughtworks.capability.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingRobotTest {

    @Test
    public void should_find_available_parking_lot() {
        String parkingLotId = "parkingLot";
        ParkingRobot parkingRobot = new ParkingRobot(new ParkingLot(parkingLotId, 10));
        ParkingLot parkingLot = parkingRobot.findParkingLot();

        assertEquals(parkingLot.getId(), parkingLotId);
    }




}