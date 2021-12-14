package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FlightFilterAndDisplay {

    public static void filterAndDisplay(List<Flight> flights, String filterDescription, Predicate<Flight> pr) {
        ArrayList<Flight> flightsForDisplayAfterFilter = new ArrayList<>();
        for (Flight currentFlight : flights) {
            if (pr.test(currentFlight) != true) {
                flightsForDisplayAfterFilter.add(currentFlight);
            }
        }
        System.out.println("Перелеты " + filterDescription + ", количество: " + flightsForDisplayAfterFilter.size() + " " + "\n" + flightsForDisplayAfterFilter);
        System.out.println();
    }
}
