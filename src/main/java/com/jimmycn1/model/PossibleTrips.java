package com.jimmycn1.model;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class PossibleTrips {
  private final List<Trip> possibleTripsMap = new ArrayList<>();
  
  public PossibleTrips() {
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.ONE).setOtherStop(Stop.ONE).setChargeAmount(0.0).build());
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.ONE).setOtherStop(Stop.TWO).setChargeAmount(3.25).build());
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.ONE).setOtherStop(Stop.THREE).setChargeAmount(7.30).build());
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.TWO).setOtherStop(Stop.TWO).setChargeAmount(0.0).build());
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.TWO).setOtherStop(Stop.THREE).setChargeAmount(5.50).build());
    this.possibleTripsMap.add(new Trip.TripBuilder().setStop(Stop.THREE).setOtherStop(Stop.THREE).setChargeAmount(0.0).build());
  }
  
  public List<Trip> getPossibleTrips() {
    return possibleTripsMap;
  }
}
