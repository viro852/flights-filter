package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.List;
import java.util.function.Predicate;

public class FlightFilterGroundTimeBeforeTwoHours extends AbstractFlightFilter {

    private static final String FILTER_DESCRIPTION = "без ожидания на земле больше двух часов";
    private static final Predicate<Flight> PREDICATE = flight -> {
        List<Segment> segmentList = flight.getSegments();
        for (int i = 0; i < segmentList.size() - 1; i++) {
            if (segmentList.get(i + 1).getDepartureDate().getHour() - segmentList.get(i).getArrivalDate().getHour() <= 2) {
                return true;
            }
        }
        return false;
    };

    public FlightFilterGroundTimeBeforeTwoHours() {
        setFilterDescription(FILTER_DESCRIPTION);
        setPredicate(PREDICATE);
    }
}
