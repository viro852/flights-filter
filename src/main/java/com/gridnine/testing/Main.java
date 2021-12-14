package com.gridnine.testing;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Все перелеты" + ", количество: " + flights.size() + flights + "\n");


        FlightFilterAndDisplay.filterAndDisplay(flights,
                "без вылетов до текущего момента времени",
                flight -> flight.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())));


        FlightFilterAndDisplay.filterAndDisplay(flights,
                "без сегментов с датой прилёта раньше даты вылета",
                flight -> flight.getSegments().stream().anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())));


        FlightFilterAndDisplay.filterAndDisplay(flights,
                "без ожидания на земле больше двух часов ",
                flight -> {
                    List<Segment> segmentList = flight.getSegments();
                    for (int i = 0; i < segmentList.size() - 1; i++) {
                        if (segmentList.get(i + 1).getDepartureDate().getHour() - segmentList.get(i).getArrivalDate().getHour() > 2) {
                            return true;
                        }
                    }
                    return false;
                });
    }
}
