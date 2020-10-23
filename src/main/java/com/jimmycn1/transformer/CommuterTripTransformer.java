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
    return new CommuterTrip(
            tapOnEvent.getDateTime(),
            getFinishTime(tapOnEvent, tapOffEvent),
            calculateDurationSeconds(tapOnEvent, tapOffEvent),
            tapOnEvent.getStop(),
            getDepartureStop(tapOffEvent),
            determineChargeAmount(tapOnEvent, tapOffEvent),
            tapOnEvent.getCompanyId(),
            tapOnEvent.getVehicleId(),
            tapOnEvent.getPan(),
            getTripStatus(tapOffEvent)
    );
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
