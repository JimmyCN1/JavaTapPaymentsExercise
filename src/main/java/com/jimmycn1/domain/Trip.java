package com.jimmycn1.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Trip {
  private final Set<Stop> trip;
  private final Double chargeAmount;
  
  public Trip(Stop stop, Stop otherStop, Double chargeAmount) {
    this.trip = new HashSet<>(Arrays.asList(stop, otherStop));
    this.chargeAmount = chargeAmount;
  }
  
  public Double getChargeAmount() {
    return chargeAmount;
  }
  
  public boolean containsStop(Stop stop) {
    return trip.contains(stop);
  }
  
  public boolean equals(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    return trip.contains(tapOnEvent.getStop()) && trip.contains(tapOffEvent.getStop());
  }
}
