package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractFlightFilter implements FlightFilter {

   private String filterDescription;
   private Predicate<Flight> predicate;

    @Override
    public void filterAndDisplay(List<Flight> flights) {
        List<Flight> filteredList = flights
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println("Перелеты "+filterDescription+"количество:"+filteredList.size()+"\n"+filteredList);
        System.out.println();
    }
//почему только сеттеры?
    public void setFilterDescription(String filterDescription) {
        this.filterDescription = filterDescription;
    }

    public void setPredicate(Predicate<Flight> predicate) {
        this.predicate = predicate;
    }
}
