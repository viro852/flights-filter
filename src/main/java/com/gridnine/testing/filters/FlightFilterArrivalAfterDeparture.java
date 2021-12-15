package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.util.function.Predicate;

public class FlightFilterArrivalAfterDeparture extends AbstractFlightFilter {

    private static final String FILTER_DESCRIPTION = "без сегментов с датой прилёта раньше даты вылета";
    private static final Predicate<Flight> PREDICATE = (Flight flight) -> flight.getSegments().stream().noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));

    public FlightFilterArrivalAfterDeparture() {
        setFilterDescription(FILTER_DESCRIPTION);
        setPredicate(PREDICATE);
    }
}
