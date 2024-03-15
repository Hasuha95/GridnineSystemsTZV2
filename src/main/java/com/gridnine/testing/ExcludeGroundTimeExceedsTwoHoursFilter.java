package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExcludeGroundTimeExceedsTwoHoursFilter implements FlightFilter{
    @Override
    public List<Flight> filter(final List<Flight> flightList) {
        return flightList.stream().filter((f) -> {
            List<Segment> segments = f.getSegments();
            int sum = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                sum += Duration.between(segments.get(i).getArrivalDate()
                        , segments.get(i+1).getDepartureDate()).toMinutes();
            }
            if (sum > 120){
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());
    }
}
