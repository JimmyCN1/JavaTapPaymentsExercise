package com.jimmycn1.model;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class PossibleTrips {
  private final List<Trip> possibleTripsMap = new ArrayList<>();
  
  public PossibleTrips() {
    this.possibleTripsMap.add(new Trip(Stop.ONE, Stop.ONE, 0.0));
    this.possibleTripsMap.add(new Trip(Stop.ONE, Stop.TWO, 3.25));
    this.possibleTripsMap.add(new Trip(Stop.ONE, Stop.THREE, 7.30));
    this.possibleTripsMap.add(new Trip(Stop.TWO, Stop.TWO, 0.0));
    this.possibleTripsMap.add(new Trip(Stop.TWO, Stop.THREE, 5.50));
    this.possibleTripsMap.add(new Trip(Stop.THREE, Stop.THREE, 0.0));
  }
  
  public List<Trip> getPossibleTrips() {
    return possibleTripsMap;
  }
}
