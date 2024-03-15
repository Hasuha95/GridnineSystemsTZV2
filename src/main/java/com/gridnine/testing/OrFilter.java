package com.gridnine.testing;

import java.util.List;

public class OrFilter implements FlightFilter{
    private FlightFilter firstFilter;
    private FlightFilter secondFilter;

    public OrFilter(FlightFilter firstFilter, FlightFilter secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> firstFilterList = firstFilter.filter(flights);
        List<Flight> secondFilterList = secondFilter.filter(flights);

        for (Flight flight : secondFilterList) {
            if(!firstFilterList.contains(flight)){
                firstFilterList.add(flight);
            }
        }
        return firstFilterList;
    }
}
