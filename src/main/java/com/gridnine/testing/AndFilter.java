package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements FlightFilter{
    private FlightFilter firstFilter;
    private FlightFilter secondFilter;

    public AndFilter(FlightFilter firstFilter, FlightFilter secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> list = new ArrayList<>(firstFilter.filter(flights));
        return secondFilter.filter(list);
    }
}
