package com.thoughtworks.capability.domain;

import java.util.UUID;

public class TicketNumber {
    private String number;

    public TicketNumber() {
        this.number = UUID.randomUUID().toString();
    }

    public static TicketNumber generate() {
        return new TicketNumber();
    }
}
