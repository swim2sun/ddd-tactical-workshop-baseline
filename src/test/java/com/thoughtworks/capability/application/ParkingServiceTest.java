package com.thoughtworks.capability.application;

import com.thoughtworks.capability.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingServiceTest {
    private ParkingService parkingService;

    @Before
    public void setUp() throws Exception {
        ParkingRobot parkingRobot = new ParkingRobot(
                new ParkingLot(10),
                new ParkingLot(10)
        );
        parkingService = new ParkingService(parkingRobot);
    }

    @Test
    public void should_parking_with_car_number_successful() {
        CarNumber carNumber = new CarNumber("test");

        TicketNumber ticketNumber = parkingService.park(carNumber);

        assertNotNull(ticketNumber);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_parking_failed() {
        parkingService = new ParkingService(new ParkingRobot(new ParkingLot(1)));
        parkingService.park(new CarNumber("car1"));

        CarNumber carNumber = new CarNumber("test");
        parkingService.park(carNumber);
    }

    @Test
    public void should_pick_car_successful() {
        CarNumber parkingCar = new CarNumber("test");
        TicketNumber ticketNumber = parkingService.park(parkingCar);

        CarNumber carNumber = parkingService.pick(ticketNumber);

        assertEquals(carNumber, parkingCar);
    }

    @Test(expected = IllegalTicketException.class)
    public void should_throw_exception_when_pick_car_with_wrong_ticket() {
        parkingService.pick(TicketNumber.generate());
    }



}