package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ExcludeTimeZoneCollisions implements FlightFilter{
    @Override
    public List<Flight> filter(final List<Flight> flights) {
        return flights
                .stream()
                .filter((f) -> f.getSegments()
                        .stream()
                        .noneMatch((s) -> s.getArrivalDate().isBefore(s.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
