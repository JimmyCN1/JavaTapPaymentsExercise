package com.jimmycn1.manager;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.strategy.TripsStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripManager {
  
  public Map<String, List<CommuterTrip>> createEveryCommutersTripsForTheDay(Map<String, List<TapEvent>> everyCommutersTapEvents) {
    Map<String, List<CommuterTrip>> everyCommutersTripsForTheDayMap = new HashMap<>();
    
    TripsStrategy tripsStrategy = new TripsStrategy();
    for (String pan : everyCommutersTapEvents.keySet()) {
      List<CommuterTrip> trips = tripsStrategy.createTripsPerVehicleForTheDay(everyCommutersTapEvents.get(pan));
      
      // now assuming that the trips will already be sorted by datetime
      // so have removed the redundant sorting by datetime and grouping by vehicle type
      everyCommutersTripsForTheDayMap.put(pan, trips);
    }
    
    return everyCommutersTripsForTheDayMap;
  }
}
