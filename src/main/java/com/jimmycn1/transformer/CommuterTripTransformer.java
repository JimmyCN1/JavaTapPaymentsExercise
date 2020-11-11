package com.jimmycn1.transformer;

import com.jimmycn1.calculator.TripChargeAmountCalculator;
import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TripStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class CommuterTripTransformer {
  private final TripChargeAmountCalculator tripChargeAmountCalculator;
  
  public CommuterTripTransformer() {
    this.tripChargeAmountCalculator = new TripChargeAmountCalculator();
  }
  
  public CommuterTrip from(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    return new CommuterTrip.CommuterTripBuilder()
            .setStarted(tapOnEvent.getDateTime())
            .setFinished(getFinishTime(tapOnEvent, tapOffEvent))
            .setDurationSeconds(calculateDurationSeconds(tapOnEvent, tapOffEvent))
            .setFromStop(tapOnEvent.getStop())
            .setToStop(getDepartureStop(tapOffEvent))
            .setChargeAmount(determineChargeAmount(tapOnEvent, tapOffEvent))
            .setCompanyId(tapOnEvent.getCompanyId())
            .setVehicleId(tapOnEvent.getVehicleId())
            .setPan(tapOnEvent.getPan())
            .setStatus(getTripStatus(tapOffEvent))
            .build();
  }
  
  public CommuterTrip from(TapEvent tapOnEvent) {
    return from(tapOnEvent, null);
  }
  
  private LocalDateTime getFinishTime(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    LocalDateTime endOfDay = LocalDateTime.of(tapOnEvent.getDateTime().toLocalDate(), LocalTime.of(23, 59));
    
    return null == tapOffEvent
            ? endOfDay
            : tapOffEvent.getDateTime();
  }
  
  private Long calculateDurationSeconds(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    Long startTimeEpochSeconds = tapOnEvent.getDateTime().toEpochSecond(ZoneOffset.UTC);
    
    if (null == tapOffEvent) {
      return 0L;
    } else {
      Long endTimeEpochSeconds = tapOffEvent.getDateTime().toEpochSecond(ZoneOffset.UTC);
      return endTimeEpochSeconds - startTimeEpochSeconds;
    }
  }
  
  private Stop getDepartureStop(TapEvent tapOffEvent) {
    return null == tapOffEvent ? Stop.NONE : tapOffEvent.getStop();
  }
  
  private Double determineChargeAmount(TapEvent tapOnEvent, TapEvent tapOffEvent) {
    return null == tapOffEvent
            ? tripChargeAmountCalculator.calculateMaxChargeAmount(tapOnEvent)
            : tripChargeAmountCalculator.calculateChargeAmount(tapOnEvent, tapOffEvent);
  }
  
  private TripStatus getTripStatus(TapEvent tapOffEvent) {
    return null == tapOffEvent ? TripStatus.INCOMPLETE : TripStatus.COMPLETED;
  }
}
