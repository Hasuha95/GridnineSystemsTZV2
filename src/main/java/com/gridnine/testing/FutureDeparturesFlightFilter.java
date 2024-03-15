package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FutureDeparturesFlightFilter implements FlightFilter{
    @Override
    public List<Flight> filter(final List<Flight> flights) {
        return flights
                .stream()
                .filter((f) -> f.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
