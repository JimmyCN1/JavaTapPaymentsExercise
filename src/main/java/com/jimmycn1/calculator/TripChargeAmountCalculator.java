package com.jimmycn1.calculator;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.Trip;
import com.jimmycn1.model.PossibleTrips;

import java.util.Comparator;
import java.util.stream.Collectors;

public class TripChargeAmountCalculator {
  private final PossibleTrips possibleTrips;
  private final static int FIRST = 0;
  
  public TripChargeAmountCalculator() {
    this.possibleTrips = new PossibleTrips();
  }
  
  public Double calculateMaxChargeAmount(TapEvent tapOnEvent) {
    Stop stop = tapOnEvent.getStop();
    
    Trip maxChargeTrip = possibleTrips.getPossibleTrips().stream()
            .filter(trip -> trip.containsStop(stop))
            .max(Comparator.comparing(Trip::getChargeAmount))
            .get();
    
    return maxChargeTrip.getChargeAmount();
  }
  
  public Double calculateChargeAmount(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    Trip matchingTrip = possibleTrips.getPossibleTrips().stream()
            .filter(trip -> trip.equals(tapOnEvent, tapOffEvent))
            .collect(Collectors.toList())
            .get(FIRST);
    
    return matchingTrip.getChargeAmount();
  }
}
