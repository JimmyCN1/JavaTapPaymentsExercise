package com.jimmycn1.strategy;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TapType;
import com.jimmycn1.transformer.CommuterTripTransformer;

import java.util.ArrayList;
import java.util.List;

public class TripsStrategy {
  private final static int NEXT_TAP_EVENT = 1;
  private final CommuterTripTransformer commuterTripTransformer;
  
  public TripsStrategy() {
    this.commuterTripTransformer = new CommuterTripTransformer();
  }
  
  public List<CommuterTrip> createTripsPerVehicleForTheDay(List<TapEvent> tapEvents) {
    List<CommuterTrip> commutersVehicleTripsMap = new ArrayList<>();
    
    // assuming no overnight trips ie. commuter did not begin a trip on the previous day
    // kotlin's `forEachIndexed` would have come in handy here
    for (int i = 0; i < tapEvents.size(); i++) {
      TapEvent tapEvent = tapEvents.get(i);
      if (TapType.ON == tapEvent.getTapType()) {
        CommuterTrip commuterTrip;
        
        if (i < tapEvents.size() - NEXT_TAP_EVENT) {
          TapEvent nextTapEvent = tapEvents.get(i + NEXT_TAP_EVENT);
          
          if (TapType.OFF == nextTapEvent.getTapType()) {
            commuterTrip = createCompleteCommuterTrip(tapEvent, nextTapEvent);
            commutersVehicleTripsMap.add(commuterTrip);
          }
          
        } else {
          commuterTrip = createIncompleteCommuterTrip(tapEvent);
          commutersVehicleTripsMap.add(commuterTrip);
        }
      }
    }
    
    return commutersVehicleTripsMap;
  }
  
  private CommuterTrip createCompleteCommuterTrip(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    return commuterTripTransformer.from(tapOnEvent, tapOffEvent);
  }
  
  private CommuterTrip createIncompleteCommuterTrip(TapEvent tapOnEvent) {
    return commuterTripTransformer.from(tapOnEvent);
  }
}
