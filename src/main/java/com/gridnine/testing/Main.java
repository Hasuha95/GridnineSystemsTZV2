package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        // 1. исключить вылеты до текущего момента времени
        System.out.println("исключить вылет до текущего момента времени");
        new FutureDeparturesFlightFilter().filter(FlightBuilder.createFlights()).forEach(System.out::println);

        // 2.	исключить вылеты, где имеются сегменты с датой прилёта раньше даты вылета
        System.out.println("исключить вылеты, где имеются сегменты с датой прилёта раньше даты вылета Вариант1");
        new ExcludeTimeZoneCollisions().filter(FlightBuilder.createFlights()).forEach(System.out::println);

        // 3.	исключить полёты, где общее время, проведённое на земле превышает два часа
        System.out.println("исключить полёты, где общее время, проведённое на земле превышает два часа");
        new ExcludeGroundTimeExceedsTwoHours().filter(FlightBuilder.createFlights()).forEach(System.out::println);
    }
}
