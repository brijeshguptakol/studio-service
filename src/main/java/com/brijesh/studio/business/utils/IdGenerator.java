package com.brijesh.studio.business.utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private final static AtomicLong ClassIdCounter = new AtomicLong();
    private final static AtomicLong BookingIdCounter = new AtomicLong();

    public static Long getClassId() {
        return ClassIdCounter.incrementAndGet();
    }

    public static Long getBookingId() {
        return BookingIdCounter.incrementAndGet();
    }
}

