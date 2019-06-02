package com.thoughtworks.capability.application;

import com.thoughtworks.capability.domain.CarNumber;
import com.thoughtworks.capability.domain.NoEnoughCapacityException;
import com.thoughtworks.capability.domain.TicketNumber;
import org.junit.Test;

import java.util.stream.LongStream;

import static org.junit.Assert.assertNotNull;

public class ParkingServiceTest {
    private ParkingService parkingService = new ParkingService();

    @Test
    public void should_parking_with_car_number_successful() {
        CarNumber carNumber = new CarNumber("test");

        TicketNumber ticketNumber = parkingService.park(carNumber);

        assertNotNull(ticketNumber);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_parking_failed() {
        LongStream.range(0, parkingService.getCapacity())
                .forEach(i -> parkingService.park(new CarNumber("test" + i)));

        CarNumber carNumber = new CarNumber("test");
        parkingService.park(carNumber);
    }

}