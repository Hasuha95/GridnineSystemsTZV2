package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FutureDeparturesFilter implements FlightFilter{
    @Override
    public List<Flight> filter(final List<Flight> flights) {
        return flights
                .stream()
                .filter((f) -> f.getSegments()
                        .get(0)
                        .getDepartureDate()
                        .isAfter(LocalDateTime.now())
                        ||
                        f.getSegments()
                                .get(0)
                                .getDepartureDate()
                                .equals(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
