package com.gridnine.testing;

import com.gridnine.testing.filters.FlightFilterAfterTodayDate;
import com.gridnine.testing.filters.FlightFilterArrivalAfterDeparture;
import com.gridnine.testing.filters.FlightFilterGroundTimeBeforeTwoHours;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterAfterTodayDate flightFilterAfterTodayDate = new FlightFilterAfterTodayDate();
        flightFilterAfterTodayDate.filterAndDisplay(flights);

        FlightFilterArrivalAfterDeparture flightFilterArrivalAfterDeparture = new FlightFilterArrivalAfterDeparture();
        flightFilterArrivalAfterDeparture.filterAndDisplay(flights);

        FlightFilterGroundTimeBeforeTwoHours flightFilterGroundTimeBeforeTwoHours = new FlightFilterGroundTimeBeforeTwoHours();
        flightFilterGroundTimeBeforeTwoHours.filterAndDisplay(flights);
    }
}
