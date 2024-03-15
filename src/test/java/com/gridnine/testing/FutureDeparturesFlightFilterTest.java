package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class FutureDeparturesFlightFilterTest {

    @Test
    void excludeFlightsInPast() {
        List<Flight> list = new ArrayList<>(Arrays.asList(getSimpleFlight(), getFlightWithFutureDeparture()));

        Assertions.assertEquals(new FutureDeparturesFilter().filter(list),
                new ArrayList<>(Arrays.asList(getFlightWithFutureDeparture())));
    }


    /*
    уже вылетел без пересадок
    */
    Flight getSimpleFlight() {
        LocalDateTime time = LocalDateTime.now().minusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment = new Segment(time, time.plusHours(3));

        List<Segment> list = new ArrayList<>(Arrays.asList(segment));
        Flight flight = new Flight(list);

        return flight;
    }

    /*
       скоро летит
    */
    Flight getFlightWithFutureDeparture() {
        LocalDateTime time1 = LocalDateTime.now().plusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment1 = new Segment(time1, time1.plusHours(3));
        LocalDateTime time2 = segment1.getArrivalDate().plusHours(1).truncatedTo(ChronoUnit.MINUTES);;
        Segment segment2 = new Segment(time2, time2.plusHours(2));

        List<Segment> list = new ArrayList<>(Arrays.asList(segment1, segment2));
        Flight flight = new Flight(list);
        return flight;
    }

}