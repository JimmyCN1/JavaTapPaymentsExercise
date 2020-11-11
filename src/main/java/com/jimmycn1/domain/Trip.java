package com.jimmycn1.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Trip {
  private final Set<Stop> trip;
  private final Double chargeAmount;
  
  private Trip(Stop stop, Stop otherStop, Double chargeAmount) {
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
  
  public static class TripBuilder {
    private Stop stop;
    private Stop otherStop;
    private Double chargeAmount;
    
    public TripBuilder setStop(Stop stop) {
      this.stop = stop;
      return this;
    }
    
    public TripBuilder setOtherStop(Stop otherStop) {
      this.otherStop = otherStop;
      return this;
    }
    
    public TripBuilder setChargeAmount(Double chargeAmount) {
      this.chargeAmount = chargeAmount;
      return this;
    }
    
    public Trip build() {
      return new Trip(stop, otherStop, chargeAmount);
    }
  }
}
