package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class FlightFilterAfterTodayDate extends AbstractFlightFilter {

    private static final String FILTER_DESCRIPTION = "без вылетов до текущего момента времени";
    private static final Predicate<Flight> PREDICATE = (Flight flight) -> flight.getSegments().stream().noneMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));

    public FlightFilterAfterTodayDate() {
        setFilterDescription(FILTER_DESCRIPTION);
        setPredicate(PREDICATE);
    }
}
