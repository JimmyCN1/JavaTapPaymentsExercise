package com.jimmycn1.manager;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TapEventsManager {
  private final List<TapEvent> tapEvents;
  private final TripManager tripManger;
  
  public TapEventsManager(List<TapEvent> tapEvents) {
    this.tapEvents = tapEvents;
    this.tripManger = new TripManager();
  }
  
  public Map<String, List<CommuterTrip>> generateTripsForTheDay() {
    // assuming this csv of touch events only contains events from a single 24h day ie. batch process
    Map<String, List<TapEvent>> everyCommutersTapEventsForTheDayMap
            = tapEvents.stream().collect(Collectors.groupingBy(TapEvent::getPan));
  
    return tripManger.createEveryCommutersTripsForTheDay(everyCommutersTapEventsForTheDayMap);
  }
}
