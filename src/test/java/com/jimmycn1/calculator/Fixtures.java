package com.jimmycn1.calculator;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TapType;

import java.time.LocalDateTime;

public class Fixtures {
  public static TapEvent.TapEventBuilder createTapOnEvent() {
    return new TapEvent.TapEventBuilder()
            .setId(1L)
            .setDateTime(LocalDateTime.of(2020, 11, 10, 14, 0))
            .setTabType(TapType.ON)
            .setStop(Stop.ONE)
            .setCompanyId("company1")
            .setVehicleId("vehicle1")
            .setPan("55000055555555592");
  }
  
  public static TapEvent.TapEventBuilder createTapOffEvent() {
    return new TapEvent.TapEventBuilder()
            .setId(1L)
            .setDateTime(LocalDateTime.of(2020, 11, 10, 15, 0))
            .setTabType(TapType.OFF)
            .setStop(Stop.TWO)
            .setCompanyId("company1")
            .setVehicleId("vehicle1")
            .setPan("55000055555555592");
  }
}
