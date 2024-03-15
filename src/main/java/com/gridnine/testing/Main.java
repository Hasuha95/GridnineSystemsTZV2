package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. исключить вылеты до текущего момента времени
        System.out.println("исключить вылет до текущего момента времени");
        new FutureDeparturesFilter().filter(FlightBuilder.createFlights()).forEach(System.out::println);

        // 2.	исключить вылеты, где имеются сегменты с датой прилёта раньше даты вылета
        System.out.println("исключить вылеты, где имеются сегменты с датой прилёта раньше даты вылета");
        new ExcludeTimeZoneCollisionsFilter().filter(FlightBuilder.createFlights()).forEach(System.out::println);

        // 3.	исключить полёты, где общее время, проведённое на земле превышает два часа
        System.out.println("исключить полёты, где общее время, проведённое на земле превышает два часа");
        new ExcludeGroundTimeExceedsTwoHoursFilter().filter(FlightBuilder.createFlights()).forEach(System.out::println);
    }
}
