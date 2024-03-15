package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExcludeTimeZoneCollisionsTest {

    @Test
    void excludeFlightsWithTimeZoneCollisions() {
        List<Flight> list = new ArrayList<>(Arrays.asList(getSimpleFlight(), getFlightWithTimeZoneCollisions()));

        Assertions.assertEquals(new ExcludeTimeZoneCollisionsFilter().filter(list),
                new ArrayList<>(Arrays.asList(getSimpleFlight())));
    }


    Flight getSimpleFlight() {
        LocalDateTime time = LocalDateTime.now().minusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment = new Segment(time, time.plusHours(3));

        List<Segment> list = new ArrayList<>(Arrays.asList(segment));
        Flight flight = new Flight(list);
        return flight;
    }

    Flight getFlightWithTimeZoneCollisions() {
        LocalDateTime time1 = LocalDateTime.now().minusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment1 = new Segment(time1, time1.minusHours(1));
        LocalDateTime time2 = segment1.getArrivalDate().plusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment2 = new Segment(time2, time2.plusHours(2));

        List<Segment> list = new ArrayList<>(Arrays.asList(segment1, segment2));
        Flight flight = new Flight(list);
        return flight;
    }
}