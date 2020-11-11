package com.jimmycn1.domain;

public enum Stop {
  ONE("Stop1"),
  TWO("Stop2"),
  THREE("Stop3"),
  NONE("None");
  
  public final String stopNumber;
  
  Stop(String stopNumber) {
    this.stopNumber = stopNumber;
  }
  
  public String getStopNumber() {
    return stopNumber;
  }
  
  public static Stop fromString(String stopNumber) {
    for (Stop stop : Stop.values()) {
      if (stop.stopNumber.equals(stopNumber)) {
        return stop;
      }
    }
    return null;
  }
}
