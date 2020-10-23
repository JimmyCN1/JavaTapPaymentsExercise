package com.jimmycn1.manager;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.strategy.TripsPerVehicleStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripManager {
  
  public Map<String, List<CommuterTrip>> createEveryCommutersTripsForTheDay(Map<String, List<TapEvent>> everyCommutersTapEvents) {
    Map<String, List<CommuterTrip>> everyCommutersTripsForTheDayMap = new HashMap<>();
    
    for (String pan : everyCommutersTapEvents.keySet()) {
      List<CommuterTrip> singleCommutersTripsForTheDay = createSingleCommutersTripsForTheDay(everyCommutersTapEvents.get(pan));
      everyCommutersTripsForTheDayMap.put(pan, singleCommutersTripsForTheDay);
    }
    
    return everyCommutersTripsForTheDayMap;
  }
  
  private List<CommuterTrip> createSingleCommutersTripsForTheDay(List<TapEvent> singleCommutersTapEvents) {
    Map<String, List<TapEvent>> commutersVehicleTapEventsMap = singleCommutersTapEvents.stream()
            .sorted(Comparator.comparing(TapEvent::getDateTime))
            .collect(Collectors.groupingBy(TapEvent::getVehicleId));
    
    List<CommuterTrip> singleCommutersTripsForTheDay = new ArrayList<>();
    
    for (String vehicleId : commutersVehicleTapEventsMap.keySet()) {
      TripsPerVehicleStrategy tripsPerVehicleStrategy = new TripsPerVehicleStrategy();
      List<CommuterTrip> singleCommutersVehicleTrips
              = tripsPerVehicleStrategy.createTripsPerVehicleForTheDay(commutersVehicleTapEventsMap.get(vehicleId));
      singleCommutersTripsForTheDay.addAll(singleCommutersVehicleTrips);
    }
    
    return singleCommutersTripsForTheDay;
  }
}
